import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Aluno> alunosDb = new ArrayList<>();
    private static ArrayList<Professor> professoresDb = new ArrayList<>();
    private static ArrayList<Coordenador> coordenadoresDb = new ArrayList<>();
    private static ArrayList<Disciplina> disciplinasDb = new ArrayList<>();


    public static void main(String[] args) throws IOException, InterruptedException {
        // Exemplos de alunos, professores e coordenadores do database e database de disciplinas
        Aluno aluno1 = new Aluno("10917774469", "20241598", "Aluno1", "senha123");
        Aluno aluno2 = new Aluno("15468972351", "20240325", "Aluno2", "senha123");
        alunosDb.add(aluno1);
        alunosDb.add(aluno2);
        Professor professor1 = new Professor("12345678915", "20241568", "Prof. Carlos", "senha123");
        Professor professor2 = new Professor("12345879523", "20241564", "Prof. Base", "senha123");
        professoresDb.add(professor1);
        professoresDb.add(professor2);
        Coordenador coordenador1 = new Coordenador("12345678910", "Coord. Ana", "senha123");
        coordenadoresDb.add(coordenador1);
        Disciplina disciplina1 = new Disciplina("12345","Matemática",professor1);
        Disciplina disciplina2 = new Disciplina("12345","Geografia",professor2);
        disciplinasDb.add(disciplina1);
        disciplinasDb.add(disciplina2);


        menuPrincipal();


    }

    //Menu principal
    public static void menuPrincipal() throws IOException, InterruptedException {
        while (true) {
            System.out.println("\n=== Menu Principal ===\n");
            System.out.println("1. Menu do Aluno");
            System.out.println("2. Menu do Professor");
            System.out.println("3. Menu do Coordenador");
            System.out.println("4. Sair\n");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuProfessor();
                    break;
                case 3:
                    menuCoordenador();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
    //Menu do Aluno
    public static void menuAluno() throws IOException, InterruptedException {
        System.out.println("\n=== Menu do Aluno ===\n");

        System.out.print("Informe sua matrícula: ");
        String matriculaLida = scanner.next();
        System.out.print("Informe sua senha: ");
        String senhaLida = scanner.next();

        if(Aluno.login(matriculaLida, senhaLida, alunosDb)){
            System.out.println("\nLogin realizado com sucesso!\n");
            Aluno alunoAtual = Aluno.getAlunoObjeto(matriculaLida,alunosDb);
            assert alunoAtual != null;
            while (true) {
                System.out.println("1. Ver CRA");
                System.out.println("2. Dados de matricula do Aluno");
                System.out.println("3. Escolher nova disciplina");
                System.out.println("4. Trancar uma disciplina");
                System.out.println("5. Exibir boletim");
                System.out.println("6. Redefinir senha");
                System.out.println("7. Retornar ao Menu Principal\n");
                System.out.print("Escolha uma opção: ");

                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("\nCRA do aluno: " + alunoAtual.getCra() + "\n");
                        break;
                    case 2:
                        alunoAtual.exibirDados();
                        break;
                    case 3:
                        System.out.println("Digite o código da Disciplina que deseja cursar:");
                        String codigoEscolhido = scanner.next();
                        alunoAtual.cursarDisciplina(codigoEscolhido,disciplinasDb);
                        break;
                    case 4:
                        System.out.println("Digite o código da Disciplina que deseja trancar:");
                        String codigoTrancar = scanner.next();
                        alunoAtual.trancarDisciplina(codigoTrancar,disciplinasDb);
                        break;
                    case 5:
                        alunoAtual.exibirBoletim();
                        break;
                    case 6:
                        System.out.println("Digite seu CPF:");
                        String cpfLido = scanner.next();
                        System.out.println("Digite sua matricula:");
                        String matLida = scanner.next();
                        System.out.println("Digite sua nova senha:");
                        String novaSenha = scanner.next();
                        alunoAtual.redefinirSenha(matLida,cpfLido,novaSenha,alunosDb);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        break;
                    case 7:
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        } else {
            System.out.println("Matrícula ou senha incorretas. Por favor, tente novamente.");
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
        }


    }

    //Menu do professor
    public static void menuProfessor() throws IOException, InterruptedException {
        System.out.println("\n=== Menu do Professor ===\n");

        System.out.print("Informe sua matrícula: ");
        String matricula = scanner.next();
        System.out.print("Informe sua senha: ");
        String senha = scanner.next();

        if (Professor.login(matricula, senha, professoresDb)) {
            System.out.println("\nLogin realizado com sucesso!\n");
            Professor professorLogado = Professor.getProfessorObjeto(matricula, professoresDb);
            assert professorLogado != null;

            while (true) {
                System.out.println("1. Inserir Nota");
                System.out.println("2. Redefinir Senha");
                System.out.println("3. Visualizar disciplinas");
                System.out.println("4. Visualizar alunos");
                System.out.println("5. Retornar ao Menu Principal\n");
                System.out.print("Escolha uma opção: ");

                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Digite o código da disciplina:");
                        String codigoLido = scanner.next();
                        System.out.println("Digite a matricula do aluno:");
                        String matriculaLida = scanner.next();
                        System.out.println("Digite a nota do aluno:");
                        float notaLida = scanner.nextFloat();
                        Disciplina disciplina = Disciplina.getDisciplinaObjeto(codigoLido,disciplinasDb);
                        Aluno aluno = Aluno.getAlunoObjeto(matriculaLida, alunosDb);
                        professorLogado.inserirNota(disciplina,aluno,notaLida);
                        break;
                    case 2:
                        System.out.print("Informe sua matrícula: ");
                        String matriculaRedefinir = scanner.next();
                        System.out.print("Informe seu CPF: ");
                        String cpfLido = scanner.next();
                        System.out.print("Informe a nova senha: ");
                        String novaSenha = scanner.next();

                        professorLogado.redefinirSenha(matriculaRedefinir, cpfLido, novaSenha, professoresDb);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        break;
                    case 3:
                        professorLogado.exibirDisciplinas();
                        break;
                    case 4:
                        professorLogado.exibirAlunos();
                        break;
                    case 5:
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }

        }  else {
            System.out.println("Matrícula ou senha incorretas. Por favor, tente novamente.");
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
        }
    }


    //Menu do coordenador
    public static void menuCoordenador() throws IOException, InterruptedException {
        System.out.println("\n=== Menu do Coordenador ===\n");

        System.out.print("Informe seu Cpf: ");
        String cpf = scanner.next();
        System.out.print("Informe sua senha: ");
        String senha = scanner.next();

        if (Coordenador.login(cpf, senha, coordenadoresDb)) {
            Coordenador coordenadorLogado = Coordenador.getCoordenadorObjeto(cpf, coordenadoresDb);
            assert coordenadorLogado != null;

            while (true) {
                System.out.println("1. Matricular Aluno");
                System.out.println("2. Remover Aluno");
                System.out.println("3. Matricular Professor");
                System.out.println("4. Remover Professor");
                System.out.println("5. Criar nova Disciplina");
                System.out.println("6. Remover Disciplina");
                System.out.println("7. Exibir Alunos");
                System.out.println("8. Exibir Professores");
                System.out.println("9. Exibir Disciplinas");
                System.out.println("10. Redefinir Senha");
                System.out.println("11. Retornar ao Menu Principal\n");
                System.out.print("Escolha uma opção: ");

                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("CPF do Aluno");
                        String cpfAluno = scanner.next();
                        System.out.println("nome do Aluno");
                        String nomeAluno = scanner.next();
                        System.out.println("Senha do Aluno");
                        String senhaAluno = scanner.next();
                        coordenadorLogado.matricularAluno(cpfAluno, nomeAluno,senhaAluno, alunosDb);
                        break;
                    case 2:
                        System.out.println("CPF do Aluno");
                        String remover_Cpf_Aluno = scanner.next();
                        coordenadorLogado.excluirAluno(remover_Cpf_Aluno, alunosDb);

                        break;
                    case 3:
                        System.out.println("CPF do Professor:");
                        String cpf_novoProfessor = scanner.next();
                        System.out.println("Nome do Professor:");
                        String nome_novoProfessor = scanner.next();
                        System.out.println("Senha do Professor:");
                        String senha_novoProfessor = scanner.next();
                        coordenadorLogado.matricularProfessor(cpf_novoProfessor,nome_novoProfessor,senha_novoProfessor, professoresDb);
                        break;
                    case 4:
                        System.out.println("CPF do Professor a ser removido:");
                        String remover_Cpf_Professor = scanner.next();
                        coordenadorLogado.excluirProfessor(remover_Cpf_Professor, professoresDb);
                        break;
                    case 5:
                        System.out.println("Nova Disciplina:");
                        String novaDisciplina = scanner.next();
                        System.out.println("Codigo da disciplina:");
                        String codDisciplina = scanner.next();
                        System.out.println("Matricula do Professor:");
                        String matriculaProfessor = scanner.next();
                        Professor professorDisicplina = Professor.getProfessorObjeto(matriculaProfessor,professoresDb);
                        coordenadorLogado.adicionarDisciplina(codDisciplina, novaDisciplina, professorDisicplina,professoresDb,disciplinasDb);
                        break;
                    case 6:
                        System.out.println("Codigo da disciplina:");
                        String codigoDisciplina = scanner.next();
                        System.out.println(getDisciplinasDb());
                        coordenadorLogado.removerDisciplina(codigoDisciplina,disciplinasDb);
                        break;
                    case 7:
                        coordenadorLogado.visualizarAlunos();
                        break;
                    case 8:
                        coordenadorLogado.visualizarProfessores();
                        break;
                    case 9:
                        coordenadorLogado.visualizarDisciplinas();
                        break;
                    case 10:
                        System.out.println("Digite seu CPF:");
                        String cpfLido = scanner.next();
                        System.out.println("Digite sua nova senha:");
                        String novaSenha = scanner.next();
                        coordenadorLogado.redefinirSenha(cpfLido,novaSenha,coordenadoresDb);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        break;
                    case 11:
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Limpa o console
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        }
    }


    //Métodos Sobrecarregados para salvar alterações nos banco de dados provisórios
    public static void adicionar(Aluno alunoNovo) {

        alunosDb.add(alunoNovo);
    }
    public static void remover(Aluno alunoRemovido){

        alunosDb.remove(alunoRemovido);
    }
    public static void adicionar(Professor professorNovo) {

        professoresDb.add(professorNovo);
    }
    public static void remover(Professor professorExcluido){

        professoresDb.remove(professorExcluido);
    }
    public static void adicionar(Disciplina novaDisciplina){

        disciplinasDb.add(novaDisciplina);
    }
    public static void remover(Disciplina disciplinaRemover){

        disciplinasDb.remove(disciplinaRemover);
    }

    //Métodos que retornam o banco de dados provisorios
    public static ArrayList<Aluno> getAlunosDb() {

        return alunosDb;
    }

    public static ArrayList<Professor> getProfessoresDb() {

        return professoresDb;
    }

    public static ArrayList<Disciplina> getDisciplinasDb() {

        return disciplinasDb;
    }

}
    


    
