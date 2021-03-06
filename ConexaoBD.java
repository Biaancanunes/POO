package taqvim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

	private Connection conexao;
	private String driver, caminho, user, password;
	
	public ConexaoBD() {
		// atributo para definição do serviço do BD utilizado pela aplicação
		this.driver = "org.postgresql.Driver";
		// atributo para definição da url de acesso ao banco
		this.caminho = "jdbc:postgresql://localhost:5432/postgres";
		// atributo para definição do login do usuário no banco
		this.user = "postgres";
		// atributo para definição da senha do usuário no banco
		this.password = "123456";
		// objeto responsável pelo estabelecimento da conexão com o BD (será inicializado quando a conexão
		// com o banco for iniciada)
		this.conexao = null;
	}
	
	public void conectar() {
		// seta o drive de conexão como propriedade do sistema acessível pela aplicação ao ser
		// executada sobre a instância da JVM (o driver do BD deve ser importado para o projeto no Java Build Path) 
		System.setProperty("jdbc.Drivers", driver);
		
		try {
			// inicialização da conexão com o banco
			conexao = DriverManager.getConnection(caminho, user, password);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			// finalização da conexão com o banco (deve sempre ser chamado ao encerrar um
			// acesso ao banco)
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ResultSet executarSQL(String comando) {
		// toda consulta ao banco resulta em um objeto do tipo ResultSet
		ResultSet resultado = null;
		
		try {
			// objeto que permita e realiza a interface dos comandos SQL a serem enviados da
			// aplicação Java para o BD
			PreparedStatement stm = conexao.prepareStatement(comando);
			stm.execute();
			resultado = stm.getResultSet();
			
			// outra forma de realizar consultas ao banco:
			// Statement stm = conexao.createStatement();
			// resultado = stm.executeQuery(comando);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return resultado;
	}

	// para acessar a conexão (que está encapsulada)
	public Connection getConexao() {
		return conexao;
	}
	
}