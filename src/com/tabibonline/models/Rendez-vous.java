package com.tabibonline.models;

/**
 * Représente un rendez-vous médical entre un patient et un médecin.
 * Responsable : Motaz
 * Branche : feature/recherche-rdv
 */
public class RendezVous {

    // ─── Enum statut ──────────────────────────────────────────────────────────
    public enum Statut {
        EN_ATTENTE,
        CONFIRME,
        ANNULE,
        TERMINE
    }

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int     id;
    private Patient patient;
    private Medecin medecin;
    private String  date;
    private String  heure;
    private String  motif;
    private Statut  statut;
    private double  montant;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public RendezVous() {}

    public RendezVous(int id, Patient patient, Medecin medecin,
                      String date, String heure, String motif) {
        this.id      = id;
        this.patient = patient;
        this.medecin = medecin;
        this.date    = date;
        this.heure   = heure;
        this.motif   = motif;
        this.statut  = Statut.EN_ATTENTE;
        this.montant = medecin.getTarif();
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /** Confirme le rendez-vous (passe de EN_ATTENTE à CONFIRME). */
    public void confirmer() {
        this.statut = Statut.CONFIRME;
        System.out.println("  RDV #" + id + " confirmé : "
                + patient.getPrenom() + " " + patient.getNom()
                + " -> Dr. " + medecin.getNom()
                + " le " + date + " à " + heure
                + " | Montant : " + montant + " DT");
    }

    /** Annule le rendez-vous et libère le créneau. */
    public void annuler() {
        this.statut = Statut.ANNULE;
        System.out.println("  RDV #" + id + " annulé ("
                + patient.getPrenom() + " / Dr. " + medecin.getNom() + ")");
    }

    /** Marque le rendez-vous comme terminé (permet la notation). */
    public void terminer() {
        this.statut = Statut.TERMINE;
        System.out.println("  RDV #" + id + " terminé — notation possible.");
    }

    /** Affiche le détail complet du rendez-vous. */
    public void afficherDetails() {
        System.out.println("  RDV #" + id
                + " | Patient : " + patient.getPrenom() + " " + patient.getNom()
                + " | Médecin : Dr. " + medecin.getNom()
                + " | " + date + " à " + heure
                + " | Motif : " + motif
                + " | Statut : " + statut
                + " | " + montant + " DT");
    }

    @Override
    public String toString() {
        return "RDV #" + id + " — " + patient.getPrenom()
                + " / Dr. " + medecin.getNom()
                + " — " + date + " " + heure
                + " [" + statut + "]";
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int     getId()                  { return id; }
    public void    setId(int id)            { this.id = id; }

    public Patient getPatient()             { return patient; }
    public void    setPatient(Patient p)    { this.patient = p; }

    public Medecin getMedecin()             { return medecin; }
    public void    setMedecin(Medecin m)    { this.medecin = m; }

    public String  getDate()                { return date; }
    public void    setDate(String date)     { this.date = date; }

    public String  getHeure()               { return heure; }
    public void    setHeure(String heure)   { this.heure = heure; }

    public String  getMotif()               { return motif; }
    public void    setMotif(String motif)   { this.motif = motif; }

    public Statut  getStatut()              { return statut; }
    public void    setStatut(Statut s)      { this.statut = s; }

    public double  getMontant()             { return montant; }
    public void    setMontant(double m)     { this.montant = m; }
}
