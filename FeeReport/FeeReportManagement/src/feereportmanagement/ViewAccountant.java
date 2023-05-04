
package feereportmanagement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class ViewAccountant extends JFrame 
{
    String x[]={"name","password","email","contact","address"};
    
    String y[][]=new String[20][5];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    
    

     ViewAccountant() 
     {
          super("Customer Information");
        setLocation(1,1);
        setSize(800,400);
        
        f=new Font("MS UI GOTHIC",Font.BOLD,15);
        try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="select*from accountant;";
                ResultSet rs=obj.st.executeQuery(q);
                while(rs.next())
                {
                   y[i][j++]=rs.getString("name");
                   y[i][j++]=rs.getString("password");
                   y[i][j++]=rs.getString("email");
                   y[i][j++]=rs.getString("contact");
                   y[i][j++]=rs.getString("address");
                   i++;
                   j=0;
                   
                }
                
                t=new JTable(y,x);
                t.setFont(f);
                
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
      }

     public static void main(String[] args) 
     {
      new ViewAccountant().setVisible(true);
    }
   
    
}
