package com.teste.MagicFridgeAI.controller;

import com.teste.MagicFridgeAI.model.FoodItemRequestDTO;
import com.teste.MagicFridgeAI.model.FoodItemResponseDTO;
import com.teste.MagicFridgeAI.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/food")
public class FoodItemController {
    @Autowired
    private FoodItemService service;

   //GET
    @GetMapping("/listar")
    public List<FoodItemResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/listar/{id}")
    public FoodItemResponseDTO listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }
   //POST
    @PostMapping
    public ResponseEntity<FoodItemResponseDTO> criar(@RequestBody @Valid FoodItemRequestDTO foodItem){
        var response = service.salvar(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
   //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItemResponseDTO> atualizar(@PathVariable Long id, @RequestBody FoodItemRequestDTO foodItem){
        var atualizado = service.atualizar(id, foodItem);
        return ResponseEntity.ok(atualizado);
    }
   //DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }



}
