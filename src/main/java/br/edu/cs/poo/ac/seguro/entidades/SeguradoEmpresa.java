package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SeguradoEmpresa extends Segurado {
    private String cnpj;
    private double faturamento;
    private boolean ehLocadoraDeVeiculos;

    public SeguradoEmpresa(String nome, Endereco endereco, LocalDate dataAbertura, BigDecimal bonus, String cnpj, double faturamento, boolean ehLocadoraDeVeiculos) {
		super(endereco, nome, dataAbertura, bonus);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
        this.ehLocadoraDeVeiculos = ehLocadoraDeVeiculos;
	}

    public String getcnpj() {
        return cnpj;
    }
    
    public double getfaturamento() {
        return faturamento;
    }
    
    public boolean getehLocadoraDeVeiculos() {
        return ehLocadoraDeVeiculos;
    }
    
    public void setcnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public void setfaturamento(double faturamento){
        this.faturamento = faturamento;
    }
    
    public void setehLocadoraDeVeiculos(boolean ehLocadoraDeVeiculos){
        this.ehLocadoraDeVeiculos = ehLocadoraDeVeiculos;
    }
    
    public LocalDate getDataAbertura(){
        return this.getdataCriacao();
    }
    
    public void setDataAbertura(LocalDate dataAbertura){
        this.setdataCriacao(dataAbertura); /*basicamente dataAbertura não existe como
        atributo, é só um outro nome pra dataCriacao. aí, pra acessar em outro código que
        não o próprio de criação, tem que repetir o método (set / get) e colocar
        como parâmetro o nome que o atributo tem nesse código de agora*/
    }
}

