import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import javax.sql.rowset.*;


public class Serveur extends UnicastRemoteObject {
    public Serveur() throws RemoteException{super();}
    public static void main(String arg[]){
        try{
            // CONNEXION BDD
            final private static String LOGIN = "ep298479";
            final private static String MDP = "ep298479";
            final private static String URL = "jdbc:oracle:thin:@eluard:1521:eluard2023";
            


            ObjectFactoryImp factory = new ObjectFactoryImp();
            Registry registry = LocateRegistry.getRegistry ();
            registry.bind("factory",factory);
            System.out.println("Serveur enregistré! ");
        }
        catch (Exception e){System.err.println("Erreur : "+e);}
    }
}
