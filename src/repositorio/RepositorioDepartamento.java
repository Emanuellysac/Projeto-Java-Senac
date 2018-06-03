package repositorio;
//Importa��o da classe que manipula os c�digos insert, update e delete
import java.sql.Statement;

import banco.ConexaoBancoAccess;
import negocio.Departamento;

//Importa��o da classe que manipula as consultas Select
import java.sql.ResultSet;
//Importa��o da classe que faz o tratamento de erros de banco
import java.sql.SQLException;

public class RepositorioDepartamento {

	//Objeto que permite a conexao com um banco de dados
	private ConexaoBancoAccess conexao;
	
	//Construtor
	public RepositorioDepartamento() {
		//Instancia o objeto. Este objeto configura o banco para vazio null.
		this.conexao = new ConexaoBancoAccess();
		
	}
	
	//M�todo para VERIFICA��O se o registro j� existe
	public boolean departamentoExiste(String codigo) {
		boolean retorno = false;
			
		String codigoConsulta = "SELECT * FROM DEPARTAMENTO " +
										" WHERE CODIGO = '"+codigo+"'";
		//System.out.println(codigoConsulta);
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			if(resultado.next()) {
				retorno = true;
			}
			
		}catch(SQLException erro) {
			
			System.out.println("Erro ao verificar a exist�ncia do departamento");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return retorno;
	}
	
	//M�todo para ALTERAR dados
										//No objeto departamento cont�m todos os atributos designados a ele na classe.
	public boolean alterarDepartamento(Departamento departamento, String codigoAntigo) {
		boolean retorno = false;
		
		//Os atributos do objeto departamento � distribu�do a outras vari�veis.
		String codigo = departamento.getCodigo();
		String sigla = departamento.getSigla();
		String nome = departamento.getNomeDepartamento();
		String descricao = departamento.getDescricao();
		
		//Cria��o do c�digo para execu��o no banco
		String codigoAlterar = " UPDATE DEPARTAMENTO SET "+
							   " CODIGO = '"+codigo+"', "+
							   " SIGLA = '"+sigla+"', "+
							   " NOME = '"+nome+"', "+
							   " DESCRICAO = '"+descricao+"' "+
							   " WHERE CODIGO= '"+codigoAntigo+"'";
			
		this.conexao.abrirConexaoBanco();
		
		try {
			
			//Preparando o banco
			Statement instrucao = this.conexao.getConexao().createStatement();
			//Executando a instru��o
			instrucao.executeUpdate(codigoAlterar);
			retorno = true;
			
		}catch(SQLException erro) {
			
			System.out.println("Erro ao tentar alterar as informa��es do departamento");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return retorno;
				
	}
	
	//C�digo para EXCLUIR um departamento
	public boolean excluirDepartamento(String codigo) {
		boolean retorno = false;
	
		String codigoExcluir = "DELETE FROM DEPARTAMENTO "+
						   " WHERE CODIGO = '"+codigo+"'";
	
	this.conexao.abrirConexaoBanco();
	
	try {
		Statement instrucao = this.conexao.getConexao().createStatement();
		instrucao.executeUpdate(codigoExcluir);
			retorno = true;
			
	}catch(SQLException erro) {
		
		System.out.println("Erro ao tentar deletar as informa��es do departamento");
	}
	
	this.conexao.fecharConexaoBanco();
	return retorno;
	
	}
	
	//Codigo de CADASTRAR o departamento
  	public boolean cadatrarDepartamento(Departamento departamento) {
		boolean cadastrou = false;
		
		String codigo = departamento.getCodigo();
		String sigla = departamento.getSigla();
		String nome = departamento.getNomeDepartamento();
		String descricao = departamento.getDescricao();
		
		String codigoCadastro = "INSERT INTO DEPARTAMENTO" + 
								"(CODIGO, SIGLA, NOME, DESCRICAO) VALUES"+ 
								"('"+codigo+"', '"+sigla+"','"+nome+"', '"+descricao+"')";
		
		//Abrindo a conex�o com o banco de dados. Semelhante a abrir o programa Access
		conexao.abrirConexaoBanco();
		
		try {
			
			//Depois de abrir o programa access (internamente), essa instru��o prepara o acess para receber o c�digo a ser executado.
			//Semelhante a clicar na aba Criar, em seguida escolher a op��o Design da Consulta, Fechar a janela, Mostrar tabela e Clicar na op��o SQL.
			Statement instrucaoSQL = conexao.getConexao().createStatement();
			
			//Essa op��o corresponde a digitar o codigo a ser executado na janela do acces e em seguida clicar no bot�o Executar.
			instrucaoSQL.executeUpdate(codigoCadastro);
			
			cadastrou = true;
			
		//Fechar a conex�o com o banco.
			conexao.fecharConexaoBanco();
			
		}catch (SQLException erro) {
			
			System.out.println("Erro na prepara��o da instru��o SQL" + erro);
		}
				
		return cadastrou;	
	}
	
	//M�todo de CONSULTAR o departamento pelo CODIGO
	public Departamento consultaDepartamentoCodigo(String codigo) {
		
		//Constru��o do objeto vazio para posterior recebimento das informa��es
		Departamento departamento = new Departamento();
		
		String codigoConsulta = "SELECT * FROM DEPARTAMENTO" +
		" WHERE CODIGO = '"+codigo+"'";
		
		//Abrir a conex�o com o banco de dados
		this.conexao.abrirConexaoBanco();
		
		try {
			
			//Prepara o banco para receber a instru��o
			Statement instrucao = this.conexao.getConexao().createStatement();
			
			//A vari�vel resultado armazena as instru��es em forma de tabela ap�s a execu��o da instru��o pelo banco
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			
			//Instru��o para retornar um �nico registro
			resultado.next();
			
			//Para armazenar as informa��es capturadas da tabela; Cada nome em azul refere-se a uma coluna da tabela
			codigo = resultado.getString("CODIGO");
			String sigla = resultado.getString("SIGLA");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
			
			//Inser��o no objeto das informa��es coletadas
			departamento.setCodigo(codigo);
			departamento.setSigla(sigla);
			departamento.setNomeDepartamento(nome);
			departamento.setDescricao(descricao);
			
		}catch(SQLException erro) {
			System.out.println("Erro na consulta ao departamento");	
		}
		
		//Fechando a conex�o
		this.conexao.fecharConexaoBanco();
		
		return departamento;
	}
	
	//M�todo de CONSULTAR o departamento pela SIGLA
	public Departamento consultaDepartamentoSigla(String sigla) {
	
		//Constru��o do objeto vazio para posterior recebimento das informa��es
		Departamento departamento = new Departamento();
	
		String siglaConsulta = "SELECT * FROM DEPARTAMENTO" +
								" WHERE SIGLA = '"+sigla+"'";
	
		//Abrir a conex�o com o banco de dados
		this.conexao.abrirConexaoBanco();
	
		try {
		
			//Prepara o banco para receber a instru��o
			Statement instrucao = this.conexao.getConexao().createStatement();
		
			//A vari�vel resultado armazena as instru��es em forma de tabela ap�s a execu��o da instru��o pelo banco
			ResultSet resultado = instrucao.executeQuery(siglaConsulta);
		
			//Instru��o para retornar um �nico registro
			resultado.next();
	
			//Para armazenar as informa��es capturadas da tabela; Cada nome em azul refere-se a uma coluna da tabela
			String codigo = resultado.getString("CODIGO");
			sigla = resultado.getString("SIGLA");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
		
			//Inser��o no objeto das informa��es coletadas
			departamento.setCodigo(codigo);
			departamento.setSigla(sigla);
			departamento.setNomeDepartamento(nome);
			departamento.setDescricao(descricao);
		
		}catch(SQLException erro) {
			
		System.out.println("Erro na consulta ao departamento");	
		
		/*Ap�s a estrutura��o de todo m�todo de counsulta:
		public Departamento consultaDepartamentoCodigo(String codigo) ou public Departamento consultaDepartamentoSigla(String sigla),
		� preciso declarar dentro do c�digo: public void eventoBotaoLocalizar(), localizado na TelaDepartamento, o reposit�rio do departamento,
		para retorno das informa��es do banco e dentro das condi��es IF ou ELSE, declarar um objeto e as fun��es para retorno das informa��es a tela.*/
		
		}
	
	//Fechando a conex�o
	this.conexao.fecharConexaoBanco();
	
	return departamento;
}
	//Utilizado para o combobox da telaFuncionario
	public int quantidadeDepartamento() {
		int quantidade = 0;
		
		//Para capturar a quantidade de departamentos que existem cadastrado
		//Ser� utilizado para definir o tamanho do vetor
		String codigoConsulta =
				"SELECT COUNT(ID) AS QUANTIDADE FROM DEPARTAMENTO";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			resultado.next();
			quantidade = resultado.getInt("QUANTIDADE");
			
		}catch (SQLException erro){
			
			System.out.println("Erro na consulta de quantidade.");
			
		}
		
		this.conexao.fecharConexaoBanco();
		
		return quantidade;
	}	
	
	//Cria o vetor e lan�a as informa��es solicitadas para cada posi��o dele
	public String [] listarDepartamentos() {
		
		int quantidade = quantidadeDepartamento();
		String [] listaDepartamentos = new String[quantidade];
		
		String consultaDepartamento = "SELECT SIGLA FROM DEPARTAMENTO";
		
		int posicao = 0;
		
		this.conexao.abrirConexaoBanco();
		
		try {
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(consultaDepartamento);
			while (resultado.next()) {
				listaDepartamentos[posicao] = resultado.getString("SIGLA");
				posicao = posicao + 1;
			}
			
		} catch (SQLException erro) {
			
			System.out.println("Erro na consulta de quantidade.");		
		}
		this.conexao.fecharConexaoBanco();
		
		return listaDepartamentos;
	
	}
	
	//M�todo para associar o c�digo(String) do departamento selecionado ao ID(Int) dele
	public int consultarIdDepartamento(String sigla) {
		
		int id = 0;
		
		String codigoConsultaID = "SELECT ID FROM DEPARTAMENTO "+
									"WHERE SIGLA = '"+sigla+"'";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsultaID);
			resultado.next();
			id = resultado.getInt("ID");
			
		}catch(SQLException erro) {
			
			System.out.println("Erro ao tentar localizar o ID.");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return id;
		
	}
	
	//M�todo para localizar e devolver a Sigla do departamento atr�ves do IdDepartamento. 
	//Ele ir� localizar o IdDepartamento capturado pelo m�todo de consulta, que encontra na TelaDepartamento,
	//processa as informa��es no m�todo abaixo e devolve o Id do departamento.
	public String consultaSiglaDepartamento(int idDepartamento) {
		
		String sigla= "";
		
		String consultaSigla = "SELECT SIGLA FROM DEPARTAMENTO "+
								"WHERE ID = "+idDepartamento;
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(consultaSigla);
			resultado.next();
			sigla = resultado.getString("SIGLA");
			
		}catch (SQLException erro) {
			
			System.out.println("Erro na consulta da silgla");
			
		}
		
		this.conexao.fecharConexaoBanco();
		return sigla;
	}
}


