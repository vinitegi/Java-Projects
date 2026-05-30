package crudcarros.dao;

import crudcarros.connection.ConnectionFactory;
import crudcarros.model.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    public void inserir(Carro carro) throws SQLException {
        String sql = "INSERT INTO carros (modelo, marca, ano, cor, preco) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getMarca());
            stmt.setInt (3, carro.getAno());
            stmt.setString(4, carro.getCor());
            stmt.setDouble(5, carro.getPreco());

            stmt.executeUpdate();

            //recupera o id gerado pelo AUTO_INCREMENT e atualiza o objeto
            try (ResultSet chave = stmt.getGeneratedKeys()) {
                if (chave.next()) {
                    carro.setId(chave.getInt(1));
                }
            }
        }
    }

    public List<Carro> listarTodos() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT id, modelo, marca, ano, cor, preco FROM carros ORDER BY id ASC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                carros.add(mapearResultSet(rs));
            }
        }
        return carros;
    }

    public Carro buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, modelo, marca, ano, cor, preco FROM carros WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearResultSet(rs);
                }
            }
        }
        return null; // nao encontrado
    }

    public boolean atualizar(Carro carro) throws SQLException {
        String sql = "UPDATE carros SET modelo=?, marca=?, ano=?, cor=?, preco=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getMarca());
            stmt.setInt   (3, carro.getAno());
            stmt.setString(4, carro.getCor());
            stmt.setDouble(5, carro.getPreco());
            stmt.setInt   (6, carro.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM carros WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Carro mapearResultSet(ResultSet rs) throws SQLException {
        return new Carro(
                rs.getInt ("id"),
                rs.getString("modelo"),
                rs.getString("marca"),
                rs.getInt ("ano"),
                rs.getString("cor"),
                rs.getDouble("preco")
        );
    }
}
