package tech.ada.mark1.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ada.mark1.model.Word;
import tech.ada.mark1.repository.WordRepository;

import java.io.*;
import java.util.Optional;
import java.util.List;
import java.util.Random;

@Service
public class WordService {
    @Autowired
    private WordRepository repository;

    @Transactional
    public void uploadCSVData(String filePath) {

        clearTable();

        try (Reader reader = new FileReader(filePath);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .build()) {

            String[] line;
            while ((line = csvReader.readNext()) != null) {

                if(line[0].length() == 5){

                    Word word = new Word();
                    word.setWord(line[0]);
                    repository.save(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearTable(){
        repository.deleteAll();
    }

    public Word getById(Long id){
        Optional<Word> optWord = repository.findById(id);
        return optWord.orElseThrow(() -> new RuntimeException("Word not found!"));
    }
  
    public List<Word> getAllWords() {
        return repository.findAll();
    }
  
    public Word getRandomWord(){
        List<Word> words = getAllWords();
        if(!words.isEmpty()){
            int randomIndex = new Random().nextInt(words.size());
            return words.get(randomIndex);
        }
        return null;
    }
}


