package br.com.jamesson.dominio.portas.repositories;

import br.com.jamesson.dominio.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();
    Produto buscarPeloSku(String sku) throws Exception;
    void salvar(Produto produto);

}
