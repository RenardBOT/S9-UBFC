import java.sql.*;
import javax.sql.rowset.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ConnectionPool{
      // CONSTANTES
      final private static String LOGIN = "ep298479";
      final private static String MDP = "ep298479";
      final private static String URL = "jdbc:oracle:thin:@eluard:1521:eluard2023";

      public ArrayList<ConnectionState> connectionPool;

      public ConnectionPool(int amount){
            for( int i = 0 ; i < amount ; i++ ){
                  Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
                  connectionPool.add(new ConnectionState(connection))
            }
      }

      public Connection nextConnection(){
            Iterator<ConnectionState> poolIterator = this.connectionPool.iterator();
            boolean isFound = false;
            Connection nextAvailableConnection;

            while(poolIterator.hasNext() && !isFound){
                  ConnectionState next = poolIterator.next();
                  if(next.isAvailable){
                        nextAvailableConnection = next.connection;
                        isFound = true;
                  }
            }
            
            return nextAvailableConnection;
      }
}