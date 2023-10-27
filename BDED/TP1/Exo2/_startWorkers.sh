#!/bin/bash

# script de lancement de plusieurs workers (nombre en paramètres)

if [ $# -eq 0 ]
      then
            echo "Pas de paramètres. Veuillez fournir le nombre de workers à lancer."
            exit 1
fi

for ((i=1;i<=$1;i++)); do
            sleep 0.50
            x-terminal-emulator -e "java -cp src:ojdbc8.jar Worker" &
done
