package jdbcUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {

	private Properties props;
	private String user;
	private String password;
	private String className;
	private String url;

	private Connection conn;

	private void loagJdbc() {
		try {
			props = new Properties();
			props.load(new FileInputStream("jdbc.properties"));
			
			className = props.getProperty("jdbc.className");
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.user");
			password = props.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loagDriver() {
		try {
			Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getConnect
	 * */
	public Connection getConnect() {
		this.loagJdbc();
        
		System.out.println(className);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		this.loagDriver();
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("数据库连接成功！");
			
		} catch (SQLException e) {
			// TODO: handle exception
			conn = null;
			e.printStackTrace();
		}

		return conn;
	}
	
	public void closeConn() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void testClass() {
		//user = "test";
		//password = "123456";
		System.out.println(user);
		System.out.println(password);		
	}
}
