package practiceTeamWork.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void test01() {

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement IframeElementi = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(IframeElementi);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("(//*[@class='sub-heading'])[2]")).click();
        //4. Popup mesajini yazdirin
        WebElement popupMesaji = driver.findElement(By.tagName("h4"));
        System.out.println(popupMesaji.getText());

        //5. “close” butonuna basin
        WebElement closeButonu = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        closeButonu.click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        WebElement WebdriverUniversity = driver.findElement(By.xpath("(//*[@id='nav-title'])[1]"));
        WebdriverUniversity.click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
