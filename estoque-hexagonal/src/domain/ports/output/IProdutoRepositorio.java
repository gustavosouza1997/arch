package domain.ports.output;

import domain.model.Produto;
import java.util.List;

public interface IProdutoRepositorio {
    
    void salvar(Produto produto);

    Produto buscarPorId(String id);

    List<Produto> listarTodos();
}