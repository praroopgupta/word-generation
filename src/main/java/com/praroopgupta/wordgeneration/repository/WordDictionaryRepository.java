/**
 * 
 */
package com.praroopgupta.wordgeneration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praroopgupta.wordgeneration.entity.WordDictionary;

/**
 * @author Praroop Gupta
 *
 */
@Repository
public interface WordDictionaryRepository extends JpaRepository<WordDictionary, Long> {

	boolean existsByWord(String word);

}
