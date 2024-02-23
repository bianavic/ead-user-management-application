package org.edu.usermanagementapplication.services;

import org.edu.usermanagementapplication.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User insert(User user);

    void delete(Long id);

    User update(Long id, User updatedUser);
}
