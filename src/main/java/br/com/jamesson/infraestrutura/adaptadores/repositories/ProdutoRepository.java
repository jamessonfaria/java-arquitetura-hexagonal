package br.com.jamesson.infraestrutura.adaptadores.repositories;

import br.com.jamesson.dominio.Produto;
import br.com.jamesson.dominio.portas.repositories.ProdutoRepositoryPort;
import br.com.jamesson.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public Produto buscarPeloSku(String sku) throws Exception {
        Optional<ProdutoEntity> produtoEntity = this.springProdutoRepository.findBySku(sku);
        if (produtoEntity.isPresent())
            return produtoEntity.get().toProduto();

        throw new Exception("Produto não existe");
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity;
        if (Objects.isNull(produto.getCodigo()))
            produtoEntity = new ProdutoEntity();
        else {
            produtoEntity = this.springProdutoRepository.findById(produto.getCodigo()).get();
            produtoEntity.atualizar(produto);
        }

        this.springProdutoRepository.save(produtoEntity);
    }
}
