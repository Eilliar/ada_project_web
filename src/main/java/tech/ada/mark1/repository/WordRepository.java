package tech.ada.mark1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.mark1.model.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
