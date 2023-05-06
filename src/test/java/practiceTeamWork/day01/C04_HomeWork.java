package practiceTeamWork.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HomeWork {
    public static void main(String[] args) throws InterruptedException {

        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        //yazdirin.
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //“actual” URL’i yazdirin.

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com/");

        System.out.println("Basligi : " + driver.getTitle());
        String expectedIcerik = "facebook";
        String actualTittle = driver.getTitle();

        if (actualTittle.contains(expectedIcerik)) {
            System.out.println("Tittle facebook iceriyor test PASSED");
        } else {
            System.out.println("Dogru baslik : " + driver.getTitle());
        }

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)) {
            System.out.println("URL facebook iceriyor test PASSED");
        } else {
            System.out.println("Gecerli URL : " + actualUrl);
        }

        //4.https://www.walmart.com/ sayfasina gidin.
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        //6. Tekrar “facebook” sayfasina donun
        //7. Sayfayi yenileyin
        //8. Sayfayi tam sayfa (maximize) yapin
        //9.Browser’i kapatin

        driver.get("https://www.walmart.com/");
        expectedIcerik = "Walmart.com";

        if (actualTittle.contains(expectedIcerik)) {
            System.out.println("Tittle walmart.com iceriyor test PASSED");
        } else {
            System.out.println("Tittle walmart.com icermiyor test FAILED : " + driver.getTitle());

        }
        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.close();
    }
}
