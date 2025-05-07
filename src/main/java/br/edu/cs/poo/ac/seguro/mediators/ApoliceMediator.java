package br.edu.cs.poo.ac.seguro.mediators;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.cs.poo.ac.seguro.daos.*;
import br.edu.cs.poo.ac.seguro.entidades.*;

public class ApoliceMediator {
    private SeguradoPessoaDAO daoSegPes = new SeguradoPessoaDAO();
    private SeguradoEmpresaDAO daoSegEmp = new SeguradoEmpresaDAO();
    private VeiculoDAO daoVel = new VeiculoDAO();
    private ApoliceDAO daoApo = new ApoliceDAO();
    private SinistroDAO daoSin = new SinistroDAO();

    private static ApoliceMediator instancia = new ApoliceMediator();

    public static ApoliceMediator getInstancia() {
        return instancia;
    }

    private String numeroApolice(DadosVeiculo dados){
        String cpfOuCnpj = dados.getCpfOuCnpj();
        int anoatual = java.time.Year.now().getValue();
        String placa = dados.getPlaca();
        String numeroDaApolice;

        if(ValidadorCpfCnpj.ehCpfValido(cpfOuCnpj)){
            //ano atual + "000" + cpfOuCnpj + placa
            numeroDaApolice = anoatual + "000" + cpfOuCnpj + placa;
            return numeroDaApolice;
        }
        else if (ValidadorCpfCnpj.ehCnpjValido(cpfOuCnpj)){
            //número da apólice  = ano atual + cpfOuCnpj + placa
            numeroDaApolice = anoatual + cpfOuCnpj + placa;
            return numeroDaApolice;
        }
        return null;
    }

    private ApoliceMediator() {}
    /*
     * Algumas regras de validação e lógicas devem ser inferidas através da leitura e
     * do entendimento dos testes automatizados. Seguem abaixo explicações pertinentes
     * e necessárias ao entendimento completo de como este método deve funcionar.
     *
     *  Toda vez que um retorno contiver uma mensagem de erro não nula, significando
     *  que a apólice não foi incluída, o numero da apólice no retorno deve ser nulo.
     *
     *  Toda vez que um retorno contiver uma mensagem de erro não nula, significando
     *  que a apólice não foi incluída, o numero da apólice no retorno deve ser nulo.
     *
     *  Toda vez que um retorno contiver uma mensagem de erro nula, significando
     *  que a apólice foi incluída com sucesso, o numero da apólice no retorno deve ser
     *  o número da apólice incluída.
     *
     * CHECK À clase Apolice, deve ser acrescentado (com seus respectivos get/set e presença
     * dele no construtor) o atributo LocalDate dataInicioVigencia.
     *
     * CHECK O número da apólice é igual a:
     * Se cpfOuCnpj de dados for um CPF
     *     número da apólice  = ano atual + "000" + cpfOuCnpj + placa
     * Se cpfOuCnpj de dados for um CNPJ
     *     número da apólice  = ano atual + cpfOuCnpj + placa
     *
     * CHECK O valor do prêmio é calculado da seguinte forma
     * (A) Calcula-se VPA = (3% do valor máximo segurado)
     * (B) Calcula-se VPB = 1.2*VPA, se segurado for empresa e indicador de locadora
     *     for true; ou VPB = VPA, caso contrário.
     * (C) Calcula-se VPC = VPB - bonus/10.
     * (D) Calcula-se valor do prêmio = VPC, se VPC > 0; ou valor do prêmio = 0, se
     *     VPC <=0.
     *
     * CHECK O valor da franquia é igual a 130% do VPB.
     *
     * Após validar a nulidade de dados e da placa, fazer a busca do veículo por placa.
     * Se o veículo não existir, realizar todas as valiações pertinentes
     * Se o veículo existir, realizar as validações de cpf/cnpj e de valor máximo, e a verificação
     * de apólice já existente (busca de apólice por número).
     *
     * ASSOCIAÇÂO DE VEICULO COM SEGURADOS: buscar segurado empresa por CNPJ OU segura pessoa por CPF.
     * Se não for encontrado, retornar mensagem de erro, Se for encontrado, associar ao veículo.
     *
     * Se o veículo não existir (busca no dao de veículos por placa), ele deve ser incluído
     * no dao de veículos com as informações recebidas em dados
     * Se o veículo existir, (busca no dao de veículos por placa), ele deve ser alterado no
     * dao de veículos, mudando-se apenas os segurado empresa e segurado pessoa, cujo cpf ou
     * cnpj foi recebido em dados. Estes devem ser atualizados em veículo após validações
     * de cpf/cnpj e busca deles a partir dos mediators de segurado empresa e de segurado
     * pessoa.
     *
     * Após todos os dados validados, e o veículo incluído ou alterado, deve-se instanciar
     * um objeto do tipo Apolice, e incluí-lo no dao de apolice.
     *
     * Após a inclusão bem sucedida da apólice, deve-se bonficar o segurado, se for o caso.
     * O segurado, pessoa ou empresa, a depender do cpf ou do cnpj recebido em dados, vai
     * ter direito a crédito no bônus se seu cpf ou cnpj não tiver tido sinistro cadastrado
     * no ano anterior à data de início de vigência da apólice.
     * Para inferir isto, deve-se usar um novo método, a ser criado no SinistroDAO,
     * public Sinistro[] buscarTodos() e, com o resultado, verificar se existe pelos menos
     * um sinistro cujo veículo está associado ao cpf ou ao cnpj do segurado da apólice,
     * e o ano da data e hora do sinistro seja igual à data de início de vigência da apólice
     * menos um. Se existir, não haverá bônus. Caso contrário, deve-se acrescer 30% do valor do
     * prêmio da apólice ao bônus do segurado pessoa ou segurado empresa, e finalmente alterar o
     * segurado pessoa ou segurado empresa no seu respectivo DAO.
     *
     * OBS: TODOS os atributos do tipo BigDecimal devem ser gravados com 02 casas decimais (usar
     * o método setScale). Se isto não ocorrer, alguns testes vão quebrar.
     */

    /*
    * Toda vez que um retorno contiver uma mensagem de erro não nula, significando
       que a apólice não foi incluída, o numero da apólice no retorno deve ser nulo.

       Toda vez que um retorno contiver uma mensagem de erro não nula, significando
       que a apólice não foi incluída, o numero da apólice no retorno deve ser nulo.

       Toda vez que um retorno contiver uma mensagem de erro nula, significando
       que a apólice foi incluída com sucesso, o numero da apólice no retorno deve ser
       o número da apólice incluída.*/
    public RetornoInclusaoApolice incluirApolice(DadosVeiculo dados) {

        return null;
    }
    /*
     * Ver os testes test19 e test20
     */
    public Apolice buscarApolice(String numero) {
        return daoApo.buscar(numero);
    }

    public String excluirApolice(String numero) {
        if (numero == null || numero.isBlank()) {
            return "Número inválido.";
        }

        Apolice apolice = daoApo.buscar(numero);
        if (apolice == null) {
            return "Apólice inexistente.";
        }

        Veiculo veiculo = daoVel.buscar(apolice.getPlacaVeiculo());
        Sinistro[] sinistros = daoSin.buscarTodos();
        int anoApolice = apolice.getDataInicioVigencia().getYear();

        for (Sinistro s : sinistros) {
            if (s.getVeiculo().equals(veiculo) && s.getDataHora().getYear() == anoApolice) {
                return "Existe sinistro no ano da apólice para o mesmo veículo.";
            }
        }

        daoApo.excluir(numero);
        return null;
    }

    /*Após validar a nulidade de dados e da placa, fazer a busca do veículo por placa.
      Se o veículo não existir, realizar todas as valiações pertinentes
      Se o veículo existir, realizar as validações de cpf/cnpj e de valor máximo, e a verificação
      de apólice já existente (busca de apólice por número).*/
    private String validarTodosDadosVeiculo(DadosVeiculo dados) {
        String placa = dados.getPlaca();
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        if(dados != null){
            if(placa != null){
                Veiculo veiculo = veiculoDAO.buscar(dados.getPlaca()); /*não dava pra fazer veiculoDAO = veiculoDAO.buscar(dados.getPlaca());
                porque essa busca vai retornar um veiculo, e não um veiculoDAO. exemplo da biblioteca e livros.*/
            }
            else{

            }
        }

        return null;
    }
    private String validarCpfCnpjValorMaximo(DadosVeiculo dados) {

        return null;
    }
    private BigDecimal obterValorMaximoPermitido(int ano, int codigoCat) {
        return null;
    }

    private BigDecimal calcularPremio(Apolice dadosApolice, SeguradoEmpresa indicadorLocadora, DadosVeiculo dados, Segurado dadosSegurado){
        BigDecimal valorMaximoSegurado = dadosApolice.getValorMaximoSegurado();
        boolean ehLocadoraDeVeiculos = indicadorLocadora.getehLocadoraDeVeiculos();
        BigDecimal bonus = dadosSegurado.getBonus();
        BigDecimal valorPremio = dadosApolice.getValorPremio();
        BigDecimal valorFranquia = dadosApolice.getValorFranquia();
        BigDecimal porcentagem = new BigDecimal("0.03");
        BigDecimal VPA = valorMaximoSegurado.multiply(porcentagem);
        BigDecimal VPB;

        if(ehLocadoraDeVeiculos){ //se ele é uma locadora automaticamente já é uma empresa
            BigDecimal porcetagemVPB = new BigDecimal("1.2");
            VPB = VPA.multiply(porcetagemVPB);
        }
        else{
            VPB = VPA;
        }

        BigDecimal VPC = VPB.subtract(bonus.divide(BigDecimal.TEN));

        if(VPC.compareTo(BigDecimal.ZERO) > 0){
            valorPremio = VPC;
        } else {
            valorPremio = BigDecimal.ZERO;
        }

        BigDecimal porcentagemValorFranquia = new BigDecimal("1.3");
        valorFranquia = VPB.multiply(porcentagemValorFranquia);

        return null;
    }
}
