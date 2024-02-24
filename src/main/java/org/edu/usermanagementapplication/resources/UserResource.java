package org.edu.usermanagementapplication.resources;

import lombok.RequiredArgsConstructor;
import org.edu.usermanagementapplication.entities.User;
import org.edu.usermanagementapplication.services.UserService;
import org.edu.usermanagementapplication.services.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createUser = userService.insert(user);
        if (createUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createUser.getCpf())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createUser);
        }

    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(User user) {
        List<User> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getByID(@PathVariable("id") Long id) {

        User foundUser = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id not found " + id));

        return ResponseEntity.ok(foundUser);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable("id") Long id) {

        User updatedUser = userService.update(id, user);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
