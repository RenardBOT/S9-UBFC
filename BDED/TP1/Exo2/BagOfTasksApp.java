import java.rmi.Remote;
import java.rmi.*;

public interface BagOfTasksApp extends Remote {

      public void submitTask(Task task) throws java.rmi.RemoteException;

}
