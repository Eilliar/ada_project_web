package tech.ada.mark1.service;

import org.springframework.stereotype.Service;
import tech.ada.mark1.model.User;
import tech.ada.mark1.model.UserStats;
import tech.ada.mark1.model.Word;
import tech.ada.mark1.repository.UserRepository;
import tech.ada.mark1.repository.UserStatsRepository;
import tech.ada.mark1.repository.WordRepository;

@Service
public class UserStatsService {

    private UserStatsRepository userStatsRepository;
    private UserRepository userRepository;

    private WordRepository wordRepository;

    public UserStatsService(UserStatsRepository userStatsRepository,UserRepository userRepository, WordRepository wordRepository) {
        this.userStatsRepository = userStatsRepository;
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }

    public void addStatus(Long idUser, Long idWord, Integer numAttempts) {
        User user = userRepository.getById(idUser);
        Word word = wordRepository.getById(idWord);

        UserStats userStats = new UserStats(numAttempts,user,word);
        user.getStats().add(userStats);
    }

    public List<UserStats> getHistoricScores(Long id) {
        User user = getById(id);

        return user.getStats();
    }

    public Integer getAverageScore(Long id) {
        User user = getById(id);
        double avg = user.getStats().stream().mapToInt(stats -> stats.getNumAttempts()).average().orElse(0.0);
        return (int) Math.round(avg);
    }

    private User getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        return optUser.orElseThrow(() -> new RuntimeException("User not found!"));
    }


}
