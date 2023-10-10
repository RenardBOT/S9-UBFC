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
            ObjectFactoryImp factory = new ObjectFactoryImp();
            Registry registry = LocateRegistry.getRegistry ();
            registry.bind("factory",factory);
            System.out.println("Serveur enregistré! ");
        }
        catch (Exception e){System.err.println("Erreur : "+e);}
    }
}
