package br.com.jamesson.dominio.portas.interfaces;

import br.com.jamesson.dominio.dtos.EstoqueDTO;
import br.com.jamesson.dominio.dtos.ProdutoDTO;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();
    void criarProduto(ProdutoDTO produtoDTO);
    void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws Exception;

}
