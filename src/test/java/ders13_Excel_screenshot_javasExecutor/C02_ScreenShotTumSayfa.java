package ders13_Excel_screenshot_javasExecutor;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShotTumSayfa extends TestBase {

   /* @Test
    public void test01() throws IOException {
        //Amaxon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // Nutella icin arama yapalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedKelime="Nutella";
        String actualYazi=sonucYazisiElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedKelime));

        // tum sayfanin screenshot'ini almak icin 4 adim gerekiyor

        //1- screenshot objesi kullanarak fotografı cekip,gecici dosyayahot objesi olusturup
        // deger olarak cast ettigimiz driver2i atayalım
        TakesScreenshot tss=(TakesScreenshot) driver;

        // 2- resmi kaydedecegimiz bir dosya olusturulur
        File tumSayfaSSchot=new File("target/ScreenShot/tumSayfaScreenshot.jpeg");

        //3-
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi hazirladıgım

        FileUtils.copyFile(geciciResim,tumSayfaSSchot);

        public  class TestBase {
            protected WebDriver driver;

            @Before
            public void setup(){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            }

            @After
            public void teardown(){
                driver.close();
            }

            public  void bekle(int beklenecekSaniye){
                try {
                    Thread.sleep(beklenecekSaniye*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            public void tumSayfaResimCek() throws IOException {

            }
                // 1- TakesScreenShot objesi olusturup
                //    deger olarak cast ettigimiz driver'i atayalim
                TakesScreenshot tss= (TakesScreenshot) driver;

                // 2- resmi kaydedecegimiz bir dosya olusturulur
                //    resim isimlerini dinamik yapmak ve resmin tarihini eklemek icin
                //    resim dosya yoluna tarih ekleyelim
                LocalDateTime ldt=LocalDateTime.now();
                DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
                File tumSayfaSShot= new File("target/ScreenShot/tumSayfaScrenshot"+ldt.format(dtf)+".jpeg");
                // 3- screenshot objesi kullanarak fotografi cekip, gecici dosyaya kaydet
                File geciciResim= tss.getScreenshotAs(OutputType.FILE);
                // 4- gecici dosyayi hazirladigim file'a kopyalayalim
                FileUtils.copyFile(geciciResim,tumSayfaSShot);
            }

    }

    */
}
