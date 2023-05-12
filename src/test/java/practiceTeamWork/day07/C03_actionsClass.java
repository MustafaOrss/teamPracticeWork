package practiceTeamWork.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_actionsClass extends TestBase {


    @Test
    public void test01() {


        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualIcerik = driver.switchTo().alert().getText();
        String expectedIcerik = "You selected a context menu";

        Assert.assertEquals(expectedIcerik,actualIcerik);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String ilkSayfaWHD = driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> WHDegerleri = driver.getWindowHandles();
        String ikinciWHD = "";

        for (String eachWHDegerleri: WHDegerleri
        ) {
            if(!eachWHDegerleri.equals(ilkSayfaWHD)){
                ikinciWHD = eachWHDegerleri;

            }

        }
        driver.switchTo().window(ikinciWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        expectedIcerik = "Elemental Selenium";
        actualIcerik = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedIcerik,actualIcerik);

    }
}