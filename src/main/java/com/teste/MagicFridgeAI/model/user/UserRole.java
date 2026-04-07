package com.teste.MagicFridgeAI.model.user;

public enum UserRole {
    USER("user"),
    ADMIN("admin");
    String role;
    UserRole(String role){
        this.role = role;
    }
}
