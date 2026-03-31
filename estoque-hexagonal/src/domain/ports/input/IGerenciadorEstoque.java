package domain.ports.input;

import java.util.List;

import domain.Estoque;
import domain.Produto;

public interface IGerenciadorEstoque {

    public void cadastrarProduto(String id, String nome, double preco) {}

    public Produto consultarProduto(String id) {}

    public void excluirProduto(String id) {}

    public double calcularPrecoMedio() {}
}