package tech.ada.mark1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    // Other fields

    // Getters and setters

    public void setWord(String word) {
        this.word = word;
    }
}
