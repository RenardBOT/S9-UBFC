#!/bin/bash
xterm -e "javac Client.java"
for (( i=1; i<=$1; ++i ))
do
    xterm -e "java Client" &
done