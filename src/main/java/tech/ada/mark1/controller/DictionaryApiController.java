package tech.ada.mark1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.mark1.service.DictionaryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dictionary")
public class DictionaryApiController {

    DictionaryService dictionaryService;

    public DictionaryApiController(DictionaryService dictionaryService){
        this.dictionaryService = dictionaryService;
    }

    @GetMapping(value="/{word}")
    public ResponseEntity<List<Object>> getWordDefinition(@PathVariable("word") String word){

        try {
            return new ResponseEntity<>(this.dictionaryService.getWordDefinition(word), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
