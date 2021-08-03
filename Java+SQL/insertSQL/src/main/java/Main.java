import db.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) { //Insert on database
        Connection con = null;
        PreparedStatement pst = null;

        try{
            con= DB.getConnection();
            pst = con.prepareStatement(//SQL COMMANDS
                    "INSERT INTO seller" //Create new Seller on the datebase
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)" //Setting all columns from this table
                            + "Values"
                            + "(?,?,?,?,?)" //Placeholder for inserting data (name, email, birthdate, basesalary, departamentid) respectively
            );

            pst.setString(1,"Carl Purple"); //Name of the person being added
            pst.setString(2,"carl@email.com"); //Email
            pst.setDate(3, new Date(10-12-2020)); //BirthDate
            pst.setDouble(4, 3210.00); //BaseSalary
            pst.setInt(5,4); //DepartamentID

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
