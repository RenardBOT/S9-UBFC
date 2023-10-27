import java.net.*;
import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Thread;

public class Worker {
    public static void main(String args[]){

        // Récupération de l'ip, du port, du temps de sommeil entre les traitements et du boolean interactive avec la classe Config
        String ip = Config.getIp();
        int port = Config.getPort();
        boolean interactive = Config.getInteractive();
        int sleepTime = Config.getSleepTime();

        // Construction de l'url du bag of tasks
        String url = "//"+ip+":"+port+"/bag";

        try{

            // Initialisation du worker : récupération du bag of tasks qui est un objet distant
            System.out.println("Récupération du bag of tasks...");
            BagOfTasks bag = (BagOfTasks) Naming.lookup(url);
            System.out.println("Bag of tasks récupéré");

            // Boucle infinie pour récupérer les requêtes du bag of tasks
            boolean next = true;
            while(next){

                // Si le boolean interactive est à true, on attend une entrée clavier pour continuer
                if(interactive){
                    System.out.println("Appuyez sur entrée pour recevoir une requête");
                    System.in.read();
                }

                Thread.sleep(sleepTime);
                Task t = bag.nextTask();
                if(t == null)
                    continue;
                else{
                    // Si le boolean interactive est à true, on attend une entrée clavier pour continuer
                    if(interactive){
                        System.out.println("Appuyez sur entrée pour exécuter la requête suivante :\n" + t.getQuery());
                        System.in.read();
                    }
                    
                    System.out.println("Execution de la requête suivante :\n" + t.getQuery() );
                    t.execute();
                }
            }
        }catch(Exception e){System.err.println("Erreur :"+e);}
    }
}
