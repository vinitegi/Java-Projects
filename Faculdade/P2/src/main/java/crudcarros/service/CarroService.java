package crudcarros.service;

import crudcarros.dao.CarroDAO;
import crudcarros.model.Carro;
import java.sql.SQLException;
import java.util.List;

public class CarroService {
    private final CarroDAO carroDAO;

    public CarroService() {
        this.carroDAO = new CarroDAO();
    }

    public Carro cadastrarCarro(String modelo, String marca, int ano, String cor, double preco) {
        validarString(modelo,"Modelo");
        validarString(marca,"Marca");
        validarString(cor, "Cor");
        validarAno(ano);
        validarPreco(preco);

        Carro carro = new Carro(modelo.trim(), marca.trim(), ano, cor.trim(), preco);

        try {
            carroDAO.inserir(carro);
            return carro;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar carro: " + e.getMessage(), e);
        }
    }

    //listar
    public List<Carro> listarCarros() {
        try {
            return carroDAO.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar carros: " + e.getMessage(), e);
        }
    }

    public Carro buscarCarroPorId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID deve ser um número positivo.");
        try {
            Carro carro = carroDAO.buscarPorId(id);
            if (carro == null) throw new RuntimeException("Carro com ID " + id + " nao encontrado.");
            return carro;
        } catch (RuntimeException e) {
            throw e;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar carro: " + e.getMessage(), e);
        }
    }

    public Carro atualizarCarro(int id, String modelo, String marca,
                                int ano, String cor, double preco) {
        buscarCarroPorId(id); // ve que existe

        validarString(modelo, "Modelo");
        validarString(marca, "Marca");
        validarString(cor,"Cor");
        validarAno(ano);
        validarPreco(preco);

        Carro carro = new Carro(id, modelo.trim(), marca.trim(), ano, cor.trim(), preco);

        try {
            if (!carroDAO.atualizar(carro))
                throw new RuntimeException("Falha ao atualizar carro com ID " + id);
            return carro;
        } catch (RuntimeException e) {
            throw e;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar carro: " + e.getMessage(), e);
        }
    }

    public void deletarCarro(int id) {
        buscarCarroPorId(id); // ve que existe

        try {
            if (!carroDAO.deletar(id))
                throw new RuntimeException("Falha ao excluir carro com ID " + id);
        } catch (RuntimeException e) {
            throw e;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir carro: " + e.getMessage(), e);
        }
    }

    private void validarString(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty())
            throw new IllegalArgumentException(campo + " não pode ser vazio.");
    }

    private void validarAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        if (ano < 1886 || ano > anoAtual + 1)
            throw new IllegalArgumentException("Ano inválido. Use entre 1886 e " + (anoAtual + 1) + ".");
    }

    private void validarPreco(double preco) {
        if (preco <= 0)
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
    }
}
