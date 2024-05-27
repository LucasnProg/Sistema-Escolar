package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bancoDados.Conexao_Jmysql;
import classes.*;

public class BancoDeDadosDao {
	//Retorna todas as disciplinas do Banco de dados
	public static ArrayList<Disciplina> listarDisciplinas() {
	    ArrayList<Disciplina> disciplinaBD = new ArrayList<>();

	    String selectDisciplina = "SELECT codigo, nome, matriculaProfessor FROM disciplina";
	    Connection conDisciplina = null;
        PreparedStatement psDisciplina = null;
        ResultSet dadosDisciplina = null;

	    try {
	    	conDisciplina = Conexao_Jmysql.conexao();
	    	psDisciplina = conDisciplina.prepareStatement(selectDisciplina);
	    	dadosDisciplina = psDisciplina.executeQuery();

	        while (dadosDisciplina.next()) {
	            String codigo = dadosDisciplina.getString("codigo");
	            String nomeDisciplina = dadosDisciplina.getString("nome");
	            String matriculaProfessor = dadosDisciplina.getString("matriculaProfessor");
	            Disciplina disciplina = new Disciplina(codigo, nomeDisciplina, matriculaProfessor);
	          
	            
	            disciplinaBD.add(disciplina);
	        }
	    } catch (Exception e) {
	    }finally { 
            try {
                if(conDisciplina != null)conDisciplina.close();
                if(psDisciplina != null)psDisciplina.close();
                dadosDisciplina.close();
            }catch(Exception e) {
            }
        }
	    return disciplinaBD;
	}
	//Retorna todos os professores do banco de dados
	public static ArrayList<Professor> listarProfessores(){

        ArrayList<Professor> professorBD = new ArrayList<Professor>();

        String select = "SELECT matricula, nome, cpf, senha FROM professor";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet dados = null;

        try {
            con = Conexao_Jmysql.conexao();
            ps = con.prepareStatement(select);

            dados = ps.executeQuery();

            while(dados.next()) {
                String matricula = dados.getString("matricula");
                String nome = dados.getString("nome");
                String cpf = dados.getString("cpf");
                String senha = dados.getString("senha");
                Professor novoProfessor = new Professor(cpf,matricula,nome,senha);

                professorBD.add(novoProfessor);
            }

            

        }catch (Exception e) {
        }finally { 
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
                dados.close();
            }catch(Exception e) {
            }
        }
        return professorBD;
    }
	//Retorna todos os alunos do banco de dados
	public static ArrayList<Aluno> listarAlunos(){
	    ArrayList<Aluno> alunosBD = new ArrayList<>();
	    String select = "SELECT cpf, nome, senha, matricula FROM aluno";
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet dados = null;

	    try {
	        con = Conexao_Jmysql.conexao();
	        ps = con.prepareStatement(select);
	        dados = ps.executeQuery();

	        while(dados.next()) {
	            String nomeNovo = dados.getString("nome");
	            String cpfNovo = dados.getString("cpf");
	            String senhaNovo = dados.getString("senha");
	            String matriculaNovo = dados.getString("matricula");
	            Aluno alunoNovo = new Aluno(cpfNovo, matriculaNovo, nomeNovo, senhaNovo);
	            alunosBD.add(alunoNovo);
	            
	        }
	    } catch (SQLException e) {
	    } finally { 
	        try {
	            if(con != null) con.close();
	            if(ps != null) ps.close();
	            if(dados != null) dados.close();
	        } catch(Exception e) {
	        }
	    }
	    return alunosBD;
	}

	//Retorna todos os alunos de uma disciplina determinada
	public static ArrayList<String> getAlunosPorDisciplina(Disciplina disciplina) {
	    ArrayList<String> alunosCursando = new ArrayList<>();

	    String select = "SELECT a.matricula "
	    		+ "FROM aluno a "
	    		+ "INNER JOIN aluno_disciplina ad ON a.matricula = ad.matriculaAluno "
	    		+ "WHERE ad.codDisciplina = ?";

	    try (
	    	Connection con = Conexao_Jmysql.conexao();
	        PreparedStatement ps = con.prepareStatement(select)) {

	        ps.setString(1, disciplina.getCodigo());

	        try (ResultSet dados = ps.executeQuery()) {
	            while (dados.next()) {
	                String matriculaAluno = dados.getString("matricula");
	                alunosCursando.add(matriculaAluno);
	            }
	        }
	    } catch (Exception e) {
	    }

	    return alunosCursando;
	}
	//Retorna todos os coordenadores do banco de dados
	 public static  ArrayList<Coordenador> listarCoordenadores(){
			
			ArrayList<Coordenador> coordenadoresBd = new ArrayList<Coordenador>();
			
			String select = "SELECT  cpf, nome, senha FROM coordenador";
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet dados = null;
			
			try {
				con = Conexao_Jmysql.conexao();
				ps = con.prepareStatement(select);
				
				dados = ps.executeQuery();
				while(dados.next()) {
	                String nome = dados.getString("nome");
	                String cpf = dados.getString("cpf");
	                String senha = dados.getString("senha");
	                Coordenador coordenador = new Coordenador(cpf,nome,senha);

	                coordenadoresBd.add(coordenador);
	            }
				
			}catch (Exception e) {
			}finally { 
				try {
					if(con != null)con.close();
					if(ps != null)ps.close();
					if(dados != null)dados.close();
				}catch(Exception e) {
				}
			}
			return coordenadoresBd;
		}
	 //Matricula o aluno em uma disciplina
	 public static void matricularAlunoDisciplina(String matriculaAluno, String codigoDisciplina) {
		    String insertMatricula = "INSERT INTO aluno_disciplina (matriculaAluno, codDisciplina) VALUES (?, ?)";
		    Connection con = null;
		    PreparedStatement ps = null;
		    
		    try {
		        con = Conexao_Jmysql.conexao();
		        ps = con.prepareStatement(insertMatricula);
		        
		        ps.setString(1, matriculaAluno);
		        ps.setString(2, codigoDisciplina);
		        
		        ps.executeUpdate();
		    } catch (Exception e) {
		    } finally {
		        try {
		            if (con != null) con.close();
		            if (ps != null) ps.close();
		        } catch (Exception e) {
		        }
		    }
		}
	 //Adiciona a disicplina ao boletim
	 public static void adicionarDisciplinaBoletim(String matriculaAluno, String codigoDisciplina) {
		    String insertDisciplina = "INSERT INTO boletim (matriculaAluno, disciplina_id) VALUES (?, ?)";
		    Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        con = Conexao_Jmysql.conexao();
		        ps = con.prepareStatement(insertDisciplina);

		        ps.setString(1, matriculaAluno);
		        ps.setString(2, codigoDisciplina);

		        ps.executeUpdate();
		    } catch (SQLException e) {
		    } finally {
		    	try {
		            if (ps != null) ps.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		        }
		    }
		}
	 //Remove a relação entre o aluno e a disciplina
	 public static void removerAlunoDisciplina(String matriculaAluno, String codigoDisciplina) {
		    String deleteMatricula = "DELETE FROM aluno_disciplina WHERE matriculaAluno = ? AND codDisciplina = ?";
		    Connection con = null;
		    PreparedStatement ps = null;
		    
		    try {
		        con = Conexao_Jmysql.conexao();
		        ps = con.prepareStatement(deleteMatricula);
		        
		        ps.setString(1, matriculaAluno);
		        ps.setString(2, codigoDisciplina);
		        
		        ps.executeUpdate();
		    } catch (Exception e) {
		    } finally {
		        try {
		            if (con != null) con.close();
		            if (ps != null) ps.close();
		        } catch (Exception e) {
		        }
		    }
		}
	 //Remove a disciplina do boletim
	 public static void removerDisciplinaBoletim(String matriculaAluno, String codigoDisciplina) {
		    String deleteDisciplina = "DELETE FROM boletim WHERE matriculaAluno = ? AND disciplina_id = ?";
		    Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        con = Conexao_Jmysql.conexao();
		        ps = con.prepareStatement(deleteDisciplina);

		        ps.setString(1, matriculaAluno);
		        ps.setString(2, codigoDisciplina);

		        ps.executeUpdate();
		    } catch (SQLException e) {
		    } finally {
		        try {
		            if (ps != null) ps.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		        }
		    }
		}
	 

}
