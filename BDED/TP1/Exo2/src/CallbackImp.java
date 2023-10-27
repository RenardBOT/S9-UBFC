
import java.rmi.server.*;
import java.rmi.*;
import java.io.Serializable;


public class CallbackImp extends UnicastRemoteObject implements Callback {
      
      private String data;

      public CallbackImp() throws java.rmi.RemoteException {
            this.data = null;
      }

      public String getData() {
            return this.data;
      }

      public void setData(String newData) {
            this.data = newData;
      }
}
