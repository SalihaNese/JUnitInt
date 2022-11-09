package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {

    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximixe edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */      //sıralama BeforeClass,Before,Test,After,AfterClass

    static WebDriver driver; //Junit'te static kullanmak zorunlu
   // WebElement searccBox= driver.findElement(By.xpath("//input[@name='q']"));
    //bircok kez kullanacagımız testlerde class levelde bir kez olustururuz
    @BeforeClass
    public static void  setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();// driver ataması bu obje olusturduk
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public  static void teardown(){
        driver.close();
    }

    @After
    public void afterTest(){
        System.out.println("test sonucu" + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @Before
    public void beforeTest(){
        driver.get(" http://www.google.com");//her testtten once buraya gitsin diye buraya yazdık
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//div[text()='Tümünü kabul et']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);

    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Brave Heart"+ Keys.ENTER);
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Harry Potter"+ Keys.ENTER);
    }

}
