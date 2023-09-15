
import java.rmi.Remote;
import java.rmi.*;
public interface Compte extends Remote{
    public void withdraw(int amount) throws java.rmi.RemoteException;

    public void deposit(int amount) throws java.rmi.RemoteException;
    
    public int check() throws java.rmi.RemoteException;

    public void inputLog(String log) throws java.rmi.RemoteException;
}
