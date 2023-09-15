import java.rmi.*;
import java.util.Scanner; 
public class Client {
    public static void main(String args[]){
        
        try{
            Scanner scan = new Scanner(System.in);
            /*while(true){
                String input = scan.nextLine();
                System.out.println("Entrée : "+input);
            }*/
            ObjectFactory factory = (ObjectFactory) Naming.lookup("rmi://172.31.18.42:1099/factory");
            System.out.println("Factory récupérée");
            int id = -1;
            while(id < 0 || id > 1000){
                System.out.println("Entrez votre ID (entre 0 et 1000):");
                String input = scan.nextLine();
                id = Integer.parseInt(input);
            }

            //Compte compte = factory.getCompte(id);
            Compte c = (Compte) factory.getCompte(id);
            System.out.println("Compte récupéré");
            
            int menu = 1;
            int menuMin = 1;
            int menuMax = 3;
            while(menu >= menuMin && menu <= menuMax){
                System.out.println("1 : Ajouter argent");
                System.out.println("2 : Retirer argent");
                System.out.println("3 : Vérifier solde");
                System.out.println("4 (ou autre) : Quitter");

                String m = scan.nextLine();
                menu = Integer.valueOf(m);

                if(menu == 1){
                    String ajout = scan.nextLine();
                    int a = Integer.valueOf(ajout);
                    factory.getCompte(id).deposit(a);
                }

                if(menu == 2){
                    String retrait = scan.nextLine();
                    int r = Integer.valueOf(retrait);
                    factory.getCompte(id).withdraw(r);
                }

                if(menu == 3)
                    System.out.println("Solde du compte ["+id+"] : "+factory.getCompte(id).check());
            
                factory.test();
                factory.debug();
            }
        }
        catch(Exception e){System.err.println("Erreur :"+e);}

    }
}
