package repositorio;
//Para conexao com o banco de dados.

import java.sql.Statement;

import banco.ConexaoBancoAccess;
import negocio.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUsuario {
	
	private ConexaoBancoAccess conexao;
	
	public RepositorioUsuario() {
		this.conexao = new ConexaoBancoAccess();
		
	}
	
	public boolean cadastroUsuario(Usuario usuario) {
		boolean resposta = false;
		
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String tipo = usuario.getTipo();
		String cpf = usuario.getCpf();
		
		String codigoCadastro = "INSERT INTO USUARIO "+
								"(LOGIN, SENHA, TIPO, CPF) VALUES "+
								"('"+login+"','"+senha+"','"+tipo+"','"+cpf+"')";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			Statement instrucao = this.conexao.getConexao().createStatement();
			instrucao.executeUpdate(codigoCadastro);
			resposta = true;
			
		}catch (SQLException erro) {
			
			System.out.println("Erro no cadastro do usuário.");	
		}
		
		this.conexao.fecharConexaoBanco();
				
		return resposta;
	
	}
	
	public boolean validarLogin(String login, String senha) {
		boolean resposta = false;
		
		String codigoConsulta = "SELECT * FROM USUARIO "+
								"WHERE LOGIN = '"+login+"' AND SENHA = '"+senha+"'";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			if(resultado.next()) {
				resposta = true;	
			}
		}catch(Exception erro) {
			System.out.println("Erro na validação do usuário" + erro);
		}
		
		this.conexao.fecharConexaoBanco();
		
		return resposta;		
		
	}

} 
