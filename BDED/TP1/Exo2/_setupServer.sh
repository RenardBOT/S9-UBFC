#!/bin/bash

xterm -e "rmiregistry" &
xterm -e "javac Serveur.java"
xterm -e "java Serveur" &