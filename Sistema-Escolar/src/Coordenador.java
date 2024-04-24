import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


//Classe Coordenador, subclasse de Usuario
public class Coordenador extends Usuario {

    //método construtor de Coordenador
    public Coordenador(String cpf, String nome, String senha) {

        super(cpf, nome, senha);
    }

    //Métodos @override, porque a função Login é statica, logo não seria possivel usar os gets da superclasse por ela
    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    //O Método de login e redefinirSenha, será "@override", porém apenas quando implementado API de banco de dados
    //Tendo em vista, que ainda é necessario passar o ArrayList usado para armazenar os Coornadores como parametro
    //Esse método é estatico. Pois, não é necessario instanciar um objeto pra chama-lo.
    public static boolean login(String cpf, String senha, ArrayList<Coordenador> coordenadoresDb) {
        for (Coordenador coord : coordenadoresDb){
            if(coord.getCpf().equals(cpf) && coord.getSenha().equals(senha)){
                return true;
            }
        }
        return false;

    }

    public void redefinirSenha(String cpf, String novaSenha, ArrayList<Coordenador> coordenadoresDb) {
        for(Coordenador coord : coordenadoresDb){
            if (getCpf().equals(cpf)) {
                setSenha(novaSenha);
                System.out.println("Senha alterada com sucesso. Por favor, faça login novamente!");
                return;
            }
        }
        System.out.println("CPF incorreto. Por favor, tente novamente!");
    }

    //retorna um objeto do Coordenador apartir do seu CPF
    public static Coordenador getCoordenadorObjeto(String cpf, ArrayList<Coordenador> coordenadores){
        for (Coordenador coord : coordenadores) {
            if (coord.getCpf().equals(cpf)) {
                return coord;
            }
        }
        return null;
    }

   //Usando regex, valida cpf e nome
    public boolean validarDados(String cpf, String nome, String senha) {
        //Verifica cpf,nome por meio de regex e senha apenas tem que ter mais de 6 digitos
        if (cpf.matches("\\d{11}") && nome.matches("[a-zA-Z ]+") && senha.length() >= 6) {
            return true;
        }
        System.out.println("Dados inválidos. Por favor, insira dados válidos!");
        return false;
    }

    //Gera uma matricula nova tanto para professor quanto para aluno
    //As matriculas podem ser iguais apenas para objetos diferentes no caso Aluno e Professor
    public String gerarMatricula() {
        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
        Random random = new Random();
        int num = random.nextInt(1000);
        return anoAtual + String.format("%04d", num);
    }

    //Adiciona um novo aluno ao sistema
    public void matricularAluno(String cpf, String nome, String senha, ArrayList<Aluno> alunos) {
        if (!Aluno.verificarCpfExiste(cpf,alunos)) { //Se o aluno não estiver cadastrado com o cpf
            if (validarDados(cpf, nome, senha)) { //valida as entradas
                String matricula;
                do {
                    matricula = gerarMatricula();
                } while (Aluno.verificarMatriculaExiste(matricula, alunos)); //Enquanto a matricula ja existir, gera uma nova
                Aluno alunoNovo = new Aluno(cpf, matricula, nome, senha);
                Main.adicionar(alunoNovo); //Método do main, que foi importado para salvar o novo aluno
                System.out.printf("O aluno foi matriculado com sucesso, sua matricula é: %s", alunoNovo.getMatricula());
                return;
            }
        }   else {
            System.out.println("Esse aluno já está matriculado!");
        }
    }

    //Remove um aluno do sistema
    public void excluirAluno(String cpfAluno, ArrayList<Aluno> alunos){
        for(Aluno aluno : alunos){
            if(aluno.getCpf().equals(cpfAluno)){
                Aluno alunoExcluido = Aluno.getAlunoObjeto(aluno.getMatricula(), alunos);
                Main.remover(alunoExcluido);
                assert alunoExcluido != null;
                System.out.printf("O Aluno: %s foi excluido", alunoExcluido.getNome() );
                return;
            }

        }
        System.out.println("Esse aluno não está matriculado!");

    }

    //Adiciona um professor ao sistema
    public void matricularProfessor(String cpf, String nome, String senha, ArrayList<Professor> professores){
        if (!Professor.verificarCpfExiste(cpf, professores)) { //Verifica se o professor ja existe
            if (validarDados(cpf, nome, senha)) {
                String matricula;
                do {
                    matricula = gerarMatricula();
                } while (Professor.verificarMatriculaExiste(matricula, professores)); //Enquanto a matricula ja existir, gera uma nova
                Professor professorNovo = new Professor(cpf, matricula, nome, senha);
                Main.adicionar(professorNovo); //Método do main, que foi importado para salvar o novo aluno
                System.out.printf("O aluno foi matriculado com sucesso, sua matricula é: %s", professorNovo.getMatricula());
                return;
            }else {
                System.out.println("Esse professor já está matriculado!");
            }
        }
    }

    //Remove o professor
    public void excluirProfessor(String cpfProfessor, ArrayList<Professor> professores){
        for(Professor prof : professores){
            if(prof.getCpf().equals(cpfProfessor)){
                Professor professorExcluido = Professor.getProfessorObjeto(prof.getMatricula(), professores);
                Main.remover(professorExcluido);
                assert professorExcluido != null;
                System.out.printf("O Professor: %s foi excluido", professorExcluido.getNome() );
                return;
            }
        }
        System.out.println("Esse professor não está matriculado!");

    }

    //Adiciona uma nova disciplina no sistema
    public void adicionarDisciplina(String codigo, String nome, Professor professor, ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas){
        if (Disciplina.verificarDisciplina(codigo,disciplinas)){
            System.out.println("Já existe uma disciplina com esse código!");
            return;
        } else {
                if (professores.contains(professor)){
                    Disciplina novaDisciplina = new Disciplina(codigo,nome,professor);
                    professor.receberDisciplina(novaDisciplina);
                    Main.adicionar(novaDisciplina);
                } else {
                    System.out.println("Esse professor não existe!");
                    return;
            }
        }
    }

    //Remove completamente uma disciplina
    public void removerDisciplina(String codigo, ArrayList<Disciplina> disciplinas){
        if (Disciplina.verificarDisciplina(codigo,disciplinas)) {
            Disciplina disciplinaRemover = Disciplina.getDisciplinaObjeto(codigo,disciplinas);
            assert disciplinaRemover != null;
            //Removendo todos os alunos da disciplina
            for (Aluno aluno : disciplinaRemover.getAlunos()){
                aluno.getBoletim().removerDisciplina(disciplinaRemover);
            }
            //Removendo o professor da disciplina
            disciplinaRemover.getProfessor().removerDisciplina(disciplinaRemover);
            Main.remover(disciplinaRemover); //Remover a disciplina da base de dados
        } else {
            System.out.println("Esse disciplina não existe!");
        }
    }

    //Mostra todos os alunos matriculados
    public void visualizarAlunos(){
        ArrayList<Aluno> listaAlunos = Main.getAlunosDb();
        for (Aluno aluno : listaAlunos){
            System.out.printf("Cpf: %s Matricula: %s Nome: %s CRA: %f\n", aluno.getCpf(),aluno.getMatricula(),aluno.getNome(),aluno.getCra());
        }
    }

    //Mostra todos os professores matriculados

    public void visualizarProfessores(){
        ArrayList<Professor> listaProfessores = Main.getProfessoresDb();
        for (Professor prof : listaProfessores){
            System.out.printf("Cpf: %s Matricula: %s Nome: %s Disciplinas: \n", prof.getCpf(),prof.getMatricula(),prof.getNome());
            for (Disciplina disciplina : prof.getDisciplinas()){
                System.out.print(disciplina);
            }
            System.out.println();
        }
    }

    //Mostra todas as disciplinas existentes

    public void visualizarDisciplinas(){
        ArrayList<Disciplina> listaDiscplinas = Main.getDisciplinasDb();
        for (Disciplina disc : listaDiscplinas){
            System.out.printf("Código: %s Nome: %s Professor: %s\n", disc.getCodigo(), disc.getNome(),disc.getProfessor().getNome());
        }
    }
}

