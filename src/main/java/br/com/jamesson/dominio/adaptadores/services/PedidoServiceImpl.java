package br.com.jamesson.dominio.adaptadores.services;

import br.com.jamesson.dominio.Produto;
import br.com.jamesson.dominio.dtos.EstoqueDTO;
import br.com.jamesson.dominio.dtos.ProdutoDTO;
import br.com.jamesson.dominio.portas.interfaces.ProdutoServicePort;
import br.com.jamesson.dominio.portas.repositories.ProdutoRepositoryPort;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PedidoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public PedidoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepositoryPort.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepositoryPort.salvar(produto);
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws Exception {
        Produto produto = this.produtoRepositoryPort.buscarPeloSku(sku);
        if(Objects.isNull(produto))
            throw new Exception("Produto não encontrado");

        produto.atualizarEstoque(estoqueDTO.getQuantidade());
        this.produtoRepositoryPort.salvar(produto);
    }
}
