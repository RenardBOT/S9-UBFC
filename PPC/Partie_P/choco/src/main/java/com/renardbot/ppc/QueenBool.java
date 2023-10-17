package com.renardbot.ppc;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class QueenBool {
      Model model;

      public void build(){
            int n = 5;
            int size = n*n;
            this.model = new Model(n + "-queens problem (boolean variation)");
            IntVar[][] vars = new IntVar[n][n];
            for(int i = 0; i < n; i++){
                  for(int j = 0; j < n; j++)
                  {
                        vars[i][j] = model.intVar("Q_"+i+','+j, 0, 1);
                  }
            }

            // Contrainte de ligne
            for(int i = 0; i < n; i++){
                  model.sum(vars[i], "=", 1).post();
            }

            // Contrainte de colonne
            for(int i = 0 ; i < n ; i++){
                  IntVar[] col = new IntVar[n];
                  for(int j = 0 ; j < n ; j++){
                        col[j] = vars[j][i];
                  }
                  model.sum(col, "=", 1).post();
            }

            // Contrainte de diagonales descendantes
            

      }

      public void solve(){
            Solution solution = this.model.getSolver().findSolution();
            if(solution != null)
            {
                System.out.println(solution.toString());
            }
      }
}
