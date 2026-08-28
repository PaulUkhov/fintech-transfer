package org.fintechtransfer.dto;

import java.time.Instant;

import org.fintechtransfer.model.UserEntity;

public record UserDto(Long id, String email, String firstName, String lastName, String role, String status,
        Instant createdAt) {

public static UserDto from(UserEntity u) {
return new UserDto(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName(),
  u.getRole().name(), u.getStatus().name(), u.getCreatedAt());
}
}
