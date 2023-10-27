import java.rmi.server.*;
import java.net.*;
import java.rmi.*;
import java.util.Queue;
import java.util.LinkedList;

public class BagOfTasksImp extends UnicastRemoteObject implements BagOfTasks {

    public Queue<Task> taskQueue;
    public int size;

    public BagOfTasksImp(int size) throws java.rmi.RemoteException{

        // Queue contenant les requêtes à répartir entre les Workers
        taskQueue = new LinkedList<>();
        this.size = size;
    }

    public boolean isEmpty(){
        return taskQueue.isEmpty();
    }

    public boolean isFull(){
        return taskQueue.size() == size;
    }

    public Task nextTask(){
        if(this.isEmpty())
            return null;

        return taskQueue.remove();
    }

    public void submitTask(Task task){
        System.out.println("Requête reçue dans la queue : "+task.getQuery());
        taskQueue.add(task);
    }

    public void setSize(int size){
        this.size = size;
    }
    
}
