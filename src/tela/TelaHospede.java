package tela;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Hospede;
import repositorio.RepositorioHospede;

public class TelaHospede {
	
	private JFrame telaHospede;
	
	private JLabel lTitulo;
	private JLabel lNome;
	private JLabel lCpf;
	private JLabel lDataNascimento;
	private JLabel lSexo;
	private JLabel lEstadoCivil;
	private JLabel lEmail;
	private JLabel lLogradouro;
	private JLabel lNumero;
	private JLabel lBairro;
	private JLabel lCep;
	private JLabel lCidade;
	private JLabel lEstado;
	private JLabel lComplemento;
	private JLabel lRespFinanceiro;
	
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNascimento;
	private JTextField tfSexo;
	private JTextField tfEstadoCivil;
	private JTextField tfEmail;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JTextField tfComplemento;
	private JTextField tfRespFinanceiro;
	
	private JButton btNovo;
	private JButton btEditar;
	private JButton btGravar;
	private JButton btCancelar;
	private JButton btExcluir;
	private JButton btPreparar;
	private JButton btLocalizar;
		
	public TelaHospede() {
		
		this.montarTela();
		this.componenteTela();
		this.mostrartela();	
		this.eventoEstadoInicial();
		
	}
	
	public void montarTela() {
		
		this.telaHospede = new JFrame("Sistemas::HT Hotel: Hospede");
		
		this.telaHospede.setSize(700,450);
		
		this.telaHospede.setExtendedState(JFrame.NORMAL);
		
		this.telaHospede.setLocationRelativeTo(null);
		
		this.telaHospede.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon icone = new ImageIcon("src\\images.jpg");
		
		this.telaHospede.setIconImage(icone.getImage());
	}
	
	public void mostrartela() {
		
		this.telaHospede.setVisible(true);
		
		this.telaHospede.setAlwaysOnTop(false);
	}
	
	public void componenteTela() {
		
		Container areaTrabalho = this.telaHospede.getContentPane();
		
		areaTrabalho.setLayout(null);
		
		this.lTitulo = new JLabel("Hospede");
		this.lNome = new JLabel("Nome");
		this.lCpf = new JLabel("CPF");
		this.lDataNascimento = new JLabel("Data Nasc.");
		this.lSexo = new JLabel("Sexo");
		this.lEstadoCivil = new JLabel("Estado Civil");
		this.lEmail = new JLabel("Email");
		this.lLogradouro = new JLabel("Logradouro");
		this.lNumero = new JLabel("Número");
		this.lBairro = new JLabel("Bairro");
		this.lCep = new JLabel("CEP");
		this.lCidade = new JLabel("Cidade");
		this.lEstado = new JLabel("Estado");
		this.lComplemento = new JLabel("Complemento");
		this.lRespFinanceiro = new JLabel("Resp. Financ.");
		
		areaTrabalho.add(this.lTitulo).setBounds(300, 40, 100, 20);
		areaTrabalho.add(this.lNome).setBounds(80, 100, 100, 20);
		areaTrabalho.add(this.lCpf).setBounds(80, 130, 100, 20);
		areaTrabalho.add(this.lDataNascimento).setBounds(300, 130, 100, 20);
		areaTrabalho.add(this.lEstadoCivil).setBounds(300, 160, 100, 20);
		areaTrabalho.add(this.lEmail).setBounds(80, 190, 100, 20);
		areaTrabalho.add(this.lSexo).setBounds(80, 160, 100, 20);
		areaTrabalho.add(this.lLogradouro).setBounds(80, 220, 100, 20);
		areaTrabalho.add(this.lNumero).setBounds(370, 220, 100, 20);
		areaTrabalho.add(this.lBairro).setBounds(80, 250, 150, 20);
		areaTrabalho.add(this.lCep).setBounds(370, 250, 100, 20);
		areaTrabalho.add(this.lCidade).setBounds(80, 280, 100, 20);
		areaTrabalho.add(this.lEstado).setBounds(370, 280, 100, 20);
		areaTrabalho.add(this.lComplemento).setBounds(80, 310, 100, 20);
		areaTrabalho.add(this.lRespFinanceiro).setBounds(370, 190, 150, 20);
		
		this.tfNome = new JTextField(250);
		this.tfCpf = new JTextField(250);
		this.tfDataNascimento = new JTextField(250);
		this.tfSexo = new JTextField(250);
		this.tfEstadoCivil = new JTextField(250);
		this.tfEmail = new JTextField(250);
		this.tfLogradouro = new JTextField(250);
		this.tfNumero = new JTextField(250);
		this.tfBairro = new JTextField(250);
		this.tfCep = new JTextField(250);
		this.tfCidade = new JTextField(250);
		this.tfEstado = new JTextField(250);
		this.tfComplemento = new JTextField(250);
		this.tfRespFinanceiro = new JTextField(250);
		
		areaTrabalho.add(this.tfNome).setBounds(120, 100, 400, 20);
		areaTrabalho.add(this.tfCpf).setBounds(120, 130, 150, 20);
		areaTrabalho.add(this.tfDataNascimento).setBounds(370, 130, 150, 20);
		areaTrabalho.add(this.tfSexo).setBounds(120, 160, 150, 20);
		areaTrabalho.add(this.tfEstadoCivil).setBounds(370, 160, 150, 20);
		areaTrabalho.add(this.tfEmail).setBounds(120, 190, 220, 20);
		areaTrabalho.add(this.tfLogradouro).setBounds(150, 220, 190, 20);
		areaTrabalho.add(this.tfNumero).setBounds(430, 220, 90, 20);
		areaTrabalho.add(this.tfBairro).setBounds(120, 250, 220, 20);
		areaTrabalho.add(this.tfCep).setBounds(430, 250, 90, 20);
		areaTrabalho.add(this.tfCidade).setBounds(120, 280, 220, 20);
		areaTrabalho.add(this.tfEstado).setBounds(430, 280, 90, 20);
		areaTrabalho.add(this.tfComplemento).setBounds(170, 310, 350, 20);
		areaTrabalho.add(this.tfRespFinanceiro).setBounds(450, 190, 70, 20);
		
		this.btNovo = new JButton("Novo");
		this.btEditar = new JButton("Editar");
		this.btGravar = new JButton("Gravar");
		this.btCancelar = new JButton("Cancelar");
		this.btExcluir = new JButton("Excluir");
		this.btPreparar = new JButton("Preparar");
		this.btLocalizar = new JButton("Localizar");
		
		areaTrabalho.add(this.btNovo).setBounds(10, 350, 90, 30);
		areaTrabalho.add(this.btEditar).setBounds(105, 350, 90, 30);
		areaTrabalho.add(this.btGravar).setBounds(200, 350, 90, 30);
		areaTrabalho.add(this.btCancelar).setBounds(295, 350, 90, 30);
		areaTrabalho.add(this.btExcluir).setBounds(390, 350, 90, 30);
		areaTrabalho.add(this.btPreparar).setBounds(485, 350, 90, 30);
		areaTrabalho.add(this.btLocalizar).setBounds(580, 350, 90, 30);		
		
		this.btNovo.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoNovo();
						
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
				
		this.btGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoGravar();
				
			}
		});
	}
	
	public void limparCampos() {
		this.tfNome.setText("");
		this.tfCpf.setText("");
		this.tfDataNascimento.setText("");
		this.tfSexo.setText("");
		this.tfEstadoCivil.setText("");
		this.tfEmail.setText("");
		this.tfLogradouro.setText("");
		this.tfNumero.setText("");
		this.tfBairro.setText("");
		this.tfCep.setText("");
		this.tfCidade.setText("");
		this.tfEstado.setText("");
		this.tfComplemento.setText("");
		this.tfRespFinanceiro.setText("");
		
	}
	
	public void eventoEstadoInicial() {
		limparCampos();
		
		this.tfNome.setEnabled(false);
		this.tfCpf.setEnabled(false);
		this.tfDataNascimento.setEnabled(false);
		this.tfSexo.setEnabled(false);
		this.tfEstadoCivil.setEnabled(false);
		this.tfEmail.setEnabled(false);
		this.tfLogradouro.setEnabled(false);
		this.tfNumero.setEnabled(false);
		this.tfBairro.setEnabled(false);
		this.tfCep.setEnabled(false);
		this.tfCidade.setEnabled(false);
		this.tfEstado.setEnabled(false);
		this.tfComplemento.setEnabled(false);
		this.tfRespFinanceiro.setEnabled(false);
		
		this.btNovo.setEnabled(true);
		this.btPreparar.setEnabled(true);
		
		this.btCancelar.setEnabled(false);
		this.btEditar.setEnabled(false);
		this.btExcluir.setEnabled(false);
		this.btLocalizar.setEnabled(false);
		this.btGravar.setEnabled(false);
		
	}
	
	public void eventoBotaoNovo() {
		limparCampos();
		
		this.tfNome.setEnabled(true);
		this.tfCpf.setEnabled(true);
		this.tfDataNascimento.setEnabled(true);
		this.tfSexo.setEnabled(true);
		this.tfEstadoCivil.setEnabled(true);
		this.tfEmail.setEnabled(true);
		this.tfLogradouro.setEnabled(true);
		this.tfNumero.setEnabled(true);
		this.tfBairro.setEnabled(true);
		this.tfCep.setEnabled(true);
		this.tfCidade.setEnabled(true);
		this.tfEstado.setEnabled(true);
		this.tfComplemento.setEnabled(true);
		this.tfRespFinanceiro.setEnabled(true);
		
		this.btGravar.setEnabled(true);
		this.btCancelar.setEnabled(true);
		
		this.btEditar.setEnabled(false);
		this.btNovo.setEnabled(false);
		this.btExcluir.setEnabled(false);
		this.btLocalizar.setEnabled(false);
		this.btPreparar.setEnabled(false);
		
	}
	
	public void eventoBotaoPreparar() {
		limparCampos();
		
		this.tfNome.setEnabled(true);
		this.tfCpf.setEnabled(true);
		
		this.tfDataNascimento.setEnabled(false);
		this.tfSexo.setEnabled(false);
		this.tfEstadoCivil.setEnabled(false);
		this.tfEmail.setEnabled(false);
		this.tfLogradouro.setEnabled(false);
		this.tfNumero.setEnabled(false);
		this.tfBairro.setEnabled(false);
		this.tfCep.setEnabled(false);
		this.tfCidade.setEnabled(false);
		this.tfEstado.setEnabled(false);
		this.tfComplemento.setEnabled(false);
		this.tfRespFinanceiro.setEnabled(false);
		
		
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
		String nome = "";
		String cpf = "";
		
		if(!this.tfNome.getText().equals("")){
			nome = this.tfNome.getText();
			
		} else if(!this.tfCpf.getText().equals("")) {
			cpf = this.tfCpf.getText();
			
		}else {
			JOptionPane.showMessageDialog(null, "Digite um critério de busca. (Nome/CPF)");
		}
		
	}
	
	public void eventoBotaoGravar() {
		
		String nome = this.tfNome.getText();
		String cpf = this.tfCpf.getText();
		String dataNascimento = this.tfDataNascimento.getText();
		String sexo = this.tfSexo.getText();
		String estadoCivil = this.tfEstadoCivil.getText();
		String email = this.tfEmail.getText();
		String logradouro = this.tfLogradouro.getText();
		String numero = this.tfNumero.getText();
		String bairro = this.tfBairro.getText();
		String cep = this.tfCep.getText();
		String cidade = this.tfCidade.getText();
		String estado = this.tfEstado.getText();
		String complemento = this.tfComplemento.getText();
		String respFinanceiro = this.tfRespFinanceiro.getText();
		
		
		if(nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome!");
			
		}else if(cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o CPF!");
			
		}else if (dataNascimento.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite a data de nascimento!");
			
		}else if (sexo.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o sexo!");
			
		}else if(estadoCivil.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o estado civil");
			
		}else if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o email!");
			
		}else if (logradouro.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o logradouro!");
			
		}else if(numero.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o número!");
			
		}else if (bairro.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o bairro!");
			
		}else if (cep.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o CEP!");
			
		}else if(cidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite a cidade!");
			
		}else if (estado.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o estado!");
			
		}else if (complemento.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o complemento!");
		
		}else if (respFinanceiro.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o responsável financeiro!");
			
		}else {
			
			Hospede hospede = new Hospede (nome, cpf, dataNascimento, sexo, email, estadoCivil, logradouro, numero, bairro, cep, cidade, estado, complemento, respFinanceiro);
			
			RepositorioHospede rh = new RepositorioHospede();
			
			boolean resposta = rh.cadatrarHospede(hospede);
			
				if (resposta == true) {
					JOptionPane.showMessageDialog(null, "Hospede cadastrado com sucesso!");
					limparCampos();
					
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do hospede!");
				}	
			}			
		}
}
		

	

