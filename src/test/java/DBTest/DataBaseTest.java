package DBTest;

import org.checkerframework.checker.units.qual.min;

import java.sql.*;

public class DataBaseTest {
    //to build the connection with database we need 3 things :
    //1. URL, Username, Password
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";//java based database, database is my SQL, ip address and name of DataBase
        String username="syntax_hrm";
        String password="syntaxhrm123";

        //we need to establish the connection to database
        try {
          Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for Batch15");
            //create a statement to send sql queries
            Statement statement= conn.createStatement();

//when we send any query to the database then database returns result sets(table), rows and columns
          ResultSet rset= statement.executeQuery("select FirstName, LastName from person"); //will return only header part
            rset.next();// will return next rows

            String fName=rset.getString("FirstName");
            String lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

            rset.next();// will return next rows

            fName=rset.getString("FirstName");
            lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

        } catch (SQLException e) {
           e.printStackTrace();
        }


    }
}
