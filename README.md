# 🏥 TabibOnline — Plateforme de Prise de Rendez-Vous Médicaux en Ligne

> **Projet AGL 2025/2026 — FSEGT, Université Tunis El Manar**  
> Enseignante : Mme Fatma Karray | Avril 2026

---

## 📌 Pitch

**TabibOnline** est une plateforme web permettant aux patients tunisiens de rechercher des médecins par spécialité, consulter leurs disponibilités et prendre rendez-vous en ligne en quelques clics.

**Problème résolu :** Les patients perdent du temps à appeler les cabinets médicaux pour trouver un créneau disponible. TabibOnline centralise les disponibilités en temps réel.

**Cible :** Patients (grand public) · Médecins (toutes spécialités) · Administrateurs de la plateforme

---

## 👥 Équipe

| Membre  | Rôle Scrum         | Fonctionnalité              | Branche Git               |
|---------|--------------------|-----------------------------|---------------------------|
| Yahya   | Product Owner + Dev | Inscription & Authentification | `feature/authentification` |
| Mohamed | Scrum Master + Dev  | Profil Médecin & Disponibilités | `feature/profil-medecin` |
| Motaz   | Développeur         | Recherche & Prise de RDV    | `feature/recherche-rdv`   |
| Fedi    | Développeur         | Notation & Avis             | `feature/notation-avis`   |
| Salma   | Développeur         | Tableau de bord Admin       | `feature/admin-dashboard` |

---

## 🎨 Maquettes Figma

> **Lien Figma :** *(à compléter par l'équipe)*  
> Exports PNG disponibles dans : `docs/captures/maquettes/`

---

## 🏗️ Structure du Dépôt

```
TabibOnline/
├── README.md
├── diagrammes/
│   ├── DCU_TabibOnline.puml      ← Diagramme de Cas d'Utilisation
│   ├── DC_TabibOnline.puml       ← Diagramme de Classes
│   └── DS_PriseRDV.puml          ← Diagramme de Séquence
├── docs/
│   ├── rapport.pdf               ← Rapport final (Sprint 2)
│   └── captures/
│       ├── maquettes/            ← Exports PNG Figma
│       ├── kanban/               ← Captures tableau Kanban
│       └── reviews/              ← Captures des PR reviews
└── src/
    └── com/tabibonline/models/
        ├── Main.java             ← Point d'entrée — démo Sprint 1
        ├── Utilisateur.java      ← Classe abstraite (Yahya)
        ├── Patient.java          ← Hérite Utilisateur (Yahya)
        ├── Medecin.java          ← Hérite Utilisateur (Mohamed)
        ├── Disponibilite.java    ← Composition Médecin (Mohamed)
        ├── RendezVous.java       ← Association Patient/Médecin (Motaz)
        ├── RechercheMedecin.java ← Moteur de recherche (Motaz)
        ├── Avis.java             ← Notation post-consultation (Fedi)
        ├── Administrateur.java   ← Hérite Utilisateur (Salma)
        └── Notification.java     ← Alertes utilisateurs (Salma)
```

---

## ⚙️ Compilation & Exécution

```bash
# Depuis la racine du projet TabibOnline/

# Étape 1 — Compiler toutes les classes
javac -encoding UTF-8 -d out src/com/tabibonline/models/*.java

# Étape 2 — Exécuter le Main
java -cp out com.tabibonline.models.Main
```

### Sortie console attendue (Sprint 1)

```
══════════════════════════════════════════════════════════
       TabibOnline — Sprint 1 — Prototype V1
   Projet AGL 2025/2026 | FSEGT Tunis El Manar
══════════════════════════════════════════════════════════

┌─────────────────────────────────────────────────────┐
│  [1] Inscription & Authentification  (Yahya — PO)
└─────────────────────────────────────────────────────┘
  Patient inscrit : Fatma Ben Ali | Email : fatma@gmail.com
  Patient inscrit : Karim Chaouachi | Email : karim@gmail.com
  Connexion de Fatma réussie ? true
  Connexion avec mauvais mdp   ? false

┌─────────────────────────────────────────────────────┐
│  [2] Profil Médecin & Disponibilités  (Mohamed — SM)
└─────────────────────────────────────────────────────┘
  ...

┌─────────────────────────────────────────────────────┐
│  [3] Validation des Médecins  (Salma — Admin)
└─────────────────────────────────────────────────────┘
  ...

┌─────────────────────────────────────────────────────┐
│  [4] Recherche & Prise de Rendez-Vous  (Motaz)
└─────────────────────────────────────────────────────┘
  ...

┌─────────────────────────────────────────────────────┐
│  [5] Notation & Avis  (Fedi)
└─────────────────────────────────────────────────────┘
  ...

┌─────────────────────────────────────────────────────┐
│  [6] Tableau de Bord Administrateur  (Salma)
└─────────────────────────────────────────────────────┘
  ...
```

---

## 📊 Diagrammes UML

Les diagrammes sont disponibles dans le dossier `diagrammes/` au format `.puml` (PlantUML).

Pour les visualiser :
- **Online :** [https://www.plantuml.com/plantuml/uml/](https://www.plantuml.com/plantuml/uml/)
- **VS Code :** Extension *PlantUML* (jebbs.plantuml)
- **IntelliJ :** Plugin *PlantUML Integration*

| Diagramme | Fichier | Contenu |
|-----------|---------|---------|
| DCU | `DCU_TabibOnline.puml` | 4 acteurs, 19 cas d'utilisation |
| DC  | `DC_TabibOnline.puml`  | 10 classes, héritage, associations |
| DS  | `DS_PriseRDV.puml`     | Scénario prise de RDV complet |

---

## 🚀 Sprints

| Sprint | Incrément | Statut |
|--------|-----------|--------|
| Sprint 1 | Maquettes Figma + Java V1 (squelette exécutable) | ✅ En cours |
| Sprint 2 | Prototype V2 (logique métier complète) + Rapport final | 🔜 À venir |

---

## 📋 Règles importantes

- ✅ **IA autorisée** : GitHub Copilot, ChatGPT, Claude — prompts documentés dans le rapport
- ✅ **Java plain** : sans framework (cohérent avec les TP)
- 🚫 **Plagiat** : code copié d'un autre groupe = 0 pour les deux groupes
- 🚫 **Commits fantômes** : commits massifs la veille du rendu = pénalité

---

*Document généré — Projet TabibOnline — Sprint 1 — AGL 2025/2026*  
*Équipe : Yahya · Mohamed · Motaz · Fedi · Salma*
