package org.book.model;

import jakarta.persistence.*;
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
    @Column(name = "book_condition")
    private String condition;

    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

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
