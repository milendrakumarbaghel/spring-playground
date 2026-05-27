package org.geofence.springplayground.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
    @NotBlank(message = "Username is required")
    String username,

    @NotBlank(message = "Password is required")
    String password
) {}

