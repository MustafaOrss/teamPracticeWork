package practiceTeamWork.day06;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_iFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement iFrame = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iFrame.isDisplayed());
        System.out.println(iFrame.getText());

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(1000);
        textBoxElementi.clear();
        Thread.sleep(1000);
        textBoxElementi.sendKeys("Merhaba Dunya!");

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());
    }
}


