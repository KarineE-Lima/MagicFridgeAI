package com.teste.MagicFridgeAI.service;

import com.teste.MagicFridgeAI.exceptions.FoodNotFoundException;
import com.teste.MagicFridgeAI.model.FoodItem;
import com.teste.MagicFridgeAI.model.FoodItemRequestDTO;
import com.teste.MagicFridgeAI.model.FoodItemResponseDTO;
import com.teste.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository repository;



    public FoodItemResponseDTO salvar(FoodItemRequestDTO foodItem){
        FoodItem newFood = new FoodItem();
        newFood.setNome(foodItem.nome());
        newFood.setCategoria(foodItem.categoria());
        newFood.setQuantidade(foodItem.quantidade());
        newFood.setValidade(foodItem.validade());
        FoodItem salvo = repository.save(newFood);
        return new FoodItemResponseDTO(salvo);
    }

    public List<FoodItemResponseDTO> listar(){
        List<FoodItem> foods = repository.findAll();
        return foods.stream().map(FoodItemResponseDTO::new).toList();
    }

    public FoodItemResponseDTO atualizar(Long id, FoodItemRequestDTO foodItem){
        FoodItem foodExist = repository.findById(id).orElseThrow(()->
                new FoodNotFoundException());
        foodExist.setNome(foodItem.nome());
        foodExist.setCategoria(foodItem.categoria());
        foodExist.setQuantidade(foodItem.quantidade());
        foodExist.setValidade(foodItem.validade());
        FoodItem response = repository.save(foodExist);
        return new FoodItemResponseDTO(response);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public FoodItemResponseDTO listarPorId(Long id){
        FoodItem response = repository.findById(id).orElseThrow(()->
                new FoodNotFoundException());
        return new FoodItemResponseDTO(response);
    }


}
