package org.edu.usermanagementapplication.repositories;

import org.edu.usermanagementapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
