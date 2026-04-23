# 🏥 TabibOnline — Plateforme de Prise de Rendez-Vous Médicaux en Ligne

Ce dépôt contient l'état actuel du projet TabibOnline. Nous avons simplifié le projet pour ne conserver que les bases.

## 🏗️ Structure Actuelle du Dépôt

Nous avons actuellement uniquement les fichiers suivants :

```
TabibOnline/
├── README.md
└── src/
    └── com/tabibonline/models/
        ├── Main.java             ← Point d'entrée
        └── Utilisateur.java      ← Classe métier concrète
```

## ⚙️ Compilation & Exécution

```bash
# Depuis la racine du projet TabibOnline/
javac -encoding UTF-8 -d out src/com/tabibonline/models/*.java
java -cp out com.tabibonline.models.Main
```

### Sortie console attendue

```
=== TabibOnline - Sprint 1 ===
Actuellement, nous avons les classes Main et Utilisateur.
Utilisateur : John Doe | Email : john.doe@example.com | Actif : true
```
