package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bancoDados.Conexao_Jmysql;

public class CoordenadorDAO {
    //Efetua o login do coordenador com suas credenciais
	public static boolean loginCoordenador(String cpfLogin, String senhaLogin){
		 
	     String sql =  "SELECT COUNT(*) AS total " +
	             "FROM coordenador " +
	             "WHERE cpf = ? AND senha = ?";
	     
	     Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;

	     try {
	         con = Conexao_Jmysql.conexao();
	         ps = con.prepareStatement(sql);
	         ps.setString(1, cpfLogin);
	         ps.setString(2, senhaLogin);

	         rs = ps.executeQuery();

	         if (rs.next() && rs.getInt("total") > 0) {
	             return true;
	         } 
	     }catch(Exception e){
	    	 return false;
	     }
	     return false;
	 } 
	//Redefine a senha do Coordenador 
	public static void redefinirSenha(String cpf, String novaSenha) {

		
		String updateSql = "UPDATE coordenador SET senha = ? WHERE cpf = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(updateSql);
			
			ps.setString(1, novaSenha);
			ps.setString(2, cpf);
			
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
	
	//Cadastrar e Remover Aluno
	public static void cadastrarAluno(String cpf, String nome, String senha, String matricula) {

		String sqlAluno = "INSERT INTO aluno (cpf, nome, senha,matricula, cra)\r\n"
				+ "VALUES (?, ?, ?,?, ?);";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(sqlAluno);
			
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, senha);
            ps.setString(4, matricula);
            ps.setFloat(5, (float) 0.0);
            
            ps.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	//Remove o aluno do banco de dados
	public static void removerAlunoDAO(String matricula) {
		String deleteAluno = "DELETE FROM aluno WHERE matricula = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(deleteAluno);
			
			ps.setString(1, matricula);
			ps.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	
	//Cadastra o professor no banco de dados
	public static void cadastrarProfessorDAO(String cpf, String nome, String senha, String matricula) {
		String sqlProfessor = "INSERT INTO professor (cpf,nome, senha, matricula) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(sqlProfessor);
			
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, senha);
	        ps.setString(4, matricula);
        	ps.executeUpdate();
     
		}catch (Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	
	//Remove o professor do banco de dados
	public static void removerProfessorDAO(String matricula) {
		String deleteProfessor = "DELETE FROM professor WHERE matricula = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(deleteProfessor);
			
			ps.setString(1, matricula);
			ps.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
				}
		}
	}
	
	//Cadastrar e Remover Disciplina
	@SuppressWarnings("resource")
	public static void cadastrasDisciplinaDAO(String codigo, String nome, String matriculaProfessor) {
		String insertDisciplina = "INSERT INTO disciplina (codigo, nome,matriculaProfessor) VALUES (?, ?,?)";
	    String insertProfessorDisciplina = "INSERT INTO professor_disciplina (cod_Disciplina, matriculaProfessor) VALUES (?, ?)";
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = Conexao_Jmysql.conexao();

	        ps = con.prepareStatement(insertDisciplina);
	        ps.setString(1, codigo);
	        ps.setString(2, nome);
	        ps.setString(3, matriculaProfessor);
	        ps.executeUpdate();
	        
	        ps = con.prepareStatement(insertProfessorDisciplina);
	        ps.setString(1, codigo);
	        ps.setString(2, matriculaProfessor);
	        ps.executeUpdate();
			
	        con.commit();
		}catch (Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	//Remove a disciplina do banco de dados
	public static void removerDisciplinaDAO(String codigo) {
	    String deleteBoletim = "DELETE FROM boletim WHERE disciplina_id = ?";
	    String deleteAlunoDisciplina = "DELETE FROM aluno_disciplina WHERE codDisciplina = ?";
	    String deleteProfessorDisciplina = "DELETE FROM professor_disciplina WHERE cod_Disciplina = ?";
	    String deleteDisciplina = "DELETE FROM disciplina WHERE codigo = ?";
	    
	    try (Connection con = Conexao_Jmysql.conexao();
	         PreparedStatement psBoletim = con.prepareStatement(deleteBoletim);
	         PreparedStatement psAlunoDisciplina = con.prepareStatement(deleteAlunoDisciplina);
	         PreparedStatement psProfessorDisciplina = con.prepareStatement(deleteProfessorDisciplina);
	         PreparedStatement psDisciplina = con.prepareStatement(deleteDisciplina)) {

	        psBoletim.setString(1, codigo);
	        psBoletim.executeUpdate();
	        
	        psAlunoDisciplina.setString(1, codigo);
	        psAlunoDisciplina.executeUpdate();
	        
	        psProfessorDisciplina.setString(1, codigo);
	        psProfessorDisciplina.executeUpdate();
	        
	        psDisciplina.setString(1, codigo);
	        psDisciplina.executeUpdate();
	        
	    } catch (Exception e) {
	    }
	}

    
    
   
}
    