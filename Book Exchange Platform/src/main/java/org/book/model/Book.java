package org.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private String condition;
    private boolean available;

    // Constructors
    public Book() {
    }

    public Book(String title, String author, String genre, String condition, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.condition = condition;
        this.available = available;
    }

}
