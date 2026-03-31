package application;

import java.util.List;

import domain.model.Estoque;
import domain.model.Produto;
import domain.ports.input.IGerenciadorEstoque;
import domain.ports.output.IProdutoRepositorio;

public class GerenciadorEstoque implements IGerenciadorEstoque {

    private IProdutoRepositorio produtoRepositorio;
    private Estoque estoque;

    public GerenciadorEstoque(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.estoque = new Estoque();
    }

    public void cadastrarProduto(String id, String nome, double preco) {
        Produto produto = new Produto(id, nome, preco);
        produtoRepositorio.salvar(produto);
    }

    public Produto consultarProduto(String id) {
        return produtoRepositorio.buscarPorId(id);
    }

    public void excluirProduto(String id) {
        Produto produto = produtoRepositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto com ID '" + id + "' não encontrado.");
        }

        produtoRepositorio.excluirPorId(id);
    }

    public double calcularPrecoMedio() {
        List<Produto> produtos = produtoRepositorio.listarTodos();
        return estoque.calcularPrecoMedio(produtos);
    }
}