package com.qa.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.Character;

@Repository 
public interface CharacterRepository extends JpaRepository<Character, Integer> {
	
}