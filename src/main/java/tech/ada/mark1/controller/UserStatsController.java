package tech.ada.mark1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.mark1.model.UserStats;
import tech.ada.mark1.service.UserStatsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userstats")
public class UserStatsController {

    private UserStatsService userStatsService;

    public UserStatsController(UserStatsService userStatsService) {
        this.userStatsService = userStatsService;
    }

    @PutMapping("/result")
    public ResponseEntity<Void> addStatus(@RequestParam("idUser") Long idUser,
                                          @RequestParam("idWord") Long idWord,
                                          @RequestParam("numAttempts") Integer numAttempts) {
        try{
            userStatsService.addStatus(idUser, idWord, numAttempts);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch  (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserStats>> getHistoricScores(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(userStatsService.getHistoricScores(id),HttpStatus.OK);
        } catch  (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avg/{id}")
    public ResponseEntity<Integer> getAvgScore(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(userStatsService.getAverageScore(id), HttpStatus.OK);
        } catch  (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
