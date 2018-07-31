package kevin_maven_test;

import java.sql.Connection;
import java.util.UUID;

import excelUtils.makeExcelFileUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static Connection conn;

	public static void main(String[] args) {
		//App obj = new App();
		makeExcelFileUtils excel = new makeExcelFileUtils();
		excel.makeExcelFile("D:\\Eclipse-Workspace\\TestFile", "test.xls");

		//System.out.println(obj.generateUniqueKey());
	}

	public String generateUniqueKey() {

		String id = UUID.randomUUID().toString();
		return id;
	}
}
