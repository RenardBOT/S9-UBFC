package rls;

public interface Configuration
{
    int nbrVoisins();         // Nombre de voisins de la config courante
    double fobjVoisin(int i); // Score du voisin numéro i de la config courante
    double fobj();            // Score de la config courante
    void randomize();         // Chamboule aléatoirement la config courante
    void selectVoisin(int i); // La config courante devient le voisin numéro i
    int randomVoisin();       // Un numéro de voisin aléatoire
    boolean solution();       // Teste si la config courante est une solution
}
