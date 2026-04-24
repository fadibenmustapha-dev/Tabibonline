package com.tabibonline.models;

import java.util.List;

/**
 * Représente l'administrateur de la plateforme TabibOnline.
 * Responsable : Salma
 * Branche : feature/admin-dashboard
 */
public class Administrateur extends Utilisateur {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int niveauAcces;   // 1 = lecture, 2 = modération, 3 = super-admin
    private int nbActions;     // compteur d'actions effectuées

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Administrateur() {
        super();
        this.niveauAcces = 1;
        this.nbActions   = 0;
    }

    public Administrateur(int id, String nom, String prenom,
                          String email, String motDePasse,
                          String telephone, int niveauAcces) {
        super(id, nom, prenom, email, motDePasse, telephone);
        this.niveauAcces = niveauAcces;
        this.nbActions   = 0;
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Valide l'inscription d'un médecin sur la plateforme.
     * Active son compte et le rend visible aux patients.
     */
    public void validerMedecin(Medecin medecin) {
        medecin.setEstValide(true);
        medecin.setEstActif(true);
        nbActions++;
        System.out.println("  ✔ Médecin validé : Dr. " + medecin.getPrenom()
                + " " + medecin.getNom()
                + " (" + medecin.getSpecialite() + ")");
    }

    /**
     * Rejette l'inscription d'un médecin et désactive son compte.
     */
    public void rejeterMedecin(Medecin medecin) {
        medecin.setEstValide(false);
        medecin.setEstActif(false);
        nbActions++;
        System.out.println("  ✘ Médecin rejeté : Dr. " + medecin.getPrenom()
                + " " + medecin.getNom());
    }

    /**
     * Affiche le tableau de bord avec les statistiques de la plateforme.
     */
    public void afficherTableauDeBord(List<Patient> patients,
                                      List<Medecin> medecins,
                                      List<RendezVous> rdvs) {
        double recette = 0.0;
        for (RendezVous rdv : rdvs) {
            recette += rdv.getMontant();
        }
        System.out.println("  Patients inscrits  : " + patients.size());
        System.out.println("  Médecins validés   : " + medecins.size());
        System.out.println("  RDV enregistrés    : " + rdvs.size());
        System.out.println("  Recette totale     : " + recette + " DT");
        System.out.println("  Actions admin      : " + nbActions);
    }

    @Override
    public void afficherDetails() {
        System.out.println("  Admin : " + getPrenom() + " " + getNom()
                + " | Niveau d'accès : " + niveauAcces
                + " | Actions effectuées : " + nbActions);
    }

    @Override
    public String toString() {
        return "Admin " + getPrenom() + " " + getNom()
                + " (niveau " + niveauAcces + ")";
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int  getNiveauAcces()                    { return niveauAcces; }
    public void setNiveauAcces(int niveauAcces)     { this.niveauAcces = niveauAcces; }

    public int  getNbActions()                      { return nbActions; }
    public void setNbActions(int nbActions)         { this.nbActions = nbActions; }
}
