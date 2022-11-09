package HUISWERK;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru3 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
     /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4-Sayfa basliginin "Google" ifadesi icerdigini test edin
        5- Arama cubuguna "Nutella" yazip aratin
        6-Bulunan sonuc sayisini yazdirin
        7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        8-Sayfayi kapatin

         */

    // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    WebElement cerezler = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cerezler.click();


        if (driver.getTitle().contains("Google")) {
        System.out.println("Test PASSED");
    } else {
        System.out.println("Test FAILED");
    }


    WebElement aramaMotoru = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaMotoru.sendKeys("Nutella" + Keys.ENTER);


    WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));

    // Yaklaşık 147.000.000 sonuç bulundu (0,41 saniye)
        System.out.println(result.getText());
    String resultstr = result.getText();
    resultstr = resultstr.substring(
            (resultstr.indexOf(" ") + 1),
            (resultstr.indexOf("sonuç") - 1));
        System.out.println(resultstr); // 147000000

    resultstr = resultstr.replaceAll("\\.", "");
        System.out.println(resultstr); // 147000000

        if (Integer.parseInt(resultstr) > 10000000) {
        System.out.println("sonuc sayisi 10000000'den fazla test PASSED");
    } else {
        System.out.println("sonuc sayisi 10000000'den az test FAILED");
    }
}

}
