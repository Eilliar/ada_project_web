package tech.ada.mark1.controller;

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
    public List<Object> getWordDefinition(@PathVariable("word") String word){

        return this.dictionaryService.getWordDefinition(word);
    }
}
