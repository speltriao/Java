import db.DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DB.getConnection();
        DB.closeConnection();
    }
}
