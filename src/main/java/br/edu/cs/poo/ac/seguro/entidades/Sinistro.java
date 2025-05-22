package br.edu.cs.poo.ac.seguro.entidades;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

@Data

public class Sinistro implements Registro{
    private String numero;
    private Veiculo veiculo;
    private LocalDateTime dataHoraSinistro;
    private LocalDateTime dataHoraRegistro;
    private String usuarioRegistro;
    private BigDecimal valorSinistro;
    private TipoSinistro tipo;
    private int sequencial;
    private String numeroApolice;
    private String idUnico;

    public Sinistro(BigDecimal valorSinistro,Veiculo veiculo,LocalDateTime dataHoraSinistro,LocalDateTime dataHoraRegistro,String usuarioRegistro,TipoSinistro tipo) {
        this.veiculo= veiculo;
        this.dataHoraSinistro=dataHoraSinistro;
        this.dataHoraRegistro=dataHoraRegistro;
        this.usuarioRegistro=usuarioRegistro;
        this.valorSinistro=valorSinistro;
        this.tipo=tipo;
    }

    public Sinistro(String idUnico) {
        this.idUnico = idUnico;
    }

    @Override
    public String getIdUnico() {
        return numero;
    }
}