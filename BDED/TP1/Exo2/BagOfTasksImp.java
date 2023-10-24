import java.rmi.server.*;
import java.net.*;
import java.rmi.*;
import java.util.Queue;
import java.util.LinkedList;

public class BagOfTasksImp extends UnicastRemoteObject implements BagOfTasks {

    public Queue<Task> taskQueue;
    public int result;

    public BagOfTasksImp() throws java.rmi.RemoteException{
        taskQueue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return taskQueue.isEmpty();
    }

    public Task nextTask(){
        if(this.isEmpty())
            return null;
        return taskQueue.remove();
    }

    /* public void sendResult(Task t){
        if(t.getResult()){
            System.out.println("Une requête a été effectuée");
        }
    } */

    public void submitTask(Task task){
        System.out.println("Requête reçue dans la queue : "+task.getQuery());
        taskQueue.add(task);
    }
    
}
