package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class   Main {

    private Connection get_Db_Connection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
            System.out.println("Connected to database");
        }
        catch(ClassNotFoundException ce){
            System.out.println(ce.getMessage());
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        /*1. Connection
          2. Statement
          3. Result Set index starts at 1.
          4. Close
        */

        Main m = new Main();
        Connection conn = m.get_Db_Connection();
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}