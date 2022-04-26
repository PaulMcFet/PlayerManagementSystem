package com.qa.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.data.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	List<Inventory> findByCharacterId(int id);
}
