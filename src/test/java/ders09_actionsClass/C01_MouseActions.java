package ders09_actionsClass;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_MouseActions extends TestBase {

    //Amazon anasayfaya gidin
    //Account&List "create a List" linkini tıklayın
    //sayfanın en altındaki USD butonuna basın
    // Account&List menusunden "create a list" linkini tiklayin

    @Test

    public void test01() throws InterruptedException {
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //Account&List "create a List" linkini tıklayın


        //driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //sayfanın en altındaki USD butonuna basın
        //driver.findElement(By.xpath("//*[text()='USD - U.S. Dollar']")).click();

        Thread.sleep(5000);

        /*
        Bir test gerceklestirilirken mouse veya klavye ile extra islemler yapmak gerekebilir
        Ornegin; create a list linkini tiklayabilmek icin
        Account&List menusunun uzerinde beklemek gerekir.

        Diver genellikle (Web Develper'larin kullandiklari argumanlara gore degisir)
        gorebildigi web elementleri kullanabilir.

        Selenium mouse ve klavye ile yapabilecegimiz tum fonksiyonlari
          driver ile gerceklestirebilmek icin
          Actions class'ini olusturmustur.
         */

        // Actions class'inin ozelliklerini kullanabilmek icin obje olusturalim
        Actions actions= new Actions(driver);

        // Account&List menusunden "create a list" linkini tiklayin
        WebElement accountListElementi= driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        actions.moveToElement(accountListElementi).perform();//buraya git ve bekle diyoruz
        // action metodların calısması icin sonunda perform demeliyiz yoksa calısmaz

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        Thread.sleep(3000);

    }

}
