import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//classe Aluno, subclasse de Usuario
public class Aluno extends Usuario {
    private String matricula;
    private float cra;
    private Boletim boletim;

    //Contrutor de Aluno, usando também o super()
    public Aluno(String cpf, String matricula, String nome, String senha) {
        super(cpf, nome, senha);
        this.matricula = matricula;
        this.cra = 0.0f;
        this.boletim = new Boletim(this);
    }

    //Métodos de Aluno
    public String getMatricula() {
        return matricula;
    }

    public Boletim getBoletim() {
        return boletim;
    }

    public float getCra() {
        return cra;
    }

    public void calculaCra() {
        cra = boletim.calcularCra();
    }

    //O Método de login e redefinirSenha, será "@override", porém apenas quando implementado API de banco de dados
    //Tendo em vista, que ainda é necessario passar o ArrayList usado para armazenar os alunos como parametro
    //Esse método é estatico. Pois, não é necessario instanciar um objeto pra chama-lo.
    public static boolean login(String matricula, String senha, ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula) && aluno.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    public void redefinirSenha(String matricula, String cpf, String novaSenha, ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula) && aluno.getCpf().equals(cpf)) {
                aluno.setSenha(novaSenha);
                System.out.println("Senha alterada com sucesso. Por favor, faça login novamente!");
                return;
            }
        }
        System.out.println("Dados incorretos. Por favor, tente novamente!");
    }

    //Método retorna true, se aluno com matricula existir.
    //Retorna false, se aluno não existir
    //Esse método é estatico, pois não é chamado apartir de um objeto.
    public static boolean verificarMatriculaExiste(String matriculaNova, ArrayList<Aluno> alunos){
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matriculaNova)) {
                return true;
            }
        }
        return false;
    }

    //Esse método, retorna um objeto "Aluno" apartir de uma matricula
    public static Aluno getAlunoObjeto(String matricula, ArrayList<Aluno> alunos){
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }


    //Retorna true se o cpf ja estiver cadastrado, e retorna false caso não esteja
    public static boolean verificarCpfExiste(String cpf, ArrayList<Aluno> alunos){
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }


    //Retorna os dados pessoais do Aluno
    public void exibirDados() {
        System.out.println("\nCPF: " + getCpf());
        System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + getNome());
        System.out.println("CRA: " + cra + "\n");
    }

    //Esse método adiciona uma disciplina no boletim do aluno
    public void cursarDisciplina(String codigoDisciplina, ArrayList<Disciplina> disciplinas) {
        for(Disciplina disc : disciplinas){
            if(disc.getCodigo().equals(codigoDisciplina)){
                Disciplina disciplinaEscolhida = Disciplina.getDisciplinaObjeto(codigoDisciplina,disciplinas);
                if (!disciplinaEscolhida.procurarAluno(this)){
                    disciplinaEscolhida.adicionarAluno(this);
                    boletim.adicionarDisciplina(disciplinaEscolhida);
                    System.out.println("Disciplina adicionada ao boletim com sucesso!");
                    return;
                    } else {
                        System.out.println("Você ja está cursando essa disciplina!");
                        return;
                }
            }
        }
        System.out.println("Essa disciplina não existe!");
    }

    //Esse método remove a disciplina do boletim do aluno
    public void trancarDisciplina(String codigoDisciplina, ArrayList<Disciplina> disciplinas){
        for(Disciplina disc : disciplinas){
            if(disc.getCodigo().equals(codigoDisciplina)){
                Disciplina disciplinaEscolhida = Disciplina.getDisciplinaObjeto(codigoDisciplina,disciplinas);
                if (disciplinaEscolhida.procurarAluno(this)){
                    disciplinaEscolhida.removerAluno(this);
                    boletim.removerDisciplina(disciplinaEscolhida);
                    System.out.println("Disciplina removida do boletim com sucesso!");
                    return;
                    } else {
                        System.out.println("Você não está cursando essa disciplina!");
                        return;
                    }
                }

            }
        System.out.println("Essa disciplina não existe!");
        return;
    }

    //Método incrementa nota no boletim do aluno e atualiza seu CRA
    public void receberNota(Disciplina disciplina, float nota) {
        boletim.adicionarNota(disciplina, nota);
        calculaCra();
    }

    //Método que exibe o boletim do Aluno, chamado em menuAluno()
    public void exibirBoletim(){
        Map<Disciplina, ArrayList<Float>> boletim = this.boletim.getNotasPorDisciplina();
        if (boletim != null){
            for (Map.Entry<Disciplina, ArrayList<Float>> linhaBoletim : boletim.entrySet()) {
                System.out.print(linhaBoletim.getKey() + " : ");
                ArrayList<Float> notas = linhaBoletim.getValue();
                for (float nota : notas) {
                    System.out.print(nota + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Você não tem matriculas cadastradas no boletim!");
            return;
        }
    }
}
