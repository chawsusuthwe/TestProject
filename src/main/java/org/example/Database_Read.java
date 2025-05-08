package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database_Read {
    private Connection conn;

    public Database_Read(Connection conn) {
        this.conn = conn;
    }

    protected ArrayList<Offices> read(){
        ArrayList<Offices> aloffice = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM offices WHERE country = ?");
            //PreparedStatement ps = conn.preparedStatement("SELECT * FROM offices WHERE country = ?");
            ps.setString(1,"USA");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
//                System.out.print(rs.getInt(1));
//                System.out.print("|");
//                System.out.print(rs.getString("city"));
//                System.out.println();
                aloffice.add(new Offices(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9)));
            }

            rs.close();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return aloffice;
    }

    protected void display(ArrayList<Offices> aloffice){

    }
}