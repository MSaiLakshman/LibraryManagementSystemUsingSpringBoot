package com.lms.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.library_management_system.dto.BookDto;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.service.BookService;
import com.lms.library_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody BookDto bookDto) {
        //bookDto.setBorrowedTime(LocalDateTime.now());
        return bookService.saveBook(bookDto);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseStructure<Book>> findByBookId(@PathVariable int bookId) {
        return bookService.findByBookId(bookId);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<ResponseStructure<Book>> updateBook(@PathVariable int bookId, @RequestBody BookDto bookDto) {
        return bookService.updateBook(bookId, bookDto);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @PutMapping("/borrow/{bookID}/{userId}")
    public ResponseEntity<ResponseStructure<Book>> borrowBook(@PathVariable int bookID,@PathVariable int userId){
    	return bookService.borrowBook(bookID, userId);
    }
    
    @PutMapping("/return/{bookID}")
    public ResponseEntity<ResponseStructure<BookDto>> returnBook(@PathVariable int bookID) {
        return bookService.returnBook(bookID);
    }

}
