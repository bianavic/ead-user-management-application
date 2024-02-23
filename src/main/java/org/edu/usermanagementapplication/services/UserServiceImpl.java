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

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(String email) {

        // TODO: update null return
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            return null;
        }

        User user = new User();
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setCpf(user.getCpf());
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id not found" + id));

        userRepository.delete(existingUser);

    }

    @Override
    public User update(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id not found" + id));

        existingUser.setName(updatedUser.getName());
        existingUser.setCpf(updatedUser.getCpf());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }

}
