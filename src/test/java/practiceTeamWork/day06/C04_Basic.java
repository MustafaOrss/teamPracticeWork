package practiceTeamWork.day06;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Basic extends TestBase {
    @Test
    public void test01() {
        // 1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth
        //sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //3- asagidaki yontem ve test datalarini kullanarak
        //authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement sayfaYazi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(sayfaYazi.isDisplayed());
    }
}
