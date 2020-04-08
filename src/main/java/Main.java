import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        Properties connectionProps  = new Properties();
        connectionProps.load(Main.class.getResourceAsStream("jdbc.properties"));
        Connection conn = DriverManager.getConnection(connectionProps.getProperty("url"), connectionProps);
        DatabaseMetaData dmd = conn.getMetaData();
        System.out.printf("JDBC driver name: %s\n", dmd.getDriverName());
        System.out.printf("JDBC driver version: %s\n", dmd.getDriverVersion());
        System.out.printf("Database product version: %s\n", dmd.getDatabaseProductVersion());
        conn.close();
    }

}
