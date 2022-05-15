/**
 * 
 */
package com.praroopgupta.wordgeneration.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Praroop Gupta
 *
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
    private String message;
    
}
