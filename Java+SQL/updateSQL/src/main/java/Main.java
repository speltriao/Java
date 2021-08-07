import db.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) { //Update data on database
        Connection con = null;
        PreparedStatement pst = null;

        try{
            con= DB.getConnection();
            pst = con.prepareStatement(//SQL COMMANDS
                "UPDATE seller"
                    + "SET BaseSalary = BaseSalary + ?" //Increments base salary
                    + "WHERE" //Select the sellers to be updated
            )

            int rowsAffected = pst.executeUpdate(); //Execute the operation, return the number of affected
            System.out.println("Done! " + "Rows updated: "+ rowsAffected);
        }
        catch (SQLException e){
            e.printStackTrace(); //Print the error message
        }
        finally {
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}
