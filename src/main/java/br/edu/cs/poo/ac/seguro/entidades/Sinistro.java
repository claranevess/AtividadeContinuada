package br.edu.cs.poo.ac.seguro.entidades;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class Sinistro{
    private String numero;
    private Veiculo veiculo;
    private LocalDateTime dataHoraSinistro;
    private LocalDateTime dataHoraRegistro;
    private String usuarioRegistro;
    private BigDecimal valorSinistro;
    private TipoSinistro tipo;

    public Sinistro(BigDecimal valorSinistro,Veiculo veiculo,LocalDateTime dataHoraSinistro,LocalDateTime dataHoraRegistro,String usuarioRegistro,TipoSinistro tipo) {
		this.veiculo= veiculo;
        this.dataHoraSinistro=dataHoraSinistro;
        this.dataHoraRegistro=dataHoraRegistro;
        this.usuarioRegistro=usuarioRegistro;
        this.valorSinistro=valorSinistro;
        this.tipo=tipo;
}
}
