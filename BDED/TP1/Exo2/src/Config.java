import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Classe utilisant Properties pour récupérer les paramètres de connexion.
// Ces propriétés sont l'ip, le port.
public class Config {

      private static Properties properties = new Properties();
      
      // Chargement des propriétés depuis le fichier properties.txt
      static {
            try {
                  properties.load(new FileInputStream("properties.txt"));
            } catch (IOException e) {
                  System.err.println("Erreur lors du chargement du fichier properties.txt");
                  System.exit(1);
            }
      }
      
      // Récupération de l'ip
      public static String getIp() {
            return properties.getProperty("ip");
      }
      
      // Récupération du port
      public static int getPort() {
            return Integer.parseInt(properties.getProperty("port"));
      }

      // Récupération de la taille du bag of tasks
      public static int getBagSize() {
            return Integer.parseInt(properties.getProperty("bagSize"));
      }

      // Récupération du boolean interactive qui permet de mettre en pause le worker
      public static boolean getInteractive() {
            return Boolean.parseBoolean(properties.getProperty("interactive"));
      }

      // Récupération du sleepTime
      public static int getSleepTime() {
            return Integer.parseInt(properties.getProperty("sleepTime"));
      }
      
}
