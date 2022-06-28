package br.com.jamesson.infraestrutura.adaptadores.email;

import br.com.jamesson.dominio.Email;
import br.com.jamesson.dominio.portas.interfaces.EmailServicePort;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements EmailServicePort {

    @Override
    public void enviar(Email email) {
        System.out.println("----------------------------");
        System.out.println("De: " + email.getRementente());
        System.out.println("Para: " + email.getDestinatario());
        System.out.println("Assunto: "+ email.getAssunto());
        System.out.println("Texto: "+ email.getTexto());
        System.out.println("Produto: "+ email.getProduto());
        System.out.println("----------------------------");
    }
}
