import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
 
class Connection {
 
    public static final String url = "jdbc:mysql://localhost:3306/atmifc";
 
    public static final String user = "root";
 
    public static final String password = "Asdf1@2jkl";

    public static void connectpk(int value, Customer cusobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from customers where cust_id="+value;
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                cusobj.customer_id=rs.getInt(1);
                cusobj.c_name=rs.getString(2);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void connectpk(int value, Card cardobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from cards where card_no="+value;
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                cardobj.card_no=rs.getInt(1);
                cardobj.card_type=rs.getString(2);
                cardobj.exp_date=rs.getDate(3);
                cardobj.pin=rs.getInt(4);
                cardobj.acc_no=rs.getInt(5);
                cardobj.cust_id=rs.getInt(6);
                cardobj.limit=rs.getDouble(7);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void connectpk(int value, Customer accobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from customers where acc_no="+value;
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                accobj.acc_no=rs.getInt(1);
                accobj.acc_bal=rs.getDouble(2);
                accobj.cust_id=rs.getInt(3);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void connectpk(int value, Customer trobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from customers where tr_id="+value;
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                trobj.transac_id=rs.getInt(1);
                trobj.transac_via=rs.getString(2);
                trobj.transac_type=rs.getString(3);
                trobj.bal_bef=rs.Double(4);
                trobj.bal_aft=rs.Double(5);
                trobj.date_time=;
                trobj.acc_no=rs.getInt(7);
                trobj.cust_id=rs.getInt(8);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}