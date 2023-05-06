package practiceTeamWork.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_test {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

    //2- Add Element butonuna basin
    driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

    //3- Delete butonu'nun gorunur oldugunu test edin
    WebElement deletebutonuGorunuMu = driver.findElement(By.className("added-manually"));

    if(deletebutonuGorunuMu.isDisplayed()){
        System.out.println("Test PASSED.");
    }
    else {
        System.out.println("Test FAILED.");
    }

    //4- Delete tusuna basin
    deletebutonuGorunuMu.click();

    //5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin
    WebElement addElements = driver.findElement(By.xpath("//h3"));

    if(addElements.isDisplayed()){
        System.out.println("Test PASSED.");
    }
    else{
        System.out.println("Test FAILED.");
    }

    Thread.sleep(3000);
    driver.close();

    }
}
