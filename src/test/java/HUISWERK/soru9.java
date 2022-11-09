package HUISWERK;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class soru9 {

    public class C06_homework_DAY10 extends TestBase {
    /*
    "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
    "Our Products" butonuna basin
    "Cameras product"i tiklayin
    Popup mesajini yazdirin
    "close" butonuna basin
    "WebdriverUniversity.com (IFrame)" linkini tiklayin
    "http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */
        WebDriver driver;
        @Test
        public void test01() throws InterruptedException {
            // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
            driver.get("http://webdriveruniversity.com/IFrame/index.html");


            // "Our Products" butonuna basin
            WebElement ilkIframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
            driver.switchTo().frame(ilkIframe);

            WebElement ourPruducts= driver.findElement(By.xpath("//a[@href='products.html']"));
            ourPruducts.click();

            // "Cameras product"i tiklayin
            WebElement cameras= driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]"));
            cameras.click();

            WebElement popupMesaji=driver.findElement(By.xpath("//div[@class='modal-content']"));
            Thread.sleep(2000);
            // Popup mesajini yazdirin
            System.out.println(popupMesaji.getText());

            // "close" butonuna basin
            WebElement closeButton=driver.findElement(By.xpath("(//button[@type='button'])[4]"));
            closeButton.click();
            Thread.sleep(2000);
            //  "WebdriverUniversity.com (IFrame)" linkini tiklayin
            driver.switchTo().defaultContent();
            WebElement iframeLink= driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]"));
            iframeLink.click();

            //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
            String expectedWebsite="http://webdriveruniversity.com/index.html";
            String actualWebsite=driver.getCurrentUrl();
            Assert.assertEquals(expectedWebsite,actualWebsite);


        }
}

}
