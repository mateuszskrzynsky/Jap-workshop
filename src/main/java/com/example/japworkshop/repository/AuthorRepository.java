package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "select a from Author a join fetch a.books")
    List<Author>findAllBy();
}
