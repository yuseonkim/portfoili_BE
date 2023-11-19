package com.example.portfoiloapi;

import com.example.portfoiloapi.domain.Post;
import com.example.portfoiloapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final PostRepository postRepository;
    @Transactional
    public void postMessage(String nickname,String message){
        Post post = Post.builder()
                .nickname(nickname)
                .message(message)
                .build();
        postRepository.save(post);
    }

    public List<ResponsePostDTO> findAll(int page){
        Pageable pageable = PageRequest.of(page,6);
        Page<Post> pageContent = postRepository.findAll(pageable);
        return pageContent.getContent().stream().map(post -> new ResponsePostDTO(post)).collect(Collectors.toList());
    }
}
