package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_Jmysql {
	
	private static Connection connection = null;
	
	public static Connection conexao() throws SQLException  {
		String servidor = "jdbc:mysql://127.0.0.1:3306/boletim_bm";
		String root = "root";
		String password = "Lucas123";

		//Cria a conexão com o banco de dados
		  if (connection == null || connection.isClosed()) {
	            connection = DriverManager.getConnection(servidor, root, password);
	        }

		  return connection;

}

    public static boolean conexao_OK() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexao estabelecida");
                return true;
            } else {
                System.out.println("Conexao não estabelecida");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	


}
