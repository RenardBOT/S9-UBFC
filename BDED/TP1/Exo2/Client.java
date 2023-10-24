import java.net.*;
import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Thread;

public class Client {
    public static void main(String args[]){
        try{
            System.out.println("Récupération du bag of tasks...");
            BagOfTasks bag = (BagOfTasks) Naming.lookup("//172.31.18.37:1099/bag");
            System.out.println("Bag of tasks récupéré");

            boolean next = true;
            while(next){
                Thread.sleep(5000);
                Task t = bag.nextTask();
                if(t == null)
                    continue;
                else{
                    System.out.println("Execution de la requête suivante :\n" + t.getQuery() );
                    t.execute();
                }
            }
            

            //System.out.println(t.value);
        }catch(Exception e){System.err.println("Erreur :"+e);}
    }
}
