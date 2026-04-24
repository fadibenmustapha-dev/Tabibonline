# 📝 Compte-Rendu : Sprint 1 Review & Rétrospective
**Projet :** TabibOnline  
**Équipe :** Yahya, Mohamed, Motaz, Fedi, Salma  
**Date :** 23 Avril 2026

---

## 🏁 1. Sprint 1 Review
*Animé par le Product Owner (Yahya)*

### 🎯 Objectif du Sprint
Concevoir l'expérience utilisateur (maquettes Figma) et produire l'architecture Java exécutable (Main.java V1).

### ✅ État des User Stories (Definition of Done)
| ID | User Story | État | Note |
|---|---|---|---|
| US01 | Inscription patient | **Terminé** | Logique de base intégrée. |
| US02 | Connexion patient | **Terminé** | Authentification email/mdp fonctionnelle. |
| US03 | Profil médecin | **Terminé** | Classe Medecin.java avec tous les attributs. |
| US05 | Recherche médecin | **Terminé** | Recherche par spécialité opérationnelle. |
| US07 | Notation médecin | **Terminé** | Validation (RDV terminé) en place. |
| US09 | Validation admin | **Terminé** | Méthodes de validation par l'administrateur. |
| US04 | Disponibilités | *Incomplet* | Reporté au Sprint 2 pour la logique métier complexe. |
| US06 | Prise de RDV | *Incomplet* | Logique simplifiée (squelette fait), métier en Sprint 2. |

### 📈 Résultats de la Démo
- Le `Main.java` compile et s'exécute avec succès.
- Les classes interagissent correctement (Héritage Utilisateur, Association Patient-RDV-Medecin).
- L'affichage console correspond exactement aux attentes du cahier des charges.

---

## 🔄 2. Rétrospective Sprint 1
*Animé par le Scrum Master (Mohamed)*

### ✅ Ce qui a bien fonctionné
1. **Toolchain DevOps** : L'utilisation de GitHub avec des branches par fonctionnalité a permis une intégration fluide.
2. **Approche Hybride** : La génération du squelette AGL assistée par IA a permis de gagner 50% du temps sur le codage répétitif (getters/setters).
3. **Modélisation** : Les diagrammes PlantUML ont servi de référence claire pour tous les membres.

### ❌ Ce qui doit être amélioré
1. **Communication** : Plus de discussions nécessaires sur les noms des méthodes pour éviter les conflits au moment du merge.
2. **Gestion du temps** : Certains membres ont fini très tôt, d'autres ont eu des difficultés avec la logique d'héritage.

### 🔧 Actions concrètes pour le Sprint 2
- **Pair Programming** : Yahya (PO) aidera Mohamed sur la logique complexe des disponibilités.
- **Revues de Code** : Obligation de faire au moins 2 commentaires constructifs par Pull Request.
- **Début anticipé** : Commencer le rapport final (L7) dès le milieu du Sprint 2.

---
*Document validé par l'équipe TabibOnline.*
