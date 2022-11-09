package HUISWERK;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru5 {

     /*
   ...Exercise6...
// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim
*/

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://amazon.com");

        WebElement allButton=driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));
        allButton.click();
        Thread.sleep(1000);

        WebElement books= driver.findElement(By.xpath("//a[@data-menu-id='3']"));
        books.click();
        Thread.sleep(1000);

        WebElement allKategori= driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']"));
        System.out.println(allKategori.getText());
        Thread.sleep(1000);

        WebElement xbutton=driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']"));
        xbutton.click();
        Thread.sleep(1000);

        WebElement search= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("Les Miserables"+ Keys.ENTER);
        Thread.sleep(1000);

        WebElement result=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Result of Les Miserables : "+result.getText());

        Assert.assertTrue(result.getText().contains("Les Miserables"));


    }

    @After
    public void tearDown(){
        driver.close();
    }
}
