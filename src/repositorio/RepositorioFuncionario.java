package repositorio;
import java.sql.Statement;

import javax.swing.JLabel;

import banco.ConexaoBancoAccess;
import negocio.Departamento;
import negocio.Funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioFuncionario {
	
	private ConexaoBancoAccess conexao;
	
	public RepositorioFuncionario() {
		this.conexao = new ConexaoBancoAccess();
	}
	
	//Para verificar se o CPF já está cadastrado
	public boolean funcionarioExiste(String cpf) {
		boolean existe = false;
		
		String consultarFuncionario = "SELECT * FROM FUNCIONARIO " +
				" WHERE CPF = '"+cpf+"'";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(consultarFuncionario);
			if(resultado.next()) {
				existe = true;
			}
			
		}catch(SQLException erro) {
			
			System.out.println("Erro na consulta ao funcionário");
			
		}
		
		this.conexao.fecharConexaoBanco();
		
		return existe;
		
		}
	
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		boolean cadastrou = false;
				
		String nome = funcionario.getNome();
		String cpf = funcionario.getCpf();
		String dataNascimento = funcionario.getDataNascimento(); 
		String cargo = funcionario.getCargo();
		String formacao = funcionario.getFormacao();
		String dataAdmissao = funcionario.getDataAdmissao();
		double salario = funcionario.getSalario();
		String estadoCivil = funcionario.getEstadoCivil();
		String sexo = funcionario.getSexo();
		String email = funcionario.getEmail();
		String cidade = funcionario.getCidade();
		String estado = funcionario.getEstado();
		String logradouro = funcionario.getLogradouro();
		String bairro = funcionario.getBairro();
		String numero = funcionario.getNumero();
		String cep = funcionario.getCep();
		String complemento = funcionario.getComplemento();
		String sigla = funcionario.getDepartamento().getSigla();
		
		RepositorioDepartamento rd = new RepositorioDepartamento();
		int id = rd.consultarIdDepartamento(sigla);
		//System.out.println("ID:"+id);
		String codigoCadastro = "INSERT INTO FUNCIONARIO "+
		"(NOME, CPF, DATANASCIMENTO, SEXO, EMAIL, ESTADOCIVIL, LOGRADOURO, NUMERO, BAIRRO, CEP, "+
		"CIDADE, ESTADO, COMPLEMENTO, CARGO, FORMACAO,  SALARIO, DATAADMISSAO, IDDEPARTAMENTO)" +
		"VALUES ('"+nome+"','"+cpf+"','"+dataNascimento+"','"+sexo+"','"+email+"','"+estadoCivil+"', "+
		"'"+logradouro+"','"+numero+"','"+bairro+"','"+cep+"','"+cidade+"','"+estado+"', "+
		"'"+complemento+"','"+cargo+"','"+formacao+"',"+salario+",'"+dataAdmissao+"',"+id+")";
		//System.out.println(codigoCadastro);
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			instrucao.executeUpdate(codigoCadastro);
			cadastrou = true;
			
		}catch(SQLException erro) {
			
			System.out.println("Erro no cadastro do funcionário: " + erro.getMessage() );
		}
		
		this.conexao.fecharConexaoBanco();
		
		return cadastrou;	
		
	}
	
	public Funcionario consultarFuncionarioCpf(String cpf) {
		
		Funcionario funcionario = new Funcionario();
		
		String codigoConsulta = "SELECT * FROM FUNCIONARIO" +
								" WHERE CPF = '"+cpf+"'";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			Statement instrucao = this.conexao.getConexao().createStatement();
			ResultSet resultado = instrucao.executeQuery(codigoConsulta);
			resultado.next();
			
			String nome = resultado.getString("NOME");
			cpf = resultado.getString("CPF");
			String dataNascimento = resultado.getString("DATANASCIMENTO");
			String sexo = resultado.getString("SEXO");
			String email = resultado.getString("EMAIL");
			String estadoCivil = resultado.getString("ESTADOCIVIL");
			String logradouro = resultado.getString("LOGRADOURO");
			String numero = resultado.getString("NUMERO");
			String bairro = resultado.getString("BAIRRO");
			String cep = resultado.getString("CEP");
			String cidade = resultado.getString("CIDADE");
			String estado = resultado.getString("ESTADO");
			String complemento = resultado.getString("COMPLEMENTO");
			String cargo = resultado.getString("CARGO");
			String formacao = resultado.getString("FORMACAO");
			String dataAdmissao = resultado.getString("DATAADMISSAO");
			double  salario = resultado.getDouble("SALARIO");
			int idDepartamento = resultado.getInt("IDDEPARTAMENTO");
			
			//Acessando o repositório
			RepositorioDepartamento rd = new RepositorioDepartamento();
			//Trazendo as informações do repositório departamento
			String sigla = rd.consultaSiglaDepartamento(idDepartamento);
			
			Departamento departamento = new Departamento();
			departamento.setSigla(sigla);
			
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setDataNascimento(dataNascimento);
			funcionario.setSexo(sexo);
			funcionario.setEmail(email);
			funcionario.setEstadoCivil(estadoCivil);
			funcionario.setLogradouro(logradouro);
			funcionario.setNumero(numero);
			funcionario.setBairro(bairro);
			funcionario.setCep(cep);
			funcionario.setCidade(cidade);
			funcionario.setEstado(estado);
			funcionario.setComplemento(complemento);
			funcionario.setCargo(cargo);
			funcionario.setFormacao(formacao);
			funcionario.setDataAdmissao(dataAdmissao);
			funcionario.setSalario(salario);
			funcionario.setDepartamento(departamento);
			
		}catch(SQLException erro) {
			
			System.out.println("Erro na consulta do funcionário");
		}
		
		this.conexao.fecharConexaoBanco();
		
		return funcionario;
		
		}
	
	public boolean alterarFuncionario(Funcionario funcionario, String cpfAntigo) {
		boolean resposta = false;
		
		String nome = funcionario.getNome();
		String cpf = funcionario.getCpf();
		String dataNascimento = funcionario.getDataNascimento(); 
		String cargo = funcionario.getCargo();
		String formacao = funcionario.getFormacao();
		String dataAdmissao = funcionario.getDataAdmissao();
		double salario = funcionario.getSalario();
		String estadoCivil = funcionario.getEstadoCivil();
		String sexo = funcionario.getSexo();
		String email = funcionario.getEmail();
		String cidade = funcionario.getCidade();
		String estado = funcionario.getEstado();
		String logradouro = funcionario.getLogradouro();
		String bairro = funcionario.getBairro();
		String numero = funcionario.getNumero();
		String cep = funcionario.getCep();
		String complemento = funcionario.getComplemento();
		String sigla = funcionario.getDepartamento().getSigla();
		
		//Para transformar a SIGLA em ID
		//Chama o repositório do departamento
		RepositorioDepartamento rd = new RepositorioDepartamento();
		//Chama o consultarIdDepartamento do repositório rd onde o mesmo irá processar as informações
		//e devolver o resultado para a variável int idDepartamento
		int idDepartamento = rd.consultarIdDepartamento(sigla);
		
		String codigoAlterar = " UPDATE FUNCIONARIO SET "+
				   " NOME = '"+nome+"', "+
				   " CPF = '"+cpf+"', "+
				   " DATANASCIMENTO = '"+dataNascimento+"', "+
				   " CARGO = '"+cargo+"', "+
				   " FORMACAO = '"+formacao+"', "+
				   " DATAADMISSAO = '"+dataAdmissao+"', "+
				   " SALARIO = "+salario+", "+				//Double não tem aspas simples
				   " ESTADOCIVIL = '"+estadoCivil+"' ,"+
				   " SEXO = '"+sexo+"', "+
				   " EMAIL = '"+email+"', "+
				   " CIDADE = '"+cidade+"', "+
				   " ESTADO = '"+estado+"', "+
				   " LOGRADOURO = '"+logradouro+"', "+
				   " BAIRRO = '"+bairro+"', "+
				   " NUMERO = '"+numero+"', "+
				   " CEP = '"+cep+"', "+
				   " COMPLEMENTO = '"+complemento+"', "+
				   " IDDEPARTAMENTO = "+idDepartamento+" "+   //Não tem aspas simples //O último item antes do WHERE não tem vírgula
				   " WHERE CPF= '"+cpfAntigo+"'";
		
		this.conexao.abrirConexaoBanco();
		
		try {
			
			//Preparando o banco
			Statement instrucao = this.conexao.getConexao().createStatement();
			//Executando a instrução
			instrucao.executeUpdate(codigoAlterar);
			resposta = true;
			
		}catch(SQLException erro) {
			
			System.out.println("Erro na alteração do funcionário"+erro.getMessage());
		}
		
		this.conexao.fecharConexaoBanco();
		
		return resposta;
				
		}
	
	public boolean excluirFuncionario(String cpf) {
		boolean retorno = false;
	
		String codigoExcluir = "DELETE FROM FUNCIONARIO "+
						   " WHERE CPF = '"+cpf+"'";
	
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
}
