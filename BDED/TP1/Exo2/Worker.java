import java.net.*;
import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Thread;

public class Worker {
    public static void main(String args[]){

       // Le premier argument est le temps de sommeil du worker (en ms), par défaut 0ms
        int sleepTime = 0;

        try{
            sleepTime = Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("Pas de temps de sommeil spécifié, utilisation de la valeur par défaut : 500ms");
        }

        // Récupération de l'ip, du port et du boolean interactive avec la classe Config
        String ip = Config.getIp();
        int port = Config.getPort();
        boolean interactive = Config.getInteractive();

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
