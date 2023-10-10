import java.net.*;
import java.rmi.*;
import java.lang.Thread;
import java.util.Scanner;
import java.util.ArrayList

public class ClientApp {

      public static void main(String args[]){
            
            try{
                  List<Callback> results = new ArrayList<>();

                  System.out.println("Récupération du bag of tasks...");
                  BagOfTasksApp bag = (BagOfTasksApp) Naming.lookup("rmi://172.31.18.43:1099/bag");
                  System.out.println("Bag of tasks récupéré");
                  Scanner scanner = new Scanner( System.in ) ;

                  while(true){
                        System.out.println( "1 : Entrer une requête SQL " );
                        System.out.println( "2 : Récupérer les résultats " );
                        String menu = scanner.nextLine(); 

                        switch(menu){
                              System.out.print( "Entrer une requête SQL : " );
                              String query = scanner.nextLine(); 
                              Callback callback = new Callback();
                              results.add(callback);
                              bag.submitTask(new TaskImp(query,callback));
                        }
                  }

            }catch(Exception e){System.err.println("Erreur :"+e);}
      }
    
}
