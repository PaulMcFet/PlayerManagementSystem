package com.qa.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.qa.data.Entity.Character;

@Repository 
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}