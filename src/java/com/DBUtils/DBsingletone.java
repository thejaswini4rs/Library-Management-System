
package com.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBsingletone {
    private static final DBsingletone only_one = new DBsingletone();
    private static Connection con;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static DBsingletone getDbSingletone() {
        return only_one;
    }

    public Connection getConnection() {
        System.out.println("connection made ");
        return con;
    }  
}
