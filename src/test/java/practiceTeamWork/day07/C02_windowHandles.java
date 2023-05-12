package practiceTeamWork.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_windowHandles extends TestBase {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedIcerik = "Opening a new window";
        WebElement textElement = driver.findElement(By.tagName("h3"));
       String actualIcerik = textElement.getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        expectedIcerik = "The Internet";
        actualIcerik = driver.getTitle();
        Assert.assertEquals(expectedIcerik,actualIcerik);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();
        String ilkSayfa = driver.getWindowHandle();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> WHDegerleri = driver.getWindowHandles();
        String ikinciWHD = "";

        for (String eachWHDegerleri: WHDegerleri
             ) {
            if(!eachWHDegerleri.equals(ilkSayfa)){
                ikinciWHD = eachWHDegerleri;

            }

        }
        driver.switchTo().window(ikinciWHD);
        expectedIcerik = "New Window";
        actualIcerik = driver.getTitle();

        Assert.assertEquals(expectedIcerik,actualIcerik);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindow = driver.findElement(By.tagName("h3"));
        expectedIcerik = "New Window";
        actualIcerik = newWindow.getText();

        Assert.assertEquals(expectedIcerik,actualIcerik);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfa);
        expectedIcerik = "The Internet";
        actualIcerik = driver.getTitle();

        Assert.assertEquals(expectedIcerik,actualIcerik);



    }
}