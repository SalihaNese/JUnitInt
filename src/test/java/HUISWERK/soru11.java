package HUISWERK;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class soru11 {

WebDriver driver;

    @Test
    public void test01(){
       /*
       1. Bir Class olusturalim YanlisEmailTesti
       2. http://automationpractice.com/index.php sayfasina gidelim
       3. Sign in butonuna basalim
       4. Email kutusuna @isareti olmayan bir mail yazip enter'a
        bastigimizda "Invalid email address" uyarisi ciktigini test edelim
        */

        //2. http://automationpractice.com/index.php sayfasina gidelim
        driver.get(" http://automationpractice.com/index.php");

        // 3. Sign in butonuna basalim
        WebElement loginButton=driver.findElement(By.xpath("//a[@class='login']"));
        loginButton.click();

        // 4. Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
        WebElement mailSection= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        mailSection.sendKeys("nevzat1gmail.com"+ Keys.ENTER);

        //"Invalid email address" uyarisi ciktigini test edelim
        WebElement invalidEmail= driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        System.out.println(invalidEmail.getText());
        Assert.assertTrue(invalidEmail.isDisplayed());

    }

    @Test
    public void test02(){
    /*
       1) Bir class oluşturun: BestBuyAssertions
       2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak asagidaki
       testleri yapin
       ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
       ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
       ○ logoTest => BestBuy logosunun görüntülendigini test edin
       ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

     */
        driver.get("https://www.bestbuy.com/");
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        // Assert.assertTrue(actualUrl.contains(expectedUrl));

        Assert.assertFalse(driver.getTitle().contains("Rest"));
        System.out.println(driver.getTitle());

        WebElement fransizcaLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());


    }
}
