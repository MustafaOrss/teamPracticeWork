package practiceTeamWork.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
        //adresine gidin
        //2 ) Berlin’i 3 farkli relative locator ile locate edin
        //3 ) Relative locator’larin dogru calistigini test edin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement berlin = driver.findElement(By.id("pid7_thumb"));
        WebElement boston = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(berlin));

        if(boston.getAttribute("id").equals("pid6_thumb")){
            System.out.println("Boston Locate Testi PASSED");
        }
        else {
            System.out.println("Boston locate Testi FAILED");
        }

        WebElement mountie = driver.findElement(By.id("pid10_thumb"));
        WebElement boston2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(mountie));

        if(boston2.getAttribute("id").equals("pid6_thumb")){
            System.out.println("Boston2 Locate Testi PASSED");
        }
        else {
            System.out.println("Boston2 Locate Testi FAILED");
        }

        WebElement london = driver.findElement(By.id("pid5_thumb"));
        WebElement boston3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(london));

        if(boston3.getAttribute("id").equals("pid6_thumb")){
            System.out.println("Boston2 Locate Testi PASSED");
        }
        else {
            System.out.println("Boston2 Locate Testi PASSED");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
