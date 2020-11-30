package base;

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
    
    /*
    public static final String user = "root";
    public static final String password = "password";
    */
 
    public static final String user = "root";
    public static final String password = "password";

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
            stmt.executeUpdate("create table transactions(transac_id int, transac_via varchar(10), transac_type varchar(10), bal_bef decimal(10,2), bal_aft decimal(10,2), date_time varchar(30), acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id), amount decimal(10,2))");
            stmt.executeUpdate("create table cards(card_no int primary key, card_type varchar(10), exp_date date, pin int, acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id), lim decimal(10,2))");
            stmt.executeUpdate("insert into customers values(1, 'X A', 8320331881)");
            stmt.executeUpdate("insert into customers values(2, 'Y B', 8000531100)");
            stmt.executeUpdate("insert into customers values(3, 'Z C', 1122334455)");
            stmt.executeUpdate("insert into customers values(4, 'W D', 6677889911)");
            stmt.executeUpdate("insert into accounts values(2, 4000, 2)");
            stmt.executeUpdate("insert into accounts values(1, 20500, 1)");
            stmt.executeUpdate("insert into accounts values(4, 5000, 3)");
            stmt.executeUpdate("insert into accounts values(3, 30500, 4)");
            stmt.executeUpdate("insert into cards values(123, 'Credit', '2023-02-12', 1122, 1, 1, 10000)");
            stmt.executeUpdate("insert into cards values(111, 'Debit', '2022-07-23', 4312, 2, 2, 10000)");
            stmt.executeUpdate("insert into cards values(132, 'Credit', '2023-02-21', 1234, 3, 3, 10000)");
            stmt.executeUpdate("insert into cards values(121, 'Debit', '2022-07-14', 5678, 4, 4, 10000)");
            stmt.executeUpdate("insert into transactions values(1, 'Credit', 'Withdraw', 50000, 20500, '11-09-2020', 1, 1, 29500)");
            stmt.executeUpdate("insert into transactions values(3, 'Debit', '3', 5000, 4000, '11-09-2020', 2, 2, 1000)");
            stmt.executeUpdate("insert into transactions values(1, 'Credit', 'Withdraw', 50000, 20500, '11-09-2020', 1, 1, 29500)");
            stmt.executeUpdate("insert into transactions values(3, 'Debit', '3', 5000, 4000, '11-09-2020', 2, 2, 1000)");
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