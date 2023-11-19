package com.example.portfoiloapi.repository;

import com.example.portfoiloapi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
