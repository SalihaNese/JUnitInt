package ders09_actionsClass;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_FacebookKayit extends TestBase {

    //1- https://www.facebook.com adresine gidelim
    //  2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");


        //2- cookies'i kabul edin ve yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Nese")

                .sendKeys(Keys.TAB)
                .sendKeys("Ozer")

                .sendKeys(Keys.TAB)
                .sendKeys("fatih@gmail.com")//bir girince bir tane daha istedigi icin 2kez mail adresi yazdik
                .sendKeys(Keys.TAB)
                .sendKeys("fatih@gmail.com")

                .sendKeys(Keys.TAB)
                .sendKeys("12345Arti")

                .sendKeys(Keys.TAB)     // action'da adım adım gitmek mantiklı cunku hata verdiginde nerde verdigi
                .sendKeys(Keys.TAB)      // belli degil. perform'da verir hatayi
                .sendKeys("13")

                .sendKeys(Keys.TAB)
                .sendKeys("Oct")

                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)

                .sendKeys(Keys.TAB) // enter'e gitmek icin 5 tab basmamız gerektigi icin 5 tab'a bastik
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.ENTER)
                .perform();
        //4- Kaydol tusuna basalim

        bekle(5);


    }

}
