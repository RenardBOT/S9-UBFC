import java.net.*;
import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Thread;

public class Client {
    public static void main(String args[]){
        try{
            System.out.println("Récupération du bag of tasks...");
            BagOfTasks bag = (BagOfTasks) Naming.lookup("rmi://172.31.18.43:1099/bag");
            System.out.println("Bag of tasks récupéré");

            boolean next = true;
            while(next){
                Thread.sleep(250);
                Task t = bag.nextTask();
                if(t == null)
                    next = false;
                else{
                    System.out.println("Traitement du nombre "+t.getValue()+"...");
                    t.execute();
                    bag.sendResult(t);
                }
            }
            

            //System.out.println(t.value);
        }catch(Exception e){System.err.println("Erreur :"+e);}
    }
}
