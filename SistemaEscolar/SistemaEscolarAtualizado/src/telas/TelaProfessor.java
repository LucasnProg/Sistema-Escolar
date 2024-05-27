package telas;

import java.awt.EventQueue;
import classes.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;

public class TelaProfessor {

	protected JFrame frame;
	private Professor professorLogado = TelaLoginProfessor.getProfessorLogado();
	private JTextField matriculaRedefinirProfessor;
	private JPasswordField novaSenha;
	private JPasswordField novaSenhaRpt;
	private JTextField codDisc;
	private JTextField matAluno;
	private JTextField notaAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessor window = new TelaProfessor();
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
	public TelaProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Professor");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(198, 198, 198));
		painelPrincipal.setBounds(0, 0, 786, 563);
		frame.getContentPane().add(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelLateral = new JPanel();
		painelLateral.setBackground(new Color(128, 128, 128));
		painelLateral.setBounds(0, 0, 250, 563);
		painelPrincipal.add(painelLateral);
		painelLateral.setLayout(null);
		
		JButton botaoInserirNotas = new JButton("Inserir Notas");
		botaoInserirNotas.setToolTipText("");
		botaoInserirNotas.setForeground(Color.BLACK);
		botaoInserirNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoInserirNotas.setBackground(new Color(84, 84, 84));
		botaoInserirNotas.setBounds(34, 166, 179, 35);
		painelLateral.add(botaoInserirNotas);
		
		JButton botaoVisualizarDisciplinas = new JButton("Visualizar disciplinas");
		botaoVisualizarDisciplinas.setForeground(Color.BLACK);
		botaoVisualizarDisciplinas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoVisualizarDisciplinas.setBackground(new Color(84, 84, 84));
		botaoVisualizarDisciplinas.setBounds(34, 218, 179, 35);
		painelLateral.add(botaoVisualizarDisciplinas);
		
		JButton botaoVisualizarAluno = new JButton("Visualizar alunos");
		botaoVisualizarAluno.setForeground(Color.BLACK);
		botaoVisualizarAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoVisualizarAluno.setBackground(new Color(84, 84, 84));
		botaoVisualizarAluno.setBounds(34, 270, 179, 35);
		painelLateral.add(botaoVisualizarAluno);
		
		JButton botaoRedefinirSenha = new JButton("Redefinir Senha");
		botaoRedefinirSenha.setForeground(Color.BLACK);
		botaoRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRedefinirSenha.setBackground(new Color(84, 84, 84));
		botaoRedefinirSenha.setBounds(34, 322, 179, 35);
		painelLateral.add(botaoRedefinirSenha);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(Color.BLACK);
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoSair.setBackground(new Color(233, 87, 87));
		botaoSair.setBounds(68, 375, 110, 35);
		painelLateral.add(botaoSair);
		
		JLabel labelSistemaEscolar = new JLabel("<html>Sistema<br>     Escolar</html>");
		labelSistemaEscolar.setHorizontalAlignment(SwingConstants.CENTER);
		labelSistemaEscolar.setFont(new Font("Tahoma", Font.BOLD, 35));
		labelSistemaEscolar.setBounds(34, 23, 179, 100);
		painelLateral.add(labelSistemaEscolar);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBackground(new Color(198, 198, 198));
		cardPanel.setBounds(251, 0, 535, 563);
		painelPrincipal.add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel painelInicial = new JPanel();
		painelInicial.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelInicial, "PainelInicial");
		painelInicial.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Olá, "+professorLogado.getNome());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(38, 45, 416, 51);
		painelInicial.add(lblNewLabel);
		
		JPanel painelVisualizarDisciplinas = new JPanel();
		painelVisualizarDisciplinas.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelVisualizarDisciplinas, "PainelDisciplinas");
		painelVisualizarDisciplinas.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 175, 455, 364);
		painelVisualizarDisciplinas.add(scrollPane);
		
		JTable tableDiscplinas = new JTable();
		tableDiscplinas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDiscplinas.setBounds(46, 120, 440, 346);
		scrollPane.setViewportView(tableDiscplinas);
		
		JLabel lblNewLabel_1 = new JLabel("Disciplina:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(38, 140, 133, 31);
		painelVisualizarDisciplinas.add(lblNewLabel_1);
		
		JPanel painelVisualizarAlunos = new JPanel();
		painelVisualizarAlunos.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelVisualizarAlunos, "PainelAlunos");
		painelVisualizarAlunos.setLayout(null);
		
		JScrollPane scrollPaneAlunos = new JScrollPane();
		scrollPaneAlunos.setBounds(38, 175, 455, 364);
		painelVisualizarAlunos.add(scrollPaneAlunos);
		
		JTable tableAlunos = new JTable();
		tableAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableAlunos.setBounds(46, 120, 440, 346);
		scrollPaneAlunos.setViewportView(tableAlunos);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAlunos.setBounds(38, 140, 102, 25);
		painelVisualizarAlunos.add(lblAlunos);
		
		JPanel painelRedefinirSenha = new JPanel();
		painelRedefinirSenha.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelRedefinirSenha, "PainelRedefinirSenha");
		painelRedefinirSenha.setLayout(null);
		
		JPanel painelRedefinir = new JPanel();
		painelRedefinir.setLayout(null);
		painelRedefinir.setBackground(new Color(223, 223, 223));
		painelRedefinir.setBounds(38, 175, 455, 320);
		painelRedefinirSenha.add(painelRedefinir);
		
		JLabel lblCPF = new JLabel("Matricula:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCPF.setBounds(31, 31, 105, 25);
		painelRedefinir.add(lblCPF);
		
		matriculaRedefinirProfessor = new JTextField();
		matriculaRedefinirProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculaRedefinirProfessor.setColumns(11);
		matriculaRedefinirProfessor.setBounds(31, 61, 395, 32);
		painelRedefinir.add(matriculaRedefinirProfessor);
		
		JLabel labelNovaSenha = new JLabel("Nova Senha:");
		labelNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelNovaSenha.setBounds(31, 106, 129, 25);
		painelRedefinir.add(labelNovaSenha);
		
		JLabel lblNovaSenha2 = new JLabel("Senha Novamente:");
		lblNovaSenha2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaSenha2.setBounds(31, 189, 194, 25);
		painelRedefinir.add(lblNovaSenha2);
		
		JButton btnRedefinirSenha = new JButton("Redefinir");
		btnRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculaRedefinirProfessor.getText().isEmpty()|| String.valueOf(novaSenha.getPassword()).isEmpty()|| String.valueOf(novaSenhaRpt.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int redefinirEscolha = JOptionPane.showConfirmDialog(frame,
							"Tem certeza que deseja redefinir sua senha?",
							"Confirmação",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					
					if(redefinirEscolha == JOptionPane.YES_OPTION) {
						String matricula = matriculaRedefinirProfessor.getText();
						String senhaLida1 = String.valueOf(novaSenha.getPassword());
						String senhaLida2 = String.valueOf(novaSenhaRpt.getPassword());
						if(!Professor.verificarMatriculaExiste(matricula)) {
							JOptionPane.showMessageDialog(frame, "Essa não existe para essa conta", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(!senhaLida1.equals(senhaLida2)) {
							JOptionPane.showMessageDialog(frame, "As senhas fornecidas não coincidem", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else {
							Professor.redefinirSenha(matricula, senhaLida1);
							JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso!\nFaça login novamente com a nova senha", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							
							TelaLoginProfessor telaLogin = new TelaLoginProfessor();
					        telaLogin.frmLogin.setVisible(true);;
					        
					        TelaLoginProfessor.setProfessorLogado(professorLogado);
					        frame.dispose();
						}
					}
				}
			}
		});
		btnRedefinirSenha.setBounds(170, 270, 117, 35);
		painelRedefinir.add(btnRedefinirSenha);
		
		novaSenha = new JPasswordField();
		novaSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		novaSenha.setBounds(31, 136, 395, 32);
		painelRedefinir.add(novaSenha);
		
		novaSenhaRpt = new JPasswordField();
		novaSenhaRpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		novaSenhaRpt.setBounds(31, 217, 395, 32);
		painelRedefinir.add(novaSenhaRpt);
		
		JLabel lblRedefinirSenha = new JLabel("Redefinir Senha:");
		lblRedefinirSenha.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRedefinirSenha.setBounds(38, 140, 245, 25);
		painelRedefinirSenha.add(lblRedefinirSenha);
		
		JPanel painelInserirNotas = new JPanel();
		painelInserirNotas.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelInserirNotas, "PainelInserir");
		painelInserirNotas.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Inserir Notas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(38, 140, 209, 21);
		painelInserirNotas.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(223, 223, 223));
		panel.setBounds(38, 175, 455, 370);
		painelInserirNotas.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Código da Disciplina:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(31, 31, 171, 25);
		panel.add(lblNewLabel_3);
		
		codDisc = new JTextField();
		codDisc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codDisc.setBounds(31, 61, 395, 32);
		panel.add(codDisc);
		codDisc.setColumns(10);
		
		JLabel lblCod = new JLabel("Matricula do Aluno:");
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCod.setBounds(31, 106, 171, 25);
		panel.add(lblCod);
		
		matAluno = new JTextField();
		matAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matAluno.setColumns(10);
		matAluno.setBounds(31, 136, 395, 32);
		panel.add(matAluno);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nota:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(31, 180, 130, 25);
		panel.add(lblNewLabel_3_2);
		
		notaAluno = new JTextField();
		notaAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		notaAluno.setColumns(10);
		notaAluno.setBounds(31, 210, 395, 32);
		panel.add(notaAluno);
		
		Button button = new Button("Inserir");
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(309, 303, 117, 35);
		panel.add(button);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Unidade:");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(31, 256, 130, 25);
		panel.add(lblNewLabel_3_2_1);
		
		JComboBox<String> selUnidade = new JComboBox<String>();
		selUnidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		selUnidade.setBounds(31, 287, 98, 30);
		panel.add(selUnidade);
		selUnidade.addItem("U-1 | P-1");
		selUnidade.addItem("U-1 | P-2");
		selUnidade.addItem("U-2 | P-1");
		selUnidade.addItem("U-2 | P-2");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(codDisc.getText().isEmpty() || matAluno.getText().isEmpty() || notaAluno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha os campos corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if(!isNumeric(notaAluno.getText())) {
					JOptionPane.showMessageDialog(frame, "Nota inválida, corrija e tente novamente", "Status", JOptionPane.INFORMATION_MESSAGE);					
				} else if(professorLogado.getDisciplinas().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Você não tem nenhuma disciplina", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if(!professorLogado.getDisciplinas().isEmpty()){
					Disciplina disciplinaArg = Disciplina.getDisciplinaObjeto(codDisc.getText());
					Aluno alunoArg = Aluno.getAlunoObjeto(matAluno.getText());
					Float notaArg = Float.valueOf(notaAluno.getText());
					String unidadeNota = String.valueOf(selUnidade.getSelectedItem());
					professorLogado.inserirNota(disciplinaArg, alunoArg, notaArg,unidadeNota);
					JOptionPane.showMessageDialog(frame, "Nota inserida com sucesso", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "Aluno ou discplina incorreto(s) ou não existem.", "Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botaoInserirNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelInserir");
			}
		});
		
		botaoRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelRedefinirSenha");
			}
		});
		
		botaoVisualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelAluno = new DefaultTableModel();
				modelAluno.addColumn("MATRICULA");
				modelAluno.addColumn("NOME");
				modelAluno.addColumn("DISCIPLINA");
				
		        if(professorLogado.getDisciplinas().isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Você não tem nenhuma disciplina", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	for (Disciplina disc : professorLogado.getDisciplinas()) {
		        		for(String matAluno : disc.getAlunos()) {
		        			Aluno alunoAtual = Aluno.getAlunoObjeto(matAluno);
		        			modelAluno.addRow(new Object[]{alunoAtual.getMatricula(),alunoAtual.getNome(), disc.getNome()});
		        		}
		        
			        }
					
		        }
		        tableAlunos.setModel(modelAluno);
				tableAlunos.repaint();
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelAlunos");
			}
		});
		botaoVisualizarDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelDisciplinas = new DefaultTableModel();
				modelDisciplinas.addColumn("CÓDIGD");
				modelDisciplinas.addColumn("DISCIPLINA");
		        
		        ArrayList<Disciplina> discplinasProfessor = professorLogado.getDisciplinas();
		        if(discplinasProfessor.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Você não tem nenhuma disciplina", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	for (Disciplina disc : discplinasProfessor) {
		        		modelDisciplinas.addRow(new Object[]{disc.getCodigo(),disc.getNome()});
			        }
					
		        }
		        tableDiscplinas.setModel(modelDisciplinas);
				tableDiscplinas.repaint();
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelDisciplinas");
			}
		});
		
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
					TelaLoginProfessor telaLogin = new TelaLoginProfessor();
			        telaLogin.frmLogin.setVisible(true);;
			        
			        TelaLoginProfessor.setProfessorLogado(null);
			        frame.dispose();
				}
			}
		});
		
		labelSistemaEscolar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "PainelInicial");
		    }
		});
	}
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
