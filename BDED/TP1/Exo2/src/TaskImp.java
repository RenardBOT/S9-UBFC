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
        final String LOGIN = "ep298479";
        final String MDP = "ep298479";
        final String URL = "jdbc:oracle:thin:@eluard:1521:eluard2023"; 

        // CONNEXION BD
        try{ 
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connexion = DriverManager.getConnection(URL, LOGIN, MDP);

        result = "";
        PreparedStatement preparedStmt = connexion.prepareStatement(this.query);
        ResultSet rsPreparedStmt = preparedStmt.executeQuery();

        System.out.println("ok");

        // Traitement du résultat d'une requête insert, update ou delete
        if(rsPreparedStmt.getMetaData().getColumnCount() == 0){
            result = "REQUETE : "+this.query+"\nRESULTAT : REQUETE EXECUTEE AVEC SUCCES";
        }

        // Traitement du résultat d'une requête select, drop table ou create table (et d'autres requêtes qui retournent un résultat)
        if(!rsPreparedStmt.next()){
            result = "REQUETE : "+this.query+"\nRESULTAT : REQUETE EXECUTEE AVEC SUCCES";
        }else{
            result = "REQUETE : "+this.query+"\nRESULTAT : \n";
            do{
                result += rsPreparedStmt.getString(1) + " " + rsPreparedStmt.getString(2) + "\n";
            }while(rsPreparedStmt.next());
        }
    

        
        

        callback.setData(result);

        System.out.println("Résultat de la requête : " + result);
        connexion.close();


        }catch(Exception e){
            System.err.println("Erreur 2 :"+e);
            // Ajout de l'erreur dans le callback (gestion de la remote exception)
            try{  
                callback.setData("ERREUR :"+e);
            }catch(Exception e2){
                System.err.println("Erreur 3 :"+e2);
            }   
        }
    }
    
}
