package com.teste.MagicFridgeAI.model.user;

import org.jetbrains.annotations.NotNull;

public record RegisterDTO(
        @NotNull String login,
        @NotNull String password,
        @NotNull UserRole role) {
}
