package br.com.jamesson.dominio.portas.interfaces;

import br.com.jamesson.dominio.Email;
import br.com.jamesson.dominio.Produto;

public interface EmailServicePort {

    void enviar(Email email);

}
