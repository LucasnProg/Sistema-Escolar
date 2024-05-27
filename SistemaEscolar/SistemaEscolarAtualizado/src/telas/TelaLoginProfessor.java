package telas;

import classes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class TelaLoginProfessor {

	protected JFrame frmLogin;
	public static Professor professorLogado;
	private JTextField entradaMatriculaProfessor;
	private JPasswordField passwordField_1;

	public static Professor getProfessorLogado() {
		return professorLogado;
	}
	
	public static void setProfessorLogado(Professor novoProfessor) {
		professorLogado = novoProfessor;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginProfessor window = new TelaLoginProfessor();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLoginProfessor() {
		initialize();
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(87, 145, 155));
		frmLogin.setBackground(new Color(217, 217, 217));
		frmLogin.setTitle("Login Professor");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 800, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(217, 217, 217));
		layeredPane.setToolTipText("");
		layeredPane.setForeground(Color.LIGHT_GRAY);
		frmLogin.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		
		//Painel Login do aluno
		JPanel painelLoginALuno = new JPanel();
		painelLoginALuno.setBackground(new Color(217, 217, 217));
		painelLoginALuno.setBounds(400, -21, 386, 584);
		layeredPane.add(painelLoginALuno);
		painelLoginALuno.setLayout(null);
		
		JLabel labelMatriculaAluno = new JLabel("Matricula:");
		labelMatriculaAluno.setBackground(new Color(240, 240, 240));
		labelMatriculaAluno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelMatriculaAluno.setBounds(55, 217, 130, 40);
		painelLoginALuno.add(labelMatriculaAluno);
		
		entradaMatriculaProfessor = new JTextField();
		entradaMatriculaProfessor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		entradaMatriculaProfessor.setBounds(55, 251, 283, 45);
		painelLoginALuno.add(entradaMatriculaProfessor);
		entradaMatriculaProfessor.setColumns(10);
		
		JLabel labelSenhaAluno = new JLabel("Senha:");
		labelSenhaAluno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelSenhaAluno.setBounds(55, 306, 130, 40);
		painelLoginALuno.add(labelSenhaAluno);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_1.setBounds(55, 339, 283, 45);
		painelLoginALuno.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Acessar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(entradaMatriculaProfessor.getText().isEmpty() || String.valueOf(passwordField_1.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frmLogin, "Campos em branco, por favor preencha corretamente", "Campos em branco", JOptionPane.WARNING_MESSAGE);
				} else {
					if(Professor.login(new String(entradaMatriculaProfessor.getText()),new String(passwordField_1.getPassword()))) {
						setProfessorLogado(Professor.getProfessorObjeto(entradaMatriculaProfessor.getText()));
						JOptionPane.showMessageDialog(frmLogin, "Seja bem vindo!", "Logado com Sucesso", JOptionPane.INFORMATION_MESSAGE);
						TelaProfessor telaUsuario = new TelaProfessor();
				        
						telaUsuario.frame.setVisible(true);
	
				        frmLogin.dispose();
					} else {
						JOptionPane.showMessageDialog(frmLogin, "Dados incorretos!\n Por favor, tente novamente!.", "Dados incorretos", JOptionPane.ERROR_MESSAGE);
					}	
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(142, 414, 115, 40);
		painelLoginALuno.add(btnNewButton);
		
		JLabel lblAlunos = new JLabel("Login");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 70));
		lblAlunos.setBackground(UIManager.getColor("Button.background"));
		lblAlunos.setBounds(55, 102, 283, 101);
		painelLoginALuno.add(lblAlunos);
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(217, 217, 217));
		lblNewLabel_1.setIcon(new ImageIcon("src\\imagens\\livrosTelaLogin.jpg"));
		lblNewLabel_1.setBounds(0, 0, 404, 563);
		layeredPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmLogin.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Conta");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuEsqueceuSenha = new JMenuItem("Esqueceu a senha");
		mnNewMenu.add(menuEsqueceuSenha);
		menuEsqueceuSenha.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	TelaEsqueceuSenhaProfessor popup = new TelaEsqueceuSenhaProfessor();
		    	popup.frame.setVisible(true);;

		    }
		});
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem menuVoltar = new JMenuItem("Voltar");
		mnNewMenu.add(menuVoltar);
		menuVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	MainInterface main = new MainInterface();
		        main.frmEscolhaDeLogin.setVisible(true);;

		        frmLogin.dispose();
		    }
		});
		
		
	
	}
}
