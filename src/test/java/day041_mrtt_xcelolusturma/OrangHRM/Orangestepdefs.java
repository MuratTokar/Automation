package day041_mrtt_xcelolusturma.OrangHRM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Orangestepdefs {
    By lusername=By.xpath("//input[@name='username']");
    By lpass=By.xpath("//input[@name='password']");
    By llogin=By.xpath("//button[@type='submit']");
    By lfail=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    By lTrue=By.xpath("//h6[text()='Dashboard']");
WebDriver driver;
WebDriverWait wait;

public Orangestepdefs(){
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    wait=new WebDriverWait(driver, Duration.ofSeconds(10));
}

    @Given("user navigate to{string}")
    public void userNavigateTo(String url) {
        driver.get(url);
    }

    @When("user try to login with data in  the excel file {string}")
    public void userTryToLoginWithDataInTheExcelFile(String file) throws IOException {
        List<List<String>> newdata=data(file);
        for (List<String> row : newdata) {
            String username=row.get(0);
            String password=row.get(1);
            String login=row.get(2);
            sendKeys(lusername,username);
            sendKeys(lpass,password);
            click(llogin);
            if (login.equals("false")){
                assertVisibled(lfail);


            }else assertVisibled(lTrue);
            
        }
    }

    public List<List<String>> data(String file) throws IOException {
        List<List<String>> datas = new ArrayList<>();

        FileInputStream stream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(stream);
        Sheet sheet = workbook.getSheetAt(0);
        int rownums = sheet.getPhysicalNumberOfRows();// sutunlar
        for (int i = 1; i < rownums; i++) {

            List<String> rowlist = new ArrayList<>();// her yeni row a gectiginde sifirlayacak

            Row row = sheet.getRow(i);
            int cellnums = row.getPhysicalNumberOfCells();// satirlar
            for (int j = 1; j < cellnums; j++) {

                rowlist.add(row.getCell(j).toString());
            }
            datas.add(rowlist);

        }
        return datas;

    }
    public void click(By locator){
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
    public void sendKeys(By locator,String key){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(key);


    }
    public void assertVisibled(By locator){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
