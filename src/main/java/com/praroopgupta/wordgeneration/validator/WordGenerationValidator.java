/**
 * 
 */
package com.praroopgupta.wordgeneration.validator;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author Praroop Gupta
 *
 */
@Component
public class WordGenerationValidator {

	public void validate(String word1, String word2) {
		if(StringUtils.isBlank(word1) || StringUtils.isBlank(word2)) {
			throw new IllegalArgumentException();
		}		
	}

}
