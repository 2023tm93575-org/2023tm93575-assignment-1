package org.book.service;

import org.book.repository.BookRepository;
import org.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Find a book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update an existing book
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setCondition(updatedBook.getCondition());
            book.setAvailable(updatedBook.isAvailable());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Search books by title, author, or genre
    public List<Book> searchBooks(String title, String author, String genre) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContainingIgnoreCase(author);
        } else if (genre != null && !genre.isEmpty()) {
            return bookRepository.findByGenreContainingIgnoreCase(genre);
        } else {
            return bookRepository.findAll();
        }
    }
}
