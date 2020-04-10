package com.kamil.springapi.repository;

import com.kamil.springapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    //List<Book> findBookByTitleContaining(String text, String textAgain);
}
