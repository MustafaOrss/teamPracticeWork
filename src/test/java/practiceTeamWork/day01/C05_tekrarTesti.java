package practiceTeamWork.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_tekrarTesti {
    public static void main(String[] args) throws InterruptedException {
        //1. Yeni bir class olusturun (TekrarTesti)
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        Thread.sleep(2000);
        String expectedIcerik = "youtube";
        String actualTittle = driver.getTitle();

        if (actualTittle.contains(expectedIcerik)){
            System.out.println("Tittle PASSED");
        }
        else {
            System.out.println("Tittle FAILED : " + actualTittle);
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedIcerik)){
            System.out.println("URL PASSED");
        }
        else {
            System.out.println("URL FAILED : " + actualURL);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        //5. Youtube sayfasina geri donun

        driver.navigate().back();
        Thread.sleep(2000);
        //6. Sayfayi yenileyin

        driver.navigate().refresh();
        Thread.sleep(2000);

        //7. Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        expectedIcerik = "Amazon";
        if(actualTittle.contains(expectedIcerik)){
            System.out.println("Baslik amazon iceriyor test PASSED : ");
        }
        else {
            System.out.println("Dogru baslik : " + actualTittle);
        }


        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın

        expectedIcerik = "https://www.amazon.com/";
        if(actualURL.contains(expectedIcerik)){
            System.out.println("URL wwww.amazon.com iceriyor test PASSED.");
        }
        else{
            System.out.println("URL www.amazon.com icermiyor dogru URL : " + actualURL);
        }

        //11.Sayfayi kapatin
        driver.close();
    }
}
