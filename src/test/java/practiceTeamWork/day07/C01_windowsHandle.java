package practiceTeamWork.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_windowsHandle extends TestBase {

    @Test
    public void test01() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String WHdegeri = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWHDegeri = driver.getWindowHandle();
        //● Sayfa title’nin “wisequarter” icerdigini test edin
        expectedIcerik = "IT Bootcamp, Distance education method - Wise Quarter Course";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedIcerik,actualTitle);
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedIcerik = "Walmart";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(WHdegeri);
        expectedIcerik = "https://www.amazon.com/";
       String actualUrl = driver.getCurrentUrl();
       Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }


}
