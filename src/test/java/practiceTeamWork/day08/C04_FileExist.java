package practiceTeamWork.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        //-> https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //-> logo.png dosyasını indirelim
        WebElement logoPngElementi = driver.findElement(By.xpath("//*[text()='logo.png']"));
        logoPngElementi.click();

        Thread.sleep(2000);
        //-> Dosyanın başarıyla indirilip indirilmediğini test edelim
    /*
        String dosyaYolu = "C:/Users/MustafaOrs/Downloads/logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
*/
  /*      System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
  */
        String degisenKisim = (System.getProperty("user.home"));
        String ayniKisim = "/Downloads/logo.png";

        String dinamikYol = degisenKisim + ayniKisim;
        Assert.assertTrue(Files.exists(Paths.get(dinamikYol)));




    }

}
