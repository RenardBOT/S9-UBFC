import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.*;

public interface Callback extends Serializable, Remote {

      public String getData() throws java.rmi.RemoteException;

      public void setData(String newData) throws java.rmi.RemoteException;
}

