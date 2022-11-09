package ders10_fie_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));
        //"C:\Users\User\Desktop\FileTesti" dosyayolu yeniactıgımdosya
        // masa ustunde olusturdugumuz txt file'in path'i


         /*
          System.getProperty("user.home") tum bilgisayarlarda
          kullaniciya kadar olan path'i verir
          ve bu kisim her bilgisayar ve her kullanici icin farklidir

          user.home'dan sonrasi tum kullanicilar ortak olabilir
          ornegin tum kullanicilarin masaustu

          user.home / Desktop

          downloads %90 kullanici icin

          user.home / Downloads

          eger birden fazla bilgisayarda file ile ilgili bir test yapacaksaniz
          dosya yolunu dinamik olarak olusturmaniz gerekir

         */

        // dinamik dosya yolu olusturma
        // masa ustunde FileTesti diye bir klasor ve onun altinda deneme diye bir text dosyasi icin




       String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\FileTesti\\deneme.txt";
        //System.out.println(dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));//dosya yolu yazacaz
        //true veya false getirir

        System.out.println(System.getProperty("user.home"));
        //dosyada sag tus yolu kopyala
        //"C:\Users\User\Desktop\FileTesti"

        //DOSYA YOLUNU BUL

        //"C:\Users\User\Desktop\FileTesti\deneme.txt"

    }
}
