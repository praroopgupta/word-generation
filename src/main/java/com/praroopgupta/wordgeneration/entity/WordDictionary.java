/**
 * 
 */
package com.praroopgupta.wordgeneration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Praroop Gupta
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WordDictionary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String word;

	public WordDictionary(String word) {
		super();
		this.word = word;
	}
	
}
