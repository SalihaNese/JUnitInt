package ders10_fie_waits;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_FileUPloadTesti extends TestBase {

    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    // 3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void uploadTesti(){
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        /*
          dosya sec butonuna bastiktan sonra
          bilgisayardan selenium ile dosya secmemiz mumkun degil
          onun yerine
          dosyaSecButonu.sendKeys("DosyaYolu") yaparsak
          dosya secme islemi yapilmis olacaktir
         */

        String yuklenecekDosyaYolu= System.getProperty("user.home") +
                "/Desktop/FileTesti/deneme.txt";

        //    "/Users/ahmetbulutluoz/Desktop/FileTesti/deneme.txt" // kendi bilgisayarıızınfa dosya yolunu bu sekilde de
        //    yazarsak yıne verir ama dinamik olmaz .Yukarıda yaptıgımız dinamık

        dosyaSecButonu.sendKeys(yuklenecekDosyaYolu);


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        bekle(5);

        WebElement fileUploadYazielementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazielementi.isDisplayed());

    }

    }

