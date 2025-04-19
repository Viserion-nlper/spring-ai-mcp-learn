package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByCategory(String category);
}
