package com.example.Library.Management.BookRepository;

import com.example.Library.Management.Book.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class BookRepository {

    private Map<Long, Book> bookStorage = new HashMap<>();
    private Long nextId = 1L;

    public List<Book> findAll(){
        return new ArrayList<>(bookStorage.values());
    }

    public Optional findById(Long id){
        return  Optional.ofNullable(bookStorage.get(id));
    }

    public Book save(Book book){
        if(book.getId() == null){
            book.setId(nextId++);
        }
        bookStorage.put(book.getId(), book);
        return book;
    }

    public void deleteById(Long id){
        bookStorage.remove(id);
    }


}
