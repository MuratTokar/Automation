package day013_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.Set;

public class Windows extends BaseTest {
    {
        driver = Driver.getDriver(); // her test yazildiginda bunlar calisacak tekrar tekrar yazmayiz


    }

    /*
     * bir windowa switch etmek icin o window un name si yada handlei(numarasi sabit olan) gerekir*/
    String url = "https://www.selenium.dev/selenium/web/rc/tests/html/test_select_window.html";
    By win1 = By.xpath("//button[@id='popupPage']");
    By win2 = By.cssSelector("button[id='popupAnonymous']");
    By win3 = By.id("popupBlank");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));

    @Test
    public void test_getWindowHandle() {
        String url = "https://google.com";
        driver.get(url);
        System.out.println(driver.getWindowHandle());// (11687F53A1D07F7830C1649FD01DD8AB)acilan sayfanin handle sini yazdiriyorum.
        // her window icin ayri ayri verir.getWindow string return eder
        driver.quit();

    }

    @Test
    public void test_getWindowHandles() { // birden cok pencere icin

        driver.get(url);


        //   WebElement element=driver.findElement(win1);
        //  element.click();
        click(win1); // bu sekilde olur.ikinci bir pencere acildi
        // driver.getWindowHandles() bu set string return eder
        Set<String> wins = driver.getWindowHandles();//getWindowHandles acik olan tum windowlarin handle lerini set<String> olarak veririr
        System.out.println(wins);//[4D85DCD26831D731527D42A2ED411CD8, 2D13B386D7CBDD5CF190527EE0BB3B6D] .set ayni degerden iki tane almaz
        driver.quit();


    }

    @Test
    public void test_switchToWin() { // birden cok pencere icin
        driver.get(url);
        String mainHandle = driver.getWindowHandle();// ikinci windova gecmek icin suanki windowu string eattim
        String childWin = "";
        //   WebElement element=driver.findElement(win1);
        //  element.click();
        click(win1); // bu sekilde olur.ikinci bir pencere acildi
        // driver.getWindowHandles() bu set string return eder
        Set<String> wins = driver.getWindowHandles();
        System.out.println(wins);//[4D85DCD26831D731527D42A2ED411CD8, 2D13B386D7CBDD5CF190527EE0BB3B6D] .set ayni degerden iki tane almaz

        for (String windowHandle : wins) {
            if (!windowHandle.equals(mainHandle)) {//ilk tiklamadan sonra acilan window agitmak icin for kullandik
                childWin = windowHandle;
                break;

            }
        }
        driver.switchTo().window(childWin);// yani ikinci sayfaya gonderdik
        driver.findElement(By.cssSelector("input[id='closePage2']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='closePage2']")));


        driver.quit();

    }

    @Test
    public void test_switchToWin2() {
        By win3but = By.id("closePage2");
        String aktifHand = driver.getWindowHandle();
        String childd = "";
        driver.get(url); //sayfaya gidildi
        driver.manage().window().maximize();
        click(win3);//win3 tiklandi
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));//win sayisinin 2 olmasini bekledik
        System.out.println(aktifHand);//active window un handle sini aldik

        Set<String> winss = driver.getWindowHandles();
        for (String handless : winss) {
            if (!handless.equals(aktifHand)) {
                childd = handless;
                break;
            }
        }
        driver.switchTo().window(childd);// alt window a driver gonderdik
        sleep(3000);
        click(win3but);
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));// ikincinin kapandigini assert ettik
        driver.switchTo().window(aktifHand); //aktif window ageri dondu
        wait.until(ExpectedConditions.visibilityOfElementLocated(win1)); // windowa geri donuldugunu assert ettik

        driver.quit();
    }


    // yada boyle metot olustururuz
    public String getNewWinHandle(String activeWindHandle) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (windowHandle.equals(activeWindHandle)) {
                return windowHandle;
            }

        }
        return null;
    }

    @Test
    public void test_switchToWin3() {
        String url1 = "https://google.com";
        String url2 = "https://yahoo.com";
        String url3 = "https://demoqa.com";
        // google i main win de ac
        driver.get(url1);
        String googleHandle = driver.getWindowHandle();
        // yahoo yu new TAB da acar ve o sayfaya switch eder
        driver.switchTo().newWindow(WindowType.TAB).get(url2);
        sleep(2000);
        // close aktif window hangisi ise onu  kapatir
        driver.close();
        driver.switchTo().window(googleHandle);
        sleep(3000);
        //adresi yeni window da acar
        driver.switchTo().newWindow(WindowType.WINDOW).get(url3);
        sleep(3000);
        driver.close();
        driver.switchTo().window(googleHandle);
        driver.findElement(By.id("L2AGlb"));
        sleep(3000);
        driver.quit();
    }
}
