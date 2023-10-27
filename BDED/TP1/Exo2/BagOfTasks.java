import java.rmi.Remote;
import java.rmi.*;

public interface BagOfTasks extends Remote {

    public boolean isEmpty() throws java.rmi.RemoteException;

    public boolean isFull() throws java.rmi.RemoteException;

    public Task nextTask() throws java.rmi.RemoteException;
    
    public void submitTask(Task task) throws java.rmi.RemoteException;
    
}
