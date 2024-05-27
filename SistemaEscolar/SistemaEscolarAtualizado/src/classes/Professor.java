package classes;

import java.util.ArrayList;

import dao.BancoDeDadosDao;
import dao.ProfessorDAO;

//Classe Professor, subclasse de Usuario
public class Professor extends Usuario {
    private String matricula;
    private ArrayList<Disciplina> disciplinas;

    //Método construtor de Professor
    public Professor(String cpf, String matricula, String nome, String senha) {
        super(cpf, nome, senha);
        this.matricula = matricula;
        disciplinas = new ArrayList<>();
    }

    //Métodos de Professor
    public String getMatricula() {
        return matricula;
    }
    //Retornas as disciplinas ministradas pelo professor
    public ArrayList<Disciplina> getDisciplinas() {
    	ArrayList<String> codigosDisciplinas = ProfessorDAO.ListarDiscipliaProf(this);
    	disciplinas.clear();
    	for(String cod : codigosDisciplinas) {
    		disciplinas.add(Disciplina.getDisciplinaObjeto(cod));
    	}
        return disciplinas;
    }
    //Efetua o login do professor pelas informações do banco de dados
    public static boolean login(String matricula, String senha) {
    	return ProfessorDAO.loginProfessor(matricula, senha);
    }
    //Altera a senha do professor no banco de dados
    public static void redefinirSenha(String matricula, String novaSenha) {
    	ProfessorDAO.redefinirSenha(matricula, novaSenha);
    }
  

    //Esse método retorna um objeto Professor, apartir de uma matricula
    public static Professor getProfessorObjeto(String matricula){
        for (Professor prof : BancoDeDadosDao.listarProfessores()) {
            if (prof.getMatricula().equals(matricula)) {
                return prof;
            }
        }
        return null;
    }


    //Método que adiciona uma nota ao aluno
    public void inserirNota(Disciplina disciplina,Aluno aluno, float nota, String unidade) {
    	if(unidade.equals("U-1 | P-1")) {
    		ProfessorDAO.inserirNota(aluno, disciplina, nota, 1);
    	} else if(unidade.equals("U-1 | P-2")) {
    		ProfessorDAO.inserirNota(aluno, disciplina, nota, 2);
    	} else if(unidade.equals("U-2 | P-1")) {
    		ProfessorDAO.inserirNota(aluno, disciplina, nota, 3);
    	} else if(unidade.equals("U-2 | P-2")) {
    		ProfessorDAO.inserirNota(aluno, disciplina, nota, 4);
    	}
           
    }

    //Retorna true caso o professor com a matricula exista, e caso não retorna false
    public static boolean verificarMatriculaExiste(String matriculaNova){
        for (Professor prof : BancoDeDadosDao.listarProfessores()) {
            if (prof.getMatricula().equals(matriculaNova)) {
                return true;
            }
        }
        return false;
    }

    //Retorna true caso o professor com a cpf exista, e caso não retorna false
    public static boolean verificarCpfExiste(String cpf){
        for (Professor prof : BancoDeDadosDao.listarProfessores()) {
            if (prof.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    //Adiciona uma disciplina ao professor
    public void receberDisciplina(Disciplina disciplina){
        ProfessorDAO.adicionarProfessorDisciplina(this.getMatricula(), disciplina.getCodigo());
    }
    //Remove uma disciplina do professor
    public void removerDisciplina(Disciplina disciplina){
        ProfessorDAO.removerProfessorDisciplina(this.getMatricula(), disciplina.getCodigo());
    }
}
