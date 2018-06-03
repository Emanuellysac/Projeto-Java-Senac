package tela;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import repositorio.RepositorioUsuario;

import javax.swing.JButton;

import java.awt.Container; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAcessoUsuario {
	
	private JFrame telaAcessoUsuario;
	
	private JLabel lTitulo;
	private JLabel lLogin;
	private JLabel lSenha;
	
	private JTextField tfLogin;
	private JPasswordField tfSenha; //Para a senha não aparecer na hora que estiver sendo digitada, ou seja, mostrar umas bolinhas
	
	private JButton btLogar;
	
	private boolean logado; //Para dizer se está logado ou não
		
public TelaAcessoUsuario() {
		
		this.montarTela();
		this.componenteTela();
		this.mostrarTela();
		this.logado = false; //Significa que quando abrir a janela o usuário ainda não está logado
			
	}

public void montarTela() {
	
	this.telaAcessoUsuario = new JFrame("HT Hotel");
			
	this.telaAcessoUsuario.setSize(250, 200);
			
	this.telaAcessoUsuario.setExtendedState(JFrame.NORMAL);
			
	this.telaAcessoUsuario.setResizable(false);
	
	this.telaAcessoUsuario.setLocationRelativeTo(null);
	
	this.telaAcessoUsuario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	ImageIcon icone = new ImageIcon("src\\images.jpg");
	
	this.telaAcessoUsuario.setIconImage(icone.getImage());	
	
}

public void mostrarTela() {
	
	this.telaAcessoUsuario.setVisible(true);
	
	this.telaAcessoUsuario.setAlwaysOnTop(false);

}

public void componenteTela() {
	

	Container areaTrabalho = this.telaAcessoUsuario.getContentPane();

	areaTrabalho.setLayout(null);
	
	this.lTitulo = new JLabel("Acesso");
	this.lLogin = new JLabel("Login");
	this.lSenha = new JLabel("Senha");
	
	areaTrabalho.add(this.lTitulo).setBounds(100, 10, 100, 20);
	areaTrabalho.add(this.lLogin).setBounds(40, 50, 100, 20);
	areaTrabalho.add(this.lSenha).setBounds(40, 80, 100, 20);

	this.tfLogin = new JTextField(100);
	this.tfLogin.setToolTipText("Digite o seu login"); //Para mostrar um texto explicativo no momento em que parar o mouse sobre a caixa de texto. 
	
	this.tfSenha = new JPasswordField(100);
	this.tfSenha.setToolTipText("Digite a sua senha");
	
	areaTrabalho.add(this.tfLogin).setBounds(80, 50, 120, 20);
	areaTrabalho.add(this.tfSenha).setBounds(80, 80, 120, 20);
	
	this.btLogar = new JButton("Logar");
		
	areaTrabalho.add(this.btLogar).setBounds(80, 120, 90, 30);
	
	this.btLogar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			eventoBotaoLogar();
			
		}
	}); 
		
}

//Método para logar no sistema
public void eventoBotaoLogar() {
	
	String login = this.tfLogin.getText(); 
	String senha = this.tfSenha.getText();
	
		if(login.equals("")) {
			JOptionPane.showMessageDialog(null,  "Digite seu login.");
			
		}else if(senha.equals("")) {
			JOptionPane.showMessageDialog(null,  "Digite sua senha.");
			
		}else {
			RepositorioUsuario ru = new RepositorioUsuario();
			boolean resposta = ru.validarLogin(login, senha);
			
				if(resposta == false) {
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");	
				}else if(resposta == true) {
					this.telaAcessoUsuario.setVisible(false);
					TelaPrincipal tp = new TelaPrincipal();
				}
			
		}
}

} 
