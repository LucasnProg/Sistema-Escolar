package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class MainInterface {

	protected JFrame frmEscolhaDeLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frmEscolhaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEscolhaDeLogin = new JFrame();
		frmEscolhaDeLogin.setType(Type.POPUP);
		frmEscolhaDeLogin.setResizable(false);
		frmEscolhaDeLogin.setTitle("Escolha de Login");
		frmEscolhaDeLogin.setBounds(100, 100, 510, 215);
		frmEscolhaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Você deseja logar como?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		frmEscolhaDeLogin.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frmEscolhaDeLogin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton botaoCoordenador = new JButton("COORDENADOR");
		botaoCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCoordenador.setBounds(10, 57, 141, 37);
		panel.add(botaoCoordenador);
		botaoCoordenador.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	TelaLoginCoordenador telaLogin = new TelaLoginCoordenador();
		        telaLogin.frmLogin.setVisible(true);;

		        frmEscolhaDeLogin.dispose();
		    }
		});
		
		//Botão que abre a tela de login do aluno 
		JButton botaoAluno = new JButton("ALUNO");
		botaoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoAluno.setBounds(177, 57, 141, 37);
		panel.add(botaoAluno);
		botaoAluno.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	TelaLoginAluno telaLogin = new TelaLoginAluno();
		        telaLogin.frmLogin.setVisible(true);;

		        frmEscolhaDeLogin.dispose();
		    }
		});
		
		JButton botaoProfessor = new JButton("PROFESSOR");
		botaoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoProfessor.setBounds(344, 57, 141, 37);
		panel.add(botaoProfessor);
		botaoProfessor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	TelaLoginProfessor telaLogin = new TelaLoginProfessor();
		        telaLogin.frmLogin.setVisible(true);;

		        frmEscolhaDeLogin.dispose();
		    }
		});
	}
}
