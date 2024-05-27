package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import bancoDados.Conexao_Jmysql;
import classes.*;

public class ProfessorDAO {
	//Retorna as disciplinas de um determinado professor
	public static ArrayList<String> ListarDiscipliaProf(Professor professor){
		ArrayList<String> disciplinaProf = new ArrayList<String>();
		String selectDisciProf = "SELECT d.codigo, d.nome " +
                "FROM disciplina d " +
                "INNER JOIN professor_disciplina pd ON d.codigo = pd.cod_Disciplina " +
                "WHERE pd.matriculaProfessor = ?";
		Connection con = null;
		PreparedStatement  ps = null;
		ResultSet dados = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(selectDisciProf);
			ps.setString(1, professor.getMatricula());
			dados = ps.executeQuery();
			
			while(dados.next()) {
				disciplinaProf.add(dados.getString("codigo"));

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
		return disciplinaProf;
	}

	
    //Efetua o login do professor
	public static boolean loginProfessor(String matricula, String senha){
		 
	     String sql =  "SELECT COUNT(*) AS total " +
	             "FROM professor " +
	             "WHERE matricula = ? AND senha = ?";
	     
	     Connection con = null;
	     PreparedStatement ps = null;
	     try{
	         con = Conexao_Jmysql.conexao();
	         ps = con.prepareStatement(sql);
	         
	         ps.setString(1, matricula);
	         ps.setString(2, senha);
	         
	         
	        ResultSet dados = ps.executeQuery();
	        
	        if (dados.next() && dados.getInt("total") > 0) {
	            return true;
	        }
	        ps.close(); 
	         
	     }catch(Exception e) {   
	     }
	     return false;
	 } 
	//Altera a senha do Professor
	public static void redefinirSenha(String matricula, String senha) {

		
		String updateSql = "UPDATE professor SET senha = ? WHERE matricula = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(updateSql);
			
			ps.setString(1, senha);
			ps.setString(2, matricula);
			
			ps.execute();
			
			
		}catch(Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	//Insere a nota no aluno
	public static void inserirNota(Aluno aluno, Disciplina disciplina, float nota, int unidade) {
	    String sql = null;
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = Conexao_Jmysql.conexao();

	        switch (unidade) {
	            case 1:
	                sql = "UPDATE boletim SET nota_1 = ? WHERE matriculaAluno = ? AND disciplina_id = ?";
	                break;
	            case 2:
	                sql = "UPDATE boletim SET nota_2 = ? WHERE matriculaAluno = ? AND disciplina_id = ?";
	                break;
	            case 3:
	                sql = "UPDATE boletim SET nota_3 = ? WHERE matriculaAluno = ? AND disciplina_id = ?";
	                break;
	            case 4:
	                sql = "UPDATE boletim SET nota_4 = ? WHERE matriculaAluno = ? AND disciplina_id = ?";
	                break;
	        }

	        ps = con.prepareStatement(sql);
	        ps.setFloat(1, nota);
	        ps.setString(2, aluno.getMatricula());
	        ps.setString(3, disciplina.getCodigo());
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


	//Adiciona a relação entre professor e disciplina
	public static void adicionarProfessorDisciplina(String matriculaProfessor, String codigoDisciplina) {
	    String insertSql = "INSERT INTO professor_disciplina (matriculaProfessor, cod_Disciplina) VALUES (?, ?)";
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = Conexao_Jmysql.conexao();
	        ps = con.prepareStatement(insertSql);
	        ps.setString(1, matriculaProfessor);
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
	//Remove a relação entre professor e disciplina
	public static void removerProfessorDisciplina(String matriculaProfessor, String codigoDisciplina) {
		    String deleteSql = "DELETE FROM professor_disciplina WHERE matriculaProfessor = ? AND cod_Disciplina = ?";
		    Connection con = null;
		    PreparedStatement ps = null;
	
		    try {
		        con = Conexao_Jmysql.conexao();
		        ps = con.prepareStatement(deleteSql);
		        ps.setString(1, matriculaProfessor);
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
