package practiceTeamWork.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GetMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelin. https://www.amazon.com/
            driver.get("https://www.amazon.com/");
        //Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        //Sayfa basliginin "Amazon" icerdigini test edin

        String expected = "Amazon";
        String act = driver.getTitle();

        if(act.contains(expected)){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("Test FAILED.");
        }

        //Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        //Sayfa url'inin "amazon" icerdigini test edin.
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains(expected)){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("Test FAILED.");
        }
        //Sayfa handle degerini yazdirin.
        System.out.println(driver.getWindowHandles());
        //Sayfa HTML kodlarinda "alisveris" kelimesi gectigini test edin
        expected = "alışveriş";
        String code = driver.getPageSource();
        if(code.contains(expected)){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("Test FAILED.");
        }
        //Sayfayi kapatin.

        Thread.sleep(3000);
        driver.close();

    }
}
