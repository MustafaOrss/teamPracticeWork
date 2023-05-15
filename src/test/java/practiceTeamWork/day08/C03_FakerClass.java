package practiceTeamWork.day08;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {

    @Test
      public void test01() throws InterruptedException {


    //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

    //2- Yeni hesap olustur butonuna basalim
    Actions actions = new Actions(driver);
    WebElement yeniHesapOlusturButonu = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        yeniHesapOlusturButonu.click();
        Faker fakerClass = new Faker();
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

        String email = fakerClass.internet().emailAddress();
    WebElement isimKutucugu = driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(isimKutucugu)
            .sendKeys(fakerClass.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakerClass.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerClass.internet().password())
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