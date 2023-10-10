package rls;

public class Config implements Configuration {
      int[] sac; // Numéros des objets chargés dans le sac
      int[] reste; // Numéros des objets non embarqués
      int nSac; // Nombre d'objets dans le sac
      int nReste; // Nombre d'objet non embarqués
      int poids; // Poids cumulés des objets embarqués
      int valeur; // Valeur cumulée des objets embarqués
      double vobj; // Score de la configuration courante
      Model model; // Données de l'instance de problème traitée

      // Crée une configuration de l'instance de problème du sac à dos
      // décrite par m dans laquelle le sac est vide.
      public Config(Model m) {
            model = m;
            sac = new int[m.getNbObj()];
            reste = new int[m.getNbObj()];
            nSac = 0;
            nReste = m.getNbObj();
            for (int i = 0; i < nReste; i++) {
                  reste[i] = i;
            }
            poids = 0;
            valeur = 0;
            vobj = fobj(poids, valeur);
      }

      public int nbrVoisins() {
            return nSac + nReste + nSac * nReste;
      }

      public double fobjVoisin(int i) {

      }

      /**   sac poidsMax 10 et valeurMin 10
       *    score = 0 -> val = vMin
       *    score = 1 -> val = vMax
       *    donc score = (val - vMin) / (vMax - vMin)
       * 
       *    vMin = 50, vMax = 60
       *    val = 5
       * */
      public double fobj(int poids, int val) {
            final double COEF_POIDS = 0.5;
            final double COEF_VAL   = 1 - COEF_POIDS;
            final double PENALITE_POIDS = 1;
            final double PENALITE_VAL   = 1;

            double scorePoids = 1 - poids/this.model.getPmax();
            double scoreVal   = (val - this.model.getVmin()) / (this.model.getVmax() - this.model.getVmin());
            double penalite   = 0

            if(poids > this.model.getPmax())
                  penalite += PENALITE_POIDS;
            if(val < this.model.getVmin())
                  penalite += PENALITE_VAL;

            return COEF_POIDS * scorePoids + COEF_VAL * scoreVal - penalite;


            

      }

      public double fobj() {
            return vobj;
      }

      // Chambouler la configuration courante aléatoirement
      public void randomize() {
            final int ITERATIONS = 1000;
            for(int i = 0; i < ITERATIONS; i++)
                  selectVoisin(randomVoisin());
      }

      public void selectVoisin(int i) {
            // Retirer un objet du sac
            if(i < nSac){
                  reste[nReste] = sac[i] ;
                  sac[i] = sac[nSac-1];
                  sac[nSac-1] = 0;
                  nSac--;
                  nReste++;
            }
            // Ajouter un objet dans le sac
            else if(i < nSac + nReste){
                  int index = i - nSac;
                  sac[nSac] = reste[index];
                  reste[index] = reste[nReste-1];
                  reste[nReste-1] = 0;
                  nSac++;
                  nReste--;
            }
            // Echanger deux objets
            else{
                  int index = i - nSac - nReste;
                  int indexA = index % nSac;
                  int indexB = index / nSac;
                  int buffer = sac[indexA];
                  sac[indexA] = reste[indexB];
                  reste[indexB] = buffer;
            }

      }

      public int randomVoisin() {
            return (int) (Math.random() * nbrVoisins());
      }

      public boolean solution() {
            return valeur >= model.getVmin();
      }
}
