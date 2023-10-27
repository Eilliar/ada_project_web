package tech.ada.mark1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.mark1.model.Word;
import tech.ada.mark1.service.WordService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WordController {

    WordService wordService;

    public WordController(WordService wordService){
        this.wordService = wordService;
    }
    @GetMapping("/word")
    public Word getRandomWord(){
        return wordService.getRandomWord();
    }
    @GetMapping("/all")
    public List<Word> getWords(){
        return wordService.getAllWords();
    }

}
