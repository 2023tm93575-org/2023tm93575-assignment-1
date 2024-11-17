package org.book.controller;

import org.book.model.Book;
import org.book.model.User;
import org.book.service.BookService;
import org.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; // Assuming you have a UserService to handle business logic

    @Autowired
    private BookService bookService; // Assuming you have a BookService to handle book-related logic

    // Create a new User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Add Books to a User
    @PostMapping("/{userId}/books")
    public ResponseEntity<User> addBooksToUser(@PathVariable Long userId, @RequestBody List<Book> books) {
        User updatedUser = userService.addBooksToUser(userId, books);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Update Books for a User
    @PutMapping("/{userId}/books")
    public ResponseEntity<User> updateBooksForUser(@PathVariable Long userId, @RequestBody List<Book> books) {
        User updatedUser = userService.updateBooksForUser(userId, books);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Get all books owned by a user (optional endpoint)
    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> getBooksByUser(@PathVariable Long userId) {
        List<Book> books = userService.getBooksByUser(userId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

