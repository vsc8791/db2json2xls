package com.darkhorse.db2json2xls;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.codehaus.jackson.map.ObjectMapper;

import com.darkhorse.db2json2xls.pojo.MyPojo;



public class WriteToExcel {

	public static void main(String[] args) {
		try {
			//ProductModel pmodel = new ProductModel();
			ObjectMapper mapper=new ObjectMapper();
			MyPojo []myData = mapper.readValue(new File("d://db2json.json"), MyPojo[].class);
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("List Products");
			// Create Heading

			HSSFRow rowHeading = sheet.createRow(0);
			rowHeading.createCell(0).setCellValue("User ID");
			rowHeading.createCell(1).setCellValue("Name");
			rowHeading.createCell(2).setCellValue("Date of Birth");
			rowHeading.createCell(3).setCellValue("Email");
			rowHeading.createCell(4).setCellValue("Phone Number");
			//rowHeading.createCell(5).setCellValue("Sub Total");

			for (int i = 0; i < 5; i++) {

				HSSFCellStyle stylerowHeading = workbook.createCellStyle();
				HSSFFont font = workbook.createFont();
				font.getBoldweight();
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setFontHeightInPoints((short) 11);
				stylerowHeading.setFont(font);
				stylerowHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
				rowHeading.getCell(i).setCellStyle(stylerowHeading);

			}

			
			int r=1;
			for(int k=0;k<myData.length;k++) 
			{
				Row row=sheet.createRow(r);
				
				//User Id Column
				Cell cellId=row.createCell(0);
				cellId.setCellValue(myData[k].getUserid());
				// Name
				Cell cellName=row.createCell(1);
				cellName.setCellValue(myData[k].getName());
				//Creation Date 
				Cell cellCreationDate=row.createCell(2);
				cellCreationDate.setCellValue(myData[k].getDob());
				CellStyle styleCreationDate=workbook.createCellStyle();
				HSSFDataFormat df=workbook.createDataFormat();
				styleCreationDate.setDataFormat(df.getFormat("mm/dd/yyyy"));
				cellCreationDate.setCellStyle(styleCreationDate);
				
				//Email
				Cell cellPrice=row.createCell(3);
				cellPrice.setCellValue(myData[k].getEmail());
			//	CellStyle stylePrice=workbook.createCellStyle();
				//HSSFDataFormat cf=workbook.createDataFormat();
			//	stylePrice.setDataFormat(cf.getFormat("₹##,##0.00"));
			//	cellPrice.setCellStyle(stylePrice);
				
				//Phone Number Column
				
				Cell cellQuantity=row.createCell(4);
				cellQuantity.setCellValue(myData[k].getPhoneNo());
				
//				//Sub Total Column
//				Cell cellSubTotal=row.createCell(5);
//				cellSubTotal.setCellValue(p.getQuantity()*p.getPrice());
//				CellStyle styleSubTotal=workbook.createCellStyle();
//				HSSFDataFormat sdf =workbook.createDataFormat();
//				styleSubTotal.setDataFormat(sdf.getFormat("₹##,##0.00"));
//				cellSubTotal.setCellStyle(styleSubTotal);
//				//Total Column
//				Row rowTotal=sheet.createRow(pmodel.findAll().size()+1);
//				Cell cellTextTotal=rowTotal.createCell(0);
//				cellTextTotal.setCellValue("Total");
//			//	@SuppressWarnings("deprecation")
//			//	CellRangeAddress region=CellRangeAddress.valueOf("A5:E5");
//			//    sheet.addMergedRegion(region);
//				CellStyle styleTotal=workbook.createCellStyle();
//				HSSFFont fontTextTotal=workbook.createFont();
//				fontTextTotal.setBold(true);
//                fontTextTotal.setFontHeightInPoints((short)11);
//                fontTextTotal.setColor(HSSFColor.GREEN.index);
//                
//                styleTotal.setFont(fontTextTotal);
//                styleTotal.setVerticalAlignment(CellStyle.ALIGN_RIGHT);
//                cellTextTotal.setCellStyle(styleTotal);
//                
//                //Total Value Column
//                
//                Cell cellTotalValue =rowTotal.createCell(5);
//                cellTotalValue.setCellFormula("sum(F2:F5)");
//                HSSFDataFormat dfTotalValue =workbook.createDataFormat();
//                CellStyle styleTotalValue=workbook.createCellStyle();
//                styleTotalValue.setDataFormat(dfTotalValue.getFormat("₹##,##0.00"));
//                cellTotalValue.setCellStyle(styleTotalValue);
                
                
				//Iterating rows				
				r++;
			}
			// Autofit
						for (int i = 0; i < 5; i++) {
							sheet.autoSizeColumn(i);
						}
			

			// Save to Excel File
			FileOutputStream out = new FileOutputStream(new File("D:\\json2xls.xls"));
			workbook.write(out);
			out.close();
			workbook.writeProtectWorkbook("hello", "hello");
			System.out.println("Excel Written SuccessFully...");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}


	}

}
