package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB { //Database connection

    private static Connection con = null;

    public static Connection getConnection(){
        if (con == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                con = DriverManager.getConnection(url,properties);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    //getConnection() could be simplified as: Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd", "user", "passwd")

    private static Properties loadProperties(){ //Get the database details from the db.properties file
        try (FileInputStream fs = new FileInputStream("db.properties")){ //File reader
            Properties properties = new Properties();
            properties.load(fs); //Create a new Properties object containing the db.properties instructions
            return properties;

        } catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }
    public static void closeConnection() {
        if (con != null) {//Connection is instantiated
            try {
                con.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
