package ders09_actionsClass;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //      3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //  5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim

        driver.get(" https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions= new Actions(driver);
        WebElement cizgiliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi= driver.switchTo() //swithcto ile alerte gectik
                                         .alert()// sonra alerte gidiyor
                                         .getText();// onun textini alıyor

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        Thread.sleep(3000);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfahandleDegeri= driver.getWindowHandle();// baska bir sayfaya gececegimiz icin bu sayfanın
                                                                // handle degerini almalıyız

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        // once driver'i 2.sayfaya gecirmeliyiz, bunun icin de 2.sayfanin handle degerini bulmaliyiz
        //2.sayfaya gecmemiz icin 2. sayfanın handle degerine ihtiyac var
        //once bunu bulmalıyız

        Set<String > handleDegerlerSeti= driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";

        for (String eachHandleDegeri: handleDegerlerSeti
        ) {
            if (!eachHandleDegeri.equals(ilkSayfahandleDegeri)){//gelen handle degeri ilk sayfanınkine esit degilse
                ikinciSayfaHandleDegeri=eachHandleDegeri;//2. sayfanınhandele degeri o'dur diyoruz
            }
        }

        driver.switchTo().window(ikinciSayfaHandleDegeri);// 2. sayfaya geciyoruz

        WebElement h1TagElementi= driver.findElement(By.tagName("h1"));

        String expectedTagYazisi="Elemental Selenium";
        String actualTagYazisi= h1TagElementi.getText();

        Assert.assertEquals(expectedTagYazisi,actualTagYazisi);

        Thread.sleep(5000);
    }
    }






