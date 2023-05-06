package practiceTeamWork.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getDriverMethod {

    public class C01_driverGetMethodlari {


        public class C05_driverGetMethodlari {
            public static void main(String[] args) throws InterruptedException {

        /*
1. Yeni bir Class olusturalim.C05_NavigationMethods
2. Youtube ana sayfasina gidelim . https://www.youtube.com/
3. Amazon soyfasina gidelim. https://www.amazon.com/
4. Tekrar YouTube’sayfasina donelim
5. Yeniden Amazon sayfasina gidelim
6. Sayfayi Refresh(yenile) yapalim
7. Sayfayi kapatalim / Tum sayfalari kapataliml
        */

                System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

                driver.get("https://www.youtube.com/");
                Thread.sleep(3000);

                driver.get("https://www.amazon.com/");
                Thread.sleep(3000);

                driver.navigate().back();
                Thread.sleep(3000);

                driver.navigate().forward();
                Thread.sleep(3000);

                driver.navigate().refresh();
                Thread.sleep(3000);

                driver.close();





            }
        }
    }

}

