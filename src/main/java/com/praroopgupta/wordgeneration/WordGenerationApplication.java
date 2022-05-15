package com.praroopgupta.wordgeneration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.praroopgupta.wordgeneration.entity.WordDictionary;
import com.praroopgupta.wordgeneration.repository.WordDictionaryRepository;

@SpringBootApplication
public class WordGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordGenerationApplication.class, args);
	}

	
	@SuppressWarnings("deprecation")
	@Bean
    public CommandLineRunner specificationsDemo(WordDictionaryRepository repository) {
				
        return args -> {
        	String fileName = "word_dictionary.txt";
    		List<WordDictionary> wordList = new ArrayList<>();
    		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/static", fileName))) {
    			wordList = stream.map(p -> new WordDictionary(p)).collect(Collectors.toList());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}  		
        	repository.saveAll(wordList);
        };
        
    }
	
}
