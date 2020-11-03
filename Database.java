import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
 
class Database {
 
    public static final String url1 = "jdbc:mysql://localhost:3306/";
    public static final String url2 = "jdbc:mysql://localhost:3306/atmifc";
    public static final String user = "root";
    public static final String password = "Asdf1@2jkl";

    public static void init()
    {
        Connection con1 = null, con2 = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(url1, user, password);
            stmt=con1.createStatement();
            stmt.executeUpdate("create database atmifc");
            con1.close();
            con2 = DriverManager.getConnection(url2, user, password);
            stmt=con2.createStatement();
            stmt.executeUpdate("use atmifc");
            stmt.executeUpdate("create table customers(cust_id int primary key, cust_name varchar(20), ph_no Bigint)");
            stmt.executeUpdate("create table accounts(acc_no int primary key, acc_bal decimal(10,2), cust_id int, foreign key(cust_id) references customers(cust_id))");
            stmt.executeUpdate("create table transactions(tr_id int primary key, tr_via varchar(10), tr_type varchar(10), bal_bef decimal(10,2), bal_aft decimal(10,2), date_time datetime, acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id))");
            stmt.executeUpdate("create table cards(cd_no int primary key, cd_type varchar(10), exp_date date, pin int, acc_no int, foreign key(acc_no) references accounts(acc_no), cust_id int, foreign key(cust_id) references customers(cust_id), limit decimal(10,2))");
            stmt.executeUpdate("insert into customers values(1, 'X A')");
            stmt.executeUpdate("insert into customers values(2, 'Y B')");
            stmt.executeUpdate("insert into accounts values(1, 100, 100000, 2)");
            stmt.executeUpdate("insert into accounts values(2, 200, 50000, 1)");
            stmt.executeUpdate("insert into cards values(123, 'Credit', '2023-02-12', 1122, 2, 1)");
            stmt.executeUpdate("insert into cards values(111, 'Debit', '2022-07-23', 4312, 1, 2)");
            stmt.executeUpdate("insert into transactions values(1, 'Credit', 'Withdrawl', 200, 100, '2020-11-09 15:45:21', 1, 2)");
            stmt.executeUpdate("insert into transactions values(3, 'Debit', '3', 100, 50, '2020-10-11 12:35:20', 2, 1)");
            con2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}