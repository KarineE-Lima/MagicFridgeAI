package com.teste.MagicFridgeAI.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public record FoodItemRequestDTO(
        @NotBlank String nome,
        @NotBlank String categoria,
        @NotNull @PositiveOrZero Integer quantidade,
        @FutureOrPresent @NotNull LocalDate validade
        ) { }
