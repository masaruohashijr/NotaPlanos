package br.gov.previc.cgti.notaautomatica;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ETLMain {

	public static void main(String[] args) {
		File myFile = new File("Rating - Notas automáticas (dezembro de 2021).xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(myFile);
			XSSFWorkbook wb = new XSSFWorkbook (fis);
			XSSFSheet sheet = wb.getSheetAt(12);
			System.out.println(sheet.getSheetName());
			int numberOfRows = sheet.getPhysicalNumberOfRows();
			for (int r = 2; r < numberOfRows; r++) {
				XSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}

				// CNPB
				XSSFCell  cell = row.getCell(0);
				double cellValue = cell.getNumericCellValue();
				BigDecimal bd = new BigDecimal(cellValue);
				String cnpb = bd.toPlainString();
				System.out.println("CNPB: "+cnpb);
				// SOLVENCIA
				cell = row.getCell(5);
				String retorno = recuperaValorCelular(cell);
				System.out.println("SOLVENCIA: "+retorno);
				// ATIVOS
				cell = row.getCell(8);
				retorno = recuperaValorCelular(cell);
				System.out.println("ATIVOS: "+retorno);
				// ATUARIAL
				cell = row.getCell(12);
				retorno = recuperaValorCelular(cell);
				System.out.println("ATUARIAL: "+retorno);
				// RESULTADO
				cell = row.getCell(14);
				retorno = recuperaValorCelular(cell);
				System.out.println("RESULTADO: "+retorno);
				// EFICIENCIA OPERACIONAL 
				cell = row.getCell(18);
				retorno = recuperaValorCelular(cell);
				System.out.println("EFICIENCIA OPERACIONAL: "+retorno);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String recuperaValorCelular(XSSFCell cell) {
		String retorno = "";
		switch (cell.getCellType()) {
		case BOOLEAN:
			retorno = String.valueOf(cell.getBooleanCellValue());
		case NUMERIC:
			double d = cell.getNumericCellValue();
			BigDecimal b = new BigDecimal(d);
			retorno = b.toPlainString();
		case STRING:
			retorno = cell.getStringCellValue();
		case FORMULA:
			switch (cell.getCachedFormulaResultType()) {
			case BOOLEAN:
				retorno = String.valueOf(cell.getBooleanCellValue());
				break;
			case NUMERIC:
				d = cell.getNumericCellValue();
				b = new BigDecimal(d);
				BigDecimal big = b.setScale(4, RoundingMode.HALF_EVEN);				
				retorno = big.toString();
				break;
			case STRING:
				retorno = cell.getStringCellValue();
				break;
			case ERROR:
				retorno = "NÃO DISPONÍVEL";
				break;
			default:
				break;
			}
			break;
		default:
			retorno = "DEFAULT";
		}
		return retorno;
	}

}
