package com.tabibonline.models;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TabibOnline - Sprint 1 ===");
        System.out.println("Actuellement, nous avons les classes Main et Utilisateur.");
        
        Utilisateur user = new Utilisateur(1, "Doe", "John", "john.doe@example.com", "password", "12345678");
        user.afficherDetails();
    }
}
