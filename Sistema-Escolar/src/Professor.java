import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

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

    public ArrayList<Disciplina> getDisciplinas() {

        return disciplinas;
    }

    //O Método de login e redefinirSenha, será "@override", porém apenas quando implementado API de banco de dados
    //Tendo em vista, que ainda é necessario passar o ArrayList usado para armazenar os Professor como parametro
    //Esse método é estatico. Pois, não é necessario instanciar um objeto pra chama-lo.
    public static boolean login(String matricula, String senha, ArrayList<Professor> professores) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula) && professor.getSenha().equals(senha)) {
                return true;
            }
        }
        System.out.println("Matrícula ou senha incorretas. Por favor, tente novamente.");
        return false;
    }

    public void redefinirSenha(String matricula, String cpf, String novaSenha, ArrayList<Professor> professores) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula) && professor.getCpf().equals(cpf)) {
                professor.setSenha(novaSenha);
                System.out.println("Senha alterada com sucesso. Por favor, faça login novamente!");
                return;
            }
        }
        System.out.println("Dados incorretos. Por favor, tente novamente!");
    }

    //Esse método retorna um objeto Professor, apartir de uma matricula
    public static Professor getProfessorObjeto(String matricula, ArrayList<Professor> professores){
        for (Professor prof : professores) {
            if (prof.getMatricula().equals(matricula)) {
                return prof;
            }
        }
        return null;
    }


    //Método que adiciona uma nota ao aluno
    public void inserirNota(Disciplina disciplina,Aluno aluno, float nota) {
        if(this.disciplinas == null || this.disciplinas.isEmpty()){
            System.out.println("Você não tem disciplinas cadastradas para ministrar!");
            return;
        } else {
            for (Disciplina disc : this.disciplinas) {
                if (disc.equals(disciplina)) {
                    if (disc.getAlunos() == null || disc.getAlunos().isEmpty()){
                        System.out.println("Não existem alunos nessa turma, ainda.");
                        return;
                    }
                    for(Aluno alunoIterado : disciplina.getAlunos()){
                        if (alunoIterado.equals(aluno)){
                            alunoIterado.receberNota(disciplina, nota);
                        } else {
                            System.out.println("Esse aluno, não está cursando está disciplina.");
                            return;
                        }
                    }
                } else {
                    System.out.println("Você não ministra essa disciplina.");
                    return;
                }
            }
        }
    }

    //Retorna true caso o professor com a matricula exista, e caso não retorna false
    public static boolean verificarMatriculaExiste(String matriculaNova, ArrayList<Professor> professores){
        for (Professor prof : professores) {
            if (prof.getMatricula().equals(matriculaNova)) {
                return true;
            }
        }
        return false;
    }

    //Retorna true caso o professor com a cpf exista, e caso não retorna false
    public static boolean verificarCpfExiste(String cpf, ArrayList<Professor> professores){
        for (Professor prof : professores) {
            if (prof.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void receberDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    //Método que mostra todas as disciplinas do professor
    public void exibirDisciplinas(){
        if (this.disciplinas.isEmpty() || this.disciplinas == null){
            System.out.println("Você não está ministrando nenhuma disciplina");
        } else {
            for (Disciplina disc : this.disciplinas){
                System.out.printf("Código: %s Nome: %s", disc.getCodigo(), disc.getNome());
            }
            }
    }

    //Método que mostra os alunos de todas as disciplinas do professor
    public void exibirAlunos(){
        if (this.disciplinas.isEmpty() || this.disciplinas == null){
            System.out.println("Você não está ministrando nenhuma disciplina");
        } else {
            for (Disciplina disc : this.disciplinas) {
                System.out.printf("Código: %s Nome: %s\n", disc.getCodigo(), disc.getNome());
                System.out.println("Alunos matriculados:");
                if (disc.getAlunos().isEmpty() || disc.getAlunos()==null){
                    System.out.println("Não existem alunos matriculados nessa disciplina.");
                } else {
                    for (Aluno aluno : disc.getAlunos()) {
                        System.out.printf("Matricula: %s Nome: %s\n", aluno.getMatricula(), aluno.getNome());
                    }
                    System.out.println("\n");
                }
            }
        }
    }

    //remove a disciplina do professor
    public void removerDisciplina(Disciplina disciplina){
        this.disciplinas.remove(disciplina);
    }
}
