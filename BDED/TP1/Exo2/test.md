# Requêtes SQL avec Java RMI
Le programme Java présent dans ce répertoire permet de pouvoir instancier 3 entités : Un **Serveur**, des **Clients** et des **Workers**. Un utilisateur peut soumettre des requêtes SQL au client, et consulter les résultats une fois traitées par les workers.


## Scripts

Quelques scripts shell permettent de compiler ou d'exécuter en se plaçant dans un terminal dans le répertoire racine.

### Compilation

Pour pouvoir supprimer tous les fichiers .class et recompiler l'entièreté du programme :
```Shell
$ ./_delClass
$ ./_compil
```

### Execution
Lancement du rmiregistry et du serveur :
```
$ ./_startServer
```
Lancement de n workers :
```
$ ./_startWorkers n
```
Lancement de k clients :
```
$ ./_startClients k
```
Enfin, un dernier script exécute les trois l'un après l'autre pour gagner en efficacité :
```
$ ./_startAll n k
```

### Exemple d'utilisation 
Une fois le client lançé, un menu propose entre soumettre une requête SQL ou consulter les résultats. Lors de la soumission des requêtes, elles ne doivent pas posséder de point virgule à la fin, par exemple :
``SELECT * FROM bank WHERE id>150``

## Propriétés
Le fichier ```properties.txt``` permet de modifier quelques constantes et comportements du programme :
* ``ip=255.255.255.255`` : adresse IP du serveur
* ``port=1099`` : port d'écoute du RMI Registry
* ``interactive=[true|false]`` : permet d'activer ou non le mode interactif des workers (voir plus bas)
* ``sleepTime=100`` : temps de sommeil entre chaque traitement des workers (voir plus bas)
* ``bagSize=3`` : nombre de requêtes pouvant être traitées simultanément par le serveur avant d'indiquer à l'utilisateur une surcharge **(simulation de la charge)**

### Comportement des Workers
**Mode interactif :** Quand le mod interactif est actié (true), alors le worker attendra une entrée clavier (touche Entrée par exemple) pour procéder au cours de ses opérations. Cela permet de pouvoir observer le comportement de chacun des workers un à un, et d'étudier l'ordre de traitement des requêtes.
*En particulier, il faut une entrée pour que le Worker aille chercher une requête sur le serveur, et une entrée pour aller chercher le résultat et le communiquer au client.*

**Temps de sommeil :** La constante ``sleepTime`` définit le temps qu'attend chaque Worker avant de tenter d'accéder au serveur pour récupérer une requête. Ne sert à rien si le mode interactif est activé. 

## Requêtes Test
Voici quelques requêtes test permettant de manipuler un table ``names`` possédant deux attributs, ``id`` (entier clé primaire) et ``name`` (String de taille 50) **à copier coller dans le client pour effectuer des tests**

id|name
--|----
1|Alice
2|Bob
...|...

  

### Création de la table
Pour créer la table
```sql
CREATE TABLE names (id INT  PRIMARY KEY,name VARCHAR(50))
```
Pour la supprimer
```sql
DROP TABLE names
```
### Consultation de la table
```sql
SELECT name FROM names
```
```sql
SELECT * FROM names WHERE id >1
```

### Ajout d'un tuple
```sql
INSERT INTO names (id, name) VALUES (1, 'Alice')
```
```sql
INSERT INTO names (id, name) VALUES (2, 'Bob')
```
```sql
INSERT INTO names (id, name) VALUES (3, 'Carol')
```
**Attention :** Les reqûetes INSERT INTO causent une exception, mais les valeurs sont correctement insérées dans la table
### Consultation de la table
```sql
SELECT * FROM names WHERE id >1
```
### Mise à jour d'un tuple
```sql
UPDATE names SET name='Bobby' WHERE id=2
```
### Suppression d'un tuple
```sql
DELETE FROM names WHERE id=1
```
```sql
DELETE FROM names WHERE name='Bob'
```
```sql
DELETE FROM names WHERE id=3
```


