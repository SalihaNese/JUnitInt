package HUISWERK;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class soru10 {

    public class C07_homework_DAY10 extends TestBase {
    /*
    1."http://webdriveruniversity.com/" adresine gidin
    2 "Login Portal" a  kadar asagi inin
    3."Login Portal" a tiklayin
    4.Diger window'a gecin
    5."username" ve  "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    8.Ok diyerek Popup'i kapatin
    9.Ilk sayfaya geri donun
    10.Ilk sayfaya donuldugunu test edin
     */

        WebDriver driver;

        @Test
        public void test01() throws InterruptedException {
            // 1."http://webdriveruniversity.com/" adresine gidin
            driver.get("http://webdriveruniversity.com/");

            Actions actions = new Actions(driver);
            // 2 "Login Portal" a  kadar asagi inin
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                    sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

            String ilkksayfaHandle = driver.getWindowHandle(); //CDwindow-F88F80380E33FB34923B82A6816D4620
            System.out.println(ilkksayfaHandle);
            //3."Login Portal" a tiklayin
            WebElement loginButton = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
            loginButton.click();

            // 4.Diger window'a gecin


            Set<String> handles = driver.getWindowHandles();//[CDwindow-F88F80380E33FB34923B82A6816D4620, CDwindow-8A0A7F31399BF3EC933047C7A7273E7C]
            System.out.println(handles);

            Set<String> windowHandlesSet= driver.getWindowHandles();
            String ikinciSayfaWindowHandleDegeri= "";

            for (String eachHandleDegeri: windowHandlesSet
            ) {
                if (!eachHandleDegeri.equals(ilkksayfaHandle)){
                    ikinciSayfaWindowHandleDegeri= eachHandleDegeri; // yani ikinci sayfanin window handle degerini simdi bulduk...
                }
            }

            driver.switchTo().window(ikinciSayfaWindowHandleDegeri); // iste! simdi ikinci sayfaya gectik...
            Thread.sleep(2000);
            //  5."username" ve  "password" kutularina deger yazdirin
            WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
            username.sendKeys("Nevzat");
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("123456" + Keys.ENTER);
            Thread.sleep(2000);
            String expected = "validation failed";
            String actualalertMessage = driver.switchTo().alert().getText();
            System.out.println(actualalertMessage);
            Assert.assertEquals(expected, actualalertMessage);
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            // 9.Ilk sayfaya geri donun

            driver.switchTo().window(ilkksayfaHandle);
            //    10.Ilk sayfaya donuldugunu test edin

            String expectedUrl="http://webdriveruniversity.com/";
            String actualUrl= driver.getCurrentUrl();

            Assert.assertEquals(expectedUrl,actualUrl);
            //  Assert.assertTrue(actualUrl.contains(expectedUrl));
            //  Assert.assertTrue(actualUrl.equals(expectedUrl));




        }
}

}
