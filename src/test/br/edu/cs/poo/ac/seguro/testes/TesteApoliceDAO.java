package br.edu.cs.poo.ac.seguro.testes;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import br.edu.cs.poo.ac.seguro.entidades.*;
import br.edu.cs.poo.ac.seguro.daos.*;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();
    private VeiculoDAO daoV = new VeiculoDAO();
    //traz os DAOS que vão ser utilizados nos testes

    protected Class getClasse() {
        return br.edu.cs.poo.ac.seguro.entidades.Apolice.class;
    }
    //"Ei, TesteDAO, a entidade que esse teste vai manipular é Apolice.class."

    String placa = "0000";
    Veiculo veiculo = new Veiculo(placa, 2000, null, null, CategoriaVeiculo.BASICO);
    String numero = "000";
    LocalDate dataInicio = LocalDate.now();
    BigDecimal franquia = new BigDecimal("1000.00");
    BigDecimal premio = new BigDecimal("500.00");
    BigDecimal maximo = new BigDecimal("30000.00");

    @Test
    public void test01() {

        Apolice apolice = new Apolice(numero, veiculo, franquia, premio, maximo, dataInicio);

        assertEquals(veiculo, apolice.getVeiculo());
        assertEquals(franquia, apolice.getValorFranquia());
        assertEquals(premio, apolice.getValorPremio());
        assertEquals(maximo, apolice.getValorMaximoSegurado());
    }

    @Test
    public void teste02() {
        Apolice apolice = new Apolice(numero,null, null, null, null, dataInicio);
        apolice.setNumero("AP123");

        assertEquals("AP123", apolice.getNumero());
    }

    @Test
    public void teste03() {
        Apolice apolice = new Apolice(numero, null, null, null, null, dataInicio);
        Veiculo veiculo = new Veiculo(placa, 2000, null, null, CategoriaVeiculo.BASICO);
        apolice.setVeiculo(veiculo);

        assertEquals(veiculo, apolice.getVeiculo());
    }

    @Test
    public void teste04() {
        Apolice apolice = new Apolice(numero,null, null, null, null, dataInicio);
        BigDecimal franquia = new BigDecimal("1200.00");
        apolice.setValorFranquia(franquia);

        assertEquals(franquia, apolice.getValorFranquia());
    }

    @Test
    public void teste05() {
        Apolice apolice = new Apolice(numero, null, null, null, null, dataInicio);
        BigDecimal premio = new BigDecimal("450.00");
        apolice.setValorPremio(premio);

        assertEquals(premio, apolice.getValorPremio());
    }

    @Test
    public void teste06() {
        Apolice apolice = new Apolice(numero, null, null, null, null, dataInicio);
        BigDecimal maximo = new BigDecimal("50000.00");
        apolice.setValorMaximoSegurado(maximo);

        assertEquals(maximo, apolice.getValorMaximoSegurado());
    }

    @Test
    public void teste07() {
        Veiculo veiculoInicial = new Veiculo(placa, 2000, null, null, CategoriaVeiculo.BASICO);
        Apolice apolice = new Apolice(numero, veiculoInicial, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, dataInicio);

        Veiculo novoVeiculo = new Veiculo(placa, 2000, null, null, CategoriaVeiculo.BASICO);
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
    public void teste08() {
        Apolice apolice = new Apolice(numero, null, null, null, null, dataInicio);

        assertNull(apolice.getVeiculo());
        assertNull(apolice.getValorFranquia());
        assertNull(apolice.getValorPremio());
        assertNull(apolice.getValorMaximoSegurado());
        assertNull(apolice.getNumero());
    }
}
