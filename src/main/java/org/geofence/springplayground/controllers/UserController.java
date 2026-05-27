package org.geofence.springplayground.controllers;

import jakarta.validation.Valid;
import org.geofence.springplayground.dto.UserRequestDTO;
import org.geofence.springplayground.dto.UserResponseDTO;
import org.geofence.springplayground.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createUser(userRequestDTO));
    }

    @PostMapping("/addBulk")
    public ResponseEntity<List<UserResponseDTO>> addUsers(@RequestBody List<@Valid UserRequestDTO> userRequestDTOs) {
        return ResponseEntity.ok(userService.addUsers(userRequestDTOs));
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable Long id,
                                                          @Valid @RequestBody UserRequestDTO updatedUserDTO) {
        return ResponseEntity.ok(userService.updateUserById(id, updatedUserDTO));
    }

    @PatchMapping("/updateById/{id}")
    public ResponseEntity<UserResponseDTO> patchUser(@PathVariable Long id,
                                                     @RequestBody UserRequestDTO updatedUserDTO) {
        return ResponseEntity.ok(userService.patchUserById(id, updatedUserDTO));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Map<String, Object> deleteResponse = userService.deleteUserById(id);
        return ResponseEntity.ok(deleteResponse);
    }
}

