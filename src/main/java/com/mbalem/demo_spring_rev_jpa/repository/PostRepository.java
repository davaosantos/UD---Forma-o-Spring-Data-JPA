package com.mbalem.demo_spring_rev_jpa.repository;

import com.mbalem.demo_spring_rev_jpa.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
