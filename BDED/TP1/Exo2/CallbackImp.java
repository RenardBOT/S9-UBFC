import java.rmi.server.*;
import java.rmi.*;

public class CallbackImp extends UnicastRemoteObject implements Callback {
      private String data;

      public CallbackImp() throws RemoteException {
            this.data = "EMPTY CALLBACK";
      }

      public String getData() {
            return this.data;
      }

      public void setData(String newData) {
            this.data = newData;
                  }
}
