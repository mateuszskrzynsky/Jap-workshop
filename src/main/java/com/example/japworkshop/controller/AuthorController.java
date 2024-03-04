package com.example.japworkshop.controller;

import com.example.japworkshop.model.entity.Author;
import com.example.japworkshop.repository.AuthorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteBooksById() {
        Optional<Author> byId = authorRepository.findById(1L);
        byId.ifPresent(author -> author.getBooks().clear());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Void> findAll(){
        List<Author> authors = authorRepository.findAll();

        System.out.println("*******************************");

        authors.stream()
                .map(author -> author.getBooks())
                .forEach(books -> System.out.println(books));

        return ResponseEntity.ok().build();
    }
}
