/**
 * 
 */
package com.praroopgupta.wordgeneration.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.praroopgupta.wordgeneration.exception.WordsNotFoundException;
import com.praroopgupta.wordgeneration.model.WordGenerationResponse;
import com.praroopgupta.wordgeneration.service.WordGenerationService;
import com.praroopgupta.wordgeneration.validator.WordGenerationValidator;

/**
 * @author Praroop Gupta
 *
 */
@RestController
public class WordGenerationController {
	
	@Autowired
	private WordGenerationService service;
	
	@Autowired
	private WordGenerationValidator validator;
	
	@GetMapping("/api/{word1}/{word2}")
	public ResponseEntity<WordGenerationResponse> getNewWords(@PathVariable("word1") String word1, @PathVariable("word2") String word2) throws Exception, WordsNotFoundException {	
		validator.validate(word1, word2);
		WordGenerationResponse response = new WordGenerationResponse();
		List<String> words =  service.getNewWords(word1, word2);
		response.setWords(words);
		return new ResponseEntity<WordGenerationResponse>(response, HttpStatus.NOT_FOUND);
	}

}
