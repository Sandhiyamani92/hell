package com.sts.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHandler
{
	
	public ExcelHandler()
	{
	
	}
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public String[][] tabArray;
	public int columnIndex;
	public int rowIndex;
	public int numCols;
	public int numRows;
	public static String globalFilePath;



	public ExcelHandler(String PathToExcel,String Sheet,int col,int row)  throws Exception
	{   

		tabArray = null;
		columnIndex = col;
		rowIndex = row;
		
		//IOUtils.setByteArrayMaxOverride(126000000);
		//String cellValue;
		try
		{

			DataFormatter dataFormatter = new DataFormatter();
			FileInputStream ExcelFile = new FileInputStream(PathToExcel);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(Sheet);

			numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			numRows =  ExcelWSheet.getLastRowNum()+1;
	
			//System.out.println("Startin to ini Excel" + " NUmber of Rows in the Excel: " + numRows + " Number of columns in the excel: " + numCols);
			
			tabArray = new String[numRows][numCols];
			
			dataFormatter.setUseCachedValuesForFormulaCells(true);
			
			//Populate the object with the correct values
			for(int r = 0; r<numRows; r++)
			{
				for(int c = 0; c< numCols; c++)
				{
					tabArray[r][c] = dataFormatter.formatCellValue(ExcelWSheet.getRow(r).getCell(c));
					//tabArray[r][c] = ExcelWSheet.getRow(r).getCell(c).getRawValue();

					//System.out.println(r + ") " + tabArray[r][c].toString());
				} 
			}
			
			ExcelWBook.close();
			

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");
			ExcelWBook.close();
			e.printStackTrace();

		}
		
		catch (Exception e)

		{

			e.printStackTrace();
			System.out.println("Something went wrong");
			ExcelWBook.close();
		

		}
		System.out.println("Finished to ini Excel");



	}


	public String getCellValue(String rowName,String colName)
	{
		

		String cellValue;
		int rowIWant = 0;
		int colIWant = 0;
		//System.out.println(numCols + " " + numRows + " values Maintained and ready to use");
		for (int i = 0 ; i < numCols ; i++)
		{
			//System.out.println("Number of columns: " + numCols);
			//System.out.println("Requested Value: " + colName);

			if(tabArray[rowIndex][i].toString().equalsIgnoreCase(colName)==true)
			{
				colIWant = i;
			}
		}

		for (int i = 0 ; i < numRows ; i++)
		{
			

			if(tabArray[i][columnIndex].toString().equalsIgnoreCase(rowName)==true)
			{
				rowIWant = i;
			}
		}



		cellValue = tabArray[rowIWant][colIWant].toString();
		System.out.println(cellValue);



		return cellValue;
	}
	

	public String getCellValueSpecific(int rowIncrement,String colName)
	{
		

		String cellValue;
		int rowIWant = 0;
		int colIWant = 0;
		//System.out.println(numCols + " " + numRows + " values Maintained and ready to use");
		for (int i = 0 ; i < numCols ; i++)
		{
			//System.out.println("Number of columns: " + numCols);
			//System.out.println("Requested Value: " + colName);

			
			if(tabArray[rowIndex][i].toString().equalsIgnoreCase(colName)==true)
			{
				colIWant = i;
			}
		}

		
		rowIWant = rowIncrement;
		cellValue = tabArray[rowIWant][colIWant].toString().trim();
		System.out.println(cellValue);



		return cellValue;
	}
	public String getPolicyValue()
	{
		
		String cellValue;
		int rowIWant = 0;
		int colIWant = 0;
		//System.out.println(numCols + " " + numRows + " values Maintained and ready to use");
		cellValue = tabArray[1][0].toString();
		System.out.println("Policy Number is: " + cellValue);
		
		
		
		return cellValue;
	}

	public static void setExcelFile(String Path,String SheetName) throws Exception 
	{


		try 
		{

			// Open the Excel file
			
			globalFilePath = Path;

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} 

		catch (Exception e)
		{

			throw (e);

		}

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, String Attribute, String Value)  throws Exception

	{   

		String[][] tabArray = null;

		try
		{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			int numRows =  ExcelWSheet.getLastRowNum()+1;
			int attributeCol = 0;
			int valueRow = 0;
			tabArray = new String[1][numCols];

			//Determine the column for the attribute name
			for(int i = 0; i< numCols; i++)
			{
				if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(Attribute))
				{
					attributeCol = i;
					break;

				}
			}

			//Determine the row that has the value
			for(int j = 0; j< numRows; j++)
			{
				if(ExcelWSheet.getRow(j).getCell(attributeCol).getStringCellValue().equalsIgnoreCase(Value))
				{
					valueRow = j;
					break;
				}
			}

			//Populate the object with the correct values
			for(int c = 0; c< numCols; c++)
			{
				tabArray[0][c] = ExcelWSheet.getRow(valueRow).getCell(c).getStringCellValue();
				System.out.println("The column name: " + tabArray.toString());
			}



		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	//Get all entries besides the provides value
	public static Object[][] getTableArrayAllBesides(String FilePath, String SheetName, String Attribute, String Value)  throws Exception

	{   

		String[][] tabArray = null;

		try
		{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			int numRows =  ExcelWSheet.getLastRowNum()+1;
			int attributeCol = 0;
			int valueRow = 0;


			//Determine the column for the attribute name
			for(int i = 0; i< numCols; i++)
			{
				if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(Attribute))
				{
					attributeCol = i;
					break;

				}
			}

			tabArray = new String[numRows-2][numCols];
			int counter = 0;
			//Determine the row that has the value
			for(int j = 1; j< numRows; j++)
			{
				if(ExcelWSheet.getRow(j).getCell(attributeCol).getStringCellValue().equalsIgnoreCase(Value)==false)
				{
					//Populate the object with the correct values
					for(int c = 0; c< numCols; c++)
					{
						tabArray[counter][c] = ExcelWSheet.getRow(j).getCell(c).getStringCellValue();

					}

				}

				else
				{
					counter --;
				}
				counter++;

			}





		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	//Getting all of the user data from Excel 
	public static Object[][] getTableArray(String FilePath, String SheetName)  throws Exception

	{   

		String[][] tabArray = null;

		try
		{
			DataFormatter dataFormatter = new DataFormatter();
			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			int numRows =  ExcelWSheet.getLastRowNum()+1;

			int attributeCol = 0;
			int valueRow = 0;
			tabArray = new String[numRows][numCols];


			//Populate the object with the correct values
			for(int r = 1; r<numRows; r++)
			{
				for(int c = 0; c< numCols; c++)
				{
					tabArray[r-1][c] = dataFormatter.formatCellValue(ExcelWSheet.getRow(r).getCell(c));
					System.out.println(dataFormatter.formatCellValue(ExcelWSheet.getRow(r).getCell(c)));

				} 
				
			}




		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	//Delete entire last Row
	public static void deleteLastRow(String FilePath, String SheetName)  throws Exception

	{   

		try
		{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			// int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			int numRows =  ExcelWSheet.getLastRowNum();


			ExcelWSheet.removeRow(ExcelWSheet.getRow(numRows));
			ExcelWBook.write(new FileOutputStream(FilePath));
			ExcelWBook.close();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}

	//Insert last Row
	public static void insertRow(String FilePath, String SheetName,String Account, String AccountType, String isGoalCompleted, String Friends)  throws Exception

	{   

		try
		{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			//int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			int numRows =  ExcelWSheet.getLastRowNum()+1;

			ExcelWSheet.createRow(numRows);

			for(int i=0;i<4;i++)
			{
				ExcelWSheet.getRow(numRows).createCell(i);
			}
			ExcelWSheet.getRow(numRows).getCell(0).setCellValue(Account);
			ExcelWSheet.getRow(numRows).getCell(1).setCellValue(AccountType);
			ExcelWSheet.getRow(numRows).getCell(2).setCellValue(isGoalCompleted);
			ExcelWSheet.getRow(numRows).getCell(3).setCellValue(Friends);

			ExcelWBook.write(new FileOutputStream(FilePath));
			ExcelWBook.close();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}


	//Insert last Row
	public static void insertPolicy(int Row, int Col, String Policy)  throws Exception

	{   

		try
		{


			ExcelWSheet.getRow(Row).createCell(Col);
            
            ExcelWSheet.getRow(Row).createCell(Col).setCellValue(Policy);

			ExcelWBook.write(new FileOutputStream(globalFilePath));
			//ExcelWBook.close();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}
	
	
	//Insert last Row
		public static void closeBook()  throws Exception

		{   

			try
			{

				ExcelWBook.close();

			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}


		}


		



}
