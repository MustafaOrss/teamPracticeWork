package practiceTeamWork.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        Actions actions = new Actions(driver);
        WebElement yeniHesapOlusturButonu = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        yeniHesapOlusturButonu.click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim

        WebElement isimKutucugu = driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(isimKutucugu)
                .sendKeys("Berker")
                .sendKeys(Keys.TAB)
                .sendKeys("Ors")
                .sendKeys(Keys.TAB)
                .sendKeys("abcdef1234@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("abcdef1234@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1996")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        Thread.sleep(2000);

    }
}