package westpacUtilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.*;
import java.io.*;

public class westpacUtilities {

    //Method to fetch properties from property file
    public static String fetchMyProperties(String req) throws Exception {

        String val;

        FileReader reader = new FileReader("src\\test\\java\\resources\\westpac.properties");
        Properties p = new Properties();
        p.load(reader);
        val = p.getProperty(req);

        return val;// returning the requested value.
    }

    //Method to take snapshot
    public static void takeSnapShot(WebDriver webdriver, String fPath) throws Exception {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File(fPath);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }

    //Method to set excel file
      public static XSSFSheet setExcelFile() throws Exception {

            XSSFSheet ExcelWSheet;
            XSSFWorkbook ExcelWBook;
            XSSFRow Row;
            String Path;
            String SheetName;

            try {
                // Open the Excel file
                Path = fetchMyProperties("spreadsheet_path");
                SheetName= fetchMyProperties("sheet_name");
                FileInputStream ExcelFile = new FileInputStream(Path);

                // Access the required test data sheet
                ExcelWBook = new XSSFWorkbook(ExcelFile);
                ExcelWSheet = ExcelWBook.getSheet(SheetName);

            } catch (Exception e){
                throw (e);
            }
            return ExcelWSheet;
        }
    //Method to retrieve date from spreadsheet
    public static String getCellData(int RowNum, int ColNum) throws Exception{

        XSSFSheet ExcelWSheet;
        XSSFCell Cell;

        try{
            ExcelWSheet = setExcelFile();
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            if(Cell.getCellType().equals(CellType.NUMERIC)){
                int x = (int) Cell.getNumericCellValue();
                String y =  Integer.toString(x);
               return y;

            }else{
                return Cell.getStringCellValue();
            }

        }catch (Exception e){
            return"";

        }

    }

}


