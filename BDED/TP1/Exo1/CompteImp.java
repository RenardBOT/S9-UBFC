import java.util.Scanner; 
import java.rmi.server.*;
import java.net.*;
import java.rmi.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class CompteImp extends UnicastRemoteObject implements Compte {
    public int id;
    public Connection connection;

    public CompteImp(int id, Connection connection) throws java.rmi.RemoteException{
        
        this.id = id;
        inputLog("Ouverture du compte n°"+id+"\n");
    }

    public void withdraw(int amount){
        inputLog("Compte n°"+this.id+" a retiré "+amount+"€\n");
    }

    public void deposit(int amount){
        inputLog("Compte n°"+this.id+" a déposé "+amount+"€\n");
    }
    
    public int check(){
        inputLog("Compte n°"+this.id+" a vérifié son solde\n");
    }

    public void inputLog(String log){
        try{
            Writer output;
            output = new BufferedWriter(new FileWriter("bank_log", true));  //clears file every time
            output.append(log);
            output.close();
        }catch(IOException e){
            System.out.println("Erreur ecriture fichier "+e);
        }
    }

    
}
