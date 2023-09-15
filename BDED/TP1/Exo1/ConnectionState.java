import java.sql.*;
import javax.sql.rowset.*;

public class ConnectionState {
      public Connection connection;
      public boolean isAvailable;

      public ConnectionState(Connection c){
            this.connection = c;
            this.isAvailable = true;
      }
}
