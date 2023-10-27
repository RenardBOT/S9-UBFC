#!/bin/bash

# script de lancement du serveur : prend en paramètre le port pour le rmiregistry

# lancement du rmiregistry dans un terminal
cd src/
xterm -e "rmiregistry" &
cd ../

#attente 250ms pour laisser le temps au rmiregistry de se lancer
sleep 0.50

# lancement du serveur dans un terminal (serveur : src/Serveur.java)
x-terminal-emulator -e "java -cp src/ Serveur" &
