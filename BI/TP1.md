# Prise en main

**Q1.** Manipulation 

**Q2.** Manipulation

**Q3.** Nombre d'exemples : 14

**Q4.**
- Le graphe en bas à droite permet de visualiser les exemples classés en fonction de la valeur prise par un de leurs attributs 
- L'attribut play indique si les conditions sont propices pour jouer au golf, c'est lui qui décide de la positivité d'un exemple.
- Il faut faire de l'apprentissage

**Q5.** Les valeurs de température et d'humidités ne sont plus discrétisées.

# Clustering

**Q1.** Manipulation

**Q2.** Manipulation

**Q3.** 
- De base il y a deux groupes
- Avec trois groupes sans changer les autres paramètres (Distance euclidienne) il n'y a pas d'erreur dans la classification
- Pas de différence non plus avec la distance de Manhattan.

**Q4.** Il y a + de graphiques pour apporter plus de points de vue à l'analyse

**Q5.**
- En choisissant les mêmes x et y, un segment de droite linéaire se forme (trivial)
- Quand on choisit cluster(nom) en x et n'importe quoi d'autre en y (à part class ou cluster), les exemples sont rangés en fonction de leur cluster sur l'axe des abscisses.

**Q6.** Les résultats sont semblables, que l'algorithme K-Means et Cobweb soit utilisé. Il faut noter que dans K-Means le nombre de groupe doit être indiqué (3), alors que Cobweb les infère lui même.
Dans la pratique Cobweb indique la création de 4 clusters, mais en réalité ils sont organisés sous forme d'arbre et le *cluster0* ne contient aucune instance, il s'agit juste de la racine.

# Apprentissage

**Q1.** L'algorithme sort les règles suivantes :
```
(humidity = high) ∧ (outlook = sunny)     => play = no
(outlook = rainy) ∧ (windy = TRUE)        => play = no
                                          => play = yes
```
La dernière ligne signifie que les termes ne correspondant pas aux deux précédantes sont classées en **yes**

Donc la fonction de reconnaissance est :
```
[(humidity = high) ∧ (outlook = sunny)] ∨ [(outlook = rainy) ∧ (windy = TRUE)]
```
Si l'on considère que **no** indique la positivité

**Q2.** Humidity et Windy sont deux attributs prenant deux valeurs. La plupart des exemples où l'humidité est normale (6/7) l'attribut play vaut yes, donc il semble idéal pour classifier.

**Q3.a** Outlook est l'attribut utilisé en premier pour classifier, et cela semble logique, étant donné que pour la valeur "overcast", tous les exemples sont à yes.
**Au final Outlook semble être le meilleur attribut à utiliser pour classifier.**

**Q3.b** En consultant l'arbre, on trouve deux chemins permettant d'atteindre **No** qui est la valeur de positivité :
```
(outlook = sunny) -> (humidity = high) 
(outlook = rainy) -> (windy = TRUE) 
```

Donc la fonction de reconnaissance est :
```
[(humidity = high) ∧ (outlook = sunny)] ∨ [(outlook = rainy) ∧ (windy = TRUE)]
```
Qui est exactement celle trouvée avec l'algorithme JRip.

**Q4.** J48 appliqué sur *weather.numeric* donne de meilleurs résultats que sur *weather.nominal* (64% vs 50% de classifications correctes).
Cependant, JRip donne un résultat inverse (57% vs 54% de classifications correctes).  
On peut ainsi supposer que J48 fonctionne mieux sur des attributs continus, tandis que JRip fonctionne mieux sur des attributs discrets.  
<ins>Noter que les jeux de données utilisés sont assez petits, et les résultats obtenus par conséquent peu conclusifs</ins>

# Apprentissage encore

**Q1.** Manipulation

**Q2.a** Ces nombres signifient que des individus avec le diabète ont été classés comme n'ayant pas le diabète, et inversement.

**Q2.b** Car on utilise des valeurs continues.

**Q3.** C'est une galère a expliquer simplement :9

**Q4.a** Attribut important : Glucose dans le sang. En changeant l'algorithme pour que l'arbre n'ait qu'une profondeur de 1, on ne perd que 2% de résultats correctement classés.

**Q4.b** Oui, par exemple : Une personne dont l'IMC est supérieure à 29.9 et dont le taux de plasma dans le sang à 157

**Q4.c** Les arbres de décision sont facilement interprétable et compréhensibles contrairement aux autres algorithme de classification qui sont des boîtes noires.

**Q5.** Les résultats finaux sont similaires, mais l'arbre obtenu est complètement différent 