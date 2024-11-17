package org.book.repository;

import org.book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    // Custom query to find users by location
    List<User> findByLocation(String location);
}
