package HUISWERK;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru4 {

      /*
        1. "https://www.saucedemo.com" Adresine gidin
        2. Username kutusuna "standard_user" yazdirin
        3. Password kutusuna "secret_sauce" yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin
        */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test

    public void Test2() throws InterruptedException {
    driver.get("https://www.saucedemo.com");
    WebElement usarname = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));

        usarname.sendKeys("standard_user");
        Thread.sleep(1000);


    WebElement password= driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.sendKeys("secret_sauce");
        Thread.sleep(1000);

    WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        Thread.sleep(1000);

    WebElement ilkurunName=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("Product name= "+ilkurunName.getText());
        ilkurunName.click();
        Thread.sleep(1000);

    WebElement addCart=driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        addCart.click();

    WebElement alisverissepetine=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        alisverissepetine.click();

    WebElement sepeteEklendigin=driver.findElement(By.xpath("//div[@class='cart_item']"));
        if (sepeteEklendigin.isDisplayed()){
        System.out.println("Product added to Basket Test PASSED");
    }else {
        System.out.println("Product added to Basket Test FAILED");
    }

}
    @After
    public void tearDown() {
        driver.quit();
    }

        }




