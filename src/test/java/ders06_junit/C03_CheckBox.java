package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CheckBox {

  // 1. Bir class oluşturun : CheckBoxTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
   // a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın


    WebDriver driver;  // driverı yukarıda olusturuyoruz
   @Before
    public void setup(){

       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }

   @Test
   public void test01() throws InterruptedException {
       // a. Verilen web sayfasına gidin.
       driver.get("https://the-internet.herokuapp.com/checkboxes");

      ///b. Checkbox1 ve checkbox2 elementlerini locate edin.
       WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
       WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

       //c. Checkbox1 seçili değilse onay kutusunu tıklayın
       if (!checkBox1.isSelected()){
           checkBox1.click();
       }

       //  d. Checkbox2 seçili değilse onay kutusunu tıklayın
       if (!checkbox2.isSelected()){
           checkbox2.click();
       }

       Thread.sleep(5000);
   }



    @After
    public void teardown(){

        driver.close();

    }
   }








