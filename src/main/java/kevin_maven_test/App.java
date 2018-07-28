package kevin_maven_test;

import java.sql.Connection;
import java.util.UUID;

import jdbcUtils.jdbcUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static Connection conn;
	
	public static void main(String[] args) {
		App obj = new App();
		jdbcUtil jdbc = new jdbcUtil();
		jdbcUtil jdbc_test = new jdbcUtil();

		
		
		conn = jdbc.getConnect();
		jdbc.closeConn();
		jdbc_test.testClass();
		System.out.println(obj.generateUniqueKey());
	}

	public String generateUniqueKey() {

		String id = UUID.randomUUID().toString();
		return id;
	}
}
