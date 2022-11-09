package ders09_actionsClass;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_DrugAndDrop extends TestBase {

   // Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //      2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakElement= driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement tasinacakHedefAlan= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions= new Actions(driver);// mouse 2u kullanmak icin action class2ından obje olusturmalıyız

        actions.dragAndDrop(tasinacakElement,tasinacakHedefAlan).perform();//dragAndDrop tutup tasıyacak element

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziElementi= driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedDroppedYazisi="Dropped!";
        String actualDroppedYazisi=droppedYaziElementi.getText();

        Assert.assertEquals(expectedDroppedYazisi,actualDroppedYazisi);

        Thread.sleep(5000);
    }
}
