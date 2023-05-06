package practiceTeamWork.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_testTekrar {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    //1- bir class olusturun

        //2- https://www.amazon.com/ adresine gidin
          driver.get("https://www.amazon.com/");


        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- Sayfayi "refresh" yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String expectedIcerik = "spend less";
        String actually = driver.getTitle();
        if(actually.contains(expectedIcerik)){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("Test FAILED.");
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']")).click();

        //7- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        //9- Gift card details'den 25 $'i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi = driver.findElement(By.xpath("//div[@id='gc-live-preview-amount-container']"));
        String expectedElement = "25$";

        String actualElement = ucretElementi.getText();
        System.out.println(ucretElementi.getText());
        if(actualElement.equals(expectedElement)){
            System.out.println("Test PASSED.");
        }
        else {
            System.out.println("Test FAILED.");
        }

        //11-Sayfayi kapatin

    Thread.sleep(2000);
    driver.close();

    }
}
