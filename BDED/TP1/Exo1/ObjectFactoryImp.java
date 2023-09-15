import java.util.HashMap;
import java.rmi.server.*;
import java.net.*;
import java.rmi.*;

public class ObjectFactoryImp extends UnicastRemoteObject implements ObjectFactory {
    public ConnectionPool pool;

    public ObjectFactoryImp(int poolSize) throws java.rmi.RemoteException{
        this.pool = new ConnectionPool(poolSize);
    }

    public CompteImp getCompte(int id) throws java.rmi.RemoteException{
        Connection nextConnection = pool.nextConnection();
        return new CompteImp(id,nextConnection);
    }

    public void test(){
        System.out.println("OK CA MARCHE");
    }
}
