package rls;

public class Solveur
{
    //static Model instance = new Model(21);
  
    static int[] poids = {101, 102, 104, 108, 116, 132, 164};
    static int[] valeurs = {10, 11, 12, 13, 14, 15, 16};
    static Model instance = new Model(poids, valeurs, 54, 460);

    public static Configuration run(int maxTrans)
    {
        Configuration cur = new Config(instance);
        double actualScore = cur.fobj();
        System.out.println("Score initial : " + actualScore);
        for(int i=0; i<maxTrans; i++)
        {
            if(cur.solution()) return cur;
            int candidat = cur.randomVoisin();
            double newScore = cur.fobjVoisin(candidat);
            if(newScore >= actualScore)
            {
                cur.selectVoisin(candidat);
                if(newScore > actualScore)
                {
                    actualScore = newScore;
                    System.out.println(i + " : " + cur.fobj());
                }
            }
        }
        return cur;
    }

    public static void main(String[] args)
    {
        Configuration resultat = run(10000);
        if(resultat.solution())
            System.out.println("Solution trouvée");
        else
            System.out.println("Solution non trouvée");
        System.out.println(resultat);
    }
}