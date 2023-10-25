package tech.ada.mark1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "score")
    private double score;
    @OneToOne
    private User user;

    public UserStats() {

    }
    public UserStats(Long id, User user) {
        this.id = id;
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStats userStats = (UserStats) o;
        return Objects.equals(id, userStats.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
