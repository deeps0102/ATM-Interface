import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;
 
class Connect {
 
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
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                cusobj.cust_id=rs.getInt(1);
                cusobj.cust_name=rs.getString(2);
                cusobj.phn_no=rs.getInt(3);
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
    public static void connectpk(int value, Account accobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from customers where acc_no="+value;
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
    public static void connectpk(int value, ArrayList<Transaction> transacs)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from customers where transac_id="+value;
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                Transaction trobj = new Transaction();
                trobj.transac_id=rs.getInt(1);
                trobj.transac_via=rs.getString(2);
                trobj.transac_type=rs.getString(3);
                trobj.bal_bef=rs.getDouble(4);
                trobj.bal_aft=rs.getDouble(5);
                trobj.date_time=rs.getDate(6);
                trobj.acc_no=rs.getInt(7);
                trobj.cust_id=rs.getInt(8);
                transacs.add(trobj);
            }

            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void getcardnos(ArrayList<Integer>cardnos)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select card_no from cards";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                int temp=rs.getInt(1);
                cardnos.add(temp);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void updatePin(int cardno, int newpin)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="update cards set pin="+newpin+" where card_no="+cardno;
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void getcustids(ArrayList<Integer>custids)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select cust_id from customers";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                int temp=rs.getInt(1);
                custids.add(temp);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}