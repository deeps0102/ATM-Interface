package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;

class Connect {
 
    public static final String url = "jdbc:mysql://localhost:3306/atmifc";
    /*
    public static final String user = "root";
    public static final String password = "password";
    */
 
    public static final String user = "root";
    public static final String password = "password";

    public void connectpk(int value, Customer cusobj)
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
    public void connectpk(int value, Card cardobj)
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
    public void connectpk(int value, Account accobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from accounts where acc_no="+value;
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
    public ArrayList<Transaction> connectpk(int value)
    {
        ArrayList<Transaction> transacs=new ArrayList<Transaction>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from transactions where cust_id="+value;
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                Transaction trobj = new Transaction();
                trobj.transac_id=rs.getInt(1);
                trobj.transac_via=rs.getString(2);
                trobj.transac_type=rs.getString(3);
                trobj.bal_bef=rs.getDouble(4);
                trobj.bal_aft=rs.getDouble(5);
                trobj.date_time=rs.getString(6);
                trobj.acc_no=rs.getInt(7);
                trobj.cust_id=rs.getInt(8);
                trobj.amt=rs.getDouble(9);
            
                transacs.add(trobj);
            }

            con.close();
        }
        catch(Exception e){
            System.out.println("Unable to get details of transactions");
            e.printStackTrace();
        }

        return transacs;
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
    public static String getname(int cust_id)
    {
        String name=new String();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query = "select cust_name from customers where cust_id="+cust_id;
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                name=rs.getString(1);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return name;
    }
    public void updateAccbal(int accno, double newbal)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query = "update accounts set acc_bal="+newbal+" where acc_no="+accno;
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addtransaction(Trans_cre tcobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query = "insert into transactions values("+tcobj.transac_id+",'"+tcobj.transac_via+"','"+tcobj.transac_type+"',"+tcobj.bal_bef+","+tcobj.bal_aft+",'"+tcobj.date_time+"',"+tcobj.acc_no+","+tcobj.cust_id+","+tcobj.amt+")";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addtransaction(Trans_deb tdobj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query = "insert into transactions values("+tdobj.transac_id+",'"+tdobj.transac_via+"','"+tdobj.transac_type+"',"+tdobj.bal_bef+","+tdobj.bal_aft+",'"+tdobj.date_time+"',"+tdobj.acc_no+","+tdobj.cust_id+","+tdobj.amt+")";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}