package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bancoDados.Conexao_Jmysql;
import classes.*;

public class AlunoDAO {
	//Efetua o login do aluno
	public static boolean loginAluno(String matricula, String senha){
     String sql =  "SELECT COUNT(*) AS total " +
             "FROM aluno " +
             "WHERE matricula = ? AND senha = ?";
     
     Connection con = null;
     PreparedStatement ps = null;
     try{
         con = Conexao_Jmysql.conexao();
         ps = con.prepareStatement(sql);
         
         ps.setString(1, matricula);
         ps.setString(2, senha);
         
         
        ResultSet rs = ps.executeQuery();
        
        if (rs.next() && rs.getInt("total") > 0) {
        	return true;
        }
         
     }catch(Exception e){
    	 return false;
     	} 
     return false;
	} 
	//redefine a senha do aluno
	public static void redefinirSenha(String matricula, String novaSenha) {

		String updateSql = "UPDATE aluno SET senha = ? WHERE matricula = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(updateSql);
			
			ps.setString(1, novaSenha);
			ps.setString(2, matricula);
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
		}finally {
			try {
				if(con != null)con.close();
				if(ps != null)ps.close();
			}catch(Exception e) {
			}
		}
	}
	//Matricula o aluno em uma disicplina 
	public void cursarDisciplinaDAO(Disciplina disciplina, Aluno aluno) {
		String insertBoletim = "INSERT INTO aluno_disciplina (matriculaAluno, codDisciplina) VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexao_Jmysql.conexao();
			ps = con.prepareStatement(insertBoletim);
			
			ps.setString(1, aluno.getMatricula());
			ps.setString(2, disciplina.getCodigo());
			
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}finally {
	        try {
	            if (con != null) con.close();
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            System.out.println("ERRO: " + e.getMessage());
	        }
	    }
	}
	//Tranca uma disciplina do aluno
	public void excluirDisciplinaAlunoDAO(Aluno aluno, Disciplina disciplina) {
	    String deleteDisciplinaAluno = "DELETE FROM aluno_disciplina WHERE matriculaAluno = ? AND codDisciplina = ?";
	    
	    Connection con = null;
	    PreparedStatement ps = null;
	    
	    try {
	        con = Conexao_Jmysql.conexao();
	        ps = con.prepareStatement(deleteDisciplinaAluno);
	        ps.setString(1, aluno.getMatricula());
	        ps.setString(2, disciplina.getCodigo());
	        
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Disciplina excluída com sucesso!");
	        } else {
	            System.out.println("Nenhuma disciplina encontrada para exclusão.");
	        }
	    } catch (Exception e) {
	        System.out.println("ERRO: " + e.getMessage());
	    } finally {
	        try {
	            if (con != null) con.close();
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            System.out.println("ERRO: " + e.getMessage());
	        }
	    }
	}
	//Retorna o boletim como Map do aluno
	public static Map<String, ArrayList<Float>> getBoletimAluno (Aluno aluno){
        Map<String, ArrayList<Float>> boletim = new HashMap<>();
        
        String listaDisciplinaAluno = "SELECT b.disciplina_id, b.nota_1, b.nota_2, b.nota_3, b.nota_4 " +
                "FROM boletim b " +
                "JOIN aluno a ON b.matriculaAluno = a.matricula " +
                "WHERE a.matricula = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet dados = null;

        try {
            con = Conexao_Jmysql.conexao();
            ps = con.prepareStatement(listaDisciplinaAluno);

            ps.setString(1, aluno.getMatricula());

            dados = ps.executeQuery();
            
            while(dados.next()) {
            	ArrayList<Float> notas = new ArrayList<>();
            	notas.add(dados.getFloat("nota_1"));
            	notas.add(dados.getFloat("nota_2"));
            	notas.add(dados.getFloat("nota_3"));
            	notas.add(dados.getFloat("nota_4"));
            	
            	boletim.put(dados.getString("disciplina_id"), notas);
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
        return boletim;
    }
}
