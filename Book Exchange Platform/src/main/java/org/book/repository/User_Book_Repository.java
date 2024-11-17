package org.book.repository;

import org.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_Book_Repository extends JpaRepository<Book, Long> {
    // Custom query methods
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByGenreContainingIgnoreCase(String genre);


    @Query("SELECT b FROM Book b JOIN b.user u WHERE u.location = :location")
    List<Book> findBooksByUserLocation(@Param("location") String location);

}
