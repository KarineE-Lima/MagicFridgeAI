package com.teste.MagicFridgeAI.model;

import java.time.LocalDate;


public record FoodItemResponseDTO(Long id, String nome, String categoria, Integer quantidade, LocalDate validade) {
    public FoodItemResponseDTO(FoodItem foodItem){
        this(foodItem.getId(), foodItem.getNome(),
                foodItem.getCategoria(), foodItem.getQuantidade(),
                foodItem.getValidade());
    }
}
