package com.tabibonline.models;

import java.time.LocalDate;

/**
 * Représente une notification envoyée à un utilisateur.
 * Responsable : Salma
 * Branche : feature/admin-dashboard
 */
public class Notification {

    // ─── Enum type de notification ────────────────────────────────────────────
    public enum TypeNotification {
        CONFIRMATION_RDV,
        ANNULATION_RDV,
        VALIDATION_MEDECIN,
        ALERTE
    }

    // ─── Attributs privés ─────────────────────────────────────────────────────
    private int              id;
    private String           message;
    private TypeNotification type;
    private boolean          estLue;
    private Utilisateur      destinataire;
    private String           dateEnvoi;

    // ─── Constructeurs ────────────────────────────────────────────────────────
    public Notification() {}

    public Notification(int id, String message,
                        TypeNotification type, Utilisateur destinataire) {
        this.id           = id;
        this.message      = message;
        this.type         = type;
        this.destinataire = destinataire;
        this.estLue       = false;
        this.dateEnvoi    = LocalDate.now().toString();
    }

    // ─── Méthodes métier ──────────────────────────────────────────────────────
    /** Envoie la notification (affichage console). */
    public void envoyer() {
        System.out.println("  [NOTIF -> " + destinataire.getPrenom()
                + " " + destinataire.getNom() + "] "
                + type + " : " + message);
    }

    /** Marque la notification comme lue. */
    public void marquerCommeLue() {
        this.estLue = true;
    }

    /** Affiche le détail de la notification. */
    public void afficherDetails() {
        System.out.println("Notification #" + id
                + " | " + type
                + " | " + message
                + " | Lue : " + estLue
                + " | Date : " + dateEnvoi);
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }

    // ─── Getters / Setters ────────────────────────────────────────────────────
    public int              getId()                           { return id; }
    public void             setId(int id)                     { this.id = id; }

    public String           getMessage()                      { return message; }
    public void             setMessage(String message)        { this.message = message; }

    public TypeNotification getType()                         { return type; }
    public void             setType(TypeNotification type)    { this.type = type; }

    public boolean          isEstLue()                        { return estLue; }
    public void             setEstLue(boolean estLue)         { this.estLue = estLue; }

    public Utilisateur      getDestinataire()                 { return destinataire; }
    public void             setDestinataire(Utilisateur d)    { this.destinataire = d; }

    public String           getDateEnvoi()                    { return dateEnvoi; }
    public void             setDateEnvoi(String dateEnvoi)    { this.dateEnvoi = dateEnvoi; }
}
