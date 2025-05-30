package br.edu.cs.poo.ac.seguro.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.Period;

public class Segurado implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nome;
    private Endereco endereco;
    private LocalDate dataCriacao;
    private BigDecimal bonus;

    public Segurado(Endereco endereco, String nome, LocalDate dataCriacao, BigDecimal bonus) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.bonus = bonus;
        this.dataCriacao = dataCriacao;
    }


    public String getnome() {
        return nome;
    }

    public Endereco getendereco() {
        return endereco;
    }

    protected LocalDate getdataCriacao() {
        return dataCriacao;
    }

    protected void setdataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public int getIdade() {
        return Period.between(this.dataCriacao,  LocalDate.now()).getYears();
    }

    public void creditarBonus(BigDecimal valor) {
        bonus = bonus.add(valor); //valores bigdecimal não usam operadores matemáticos, mas sim esses métodos de soma, substração, etc
    }

    public void debitarBonus(BigDecimal valor) {
        bonus = bonus.subtract(valor);
    }
}
