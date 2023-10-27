package tech.ada.mark1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.mark1.service.UserStatsService;

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
                                          @RequestParam("qtTent") Integer qtTentativas) {
        try{
            userStatsService.addStatus(idUser, idWord, qtTentativas);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch  (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
