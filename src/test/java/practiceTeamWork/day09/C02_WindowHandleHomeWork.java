package practiceTeamWork.day09;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandleHomeWork extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //3."Login Portal" a tiklayin
        WebElement loginPortalButonu = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        loginPortalButonu.click();
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //4.Diger window'a gecin
        Set<String> butunSayfarinHandleDegerleri = driver.getWindowHandles();
        String ikinciWindowHandleDegeri = "";

        for (String eachWHDegeri : butunSayfarinHandleDegerleri
        ) {
            if (!eachWHDegeri.equals(ilkSayfaHandleDegeri)) {
                ikinciWindowHandleDegeri = eachWHDegeri;
            }

        }
        driver.switchTo().window(ikinciWindowHandleDegeri);

        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        WebElement usernameButonu = driver.findElement(By.xpath("//input[@id='text']"));
        //6."login" butonuna basin
        actions.click(usernameButonu).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
       String actualIcerik = driver.switchTo().alert().getText();
       String expectedIcerik = "validation failed";
        Assert.assertEquals(expectedIcerik,actualIcerik);
        //8. -> Accept diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleDegeri);
        //10.Ilk sayfaya donuldugunu test edin
        String actualdUrl = driver.getCurrentUrl();
        String expectedUrl = "http://webdriveruniversity.com/";

        Assert.assertEquals(expectedUrl,actualdUrl);


    }
}