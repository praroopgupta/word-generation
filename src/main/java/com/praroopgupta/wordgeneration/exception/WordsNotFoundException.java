/**
 * 
 */
package com.praroopgupta.wordgeneration.exception;

import org.springframework.stereotype.Component;

/**
 * @author Praroop Gupta
 *
 */
@Component
public class WordsNotFoundException extends Exception {
	
	public WordsNotFoundException() {
        super("no words found");
    }

}
