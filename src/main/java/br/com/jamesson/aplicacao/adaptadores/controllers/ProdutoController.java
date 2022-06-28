package br.com.jamesson.aplicacao.adaptadores.controllers;

import br.com.jamesson.dominio.dtos.EstoqueDTO;
import br.com.jamesson.dominio.dtos.ProdutoDTO;
import br.com.jamesson.dominio.portas.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void criarProdutos(@RequestBody ProdutoDTO produtoDTO){
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos(){
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping("/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO) throws Exception {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }
}
