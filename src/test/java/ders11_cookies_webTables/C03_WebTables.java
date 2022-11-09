package ders11_cookies_webTables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_WebTables extends TestBase {


        // amazon anasayfaya gidin
        // en alttaki web table'dan home service secenegini tiklayin
        //ilgili sayfaya gittigini test edin


    @Test
    public void amazonTesti(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // en altdaki web table'dan home service secenegini tiklayin
        driver.findElement(By.xpath("//table//tr[3]//td[5]")).click();
        // ilgili sayfaya gittigini test edin
        WebElement baslikYaziElementi= driver.findElement(By.xpath("//img[@alt='Home services appointments during COVID-19']"));
        Assert.assertTrue(baslikYaziElementi.isDisplayed());

        // tum tablo body'sinde care kelimesi gecmedigini test edin
        WebElement tableBody= driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tableBody.getText());
        Assert.assertFalse(tableBody.getText().contains("care"));
    }
}
