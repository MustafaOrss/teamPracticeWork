package practiceTeamWork.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

public class C02_Dropdown extends TestBaseBeforeClass {

    @Test
    public void test01(){
        // ● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement kategoriMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(kategoriMenu);
        int expectedSayisi = 45;
        int actualSayi = select.getOptions().size();
        Assert.assertEquals(expectedSayisi,actualSayi);


    }

    @Test
    public void test02(){
        //-Test 2
        driver.get("https://www.amazon.com/");
        WebElement kategoriMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(kategoriMenu);
        //1. Kategori menusunden Books secenegini secin
        select.selectByValue("search-alias=stripbooks-intl-ship");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java");
        aramaKutusu.submit();
        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayiElementi.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
        String expected = "Java";
        String actual = sonucSayiElementi.getText();
        Assert.assertTrue(actual.contains(expected));
    }

}
