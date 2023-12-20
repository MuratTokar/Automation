package day041_mrtt_xcelolusturma;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcellOlusturma {
    public ExcellOlusturma() throws FileNotFoundException {
    }

    @Test
    //sifirdan excel aciyoruz
    public void createExcelFile() throws IOException {
        //xlsx icin XSSF....,xls icin  HSSF
        XSSFWorkbook workbook = new XSSFWorkbook();  //Ram da excel olustu
        XSSFSheet sheet1 = workbook.createSheet("Sayfa1"); //sheet1 adinda excel icinde  excel sayfasi olustu

        Row row1 = sheet1.createRow(0);// acilan sheet sayfasinin icine suton olustu.row a deger atanmaz.row icinde satira deger atanir

        for (int i = 0; i < 10; i++) {
            row1.createCell(i).setCellValue(i + 1);// sifirdan baslayacagi icin  1 den baslatmak icin +1 yaptim
            // yani 1.sutundan soldan saga  dogru 1 den 10 a kadar yazacak

        }
        XSSFSheet sheet2 = workbook.createSheet("Sayfa2");
        for (int i = 0; i < 10; i++) {
            Row row = sheet2.createRow(i);
            row.createCell(0).setCellValue(i + 1);// yukaridan asagiya 1 den 10 a kadar yazdi
        }

        String file = "src/test/java/utils/exel3.xlsx";// kaydedilecek yeri belirledik
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);// bununla kaytettik
        outputStream.close();
    }

    @Test
    public void createExcel3() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();// ram da excel olustu
        XSSFSheet sheet3 = workbook.createSheet("sayfa1");//excel de bir tane sayfa olustu
        for (int i = 0; i < 10; i++) {
            Row row1 = sheet3.createRow(i);
            for (int j = 0; j < 10; j++) {
                row1.createCell(j).setCellValue(i * 10 + j + 1);

            }

        }
        String file = "src/test/java/utils/exel4.xlsx";// kaydedilecek yeri belirledik
        FileOutputStream stream = new FileOutputStream(file);
        workbook.write(stream);
        stream.close();
    }

    @Test
    public void carpimTablosu() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("sayfa1");

        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue(3);
        row.createCell(1).setCellValue("*");
        row.createCell(2).setCellValue(1);
        row.createCell(3).setCellValue("=");
        row.createCell(4).setCellValue(3);


    }



}



