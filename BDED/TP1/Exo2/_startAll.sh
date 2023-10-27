#!/bin/bash

# appelle successivement les scripts _startServer.sh, _startWorkers.sh et _startClients.sh avec les paramètres fournis

if [ $# -eq 0 ]
      then
            echo "Pas de paramètres. Veuillez fournir le nombre de workers et de clients à lancer."
            exit 1
fi

./_startServer.sh
./_startWorkers.sh $1   
./_startClients.sh $2