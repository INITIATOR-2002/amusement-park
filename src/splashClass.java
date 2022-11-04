import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class splashClass {
    public static void main(String[] args)
    {splash_screen sp = new splash_screen();
    sp.setVisible(true);
    login_page lp = new login_page();
    
    String contain ="1234567890";
    Random rnd = new Random();
    StringBuilder sb =new StringBuilder(2);
    for(int i=0;i<2;i++)
    {sb.append(contain.charAt(rnd.nextInt(contain.length())));}
    String random =sb.toString();
    int ran = Integer.parseInt(random);
    
    try{
    for(int i =0;i<=100;i++)
    {Thread.sleep(ran);
    sp.jLabel1.setText(Integer.toString(i));
    sp.jProgressBar1.setValue(i);
    if(i==100)
    {   sp.setVisible(false);
        lp.setVisible(true);}
    
    }
       }
    catch(Exception e)
    {
    }
    //creating table userinfo
    try
        {Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AmusementPark","root","123456");
            Statement stmt= con.createStatement();
            String rs2="create table if not exists userinfo (FIRST_NAME varchar(50) not null,LAST_NAME varchar(50) not null,USER_ID varchar(50) primary key not null,PASSWORD varchar(50) not null);";
            stmt.executeUpdate(rs2);
            
        }

        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);} 
   //creating table hotelsbooked 
    try
        {Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AmusementPark","root","123456");
            Statement stmt= con.createStatement();
            String rs2="create table if not exists hotelsbooked (User_Id varchar(50) not null,Country varchar(50) not null,City varchar(50) not null,Star varchar(50) not null,Check_In_Date varchar(50) not null,Check_out_Date varchar(50) not null,Check_In_Time varchar(50) not null,Check_Out_Time varchar(50) not null,Infants varchar(50) not null,Adults varchar(50) not null,Room_Type varchar(50) not null,Stay_Days integer not null,Total_Price double not null);";
            stmt.executeUpdate(rs2);
            
        }

        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);} 
    
    //creating table Parkbook
     try
        {Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AmusementPark","root","123456");
            Statement stmt= con.createStatement();
            String rs2=" create table if not exists parkbook" +
            " (User_Id varchar(50) not null," +
            " Themepack varchar(50) not null," +
            " Waterpack varchar(50) not null," +
            " snowpack varchar(50) not null," +
            " No_of_people integer not null," +
            " Date_of_visit varchar(50) not null," + 
            " cost integer not null );";
            stmt.executeUpdate(rs2);
            
}

        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e);} 
    }   
    
     
}
