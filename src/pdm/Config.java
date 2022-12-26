package pdm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    public static Connection getConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbomysql", "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
