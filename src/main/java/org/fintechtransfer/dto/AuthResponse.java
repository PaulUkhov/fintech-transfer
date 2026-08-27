package org.fintechtransfer.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresInSeconds,
        String refreshToken,
        UserDto user

) {

    public static AuthResponse of(String accessToken, long expiresInSeconds, String refreshToken, UserDto userDto) {
        return AuthResponse.builder()
                .accessToken(accessToken)
                .expiresInSeconds(expiresInSeconds)
                .refreshToken(refreshToken)
                .user(userDto)
                .build();
    }
}
