package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.UserRequestDTO;
import org.geofence.springplayground.dto.UserResponseDTO;
import org.geofence.springplayground.entities.User;
import org.geofence.springplayground.exceptions.UserNotFoundException;
import org.geofence.springplayground.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return toResponseDTO(findUserById(id));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = toEntity(userRequestDTO);
        return toResponseDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> addUsers(List<UserRequestDTO> userRequestDTOs) {
        List<User> users = userRequestDTOs.stream()
                .map(this::toEntity)
                .toList();

        return userRepository.saveAll(users)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO updateUserById(Long id, UserRequestDTO updatedUserDTO) {
        User user = findUserById(id);
        user.setUsername(updatedUserDTO.username());
        user.setPassword(updatedUserDTO.password());
        return toResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO patchUserById(Long id, UserRequestDTO updatedUserDTO) {
        User user = findUserById(id);
        if (updatedUserDTO.username() != null) {
            user.setUsername(updatedUserDTO.username());
        }
        if (updatedUserDTO.password() != null) {
            user.setPassword(updatedUserDTO.password());
        }
        return toResponseDTO(userRepository.save(user));
    }

    @Override
    public Map<String, Object> deleteUserById(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);

        return Map.of(
                "status", 200,
                "message", "User deleted successfully with id: " + id
        );
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getUsername());
    }

    private User toEntity(UserRequestDTO dto) {
        return new User(dto.username(), dto.password());
    }
}

