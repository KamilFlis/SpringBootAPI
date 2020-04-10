package com.kamil.springapi.controller;

import com.kamil.springapi.model.Author;
import com.kamil.springapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping()
    public List<Author> index() {
        return authorRepository.findAll();
    }

    @GetMapping("{id}")
    public Author show(@PathVariable String id) {
        int authorId = Integer.parseInt(id);
        return authorRepository.getOne(authorId);
    }

    @PostMapping()
    public Author create(@RequestBody Map<String, String> body) {
        int author_id = Integer.parseInt(body.get("author_id"));
        String author_first_name = body.get("author_first_name");
        String author_last_name = body.get("author_last_name");
        return authorRepository.saveAndFlush(new Author(author_id, author_first_name, author_last_name));
    }

    @PutMapping("{id}")
    public Author update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int author_id = Integer.getInteger(id);
        Author author = authorRepository.getOne(author_id);
        String author_first_name = body.get("author_first_name");
        String author_last_name = body.get("author_last_name");
        return authorRepository.save(author);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable String id) {
        int bookId = Integer.parseInt(id);
        authorRepository.deleteById(bookId);
        return true;
    }
}
