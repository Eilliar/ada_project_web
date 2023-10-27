package tech.ada.mark1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.mark1.model.UserStats;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats,Long> {
}
