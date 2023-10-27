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

    public void addStatus(Long idUser, Long idWord, Integer qtTentativas) {
        User user = userRepository.getById(idUser);
        Word word = wordRepository.getById(idWord);

        UserStats userStats = new UserStats(qtTentativas,user,word);
        user.getStats().add(userStats);
    }


}
