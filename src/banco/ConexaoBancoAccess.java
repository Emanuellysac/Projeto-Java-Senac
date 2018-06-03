package banco;
//A extensão do Driver é o JAR.

//Importando a classe connection, esta classe permite a conexão com um banco de dados.
import java.sql.Connection;
//Importando a classe de gerenciamento de drivers. Cadastro/ Consulta/ Exclusão/ Atualização.
import java.sql.DriverManager;
//Importando a classe de tratamento de erros de banco de dados
import java.sql.SQLException;

public class ConexaoBancoAccess {
	
	//Criação do objeto para permissão com o banco de dados.
	private Connection conexao;
	
	//Construtor
	public ConexaoBancoAccess() {
		//No inicio da execução do sistema o banco não recebe nenhum parâmetro.
		//Apenas quando o usuário deseja efetuar algum procedimento é que o banco é especificado.
		this.conexao = null;	
	}

	//Criação dos métodos Get e Set.
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	//Este método é responsável em fazer a abertura do banco de dados.
	public boolean abrirConexaoBanco() {
		
		boolean abriu = false;
		
		//Condição para caso o driver do banco não seja localizado.
		try {
			//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
		}catch (ClassNotFoundException erro) {
			
			System.out.println("O driver não foi localizado");	
		}
		
		//Condição para caso o banco não seja localizado. 
		try {
			this.conexao = DriverManager.getConnection(
				//	"jdbc:ucanaccess://D:\\EmanuellyJava\\Banco\\hthotelbd\\hthotelbd.accdb");
					"jdbc:sqlserver://localhost:1433;databaseName=hotel","sa","249871"
					 );
								
			abriu = true;	
		}catch (SQLException erro) {
			
			System.out.println("O banco não foi localizado");	
		}
		
		return abriu;
	}
	
	public boolean fecharConexaoBanco() {
		
		boolean fechou = false;
		
		if (this.conexao != null) {
			
			try {
				this.conexao.close();
				fechou = true;
				
			}catch (SQLException erro) {
				
				System.out.println("Erro ao tentar fechar a conexão.");		
			}
		}
		
		return fechou;
	}
	
}
