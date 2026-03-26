package com.teste.MagicFridgeAI.controller;

import com.teste.MagicFridgeAI.model.FoodItemResponseDTO;
import com.teste.MagicFridgeAI.service.FoodItemService;
import com.teste.MagicFridgeAI.service.ReceitaIAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ia")
public class ReceitaIAController {
    @Autowired
    private ReceitaIAService service;
    @Autowired
    private FoodItemService foodItemService;
    @GetMapping("/pergunta")
    public String resposta(){
        var listaDeAlimentos = foodItemService.listar();
        String ingredientes = listaDeAlimentos.stream().map(FoodItemResponseDTO::nome).collect(Collectors.joining(","));
        return service.criarReceita(ingredientes);
    }

}
