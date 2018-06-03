package repositorio;
import java.sql.Statement;

import banco.ConexaoBancoAccess;
import negocio.Hospede;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioHospede {

	private ConexaoBancoAccess conexaoHo;
	
	public RepositorioHospede() {
		
		this.conexaoHo = new ConexaoBancoAccess();
		
	}
	
	public boolean cadatrarHospede(Hospede hospede) {
		boolean cadastrou = false;
		
		String nome = hospede.getNome();
		String cpf = hospede.getCpf();
		String dataNascimento = hospede.getDataNascimento();
		String sexo = hospede.getSexo();
		String estadoCivil = hospede.getEstadoCivil();
		String email = hospede.getEmail();
		String logradouro = hospede.getLogradouro();
		String numero = hospede.getNumero();
		String bairro = hospede.getBairro();
		String cep = hospede.getCep();
		String cidade = hospede.getCidade();
		String estado = hospede.getEstado();
		String complemento = hospede.getComplemento();
		String respFinanceiro = hospede.getRespFinanceiro();
		
		String codigoCadastro = "INSERT INTO HOSPEDE" + 
								"(NOME, CPF, DATANASCIMENTO, SEXO, ESTADOCIVIL, EMAIL, LOGRADOURO" +
								"NUMERO, BAIRRO, CEP, CIDADE, ESTADO, COMPLEMENTO, RESPFINNACEIRO) VALUES"+ 
								"('"+nome+"','"+cpf+"','"+dataNascimento+"','"+sexo+"', " +
								" '"+estadoCivil+"','"+email+"','"+logradouro+"','"+numero+"', " +
								" '"+bairro+"','"+cep+"','"+cidade+"','"+estado+"','"+complemento+"','"+respFinanceiro+"')";
		
		conexaoHo.abrirConexaoBanco();
		
		try {
			
			Statement instrucaoSQL = conexaoHo.getConexao().createStatement();
			
			instrucaoSQL.executeUpdate(codigoCadastro);
			
			cadastrou = true;
			
		conexaoHo.fecharConexaoBanco();
			
		}catch (SQLException erro) {
			
			System.out.println("Erro na preparação da instrução SQL");
		}
				
		return cadastrou;
		
	}
	
	
}

