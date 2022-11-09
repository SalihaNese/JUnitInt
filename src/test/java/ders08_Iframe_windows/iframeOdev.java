package ders08_Iframe_windows;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iframeOdev extends TestBase {
        // ● Bir class olusturun: IframeTest02
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        // 2) sayfadaki iframe sayısını bulunuz.
        //3) ilk iframe’deki (Youtube) play butonuna tıklayınız.
        // 4) ilk iframe’den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void test01(){
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement iframeYaziElementi= driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframeYaziElementi);
        WebElement declineCookies= driver.findElement(By.xpath("//button[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']"));
        declineCookies.click();
        driver.switchTo().defaultContent();


        WebElement iframeYaziElemeti2= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframeYaziElemeti2);
        WebElement youtubeButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubeButton.click();
        driver.switchTo().defaultContent();


        WebElement JmeterMadeEasy=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(JmeterMadeEasy);
        WebElement JmeterPage= driver.findElement(By.xpath("//a[@href=\"http://www.guru99.com/live-selenium-project.html\"]"));
        JmeterPage.click();

        driver.switchTo().defaultContent();



    }







}
