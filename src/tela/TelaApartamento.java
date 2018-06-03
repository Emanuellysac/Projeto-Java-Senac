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

import negocio.Apartamento;
import negocio.Departamento;
import repositorio.RepositorioApartamento;
import repositorio.RepositorioDepartamento;



public class TelaApartamento {
		
		private JFrame telaApartamento;
		
		private JLabel lTitulo;
		private JLabel lNumero;
		private JLabel lCapacidadeMaxima;
		private JLabel lValor;
		private JLabel lCategoria;
		private JLabel lDescricao;
		
		private JTextField tfNumero;
		private JTextField tfCapacidadeMaxima;
		private JTextField tfValor;
		private JTextField tfCategoria;
		private JTextField tfDescricao;
		
		private JButton btNovo;
		private JButton btEditar;
		private JButton btGravar;
		private JButton btCancelar;
		private JButton btExcluir;
		private JButton btPreparar;
		private JButton btLocalizar;
		
		private String controle;
		
		private String numeroAntigo;
		
		public TelaApartamento() {
			this.montarTela();
			this.componenteTela();
			this.mostrarTela();
			this.eventoEstadoInicial();
			
		}
		
		public void montarTela() {
			
			this.telaApartamento = new JFrame("Sistemas::HT Hotel: Apartamento");
			
			this.telaApartamento.setSize(690, 320);
			
			this.telaApartamento.setExtendedState(JFrame.NORMAL);
			
			this.telaApartamento.setResizable(false);
			
			this.telaApartamento.setLocationRelativeTo(null);
			
			this.telaApartamento.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			ImageIcon icone = new ImageIcon("src\\images.jpg");
			
			this.telaApartamento.setIconImage(icone.getImage());
			
		}
		
		public void mostrarTela() {
			
			this.telaApartamento.setVisible(true);
			
			this.telaApartamento.setAlwaysOnTop(false);
			
		}
		
		public void componenteTela() {
			
			Container areaTrabalho = this.telaApartamento.getContentPane();
			
			areaTrabalho.setLayout(null);
			
			this.lTitulo = new JLabel("Apartamentos");
			this.lNumero = new JLabel("Número");
			this.lCapacidadeMaxima = new JLabel("Capacidade Max.");
			this.lValor = new JLabel("Valor");
			this.lCategoria = new JLabel("Categoria");
			this.lDescricao = new JLabel("Descrição");
			
			areaTrabalho.add(this.lTitulo).setBounds(300, 40, 100, 20);
			areaTrabalho.add(this.lNumero).setBounds(160, 70, 100, 20);
			areaTrabalho.add(this.lCapacidadeMaxima).setBounds(160, 100, 120, 20);
			areaTrabalho.add(this.lValor).setBounds(160, 130, 100, 20);
			areaTrabalho.add(this.lCategoria).setBounds(160, 160, 100, 20);
			areaTrabalho.add(this.lDescricao).setBounds(160, 190, 100, 20);
			
			this.tfNumero = new JTextField(250);
			this.tfCapacidadeMaxima = new JTextField(250);
			this.tfValor = new JTextField(250);
			this.tfCategoria = new JTextField(250);
			this.tfDescricao = new JTextField(250);
			
			areaTrabalho.add(this.tfNumero).setBounds(250, 70, 250, 20);
			areaTrabalho.add(this.tfCapacidadeMaxima).setBounds(260, 100, 240, 20);
			areaTrabalho.add(this.tfValor).setBounds(250, 130, 250, 20);
			areaTrabalho.add(this.tfCategoria).setBounds(250, 160, 250, 20);
			areaTrabalho.add(this.tfDescricao).setBounds(250, 190, 250, 20);
			
			this.btNovo = new JButton("Novo");
			this.btEditar = new JButton("Editar");
			this.btGravar = new JButton("Gravar");
			this.btCancelar = new JButton("Cancelar");
			this.btExcluir = new JButton("Excluir");
			this.btPreparar = new JButton("Preparar");
			this.btLocalizar = new JButton("Localizar");
			
			areaTrabalho.add(this.btNovo).setBounds(10, 250, 90, 30);
			areaTrabalho.add(this.btEditar).setBounds(105, 250, 90, 30);
			areaTrabalho.add(this.btGravar).setBounds(200, 250, 90, 30);
			areaTrabalho.add(this.btCancelar).setBounds(295, 250, 90, 30);
			areaTrabalho.add(this.btExcluir).setBounds(390, 250, 90, 30);
			areaTrabalho.add(this.btPreparar).setBounds(485, 250, 90, 30);
			areaTrabalho.add(this.btLocalizar).setBounds(580, 250, 90, 30);	
			
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
		
		public void limparCampos() {
			this.tfNumero.setText("");
			this.tfCapacidadeMaxima.setText("");
			this.tfValor.setText("");
			this.tfCategoria.setText("");
			this.tfDescricao.setText("");
			
		}
		
		public void eventoEstadoInicial() {
			limparCampos();
			
			this.tfNumero.setEnabled(false);
			this.tfCapacidadeMaxima.setEnabled(false);
			this.tfValor.setEnabled(false);
			this.tfCategoria.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
			this.btNovo.setEnabled(true);
			this.btPreparar.setEnabled(true);
			
			this.btCancelar.setEnabled(false);
			this.btEditar.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			this.btGravar.setEnabled(false);
		}
		
		public void eventoBotaoNovo () {
			limparCampos();
			
			this.controle = "novo";
			
			this.tfNumero.setEnabled(true);
			this.tfCapacidadeMaxima.setEnabled(true);
			this.tfValor.setEnabled(true);
			this.tfCategoria.setEnabled(true);
			this.tfDescricao.setEnabled(true);
			
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
			
			this.tfNumero.setEnabled(true);
			
			this.tfCapacidadeMaxima.setEnabled(false);
			this.tfValor.setEnabled(false);
			this.tfCategoria.setEnabled(false);
			this.tfDescricao.setEnabled(false);
			
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
			String numero = "";
			
			RepositorioApartamento ra = new RepositorioApartamento();
			
			if(!this.tfNumero.getText().equals("")) {
				numero = this.tfNumero.getText();
			}
				
				if(ra.apartamentoExiste(numero) == true) {
					 Apartamento apartamento = ra.consultaApartamentoNumero(numero);
					 
					 	this.tfNumero.setText(String.valueOf(apartamento.getNumero()));
						this.tfCapacidadeMaxima.setText(String.valueOf(apartamento.getCapacidadeMaxima()));
						this.tfValor.setText(String.valueOf(apartamento.getValor()));
						this.tfCategoria.setText(apartamento.getCategoria());
						this.tfDescricao.setText(apartamento.getDescricao());
						
						this.btEditar.setEnabled(true);
						this.btExcluir.setEnabled(true);
						this.btCancelar.setEnabled(true);
						
						this.btNovo.setEnabled(false);
						this.btGravar.setEnabled(false);
						this.btLocalizar.setEnabled(false);
						this.btPreparar.setEnabled(false);	
						
						this.numeroAntigo = (String.valueOf(apartamento.getNumero()));
					
			} else {
				JOptionPane.showMessageDialog(null, "Digite o número do apartamento.");
			}
				
		}
				
		public void eventoBotaoGravar() {
			
			String numero = this.tfNumero.getText();
			int numero1 = Integer.parseInt(numero);
			String capacidadeMaxima = this.tfCapacidadeMaxima.getText();
			int capacidadeMaxima1 = Integer.parseInt(capacidadeMaxima);
			String valor = this.tfValor.getText();
			double valor1 = Double.parseDouble(valor);
			String categoria = this.tfCategoria.getText();
			String descricao = this.tfDescricao.getText();
			
			if(numero.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o número do apartamento");
				
			}else if(capacidadeMaxima.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a capacidade máxima do apartamento");
				
			}else if (valor.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite o valor do apartamento");
				
			}else if (categoria.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a categoria do apartamento");
			
			}else if (descricao.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite a descrição do apartamento");
				
			}else {
				
					Apartamento apartamento = new Apartamento(numero1, capacidadeMaxima1, valor1, categoria, descricao);
				
					RepositorioApartamento ra = new RepositorioApartamento();
					
					if(this.controle.equals("novo")) {	
						
						boolean resposta = ra.cadastrarApartamento(apartamento);
						
						if(resposta == true) {
							JOptionPane.showMessageDialog(null, "Apartamento cadastrado com sucesso!");
							limparCampos();
							
						}else {
							JOptionPane.showMessageDialog(null, "Falha no cadastro do Apartamento!");
							
						}
						
					}else if (this.controle.equals("editar")) {
						
						boolean resposta = ra.cadastrarApartamento(apartamento);
					
								if(resposta == true) {
									JOptionPane.showMessageDialog(null, "Informações foram alteradas com sucesso");
									
									eventoEstadoInicial();
									
								}else {
									JOptionPane.showMessageDialog(null, "Erro ao tentar alterar as informações");	
								}				
					}
		       }
		}
				
		public void eventoBotaoEditar() {
			
			this.controle = "editar";
			
			this.tfNumero.setEnabled(true);
			this.tfCapacidadeMaxima.setEnabled(true);
			this.tfValor.setEnabled(true);
			this.tfCategoria.setEnabled(true);
			this.tfDescricao.setEnabled(true);
				
			this.btGravar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			
			this.btNovo.setEnabled(false);
			this.btEditar.setEnabled(false);
			this.btExcluir.setEnabled(false);
			this.btPreparar.setEnabled(false);
			this.btLocalizar.setEnabled(false);
			
		}
		
		public void eventoBotaoExcluir() {
			
			int valor = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse apartamento?");
			
				if(valor == 0) {
			
					RepositorioApartamento ra = new RepositorioApartamento();
			
					boolean resposta = ra.excluirApartamento(numeroAntigo);
			
					if(resposta == true) {
				
						JOptionPane.showMessageDialog(null, "Apartamento excluído com sucesso!");
				
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




