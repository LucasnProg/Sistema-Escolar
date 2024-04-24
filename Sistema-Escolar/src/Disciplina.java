import java.util.ArrayList;

//classe Disciplina
public class Disciplina {
    private String codigo;
    private String nome;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    //construtor de disciplina
    public Disciplina(String codigo, String nome, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    //Métodos de disciplina
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    //Adiciona um novo aluno a lista de alunos
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    //remove Aluno da disciplina
    public void removerAluno(Aluno aluno){
        this.alunos.remove(aluno);
    }

    //verifica se aluno existe na disciplina
    public boolean procurarAluno(Aluno aluno){
        for(Aluno al : this.alunos){
            if(aluno.equals(al)){
                return true;
            }
        }
        return false;
    }

    //retorna um objeto Disciplina pelo codigo
    public static Disciplina getDisciplinaObjeto(String codigo, ArrayList<Disciplina> disciplinas){
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    //verifica se disciplina existe
    public static boolean verificarDisciplina(String codigo, ArrayList<Disciplina> disciplinas){
        for (Disciplina disc : disciplinas){
            if (disc.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
}
