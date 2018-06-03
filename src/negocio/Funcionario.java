package negocio;

public class Funcionario extends Pessoa {
	
	private String cargo, formacao, dataAdmissao;             
	private double salario;
	private Departamento departamento;
	
	public Funcionario(String nome, String cpf, String dataNascimento, String sexo, String email, String estadoCivil,
			String logradouro, String numero, String bairro, String cep, String cidade, String estado,
			String complemento, String cargo, String formacao, String dataAdmissao, double salario, Departamento departamento) {
				
		super(nome, cpf, dataNascimento, sexo, email, estadoCivil, logradouro, numero, bairro, cep, cidade, estado, complemento);
		this.cargo = cargo;
		this.formacao = formacao;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public Funcionario () {
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}