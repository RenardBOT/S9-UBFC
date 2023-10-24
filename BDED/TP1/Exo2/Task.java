import java.io.Serializable;
import java.net.*;
import java.rmi.*;


public interface Task extends Serializable {

    public void execute();

    public String getQuery();  
}
