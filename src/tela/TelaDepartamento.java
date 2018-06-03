package tela;
import javax.swing.JFrame;//Representa a montagem da tela do sistema
import javax.swing.ImageIcon;// Permite adicionar imagens a tela
import javax.swing.JLabel; //Permite adicionar texto na área de trabalho da tela
import javax.swing.JOptionPane;
import javax.swing.JTextField; //Caixa de digitação. Permite adicionar caixa de entrada texto na área de trabalho da tela

import negocio.Departamento;
import repositorio.RepositorioDepartamento;

import javax.swing.JButton; //Permite adicionar botões de controle na área de trabalho da tela
import java.awt.Container; //Controla a área da tela
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
	
	//13-Declarando os botões de controle da área de trabalho
	private JButton btNovo;
	private JButton btEditar;
	private JButton btGravar;
	private JButton btCancelar;
	private JButton btExcluir;
	private JButton btPreparar;
	private JButton btLocalizar;
	
	/*A variável CONTROLE controlará a operação que será executada
	quando o usuário clicar no botão GRAVAR. (criar um novo departamento
	ou alterar as informações de um departamento já existente). Essa variável
	estará presente nos métodos "public void eventoBotaoNovo()", "public void eventoBotaoGravar() e
	public void eventoBotaoEditar(). */
	private String controle;
	
	/*Armazena o codigo do departamento que terá as informações alteradas.
	Essa variável estará presente no método "public void eventoBotaoLocalizar()" e "public void eventoBotaoGravar()". */
	private String codigoAntigo;
	
	//2-Criando o construtor
  	public TelaDepartamento() {
		//6-Declaração dos métodos no constrtutor
		this.montarTela();
		this.componenteTela();
		this.mostrarTela();
		this.eventoEstadoInicial();
		
	}
	
	//3-Esse método será responsável em determinar todas as configurações iniciais da tela
	public void montarTela() {
		
		//Instanciando o objeto e acionando o nome da tela
		this.telaDepartamento = new JFrame("Sistemas::HT Hotel: Departamento");
		
		//Definindo as dimensões da tela no estado normal(largura, altura)
		this.telaDepartamento.setSize(690, 320);
		
		//Definindo a abertura da tela para o modo maximizado
		this.telaDepartamento.setExtendedState(JFrame.NORMAL);
		
		//Permitindo ao usuário redimensionar a tela
		this.telaDepartamento.setResizable(false);
		
		//Configurando a tela para aparecer no centro do monitor
		this.telaDepartamento.setLocationRelativeTo(null);
		
		//Definindo o método de fechamento da tela
		this.telaDepartamento.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Criando o objeto que receb o ícone do sistema à janela
		ImageIcon icone = new ImageIcon("src\\images.jpg");
		
		//Adicionando o ícone a tela
		this.telaDepartamento.setIconImage(icone.getImage());	
		
	}
	
	//4-Método responsável em tornar a tela visível
	public void mostrarTela() {
		
		//tornando a tela visível
		this.telaDepartamento.setVisible(true);
		
		//permitir que outras telas se sobrepõem a esta tela. A janela ficará ativa por cima da janela principal.
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
		this.lCodigo = new JLabel("Código");
		this.lSigla = new JLabel("Sigla");
		this.lNome = new JLabel("Nome");
		this.lDescricao = new JLabel("Descrição");
		
		//9-Adicionando e posicionando os textos na área de trabalho
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
		
		//12-Adicionando e posicionando os objetos de entrada de textos na área de trabalho. Caixa de texto.
		areaTrabalho.add(this.tfCodigo).setBounds(250, 100, 250, 20);
		areaTrabalho.add(this.tfSigla).setBounds(250, 130, 250, 20);
		areaTrabalho.add(this.tfNome).setBounds(250, 160, 250, 20);
		areaTrabalho.add(this.tfDescricao).setBounds(250, 190, 250, 20);
		
		//14-Instanciando os botões de controle da área de trabalho
		this.btNovo = new JButton("Novo");
		this.btEditar = new JButton("Editar");
		this.btGravar = new JButton("Gravar");
		this.btCancelar = new JButton("Cancelar");
		this.btExcluir = new JButton("Excluir");
		this.btPreparar = new JButton("Preparar");
		this.btLocalizar = new JButton("Localizar");
		
		//15-Adicionando os botões de controle da área de trabalho
		areaTrabalho.add(this.btNovo).setBounds(10, 250, 90, 30);
		areaTrabalho.add(this.btEditar).setBounds(105, 250, 90, 30);
		areaTrabalho.add(this.btGravar).setBounds(200, 250, 90, 30);
		areaTrabalho.add(this.btCancelar).setBounds(295, 250, 90, 30);
		areaTrabalho.add(this.btExcluir).setBounds(390, 250, 90, 30);
		areaTrabalho.add(this.btPreparar).setBounds(485, 250, 90, 30);
		areaTrabalho.add(this.btLocalizar).setBounds(580, 250, 90, 30);	
		
		//18.1-Para que o botão NOVO ative a funcionalidade
		this.btNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 eventoBotaoNovo();
				
			}
		});
		
		//19.1-Para que o botão PREPARAR ative a funcionalidade
		this.btPreparar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoPreparar();
			}
		});
		
		//20.1-Para que o botão CANCELAR ative a funcionalidade
		this.btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoCancelar();
				
			}
		});
		
		//21.1-Para que o botão LOCALIZAR ative a funcionalidade
		this.btLocalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoBotaoLocalizar();
				
			}
		});
		
		//22.1-Para que o botão GRAVAR ative a funcionalidade
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
		
		//17-Definindo a configuração inicial dos elementos da tela
		public void eventoEstadoInicial() {
			limparCampos();
			//Bloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(false);
			this.tfSigla.setEnabled(false);
			this.tfNome.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
			//Ativando os botões
			this.btNovo.setEnabled(true);
			this.btPreparar.setEnabled(true);
			
			//Bloqueando os botões
			this.btCancelar.setEnabled(false);
			this.btEditar.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			this.btGravar.setEnabled(false);
		}
		
		//18-Eventos do botão NOVO
		public void eventoBotaoNovo() {
			limparCampos();
			
			//Variável de controle para adicionar novo registro
			this.controle = "novo";
			
			//Desbloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(true);
			this.tfSigla.setEnabled(true);
			this.tfNome.setEnabled(true);
			this.tfDescricao.setEnabled(true);
			
			//Ativando os botões
			this.btGravar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			//Bloqueando os botões
			this.btEditar.setEnabled(false);
			this.btNovo.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			this.btPreparar.setEnabled(false);
			
		}
		
		//19-Eventos do botão PREPARAR
		public void eventoBotaoPreparar() {
			limparCampos();
			
			//Desbloqueando os campos de entrada de dados
			this.tfCodigo.setEnabled(true);
			this.tfSigla.setEnabled(true);
			
			//Bloqueando os campos
			this.tfNome.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
			//Ativando os botões
			this.btLocalizar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			//Bloqueando os botões
			this.btEditar.setEnabled(false);
			this.btNovo.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btGravar.setEnabled(false);
			this.btPreparar.setEnabled(false);	
			
		}
		
		//20-Eventos do botão CANCELAR
		public void eventoBotaoCancelar() {
			eventoEstadoInicial();
		}
		
		//21-Eventos do botão LOCALIZAR 
		public void eventoBotaoLocalizar() {
			String codigo = "";
			String sigla = "";
			
			//Criação do repositório para retorno das informações do banco
			RepositorioDepartamento rd = new RepositorioDepartamento();
			
				if(!this.tfCodigo.getText().equals("")){
				codigo = this.tfCodigo.getText();
				
					//Verificação se o código existe
					if(rd.departamentoExiste(codigo) == true) {
						
						//Criação do objeto para recebimento do parâmetro de consulta pelo CODIGO
						Departamento departamento = rd.consultaDepartamentoCodigo(codigo);
				
						//Retorno das informações para aparecimento na tela
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
						
						JOptionPane.showMessageDialog(null, "Não foi possóvel "+
														"localizar o departamento.");
					}
				
				} else if(!this.tfSigla.getText().equals("")) {
				sigla = this.tfSigla.getText();
				
					//Criação do objeto para recebimento do parâmetro de consulta pela SIGLA
					Departamento departamento = rd.consultaDepartamentoSigla(sigla);
				
					//Retorno das informações para aparecimento na tela
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
					
				JOptionPane.showMessageDialog(null, "Digite um critério de busca. (Código/Sigla)");
			}
			
		}
		
		//22-Eventos do botão GRAVAR
		public void eventoBotaoGravar() {
			//Capturar as informações da tela
			String codigo = this.tfCodigo.getText();
			String sigla = this.tfSigla.getText();
			String nome = this.tfNome.getText();
			String descricao = this.tfDescricao.getText();
			
			//Validar essas informações
			if(codigo.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o código do departamento");
				
			}else if(sigla.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a sigla do departamento");
				
			}else if (nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o nome do departamento");
				
			}else if (descricao.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a descrição do departamento");
				
			}else {
				
				//Criação do objeto o qual será enviado para o repositório
				Departamento departamento = new Departamento(codigo, nome, sigla, descricao);
				//Inclusão do repositório para retorno das informações do banco
				RepositorioDepartamento rd = new RepositorioDepartamento();
				//Variável para confirmação do evento GRAVAR
				
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
								JOptionPane.showMessageDialog(null, "Informações foram alteradas com sucesso");
						
								eventoEstadoInicial();
						
							}else {
								JOptionPane.showMessageDialog(null, "Erro ao tentar alterar as informações");
							
					}
					
				}
			}
		}
		
		//Evento do botão EDITAR
		public void eventoBotaoEditar() {
			
			//Variável de controle para editar um registro
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
		
		//Evento do botão EXCLUIR
		public void eventoBotaoExcluir() {
			
			//String codigo = this.tfCodigo.getText(); Pode ser usado dessa forma também.
			
			int valor = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o departamento?");
			
				if(valor == 0) {
			
					RepositorioDepartamento rd = new RepositorioDepartamento();
			
					boolean resposta = rd.excluirDepartamento(codigoAntigo);
			
					if(resposta == true) {
				
						JOptionPane.showMessageDialog(null, "Departamento excluído com sucesso!");
				
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

