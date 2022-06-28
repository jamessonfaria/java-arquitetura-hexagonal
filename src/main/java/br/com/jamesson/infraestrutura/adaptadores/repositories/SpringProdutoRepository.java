package br.com.jamesson.infraestrutura.adaptadores.repositories;

import br.com.jamesson.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Double> {
    Optional<ProdutoEntity> findBySku(String sku);
}
