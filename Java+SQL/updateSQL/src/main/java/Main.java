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
                "UPDATE seller " //Always leave spaces after command string.
                    + "SET BaseSalary = BaseSalary + ? " //Increments base salary
                    + "WHERE " //Select the sellers to be updated
                    + "(DepartmentId = ?)" //Change all salaries from a given Department
            );

            pst.setDouble(1,200.0); // Set BaseSalary (first ?) as 200.0
            pst.setInt(2,2); //Set DepartmentId (second ?) as DepartmentId 2

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
