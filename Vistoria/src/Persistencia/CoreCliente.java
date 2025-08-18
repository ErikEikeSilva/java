package persistencia;



import core.Cliente;



import java.sql.*;

import java.util.ArrayList;

import java.util.List;



/**

 * DAO didático para Cliente usando JDBC (CRUD mínimo).

 */

public class ClienteDAO {



    public void inserir(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO clients (name, document, phone, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.obterConexao();

             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNome());

            ps.setString(2, cliente.getDocumento());

            ps.setString(3, cliente.getTelefone());

            ps.setString(4, cliente.getEmail());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) cliente.setId(rs.getInt(1));

            }

        }

    }



    public List<Cliente> listarTodos() throws SQLException {

        String sql = "SELECT * FROM clients ORDER BY name";

        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.obterConexao();

             PreparedStatement ps = conn.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente c = new Cliente(rs.getString("name"), rs.getString("document"));

                c.setId(rs.getInt("id"));

                c.setTelefone(rs.getString("phone"));

                c.setEmail(rs.getString("email"));

                lista.add(c);

            }

        }

        return lista;

    }

}