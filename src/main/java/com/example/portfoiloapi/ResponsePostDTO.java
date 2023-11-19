package com.example.portfoiloapi;

import com.example.portfoiloapi.domain.Post;
import lombok.Data;

@Data
public class ResponsePostDTO {
    String nickname;
    String message;

    public ResponsePostDTO(Post post){
        this.nickname = post.getNickname();
        this.message = post.getMessage();
    }
}
