package practiceTeamWork.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    //1. Yeni bir package olusturalim : day01
    //2. Yeni bir class olusturalim : C03_GetMethods
    //3. Amazon sayfasina gidelim. https://www.amazon.com/
    //4. Sayfa basligini(title) yazdirin
    //5. Sayfa basliginin “Amazon” icerdigini test edin
    //6. Sayfa adresini(url) yazdirin
    //7. Sayfa url’inin “amazon” icerdigini test edin.
    //8. Sayfa handle degerini yazdirin
    //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
    //10. Sayfayi kapatin.

    WebDriver driver = new ChromeDriver();

    public void mahserinAtlilari(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test01(){
        mahserinAtlilari();

        System.out.println(driver.getTitle());
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.close();
    }
        @Test
        public void test02(){

            mahserinAtlilari();
            System.out.println(driver.getCurrentUrl());
            String expectedUrl = "amazon";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedUrl));
            driver.close();
    }
    @Test
    public void test03(){
        mahserinAtlilari();
        System.out.println(driver.getWindowHandle());

        String expectedAlisveris = "shopping";
        String actualAlisveris = driver.getPageSource();
        Assert.assertTrue(actualAlisveris.contains(expectedAlisveris));

        driver.close();
    }
}
