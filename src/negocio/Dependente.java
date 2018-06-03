package negocio;

public class Dependente {
	
	private String nome, grauParentesco, dataNascimento, sexo;
	Funcionario funcionario;
	
	public Dependente(String nome, String grauParentesco, String dataNascimento, String sexo, Funcionario funcionario) {
		this.nome = nome;
		this.grauParentesco = grauParentesco;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
