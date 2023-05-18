package practiceTeamWork.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_cookies extends TestBase {

    @Test
    public void test01() {


        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri duzenli bir sekilde listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        int siraNo = 1;
        for (Cookie eachCookie: cookies
             ) {
            System.out.println(siraNo + "------>" +eachCookie);
            siraNo++;

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookies = 5;
        int actualCookies = cookies.size();
        Assert.assertTrue(actualCookies>expectedCookies);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue = "USD";
        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertTrue(actualValue.contains(expectedValue));
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie cookie2 = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie2);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        expectedValue = "cikolatali";
        actualValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedValue,actualValue);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        siraNo = 1;
        cookies = driver.manage().getCookies();
        String flag = "skin isminde bir cookie yok";
        for (Cookie eachCookie : cookies
        ) {
            System.out.println(siraNo + "------ " + eachCookie);
            if (eachCookie.getName().equals("skin")) {
                flag = "skin isminde cookie bulundu";
            }
            siraNo++;
        }

        Assert.assertTrue(flag.equals("skin isminde bir cookie yok"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        Assert.assertEquals(cookies.size(),0);
        

    }
}