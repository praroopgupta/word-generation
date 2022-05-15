/**
 * 
 */
package com.praroopgupta.wordgeneration.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praroopgupta.wordgeneration.exception.WordsNotFoundException;
import com.praroopgupta.wordgeneration.repository.WordDictionaryRepository;

/**
 * @author Praroop Gupta
 *
 */
@Service
public class WordGenerationService {
	
	@Autowired
	private WordDictionaryRepository repository;

	public List<String> getNewWords(String word1, String word2) throws WordsNotFoundException {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(int i=1; i<=word1.length(); i++) {
			for (int j=word2.length()-1; j>=0; j--) {
				String temp = word1.substring(0, i) + word2.substring(j, word2.length());
				if(repository.existsByWord(temp)){
					set.add(temp);
				}
			}
		}
		words.addAll(set);
		if(words.size()==0) {
			throw new WordsNotFoundException();
		}
		return words;
	}

}
