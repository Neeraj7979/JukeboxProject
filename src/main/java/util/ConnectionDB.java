package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnection()  {
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jukebox";
            String user = "root";
            String pass = "admin";
            connection = DriverManager.getConnection(url, user, pass);

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException exception){
            System.out.println(exception);
        }
        return connection;

    }
}