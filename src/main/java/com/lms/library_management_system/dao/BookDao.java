package com.lms.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.repository.AddressRepository;
import com.lms.library_management_system.repository.BookRepository;

@Repository
public class BookDao {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public Book updateBook(int bookId, Book book) {
        Optional<Book> findById = bookRepository.findById(bookId);
        if (findById.isPresent()) {
        	Book existingBook = findById.get();
        book.setBookId(book.getBookId());
            return bookRepository.save(existingBook);
        }
        return findById.get();
    }

 
    public Book findByBookId(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }
    
    public boolean deleteBook(int bookId) {
        Optional<Book> optional = bookRepository.findById(bookId);
        if (optional.isPresent()) {
            bookRepository.delete(optional.get()); 
            return true; 
        }
        return false; 
    }
    
    

    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }
}
