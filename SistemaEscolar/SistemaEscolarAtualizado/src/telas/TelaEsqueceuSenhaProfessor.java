package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import classes.*;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class TelaEsqueceuSenhaProfessor {

	protected JFrame frame;
	private JTextField cpf;
	private JTextField matricula;
	private JPasswordField senha;
	private JPasswordField senhaRpt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueceuSenhaProfessor window = new TelaEsqueceuSenhaProfessor();
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
	public TelaEsqueceuSenhaProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(217, 217, 217));
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 316, 415);
		frame.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Redefinir Senha: ");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		titulo.setBounds(45, 22, 216, 25);
		frame.getContentPane().add(titulo);
		
		JLabel cpfLabel = new JLabel("CPF: ");
		cpfLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cpfLabel.setBounds(31, 79, 46, 14);
		frame.getContentPane().add(cpfLabel);
		
		cpf = new JTextField();
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpf.setBounds(31, 100, 240, 32);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatricula.setBounds(31, 143, 136, 14);
		frame.getContentPane().add(lblMatricula);
		
		matricula = new JTextField();
		matricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matricula.setColumns(10);
		matricula.setBounds(31, 160, 240, 32);
		frame.getContentPane().add(matricula);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaSenha.setBounds(31, 204, 171, 14);
		frame.getContentPane().add(lblNovaSenha);
		
		senha = new JPasswordField();
		senha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senha.setBounds(31, 222, 240, 32);
		frame.getContentPane().add(senha);
		
		senhaRpt = new JPasswordField();
		senhaRpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaRpt.setBounds(31, 284, 240, 32);
		frame.getContentPane().add(senhaRpt);
		
		JLabel lblNovaSenhaNovamente = new JLabel("Senha Novamente:");
		lblNovaSenhaNovamente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaSenhaNovamente.setBounds(31, 264, 199, 14);
		frame.getContentPane().add(lblNovaSenhaNovamente);
		
		JButton botaoRedefinir = new JButton("Redefinir");
		botaoRedefinir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRedefinir.setBounds(95, 333, 117, 35);
		frame.getContentPane().add(botaoRedefinir);
		botaoRedefinir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cpf.getText().isEmpty()|| String.valueOf(senha.getPassword()).isEmpty()|| String.valueOf(senhaRpt.getPassword()).isEmpty() || matricula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int redefinirEscolha = JOptionPane.showConfirmDialog(frame,
							"Tem certeza que deseja redefinir sua senha?",
							"Confirmação",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					
					if(redefinirEscolha == JOptionPane.YES_OPTION) {
						String cpfLido = cpf.getText();
						String matriculaLida = matricula.getText();
						String senhaLida1 = String.valueOf(senha.getPassword());
						String senhaLida2 = String.valueOf(senhaRpt.getPassword());
						if(!Professor.verificarCpfExiste(cpfLido)) {
							JOptionPane.showMessageDialog(frame, "Esse CPF não está cadastrado no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(!Professor.verificarMatriculaExiste(matriculaLida)) {
							JOptionPane.showMessageDialog(frame, "Essa matricula não está cadastrada no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(!senhaLida1.equals(senhaLida2)) {
							JOptionPane.showMessageDialog(frame, "As senhas fornecidas não coincidem", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(Professor.verificarMatriculaExiste(matriculaLida)) {
							Professor professor = Professor.getProfessorObjeto(matriculaLida);
							if(professor.getCpf().equals(cpfLido)) {
								Professor.redefinirSenha(matriculaLida, senhaLida1);
								JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso!\nFaça login novamente com a nova senha", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
								
						        frame.dispose();
							} else {
								JOptionPane.showMessageDialog(frame, "CPF e Matricula cadastrados não conincidem!", "Status", JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Ocorreu algum problema, verifique suas informações e tente novamente", "Status", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
	}
}
