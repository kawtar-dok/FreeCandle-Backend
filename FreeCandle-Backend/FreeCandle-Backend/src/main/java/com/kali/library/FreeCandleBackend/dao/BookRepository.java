package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByNameAndAuthor( String name,  String author);
}
