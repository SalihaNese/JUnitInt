package ders11_cookies_webTables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C04_WebTables extends TestBase {
    @Test
    public void  test01(){
        // amazon anasayfaya gidin
        //en alttaki web table'da 10 satir oldugunu test edin
        // sutun sayisinin 13 oldugunu test edin
        // 3.sutunu yazdirin
        //5.satiri yazdirin
        // 3. satir, 5.sutundaki basligin Home Service oldugunu test edin
        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun


        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //en alttaki web table'da 9 satir oldugunu test edin
        List<WebElement> dataListesi=driver.findElements(By.xpath("//table//tr"));

        Assert.assertTrue(dataListesi.size()==10);
        System.out.println(dataListesi);
        // sutun sayisinin 14 oldugunu test edin
        List<WebElement> ilksatirdatalistesi=driver.findElements(By.xpath("//table//tr[1]/td"));
        Assert.assertTrue(ilksatirdatalistesi.size()==14);
        // 3.sutunu yazdirin
        //5.satiri yazdirin
        // 3. satir, 5.sutundaki basligin Home Service oldugunu test edin
        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun



    }
}
