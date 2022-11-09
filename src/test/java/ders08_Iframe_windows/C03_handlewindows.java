package ders08_Iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_handlewindows {

   // ● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    //● Sayfa title’nin “wisequarter” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void windowTesti() throws InterruptedException {

        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //     ● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilksayfaHandleDegeri= driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedIcerik="Amazon";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        /*
          driver.switchTo().newWindow() method'u ile yeni bir sayfa olusturup
          driver'i o sayfaya switch ederiz

          bu gecis driver uzerinden yapildigi icin driver da yeni sayfaya gecer
          ve biz yeni sayfada islem yapabiliriz
         */

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB); // yeni bir tab olustur oraya git dedik
        driver.get("https://www.wisequarter.com");

        //● Sayfa title’nin “Wise Quarter” icerdigini test edin

        expectedIcerik="Wise Quarter";
        actualTitle= driver.getTitle();
        System.out.println(actualTitle);

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        Thread.sleep(5000);
        expectedIcerik="Walmart";
        actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        /*
          driver'i switchTo() ile yeni bir tab veya window'a gecirebiliriz
          yeni window olusturmak disinda
          herhangi bir window'a gecmenin TEK BIR YOLU VARDIR
          o da gecmek istedigimiz sayfanin window handle degerini kullanmak

          YANI;
          bir test sirasinda yeniden donmeniz gereken bir window'da iseniz
          o sayfanin window handle degerini KAYDETMELISINIZ

         */

        driver.switchTo().window(ilksayfaHandleDegeri);// bunu yazdıgımızda ilk sayfaya donecektir

        expectedIcerik="Amazon";
       actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        Thread.sleep(5000);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
