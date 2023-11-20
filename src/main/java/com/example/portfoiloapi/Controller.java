package com.example.portfoiloapi;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.portfoiloapi._core.ApiResponse;
import com.example.portfoiloapi._core.ApiResponseGenerator;
import com.example.portfoiloapi.jwt.service.CreateAccessToken;
import com.example.portfoiloapi.jwt.service.VerifyToken;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class Controller {
    private final CreateAccessToken createAccessToken;
    private final Service service;

    @PostMapping("/login")
    public ApiResponse<?> login(HttpServletResponse response, @RequestBody RequestNicknameDTO nickname){
        String jwt = createAccessToken.execute(nickname.getNickname());
        response.addHeader("Authorization",jwt);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @PostMapping("/post")
    public ApiResponse<?> post(HttpServletRequest request,@RequestBody RequestPostDTO requestPostDTO){
        String jwt = request.getHeader("Authorization");
        DecodedJWT decodedJWT = VerifyToken.execute(jwt);
        String nickname = decodedJWT.getClaim("nickname").asString();
        System.out.println(nickname);
        service.postMessage(nickname, requestPostDTO.getMessage());
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @GetMapping("/post")
    public ApiResponse<?> post(@RequestParam(value = "page", defaultValue = "0") Integer page){
        List<ResponsePostDTO> responsePostDTOs = service.findAll(page);
        return ApiResponseGenerator.success(responsePostDTOs,HttpStatus.OK);
    }
}
