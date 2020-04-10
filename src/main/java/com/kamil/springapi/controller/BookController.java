package com.kamil.springapi.controller;

import com.kamil.springapi.model.Book;
import com.kamil.springapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping()
    public List<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping("{id}")
    public Book show(@PathVariable String id) {
        int bookId = Integer.parseInt(id);
        return bookRepository.getOne(bookId);
    }

//    @PostMapping("/books/search")
//    public List<Book> search(@RequestBody Map<String, String> body) {
//        String searchTerm = body.get("text");
//        return bookRepository.findBookByTitleContaining(searchTerm, searchTerm);
//    }

    @PostMapping()
    public Book create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("ISBN"));
        String title = body.get("title");
        double price = Double.parseDouble(body.get("price"));
        int category = Integer.parseInt(body.get("category"));
        Date published_date = Date.valueOf(body.get("published_date"));
        int quantity = Integer.parseInt(body.get("quantity"));
        return bookRepository.save(new Book(id, title, price, category, published_date, quantity));
    }

    @PutMapping("{id}")
    public Book update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int bookId = Integer.getInteger(id);
        Book book = bookRepository.getOne(bookId);
        String title = body.get("title");
        double price = Double.parseDouble(body.get("price"));
        int category = Integer.parseInt(body.get("category"));
        Date published_date = Date.valueOf(body.get("published_date"));
        int quantity = Integer.parseInt(body.get("quantity"));
        return bookRepository.save(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable String id) {
        int bookId = Integer.parseInt(id);
        bookRepository.deleteById(bookId);
        return true;
    }
}
