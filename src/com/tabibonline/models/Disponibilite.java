package com.tabibonline.models;

/**
 * Représente un créneau de disponibilité d'un médecin.
 * Responsable : Mohamed (Scrum Master)
 * Branche : feature/profil-medecin
 */
public class Disponibilite {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int     id;
    private String  jour;
    private String  heureDebut;
    private String  heureFin;
    private boolean estDisponible;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Disponibilite() {}

    public Disponibilite(int id, String jour, String heureDebut, String heureFin) {
        this.id           = id;
        this.jour         = jour;
        this.heureDebut   = heureDebut;
        this.heureFin     = heureFin;
        this.estDisponible = true;
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /** Marque le créneau comme réservé (indisponible). */
    public void reserver() {
        this.estDisponible = false;
    }

    /** Libère le créneau (disponible de nouveau). */
    public void liberer() {
        this.estDisponible = true;
    }

    /** Affiche le détail du créneau en console. */
    public void afficherDetails() {
        System.out.println("  Créneau : " + jour + " " + heureDebut
                + "-" + heureFin
                + " | Disponible : " + estDisponible);
    }

    @Override
    public String toString() {
        return jour + " " + heureDebut + "-" + heureFin
                + (estDisponible ? " [LIBRE]" : " [RÉSERVÉ]");
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int     getId()                          { return id; }
    public void    setId(int id)                    { this.id = id; }

    public String  getJour()                        { return jour; }
    public void    setJour(String jour)             { this.jour = jour; }

    public String  getHeureDebut()                  { return heureDebut; }
    public void    setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }

    public String  getHeureFin()                    { return heureFin; }
    public void    setHeureFin(String heureFin)     { this.heureFin = heureFin; }

    public boolean isEstDisponible()                        { return estDisponible; }
    public void    setEstDisponible(boolean estDisponible)  { this.estDisponible = estDisponible; }
}
