package classes;
import java.time.LocalDate;
import java.util.Random;

import dao.BancoDeDadosDao;
import dao.CoordenadorDAO;


//Classe Coordenador, subclasse de Usuario
public class Coordenador extends Usuario {

    //método construtor de Coordenador
    public Coordenador(String cpf, String nome, String senha) {

        super(cpf, nome, senha);
    }
    
    //Executa o login do coordenador no banco de dados
    public static boolean login(String cpf, String senha) {
        return CoordenadorDAO.loginCoordenador(cpf, senha);

    }

    //Executa e salva a alteração da senha do Coordenador
    public static void redefinirSenha(String cpf, String novaSenha) {
           CoordenadorDAO.redefinirSenha(cpf, novaSenha);
    }
    
    //Verifica se existe algum professor com esse CPF no banco de dados
    public static boolean verificarCpfExiste(String cpf){
        for (Coordenador coord : BancoDeDadosDao.listarCoordenadores()) {
            if (coord.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    
    //retorna um objeto do Coordenador apartir do seu CPF
    public static Coordenador getCoordenadorObjeto(String cpf){
        for (Coordenador coord : BancoDeDadosDao.listarCoordenadores()) {
            if (coord.getCpf().equals(cpf)) {
                return coord;
            }
        }
        return null;
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
    public void matricularAluno(String cpf, String nome, String senha) {
           String matricula;
           do {
              matricula = gerarMatricula();
           } while (Aluno.verificarMatriculaExiste(matricula));
           CoordenadorDAO.cadastrarAluno(cpf, nome, senha, matricula);
           return;
            
    }

    //Remove um aluno do sistema
    public static void excluirAluno(String matricula){
       CoordenadorDAO.removerAlunoDAO(matricula);
    }

    //Adiciona um professor ao sistema
    public void matricularProfessor(String cpf, String nome, String senha){
                String matricula;
                do {
                    matricula = gerarMatricula();
                } while (Professor.verificarMatriculaExiste(matricula)); //Enquanto a matricula ja existir, gera uma nova
                CoordenadorDAO.cadastrarProfessorDAO(cpf, nome, senha, matricula);
                return;
    }

    //Remove o professor
    public static void excluirProfessor(String matricula){
    	CoordenadorDAO.removerProfessorDAO(matricula);
    }

    //Adiciona uma nova disciplina no sistema
    public void adicionarDisciplina(String codigo, String nome, String matriculaProfessor){
    	CoordenadorDAO.cadastrasDisciplinaDAO(codigo, nome, matriculaProfessor);
     }

    //Remove completamente uma disciplina
    public static void removerDisciplina(String codigo){
        CoordenadorDAO.removerDisciplinaDAO(codigo);
    }

}

