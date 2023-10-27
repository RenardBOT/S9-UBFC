import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback extends Remote {

      public String getData() throws java.rmi.RemoteException;

      public void setData(String newData) throws java.rmi.RemoteException;
}

