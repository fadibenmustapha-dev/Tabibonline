package com.tabibonline.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un médecin inscrit et validé sur la plateforme TabibOnline.
 * Responsable : Mohamed (Scrum Master)
 * Branche : feature/profil-medecin
 */
public class Medecin extends Utilisateur {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private String              specialite;
    private String              numeroOrdre;
    private String              cabinet;
    private double              tarif;
    private double              note;
    private boolean             estValide;
    private List<Disponibilite> disponibilites;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Medecin() {
        super();
        this.disponibilites = new ArrayList<>();
        this.note           = 0.0;
        this.estValide      = false;
    }

    public Medecin(int id, String nom, String prenom,
                   String email, String motDePasse, String telephone,
                   String specialite, String numeroOrdre,
                   String cabinet, double tarif) {
        super(id, nom, prenom, email, motDePasse, telephone);
        this.specialite     = specialite;
        this.numeroOrdre    = numeroOrdre;
        this.cabinet        = cabinet;
        this.tarif          = tarif;
        this.note           = 0.0;
        this.estValide      = false;
        this.disponibilites = new ArrayList<>();
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Ajoute un créneau de disponibilité au planning du médecin.
     */
    public void ajouterDisponibilite(Disponibilite d) {
        disponibilites.add(d);
        System.out.println("  Créneau ajouté : " + d.getJour()
                + " " + d.getHeureDebut() + " — " + d.getHeureFin());
    }

    /**
     * Supprime un créneau non encore réservé.
     */
    public boolean supprimerDisponibilite(Disponibilite d) {
        if (d.isEstDisponible()) {
            disponibilites.remove(d);
            System.out.println("  Créneau supprimé : " + d);
            return true;
        }
        System.out.println("  Impossible : créneau déjà réservé.");
        return false;
    }

    /**
     * Retourne uniquement les créneaux encore libres.
     */
    public List<Disponibilite> getDisponibilitesLibres() {
        List<Disponibilite> libres = new ArrayList<>();
        for (Disponibilite d : disponibilites) {
            if (d.isEstDisponible()) libres.add(d);
        }
        return libres;
    }

    /**
     * Met à jour la note moyenne du médecin après un nouvel avis.
     */
    public void mettreAJourNote(double nouvelleNote) {
        if (this.note == 0.0) {
            this.note = nouvelleNote;
        } else {
            this.note = (this.note + nouvelleNote) / 2.0;
        }
    }

    /** Affiche le profil complet du médecin. */
    public void afficherProfil() {
        System.out.println("  Dr. " + getPrenom() + " " + getNom()
                + " | " + specialite
                + " | " + tarif + " DT"
                + " | Note : " + note + "/5"
                + " | Cabinet : " + cabinet
                + " | Validé : " + estValide);
    }

    @Override
    public void afficherDetails() {
        afficherProfil();
    }

    @Override
    public String toString() {
        return "Dr. " + getPrenom() + " " + getNom()
                + " | " + specialite + " | " + tarif + " DT";
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public String              getSpecialite()                          { return specialite; }
    public void                setSpecialite(String specialite)         { this.specialite = specialite; }

    public String              getNumeroOrdre()                         { return numeroOrdre; }
    public void                setNumeroOrdre(String numeroOrdre)       { this.numeroOrdre = numeroOrdre; }

    public String              getCabinet()                             { return cabinet; }
    public void                setCabinet(String cabinet)               { this.cabinet = cabinet; }

    public double              getTarif()                               { return tarif; }
    public void                setTarif(double tarif)                   { this.tarif = tarif; }

    public double              getNote()                                { return note; }
    public void                setNote(double note)                     { this.note = note; }

    public boolean             isEstValide()                            { return estValide; }
    public void                setEstValide(boolean estValide)          { this.estValide = estValide; }

    public List<Disponibilite> getDisponibilites()                      { return disponibilites; }
    public void                setDisponibilites(List<Disponibilite> d) { this.disponibilites = d; }
}
