package com.example.portfoiloapi.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity(name = "posts")
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nickname;
    @Column(nullable = false, length = 255)
    private String message;

    @Builder
    public Post(String nickname,String message){
        this.nickname = nickname;
        this.message = message;
    }
}
