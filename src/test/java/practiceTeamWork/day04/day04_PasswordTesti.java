package practiceTeamWork.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day04_PasswordTesti {
    public static void main(String[] args) throws InterruptedException {

        //1. “https://www.saucedemo.com” Adresine gidin
        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //6. Add to Cart butonuna basin
        //7. Alisveris sepetine tiklayin
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //9. Sayfayi kapatin


            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            // 1. “https://www.saucedemo.com” Adresine gidin
            driver.get("https://www.saucedemo.com");


            //2. Username kutusuna “standard_user” yazdirin
            WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            username.sendKeys("standard_user");


            //3. Password kutusuna “secret_sauce” yazdirin
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            password.sendKeys("secret_sauce");


            //4. Login tusuna basin
            driver.findElement(By.id("login-button")).click();


            //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
            WebElement ilkUrun = driver.findElement(By.id("item_4_title_link"));
            ilkUrun.click();


            //6. Add to Cart butonuna basin
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


            //7. Alisveris sepetine tiklayin
            driver.findElement(By.className("shopping_cart_badge")).click();


            //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            WebElement sepet = driver.findElement(By.className("inventory_item_name"));


            if (sepet.isDisplayed()) {
                System.out.println("Test PASSED");
            } else {
                System.out.println("Test FAILED");
            }
            //9. Sayfayi kapatin
            Thread.sleep(2000);
            // driver.quit();
        }
    }


