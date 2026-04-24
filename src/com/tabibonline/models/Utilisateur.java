package com.tabibonline.models;

/**
 * Classe abstraite Utilisateur — superclasse de Patient, Medecin, Administrateur
 * Responsable : Yahya (Product Owner)
 * Branche : feature/authentification
 */
public abstract class Utilisateur {

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int    id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private boolean estActif;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Utilisateur() {}

    public Utilisateur(int id, String nom, String prenom,
                       String email, String motDePasse, String telephone) {
        this.id         = id;
        this.nom        = nom;
        this.prenom     = prenom;
        this.email      = email;
        this.motDePasse = motDePasse;
        this.telephone  = telephone;
        this.estActif   = true;
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /**
     * Vérifie les identifiants de connexion.
     * @return true si email et mot de passe correspondent
     */
    public boolean seConnecter(String email, String motDePasse) {
        return this.email.equals(email) && this.motDePasse.equals(motDePasse);
    }

    /** Affiche les informations de l'utilisateur en console. */
    public void afficherDetails() {
        System.out.println("Utilisateur : " + prenom + " " + nom
                + " | Email : " + email
                + " | Actif : " + estActif);
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + email + ")";
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int     getId()          { return id; }
    public void    setId(int id)    { this.id = id; }

    public String  getNom()                 { return nom; }
    public void    setNom(String nom)       { this.nom = nom; }

    public String  getPrenom()              { return prenom; }
    public void    setPrenom(String prenom) { this.prenom = prenom; }

    public String  getEmail()               { return email; }
    public void    setEmail(String email)   { this.email = email; }

    public String  getMotDePasse()                      { return motDePasse; }
    public void    setMotDePasse(String motDePasse)     { this.motDePasse = motDePasse; }

    public String  getTelephone()                       { return telephone; }
    public void    setTelephone(String telephone)       { this.telephone = telephone; }

    public boolean isEstActif()                         { return estActif; }
    public void    setEstActif(boolean estActif)        { this.estActif = estActif; }
}
