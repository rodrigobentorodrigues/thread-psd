package com.ifpb.psd.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo Bento
 */
public class ConFactory {
    
    private static final String url = "jdbc:postgresql://localhost:5432/PSD";
    private static final String user = "postgres";
    private static final String password = "12345";
    
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }        
    }    
    
}
