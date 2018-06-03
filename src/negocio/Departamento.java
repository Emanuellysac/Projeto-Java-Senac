package negocio;

public class Departamento {
	
	private String codigo, nomeDepartamento, sigla, descricao;

	public Departamento(String codigo, String nomeDepartamento, String sigla, String descricao) {
		this.codigo = codigo;
		this.nomeDepartamento = nomeDepartamento;
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	//Método para efetuar consulta no banco
	public Departamento() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
