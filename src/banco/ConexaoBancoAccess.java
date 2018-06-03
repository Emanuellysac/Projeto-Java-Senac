package banco;
//A extens�o do Driver � o JAR.

//Importando a classe connection, esta classe permite a conex�o com um banco de dados.
import java.sql.Connection;
//Importando a classe de gerenciamento de drivers. Cadastro/ Consulta/ Exclus�o/ Atualiza��o.
import java.sql.DriverManager;
//Importando a classe de tratamento de erros de banco de dados
import java.sql.SQLException;

public class ConexaoBancoAccess {
	
	//Cria��o do objeto para permiss�o com o banco de dados.
	private Connection conexao;
	
	//Construtor
	public ConexaoBancoAccess() {
		//No inicio da execu��o do sistema o banco n�o recebe nenhum par�metro.
		//Apenas quando o usu�rio deseja efetuar algum procedimento � que o banco � especificado.
		this.conexao = null;	
	}

	//Cria��o dos m�todos Get e Set.
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	//Este m�todo � respons�vel em fazer a abertura do banco de dados.
	public boolean abrirConexaoBanco() {
		
		boolean abriu = false;
		
		//Condi��o para caso o driver do banco n�o seja localizado.
		try {
			//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
		}catch (ClassNotFoundException erro) {
			
			System.out.println("O driver n�o foi localizado");	
		}
		
		//Condi��o para caso o banco n�o seja localizado. 
		try {
			this.conexao = DriverManager.getConnection(
				//	"jdbc:ucanaccess://D:\\EmanuellyJava\\Banco\\hthotelbd\\hthotelbd.accdb");
					"jdbc:sqlserver://localhost:1433;databaseName=hotel","sa","249871"
					 );
								
			abriu = true;	
		}catch (SQLException erro) {
			
			System.out.println("O banco n�o foi localizado");	
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
				
				System.out.println("Erro ao tentar fechar a conex�o.");		
			}
		}
		
		return fechou;
	}
	
}
