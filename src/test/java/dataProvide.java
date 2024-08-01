import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="driveTest")
	
	public void testCaseData(String Greeting, String Communication, String Id)
	 {
		System.out.println(Greeting+Communication+Id);
	 }
	
	
    @DataProvider(name="driveTest")
		
    public Object[][] getdata() throws IOException
    
    {

    	FileInputStream fis = new FileInputStream("C:\\Users\\veereshkumar.s\\Desktop\\demodata1.xlsx");
    	@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet sheet = wb.getSheetAt(0);
    	int rowcount = sheet.getPhysicalNumberOfRows();
    	XSSFRow row =sheet.getRow(0);
    	int coloumncount = row.getLastCellNum();
    	
    	Object data[][]= new Object[rowcount-1][coloumncount];
    	
    	for(int i=0; i<rowcount-1; i++)
    	{

    		row= sheet.getRow(i+1);
    		for(int j=0; j<coloumncount; j++)
    		{
    			XSSFCell cell = row.getCell(j);
    			data[i][j]=formatter.formatCellValue(cell);
    		}  
    	}
    	return data;
    }
	

}
