package rls;

public final class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] poids = new int[]{ 1 , 2 , 3 };
        int[] valeurs = new int[]{ 1 , 1 , 2 };
        int poidsMax = 10;
        int valeurMax = 10;

        Model modele = new Model(poids, valeurs, poidsMax, valeurMax);
        System.out.println(modele.toString());

    }
}
