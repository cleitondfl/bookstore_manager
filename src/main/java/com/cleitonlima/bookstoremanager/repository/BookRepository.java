package com.cleitonlima.bookstoremanager.repository;

import com.cleitonlima.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long>{
}
