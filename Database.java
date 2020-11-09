import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Math.abs;
import java.time.LocalDate;
 
class Database {
 
    public static final String url1 = "jdbc:mysql://localhost:3306/";
    public static final String url2 = "jdbc:mysql://localhost:3306/atmifc";
    public static final String user = "root";
    public static final String password = "Asdf1@2jkl";

    public static void init()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection(url1, user, password);
            Statement stmt=con1.createStatement();
            stmt.executeUpdate("create database atmifc");
            con1.close();
            Connection con2 = DriverManager.getConnection(url2, user, password);
            stmt=con2.createStatement();
            stmt.executeUpdate("use atmifc");
            stmt.executeUpdate("create table customers(cust_id int primary key, cust_name varchar(20), phn_no Bigint)");
            stmt.executeUpdate("create table accounts(acc_no int primary key, acc_bal decimal(10,2), cust_id int, foreign key(cust_id) references customers(cust_id))");
            stmt.executeUpdate("create table transactions(transac_id int primary key, transac_via varchar(10), transac_type varchar(10), bal_bef decimal(10,2), bal_aft decimal(10,2), date_time datetime, acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id))");
            stmt.executeUpdate("create table cards(card_no int primary key, card_type varchar(10), exp_date date, pin int, acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id), limit decimal(10,2))");
            stmt.executeUpdate("insert into customers values(1, 'X A', 8320331881)");
            stmt.executeUpdate("insert into customers values(2, 'Y B', 8000531100)");
            stmt.executeUpdate("insert into accounts values(1, 10, 2)");
            stmt.executeUpdate("insert into accounts values(2, 200, 1)");
            stmt.executeUpdate("insert into cards values(123, 'Credit', '2023-02-12', 1122, 2, 1, 100000)");
            stmt.executeUpdate("insert into cards values(111, 'Debit', '2022-07-23', 4312, 1, 2, 50000)");
            stmt.executeUpdate("insert into transactions values(1, 'Credit', 'Withdrawl', 200, 100, '2020-11-09 15:45:21', 1, 2)");
            stmt.executeUpdate("insert into transactions values(3, 'Debit', '3', 100, 50, '2020-10-11 12:35:20', 2, 1)");
            con2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void drop()
    {
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url2, user, password);
            stmt=con.createStatement();
            stmt.executeUpdate("drop database atmifc");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}