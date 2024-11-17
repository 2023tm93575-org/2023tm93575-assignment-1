package org.book.service;

import org.book.model.Book;
import org.book.model.User;
import org.book.repository.BookRepository;
import org.book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // User repository for CRUD operations

    @Autowired
    private BookRepository bookRepository; // Book repository for managing books

    // Create a new User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Add Books to a User
    public User addBooksToUser(Long userId, List<Book> books) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            for (Book book : books) {
                book.setUser(user); // Set the user who owns the book
                bookRepository.save(book); // Save each book
            }
            user.getBooks().addAll(books); // Add books to the user's list
            return userRepository.save(user); // Save updated user
        }
        throw new RuntimeException("User not found with ID: " + userId);
    }

    // Update Books for a User
    public User updateBooksForUser(Long userId, List<Book> books) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.getBooks().clear(); // Clear existing books
            for (Book book : books) {
                book.setUser(user); // Set the user who owns the book
                bookRepository.save(book); // Save each book
            }
            user.getBooks().addAll(books); // Add new books to the user's list
            return userRepository.save(user); // Save updated user
        }
        throw new RuntimeException("User not found with ID: " + userId);
    }

    // Get all books owned by a user
    public List<Book> getBooksByUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get().getBooks();
        }
        throw new RuntimeException("User not found with ID: " + userId);
    }
}

