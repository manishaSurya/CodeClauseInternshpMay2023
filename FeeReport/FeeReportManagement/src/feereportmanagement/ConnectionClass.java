
package feereportmanagement;

import java.sql.*;
public class ConnectionClass {
    
    Connection con;
    Statement st;
    
    ConnectionClass()
    {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","root");
           st=con.createStatement();
           if(con.isClosed())
           {
               System.out.println("Not connected");          
           }
           else
           {
               System.out.println("Connected");
           }
                   
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    public static void main(String[] args) {
        new ConnectionClass();
    }
    
}
