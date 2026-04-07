package com.teste.MagicFridgeAI.repository;

import com.teste.MagicFridgeAI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodItemRepository extends JpaRepository <FoodItem, Long> {
    List<FoodItem> findByUserId(UUID user);
}
