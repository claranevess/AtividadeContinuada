package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;

public class SeguradoPessoa extends Segurado implements Serializable{

    private static final long serialVersionUID = 1L;

    private String cpf;
    private double renda;

    public SeguradoPessoa(String nome, Endereco endereco, LocalDate dataNascimento, BigDecimal bonus, String cpf, double renda) {
        super(endereco, nome, dataNascimento, bonus);
        this.cpf = cpf;
        this.renda = renda;
    }


    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public LocalDate getdataNascimento() {
        return this.getdataCriacao(); //é uma boa prática quando for acessar atributos
        //de outras classes em um get / set usar this.getOQueEuQueriaRetornar();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.setdataCriacao(dataNascimento);
    }
}

