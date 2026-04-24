package com.tabibonline.models;

import java.time.LocalDate;

/**
 * Représente un avis laissé par un patient après un rendez-vous terminé.
 * Responsable : Fedi
 * Branche : feature/notation-avis
 */
public class Avis {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int        id;
    private Patient    patient;
    private Medecin    medecin;
    private RendezVous rendezVous;
    private int        note;          // 1 à 5 étoiles
    private String     commentaire;
    private String     dateAvis;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Avis() {}

    public Avis(int id, Patient patient, Medecin medecin,
                RendezVous rendezVous, int note, String commentaire) {
        this.id          = id;
        this.patient     = patient;
        this.medecin     = medecin;
        this.rendezVous  = rendezVous;
        this.note        = note;
        this.commentaire = commentaire;
        this.dateAvis    = LocalDate.now().toString();
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Soumet l'avis après vérification des conditions :
     *  - le RDV doit être au statut TERMINE
     *  - la note doit être entre 1 et 5
     * @return true si l'avis est soumis avec succès
     */
    public boolean soumettre() {
        if (rendezVous.getStatut() != RendezVous.Statut.TERMINE) {
            System.out.println("  [ERREUR] Vous ne pouvez noter qu'après un RDV terminé.");
            return false;
        }
        if (note < 1 || note > 5) {
            System.out.println("  [ERREUR] La note doit être entre 1 et 5 étoiles.");
            return false;
        }
        medecin.mettreAJourNote(note);
        System.out.println("  Avis soumis : " + note + "/5 étoiles"
                + " | \"" + commentaire + "\""
                + " | Médecin : Dr. " + medecin.getNom()
                + " | Par : " + patient.getPrenom());
        return true;
    }

    /** Affiche le détail de l'avis. */
    public void afficherDetails() {
        System.out.println("  Avis #" + id
                + " | " + patient.getPrenom() + " " + patient.getNom()
                + " | " + note + "/5 ★"
                + " | \"" + commentaire + "\""
                + " | " + dateAvis);
    }

    @Override
    public String toString() {
        return patient.getPrenom() + " : " + note + "/5 — " + commentaire;
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int        getId()                           { return id; }
    public void       setId(int id)                     { this.id = id; }

    public Patient    getPatient()                      { return patient; }
    public void       setPatient(Patient patient)       { this.patient = patient; }

    public Medecin    getMedecin()                      { return medecin; }
    public void       setMedecin(Medecin medecin)       { this.medecin = medecin; }

    public RendezVous getRendezVous()                   { return rendezVous; }
    public void       setRendezVous(RendezVous rdv)     { this.rendezVous = rdv; }

    public int        getNote()                         { return note; }
    public void       setNote(int note)                 { this.note = note; }

    public String     getCommentaire()                  { return commentaire; }
    public void       setCommentaire(String c)          { this.commentaire = c; }

    public String     getDateAvis()                     { return dateAvis; }
    public void       setDateAvis(String dateAvis)      { this.dateAvis = dateAvis; }
}
