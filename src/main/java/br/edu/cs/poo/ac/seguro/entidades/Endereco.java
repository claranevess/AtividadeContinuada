package br.edu.cs.poo.ac.seguro.entidades;

public class Endereco {
    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String pais;
    private String estado;
    private String cidade;

    public Endereco(String logradouro, String cep, String numero, String complemento, String pais, String estado, String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }


    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}