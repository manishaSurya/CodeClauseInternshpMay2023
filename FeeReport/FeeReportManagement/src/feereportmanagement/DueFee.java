
package feereportmanagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DueFee extends JFrame {

   String x[]={"rollno","name","email","course","fee","paid","due","addrs","city","state","country","mob"};
    
    String y[][]=new String[20][12];
    int i=0,j=0;
    JTable t;
    Font f;
    

    DueFee() 
    {
        super("Due Fees Student");
        setLocation(1,1);
        setSize(1300,400);
        
         f=new Font("MS UI GOTHIC",Font.BOLD,15);
         try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="select*from add_student where due>0;";
                ResultSet rs=obj.st.executeQuery(q);
                while(rs.next())
                {
                   y[i][j++]=rs.getString("rollno");
                   y[i][j++]=rs.getString("name");
                   y[i][j++]=rs.getString("Email");
                   y[i][j++]=rs.getString("Course");
                   y[i][j++]=rs.getString("Fee");
                   y[i][j++]=rs.getString("paid");
                   y[i][j++]=rs.getString("due");
                   y[i][j++]=rs.getString("addrs");
                   y[i][j++]=rs.getString("city");
                   y[i][j++]=rs.getString("state");
                   y[i][j++]=rs.getString("country");
                   y[i][j++]=rs.getString("mob");
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
      new DueFee().setVisible(true);
    }
    
}
