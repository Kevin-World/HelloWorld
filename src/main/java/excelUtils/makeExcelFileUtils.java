package excelUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jdbcUtils.jdbcUtil;

public class makeExcelFileUtils {

	public void makeExcelFile(String filePath, String fileName) {
		Connection conn = null;
		jdbcUtil jdbc = new jdbcUtil();
		try {
			conn = jdbc.getConnect();
			ResultSet rSet = getInventoryData(conn);

			writeDataToExcel(rSet, filePath, fileName);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ResultSet getInventoryData(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;

		String sqlTxt = "select upper(t.item_code) item_code," + " upper(t.organization_code_rec) organizationCode, "
				+ "rec.subinventory_code subinventoryCode, " + "rec.inventory_location inventoryLocation, "
				+ "t.qty recQuantity, rec.qty quantity, t.r_date rDate "
				+ "FROM xxc.xxc_compare_result t,xxc_onhand_receive rec "
				+ "WHERE 1 = 1 AND t.rownumber_rec = rec.rownumber "
				+ "ORDER BY upper(t.item_code), upper(t.organization_code_rec), t.r_date";

		try {
			pstmt = conn.prepareStatement(sqlTxt);
			rSet = pstmt.executeQuery();
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return rSet;
	}

	public void writeDataToExcel(ResultSet rSet, String filePath, String fileName) {
		String excelFileName = filePath + "\\" + fileName;
		String[] cellSet = { "item_code", "organizationCode", "subinventoryCode", "inventoryLocation", "quantity",
				"recQuantity", "rDate" };
		int rowCount = 0;
		try {
			FileOutputStream excelFile = new FileOutputStream(excelFileName);
			// 建立一个Excel
			Workbook book = new HSSFWorkbook();
			// 在对应的Excel中建立一个分表
			Sheet invData = (Sheet) book.createSheet("Inventory_Data");

			while (rSet.next()) {
				// 设置相应的行（初始从0开始）
				Row row = invData.createRow(rowCount);
				for (int i = 0; i < cellSet.length; i++) {
					Cell cell = row.createCell(i);
					cell.setCellValue(rSet.getString(cellSet[i]));
				}

				rowCount = rowCount + 1;
			}

			// 保存到计算机相应路径
			book.write(excelFile);
			excelFile.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
