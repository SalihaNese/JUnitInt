package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_BestBuyAssertons {

    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    //  farkli test method’lari olusturarak asagidaki testleri yapin
     //   ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
     //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void urltest(){
        //2) https://www.bestbuy.com/ Adresine gidin
        driver.get(" https://www.bestbuy.com/");

        // Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titletest(){
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        driver.get("https://www.bestbuy.com/");// bunu yukardada aldık ama bagımsız calıstırmak icin onemli

        String expectedYanlisIcerik="Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedYanlisIcerik));
    }

    @AfterClass
    public static void teardown(){
        driver.close();                                                   ////button[text()='Français']
    }

    @Test
    public void logoTest(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        driver.get("https://www.bestbuy.com/");

        WebElement logoElement= driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoElement.isDisplayed());//goruntulendigini derken isDisplay kullanılır
    }

    @Test
    public void FrancaisTesti(){
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        driver.get("https://www.bestbuy.com/");
        WebElement francaisElementi= driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francaisElementi.isDisplayed());
    }
}
