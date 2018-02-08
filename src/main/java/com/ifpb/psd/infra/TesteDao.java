package com.ifpb.psd.infra;

import com.ifpb.psd.config.ConFactory;
import com.ifpb.psd.interfaces.Dao;
import com.ifpb.psd.model.Teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo Bento
 */
public class TesteDao implements Dao {

    private Connection con;

    public TesteDao() {
        this.con = ConFactory.getConnection();
    }

    @Override
    public void adicionar(Teste teste) {
        try {
            int id = getLastId();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO tabela (id, name, edited, deleted) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2, teste.getName());
            stmt.setBoolean(3, teste.isEdited());
            stmt.setBoolean(4, teste.isDeleted());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remover(Teste teste) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE tabela SET deleted = ? WHERE id = ?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, teste.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Teste teste) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE tabela SET edited = ? WHERE id = ?");
            stmt.setBoolean(2, true);
            stmt.setInt(3, teste.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private int getLastId() {
        int id = 1;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT MAX(id) FROM tabela");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

}
