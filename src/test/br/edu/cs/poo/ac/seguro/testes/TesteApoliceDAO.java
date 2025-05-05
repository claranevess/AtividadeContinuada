package br.edu.cs.poo.ac.seguro.testes;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApoliceTest {

    @Test
    public void deveCriarApoliceComValores() {
        Veiculo veiculo = new Veiculo();
        BigDecimal franquia = new BigDecimal("1000.00");
        BigDecimal premio = new BigDecimal("500.00");
        BigDecimal maximo = new BigDecimal("30000.00");

        Apolice apolice = new Apolice(veiculo, franquia, premio, maximo);

        assertEquals(veiculo, apolice.getVeiculo());
        assertEquals(franquia, apolice.getValorFranquia());
        assertEquals(premio, apolice.getValorPremio());
        assertEquals(maximo, apolice.getValorMaximoSegurado());
    }

    @Test
    public void deveSetarEObterNumero() {
        Apolice apolice = new Apolice(null, null, null, null);
        apolice.setNumero("AP123");

        assertEquals("AP123", apolice.getNumero());
    }

    @Test
    public void deveSetarEObterVeiculo() {
        Apolice apolice = new Apolice(null, null, null, null);
        Veiculo veiculo = new Veiculo();
        apolice.setVeiculo(veiculo);

        assertEquals(veiculo, apolice.getVeiculo());
    }

    @Test
    public void deveSetarEObterValorFranquia() {
        Apolice apolice = new Apolice(null, null, null, null);
        BigDecimal franquia = new BigDecimal("1200.00");
        apolice.setValorFranquia(franquia);

        assertEquals(franquia, apolice.getValorFranquia());
    }

    @Test
    public void deveSetarEObterValorPremio() {
        Apolice apolice = new Apolice(null, null, null, null);
        BigDecimal premio = new BigDecimal("450.00");
        apolice.setValorPremio(premio);

        assertEquals(premio, apolice.getValorPremio());
    }

    @Test
    public void deveSetarEObterValorMaximoSegurado() {
        Apolice apolice = new Apolice(null, null, null, null);
        BigDecimal maximo = new BigDecimal("50000.00");
        apolice.setValorMaximoSegurado(maximo);

        assertEquals(maximo, apolice.getValorMaximoSegurado());
    }

    @Test
    public void deveAlterarAtributosDepoisDoConstrutor() {
        Veiculo veiculoInicial = new Veiculo();
        Apolice apolice = new Apolice(veiculoInicial, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

        Veiculo novoVeiculo = new Veiculo();
        apolice.setVeiculo(novoVeiculo);
        apolice.setValorFranquia(new BigDecimal("1500.00"));
        apolice.setValorPremio(new BigDecimal("700.00"));
        apolice.setValorMaximoSegurado(new BigDecimal("40000.00"));
        apolice.setNumero("AP999");

        assertEquals(novoVeiculo, apolice.getVeiculo());
        assertEquals(new BigDecimal("1500.00"), apolice.getValorFranquia());
        assertEquals(new BigDecimal("700.00"), apolice.getValorPremio());
        assertEquals(new BigDecimal("40000.00"), apolice.getValorMaximoSegurado());
        assertEquals("AP999", apolice.getNumero());
    }

    @Test
    public void deveAceitarValoresNulos() {
        Apolice apolice = new Apolice(null, null, null, null);

        assertNull(apolice.getVeiculo());
        assertNull(apolice.getValorFranquia());
        assertNull(apolice.getValorPremio());
        assertNull(apolice.getValorMaximoSegurado());
        assertNull(apolice.getNumero());
    }
}
