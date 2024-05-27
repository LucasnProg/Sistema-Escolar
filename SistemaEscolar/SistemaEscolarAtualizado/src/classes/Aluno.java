package classes;

import java.util.ArrayList;
import java.util.Map;

import dao.AlunoDAO;
import dao.BancoDeDadosDao;
//classe Aluno, subclasse de Usuario
public class Aluno extends Usuario {
    private String matricula;
    private float cra;
    private Boletim boletim;

    //Contrutor de Aluno, usando também o super()
    public Aluno(String cpf, String matricula, String nome, String senha) {
        super(cpf, nome, senha);
        this.matricula = matricula;
    }

    //Métodos de Aluno
    public String getMatricula() {
        return matricula;
    }

    //Pega o boletim do aluno
    public Boletim getBoletim() {
    	this.boletim = new Boletim(this);
        return boletim;
    }
    
    //Retorna o cra do aluno
    public float getCra() {
    	   Map<Disciplina, ArrayList<Float>> notasPorDisciplina = this.getBoletim().getNotasPorDisciplina(this);
    	    
    	   float somaTotal = 0;
    	   int countTotal = 0;

    	   for (Map.Entry<Disciplina, ArrayList<Float>> disciplinas : notasPorDisciplina.entrySet()) {
    	        ArrayList<Float> notas = disciplinas.getValue();

    	        for (Float nota : notas) {
    	            if (nota != null) {
    	                somaTotal += nota;
    	                countTotal++;
    	            }
    	        }
    	    }
    	
    	   cra = (countTotal > 0) ? somaTotal / countTotal : 0;
    	   return cra;
    }
    
    //Chama a função que faz o login com as informações do banco de dados
    public static boolean login(String matricula, String senha) {
        return AlunoDAO.loginAluno(matricula, senha);
    }

    //chama a função que redefine a senha e salva direto no banco de dados
    public static void redefinirSenha(String matricula, String novaSenha) {
    	AlunoDAO.redefinirSenha(matricula, novaSenha);
    }
    
    //Verifica se existe a matricula no banco de dados
    public static boolean verificarMatriculaExiste(String matriculaNova){
        for (Aluno aluno : BancoDeDadosDao.listarAlunos()) {
            if (aluno.getMatricula().equals(matriculaNova)) {
                return true;
            }
        }
        return false;
    }

    //Esse método, retorna um objeto "Aluno" apartir de uma matricula
    public static Aluno getAlunoObjeto(String matricula){
        for (Aluno aluno : BancoDeDadosDao.listarAlunos()) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }


    //Retorna true se o cpf ja estiver cadastrado, e retorna false caso não esteja
    public static boolean verificarCpfExiste(String cpf){
        for (Aluno aluno : BancoDeDadosDao.listarAlunos()) {
            if (aluno.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    //matricula o aluno numa nova disciplina
    public boolean matricularDisciplina(String codigoDisciplina) {
        for(Disciplina disc : BancoDeDadosDao.listarDisciplinas()){
            if(disc.getCodigo().equals(codigoDisciplina)){
                if (!Disciplina.procurarAluno(this, codigoDisciplina)){
                    BancoDeDadosDao.matricularAlunoDisciplina(this.getMatricula(), codigoDisciplina);;
                    BancoDeDadosDao.adicionarDisciplinaBoletim(this.getMatricula(), codigoDisciplina);
                    return true;
                    } 
                }
            }
        return false;
      
    }
    
    //tranca a disciplina do aluno
    public boolean removerDisciplina(String codigoDisciplina){
    	for(Disciplina disc : BancoDeDadosDao.listarDisciplinas()){
            if(disc.getCodigo().equals(codigoDisciplina)){
                if (Disciplina.procurarAluno(this, codigoDisciplina)){
                	BancoDeDadosDao.removerAlunoDisciplina(this.getMatricula(), codigoDisciplina);;
                    BancoDeDadosDao.removerDisciplinaBoletim(this.getMatricula(), codigoDisciplina);
                    return true;
                } 
            }
        }
    return false;
  
}

}
