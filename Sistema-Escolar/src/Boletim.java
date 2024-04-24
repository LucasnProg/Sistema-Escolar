// Boletim.java

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Classe Boletim
public class Boletim {
    private Aluno aluno;
    private Map<Disciplina, ArrayList<Float>> notasPorDisciplina = new HashMap<>();

    //Método construtor de Boletim
    public Boletim(Aluno aluno) {
        this.aluno = aluno;
        notasPorDisciplina = null;
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
    public Map<Disciplina, ArrayList<Float>> getNotasPorDisciplina() {
        return notasPorDisciplina;
    }

}
