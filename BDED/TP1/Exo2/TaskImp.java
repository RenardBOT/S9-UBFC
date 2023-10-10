import java.rmi.server.*;
import java.net.*;
import java.rmi.*;
import java.io.Serializable;
import java.sql.*;
import javax.sql.rowset.*;

public class TaskImp implements Serializable,Task  {

    String query;
    String result;
    Callback callback;
    

    public TaskImp(String query, Callback callback){
        
        this.query = query;
        System.out.println("Tâche créée avec la requête : " + query);

        this.callback = callback;
    }

    public String getQuery(){
        return this.query;
    }

    public void execute(){
        // CONSTANTES CONNEXION BD
        final private static String LOGIN = "ep298479";
        final private static String MDP = "ep298479";
        final private static String URL = "jdbc:oracle:thin:@eluard:1521:eluard2023";

        // CONNEXION BD
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connexion = DriverManager.getConnection(URL, LOGIN, MDP);

        result = "";
        PreparedStatement preparedStmt = connexion.prepareStatement(this.query);
        ResultSet rsPreparedStmt = preparedStmt.executeQuery();
        callback.updateResult("OK");
    }

    public String getResult(){
        return "Résultat";
    }
    
}
