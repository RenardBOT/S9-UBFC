import java.sql.*;
import javax.sql.rowset.*;
//import com.sun.rowset.*;

public class ExempleConnexion {
    // LOGIN et MDP doivent correspondre à ceux de la BD
    final private static String LOGIN = "ep298479";
    final private static String MDP = "ep298479";
    // URL pour se connecter à Eluard
    final private static String URL = "jdbc:oracle:thin:@eluard:1521:eluard2023";


    /**
     * A exécuter avec "java -cp ojdbcX.jar:. ExempleConnexion"
     *
     */
    public static void main(String[] args) {
        try {
            // Chargemebt du driver Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Ouverture de la connexion
		    Connection connexion = DriverManager.getConnection(URL, LOGIN, MDP);

            /*
            * Statement : exécution d'une requête.
            */
            // executeQuery : pour les requêtes retournant un résultat
            /*
            Statement stmtExecuteQuery = connexion.createStatement();
            ResultSet rsExecuteQuery = stmtExecuteQuery.executeQuery("select * from v$version");
            while (rsExecuteQuery.next()) {
                System.out.println(rsExecuteQuery.getString(1));
            }
            rsExecuteQuery.close();
            stmtExecuteQuery.close();

            // execute : pour tous les types de requêtes
            Statement stmtExecute = connexion.createStatement();
            try {
                stmtExecute.execute("DROP TABLE test2");
            } catch (SQLException e) {}
            boolean resultExecute = stmtExecute.execute("CREATE TABLE test2(id INTEGER)");
            System.out.println(resultExecute);
            stmtExecute.close();

            // executeUpdate : utilisé principalement pour les INSERT, UPDATE et DELETE
            Statement stmtExecuteUpdate = connexion.createStatement();
            int resultExecuteUpdate = stmtExecuteUpdate.executeUpdate("INSERT INTO test2(id) VALUES(100)");
            stmtExecuteUpdate.close();

            /*
            * PreparedStatement : permet de construire une requête
            * et de l'exécuter avec des paramètres spécifiques.
            * On retrouve les méthodes executeuery(), executeUpdate() et execute()
            * de l'objet Statement. 
            */
            
            /*
            PreparedStatement preparedStmt = connexion.prepareStatement("SELECT id FROM bank WHERE id = 5");
            //preparedStmt.setInt(1, 100);
            ResultSet rsPreparedStmt = preparedStmt.executeQuery();
            while (rsPreparedStmt.next()) {
                System.out.println("---");
                System.out.println(rsPreparedStmt.getString(1));
            }
            */

            String query = "SELECT * FROM bank";
            try(Statement stmt = connexion.createStatement()){
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt(1);
                    float balance = rs.getFloat(2);

                    System.out.println("ID = "+id+", BALANCE = "+balance);
                }
                stmt.close();
                rs.close();
            }catch (Exception e) {
                System.out.println("Erreur");
              }


            /*
            * CachedRowSet : conservation du résultat d'un ResultSet en hors-ligne
            * (sans nécessiter une connexion ouverte à la BD). 
            * Peut être sérialisé. 
            */
            /*
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rsPreparedStmt);
            
            // Ne pas oublier de fermer les ressources !
            rsPreparedStmt.close();
            stmtExecuteQuery.close();
            connexion.close();
            */
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Utiliser 'java -cp ojdbcX.jar:. ExempleConnexion' en remplacant X par la version de l'ojdbc pour exécuter le programme.");
        }
    }
}
