package com.tabibonline.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Moteur de recherche de médecins par spécialité ou tarif.
 * Responsable : Motaz
 * Branche : feature/recherche-rdv
 */
public class RechercheMedecin {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private List<Medecin> listeMedecins;
    private String        critereSpecialite;
    private double        tarifMax;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public RechercheMedecin() {
        this.listeMedecins = new ArrayList<>();
    }

    public RechercheMedecin(List<Medecin> listeMedecins) {
        this.listeMedecins = new ArrayList<>(listeMedecins);
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Recherche les médecins validés par spécialité (insensible à la casse).
     * @return liste des médecins correspondants
     */
    public List<Medecin> rechercherParSpecialite(String specialite) {
        this.critereSpecialite = specialite;
        List<Medecin> resultats = new ArrayList<>();
        for (Medecin m : listeMedecins) {
            if (m.getSpecialite().equalsIgnoreCase(specialite) && m.isEstValide()) {
                resultats.add(m);
            }
        }
        System.out.println("  Recherche '" + specialite + "' : "
                + resultats.size() + " médecin(s) trouvé(s).");
        return resultats;
    }

    /**
     * Filtre les médecins validés dont le tarif est ≤ tarifMax.
     * @return liste filtrée
     */
    public List<Medecin> rechercherParTarifMax(double tarifMax) {
        this.tarifMax = tarifMax;
        List<Medecin> resultats = new ArrayList<>();
        for (Medecin m : listeMedecins) {
            if (m.getTarif() <= tarifMax && m.isEstValide()) {
                resultats.add(m);
            }
        }
        System.out.println("  Filtre tarif <= " + tarifMax + " DT : "
                + resultats.size() + " médecin(s) trouvé(s).");
        return resultats;
    }

    /** Affiche les médecins d'une liste de résultats. */
    public void afficherResultats(List<Medecin> resultats) {
        for (Medecin m : resultats) {
            System.out.println("    -> Dr. " + m.getPrenom() + " " + m.getNom()
                    + " | " + m.getSpecialite()
                    + " | " + m.getTarif() + " DT"
                    + " | Note : " + m.getNote() + "/5"
                    + " | Cabinet : " + m.getCabinet());
        }
    }

    /** Ajoute un médecin à la liste de recherche. */
    public void ajouterMedecin(Medecin m) {
        listeMedecins.add(m);
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public List<Medecin> getListeMedecins()                         { return listeMedecins; }
    public void          setListeMedecins(List<Medecin> l)          { this.listeMedecins = l; }

    public String        getCritereSpecialite()                     { return critereSpecialite; }
    public void          setCritereSpecialite(String c)             { this.critereSpecialite = c; }

    public double        getTarifMax()                              { return tarifMax; }
    public void          setTarifMax(double tarifMax)               { this.tarifMax = tarifMax; }
}
