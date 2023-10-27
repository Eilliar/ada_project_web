package tech.ada.mark1.model;

public record RegisterDTO(
        String username,
        String email,
        String password,
        UserRole role
) {
}
