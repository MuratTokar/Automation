package day017_mrtt;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {
    // java awt nin robot classi
    //ekrana mudahale edebilir
    //Klavye mouse islemleri yapilabilir
    // sayfadaki elementleri anlamaz

    @Test
    public void robotClass1() throws AWTException {
        // robot class etanimi
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);// ctrl tusuna basar ama KeyRelease yapilmazsa ctrl basili kalir
        robot.keyRelease(KeyEvent.VK_CONTROL); // ctrl realese edildi

        //robot class aktif oldugu yerde islem yapar.Run edince "a" buraya yazildi
        robot.keyPress(KeyEvent.VK_A);



       // ax//asagidaki X i ax olarak buraya yazdi
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('X'));


       write("Guidersoft");// axguidersoft   buraya yazdi

        // stringi char char alip yazdi
    }
    public void write(String str) throws AWTException {
        Robot robot=new Robot();
        for (int i = 0; i <str.length() ; i++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));


        }

    }
}
