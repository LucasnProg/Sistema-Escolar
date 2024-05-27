// Boletim.java
package classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.AlunoDAO;

//Classe Boletim
public class Boletim {
	private Aluno aluno;
    private Map<Disciplina, ArrayList<Float>> notasPorDisciplina;

    //Método construtor de Boletim
    public Boletim(Aluno aluno) {
        this.notasPorDisciplina = getNotasPorDisciplina(aluno);

    }

    //Esse método calcula o CRA do aluno
    public float calcularCra() {
        if (notasPorDisciplina.isEmpty()) {
            return 0.0f;
        }
        float somaCra = 0.0f;
        for (ArrayList<Float> notas : notasPorDisciplina.values()) {
            float somaNotas = 0.0f;
            for (float nota : notas) {
                somaNotas += nota;
            }
            somaCra += somaNotas / notas.size();
        }
        return somaCra / notasPorDisciplina.size();
    }

    //Adiciona uma nova disciplina no boletim
    public void adicionarDisciplina(Disciplina disciplina) {
        this.notasPorDisciplina.put(disciplina, new ArrayList<Float>());
    }
    //Remove uma disciplina do boletim
    public void removerDisciplina(Disciplina disciplina){
        this.notasPorDisciplina.remove(disciplina);
    }

    //adiciona uma nota inserida pelo professor ao boletim
    public void adicionarNota(Disciplina disciplina, float nota) {
        ArrayList<Float> notas = notasPorDisciplina.getOrDefault(disciplina, new ArrayList<>());
        notas.add(nota);
        notasPorDisciplina.put(disciplina, notas);
    }

    //Método get de notasPorDisciplina
    public Map<Disciplina, ArrayList<Float>> getNotasPorDisciplina(Aluno aluno) {
    	Map<Disciplina, ArrayList<Float>> notasPorDisciplina = new HashMap<Disciplina, ArrayList<Float>>();
    	Map<String, ArrayList<Float>> boletimBD = AlunoDAO.getBoletimAluno(aluno);
    	for(String codDisicplina : boletimBD.keySet()) {
    		notasPorDisciplina.put(Disciplina.getDisciplinaObjeto(codDisicplina), boletimBD.get(codDisicplina));
    	}
        return notasPorDisciplina;
    }

    //salva as alterações feitas no atributo notarPorDisciplina
	public void setNotasPorDisciplina(Map<Disciplina, ArrayList<Float>> notasPorDisciplina) {
		this.notasPorDisciplina = notasPorDisciplina;
	}
	
	//Retorna o aluno ao qual pertence o boletim
	public Aluno getAluno() {
		return aluno;
	}
    
    

}
