package teste;
import banco.ConexaoBancoAccess;

public class TesteBanco {

	public static void main(String[] args) {
		
		ConexaoBancoAccess c = new ConexaoBancoAccess();
		
		boolean resposta = c.abrirConexaoBanco();
		
		if(resposta == true) {
			
			System.out.println("O banco está aberto");
		}
		
		resposta = c.fecharConexaoBanco();
		
		if (resposta == true) {
			
			System.out.println("O banco está fechado");	
		}
	}

}
