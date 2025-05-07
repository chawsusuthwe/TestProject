package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database_Read {
    private Connection conn;

    public Database_Read(Connection conn) {
        this.conn = conn;
    }

    protected void read(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM offices WHERE country = ?");
            //PreparedStatement ps = conn.preparedStatement("SELECT * FROM offices WHERE country = ?");
            ps.setString(1,"USA");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt(1));
                System.out.print("|");
                System.out.print(rs.getString("city"));
                System.out.println();
            }

            rs.close();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}