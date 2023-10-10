import java.rmi.Remote;
import java.rmi.*;

public interface BagOfTasks extends Remote {

    public boolean isEmpty() throws java.rmi.RemoteException;

    public Task nextTask() throws java.rmi.RemoteException;

    public void sendResult(Task t) throws java.rmi.RemoteException;

    
    
}
