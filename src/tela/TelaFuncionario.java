package tela;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Departamento;
import negocio.Funcionario;
import negocio.Usuario;
import repositorio.RepositorioDepartamento;
import repositorio.RepositorioFuncionario;
import repositorio.RepositorioUsuario;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Container; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionario {
	
	private JFrame telaFuncionario;
	
	private JLabel lTitulo;
	private JLabel lNome;
	private JLabel lCpf;
	private JLabel lDataNascimento;
	private JLabel lCargo;
	private JLabel lFormacao;
	private JLabel lDataAdmissao;
	private JLabel lSalario;
	private JLabel lEstadoCivil;
	private JLabel lSexo;
	private JLabel lEmail;
	private JLabel lCidade;
	private JLabel lEstado;
	private JLabel lLogradouro;
	private JLabel lBairro;
	private JLabel lNumero;
	private JLabel lCep;
	private JLabel lComplemento;
	private JLabel lDepartamento;
	private JLabel lLogin; //Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	private JLabel lSenha; //Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	private JLabel lTipo;  //Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNascimento;
	private JTextField tfCargo;
	private JTextField tfFormacao;
	private JTextField tfDataAdmissao;
	private JTextField tfSalario;
	private JTextField tfEstadoCivil;
	private JTextField tfSexo;
	private JTextField tfEmail;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JTextField tfLogradouro;
	private JTextField tfBairro;
	private JTextField tfNumero;
	private JTextField tfCep;
	private JTextField tfComplemento;
	private JComboBox cbDepartamento;
	private JTextField tfLogin; //Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	private JTextField tfSenha;	//Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	private JTextField tfTipo;	//Necessário para realizar o login do usuário no sistema, atributos da classe Usuario.
	
	private JButton btNovo;
	private JButton btEditar;
	private JButton btGravar;
	private JButton btCancelar;
	private JButton btExcluir;
	private JButton btPreparar;
	private JButton btLocalizar;
	
	//Variável que servirá para fazer a diferenciação entre cadastrar um novo registro ou alterar o registro. 
	//Esta variável estará presente no método "public void eventoBotaoNovo(), "public void eventoBotaoEditar() e "public void eventoBotaoGravar()".
	private String opcao;
	
	//Localizado em "public void eventoBotaoLocalizar()" e "public void eventoBotaoGravar(); 
	private String cpfAntigo;
	
 public TelaFuncionario() {
		
		this.montarTela();
		this.componenteTela();
		this.mostrarTela();
		this.eventoEstadoInicial();
		
	}
 	
 public void montarTela() {
		
		this.telaFuncionario = new JFrame("Sistemas::HT Hotel: Funcionario");
				
		this.telaFuncionario.setSize(690, 710);
				
		this.telaFuncionario.setExtendedState(JFrame.NORMAL);
				
		this.telaFuncionario.setResizable(false);
		
		this.telaFuncionario.setLocationRelativeTo(null);
		
		this.telaFuncionario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon icone = new ImageIcon("src\\images.jpg");
		
		this.telaFuncionario.setIconImage(icone.getImage());	
		
	}
 	
public void mostrarTela() {
		
		this.telaFuncionario.setVisible(true);
		
		this.telaFuncionario.setAlwaysOnTop(false);

}

public void componenteTela() {
	
	Container areaTrabalho = this.telaFuncionario.getContentPane();
	
	areaTrabalho.setLayout(null);
	
	this.lTitulo = new JLabel("Funcionário");
	this.lNome = new JLabel("Nome");
	this.lCpf = new JLabel("CPF");
	this.lDataNascimento = new JLabel("Data Nasc.");
	this.lCargo = new JLabel("Cargo");
	this.lFormacao = new JLabel("Formação");
	this.lDataAdmissao = new JLabel("Data Admissão");
	this.lSalario = new JLabel("Salário");
	this.lEstadoCivil = new JLabel("Estado Civil");
	this.lSexo = new JLabel("Sexo");
	this.lEmail = new JLabel("Email");
	this.lCidade = new JLabel("Cidade");
	this.lEstado = new JLabel("Estado");
	this.lLogradouro = new JLabel("Logradouro");
	this.lBairro = new JLabel("Bairro");
	this.lNumero = new JLabel("Numero");
	this.lCep = new JLabel("CEP");
	this.lComplemento = new JLabel("Complemento");
	this.lDepartamento = new JLabel("Departamento");
	this.lLogin = new JLabel("Login");
	this.lSenha = new JLabel("Senha");
	this.lTipo = new JLabel("Tipo");
	
	areaTrabalho.add(this.lTitulo).setBounds(300, 10, 100, 20);
	areaTrabalho.add(this.lNome).setBounds(160, 40, 100, 20);
	areaTrabalho.add(this.lCpf).setBounds(160, 70, 100, 20);
	areaTrabalho.add(this.lDataNascimento).setBounds(160, 100, 100, 20);
	areaTrabalho.add(this.lCargo).setBounds(160, 130, 100, 20);
	areaTrabalho.add(this.lFormacao).setBounds(160, 160, 100, 20);
	areaTrabalho.add(this.lDataAdmissao).setBounds(160, 190, 100, 20);
	areaTrabalho.add(this.lSalario).setBounds(160, 220, 100, 20);
	areaTrabalho.add(this.lEstadoCivil).setBounds(160, 250, 100, 20);
	areaTrabalho.add(this.lSexo).setBounds(160, 280, 100, 20);
	areaTrabalho.add(this.lEmail).setBounds(160, 310, 100, 20);
	areaTrabalho.add(this.lCidade).setBounds(160, 340, 100, 20);
	areaTrabalho.add(this.lEstado).setBounds(160, 370, 100, 20);
	areaTrabalho.add(this.lLogradouro).setBounds(160, 400, 100, 20);
	areaTrabalho.add(this.lBairro).setBounds(160, 430, 100, 20);
	areaTrabalho.add(this.lNumero).setBounds(160, 460, 100, 20);
	areaTrabalho.add(this.lCep).setBounds(160, 490, 100, 20);
	areaTrabalho.add(this.lComplemento).setBounds(160, 520, 100, 20);
	areaTrabalho.add(this.lDepartamento).setBounds(160, 550, 100, 20);
	areaTrabalho.add(this.lLogin).setBounds(30, 590, 100, 20);
	areaTrabalho.add(this.lSenha).setBounds(250, 590, 100, 20);
	areaTrabalho.add(this.lTipo).setBounds(480, 590, 100, 20);
		
	this.tfNome = new JTextField(250);
	this.tfCpf = new JTextField(250);
	this.tfDataNascimento = new JTextField(250);
	this.tfCargo = new JTextField(250);
	this.tfFormacao = new JTextField(250);
	this.tfDataAdmissao = new JTextField(250);
	this.tfSalario = new JTextField(250);
	this.tfEstadoCivil = new JTextField(250);
	this.tfSexo = new JTextField(250);
	this.tfEmail = new JTextField(250);
	this.tfCidade = new JTextField(250);
	this.tfEstado = new JTextField(250);
	this.tfLogradouro = new JTextField(250);
	this.tfBairro = new JTextField(250);
	this.tfNumero = new JTextField(250);
	this.tfCep = new JTextField(250);
	this.tfComplemento = new JTextField(250);
	this.tfLogin = new JTextField(250);
	this.tfSenha = new JTextField(250);
	this.tfTipo = new JTextField(250);
	
		//Chama repositório
		RepositorioDepartamento rd = new RepositorioDepartamento();
		//Chama método do vetor
		String [] listaDepartamento = rd.listarDepartamentos();
		//Chama método quantidade(tamanho) do vetor
		int quantidade = rd.quantidadeDepartamento();
		int posicao = 0;
		
		//Preparar o COMBOBOX para receber os elementos;
		this.cbDepartamento = new JComboBox();
		this.cbDepartamento.addItem("");
			//Criação do laço para trazer as informações contidas no vetor para dentro do COMBOBOX
			while (posicao < quantidade) {
				cbDepartamento.addItem(listaDepartamento[posicao]);
				posicao = posicao + 1;
				
			}
	
	areaTrabalho.add(this.tfNome).setBounds(250, 40, 250, 20);
	areaTrabalho.add(this.tfCpf).setBounds(250, 70, 250, 20);
	areaTrabalho.add(this.tfDataNascimento).setBounds(250, 100, 250, 20);
	areaTrabalho.add(this.tfCargo).setBounds(250, 130, 250, 20);
	areaTrabalho.add(this.tfFormacao).setBounds(250, 160, 250, 20);
	areaTrabalho.add(this.tfDataAdmissao).setBounds(250, 190, 250, 20);
	areaTrabalho.add(this.tfSalario).setBounds(250, 220, 250, 20);
	areaTrabalho.add(this.tfEstadoCivil).setBounds(250, 250, 250, 20);
	areaTrabalho.add(this.tfSexo).setBounds(250, 280, 250, 20);
	areaTrabalho.add(this.tfEmail).setBounds(250, 310, 250, 20);
	areaTrabalho.add(this.tfCidade).setBounds(250, 340, 250, 20);
	areaTrabalho.add(this.tfEstado).setBounds(250, 370, 250, 20);
	areaTrabalho.add(this.tfLogradouro).setBounds(250, 400, 250, 20);
	areaTrabalho.add(this.tfBairro).setBounds(250, 430, 250, 20);
	areaTrabalho.add(this.tfNumero).setBounds(250, 460, 250, 20);
	areaTrabalho.add(this.tfCep).setBounds(250, 490, 250, 20);
	areaTrabalho.add(this.tfComplemento).setBounds(250, 520, 250, 20);
	areaTrabalho.add(this.cbDepartamento).setBounds(250, 550, 250, 20);
	areaTrabalho.add(this.tfLogin).setBounds(70, 590, 100, 20);
	areaTrabalho.add(this.tfSenha).setBounds(300, 590, 100, 20);
	areaTrabalho.add(this.tfTipo).setBounds(520, 590, 100, 20);
				
	this.btNovo = new JButton("Novo");
	this.btEditar = new JButton("Editar");
	this.btGravar = new JButton("Gravar");
	this.btCancelar = new JButton("Cancelar");
	this.btExcluir = new JButton("Excluir");
	this.btPreparar = new JButton("Preparar");
	this.btLocalizar = new JButton("Localizar");
			
	areaTrabalho.add(this.btNovo).setBounds(10, 630, 90, 30);
	areaTrabalho.add(this.btEditar).setBounds(105, 630, 90, 30);
	areaTrabalho.add(this.btGravar).setBounds(200, 630, 90, 30);
	areaTrabalho.add(this.btCancelar).setBounds(295, 630, 90, 30);
	areaTrabalho.add(this.btExcluir).setBounds(390, 630, 90, 30);
	areaTrabalho.add(this.btPreparar).setBounds(485, 630, 90, 30);
	areaTrabalho.add(this.btLocalizar).setBounds(580, 630, 90, 30);	
	
			this.btNovo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				 eventoBotaoNovo();
					
				}
			});
			
			this.btGravar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoGravar();
					
				}
			});
			
			this.btPreparar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoPreparar();
					
				}
			});
			
			this.btCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoCancelar();
					
				}
			});
			
			this.btLocalizar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoLocalizar();
					
				}
			});
			
			this.btExcluir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoExcluir();
					
				}
			});
			
			this.btEditar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					eventoBotaoEditar();
					
				}
			});
				
		}

public void limparCampos() {
	this.tfNome.setText("");
	this.tfCpf.setText("");
	this.tfDataNascimento.setText("");
	this.tfCargo.setText("");
	this.tfFormacao.setText("");
	this.tfDataAdmissao.setText("");
	this.tfSalario.setText("");
	this.tfEstadoCivil.setText("");
	this.tfCargo.setText("");
	this.tfFormacao.setText("");
	this.tfSexo.setText("");
	this.tfEmail.setText("");
	this.tfCidade.setText("");
	this.tfEstado.setText("");
	this.tfLogradouro.setText("");
	this.tfBairro.setText("");
	this.tfNumero.setText("");
	this.tfCep.setText("");
	this.tfComplemento.setText("");
	this.tfLogin.setText("");
	this.tfSenha.setText("");
	this.tfTipo.setText("");
	
}

public void eventoEstadoInicial() {
	limparCampos();
	
	this.tfNome.setEnabled(false);
	this.tfCpf.setEnabled(false);
	this.tfDataNascimento.setEnabled(false);
	this.tfCargo.setEnabled(false);
	this.tfFormacao.setEnabled(false);
	this.tfDataAdmissao.setEnabled(false);
	this.tfSalario.setEnabled(false);
	this.tfEstadoCivil.setEnabled(false);
	this.tfSexo.setEnabled(false);
	this.tfEmail.setEnabled(false);
	this.tfCidade.setEnabled(false);
	this.tfEstado.setEnabled(false);
	this.tfLogradouro.setEnabled(false);
	this.tfBairro.setEnabled(false);
	this.tfNumero.setEnabled(false);
	this.tfCep.setEnabled(false);
	this.tfComplemento.setEnabled(false);
	this.cbDepartamento.setEnabled(false);
	this.tfLogin.setEnabled(false);
	this.tfSenha.setEnabled(false);
	this.tfTipo.setEnabled(false);
		
	this.btNovo.setEnabled(true);
	this.btPreparar.setEnabled(true);
	
	this.btCancelar.setEnabled(false);
	this.btEditar.setEnabled(false);
	this.btExcluir.setEnabled(false);
	this.btLocalizar.setEnabled(false);
	this.btGravar.setEnabled(false);
}

public void eventoBotaoNovo() {
	
	//Quando clicar no botão NOVO a variável receberá essa String que servirá para indicar o cadastro de um novo registro.
	this.opcao = "novo";
	
	limparCampos();
	
	this.tfNome.setEnabled(true);
	this.tfCpf.setEnabled(true);
	this.tfDataNascimento.setEnabled(true);
	this.tfCargo.setEnabled(true);
	this.tfFormacao.setEnabled(true);
	this.tfDataAdmissao.setEnabled(true);
	this.tfSalario.setEnabled(true);
	this.cbDepartamento.setEnabled(true);
	this.tfEstadoCivil.setEnabled(true);
	this.tfCargo.setEnabled(true);
	this.tfFormacao.setEnabled(true);
	this.tfSexo.setEnabled(true);
	this.tfEmail.setEnabled(true);
	this.tfCidade.setEnabled(true);
	this.tfEstado.setEnabled(true);
	this.tfLogradouro.setEnabled(true);
	this.tfBairro.setEnabled(true);
	this.tfNumero.setEnabled(true);
	this.tfCep.setEnabled(true);
	this.tfComplemento.setEnabled(true);
	this.cbDepartamento.setEnabled(true);
	this.tfLogin.setEnabled(true);
	this.tfSenha.setEnabled(true);
	this.tfTipo.setEnabled(true);
	
	this.btGravar.setEnabled(true);
	this.btCancelar.setEnabled(true);
	
	this.btNovo.setEnabled(false);
	this.btPreparar.setEnabled(false);
	this.btEditar.setEnabled(false);
	this.btExcluir.setEnabled(false);
	this.btLocalizar.setEnabled(false);	
	
}

public void eventoBotaoPreparar() {
	limparCampos();
	
	this.tfNome.setEnabled(false);
	this.tfCpf.setEnabled(true);
	this.tfDataNascimento.setEnabled(false);
	this.tfCargo.setEnabled(false);
	this.tfFormacao.setEnabled(false);
	this.tfDataAdmissao.setEnabled(false);
	this.tfSalario.setEnabled(false);
	this.cbDepartamento.setEnabled(false);
	this.tfEstadoCivil.setEnabled(false);
	this.tfCargo.setEnabled(false);
	this.tfFormacao.setEnabled(false);
	this.tfSexo.setEnabled(false);
	this.tfEmail.setEnabled(false);
	this.tfCidade.setEnabled(false);
	this.tfEstado.setEnabled(false);
	this.tfLogradouro.setEnabled(false);
	this.tfBairro.setEnabled(false);
	this.tfNumero.setEnabled(false);
	this.tfCep.setEnabled(false);
	this.tfComplemento.setEnabled(false);
	this.cbDepartamento.setEnabled(false);
	
	this.btLocalizar.setEnabled(true);
	this.btCancelar.setEnabled(true);
	
	this.btEditar.setEnabled(false);
	this.btNovo.setEnabled(false);
	this.btExcluir.setEnabled(false);
	this.btGravar.setEnabled(false);
	this.btPreparar.setEnabled(false);	
	
}

public void eventoBotaoCancelar() {
	eventoEstadoInicial();
}

public void eventoBotaoLocalizar() {
	
	String cpf = this.tfCpf.getText();
	
	//Chamada ao repositório
	RepositorioFuncionario rf = new RepositorioFuncionario();
	boolean resposta = rf.funcionarioExiste(cpf);
				
		if( resposta == true) {
					
			Funcionario funcionario = rf.consultarFuncionarioCpf(cpf);
					
			this.tfNome.setText(funcionario.getNome());
		    this.tfNome.setDisabledTextColor(Color.BLUE); //Para alterar a cor do texto quando for realizado a consulta. Deve-se colocar essa função em cada item.
			this.tfCpf.setText(funcionario.getCpf());
			this.tfDataNascimento.setText(funcionario.getDataNascimento());
			this.tfSexo.setText(funcionario.getSexo());
			this.tfEmail.setText(funcionario.getEmail());
			this.tfEstadoCivil.setText(funcionario.getEstadoCivil());
			this.tfLogradouro.setText(funcionario.getLogradouro());
			this.tfNumero.setText(funcionario.getNumero());
			this.tfBairro.setText(funcionario.getBairro());
			this.tfCep.setText(funcionario.getCep());
			this.tfCidade.setText(funcionario.getCidade());
			this.tfEstado.setText(funcionario.getEstado());
			this.tfComplemento.setText(funcionario.getComplemento());
			this.tfCargo.setText(funcionario.getCargo());
			this.tfFormacao.setText(funcionario.getFormacao());
			this.tfDataAdmissao.setText(funcionario.getDataAdmissao());
			this.tfSalario.setText(String.valueOf(funcionario.getSalario())); //Transforma um valor para uma String
			this.cbDepartamento.setSelectedItem(funcionario.getDepartamento().getSigla());// Carrega o combobox
				
			this.btLocalizar.setEnabled(false);
			this.btExcluir.setEnabled(true);
			this.btEditar.setEnabled(true);
			
					this.cpfAntigo = funcionario.getCpf();
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Não foi possóvel "+
							"localizar o funcionário.");	
				} 		
		} 				

public void eventoBotaoGravar() {
	
	String nome = this.tfNome.getText();
	String cpf = this.tfCpf.getText();
	String dataNascimento = this.tfDataNascimento.getText();
	String cargo = this.tfCargo.getText();
	String formacao = this.tfFormacao.getText();
	String dataAdmissao = this.tfDataAdmissao.getText();
	double salario = Double.parseDouble(this.tfSalario.getText());
	String estadoCivil = this.tfEstadoCivil.getText();
	String sexo = this.tfSexo.getText();
	String email = this.tfEmail.getText();
	String cidade = this.tfCidade.getText();
	String estado = this.tfEstado.getText();
	String logradouro = this.tfLogradouro.getText();
	String bairro = this.tfBairro.getText();
	String numero = this.tfNumero.getText();
	String cep = this.tfCep.getText();
	String complemento = this.tfComplemento.getText();
	//Para converter a String em um valor
	String sigla = String.valueOf(this.cbDepartamento.getSelectedItem());
	String login = tfLogin.getText(); //Login, Senha Tipo: para capturar as informações para o login do usuário. Também é preciso validar igual aos outros campos.
	String senha = tfSenha.getText();
	String tipo = tfTipo.getText();
	
	//Criação do objeto departamento vazio, conforme construtor que está na classe Departamento
	Departamento departamento = new Departamento();
	//Do objeto departamento foi resgatado apenas a "sigla"
	departamento.setSigla(sigla);
	
	Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, sexo, email, estadoCivil, logradouro, numero,
											  bairro, cep, cidade, estado, complemento, cargo, formacao, dataAdmissao, 
											  salario, departamento);
	
	//Validação dos campos
	if(nome.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o código do funcionário!");
		
	}else if(cpf.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o CPF do funcionário!");
		
	}else if (dataNascimento.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite a data de nascimento do funcionário!");
		
	}else if (sexo.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o sexo do funcionário!");
		
	}else if(email.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o email do funcionário!");
			
	}else if (estadoCivil.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o estado civil do funcionário!");
			
	}else if (logradouro.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o logradouro!");
			
	}else if(numero.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o numero!");
		
	}else if (bairro.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o bairro!");
		
	}else if (cep.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o cep!");
		
	}else if(cidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite a cidade!");
			
	}else if (estado.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o estado!");
			
	}else if (complemento.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o complemento!");
			
	}else if (cargo.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite o cargo!");
		
	}else if (formacao.equals("")) {
		JOptionPane.showMessageDialog(null, "Digite a formação do funcionário!");
		
	}else if(dataAdmissao.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite a data de admissao do funcionário!");
			
	}else if (salario == 0) {
			JOptionPane.showMessageDialog(null, "Digite o salario do funcionário!");
			
	}else if (sigla.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o departamento!");
			
	}else {
		
			if(this.opcao.equals("novo")) {
				
				//Chama a classe do repositório, nomear, cria um novo objeto repositório
				RepositorioFuncionario rf = new RepositorioFuncionario();
				//Pelo nome do repositorio (rf), chama o método cadastrarFuncionario do repositorio funcionário, processa
				//e depois retorna o resultado, onde se true ficará guardado na variável (resposta).
				boolean resposta = rf.cadastrarFuncionario(funcionario);
				
				if(resposta == true) {
					
							//Para cadastrar as informações na tabela usuário, de login do usuário ao sistema
							//Chama o repositório usuário
							RepositorioUsuario ru = new RepositorioUsuario();
							//Cria o objeto usuário
							Usuario usuario = new Usuario(login, senha, tipo, cpf);
							boolean resposta2 = ru.cadastroUsuario(usuario);
							
								if(resposta2 == true) {
									System.out.println("Cadastro do usuário com sucesso");
								}else {
									System.out.println("Erro no cadastro do usuário");
								}
					
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado!");
					
					eventoEstadoInicial();
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro no cadastro!");
				}
					
				} else if(this.opcao.equals("editar")) {
					
					//Chama a classe do repositório funcionário
					RepositorioFuncionario rf = new RepositorioFuncionario();
					//Pelo nome do repositorio (rf), chama o método alterarfuncionario do repositorio funcionário, processa
					//e depois retorna o resultado, onde se true ficará guardado na variável (resposta).
					boolean resposta = rf.alterarFuncionario(funcionario, this.cpfAntigo);
					
					if(resposta == true) {
						JOptionPane.showMessageDialog(null, "Informações do funcionário alteradas!");
						
						eventoEstadoInicial();
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro na alteração!");
						
					}
			}
		}	
	}

public void eventoBotaoExcluir() {

	int valor = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o funcionário?");
	
		if(valor == 0) {
	
			RepositorioFuncionario rf = new RepositorioFuncionario();
	
			boolean resposta = rf.excluirFuncionario(cpfAntigo);
	
			if(resposta == true) {
		
				JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
		
				eventoEstadoInicial();
		
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o funcionário!");
				}
		}
		
		if(valor == 2) {
			
			eventoEstadoInicial();		
		}
	}

public void eventoBotaoEditar() {
	
	this.opcao = "editar";
	
	this.tfNome.setEnabled(true);
	this.tfCpf.setEnabled(true);
	this.tfDataNascimento.setEnabled(true);
	this.tfCargo.setEnabled(true);
	this.tfFormacao.setEnabled(true);
	this.tfDataAdmissao.setEnabled(true);
	this.tfSalario.setEnabled(true);
	this.tfEstadoCivil.setEnabled(true);
	this.tfSexo.setEnabled(true);
	this.tfEmail.setEnabled(true);
	this.tfCidade.setEnabled(true);
	this.tfEstado.setEnabled(true);
	this.tfLogradouro.setEnabled(true);
	this.tfBairro.setEnabled(true);
	this.tfNumero.setEnabled(true);
	this.tfCep.setEnabled(true);
	this.tfComplemento.setEnabled(true);
	this.cbDepartamento.setEnabled(true);
	
	this.btGravar.setEnabled(true);
	this.btCancelar.setEnabled(true);
	this.btNovo.setEnabled(false);
	this.btPreparar.setEnabled(false);
	this.btEditar.setEnabled(false);
	this.btExcluir.setEnabled(false);
	this.btLocalizar.setEnabled(false);

	}

}

