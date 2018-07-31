package jdbcUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtil {
	private static String user;
	private static String password;
	private static String className;
	private static String url;
	
	/**************************************************************
	 * loagJdbc：获取配置文件的值
	 * @author Joker
	 **************************************************************/
	private void loagJdbc() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("jdbc.properties"));
			
			className = props.getProperty("jdbc.className");
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.user");
			password = props.getProperty("jdbc.password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**************************************************************
	 * getConnect：连接数据库
	 * @author Joker
	 **************************************************************/
	public Connection getConnect() {
	    Connection conn;

		try {
			this.loagJdbc();
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功！");
			
		}catch (SQLException e) {
			// TODO: handle exception
			conn = null;
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			conn = null;
			e.printStackTrace();
		}
		return conn;
	}
	
	/**************************************************************
	 * closeConn：关闭数据库连接
	 * @author Joker
	 * @param conn
	 **************************************************************/
	public void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**************************************************************
	 * closeStmt：关闭数据库连接
	 * @author Joker
	 * @param stmt
	 **************************************************************/
	public void closeStmt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**************************************************************
	 * closePstmt：关闭数据库连接
	 * @author Joker
	 * @param pstmt
	 **************************************************************/
	public void closePstmt(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**************************************************************
	 * closePstmt：关闭数据库连接
	 * @author Joker
	 * @param rs
	 **************************************************************/
	public void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
