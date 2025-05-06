package br.edu.cs.poo.ac.seguro.mediators;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.edu.cs.poo.ac.seguro.entidades.Endereco;

public class SeguradoMediator {
    private static SeguradoMediator instancia;

    private SeguradoMediator() {}

    public static SeguradoMediator getInstancia() {
        if (instancia == null) {
            instancia = new SeguradoMediator();
        }
        return instancia;
    }

    public String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome inválido.";
        }
        return null;
    }

    public String validarEndereco(Endereco endereco) {
        if (endereco == null) {
            return "Endereço inválido.";
        }
        return null;
    }

    public String validarDataCriacao(LocalDate dataCriacao) {
        if (dataCriacao == null || dataCriacao.isAfter(LocalDate.now())) {
            return "Data de criação inválida.";
        }
        return null;
    }

    public BigDecimal ajustarDebitoBonus(BigDecimal bonus, BigDecimal valorDebito) {
        if (bonus == null || valorDebito == null) return valorDebito;
        BigDecimal resultado = valorDebito.subtract(bonus);
        return resultado.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : resultado;
    }
}

