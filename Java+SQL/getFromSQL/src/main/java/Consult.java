import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consult { //Consult DB tables
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null; //Ready the connection
        Statement st = null; //Make thee search in the DB
        ResultSet rs = null; //Put the results here (has a table form)

        try{
            con = DB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM department"); //table name

            while (rs.next()){ //Read all rows from the rs table
                System.out.print(rs.getInt("Id") + ", "); //Print the int found at the Id column
                System.out.print(rs.getString("Name")+"\n"); //Print the string found at the Name column
            }
        }
        catch (SQLException e ){
            throw new db.DbException(e.getMessage());
        }
        finally { //Close database connection
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection(con);
        }

    }
}
