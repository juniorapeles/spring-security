package tech.junior.springsecurity.controller.dto;

public record LoginResponse(String accessToken, long expiresIn) {
}
