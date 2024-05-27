package telas;
import classes.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TelaAluno {

	protected JFrame frame;
	private Aluno alunoLogado = TelaLoginAluno.getAlunoLogado();
	private JTable table;
	private JTextField codInput;
	private JTextField codTrancar;
	private JTextField matriculaRedefinir;
	private JPasswordField novaSenha;
	private JPasswordField novaSenha2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno window = new TelaAluno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAluno() {
		initialize();
		frame.setBackground(new Color(217, 217, 217));
		frame.setTitle("Aluno");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelLateral = new JPanel();
		painelLateral.setBackground(new Color(128, 128, 128));
		painelLateral.setBounds(0, 0, 250, 561);
		painelPrincipal.add(painelLateral);
		painelLateral.setLayout(null);
		
		JButton botaoMatricula = new JButton("Dados de Matrícula");
		botaoMatricula.setForeground(new Color(0, 0, 0));
		botaoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoMatricula.setBackground(new Color(84, 84, 84));
		
		botaoMatricula.setBounds(34, 148, 179, 35);
		painelLateral.add(botaoMatricula);
		
		JButton botaoBoletim = new JButton("Boletim");
		botaoBoletim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoBoletim.setForeground(new Color(0, 0, 0));
		botaoBoletim.setToolTipText("");
		botaoBoletim.setBackground(new Color(84, 84, 84));
		botaoBoletim.setBounds(34, 200, 179, 35);
		painelLateral.add(botaoBoletim);
		
		JButton botaoAdicionarDisciplina = new JButton("Adicionar Disciplina");
		botaoAdicionarDisciplina.setForeground(new Color(0, 0, 0));
		botaoAdicionarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoAdicionarDisciplina.setBackground(new Color(84, 84, 84));
		botaoAdicionarDisciplina.setBounds(34, 252, 179, 35);
		painelLateral.add(botaoAdicionarDisciplina);
		
		JButton botaoTrancarDisciplina = new JButton("Trancar Disciplina");
		botaoTrancarDisciplina.setForeground(new Color(0, 0, 0));
		botaoTrancarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoTrancarDisciplina.setBackground(new Color(84, 84, 84));
		botaoTrancarDisciplina.setBounds(34, 304, 179, 35);
		painelLateral.add(botaoTrancarDisciplina);
		
		JButton botaoRedefinirSenha = new JButton("Redefinir Senha");
		botaoRedefinirSenha.setForeground(new Color(0, 0, 0));
		botaoRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRedefinirSenha.setBackground(new Color(84, 84, 84));
		botaoRedefinirSenha.setBounds(34, 356, 179, 35);
		painelLateral.add(botaoRedefinirSenha);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(new Color(0, 0, 0));
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoSair.setBackground(new Color(255, 87, 87));
		botaoSair.setBounds(68, 409, 110, 35);
		painelLateral.add(botaoSair);
		
		JLabel labelSistema = new JLabel("<html>Sistema<br>     Escolar</html>");
		labelSistema.setHorizontalAlignment(SwingConstants.CENTER);
		labelSistema.setFont(new Font("Tahoma", Font.BOLD, 35));
		labelSistema.setBounds(34, 23, 179, 100);
		painelLateral.add(labelSistema);
	
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
	                    frame,
	                    "Tem certeza que deseja sair?",
	                    "Sair",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE
	            );
				
				if(resposta == JOptionPane.YES_OPTION) {
					TelaLoginAluno telaLogin = new TelaLoginAluno();
			        telaLogin.frmLogin.setVisible(true);;
			        
			        TelaLoginAluno.setAlunoLogado(null);
			        frame.dispose();
				}
			}
		});
		
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBackground(new Color(192, 192, 192));
		cardPanel.setBounds(251, 0, 533, 561);
		painelPrincipal.add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelInicial, "PainelInicial");
		panelInicial.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Olá, "+alunoLogado.getNome()+"!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(38, 45, 416, 51);
		panelInicial.add(lblNewLabel);
		
		JPanel panelDadosMatricula = new JPanel();
		panelDadosMatricula.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelDadosMatricula, "painelDadosMatricula");
		panelDadosMatricula.setLayout(null);
		
		JLabel tituloDadosAluno = new JLabel("Dados do Aluno:");
		tituloDadosAluno.setFont(new Font("Tahoma", Font.BOLD, 25));
		tituloDadosAluno.setForeground(new Color(0, 0, 0));
		tituloDadosAluno.setBounds(38, 140, 269, 37);
		panelDadosMatricula.add(tituloDadosAluno);
		
		JPanel panelDados = new JPanel();
		panelDados.setBackground(new Color(223, 223, 223));
		panelDados.setBounds(38, 175, 455, 350);
		panelDadosMatricula.add(panelDados);
		panelDados.setLayout(null);
		
		JLabel cpfLabel = new JLabel("CPF: ");
		cpfLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cpfLabel.setBounds(30, 25, 79, 26);
		panelDados.add(cpfLabel);
		
		JLabel cpf = new JLabel(alunoLogado.getCpf());
		cpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		cpf.setBounds(40, 50, 215, 26);
		panelDados.add(cpf);
		
		JLabel matricula = new JLabel(alunoLogado.getMatricula());
		matricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		matricula.setBounds(40, 124, 215, 26);
		panelDados.add(matricula);
		
		JLabel lblMatricula = new JLabel("Matricula: ");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatricula.setBounds(30, 87, 93, 26);
		panelDados.add(lblMatricula);
		
		JLabel nome = new JLabel(alunoLogado.getNome());
		nome.setFont(new Font("Tahoma", Font.BOLD, 15));
		nome.setBounds(40, 198, 244, 26);
		panelDados.add(nome);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(30, 161, 79, 26);
		panelDados.add(lblNome);
		
		JLabel lblCra = new JLabel("CRA: ");
		lblCra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCra.setBounds(30, 235, 49, 26);
		panelDados.add(lblCra);
		
		JLabel cra = new JLabel(String.valueOf(alunoLogado.getCra()));
		cra.setFont(new Font("Tahoma", Font.BOLD, 15));
		cra.setBounds(40, 272, 215, 26);
		panelDados.add(cra);
		
		JPanel panelBoletim = new JPanel();
		panelBoletim.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelBoletim, "painelBoletim");
		panelBoletim.setLayout(null);
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 175, 455, 346);
		panelBoletim.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(46, 120, 440, 346);
		scrollPane.setViewportView(table);
		
		
		JLabel lblBoletim = new JLabel("Boletim:");
		lblBoletim.setForeground(Color.BLACK);
		lblBoletim.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBoletim.setBounds(38, 140, 269, 37);
		panelBoletim.add(lblBoletim);
		
		JPanel panelAdicionaDisciplina = new JPanel();
		panelAdicionaDisciplina.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelAdicionaDisciplina, "painelAdicionarDisciplina");
		panelAdicionaDisciplina.setLayout(null);
		
		JLabel lblAdicionar = new JLabel("Adicionar Disciplina:");
		lblAdicionar.setForeground(Color.BLACK);
		lblAdicionar.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdicionar.setBounds(38, 140, 269, 37);
		panelAdicionaDisciplina.add(lblAdicionar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(223, 223, 223));
		panel.setBounds(38, 175, 455, 310);
		panelAdicionaDisciplina.add(panel);
		panel.setLayout(null);
		
		JLabel codLabel = new JLabel("Código da Disciplina:");
		codLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		codLabel.setBounds(31, 109, 204, 25);
		panel.add(codLabel);
		
		codInput = new JTextField();
		codInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codInput.setBounds(31, 138, 395, 37);
		panel.add(codInput);
		codInput.setColumns(10);
		
		JButton botaoCursar = new JButton("Matricular");
		botaoCursar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCursar.setBounds(170, 190, 117, 35);
		panel.add(botaoCursar);
		botaoCursar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = codInput.getText();
			  

			    if(codigo.isEmpty()) {
			        JOptionPane.showMessageDialog(frame, "Campo em branco, por favor preencha corretamente", "Campo em branco", JOptionPane.WARNING_MESSAGE);
			    } else{
			    	if (Disciplina.procurarAluno(alunoLogado, codigo)) {
			    		JOptionPane.showMessageDialog(frame, "Você já está cursando essa disciplina, não é possível matricular-se novamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				    } else if (alunoLogado.matricularDisciplina(codigo)) {
				        JOptionPane.showMessageDialog(frame, "Disciplina adicionada com sucesso, verifique no seu boletim!", "Status", JOptionPane.INFORMATION_MESSAGE);
				    } else {
				    	JOptionPane.showMessageDialog(frame, "Disciplina não existe, verifique e tente novamente!", "Status", JOptionPane.INFORMATION_MESSAGE);
					    
				    }
			    }
			        
			}
		});	
		
		JPanel panelTrancarDisciplina = new JPanel();
		panelTrancarDisciplina.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelTrancarDisciplina, "painelTrancarDisciplina");
		panelTrancarDisciplina.setLayout(null);
		
		JLabel lblBoletim_1_1 = new JLabel("Trancar Disciplina:");
		lblBoletim_1_1.setForeground(Color.BLACK);
		lblBoletim_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBoletim_1_1.setBounds(38, 140, 269, 37);
		panelTrancarDisciplina.add(lblBoletim_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(223, 223, 223));
		panel_1.setLayout(null);
		panel_1.setBounds(38, 175, 455, 310);
		panelTrancarDisciplina.add(panel_1);
		
		JLabel codLabel_1 = new JLabel("Código da Disciplina:");
		codLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		codLabel_1.setBounds(31, 109, 204, 25);
		panel_1.add(codLabel_1);
		
		codTrancar = new JTextField();
		codTrancar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codTrancar.setColumns(10);
		codTrancar.setBounds(31, 138, 395, 37);
		panel_1.add(codTrancar);
		
		JButton btnTrancar = new JButton("Trancar");
		btnTrancar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTrancar.setBounds(170, 190, 117, 35);
		panel_1.add(btnTrancar);
		btnTrancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = codTrancar.getText();
				if(codigo.isEmpty()) {
			        JOptionPane.showMessageDialog(frame, "Campo em branco, por favor preencha corretamente", "Campo em branco", JOptionPane.WARNING_MESSAGE);
			    } else{
			    	if (!Disciplina.procurarAluno(alunoLogado, codigo)) {
			    		JOptionPane.showMessageDialog(frame, "Você não está cursando essa disciplina", "Status", JOptionPane.INFORMATION_MESSAGE);
				    } else if (alunoLogado.removerDisciplina(codigo)) {
				        JOptionPane.showMessageDialog(frame, "Disciplina removida com sucesso, verifique no seu boletim!", "Status", JOptionPane.INFORMATION_MESSAGE);
				    } else {
				    	JOptionPane.showMessageDialog(frame, "Disciplina não existe, verifique e tente novamente!", "Status", JOptionPane.INFORMATION_MESSAGE);
					    
				    }
			    }
			}
		});	
		
		JPanel panelRedefinirSenha = new JPanel();
		panelRedefinirSenha.setBackground(new Color(198, 198, 198));
		cardPanel.add(panelRedefinirSenha, "painelRedefinirSenha");
		panelRedefinirSenha.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(223, 223, 223));
		panel_2.setBounds(38, 175, 455, 320);
		panelRedefinirSenha.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCPF = new JLabel("Matrícula:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCPF.setBounds(31, 31, 135, 25);
		panel_2.add(lblCPF);
		
		matriculaRedefinir = new JTextField();
		matriculaRedefinir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculaRedefinir.setBounds(31, 61, 395, 32);
		panel_2.add(matriculaRedefinir);
		matriculaRedefinir.setColumns(11);
		
		JLabel labelNovaSenha = new JLabel("Nova Senha:");
		labelNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelNovaSenha.setBounds(31, 106, 135, 25);
		panel_2.add(labelNovaSenha);
		
		JLabel lblNovaSenha2 = new JLabel("Senha Novamente:");
		lblNovaSenha2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaSenha2.setBounds(31, 189, 194, 25);
		panel_2.add(lblNovaSenha2);
		
		JButton btnRedefinirSenha = new JButton("Redefinir");
		btnRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculaRedefinir.getText().isEmpty()|| String.valueOf(novaSenha.getPassword()).isEmpty()|| String.valueOf(novaSenha2.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int redefinirEscolha = JOptionPane.showConfirmDialog(frame,
							"Tem certeza que deseja redefinir sua senha?",
							"Confirmação",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					
					if(redefinirEscolha == JOptionPane.YES_OPTION) {
						String matriculaLida = matriculaRedefinir.getText();
						String senhaLida1 = String.valueOf(novaSenha.getPassword());
						String senhaLida2 = String.valueOf(novaSenha2.getPassword());
						if(!Aluno.verificarMatriculaExiste(matriculaLida)) {
							JOptionPane.showMessageDialog(frame, "Essa matricula não existe", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(!senhaLida1.equals(senhaLida2)) {
							JOptionPane.showMessageDialog(frame, "As senhas fornecidas não coincidem", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(!alunoLogado.getMatricula().equals(matriculaLida)) {
							JOptionPane.showMessageDialog(frame, "Essa matricula não é sua matricula", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else {
							Aluno.redefinirSenha(matriculaLida, senhaLida1);
							JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso!\nFaça login novamente com a nova senha", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							
							TelaLoginAluno telaLogin = new TelaLoginAluno();
					        telaLogin.frmLogin.setVisible(true);;
					        
					        TelaLoginAluno.setAlunoLogado(null);
					        frame.dispose();
						}
					}
				}
			}
		});
		btnRedefinirSenha.setBounds(170, 270, 117, 35);
		panel_2.add(btnRedefinirSenha);
		
		novaSenha = new JPasswordField();
		novaSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		novaSenha.setBounds(31, 136, 395, 32);
		panel_2.add(novaSenha);
		
		novaSenha2 = new JPasswordField();
		novaSenha2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		novaSenha2.setBounds(31, 217, 395, 32);
		panel_2.add(novaSenha2);
		
		JLabel lblRedefinirSenha = new JLabel("Redefinir Senha:");
		lblRedefinirSenha.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRedefinirSenha.setBounds(38, 140, 246, 25);
		panelRedefinirSenha.add(lblRedefinirSenha);
		
		//Actions dos botões
		
		botaoMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelDadosMatricula");
			}
		});
		
		botaoBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("COD : DISCIPLINA");
		        model.addColumn("NOTAS");
				
		        Map<Disciplina, ArrayList<Float>> notasPorDisciplina = alunoLogado.getBoletim().getNotasPorDisciplina(alunoLogado);
		        
		        if(notasPorDisciplina.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Você não tem nenhuma disciplina matriculada", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		
		        	for (Disciplina disc : notasPorDisciplina.keySet()) {
			            String coluna1 = disc.getCodigo()+" : "+disc.getNome();
			            ArrayList<Float> notas = notasPorDisciplina.get(disc);
			            String notasString = "";
			            for(float nota : notas) {
			            	notasString = notasString + " " + String.valueOf(nota);
			            }
						model.addRow(new Object[]{coluna1, notasString});
			        }
					
		        }
		        table.setModel(model);
				table.repaint();
		        
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelBoletim");
			}
		});
		
		botaoAdicionarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelAdicionarDisciplina");
			}
		});
		
		botaoTrancarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelTrancarDisciplina");
			}
		});
		
		botaoRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelRedefinirSenha");
			}
		});
		labelSistema.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelInicial");
		    }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
