import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class testProps {
      public static void main(String[] args) {
            Properties prop = new Properties();
            try {
                  FileInputStream input = new FileInputStream("test.properties");
                  prop.load(input);
                  String ip = prop.getProperty("ip");
                  System.out.println("IP address: " + ip);
            } catch (IOException ex) {
                  ex.printStackTrace();
            }
      }
}
