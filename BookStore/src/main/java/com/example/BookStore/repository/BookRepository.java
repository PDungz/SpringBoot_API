package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>  {

}
