import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.rmi.*;

public class Serveur extends UnicastRemoteObject {
    public Serveur() throws RemoteException{super();}
    public static void main(String arg[]){

        // Récupération du port et de la taille du BoT dans le fichier de configuration
        int port = Config.getPort();
        int size = Config.getBagSize();

        try{
            BagOfTasksImp bag = new BagOfTasksImp(size);
            Registry registry = LocateRegistry.getRegistry(port);
            registry.bind("bag",bag);
            System.out.println("Serveur enregistré! ");
        }
        catch (Exception e){System.err.println("Erreur : "+e);}
    }
}
