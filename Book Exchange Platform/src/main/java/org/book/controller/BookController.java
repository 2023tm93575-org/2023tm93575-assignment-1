package org.book.controller;

import org.book.dto.BookDto;
import org.book.mapper.BookMapper;
import org.book.model.Book;
import org.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book bookToSave = BookMapper.toEntity(bookDto);
        Book book = bookService.addBook(bookToSave);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public List<Book> getAllBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String location
    ) {
        return bookService.searchBooks(title, author, genre,location);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String location
    ) {
        List<Book> books = bookService.searchBooks(title, author, genre, location);
        return ResponseEntity.ok(books);
    }
}
