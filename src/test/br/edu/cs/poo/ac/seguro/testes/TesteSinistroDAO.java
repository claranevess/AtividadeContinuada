package br.edu.cs.poo.ac.seguro.testes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;
import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;
import br.edu.cs.poo.ac.seguro.entidades.TipoSinistro;
import br.edu.cs.poo.ac.seguro.entidades.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TesteSinistroDAO extends TesteDAO {
	private SinistroDAO dao = new SinistroDAO();
	protected Class getClasse() {
		return Sinistro.class;
	}
	
	@Test
	public void teste01() { //buscar um sinistro existente
	    Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "00000000";
		cadastro.incluir(new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO), numero);
		Sinistro s = dao.buscar(numero);
		Assertions.assertNotNull(s); 
	}
	@Test
	public void teste02() { //Sinistro inexistente retorna nulo
	    Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "10000000";
		cadastro.incluir(new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO), numero);
		Sinistro s = dao.buscar("11000000");
		Assertions.assertNull(s);
	}
	@Test
	public void teste03() { //excluir um sinistro existente
	    Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "20000000";
		cadastro.incluir(new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO), numero);
		boolean ret = dao.excluir(numero);
		Assertions.assertTrue(ret);
	}
	@Test
	public void teste04() { //excluir um sinistro inexistente retorna falso
		Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "30000000";
		cadastro.incluir(new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO), numero);
		boolean ret = dao.excluir("31000000");
		Assertions.assertFalse(ret);
	}
	@Test
    public void teste05() { //incluir um sinistro novo
    String numero = "40000000";
    
    //criando os objetos
    Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
    LocalDateTime dataHoraSinistro = LocalDateTime.now();
    LocalDateTime dataHoraRegistro = LocalDateTime.now();
    BigDecimal valorSinistro = new BigDecimal("5000.00");
    
    // Criando o sinistro
    Sinistro sinistro = new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, "usuario.teste", valorSinistro, TipoSinistro.COLISAO);
    
    // Como o construtor não define o número, precisamos usar o setter
    sinistro.setNumero(numero);
    
    // Incluir e verificar resultados
    boolean ret = dao.incluir(sinistro); /*ret é uma variável que vai retornar true se deu certo ou
    false se deu errado. incluir é um método de DAO e (sinistro) foi criado lá em cima. o que tá
    acontecendo é que a gnt ta tentando salvar no armazenamento / banco de dados*/       
    Assertions.assertTrue(ret); //ta verificando se ret foi true. se não foi, o teste vai falhar aqui
    Sinistro s = dao.buscar(numero); /*s vai ser null se nenhum sinistro for encontrado com o número
    que a gente deu. ele guarda o objeto sinistro que foi criado. */
    Assertions.assertNotNull(s);        
}
	
	@Test
	public void teste06() { //incluir um Sinistro já existente retorna falso
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "50000000";
		Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		Sinistro s = new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO);
		cadastro.incluir(s, numero);
		boolean ret = dao.incluir(s);
		Assertions.assertFalse(ret);
	}
	@Test
	public void teste07() { // alterar um Sinistro inexistente retorna falso
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "60000000";			
		boolean ret = dao.alterar(new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null,valorSinistro, TipoSinistro.COLISAO));
		Assertions.assertFalse(ret);
		Sinistro s = dao.buscar(numero);
		Assertions.assertNull(s);		
	}
	
	@Test
	public void teste08() { //alterar um Sinistro existente
		LocalDateTime dataHoraSinistro = LocalDateTime.now();
		LocalDateTime dataHoraRegistro = LocalDateTime.now();
		BigDecimal valorSinistro = new BigDecimal("5000.00");
		String numero = "70000000";
		Veiculo veiculo = new Veiculo("ABC1234", 2020, null, null, CategoriaVeiculo.BASICO);
		Sinistro s = new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.COLISAO);
		cadastro.incluir(s, numero);
		s = new Sinistro(numero, veiculo, dataHoraSinistro, dataHoraRegistro, null, valorSinistro, TipoSinistro.DEPREDACAO);
		boolean ret = dao.alterar(s);
		Assertions.assertTrue(ret);
	}
}