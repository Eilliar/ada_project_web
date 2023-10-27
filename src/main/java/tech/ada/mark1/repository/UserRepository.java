package tech.ada.mark1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import tech.ada.mark1.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);

    Optional<User> findUserByEmail(String email);

}
