package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.UserRequestDTO;
import org.geofence.springplayground.dto.UserResponseDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> addUsers(List<UserRequestDTO> userRequestDTOs);
    UserResponseDTO updateUserById(Long id, UserRequestDTO updatedUserDTO);
    UserResponseDTO patchUserById(Long id, UserRequestDTO updatedUserDTO);
    Map<String, Object> deleteUserById(Long id);
    PageResponseDTO<UserResponseDTO> getAllUsersWithPagination(int pageNo, int pageSize, String sortBy, String sortDir);
}
