package negocio;

public class Acompanhante extends Pessoa {
	
	
	private String categoria;
	private Hospede hospede;
	
	public Acompanhante(String nome, String cpf, String dataNascimento, String sexo, String email, String estadoCivil,
			String logradouro, String numero, String bairro, String cep, String cidade, String estado,
			String complemento, String categoria, Hospede hospede) {
		
		super (nome, cpf, dataNascimento, sexo, email, estadoCivil, logradouro, numero, bairro, cep, cidade, estado, complemento);
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
}
