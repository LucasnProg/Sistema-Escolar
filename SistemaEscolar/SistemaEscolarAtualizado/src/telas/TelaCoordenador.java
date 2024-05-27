package telas;

import java.awt.EventQueue;
import classes.*;
import dao.BancoDeDadosDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class TelaCoordenador {

	protected JFrame frame;
	private JTextField matriculaProfessorRemover;
	private JTextField matriculaRemoverAluno;
	private JTextField codigoRemoverDisciplina;
	private Coordenador coordenadorLogador = TelaLoginCoordenador.getCoordenadorLogado();
	private JTextField cpfNovo;
	private JTextField nomeNovo;
	private JPasswordField senhaNova;
	private JPasswordField senhaRpt;
	private JTextField cpfNovoAluno;
	private JTextField nomeNovoAluno;
	private JPasswordField senhaNovoAluno;
	private JPasswordField senhaNovoAlunoRpt;
	private JTextField codigoNovaDisciplina;
	private JTextField nomeNovaDisciplina;
	private JTextField matriculaProfessorNovaDisciplina;
	private JTable tableProfessores;
	private JTable tableAlunos;
	private JTable tableDisciplinas;
	private JTextField cpfRedefinir;
	private JPasswordField senhaRedefinir;
	private JPasswordField senhaRedefinirRpt;
	
	public static boolean isAlphabetic(String str) {
        return str.matches("^[a-zA-Z\\s]+$");
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCoordenador window = new TelaCoordenador();
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
	public TelaCoordenador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Coordenador");
		frame.setBounds(100, 100, 900, 764);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBounds(0, 0, 886, 727);
		frame.getContentPane().add(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelLateral = new JPanel();
		painelLateral.setLayout(null);
		painelLateral.setBackground(new Color(128, 128, 128));
		painelLateral.setBounds(0, 0, 250, 727);
		painelPrincipal.add(painelLateral);
		
		JButton botaoMatricularAluno = new JButton("Matricular Aluno");
		botaoMatricularAluno.setToolTipText("");
		botaoMatricularAluno.setForeground(Color.BLACK);
		botaoMatricularAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoMatricularAluno.setBackground(new Color(84, 84, 84));
		botaoMatricularAluno.setBounds(34, 249, 179, 35);
		painelLateral.add(botaoMatricularAluno);
		
		JButton botaoRemoverAluno = new JButton("Remover Aluno");
		botaoRemoverAluno.setForeground(Color.BLACK);
		botaoRemoverAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRemoverAluno.setBackground(new Color(84, 84, 84));
		botaoRemoverAluno.setBounds(34, 301, 179, 35);
		painelLateral.add(botaoRemoverAluno);
		
		JButton botaoCriarNovaDisciplina = new JButton("Criar nova Disciplina");
		botaoCriarNovaDisciplina.setForeground(Color.BLACK);
		botaoCriarNovaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCriarNovaDisciplina.setBackground(new Color(84, 84, 84));
		botaoCriarNovaDisciplina.setBounds(34, 353, 179, 35);
		painelLateral.add(botaoCriarNovaDisciplina);
		
		JButton botaoRedefinirSenha = new JButton("Redefinir Senha");
	
		
		botaoRedefinirSenha.setForeground(Color.BLACK);
		botaoRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRedefinirSenha.setBackground(new Color(84, 84, 84));
		botaoRedefinirSenha.setBounds(34, 613, 179, 35);
		painelLateral.add(botaoRedefinirSenha);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(Color.BLACK);
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoSair.setBackground(new Color(233, 87, 87));
		botaoSair.setBounds(68, 658, 110, 35);
		painelLateral.add(botaoSair);
		
		JButton botaoRemoverDisciplina = new JButton("Remover Disciplina");
		botaoRemoverDisciplina.setToolTipText("");
		botaoRemoverDisciplina.setForeground(Color.BLACK);
		botaoRemoverDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRemoverDisciplina.setBackground(new Color(84, 84, 84));
		botaoRemoverDisciplina.setBounds(34, 406, 179, 35);
		painelLateral.add(botaoRemoverDisciplina);
		
		JButton btnExibirProfessores = new JButton("Exibir Professores");
		btnExibirProfessores.setForeground(Color.BLACK);
		btnExibirProfessores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExibirProfessores.setBackground(new Color(84, 84, 84));
		btnExibirProfessores.setBounds(34, 458, 179, 35);
		painelLateral.add(btnExibirProfessores);
		
		JButton botaoExibirAlunos = new JButton("Exibir Alunos");
		botaoExibirAlunos.setForeground(Color.BLACK);
		botaoExibirAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoExibirAlunos.setBackground(new Color(84, 84, 84));
		botaoExibirAlunos.setBounds(34, 510, 179, 35);
		painelLateral.add(botaoExibirAlunos);
		
		JButton botaoMatricularProfessor = new JButton("Matricular Professor");
		botaoMatricularProfessor.setToolTipText("");
		botaoMatricularProfessor.setForeground(Color.BLACK);
		botaoMatricularProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoMatricularProfessor.setBackground(new Color(84, 84, 84));
		botaoMatricularProfessor.setBounds(34, 147, 179, 35);
		painelLateral.add(botaoMatricularProfessor);
		
		JButton botaoRemoverProfessor = new JButton("Remover Professor");
		botaoRemoverProfessor.setForeground(Color.BLACK);
		botaoRemoverProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRemoverProfessor.setBackground(new Color(84, 84, 84));
		botaoRemoverProfessor.setBounds(34, 199, 179, 35);
		painelLateral.add(botaoRemoverProfessor);
		
		JLabel labelSistemaEscolar = new JLabel("<html>Sistema<br>     Escolar</html>");
		labelSistemaEscolar.setHorizontalAlignment(SwingConstants.CENTER);
		labelSistemaEscolar.setFont(new Font("Tahoma", Font.BOLD, 35));
		labelSistemaEscolar.setBounds(34, 23, 179, 100);
		painelLateral.add(labelSistemaEscolar);
		
		
		JButton btnExibirDisciplinas = new JButton("Exibir Disciplinas");
		btnExibirDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExibirDisciplinas.setForeground(Color.BLACK);
		btnExibirDisciplinas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExibirDisciplinas.setBackground(new Color(84, 84, 84));
		btnExibirDisciplinas.setBounds(34, 561, 179, 35);
		painelLateral.add(btnExibirDisciplinas);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBackground(new Color(198, 198, 198));
		cardPanel.setBounds(250, 0, 636, 727);
		painelPrincipal.add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel painelnicial = new JPanel();
		painelnicial.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelnicial, "painelnicial");
		painelnicial.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Olá, "+coordenadorLogador.getNome()+"!");
		lblNewLabel.setBounds(38, 45, 361, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		painelnicial.add(lblNewLabel);
		
		JPanel painelMatriculaProfessor = new JPanel();
		painelMatriculaProfessor.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelMatriculaProfessor, "painelMatriculaProfessor");
		painelMatriculaProfessor.setLayout(null);
		
		JLabel MatrcularProfessorLabel = new JLabel("Matrícular Professor:");
		MatrcularProfessorLabel.setBounds(38, 140, 283, 25);
		MatrcularProfessorLabel.setForeground(Color.BLACK);
		MatrcularProfessorLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		painelMatriculaProfessor.add(MatrcularProfessorLabel);
		
		JPanel painelMatricularProfessor = new JPanel();
		painelMatricularProfessor.setBackground(new Color(223, 223, 223));
		painelMatricularProfessor.setLayout(null);
		painelMatricularProfessor.setBounds(38, 175, 560, 350);
		painelMatriculaProfessor.add(painelMatricularProfessor);
		
		JLabel NomeDoProfessorLabel = new JLabel("Nome:");
		NomeDoProfessorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		NomeDoProfessorLabel.setBounds(307, 102, 177, 26);
		painelMatricularProfessor.add(NomeDoProfessorLabel);
		
		JLabel CPFLabel = new JLabel("CPF:");
		CPFLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		CPFLabel.setBounds(31, 102, 93, 26);
		painelMatricularProfessor.add(CPFLabel);
		
		JButton botaoMatricular = new JButton("Cadastrar");
		botaoMatricular.setBackground(new Color(240, 240, 240));
		botaoMatricular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoMatricular.setBounds(225, 290, 117, 35);
		painelMatricularProfessor.add(botaoMatricular);
		
		cpfNovo = new JTextField();
		cpfNovo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfNovo.setBounds(31, 128, 228, 32);
		painelMatricularProfessor.add(cpfNovo);
		cpfNovo.setColumns(10);
		
		nomeNovo = new JTextField();
		nomeNovo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeNovo.setColumns(10);
		nomeNovo.setBounds(307, 128, 228, 32);
		painelMatricularProfessor.add(nomeNovo);
		
		senhaNova = new JPasswordField();
		senhaNova.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaNova.setColumns(10);
		senhaNova.setBounds(31, 203, 228, 32);
		painelMatricularProfessor.add(senhaNova);
		
		JLabel senhalbl = new JLabel("Senha:");
		senhalbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		senhalbl.setBounds(31, 173, 93, 26);
		painelMatricularProfessor.add(senhalbl);
		
		JLabel lblSenhaNovamente = new JLabel("Senha Novamente:");
		lblSenhaNovamente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenhaNovamente.setBounds(307, 173, 177, 26);
		painelMatricularProfessor.add(lblSenhaNovamente);
		
		senhaRpt = new JPasswordField();
		senhaRpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaRpt.setColumns(10);
		senhaRpt.setBounds(307, 203, 228, 32);
		painelMatricularProfessor.add(senhaRpt);
		
		JPanel painelRemoverProfessor = new JPanel();
		painelRemoverProfessor.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelRemoverProfessor, "painelRemoverProfessor");
		painelRemoverProfessor.setLayout(null);
		
		JPanel paineRemover = new JPanel();
		paineRemover.setBackground(new Color(223, 223, 223));
		paineRemover.setLayout(null);
		paineRemover.setBounds(38, 175, 560, 350);
		painelRemoverProfessor.add(paineRemover);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculaProfessorRemover.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campo em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if(!Professor.verificarMatriculaExiste(matriculaProfessorRemover.getText())) {
					JOptionPane.showMessageDialog(frame, "Esse professor não está cadastrado no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Coordenador.excluirProfessor(matriculaProfessorRemover.getText());
					JOptionPane.showMessageDialog(frame, "Professor removido com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					matriculaProfessorRemover.setText("");
				}
			}
		});
		botaoRemover.setBackground(new Color(240, 240, 240));
		botaoRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoRemover.setBounds(225, 290, 117, 35);
		paineRemover.add(botaoRemover);
		
		JLabel CpfDoProfessorLabel = new JLabel("Matrícula do Professor:");
		CpfDoProfessorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		CpfDoProfessorLabel.setBounds(31, 116, 294, 25);
		paineRemover.add(CpfDoProfessorLabel);
		
		matriculaProfessorRemover = new JTextField();
		matriculaProfessorRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculaProfessorRemover.setColumns(10);
		matriculaProfessorRemover.setBounds(31, 148, 490, 32);
		paineRemover.add(matriculaProfessorRemover);
		
		JLabel RemoverProfessorLabel = new JLabel("Remover Professor:");
		RemoverProfessorLabel.setForeground(Color.BLACK);
		RemoverProfessorLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		RemoverProfessorLabel.setBounds(38, 140, 283, 25);
		painelRemoverProfessor.add(RemoverProfessorLabel);
		
		JPanel painelMatriculaAluno = new JPanel();
		painelMatriculaAluno.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelMatriculaAluno, "painelMatriculaAluno");
		painelMatriculaAluno.setLayout(null);
		
		JLabel MatrcularAlunoLabel = new JLabel("Matrícular Aluno:");
		MatrcularAlunoLabel.setForeground(Color.BLACK);
		MatrcularAlunoLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		MatrcularAlunoLabel.setBounds(38, 140, 283, 25);
		painelMatriculaAluno.add(MatrcularAlunoLabel);
		
		JPanel painelMatricularProfessor_1 = new JPanel();
		painelMatricularProfessor_1.setLayout(null);
		painelMatricularProfessor_1.setBackground(new Color(223, 223, 223));
		painelMatricularProfessor_1.setBounds(38, 175, 560, 350);
		painelMatriculaAluno.add(painelMatricularProfessor_1);
		
		JLabel NomeDoProfessorLabel_1 = new JLabel("Nome:");
		NomeDoProfessorLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		NomeDoProfessorLabel_1.setBounds(307, 102, 177, 26);
		painelMatricularProfessor_1.add(NomeDoProfessorLabel_1);
		
		JLabel CPFLabel_2 = new JLabel("CPF:");
		CPFLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		CPFLabel_2.setBounds(31, 102, 93, 26);
		painelMatricularProfessor_1.add(CPFLabel_2);
		
		JButton botaoMatAluno = new JButton("Cadastrar");
		botaoMatAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoMatAluno.setBackground(new Color(240, 240, 240));
		botaoMatAluno.setBounds(225, 290, 117, 35);
		painelMatricularProfessor_1.add(botaoMatAluno);
		
		cpfNovoAluno = new JTextField();
		cpfNovoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfNovoAluno.setColumns(10);
		cpfNovoAluno.setBounds(31, 128, 228, 32);
		painelMatricularProfessor_1.add(cpfNovoAluno);
		
		nomeNovoAluno = new JTextField();
		nomeNovoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeNovoAluno.setColumns(10);
		nomeNovoAluno.setBounds(307, 128, 228, 32);
		painelMatricularProfessor_1.add(nomeNovoAluno);
		
		senhaNovoAluno = new JPasswordField();
		senhaNovoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaNovoAluno.setColumns(10);
		senhaNovoAluno.setBounds(31, 203, 228, 32);
		painelMatricularProfessor_1.add(senhaNovoAluno);
		
		JLabel senhalbl_1 = new JLabel("Senha:");
		senhalbl_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		senhalbl_1.setBounds(31, 173, 93, 26);
		painelMatricularProfessor_1.add(senhalbl_1);
		
		JLabel lblSenhaNovamente_1 = new JLabel("Senha Novamente:");
		lblSenhaNovamente_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenhaNovamente_1.setBounds(307, 173, 177, 26);
		painelMatricularProfessor_1.add(lblSenhaNovamente_1);
		
		senhaNovoAlunoRpt = new JPasswordField();
		senhaNovoAlunoRpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaNovoAlunoRpt.setColumns(10);
		senhaNovoAlunoRpt.setBounds(307, 203, 228, 32);
		painelMatricularProfessor_1.add(senhaNovoAlunoRpt);
		
		JPanel painelRemoverAluno = new JPanel();
		painelRemoverAluno.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelRemoverAluno, "painelRemoverAluno");
		painelRemoverAluno.setLayout(null);
		
		JPanel paineRemoverAluno = new JPanel();
		paineRemoverAluno.setLayout(null);
		paineRemoverAluno.setBackground(new Color(223, 223, 223));
		paineRemoverAluno.setBounds(38, 175, 560, 350);
		painelRemoverAluno.add(paineRemoverAluno);
		
		JButton btnRemoverAluno = new JButton("Remover");
		btnRemoverAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoverAluno.setBackground(new Color(240, 240, 240));
		btnRemoverAluno.setBounds(225, 290, 117, 35);
		paineRemoverAluno.add(btnRemoverAluno);
		
		JLabel CpfDoAlunoLabel = new JLabel("Matrícula do Aluno:");
		CpfDoAlunoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		CpfDoAlunoLabel.setBounds(31, 116, 294, 25);
		paineRemoverAluno.add(CpfDoAlunoLabel);
		
		matriculaRemoverAluno = new JTextField();
		matriculaRemoverAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculaRemoverAluno.setColumns(10);
		matriculaRemoverAluno.setBounds(31, 148, 490, 32);
		paineRemoverAluno.add(matriculaRemoverAluno);
		
		JLabel RemoverAlunoLabel = new JLabel("Remover Aluno:");
		RemoverAlunoLabel.setForeground(Color.BLACK);
		RemoverAlunoLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		RemoverAlunoLabel.setBounds(38, 140, 283, 25);
		painelRemoverAluno.add(RemoverAlunoLabel);
		
		JPanel painelCriarNovaDisciplina = new JPanel();
		painelCriarNovaDisciplina.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelCriarNovaDisciplina, "painelCriarNovaDisciplina");
		painelCriarNovaDisciplina.setLayout(null);
		
		JLabel CriarNovaDisciplinaLabel = new JLabel("Criar nova disciplina:");
		CriarNovaDisciplinaLabel.setForeground(Color.BLACK);
		CriarNovaDisciplinaLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		CriarNovaDisciplinaLabel.setBounds(38, 140, 283, 25);
		painelCriarNovaDisciplina.add(CriarNovaDisciplinaLabel);
		
		JPanel painelMatricularProfessor_2 = new JPanel();
		painelMatricularProfessor_2.setLayout(null);
		painelMatricularProfessor_2.setBackground(new Color(223, 223, 223));
		painelMatricularProfessor_2.setBounds(38, 175, 560, 350);
		painelCriarNovaDisciplina.add(painelMatricularProfessor_2);
		
		JLabel NomeDaDisciplinaLabel = new JLabel("Nome da Disciplina:");
		NomeDaDisciplinaLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		NomeDaDisciplinaLabel.setBounds(307, 102, 177, 26);
		painelMatricularProfessor_2.add(NomeDaDisciplinaLabel);
		
		JLabel CodigoDaDisciplinaLabel = new JLabel("Código da Disciplina:");
		CodigoDaDisciplinaLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		CodigoDaDisciplinaLabel.setBounds(31, 102, 177, 26);
		painelMatricularProfessor_2.add(CodigoDaDisciplinaLabel);
		
		JButton botaoCriarDisciplina = new JButton("Cadastrar");
		botaoCriarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCriarDisciplina.setBackground(new Color(240, 240, 240));
		botaoCriarDisciplina.setBounds(225, 290, 117, 35);
		painelMatricularProfessor_2.add(botaoCriarDisciplina);
		
		JLabel CPFLabel_1_1_1 = new JLabel("Matrícula do Professor:");
		CPFLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		CPFLabel_1_1_1.setBounds(31, 175, 203, 26);
		painelMatricularProfessor_2.add(CPFLabel_1_1_1);
		
		codigoNovaDisciplina = new JTextField();
		codigoNovaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codigoNovaDisciplina.setBounds(31, 128, 228, 32);
		painelMatricularProfessor_2.add(codigoNovaDisciplina);
		codigoNovaDisciplina.setColumns(10);
		
		nomeNovaDisciplina = new JTextField();
		nomeNovaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeNovaDisciplina.setColumns(10);
		nomeNovaDisciplina.setBounds(307, 128, 228, 32);
		painelMatricularProfessor_2.add(nomeNovaDisciplina);
		
		matriculaProfessorNovaDisciplina = new JTextField();
		matriculaProfessorNovaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculaProfessorNovaDisciplina.setColumns(10);
		matriculaProfessorNovaDisciplina.setBounds(31, 203, 228, 32);
		painelMatricularProfessor_2.add(matriculaProfessorNovaDisciplina);
		
		JPanel painelRemoverDisciplina = new JPanel();
		painelRemoverDisciplina.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelRemoverDisciplina, "painelRemoverDisciplina");
		painelRemoverDisciplina.setLayout(null);
		
		JPanel paineRemoverDisciplina = new JPanel();
		paineRemoverDisciplina.setLayout(null);
		paineRemoverDisciplina.setBackground(new Color(223, 223, 223));
		paineRemoverDisciplina.setBounds(38, 175, 560, 350);
		painelRemoverDisciplina.add(paineRemoverDisciplina);
		
		JButton btnRemoverDisciplina = new JButton("Remover");
		btnRemoverDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoverDisciplina.setBackground(new Color(240, 240, 240));
		btnRemoverDisciplina.setBounds(225, 290, 117, 35);
		paineRemoverDisciplina.add(btnRemoverDisciplina);
		
		JLabel lblCdigoDaDisciplina = new JLabel("Código da Disciplina:");
		lblCdigoDaDisciplina.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCdigoDaDisciplina.setBounds(31, 116, 294, 25);
		paineRemoverDisciplina.add(lblCdigoDaDisciplina);
		
		codigoRemoverDisciplina = new JTextField();
		codigoRemoverDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codigoRemoverDisciplina.setColumns(10);
		codigoRemoverDisciplina.setBounds(31, 148, 490, 32);
		paineRemoverDisciplina.add(codigoRemoverDisciplina);
		
		JLabel lblRemoverDisciplina = new JLabel("Remover Disciplina:");
		lblRemoverDisciplina.setForeground(Color.BLACK);
		lblRemoverDisciplina.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRemoverDisciplina.setBounds(38, 140, 283, 25);
		painelRemoverDisciplina.add(lblRemoverDisciplina);
		
		JPanel painelExibirProfessores = new JPanel();
		painelExibirProfessores.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelExibirProfessores, "painelExibirProfessores");
		painelExibirProfessores.setLayout(null);
		
		JScrollPane scrollPaneAlunos = new JScrollPane();
		scrollPaneAlunos.setBounds(38, 175, 560, 402);
		painelExibirProfessores.add(scrollPaneAlunos);
		
		tableProfessores = new JTable();
		scrollPaneAlunos.setViewportView(tableProfessores);
		
		JLabel lblProfessores = new JLabel("Professor:");
		lblProfessores.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProfessores.setBounds(38, 140, 214, 25);
		painelExibirProfessores.add(lblProfessores);
		
		JPanel painelExibirAluno = new JPanel();
		painelExibirAluno.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelExibirAluno, "painelExibirAluno");
		painelExibirAluno.setLayout(null);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAlunos.setBounds(38, 140, 214, 25);
		painelExibirAluno.add(lblAlunos);
		
		JScrollPane scrollPaneAlunos_1 = new JScrollPane();
		scrollPaneAlunos_1.setBounds(38, 175, 560, 402);
		painelExibirAluno.add(scrollPaneAlunos_1);
		
		tableAlunos = new JTable();
		scrollPaneAlunos_1.setViewportView(tableAlunos);
		
		JPanel painelExibirDisciplinas = new JPanel();
		painelExibirDisciplinas.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelExibirDisciplinas, "painelExibirDisciplinas");
		painelExibirDisciplinas.setLayout(null);
		
		JLabel lblProfessores_1 = new JLabel("Disciplina:");
		lblProfessores_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProfessores_1.setBounds(38, 140, 214, 25);
		painelExibirDisciplinas.add(lblProfessores_1);
		
		JScrollPane scrollPaneAlunos_2 = new JScrollPane();
		scrollPaneAlunos_2.setBounds(38, 175, 560, 402);
		painelExibirDisciplinas.add(scrollPaneAlunos_2);
		
		tableDisciplinas = new JTable();
		scrollPaneAlunos_2.setViewportView(tableDisciplinas);
		
		JPanel painelRedefinirSenha = new JPanel();
		painelRedefinirSenha.setBackground(new Color(198, 198, 198));
		cardPanel.add(painelRedefinirSenha, "painelRedefinirSenha");
		painelRedefinirSenha.setLayout(null);
		
		JPanel painelRedefinir = new JPanel();
		painelRedefinir.setLayout(null);
		painelRedefinir.setBackground(new Color(223, 223, 223));
		painelRedefinir.setBounds(38, 175, 560, 350);
		painelRedefinirSenha.add(painelRedefinir);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCPF.setBounds(31, 31, 84, 25);
		painelRedefinir.add(lblCPF);
		
		cpfRedefinir = new JTextField();
		cpfRedefinir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfRedefinir.setColumns(11);
		cpfRedefinir.setBounds(31, 61, 490, 32);
		painelRedefinir.add(cpfRedefinir);
		
		JLabel labelNovaSenha = new JLabel("Nova Senha:");
		labelNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelNovaSenha.setBounds(31, 100, 104, 25);
		painelRedefinir.add(labelNovaSenha);
		
		JLabel lblNovaSenha2 = new JLabel("Nova Senha, novamente:");
		lblNovaSenha2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaSenha2.setBounds(31, 179, 194, 25);
		painelRedefinir.add(lblNovaSenha2);
		
		JButton btnRedefinirSenha = new JButton("Redefinir");
		btnRedefinirSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRedefinirSenha.setBackground(new Color(240, 240, 240));
		btnRedefinirSenha.setBounds(225, 290, 117, 32);
		painelRedefinir.add(btnRedefinirSenha);
		btnRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cpfRedefinir.getText().isEmpty()|| String.valueOf(senhaRedefinir.getPassword()).isEmpty()|| String.valueOf(senhaRedefinirRpt.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int redefinirEscolha = JOptionPane.showConfirmDialog(frame,
							"Tem certeza que deseja redefinir sua senha?",
							"Confirmação",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					
					if(redefinirEscolha == JOptionPane.YES_OPTION) {
						String cpfLido = cpfRedefinir.getText();
						String senhaLida1 = String.valueOf(senhaRedefinir.getPassword());
						String senhaLida2 = String.valueOf(senhaRedefinirRpt.getPassword());
						if(!Coordenador.verificarCpfExiste(cpfLido)) {
							JOptionPane.showMessageDialog(frame, "Esse CPF não está cadastrado no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
						}  else if(!senhaLida1.equals(senhaLida2)) {
							JOptionPane.showMessageDialog(frame, "As senhas fornecidas não coincidem", "Status", JOptionPane.INFORMATION_MESSAGE);
						} else if(Coordenador.verificarCpfExiste(cpfLido)) {
								Coordenador.redefinirSenha(cpfLido, senhaLida1);
								JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso!\nFaça login novamente com a nova senha", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
								
								TelaLoginCoordenador telaLogin = new TelaLoginCoordenador();
						        telaLogin.frmLogin.setVisible(true);;
						        
						        TelaLoginCoordenador.setCoordenadorLogado(null);
						        frame.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "Ocorreu algum problema, verifique suas informações e tente novamente", "Status", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		
		senhaRedefinir = new JPasswordField();
		senhaRedefinir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaRedefinir.setBounds(31, 136, 490, 32);
		painelRedefinir.add(senhaRedefinir);
		
		senhaRedefinirRpt = new JPasswordField();
		senhaRedefinirRpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		senhaRedefinirRpt.setBounds(31, 217, 490, 32);
		painelRedefinir.add(senhaRedefinirRpt);
		
		JLabel lblRedefinirSenha = new JLabel("Redefinir Senha:");
		lblRedefinirSenha.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRedefinirSenha.setBounds(38, 140, 241, 25);
		painelRedefinirSenha.add(lblRedefinirSenha);
		
		
		labelSistemaEscolar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelnicial");
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
					TelaLoginCoordenador telaLogin = new TelaLoginCoordenador();
			        telaLogin.frmLogin.setVisible(true);;
			        
			        TelaLoginCoordenador.setCoordenadorLogado(null);
			        frame.dispose();
				}
			}
		});
		
		botaoMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cpfNovo.getText().isEmpty() || nomeNovo.getText().isEmpty() || String.valueOf(senhaNova.getPassword()).isEmpty()|| String.valueOf(senhaNova.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha os campos corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (Professor.verificarCpfExiste(cpfNovo.getText())) {
					JOptionPane.showMessageDialog(frame, "Professor ja existe no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!isAlphabetic(nomeNovo.getText())) {
					JOptionPane.showMessageDialog(frame, "Nome inválido, tente colocas apenas letras", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!String.valueOf(senhaNova.getPassword()).equals(String.valueOf(senhaRpt.getPassword()))) {
					JOptionPane.showMessageDialog(frame, "Senha não coincidem, tente novamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					coordenadorLogador.matricularProfessor(cpfNovo.getText(), nomeNovo.getText(), String.valueOf(senhaNova.getPassword()));
					JOptionPane.showMessageDialog(frame, "Professor matriculado com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					cpfNovo.setText("");
					nomeNovo.setText("");
					senhaNova.setText("");
					senhaRpt.setText("");
				}
				
			}
		});
		botaoMatAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cpfNovoAluno.getText().isEmpty() || nomeNovoAluno.getText().isEmpty() || String.valueOf(senhaNovoAluno.getPassword()).isEmpty()|| String.valueOf(senhaNovoAlunoRpt.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha os campos corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (Aluno.verificarCpfExiste(cpfNovoAluno.getText())) {
					JOptionPane.showMessageDialog(frame, "Aluno já existe no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!isAlphabetic(nomeNovoAluno.getText())) {
					JOptionPane.showMessageDialog(frame, "Nome inválido, tente colocas apenas letras", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!String.valueOf(senhaNovoAluno.getPassword()).equals(String.valueOf(senhaNovoAlunoRpt.getPassword()))) {
					JOptionPane.showMessageDialog(frame, "Senha não coincidem, tente novamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					coordenadorLogador.matricularAluno(cpfNovoAluno.getText(), nomeNovoAluno.getText(), String.valueOf(senhaNovoAluno.getPassword()));
					JOptionPane.showMessageDialog(frame, "Aluno matriculado com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					cpfNovoAluno.setText("");
					nomeNovoAluno.setText("");
					senhaNovoAluno.setText("");
					senhaNovoAlunoRpt.setText("");
				}
				
			}
		});
		btnRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculaRemoverAluno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campo em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if(!Aluno.verificarMatriculaExiste(matriculaRemoverAluno.getText())) {
					JOptionPane.showMessageDialog(frame, "Esse Aluno não está cadastrado no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Coordenador.excluirAluno(matriculaRemoverAluno.getText());
					JOptionPane.showMessageDialog(frame, "Aluno removido com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					matriculaRemoverAluno.setText("");
				}
			}
		});
		botaoCriarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(codigoNovaDisciplina.getText().isEmpty() || nomeNovaDisciplina.getText().isEmpty() || String.valueOf(matriculaProfessorNovaDisciplina.getText()).isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campos em branco, por favor preencha os campos corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (Disciplina.verificarDisciplina(codigoNovaDisciplina.getText())) {
					JOptionPane.showMessageDialog(frame, "Esse código de disciplina ja existe", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!isAlphabetic(nomeNovaDisciplina.getText())) {
					JOptionPane.showMessageDialog(frame, "Nome de disciplina inválido, tente colocas apenas letras", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if (!Professor.verificarMatriculaExiste(matriculaProfessorNovaDisciplina.getText())) {
					JOptionPane.showMessageDialog(frame, "Esse professor não existe", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					coordenadorLogador.adicionarDisciplina(codigoNovaDisciplina.getText(),nomeNovaDisciplina.getText(), matriculaProfessorNovaDisciplina.getText());
					JOptionPane.showMessageDialog(frame, "Disciplina criada com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					codigoNovaDisciplina.setText("");
					nomeNovaDisciplina.setText("");
					matriculaProfessorNovaDisciplina.setText("");
				}
			}
		});
		btnRemoverDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(codigoRemoverDisciplina.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Campo em branco, por favor preencha corretamente", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else if(!Disciplina.verificarDisciplina(codigoRemoverDisciplina.getText())) {
					JOptionPane.showMessageDialog(frame, "Essa disciplina não está cadastrado no sistema", "Status", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Coordenador.removerDisciplina(codigoRemoverDisciplina.getText());
					JOptionPane.showMessageDialog(frame, "Disciplina Removida removido com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
					codigoRemoverDisciplina.setText("");
				}
			}
		});
		botaoRedefinirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelRedefinirSenha");
			}
		});
		
		botaoMatricularProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelMatriculaProfessor");
			}
		});
		
		botaoRemoverProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelRemoverProfessor");
			}
		});
		botaoMatricularAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelMatriculaAluno");
			}
		});
		botaoRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelRemoverAluno");
			}
		});
		botaoCriarNovaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelCriarNovaDisciplina");
			}
		});
		botaoRemoverDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelRemoverDisciplina");
			}
		});
		botaoExibirAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelExibirAluno");
                
                DefaultTableModel modelAlunos = new DefaultTableModel();
                modelAlunos.addColumn("MATRICULA");
                modelAlunos.addColumn("NOME");
                modelAlunos.addColumn("CPF");
                
                ArrayList<Aluno> alunos = BancoDeDadosDao.listarAlunos();
                if(alunos.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Não existem alunos matriculados", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	for (Aluno aluno : alunos) {
		        		modelAlunos.addRow(new Object[]{aluno.getMatricula(),aluno.getNome(), aluno.getCpf()});
		        	}
				}
                tableAlunos.setModel(modelAlunos);
				tableAlunos.repaint();
			}
		});
		btnExibirProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelExibirProfessores");
                
                DefaultTableModel modelProfessores = new DefaultTableModel();
                modelProfessores.addColumn("MATRICULA");
                modelProfessores.addColumn("NOME");
                modelProfessores.addColumn("CPF");
                
                ArrayList<Professor> professores = BancoDeDadosDao.listarProfessores();
                if(professores.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Não existem professores matriculados", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	for (Professor prof : professores) {
						modelProfessores.addRow(new Object[]{prof.getMatricula(),prof.getNome(), prof.getCpf()});
			        }

	            
		        }
			tableProfessores.setModel(modelProfessores);
			tableProfessores.repaint();
			}
		});
		btnExibirDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout panelAtual = (CardLayout) (cardPanel.getLayout());
                panelAtual.show(cardPanel, "painelExibirDisciplinas");
                
                DefaultTableModel modelDisciplinas = new DefaultTableModel();
                modelDisciplinas.addColumn("CÓDIGO");
                modelDisciplinas.addColumn("NOME DISCIPLINA");
                modelDisciplinas.addColumn("PROFESSOR");
                
                ArrayList<Disciplina> disciplinas = BancoDeDadosDao.listarDisciplinas();
                if(disciplinas.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Não existem disciplinas cadastradas", "Notificação", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	for (Disciplina disci : disciplinas) {
		        		modelDisciplinas.addRow(new Object[]{disci.getCodigo(),disci.getNome(), disci.getProfessor(disci.getMatriculaprofessor()).getNome()});
			        }

	            
				}
                tableDisciplinas.setModel(modelDisciplinas);
				tableDisciplinas.repaint();
			}
		});
	}
}
