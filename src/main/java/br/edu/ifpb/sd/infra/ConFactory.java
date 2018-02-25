package br.edu.ifpb.sd.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class ConFactory {
    
    public static Connection getInstance() throws SQLException{
        String usuario = "postgres";
        String senha = "12345";
        String url = "jdbc:postgresql://localhost:5432/thread";
        Connection con = DriverManager.getConnection(url, usuario, senha);
        con.setAutoCommit(true);
        return con;
    }
    
}
