package negocio;
public class Conta {
	
	private String codigo, dataCheckin, dataCheckout, observacao;
	private double valorTotal;
	Funcionario funcionario;
	Apartamento apartamento;
	Hospede hospede;
	
	public Conta(String codigo, String dataCheckin, String dataCheckout, String observacao, double valorTotal,
			Funcionario funcionario, Apartamento apartamento, Hospede hospede) {
		
		this.codigo = codigo;
		this.dataCheckin = dataCheckin;
		this.dataCheckout = dataCheckout;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		this.funcionario = funcionario;
		this.apartamento = apartamento;
		this.hospede = hospede;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(String dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public String getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(String dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
	public double valorRestaurante (double valorRestaurante) {
		
		this.valorTotal = this.valorTotal + valorRestaurante;
		return this.valorTotal;
	}
	
	public double valorSalao (double valorSalao) {
		this.valorTotal = this.valorTotal + valorSalao;
		return this.valorTotal;
	}
	
	public double valorServico (double valorServico) {
		this.valorTotal = this.valorTotal + valorServico;
		return this.valorTotal;
	}
	
	public double valorBar (double valorBar) {
		this.valorTotal = this.valorTotal + valorBar;
		return this.valorTotal;
	}
	
	public double valorLanchonete (double valorLanchonete) {
		this.valorTotal = this.valorTotal + valorLanchonete;
		return this.valorTotal;
	}
	
	public double desconto (double desconto) {
		this.valorTotal = this.valorTotal - desconto;
		return this.valorTotal;
	}
	
	public double multa (double multa) {
		this.valorTotal = this.valorTotal - multa;
		return this.valorTotal;
		
	}
	
	/*public void multa1 (double multa1) {
		this.valorTotal = this.valorTotal - multa1;
	}
	  Os métodos também podem serem feitos utilizando o VOID, nesse caso o método não tem retorno e
	  não há impressão do resultado, porém, pode-se imprimir o valor da variável alterada: 
	  1º Chama o método:  c1.multa1(500);
	  2º Vizualiza a alteração: System.out.println(c1.getValorTotal());*/
	  
	
}


