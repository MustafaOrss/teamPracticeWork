package practiceTeamWork.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_locate {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementiListesi = driver.findElements(By.className("panel-title"));
        //4- Category bolumunde 3 element oldugunu test edin
        int expectedElementListesi = 3;
        int actual = categoryElementiListesi.size();
        if(expectedElementListesi==actual){
            System.out.println("test PASSED.");
        }
        else {
            System.out.println("test FAILED.");
        }

        //5- Category isimlerini yazdirin

        for (WebElement eachElement:  categoryElementiListesi

                ) {
            System.out.println(eachElement.getText());
        }

        //6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
