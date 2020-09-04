# ENTREVOISINS



Entrevoisins est une application qui permet à des personnes d"un même quartier de se rendre des petits services: garde d'animaux, petit bricolage, troc d'objets, cours particuliers, et tant d'autres options.

# Nouvelles Fonctionnalités !

  - Accès au profil détaillé de chaque utilisateur: 
     - photo de profil (au format 1/3 d'écran)
     - lieu
     - téléphone mobile
     - profil Facebook
     - descriptif personnel
  - Ajout de vos voisins à une liste de favoris (accessible via la barre d'onglets).


Vous pouvez également et à tout moment:
  - Ajouter un voisin (en cliquant sur le bouton d'ajout)
  - Sélectionner/Déselectionner un voisin comme favori (en cliquant sur l'icon favoris)
  - Supprimer un voisin  (en cliquant sur la poubelle rose)

### Prérequis

Le projet est développé en language JAVA sur l'environnement de développement Android Studio.

Le code de l'application est disponible sur GitHub: https://github.com/Michael75008/Projet-3.git


### Installation

L'environnement de développement Android Studio est conseillé pour la prise en main du projet, le logiciel est téléchargeable gratuitement: https://developer.android.com/studio

Une fois l'installation terminée, vous pourrez importer le projet via le lien Git mais également avoir accès à l'historique du projet dans son intégralité.

Il est conseillé de déposer tout travail ultérieur sur l'application en ligne afin qu'il soit sauvegardé et accessible au futurs codeurs en charge d'un nouveau projet.

A des fins d'execution des tests instrumentalisés, un périphérique Android spécifique sera nécessaire. Vous pourrez utiliser un émulateur Android (AVD, Android Virtual Device) en tant que plate-forme cible pour exécuter et tester cette application Android sur votre PC. 
  
    
#### Tests Unitaires - NeighbourServiceTest.java

Il s'agit de vérifier le bon fonctionnement d'une partie précise du programme, une fonctionnalité précise, l'émulateur n'est donc pas nécessaire. 
En cliquant sur l'icone Play (vert) le test se lance et le résultat apparait  dans l'onglet RUN.


Vérifier que l'on accède bien à la liste des voisins:
```java
public void getNeighboursWithSuccess()
```
Supprimer un voisin donné et vérifier qu'il a bien été supprimé de la liste des voisins:
```java
 public void deleteNeighbourWithSuccess()
```
Créer un voisin et vérifier qu'il a bien été ajouté à la liste des voisins:
```java
public void createNeighbourWithSuccess()
```
Au défil de la liste des voisins, récupérer les voisins marqués comme favoris:
```java
public void getFavoriteNeighboursWithSuccess()
```
Enregistrer le changement d'état des voisins marqués comme favoris:
```java
public void updateFavoriteNeighbourWithSuccess()
```
  
  
#### Tests Instrumentalisés - NeighbourListTests.java
Les tests suivants nécessitent un émulateur. Il s'agira de tester la liste de voisins via l'UI. Il faudra donc observer le fonctionnement de l'application au cours du test pour valider son exécution. 

Test s'assurant que la liste de voisins comporte au moins 1 voisin:
```java
public void myNeighboursList_shouldNotBeEmpty(){...}
```
Test vérifiant qu'au clic sur le bouton supprimer d'un voisin, la liste de voisins comporte bien 1 voisin en moins :
```java
public void myNeighboursList_deleteAction_shouldRemoveItem(){...}
```
Test vérifiant qu'au clic sur un voisin précis, l'écran affichant les détails de ce voisin (nom concordant) s'ouvre bien:
```java
public void myNeighbourList_detailsAction_shouldDisplayNeighbourDetails (){...}
```
Test s'assurant qu'un voisin marqué comme favori apparaitra bien dans la liste des favoris (vide par défaut):
```java
public void myNeighboursList_favoriteAction_setInFavoriteList (){...}
```
  
  
### Identification des parties prenantes

Commanditaire: Claire Parlo, Entrevoisins
Equipe projet: Mr. Martins
Autre partie prenante: Charline, UX Designer freelance


#### Bilan sur Enjeu

L'expérience utilisateur est nettement améliorée.
Les nouvelles fonctionnalités ont étées ajoutées.
Le cadrage a été respecté.
Des tests ont étés produits rendant l'application maintenable et évolutive.



**Pour toute autre information, vous pouvez contacter la dernière personne en charge du projet par email: michael.martins@hotmail.fr**

