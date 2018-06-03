package repositorio;
import java.sql.Statement;

import banco.ConexaoBancoAccess;
import negocio.Apartamento;
import negocio.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioApartamento {
	
	private ConexaoBancoAccess conexao;
	
	public RepositorioApartamento() {
		this.conexao = new  ConexaoBancoAccess();
	}
	
	public boolean apartamentoExiste(String numero) {
		boolean retorno = false;
			
		String codigoConsulta = "SELECT * FROM APARTAMENTO " +
										" WHERE NUMERO = '"+numero+"'";
				
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			if(resultado.next()) {
				retorno = true;
			}
			
		}catch(SQLException erro) {
			
			System.out.println("Erro ao verificar a existência do apartamento");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return retorno;
	}
	
	public boolean cadastrarApartamento(Apartamento apartamento) {
		boolean cadastrou = false;
		
		int numero = apartamento.getNumero();
		int capacidadeMaxima = apartamento.getCapacidadeMaxima();
		double valor = apartamento.getValor();
		String categoria = apartamento.getCategoria();
		String descricao = apartamento.getDescricao();
		
		String codigoCadastro = "INSERT INTO APARTAMENTO" +
								"(NUMERO, CAPACIDADEMAXIMA, VALOR, CATEGORIA, DESCRICAO) VALUES" +
								"("+numero+", "+capacidadeMaxima+", "+valor+", '"+categoria+"', '"+descricao+"')";
		
		conexao.abrirConexaoBanco();
		
		try {	
	
			Statement instrucaoSQL = conexao.getConexao().createStatement();
			
			instrucaoSQL.executeUpdate(codigoCadastro);
			
			cadastrou = true;
			
			conexao.fecharConexaoBanco();
			
		}catch (SQLException erro) {
			
			System.out.println("Erro na preparação da instrução SQL");
		}
				
		return cadastrou;
		
	}
	
	public Apartamento consultaApartamentoNumero(String numero) {
			
			Apartamento apartamento = new Apartamento();
			
			String codigoConsulta = "SELECT * FROM APARTAMENTO" +
			" WHERE NUMERO = '"+numero+"'";
			
			this.conexao.abrirConexaoBanco();
			
			try {
				
				Statement instrucao = this.conexao.getConexao().createStatement();
				
				ResultSet resultado = instrucao.executeQuery(codigoConsulta);
				resultado.next();
				
				numero = resultado.getString("NUMERO");
				int numeroN = Integer.parseInt(numero);
				int capacidadeMaxima = resultado.getInt("CAPACIDADEMAXIMA");
				double valor = resultado.getDouble("VALOR");
				String categoria = resultado.getString("CATEGORIA");
				String descricao = resultado.getString("DESCRICAO");
				
				apartamento.setNumero(numeroN);
				apartamento.setCapacidadeMaxima(capacidadeMaxima);
				apartamento.setValor(valor);
				apartamento.setCategoria(categoria);
				apartamento.setDescricao(descricao);
				
			}catch(SQLException erro) {
				System.out.println("Erro na consulta ao apartamento");	
			}
			
			this.conexao.fecharConexaoBanco();
			
			return apartamento;
		}
	
	public boolean excluirApartamento(String numero) {
		boolean retorno = false;
	
		String codigoExcluir = "DELETE FROM APARTAMENTO "+
						   	   " WHERE NUMERO = "+numero+"";
	
	this.conexao.abrirConexaoBanco();
	
	try {
		Statement instrucao = this.conexao.getConexao().createStatement();
		instrucao.executeUpdate(codigoExcluir);
			retorno = true;
			
	}catch(SQLException erro) {
		
		System.out.println("Erro ao tentar deletar as informações do apartamento" + erro);
	}
	
	this.conexao.fecharConexaoBanco();
	return retorno;
	
	}
}
