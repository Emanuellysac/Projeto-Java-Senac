package tela;
import javax.swing.JFrame;//Representa a montagem da tela do sistema
import javax.swing.ImageIcon;// Permite adicionar imagens a tela
import javax.swing.JLabel; //Permite adicionar texto na �rea de trabalho da tela
import javax.swing.JOptionPane;
import javax.swing.JTextField; //Caixa de digita��o. Permite adicionar caixa de entrada texto na �rea de trabalho da tela

import negocio.Departamento;
import repositorio.RepositorioDepartamento;

import javax.swing.JButton; //Permite adicionar bot�es de controle na �rea de trabalho da tela
import java.awt.Container; //Controla a �rea da tela
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDepartamento {
	
	//1-Declarando o objeto da tela
	private JFrame telaDepartamento;
	
	//7-Declarando os objetos de textos
	private JLabel lTitulo;
	private JLabel lCodigo;
	private JLabel lSigla;
	private JLabel lNome;
	private JLabel lDescricao;
	
	//10-Declarando os objetos de entrada de texto. Caixas de texto.
	private JTextField tfCodigo;
	private JTextField tfSigla;
	private JTextField tfNome;
	private JTextField tfDescricao;
	
	//13-Declarando os bot�es de controle da �rea de trabalho
	private JButton btNovo;
	private JButton btEditar;
	private JButton btGravar;
	private JButton btCancelar;
	private JButton btExcluir;
	private JButton btPreparar;
	private JButton btLocalizar;
	
	/*A vari�vel CONTROLE controlar� a opera��o que ser� executada
	quando o usu�rio clicar no bot�o GRAVAR. (criar um novo departamento
	ou alterar as informa��es de um departamento j� existente). Essa vari�vel
	estar� presente nos m�todos "public void eventoBotaoNovo()", "public void eventoBotaoGravar() e
	public void eventoBotaoEditar(). */
	private String controle;
	
	/*Armazena o codigo do departamento que ter� as informa��es alteradas.
	Essa vari�vel estar� presente no m�todo "public void eventoBotaoLocalizar()" e "public void eventoBotaoGravar()". */
	private String codigoAntigo;
	
	//2-Criando o construtor
  	public TelaDepartamento() {
		//6-Declara��o dos m�todos no constrtutor
		this.montarTela();
		this.componenteTela();
		this.mostrarTela();
		this.eventoEstadoInicial();
		
	}
	
	//3-Esse m�todo ser� respons�vel em determinar todas as configura��es iniciais da tela
	public void montarTela() {
		
		//Instanciando o objeto e acionando o nome da tela
		this.telaDepartamento = new JFrame("Sistemas::HT Hotel: Departamento");
		
		//Definindo as dimens�es da tela no estado normal(largura, altura)
		this.telaDepartamento.setSize(690, 320);
		
		//Definindo a abertura da tela para o modo maximizado
		this.telaDepartamento.setExtendedState(JFrame.NORMAL);
		
		//Permitindo ao usu�rio redimensionar a tela
		this.telaDepartamento.setResizable(false);
		
		//Configurando a tela para aparecer no centro do monitor
		this.telaDepartamento.setLocationRelativeTo(null);
		
		//Definindo o m�todo de fechamento da tela
		this.telaDepartamento.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Criando o objeto que receb o �cone do sistema � janela
		ImageIcon icone = new ImageIcon("src\\images.jpg");
		
		//Adicionando o �cone a tela
		this.telaDepartamento.setIconImage(icone.getImage());	
		
	}
	
	//4-M�todo respons�vel em tornar a tela vis�vel
	public void mostrarTela() {
		
		//tornando a tela vis�vel
		this.telaDepartamento.setVisible(true);
		
		//permitir que outras telas se sobrep�em a esta tela. A janela ficar� ativa por cima da janela principal.
		this.telaDepartamento.setAlwaysOnTop(false);
		
	}
	
	//5-Componentes da tela
	public void componenteTela() {
		
		//Atribuindo o controle da area de trabalho ao objeto areaTrabalho
		Container areaTrabalho = this.telaDepartamento.getContentPane();
		
		//Definindo o alinhamento manual dos elementos da tela
		areaTrabalho.setLayout(null);
		
		//8-Instanciando os objetos de textos
		this.lTitulo = new JLabel("Departamento");
		this.lCodigo = new JLabel("C�digo");
		this.lSigla = new JLabel("Sigla");
		this.lNome = new JLabel("Nome");
		this.lDescricao = new JLabel("Descri��o");
		
		//9-Adicionando e posicionando os textos na �rea de trabalho
		areaTrabalho.add(this.lTitulo).setBounds(300, 40, 100, 20);
		areaTrabalho.add(this.lCodigo).setBounds(160, 100, 100, 20);
		areaTrabalho.add(this.lSigla).setBounds(160, 130, 100, 20);
		areaTrabalho.add(this.lNome).setBounds(160, 160, 100, 20);
		areaTrabalho.add(this.lDescricao).setBounds(160, 190, 100, 20);
		
		//11-Instanciando os objetos de entrada de textos. Caixa de texto
		this.tfCodigo = new JTextField(250);
		this.tfSigla = new JTextField(250);
		this.tfNome = new JTextField(250);
		this.tfDescricao = new JTextField(250);
		
		//12-Adicionando e posicionando os objetos de entrada de textos na �rea de trabalho. Caixa de texto.
		areaTrabalho.add(this.tfCodigo).setBounds(250, 100, 250, 20);
		areaTrabalho.add(this.tfSigla).setBounds(250, 130, 250, 20);
		areaTrabalho.add(this.tfNome).setBounds(250, 160, 250, 20);
		areaTrabalho.add(this.tfDescricao).setBounds(250, 190, 250, 20);
		
		//14-Instanciando os bot�es de controle da �rea de trabalho
		this.btNovo = new JButton("Novo");
		this.btEditar = new JButton("Editar");
		this.btGravar = new JButton("Gravar");
		this.btCancelar = new JButton("Cancelar");
		this.btExcluir = new JButton("Excluir");
		this.btPreparar = new JButton("Preparar");
		this.btLocalizar = new JButton("Localizar");
		
		//15-Adicionando os bot�es de controle da �rea de trabalho
		areaTrabalho.add(this.btNovo).setBounds(10, 250, 90, 30);
		areaTrabalho.add(this.btEditar).setBounds(105, 250, 90, 30);
		areaTrabalho.add(this.btGravar).setBounds(200, 250, 90, 30);
		areaTrabalho.add(this.btCancelar).setBounds(295, 250, 90, 30);
		areaTrabalho.add(this.btExcluir).setBounds(390, 250, 90, 30);
		areaTrabalho.add(this.btPreparar).setBounds(485, 250, 90, 30);
		areaTrabalho.add(this.btLocalizar).setBounds(580, 250, 90, 30);	
		
		//18.1-Para que o bot�o NOVO ative a funcionalidade
		this.btNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 eventoBotaoNovo();
				
			}
		});
		
		//19.1-Para que o bot�o PREPARAR ative a funcionalidade
		this.btPreparar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoPreparar();
			}
		});
		
		//20.1-Para que o bot�o CANCELAR ative a funcionalidade
		this.btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoCancelar();
				
			}
		});
		
		//21.1-Para que o bot�o LOCALIZAR ative a funcionalidade
		this.btLocalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoLocalizar();
				
			}
		});
		
		//22.1-Para que o bot�o GRAVAR ative a funcionalidade
		this.btGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoGravar();
				
			}
		});
		
		this.btEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoEditar();
				
			}
		});
		
		this.btExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoExcluir();
				
			}
		});
					
	}
	
		//16-Limpar as caixas de entrada de dados
		public void limparCampos() {
			this.tfCodigo.setText("");
			this.tfSigla.setText("");
			this.tfNome.setText("");
			this.tfDescricao.setText("");
			
		}
		
		//EVENTOS//
		
		//17-Definindo a configura��o inicial dos elementos da tela
		public void eventoEstadoInicial() {
			limparCampos();
			//Bloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(false);
			this.tfSigla.setEnabled(false);
			this.tfNome.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
			//Ativando os bot�es
			this.btNovo.setEnabled(true);
			this.btPreparar.setEnabled(true);
			
			//Bloqueando os bot�es
			this.btCancelar.setEnabled(false);
			this.btEditar.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			this.btGravar.setEnabled(false);
		}
		
		//18-Eventos do bot�o NOVO
		public void eventoBotaoNovo() {
			limparCampos();
			
			//Vari�vel de controle para adicionar novo registro
			this.controle = "novo";
			
			//Desbloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(true);
			this.tfSigla.setEnabled(true);
			this.tfNome.setEnabled(true);
			this.tfDescricao.setEnabled(true);
			
			//Ativando os bot�es
			this.btGravar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			//Bloqueando os bot�es
			this.btEditar.setEnabled(false);
			this.btNovo.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			this.btPreparar.setEnabled(false);
			
		}
		
		//19-Eventos do bot�o PREPARAR
		public void eventoBotaoPreparar() {
			limparCampos();
			
			//Desbloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(true);
			this.tfSigla.setEnabled(true);
			
			//Bloqueando os campos
			this.tfNome.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
			//Ativando os bot�es
			this.btLocalizar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			//Bloqueando os bot�es
			this.btEditar.setEnabled(false);
			this.btNovo.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btGravar.setEnabled(false);
			this.btPreparar.setEnabled(false);	
			
		}
		
		//20-Eventos do bot�o CANCELAR
		public void eventoBotaoCancelar() {
			eventoEstadoInicial();
		}
		
		//21-Eventos do bot�o LOCALIZAR 
		public void eventoBotaoLocalizar() {
			String codigo = "";
			String sigla = "";
			
			//Cria��o do reposit�rio para retorno das informa��es do banco
			RepositorioDepartamento rd = new RepositorioDepartamento();
			
				if(!this.tfCodigo.getText().equals("")){
				codigo = this.tfCodigo.getText();
				
					//Verifica��o se o c�digo existe
					if(rd.departamentoExiste(codigo) == true) {
						
						//Cria��o do objeto para recebimento do par�metro de consulta pelo CODIGO
						Departamento departamento = rd.consultaDepartamentoCodigo(codigo);
				
						//Retorno das informa��es para aparecimento na tela
						this.tfCodigo.setText(departamento.getCodigo());
						this.tfSigla.setText(departamento.getSigla());
						this.tfNome.setText(departamento.getNomeDepartamento());
						this.tfDescricao.setText(departamento.getDescricao());
						
						this.btEditar.setEnabled(true);
						this.btExcluir.setEnabled(true);
						this.btCancelar.setEnabled(true);
						
						this.btNovo.setEnabled(false);
						this.btGravar.setEnabled(false);
						this.btLocalizar.setEnabled(false);
						this.btPreparar.setEnabled(false);	
						
						this.codigoAntigo = departamento.getCodigo();
						
					}else {
						
						JOptionPane.showMessageDialog(null, "N�o foi poss�vel "+
														"localizar o departamento.");
					}
				
				} else if(!this.tfSigla.getText().equals("")) {
				sigla = this.tfSigla.getText();
				
					//Cria��o do objeto para recebimento do par�metro de consulta pela SIGLA
					Departamento departamento = rd.consultaDepartamentoSigla(sigla);
				
					//Retorno das informa��es para aparecimento na tela
					this.tfCodigo.setText(departamento.getCodigo());
					this.tfSigla.setText(departamento.getSigla());
					this.tfNome.setText(departamento.getNomeDepartamento());
					this.tfDescricao.setText(departamento.getDescricao());
					
					this.btEditar.setEnabled(true);
					this.btExcluir.setEnabled(true);
					this.btCancelar.setEnabled(true);
					
					this.btNovo.setEnabled(false);
					this.btGravar.setEnabled(false);
					this.btLocalizar.setEnabled(false);
					this.btPreparar.setEnabled(false);
				
				}else {
					
				JOptionPane.showMessageDialog(null, "Digite um crit�rio de busca. (C�digo/Sigla)");
			}
			
		}
		
		//22-Eventos do bot�o GRAVAR
		public void eventoBotaoGravar() {
			//Capturar as informa��es da tela
			String codigo = this.tfCodigo.getText();
			String sigla = this.tfSigla.getText();
			String nome = this.tfNome.getText();
			String descricao = this.tfDescricao.getText();
			
			//Validar essas informa��es
			if(codigo.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o c�digo do departamento");
				
			}else if(sigla.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a sigla do departamento");
				
			}else if (nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o nome do departamento");
				
			}else if (descricao.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a descri��o do departamento");
				
			}else {
				
				//Cria��o do objeto o qual ser� enviado para o reposit�rio
				Departamento departamento = new Departamento(codigo, nome, sigla, descricao);
				//Inclus�o do reposit�rio para retorno das informa��es do banco
				RepositorioDepartamento rd = new RepositorioDepartamento();
				//Vari�vel para confirma��o do evento GRAVAR
				
				//Cadastrar um novo registro
					if(this.controle.equals("novo")) {
					
						boolean resposta = rd.cadatrarDepartamento(departamento);
					
							if (resposta == true) {
								JOptionPane.showMessageDialog(null, "Departamento cadastrado com sucesso");
								limparCampos();
						
							}else {
								JOptionPane.showMessageDialog(null, "Falha no cadastro do departamento");
						
							}
						
					//Alterar um registro existente	
					}else if (this.controle.equals("editar")) {
					
						boolean resposta = rd.alterarDepartamento(departamento, codigoAntigo);
					
							if (resposta == true) {
								JOptionPane.showMessageDialog(null, "Informa��es foram alteradas com sucesso");
						
								eventoEstadoInicial();
						
							}else {
								JOptionPane.showMessageDialog(null, "Erro ao tentar alterar as informa��es");
							
					}
					
				}
			}
		}
		
		//Evento do bot�o EDITAR
		public void eventoBotaoEditar() {
			
			//Vari�vel de controle para editar um registro
			this.controle = "editar";
			
			this.tfCodigo.setEnabled(true);
			this.tfSigla.setEnabled(true);
			this.tfNome.setEnabled(true);
			this.tfDescricao.setEnabled(true);
			
			this.btGravar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			this.btNovo.setEnabled(false);
			this.btEditar.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btPreparar.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			
		}
		
		//Evento do bot�o EXCLUIR
		public void eventoBotaoExcluir() {
			
			//String codigo = this.tfCodigo.getText(); Pode ser usado dessa forma tamb�m.
			
			int valor = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o departamento?");
			
				if(valor == 0) {
			
					RepositorioDepartamento rd = new RepositorioDepartamento();
			
					boolean resposta = rd.excluirDepartamento(codigoAntigo);
			
					if(resposta == true) {
				
						JOptionPane.showMessageDialog(null, "Departamento exclu�do com sucesso!");
				
						eventoEstadoInicial();
				
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o departamento");
						}
				}
				
				if(valor == 2) {
					
					eventoEstadoInicial();		
				}
		}
}

