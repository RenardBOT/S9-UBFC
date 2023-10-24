import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.rmi.*;

public class Serveur extends UnicastRemoteObject {
    public Serveur() throws RemoteException{super();}
    public static void main(String arg[]){
        try{
            BagOfTasksImp bag = new BagOfTasksImp();
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.bind("bag",bag);
            System.out.println("Serveur enregistré! ");
        }
        catch (Exception e){System.err.println("Erreur : "+e);}
    }
}
