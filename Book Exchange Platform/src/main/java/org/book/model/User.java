package org.book.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.book.model.Book;

import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String location;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    public User() {
    }
}