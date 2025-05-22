package br.edu.cs.poo.ac.seguro.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Data
public class Veiculo implements Registro{
    private static final long serialVersionUID = 1L;

    private String placa;
    private int ano;
    private SeguradoEmpresa proprietarioEmpresa;
    private SeguradoPessoa proprietarioPessoa;
    private CategoriaVeiculo categoria;
    private String idUnico;
    

    public Veiculo(String placa,int ano,SeguradoEmpresa proprietarioEmpresa,SeguradoPessoa proprietarioPessoa,CategoriaVeiculo categoria){
        this.placa = placa;
        this.ano = ano;
        this.proprietarioEmpresa = proprietarioEmpresa;
        this.proprietarioPessoa = proprietarioPessoa;
        this.categoria = categoria;
    }

    public Veiculo(String idUnico) {
        this.idUnico = idUnico;
    }

    @Override
    public String getIdUnico() {
        return placa;
    }
}
