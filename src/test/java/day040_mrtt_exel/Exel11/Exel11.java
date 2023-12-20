package day040_mrtt_exel.Exel11;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exel11 {
    @Test
    public void readExcel_xls() throws IOException {

        // okunacak excel dosya yolu
        String excell = "src/test/java/utils/exel1.xlsx";

        //excel dosyasi FileImputStrean  ile okunur
        FileInputStream inputStream = new FileInputStream(excell);

        //excel icin bir workbook create ediliyor
        Workbook workbook = WorkbookFactory.create(inputStream);

        //workbooktaki sayfa secilir
        //dike olan Row(satir) yatay olan  Cell (hücre)
        Sheet sheet1 = workbook.getSheet("Tabelle");

        // burda row(suton) belirlenir
        Row row = sheet1.getRow(0);
        // cell(satir ) secilir
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());
        inputStream.close();


    }

    @Test
    public void readExcel_xlxs() throws IOException {

        // okunacak excel dosya yolu
        String excell = "src/test/java/utils/users.xlsx";


        //excel dosyasi FileImputStrean  ile okunur
        FileInputStream inputStream = new FileInputStream(excell);

        //excel icin bir workbook create ediliyor
        Workbook workbook = WorkbookFactory.create(inputStream);//wordbook sayfanin tamami demektir

        //workbooktaki sayfa secilir
        //dike olan Row(satir) yatay olan  Cell (hücre)
        Sheet sheet1 = workbook.getSheet("data");

        // burda row(satir) belirlenir
        Row row = sheet1.getRow(0);
        // cell(hücre ) secilir
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());
        inputStream.close();

    }

    @Test
    public void readExcel_xlxs1() throws IOException {
        String excell = "src/test/java/utils/users.xlsx";

        FileInputStream inputStream = new FileInputStream(excell); // yani excel sayfasini tikla

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheet("data"); // sayfayi sectik

        int rownum = sheet1.getPhysicalNumberOfRows(); // row sayilarini   aldik yani suton

        for (int i = 0; i < rownum; i++) {
            Row row = sheet1.getRow(i);

            int cols = row.getPhysicalNumberOfCells();//cell yani satirlari aldik

            for (int j = 0; j < cols; j++) {
                System.out.print(row.getCell(j) + "\t");
            }
            System.out.println();
        }
        inputStream.close();
    }

    @Test
    public void getDataFromExcelAslist() throws IOException {
        String excel = "src/test/java/utils/users.xlsx";
        //System.out.println("getdata(excel) = " + getdata(excel));
        for (List<String> row : getdata(excel)) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();// enter e bastik

        }
    }


    public List<List<String>> getdata(String path) throws IOException {
        List<List<String>> data = new ArrayList<>();
        FileInputStream stream = new FileInputStream(path); //sayfa tiklandi
        Workbook workbook = WorkbookFactory.create(stream);
        Sheet sheet2 = workbook.getSheetAt(0);
        int rownum = sheet2.getPhysicalNumberOfRows();
        for (int i = 0; i < rownum; i++) {
            Row row = sheet2.getRow(i);
            int cols = row.getPhysicalNumberOfCells();
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                rowData.add(cell.toString());

            }

            data.add(rowData);

        }

        return data;
    }

    @Test
    public void testWritrToExcel() throws IOException {

        String excell = "src/test/java/utils/users.xlsx";
        String excell1 = "src/test/java/utils/users.xlsx";

        FileInputStream inputStream = new FileInputStream(excell);

        Workbook workbook = WorkbookFactory.create(inputStream);//wordbook sayfanin tamami demektir

        Sheet sheet1 = workbook.getSheet("data");

        int rownum = sheet1.getPhysicalNumberOfRows();

        Row row = sheet1.createRow(rownum);
        Cell cell0=row.createCell(0);
        cell0.setCellValue(101);
        inputStream.close();

        FileOutputStream outputStream=new FileOutputStream(excell);
        workbook.write(outputStream);
        outputStream.close();


    }
    @Test
    //sifirdan excel aciyoruz
    public void createExcelFile() throws IOException {
      //xlsx icin XSSF....,xls icin  HSSF
        XSSFWorkbook workbook=new XSSFWorkbook();  //excel olustu
        XSSFSheet sheet= workbook.createSheet("Sheet1"); // icine excel sayfasi olustu

        Row row =sheet.createRow(0);// suton olustu.row a deger atanmaz.row icinde satira deger atanir
        Cell cello= row.createCell(0);// satir olustu
        cello.setCellValue(10);//satira deger atadik

        row.createCell(1).setCellValue(20);
        String file="src/test/java/utils/exel1.xlsx";
        FileOutputStream outputStream=new FileOutputStream(file);// kaydedilecek yeri belirledik
        workbook.write(outputStream);// bununla kaytettik
        outputStream.close();
    }
}
