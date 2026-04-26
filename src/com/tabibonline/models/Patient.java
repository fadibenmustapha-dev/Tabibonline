package com.tabibonline.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un patient inscrit sur la plateforme TabibOnline.
 * Responsable : Yahya (Product Owner)
 * Branche : feature/authentification
 */
public class Patient extends Utilisateur {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private String             dateNaissance;
    private String             groupeSanguin;
    private List<RendezVous>   historiqueRdv;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Patient() {
        super();
        this.historiqueRdv = new ArrayList<>();
    }

    public Patient(int id, String nom, String prenom,
                   String email, String motDePasse, String telephone,
                   String dateNaissance, String groupeSanguin) {
        super(id, nom, prenom, email, motDePasse, telephone);
        this.dateNaissance = dateNaissance;
        this.groupeSanguin = groupeSanguin;
        this.historiqueRdv = new ArrayList<>();
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Inscrit le patient sur la plateforme.
     * @return true si l'inscription réussit
     */
    public boolean sInscrire() {
        System.out.println("  Patient inscrit : " + getPrenom() + " " + getNom()
                + " | Email : " + getEmail());
        return true;
    }

    /**
     * Ajoute un rendez-vous à l'historique du patient.
     */
    public void ajouterRdv(RendezVous rdv) {
        historiqueRdv.add(rdv);
    }

    /**
     * Annule un rendez-vous (au moins 24h à l'avance, logique simplifiée Sprint 1).
     */
    public void annulerRdv(RendezVous rdv) {
        rdv.annuler();
        System.out.println("  RDV annulé pour " + getPrenom() + " " + getNom());
    }

    /** Affiche le détail du patient. */
    @Override
    public void afficherDetails() {
        System.out.println("  Patient : " + getPrenom() + " " + getNom()
                + " | Email : " + getEmail()
                + " | Naissance : " + dateNaissance
                + " | Groupe sanguin : " + groupeSanguin);
    }

    @Override
    public String toString() {
        return getPrenom() + " " + getNom() + " (" + getEmail() + ")";
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public String           getDateNaissance()                      { return dateNaissance; }
    public void             setDateNaissance(String dateNaissance)  { this.dateNaissance = dateNaissance; }

    public String           getGroupeSanguin()                      { return groupeSanguin; }
    public void             setGroupeSanguin(String groupeSanguin)  { this.groupeSanguin = groupeSanguin; }

    public List<RendezVous> getHistoriqueRdv()                      { return historiqueRdv; }
    public void             setHistoriqueRdv(List<RendezVous> h)    { this.historiqueRdv = h; }
}
