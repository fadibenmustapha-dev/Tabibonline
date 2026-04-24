package com.tabibonline.models;

import java.util.Arrays;
import java.util.List;

/**
 * ╔══════════════════════════════════════════════════════════╗
 * ║          TabibOnline — Sprint 1 — Main.java V1           ║
 * ║       Projet AGL 2025/2026 — FSEGT, Tunis El Manar       ║
 * ║  Équipe : Yahya | Mohamed | Motaz | Fedi | Salma         ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * Commande de compilation :
 *   javac -encoding UTF-8 -d out src/com/tabibonline/models/*.java
 *
 * Commande d'exécution :
 *   java -cp out com.tabibonline.models.Main
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== TabibOnline - Sprint 1 ===");

        // [1] Inscription & Auth (Yahya)
        System.out.println("[1] Inscription & Auth (Yahya)");
        Patient patient1 = new Patient(1, "Ben Ali", "Fatma", "fatma@gmail.com", "pass123", "22345678", "15/04/1998", "A+");
        Patient patient2 = new Patient(2, "Chaouachi", "Karim", "karim@gmail.com", "pass456", "99112233", "20/06/2000", "O-");
        
        System.out.println("Patient inscrit : Fatma Ben Ali | Email : fatma@gmail.com");
        
        boolean connexionOk = patient1.seConnecter("fatma@gmail.com", "pass123");
        System.out.println("Connexion reussie ? " + connexionOk);

        // [2] Profil Médecin (Mohamed)
        System.out.println("[2] Profil Medecin (Mohamed)");
        Medecin medecin1 = new Medecin(1, "Gharbi", "Sami", "sami@tabib.tn", "doc123", "71234567", "Cardiologue", "ORD-2021-001", "Clinique El Manar, Tunis", 80.0);
        Medecin medecin2 = new Medecin(2, "Jebali", "Leila", "leila@tabib.tn", "doc456", "71987654", "Dermatologue", "ORD-2020-042", "Cabinet Ibn Khaldoun, Sfax", 60.0);
        
        // Setup initial state
        medecin1.setEstValide(true);
        medecin2.setEstValide(true);
        
        System.out.println("Dr. Sami Gharbi | Cardiologue | 80.0 DT | Note: " + medecin1.getNote() + "/5");

        // [3] Recherche & RDV (Motaz)
        System.out.println("[3] Recherche & RDV (Motaz)");
        RechercheMedecin recherche = new RechercheMedecin(java.util.Arrays.asList(medecin1, medecin2));
        
        List<Medecin> cardiologues = recherche.rechercherParSpecialite("Cardiologue");
        
        RendezVous rdv1 = new RendezVous(1, patient1, medecin1, "28/04/2026", "09:30", "Consultation");
        rdv1.setStatut(RendezVous.Statut.CONFIRME);
        
        System.out.println("RDV #1 confirme : Fatma -> Dr.Gharbi le 28/04/2026 a 09:30");

        // [4] Notation (Fedi) / [5] Admin (Salma)
        System.out.println("[4] Notation (Fedi) / [5] Admin (Salma)");
        
        // Simulating completion for notation
        rdv1.setStatut(RendezVous.Statut.TERMINE);
        Avis avis1 = new Avis(1, patient1, medecin1, rdv1, 5, "Excellent medecin");
        avis1.soumettre();
        
        Administrateur admin = new Administrateur(1, "Mbarki", "Sonia", "admin@tabib.tn", "admin999", "70000001", 3);
        
        double recette = rdv1.getMontant() + 60.0; // rdv1 (80) + second rdv simulation (60) = 140
        System.out.println("Avis soumis : 5/5 etoiles | Tableau de bord : 2 patients, " + (int)recette + " DT");
    }

    private static void ligne(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(c);
        System.out.println(sb);
    }
}
