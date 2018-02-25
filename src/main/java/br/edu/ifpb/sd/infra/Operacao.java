package br.edu.ifpb.sd.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class Operacao {

    private final Connection conn;

    public Operacao() throws SQLException {
        this.conn = ConFactory.getInstance();
    }

    public void inserir(int id, String nome) throws SQLException {
        String sql = "INSERT INTO tb(id, name, edited, deleted) VALUES (?, ?, FALSE, FALSE);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, nome);
        stmt.executeUpdate();
    }

    public void atualizar(int id) throws SQLException {
        String sql = "UPDATE tb SET edited = TRUE WHERE id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void excluir(int id) throws SQLException {
        String sql = "UPDATE tb SET deleted = TRUE WHERE id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void limparTabela() throws SQLException {
        String sql = "delete from tb";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

}
