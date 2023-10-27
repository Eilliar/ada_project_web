package tech.ada.mark1.dto;

import tech.ada.mark1.model.UserRole;

public record RegisterDTO(

        String username,
        String email,
        String password,
        UserRole role

) {
}
