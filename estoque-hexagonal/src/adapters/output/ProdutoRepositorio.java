package infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import domain.model.Produto;
import domain.ports.output.IProdutoRepositorio;

public class ProdutoRepositorio implements IProdutoRepositorio {

    private HashMap<String, Produto> banco = new HashMap<>();

    public void salvar(Produto produto) {
        banco.put(produto.getId(), produto);
    }

    public Produto buscarPorId(String id) {
        return banco.get(id);
    }

    public void excluirPorId(String id) {
        banco.remove(id);
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(banco.values());
    }
}