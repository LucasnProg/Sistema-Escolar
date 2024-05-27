package classes;
import java.util.ArrayList;
import java.util.Map;

import dao.BancoDeDadosDao;

//classe Disciplina
public class Disciplina {
    private String codigo;
    private String nome;
    private Professor professor;
    private String Matriculaprofessor;
    private ArrayList<String> alunosCursando;

    //construtor de disciplina
    /*public Disciplina(String codigo, String nome, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.alunosCursando = new ArrayList<>();
    }*/
    public Disciplina(String codigo, String nome, String matricula) {
        this.codigo = codigo;
        this.nome = nome;
        this.Matriculaprofessor = matricula;
        this.alunosCursando = new ArrayList<>();
    }

    //Retorna o código da disciplina
    public String getCodigo() {
        return codigo;
    }
    //Retorna o nome da disciplina
    public String getNome() {
        return nome;
    }
    //Retorna o objeto professor que ministra essa disciplina
    public Professor getProfessor(String matricula) {
    	professor = Professor.getProfessorObjeto(matricula);
        return professor;
    }
    //Retorna o array de alunos que cursam essa disciplina
    public ArrayList<String> getAlunos() {
    	ArrayList<String> alunos = BancoDeDadosDao.getAlunosPorDisciplina(this);
    	alunosCursando = alunos;
        return alunosCursando;
    }

    //Adiciona um novo aluno a lista de alunos
    public void adicionarAluno(String matriculaAaluno) {
        this.alunosCursando.add(matriculaAaluno);
    }
    //remove Aluno da disciplina
    public void removerAluno(String matriculaAluno){
        this.alunosCursando.remove(matriculaAluno);
    }
    //Altera os alunos que cursam 
    public void setAlunos(ArrayList<String> alunos) {
		this.alunosCursando = alunos;
	}

	//verifica se aluno existe na disciplina
    public static boolean procurarAluno(Aluno aluno, String disciplinaCheck){
    	Map<Disciplina, ArrayList<Float>> notasPorDisciplina = aluno.getBoletim().getNotasPorDisciplina(aluno);
    	for (Disciplina disciplina : notasPorDisciplina.keySet()) {
    	    if(disciplina.getCodigo().equals(disciplinaCheck)) {
    	    	return true;
    	    }
    	}
	   
        return false;
    }

    //retorna um objeto Disciplina pelo codigo
    public static Disciplina getDisciplinaObjeto(String codigo){
        for (Disciplina disciplina : BancoDeDadosDao.listarDisciplinas()) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    //verifica se disciplina existe
    public static boolean verificarDisciplina(String codigo){
        for (Disciplina disc : BancoDeDadosDao.listarDisciplinas()){
            if (disc.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    //Retorna a matricula do professor
	public String getMatriculaprofessor() {
		return Matriculaprofessor;
	}
}
