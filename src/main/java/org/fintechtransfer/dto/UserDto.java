package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.UserEntity;

import java.time.Instant;

@Builder
public record UserDto(
        Long id,
        String email,
        String firstName,
        String lastName,
        String role,
        String status,
        Instant createdAt

) {
    public static UserDto from(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .role(userEntity.getRole().name())
                .status(userEntity.getStatus().name())
                .createdAt(userEntity.getCreatedAt())
                .build();
    }
}
