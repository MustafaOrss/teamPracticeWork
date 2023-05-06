package practiceTeamWork.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_LinkTest {
    public static void main(String[] args) throws InterruptedException {


        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.

        List<WebElement> listdekiLinkler = driver.findElements(By.tagName("a"));

        int expectedListedekiLinkler = 147;
        int actualLinkler = listdekiLinkler.size();

        if(expectedListedekiLinkler==actualLinkler){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("test FAILED.");
        }
        //4- Products linkine tiklayin

        driver.findElement(By.partialLinkText(" Products")).click();

        //5- special offer yazisinin gorundugunu test edin

        WebElement specialoffer = driver.findElement(By.id("sale_image"));

        if(specialoffer.isDisplayed()){
            System.out.println("Test PASSED");
        }
        else {
            System.out.println("Test FAILED");
        }

        //6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();

    }
}
