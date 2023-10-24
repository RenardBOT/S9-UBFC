import java.net.*;
import java.rmi.*;
import java.lang.Thread;
import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList;

public class ClientApp {

      public static void main(String args[]){
                        
            try{
                  List<Callback> results = new ArrayList<>();

                  BagOfTasks bag = (BagOfTasks) Naming.lookup("//172.31.18.37:1099/bag");
                  System.out.println("Bag of tasks récupéré") ;

                  // Scanner pour les entrées clavier
                  Scanner scanner = new Scanner( System.in ) ;

                  while(true){
                        System.out.println( "1 : Entrer une requête SQL " );
                        System.out.println( "2 : Récupérer les résultats " );
                        String menu = scanner.nextLine(); 

                        switch(menu){
                              case "1":
                                    System.out.print( "Entrer une requête SQL : " );
                                    String query = scanner.nextLine(); 
                                    Callback callback = new CallbackImp();
                                    results.add(callback);
                                    bag.submitTask(new TaskImp(query,callback));
                                    break;
                              case "2":
                                    System.out.println("Résultats : ");
                                    for(Callback result : results){
                                          System.out.println(result.getData());
                                    }
                                    results.clear();
                                    break;
                              default:
                                    System.out.println("Entrée invalide");
                        }
                  }

            }catch(Exception e){System.err.println("Erreur :"+e);}
      }
    
}
