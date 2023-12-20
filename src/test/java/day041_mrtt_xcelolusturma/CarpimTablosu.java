package day041_mrtt_xcelolusturma;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class CarpimTablosu {


    @Test
    public void carpimTablosu() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("sayfa1");
        for (int i = 0; i <10 ; i++) {
            Row row0 = sheet1.createRow(i);
            row0.createCell(0).setCellValue(3);
            row0.createCell(1).setCellValue("x");
            row0.createCell(2).setCellValue(i+1);
            row0.createCell(3).setCellValue("=");
            row0.createCell(4).setCellValue(3*(i+1));

        }
/*
        Row row0 = sheet1.createRow(0);
        row0.createCell(0).setCellValue(3);
        row0.createCell(1).setCellValue("x");
        row0.createCell(2).setCellValue(1);
        row0.createCell(3).setCellValue("=");
        row0.createCell(4).setCellValue(3*1);

        Row row1 = sheet1.createRow(1);
        row1.createCell(0).setCellValue(3);
        row1.createCell(1).setCellValue("x");
        row1.createCell(2).setCellValue(2);
        row1.createCell(3).setCellValue("=");
        row1.createCell(4).setCellValue(3*2);

        Row row2 = sheet1.createRow(2);
        row2.createCell(0).setCellValue(3);
        row2.createCell(1).setCellValue("x");
        row2.createCell(2).setCellValue(3);
        row2.createCell(3).setCellValue("=");
        row2.createCell(4).setCellValue(3*3);

        Row row3 = sheet1.createRow(3);
        row3.createCell(0).setCellValue(3);
        row3.createCell(1).setCellValue("x");
        row3.createCell(2).setCellValue(4);
        row3.createCell(3).setCellValue("=");
        row3.createCell(4).setCellValue(3*4);

        Row row4 = sheet1.createRow(4);
        row4.createCell(0).setCellValue(3);
        row4.createCell(1).setCellValue("x");
        row4.createCell(2).setCellValue(5);
        row4.createCell(3).setCellValue("=");
        row4.createCell(4).setCellValue(3*5);

        Row row5 = sheet1.createRow(5);
        row5.createCell(0).setCellValue(3);
        row5.createCell(1).setCellValue("x");
        row5.createCell(2).setCellValue(6);
        row5.createCell(3).setCellValue("=");
        row5.createCell(4).setCellValue(3*6);

        Row row6 = sheet1.createRow(6);
        row6.createCell(0).setCellValue(3);
        row6.createCell(1).setCellValue("x");
        row6.createCell(2).setCellValue(7);
        row6.createCell(3).setCellValue("=");
        row6.createCell(4).setCellValue(3*7);

        Row row7 = sheet1.createRow(7);
        row7.createCell(0).setCellValue(3);
        row7.createCell(1).setCellValue("x");
        row7.createCell(2).setCellValue(8);
        row7.createCell(3).setCellValue("=");
        row7.createCell(4).setCellValue(3*8);

        Row row8 = sheet1.createRow(8);
        row8.createCell(0).setCellValue(3);
        row8.createCell(1).setCellValue("x");
        row8.createCell(2).setCellValue(9);
        row8.createCell(3).setCellValue("=");
        row8.createCell(4).setCellValue(3*9);

        Row row9= sheet1.createRow(9);
        row9.createCell(0).setCellValue(3);
        row9.createCell(1).setCellValue("x");
        row9.createCell(2).setCellValue(10);
        row9.createCell(3).setCellValue("=");
        row9.createCell(4).setCellValue(3*10);




*/
        String file = "src/test/java/utils/exel5.xlsx";// kaydedilecek yeri belirledik
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);// bununla kaytettik
        outputStream.close();
    }
}
