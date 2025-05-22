package br.edu.cs.poo.ac.seguro.entidades;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Data
public class Apolice implements Registro {
    private static final long serialVersionUID = 1L;

    private String numero;
    private Veiculo veiculo;
    private BigDecimal valorFranquia;
    private BigDecimal valorPremio;
    private BigDecimal valorMaximoSegurado;
    private LocalDate dataInicioVigencia;
    private String idUnico;

    public Apolice(String numero, Veiculo veiculo, BigDecimal valorFranquia, BigDecimal valorPremio, BigDecimal valorMaximoSegurado, LocalDate dataInicioVigencia) {
		this.numero = numero;
        this.veiculo = veiculo;
        this.valorFranquia = valorFranquia;
        this.valorPremio = valorPremio;
        this.valorMaximoSegurado = valorMaximoSegurado;
        this.dataInicioVigencia = dataInicioVigencia;
}

    public Apolice(String idUnico) {
        this.idUnico = idUnico;
    }

    @Override
    public String getIdUnico() {
        return numero;
    }
}