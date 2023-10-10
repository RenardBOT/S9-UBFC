package rls;

import java.util.Random;

public class Model {
      static Random genr = new Random();
      int[] poids; // Liste des poids
      int[] valeurs; // Liste des valeurs
      int vmin; // Seuil de rentabilité
      int pmax; // Charge maximum du sac

      // Crée une instance à partir des données fournies
      public Model(int[] tabP, int[] tabV, int vMin, int pMax) {
            poids = new int[tabP.length];
            System.arraycopy(tabP, 0, poids, 0, tabP.length);
            valeurs = new int[tabV.length];
            System.arraycopy(tabV, 0, valeurs, 0, tabV.length);
            this.vmin = vMin;
            this.pmax = pMax;
      }

      // Crée une instance aléatoire supposée difficile (non testé)
      public Model(int nobj) {
            poids = new int[nobj];
            valeurs = new int[nobj];
            int nSol = nobj / 2 + 1;
            int nReste = nobj - nSol;
            int sommeP = 0;
            int sommeV = 0;
            for (int i = 0; i < nSol; i++) {
                  poids[i] = genr.nextInt(10000, 20000);
                  valeurs[i] = genr.nextInt(10000, 20000);
                  sommeP += poids[i];
                  sommeV += valeurs[i];
            }
            int valref = sommeV / (nSol + 1);
            for (int i = nSol; i < nobj; i++) {
                  int j = i - nSol;
                  poids[i] = poids[j] + genr.nextInt(1, 10);
                  valeurs[i] = valref + genr.nextInt(1, 10);
            }
            vmin = sommeV;
            pmax = sommeP;
      }

      public String toString() {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < poids.length; i++) {
                  if ((i % 10 == 0) && (i != 0))
                        out.append("\n");
                  out.append("(").append(poids[i]).append(",").append(valeurs[i]).append(") ");
            }
            out.append("\nPmax = ").append(pmax).append(", Vmin = ").append(vmin);
            return out.toString();
      }

      // Retourne le nombre d'objets
      int getNbObj() {
            return poids.length;
      }

      // Retourne le poid de l'objet numéro i
      int getPoids(int i) {
            return poids[i];
      }

      // Retourne la valeur de l'objet numéro i
      int getVal(int i) {
            return valeurs[i];
      }

      // Retourne le seuil de rentabilité
      int getVmin() {
            return vmin;
      }

      // Retourne la charge maximum autorisée
      int getPmax() {
            return pmax;
      }

      // Retourne la somme des valeurs de tous les objets possibles
      int getVmax() {
            int somme = 0;
            for (int i = 0; i < valeurs.length; i++)
                  somme += valeurs[i];
            return somme;
      }
}