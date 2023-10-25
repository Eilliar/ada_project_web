package tech.ada.mark1;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ada.mark1.service.WordService;

@SpringBootApplication
public class Mark1Application {

	@Autowired
	private WordService service;

	public static void main(String[] args) {
		SpringApplication.run(Mark1Application.class, args);
	}


	@PostConstruct
	public void onStartup() {
		String csvFilePath = "data/words_alpha.csv";
		service.uploadCSVData(csvFilePath);
	}

}
