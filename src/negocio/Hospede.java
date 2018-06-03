package negocio;

public class Hospede extends Pessoa {
	
	private String respFinanceiro;
	public Hospede(String nome, String cpf, String dataNascimento, String sexo, String email, String estadoCivil,
			String logradouro, String numero, String bairro, String cep, String cidade, String estado,
			String complemento, String respFinanceiro) {
		
		super (nome, cpf, dataNascimento, sexo, email, estadoCivil, logradouro, numero, bairro, cep, cidade, estado, complemento);
		this.respFinanceiro = respFinanceiro;
	}
	public String getRespFinanceiro() {
		return respFinanceiro;
	}
	public void setRespFinanceiro(String respFinanceiro) {
		this.respFinanceiro = respFinanceiro;
	}
	
}




