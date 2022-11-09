package ders07_HandleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDownMenu {

    // amazon anasayfaya gidin
    // arama kutusunun solundaki DDM'deki option sayisinin 27 oldugunu test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void ddmTest(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        WebElement dropdownElement= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdownElement);

        List<WebElement>optionListesi=select.getOptions(); // webelementlerden olusan bir Liste dondurur

        // tum optionlari yazdiralim
       // System.out.println(optionListesi);// bu sekilde yazdiramayız tum elementleri eger yazdırmak istiyorsak
                                                                        //for each ile yazdirabiliriz.
        for (WebElement eachWebElement: optionListesi
        ) {
          //  System.out.println(eachWebElement.getText());
        }


        // arama kutusunun solundaki DDM'deki option sayisinin 27 oldugunu test edin
        Assert.assertEquals(27,optionListesi.size());

    }



    @After
    public void teardown(){
        driver.close();
    }

}
