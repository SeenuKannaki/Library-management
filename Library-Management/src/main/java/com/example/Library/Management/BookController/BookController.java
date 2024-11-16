package com.example.Library.Management.BookController;


import com.example.Library.Management.Book.Book;
import com.example.Library.Management.BookServices.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices){
        this.bookServices = bookServices;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookServices.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional<Book> book = bookServices.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book){
        return bookServices.addBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookServices.updateBook(id, book);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookServices.deleteBook(id);
    }
}
