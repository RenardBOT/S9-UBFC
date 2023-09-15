import java.rmi.Remote;
import java.rmi.*;
import java.util.HashMap;

public interface ObjectFactory extends Remote{

    public Compte getCompte(int id)
        throws java.rmi.RemoteException;

    public void test()
        throws java.rmi.RemoteException;
    

}
