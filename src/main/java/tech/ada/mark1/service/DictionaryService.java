package tech.ada.mark1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DictionaryService {

    private String baseUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    public List<Object> getWordDefinition(String word){
        String baseUrl =   this.baseUrl + word;
        RestTemplate restTemplate = new RestTemplate();

        Object[] definitions = restTemplate.getForObject(baseUrl, Object[].class);
        return Arrays.asList(definitions);
    }
}
