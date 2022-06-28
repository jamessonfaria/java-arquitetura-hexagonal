package br.com.jamesson.dominio;

public class Email {

    private String assunto;
    private String rementente;
    private String texto;
    private String destinatario;
    private Produto produto;

    public Email(String assunto, String rementente, String texto, String destinatario, Produto produto) {
        this.assunto = assunto;
        this.rementente = rementente;
        this.texto = texto;
        this.destinatario = destinatario;
        this.produto = produto;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getRementente() {
        return rementente;
    }

    public String getTexto() {
        return texto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public Produto getProduto() {
        return produto;
    }
}
