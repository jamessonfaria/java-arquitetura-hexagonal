package br.com.jamesson.infraestrutura.configuracao;

import br.com.jamesson.dominio.adaptadores.services.PedidoServiceImpl;
import br.com.jamesson.dominio.portas.interfaces.ProdutoServicePort;
import br.com.jamesson.dominio.portas.repositories.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImpl(produtoRepositoryPort);
    }

}
