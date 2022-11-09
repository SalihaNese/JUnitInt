package HUISWERK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru1_arabamcom {

    public class Q4_Myself {
        public void main(String[] args) throws InterruptedException {
        /*
        1-Driver olusturalim
        2-Java class'imiza chromedriver.exe'yi tanitalim
        3-Driver'in tum ekrani kaplamasini saglayalim
        4-Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
           söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        5-"https://www.arabam.com/" adresine gidelim
        6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        7-Title ve url'nin "araba" kelimesinin icerip icermedigini kontrol edelim
        8-Arama kismina "Volvo yazalim"
        9-Yazdiktan arac turu olarak sadece otomobili secelim
        10-Gelismis siralama olarak "Fiyata gore (en yuksek)" olani secelim
        12- Fiyati en yuksek olan aracin ilanina tiklayalim
        13-Sayfanin title ve url sini yazdiralim
        13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */



            System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
            WebDriver driver= new ChromeDriver();


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.arabam.com/");


            if (driver.getTitle().contains("araba")) {
                System.out.println("Bu sayfanin title i 'araba' i iceriyor");
            }else {
                System.out.println("Sayfanin asil title i: "+driver.getTitle());
            }

            if (driver.getCurrentUrl().contains("araba")) {
                System.out.println("Sayfinin URL i araba iceriyor");
            }else {
                System.out.println("Sayfanin URL i araba icermiyor");
                System.out.println("Sayfanin asil URL i :"+driver.getCurrentUrl());
            }

            driver.findElement(By.className("input")).sendKeys("Volvo");
            Thread.sleep(1500);

            driver.findElement(By.className("search-button")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"facet-desktop\"]/div[2]/span/form/div[1]/div/div/div/div/ul[1]/li/a")).click();
            Thread.sleep(1500);

            driver.findElement(By.xpath("//*[@id=\"js-hook-missing-space-content\"]/div[2]/div/div[1]/div[2]/div[2]/div/select/option[3]")).click();

            driver.findElement(By.xpath("//*[@id=\"listing20583046\"]/td[2]/a")).click();

            System.out.println("Sayfanin Title i: "+driver.getTitle());

            System.out.println("Sayfanin URL i: "+driver.getCurrentUrl());

            driver.close();





        }
}

}
