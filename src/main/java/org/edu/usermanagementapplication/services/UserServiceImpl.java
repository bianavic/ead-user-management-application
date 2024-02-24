package org.edu.usermanagementapplication.services;

import lombok.RequiredArgsConstructor;
import org.edu.usermanagementapplication.entities.User;
import org.edu.usermanagementapplication.repositories.UserRepository;
import org.edu.usermanagementapplication.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User id not found: " + id);
        }
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {

        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User id not found: " + id));

            userRepository.delete(existingUser);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error deleting user: " + id);
        }

    }

    @Override
    public User update(Long id, User updatedUser) {

        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User id not found: " + id));

            existingUser.setName(updatedUser.getName());
            existingUser.setCpf(updatedUser.getCpf());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            return userRepository.save(existingUser);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error updating user: " + id);
        }
    }

}
