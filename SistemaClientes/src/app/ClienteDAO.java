package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.execute();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id ASC";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome=?, email=? WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    // NOVA FUNÇÃO: Reindexa todos os IDs dos clientes
    public void reindexarIds() {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false); 

           
            List<Cliente> clientes = listarClientes();
            
            
            try (PreparedStatement stmtDelete = conn.prepareStatement("DELETE FROM clientes")) {
                stmtDelete.executeUpdate();
            }

           
            try (PreparedStatement stmtReset = conn.prepareStatement("ALTER TABLE clientes AUTO_INCREMENT = 1")) {
                stmtReset.executeUpdate();
            }

           
            String sqlInsert = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
            try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                for (Cliente cliente : clientes) {
                    stmtInsert.setString(1, cliente.getNome());
                    stmtInsert.setString(2, cliente.getEmail());
                    stmtInsert.addBatch(); 
                }
                stmtInsert.executeBatch(); 
            }

            conn.commit();
            System.out.println("IDs dos clientes foram reindexados com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao reindexar IDs: " + e.getMessage());
            
        }
    }
}