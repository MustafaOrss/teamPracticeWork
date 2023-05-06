package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ManageWindowSet {
    public static void main(String[] args) {
        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        //8. Sayfayi kapatin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        System.out.println("Baslangic konum: "+driver.manage().window().getPosition());
        System.out.println("Baslangic boyut: "+driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(100,100));

        System.out.println("Istenilen konum: "+driver.manage().window().getPosition());
        System.out.println("Istenilen boyut: "+driver.manage().window().getSize());

        driver.close();

    }
}