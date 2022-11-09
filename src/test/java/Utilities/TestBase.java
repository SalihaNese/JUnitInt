package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected WebDriver driver; // farklı package 'da oldukları icin ve ulasılmasi icin ya protected yada public
                                    // olmasi gerekir .Biz protected tercih ettik


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void teardown(){
        //driver.close();
    }

    public static void bekle(int beklenecekSaniye){

        try {
            Thread.sleep(beklenecekSaniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    }

