package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileReader {
	private Properties po=null;

	public String getDriverPath(BrowserType driverType) {
		String driverPath = null;
		try {
			po=lodPropertyFile();
		
		
		
		switch (driverType) {
		
		case CHROME:
			driverPath = po.getProperty("chromDirverPath");
			break;
		case FIREFOX:
			driverPath = po.getProperty("firfoxDirverPath");
			break;
		case INTERNETEXPLORER:
			driverPath = po.getProperty("ieDirverPath");
			break;
		}
		} catch (ExceptionUtility e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverPath;
	}

	private Properties lodPropertyFile() throws ExceptionUtility {
		try {
			if(po==null) {
				InputStream input = new FileInputStream("C:\\NoBackup\\com.dyafysis.gmail\\resources\\config.properties");
				po = new Properties();
				po.load(input);
			}
			//FileInputStream input = new FileInputStream(new File("C:\\NoBackup\\com.dyafysis.gmail\\resources\\config.properties"));
			return po;

		} catch (FileNotFoundException e) {
			throw new ExceptionUtility(ErrorCodes.FRAMNOTFOUND);
		} catch (IOException e) {
			throw new ExceptionUtility(ErrorCodes.FRAMNOTFOUND);
		}

	}


	public List<String> getScenarioData(String sheetName) {

		List<String> emailList = new ArrayList<String>();
		try {
		
			Sheet datatypeSheet = readExcel(sheetName);

			Iterator<Row> interator = datatypeSheet.iterator();

			while (interator.hasNext()) {
				Row row = interator.next();
				Iterator<Cell> cellInterator = row.cellIterator();
				while (cellInterator.hasNext()) {
					Cell cell = cellInterator.next();
					switch (cell.getCellTypeEnum()) {
					case STRING:
						emailList.add(cell.getStringCellValue());
						break;
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailList;
	}

	private Sheet readExcel(String sheetName) throws IOException {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("Testdata.xlsx");
		//FileInputStream excelFile = new FileInputStream(new File("C:\\EclipseWorkspace\\restassured\\src\\main\\java\\files\\Testdata.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(input);
		Sheet sheet = wb.getSheet(sheetName);
		return sheet;
	}

	
	public TreeMap<String, String> getDataUsingColumnName(String sheetName) {
		TreeMap<String, String> dataMap = new TreeMap<String, String>();
		try {

			Sheet sheet = this.readExcel(sheetName);

			int noOfRow = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 1; i <= noOfRow; i++) {

				Row row = sheet.getRow(i);
				
				for (int j = 1; j < row.getLastCellNum(); j++) {
					dataMap.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataMap;

	}


}
