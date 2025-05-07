package br.edu.cs.poo.ac.seguro.entidades;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

@Data

public class Sinistro implements Serializable{
    private static final long serialVersionUID = 1L;

    private String numero;
    private Veiculo veiculo;
    private LocalDateTime dataHoraSinistro;
    private LocalDateTime dataHoraRegistro;
    private String usuarioRegistro;
    private BigDecimal valorSinistro;
    private TipoSinistro tipo;

    public Sinistro(String numero, Veiculo veiculo, LocalDateTime dataHoraSinistro, LocalDateTime dataHoraRegistro, String usuarioRegistro, BigDecimal valorSinistro, TipoSinistro tipo) {
		this.numero = numero;
        this.veiculo= veiculo;
        this.dataHoraSinistro=dataHoraSinistro;
        this.dataHoraRegistro=dataHoraRegistro;
        this.usuarioRegistro=usuarioRegistro;
        this.valorSinistro=valorSinistro;
        this.tipo=tipo;
}
}
