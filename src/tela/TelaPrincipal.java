package tela;
//JFrame, essa é a classe responsável em montar as telas do sistema.
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ImageIcon, essa classe é responsável em adicionar icones a janela e objetos visuais.
import javax.swing.ImageIcon;
//JMenuBar, essa classe é responsável por criar a barra de menu.
import javax.swing.JMenuBar;
//JMenu, essa classe é responsável em adicionar as opções a barra de menu.
import javax.swing.JMenu;
//JMenuItem, essa classe é responsável em adicionar os itens de cada opção da barra de menu.
import javax.swing.JMenuItem;

public class TelaPrincipal {
	
	//Declarando o objeto da tela
	private JFrame janelaPrincipal;
	
	public TelaPrincipal()
	{	
		this.montarTela();
		this.barraMenu();
		this.mostrarJanela();
		//TelaAcessoUsuario tl = new TelaAcessoUsuario(); //Para abrir a tela de login junto com a tela principal.
			
	}
	
	//Esse método será responsável em determinar todas as configurações inicias da tela.
	public void montarTela() {
		
		//Instanciando o objeto
		this.janelaPrincipal = new JFrame("Sistemas::HT Hotel");
		
		//Definindo as dimensões da janela no estado normal, largura, altura
		this.janelaPrincipal.setSize(1000, 800);
		
		//Definindo a tela para o modo maximizado
		this.janelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Permitindo ao usuário redimnsionar a janela
		this.janelaPrincipal.setResizable(true);
		
		//Configurando a janela para aparecer no centro da tela
		this.janelaPrincipal.setLocationRelativeTo(null);
		
		//Definindo o fechamento da aplicação ao fechar esta janela
		this.janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Criando o objeto que recebe o icone do sistema à janela
		ImageIcon icone = new ImageIcon ("src\\images.jpg");
		
		//Adicionando o icone a janela
		this.janelaPrincipal.setIconImage(icone.getImage());
		
	}
	
	//Método responsável em tornar a janlea visível
	public void mostrarJanela() {
		
		//Tornando a janela vísivel
		this.janelaPrincipal.setVisible(true);
	}
	
	//Método responsável em montar a barra de menu
	public void barraMenu() {
		
		//Instanciando o objeto barra de menu
		JMenuBar barra = new JMenuBar();
		
		//Adicionando a barra de menu a janela
		this.janelaPrincipal.setJMenuBar(barra);
		
		//Para cada item que irá compor a barra de menu deverá ser instanciado um objeto
		JMenu menuDepartamento = new JMenu("Departamento");
		JMenu menuFuncionario = new JMenu("Funcionário");
		JMenu menuDependente = new JMenu("Dependente");
		JMenu menuApartamento = new JMenu("Apartamento");
		JMenu menuHospede = new JMenu("Hospede");
		JMenu menuAcompanhante = new JMenu("Acompanhante");
		JMenu menuConta = new JMenu("Conta");
		
		//Após a criação de cada objeto que irá compor a barra de menu, deve-se adicionar este objeto a barra para tornar visível.
		barra.add(menuDepartamento);
		barra.add(menuFuncionario);
		barra.add(menuDependente);
		barra.add(menuApartamento);
		barra.add(menuHospede);
		barra.add(menuAcompanhante);
		barra.add(menuConta);
		
		//Para adicionar subitem aos itens que compõem a barra de menu, deve-se criar um objeto para cada um.
		JMenuItem cadastroDepen = new JMenuItem("Cadastrar Dependente");
			//JMenuItem consultaDepen = new JMenuItem("Consultar Dependente");
			//JMenuItem alteraDepen = new JMenuItem("Alterar Dependente");
			//JMenuItem excluiDepen = new JMenuItem("Excluir Dependente");
		
		//Após criado o objeto de cada subitem, deve-se adicionar ao item do menu desejado.
		menuDependente.add(cadastroDepen);
			//menuDependente.add(consultaDepen);
			//menuDependente.add(alteraDepen);
			//menuDependente.add(excluiDepen);
		
		JMenuItem cadastroDep = new JMenuItem("Cadastrar Departamento");
			//JMenuItem consultaDep = new JMenuItem("Consultar Departamento");
			//JMenuItem alteraDep = new JMenuItem("Alterar Departamento");
			//JMenuItem excluiDep = new JMenuItem("Excluir Departamento");
		
		menuDepartamento.add(cadastroDep);
			//menuDepartamento.add(consultaDep);
			//menuDepartamento.add(alteraDep);
			//menuDepartamento.add(excluiDep);
		
		JMenuItem cadastroFunc = new JMenuItem("Cadastrar Funcionário");
			//JMenuItem consultaFunc = new JMenuItem("Consultar Funcionário");
			//JMenuItem alteraFunc = new JMenuItem("Alterar Funcionário");
			//JMenuItem excluiFunc = new JMenuItem("Excluir Funcionário");
		
		menuFuncionario.add(cadastroFunc);
			//menuFuncionario.add(consultaFunc);
			//menuFuncionario.add(alteraFunc);
			//menuFuncionario.add(excluiFunc);
		
		JMenuItem cadastroApt = new JMenuItem("Cadastrar Apartamento");
			//JMenuItem consultaApt = new JMenuItem("Consultar Apartamento");
			//JMenuItem alteraApt = new JMenuItem("Alterar Apartamento");
			//JMenuItem excluiApt = new JMenuItem("Excluir Apartamento");
		
		menuApartamento.add(cadastroApt);
			//menuApartamento.add(consultaApt);
			//menuApartamento.add(alteraApt);
			//menuApartamento.add(excluiApt);
		
		JMenuItem cadastroHosp = new JMenuItem("Cadastrar Hospede");
			//JMenuItem consultaHosp = new JMenuItem("Consultar Hospede");
			//JMenuItem alteraHosp = new JMenuItem("Alterar Hospede");
			//JMenuItem excluiHosp = new JMenuItem("Excluir Hospede");
		
		menuHospede.add(cadastroHosp);
			//menuHospede.add(consultaHosp);
			//menuHospede.add(alteraHosp);
			//menuHospede.add(excluiHosp);
		
		JMenuItem cadastroAcomp = new JMenuItem("Cadastrar Acompanhante");
			//JMenuItem consultaAcomp = new JMenuItem("Consultar Acompanhante");
			//JMenuItem alteraAcomp = new JMenuItem("Alterar Acompanhante");
			//JMenuItem excluiAcomp = new JMenuItem("Excluir Acompanhante");
		
		menuAcompanhante.add(cadastroAcomp);
			//menuAcompanhante.add(consultaAcomp);
			//menuAcompanhante.add(alteraAcomp);
			//menuAcompanhante.add(excluiAcomp);
		
		JMenuItem cadastroConta = new JMenuItem("Cadastrar Conta");
			//JMenuItem consultaConta = new JMenuItem("Consultar Conta");
			//JMenuItem alteraConta = new JMenuItem("Alterar Conta");
			//JMenuItem excluiConta = new JMenuItem("Excluir Conta");
		
		menuConta.add(cadastroConta);
			//menuConta.add(consultaConta);
			//menuConta.add(alteraConta);
			//menuConta.add(excluiConta);
		
		//Eventos do menu da tela principal. Este método é quem chama ou faz a abertura da tela secundária.
		//Para cada tela secundária deverá ter este método vinculando-o a tela pricipal.
		cadastroDep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			TelaDepartamento td = new TelaDepartamento();
					
			}
		});
		
		cadastroApt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			TelaApartamento ta = new TelaApartamento();
					
			}
		});
		
		cadastroHosp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaHospede th = new TelaHospede();
				
			}
		});
		
		cadastroFunc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario tf = new TelaFuncionario();
				
			}
		});
		
	}

}
