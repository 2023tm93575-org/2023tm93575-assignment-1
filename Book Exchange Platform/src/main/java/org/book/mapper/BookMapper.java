package org.book.mapper;


import org.book.dto.BookDto;
import org.book.model.Book;

public class BookMapper {

    // Convert BookDto to Book entity
    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setCondition(bookDto.getCondition());
        book.setAvailable(bookDto.isAvailable());
        return book;
    }

    // Convert Book entity to BookDto
    public static BookDto toDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getCondition(),
                book.isAvailable()
        );
    }
}
