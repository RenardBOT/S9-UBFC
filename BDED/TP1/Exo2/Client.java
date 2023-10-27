import java.net.*;
import java.rmi.*;
import java.lang.Thread;
import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList;

public class Client {

      public static void main(String args[]){
            
            // Récupération de l'ip et du port avec la classe Config
            String ip = Config.getIp();                       
            int port = Config.getPort();

            // Construction de l'url du bag of tasks
            String url = "//"+ip+":"+port+"/bag";

            try{
                  List<Callback> results = new ArrayList<>();

                  BagOfTasks bag = (BagOfTasks) Naming.lookup(url);
                  System.out.println("Bag of tasks récupéré") ;

                  // Scanner pour les entrées clavier
                  Scanner scanner = new Scanner( System.in ) ;

                  // Menu pour entrer une requête ou récupérer les résultats depuis une entrée clavier
                  while(true){
                        System.out.println( "1 : Entrer une requête SQL " );
                        System.out.println( "2 : Récupérer les résultats " );
                        String menu = scanner.nextLine(); 

                        switch(menu){

                              case "1":

                                    // Vérification que le serveur n'est pas surchargé
                                    if(bag.isFull()){
                                          System.out.println("Le serveur est surchargé, veuillez réessayer plus tard");
                                          break;
                                    }

                                    System.out.print( "Entrer une requête SQL : " );
                                    String query = scanner.nextLine(); 
                                    Callback callback = new CallbackImp();
                                    results.add(callback);
                                    bag.submitTask(new TaskImp(query,callback));
                                    break;

                              case "2":
                                    System.out.println("Résultats : ");
                                    for(int i = 0; i < results.size(); i++){
                                          Callback result = results.get(i);
                                          System.out.println("--------\n RESULTAT "+(i+1)+" :\n--------");
                                          if(result.getData() == null){
                                                System.out.println("En attente du résultat");
                                          }else{
                                                System.out.println(result.getData());
                                          }
                                    }
                                    break;

                              default:
                                    System.out.println("Entrée invalide");
                        }
                  }

            }catch(Exception e){System.err.println("Erreur :"+e);}
      }
    
}

