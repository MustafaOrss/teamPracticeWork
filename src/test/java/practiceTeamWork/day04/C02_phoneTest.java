package practiceTeamWork.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class C02_phoneTest {
    public static void main(String[] args) throws InterruptedException {

        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- Sayfadaki tum basliklari yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        System.out.println(sonuc.getText());

        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();

        for (WebElement title : driver.findElements(By.tagName("h1"))) {
            System.out.println(title.getText());
        }
        for (WebElement title2 : driver.findElements(By.tagName("h2"))) {
            System.out.println(title2.getText());
        }
        for (WebElement title3 : driver.findElements(By.tagName("h3"))) {
            System.out.println(title3.getText());
        }
        for (WebElement title4 : driver.findElements(By.tagName("h4"))) {
            System.out.println(title4.getText());
        }
        for (WebElement title5 : driver.findElements(By.tagName("h5"))) {
            System.out.println(title5.getText());
        }
        for (WebElement title6 : driver.findElements(By.tagName("h6"))) {
            System.out.println(title6.getText());
        }


        Thread.sleep(2000);
        driver.close();
    }
}
