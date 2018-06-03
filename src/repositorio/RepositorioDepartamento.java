package repositorio;
//Importação da classe que manipula os códigos insert, update e delete
import java.sql.Statement;

import banco.ConexaoBancoAccess;
import negocio.Departamento;

//Importação da classe que manipula as consultas Select
import java.sql.ResultSet;
//Importação da classe que faz o tratamento de erros de banco
import java.sql.SQLException;

public class RepositorioDepartamento {

	//Objeto que permite a conexao com um banco de dados
	private ConexaoBancoAccess conexao;
	
	//Construtor
	public RepositorioDepartamento() {
		//Instancia o objeto. Este objeto configura o banco para vazio null.
		this.conexao = new ConexaoBancoAccess();
		
	}
	
	//Método para VERIFICAÇÃO se o registro já existe
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
			
			System.out.println("Erro ao verificar a existência do departamento");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return retorno;
	}
	
	//Método para ALTERAR dados
										//No objeto departamento contém todos os atributos designados a ele na classe.
	public boolean alterarDepartamento(Departamento departamento, String codigoAntigo) {
		boolean retorno = false;
		
		//Os atributos do objeto departamento é distribuído a outras variáveis.
		String codigo = departamento.getCodigo();
		String sigla = departamento.getSigla();
		String nome = departamento.getNomeDepartamento();
		String descricao = departamento.getDescricao();
		
		//Criação do código para execução no banco
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
			//Executando a instrução
			instrucao.executeUpdate(codigoAlterar);
			retorno = true;
			
		}catch(SQLException erro) {
			
			System.out.println("Erro ao tentar alterar as informações do departamento");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return retorno;
				
	}
	
	//Código para EXCLUIR um departamento
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
		
		System.out.println("Erro ao tentar deletar as informações do departamento");
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
		
		//Abrindo a conexão com o banco de dados. Semelhante a abrir o programa Access
		conexao.abrirConexaoBanco();
		
		try {
			
			//Depois de abrir o programa access (internamente), essa instrução prepara o acess para receber o código a ser executado.
			//Semelhante a clicar na aba Criar, em seguida escolher a opção Design da Consulta, Fechar a janela, Mostrar tabela e Clicar na opção SQL.
			Statement instrucaoSQL = conexao.getConexao().createStatement();
			
			//Essa opção corresponde a digitar o codigo a ser executado na janela do acces e em seguida clicar no botão Executar.
			instrucaoSQL.executeUpdate(codigoCadastro);
			
			cadastrou = true;
			
		//Fechar a conexão com o banco.
			conexao.fecharConexaoBanco();
			
		}catch (SQLException erro) {
			
			System.out.println("Erro na preparação da instrução SQL" + erro);
		}
				
		return cadastrou;	
	}
	
	//Método de CONSULTAR o departamento pelo CODIGO
	public Departamento consultaDepartamentoCodigo(String codigo) {
		
		//Construção do objeto vazio para posterior recebimento das informações
		Departamento departamento = new Departamento();
		
		String codigoConsulta = "SELECT * FROM DEPARTAMENTO" +
		" WHERE CODIGO = '"+codigo+"'";
		
		//Abrir a conexão com o banco de dados
		this.conexao.abrirConexaoBanco();
		
		try {
			
			//Prepara o banco para receber a instrução
			Statement instrucao = this.conexao.getConexao().createStatement();
			
			//A variável resultado armazena as instruções em forma de tabela após a execução da instrução pelo banco
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			
			//Instrução para retornar um único registro
			resultado.next();
			
			//Para armazenar as informações capturadas da tabela; Cada nome em azul refere-se a uma coluna da tabela
			codigo = resultado.getString("CODIGO");
			String sigla = resultado.getString("SIGLA");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
			
			//Inserção no objeto das informações coletadas
			departamento.setCodigo(codigo);
			departamento.setSigla(sigla);
			departamento.setNomeDepartamento(nome);
			departamento.setDescricao(descricao);
			
		}catch(SQLException erro) {
			System.out.println("Erro na consulta ao departamento");	
		}
		
		//Fechando a conexão
		this.conexao.fecharConexaoBanco();
		
		return departamento;
	}
	
	//Método de CONSULTAR o departamento pela SIGLA
	public Departamento consultaDepartamentoSigla(String sigla) {
	
		//Construção do objeto vazio para posterior recebimento das informações
		Departamento departamento = new Departamento();
	
		String siglaConsulta = "SELECT * FROM DEPARTAMENTO" +
								" WHERE SIGLA = '"+sigla+"'";
	
		//Abrir a conexão com o banco de dados
		this.conexao.abrirConexaoBanco();
	
		try {
		
			//Prepara o banco para receber a instrução
			Statement instrucao = this.conexao.getConexao().createStatement();
		
			//A variável resultado armazena as instruções em forma de tabela após a execução da instrução pelo banco
			ResultSet resultado = instrucao.executeQuery(siglaConsulta);
		
			//Instrução para retornar um único registro
			resultado.next();
	
			//Para armazenar as informações capturadas da tabela; Cada nome em azul refere-se a uma coluna da tabela
			String codigo = resultado.getString("CODIGO");
			sigla = resultado.getString("SIGLA");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
		
			//Inserção no objeto das informações coletadas
			departamento.setCodigo(codigo);
			departamento.setSigla(sigla);
			departamento.setNomeDepartamento(nome);
			departamento.setDescricao(descricao);
		
		}catch(SQLException erro) {
			
		System.out.println("Erro na consulta ao departamento");	
		
		/*Após a estruturação de todo método de counsulta:
		public Departamento consultaDepartamentoCodigo(String codigo) ou public Departamento consultaDepartamentoSigla(String sigla),
		é preciso declarar dentro do código: public void eventoBotaoLocalizar(), localizado na TelaDepartamento, o repositório do departamento,
		para retorno das informações do banco e dentro das condições IF ou ELSE, declarar um objeto e as funções para retorno das informações a tela.*/
		
		}
	
	//Fechando a conexão
	this.conexao.fecharConexaoBanco();
	
	return departamento;
}
	//Utilizado para o combobox da telaFuncionario
	public int quantidadeDepartamento() {
		int quantidade = 0;
		
		//Para capturar a quantidade de departamentos que existem cadastrado
		//Será utilizado para definir o tamanho do vetor
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
	
	//Cria o vetor e lança as informações solicitadas para cada posição dele
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
	
	//Método para associar o código(String) do departamento selecionado ao ID(Int) dele
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
	
	//Método para localizar e devolver a Sigla do departamento atráves do IdDepartamento. 
	//Ele irá localizar o IdDepartamento capturado pelo método de consulta, que encontra na TelaDepartamento,
	//processa as informações no método abaixo e devolve o Id do departamento.
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


