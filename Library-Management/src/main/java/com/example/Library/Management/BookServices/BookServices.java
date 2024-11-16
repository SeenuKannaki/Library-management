package com.example.Library.Management.BookServices;


import com.example.Library.Management.Book.Book;
import com.example.Library.Management.BookRepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    @Autowired
    public BookServices(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updateBook){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            updateBook.setId(id);
            return bookRepository.save(updateBook);
        }
        return null;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
