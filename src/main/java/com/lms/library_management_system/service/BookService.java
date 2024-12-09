package com.lms.library_management_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.library_management_system.dao.BookDao;
import com.lms.library_management_system.dao.UserDao;
import com.lms.library_management_system.dto.BookDto;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.exception.NotFoundExceeption;
import com.lms.library_management_system.exception.UserIdNotFoundExceeption;
import com.lms.library_management_system.util.ResponseStructure;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<ResponseStructure<Book>> saveBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book dbBook = bookDao.saveBook(book);
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Book Saved");
        responseStructure.setData(dbBook);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Book>> findByBookId(int bookId) {
        Book dbBook = bookDao.findByBookId(bookId);
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        if (dbBook != null) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Book Found");
            responseStructure.setData(dbBook);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new UserIdNotFoundExceeption("User ID not found");
        }
    }

    public ResponseEntity<ResponseStructure<Book>> updateBook(int bookId, BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book dbBook = bookDao.updateBook(bookId, book);
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Book Updated");
        responseStructure.setData(dbBook);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteBook(int bookId) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        if (bookDao.deleteBook(bookId)) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Book Deleted Successfully");
            responseStructure.setData("Book with ID " + bookId + " was deleted.");
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
        	     throw new UserIdNotFoundExceeption("User ID not found");
            
        }
    }

    public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
        List<Book> books = bookDao.fetchAllBooks();
        ResponseStructure<List<Book>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Books Retrieved");
        responseStructure.setData(books);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
    
    public ResponseEntity<ResponseStructure<Book>> borrowBook(int bookID, int userId){
    	Book book=bookDao.findByBookId(bookID);
    	User user=userDao.findByUserId(userId);
    	System.out.println(book.getTitle());
		System.out.println(user.getName());
    	if(user!=null && book!=null && !book.isBorrowed()) {
    		book.setUser(user);
    		book.setBorrowedTime(LocalDateTime.now());
    		book.setBorrowed(true);
    		
    		BookDto bookDto=modelMapper.map(book,BookDto.class);
    		return updateBook(bookID, bookDto);
    	}
    	
    	else {
    		throw new NotFoundExceeption("Not Found Exception");
    	}
    	
    }

    public ResponseEntity<ResponseStructure<BookDto>> returnBook(int bookId) {
        Book dbBook = bookDao.findByBookId(bookId); 
        ResponseStructure<BookDto> responseStructure = new ResponseStructure<>();

        if (dbBook != null) {
            if (dbBook.getUser() != null ) {
                
                dbBook.setBorrowedTime(null);
                dbBook.setReturnTime(LocalDateTime.now());
                dbBook.setUser(null); 
                dbBook.setBorrowed(false);

                
                Book updatedBook = bookDao.saveBook(dbBook);

                
                BookDto bookDto = modelMapper.map(updatedBook, BookDto.class);
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMessage("Book Returned Successfully");
                responseStructure.setData(bookDto);
                return new ResponseEntity<>(responseStructure, HttpStatus.OK);
            } else {
                responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
                responseStructure.setMessage("User mismatch or Book is not borrowed by this user");
                responseStructure.setData(null);
                return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
            }
        } else {
        	throw new NotFoundExceeption("Not Found Exception");
        }
    }


    
    
}
