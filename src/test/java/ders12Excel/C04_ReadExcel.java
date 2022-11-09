package ders12Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        // ulkeler excel'inde turkce ulke isimleri Senegal iceriyor mu test edin
        // toplam 190 ulke oldugunu test edin
        // en uzun ulke isminin Mikronezya Federal Devletleri oldugunu test edin

        String dosyaYolu=System.getProperty("user.home") + "/Desktop/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        List<String> ulkelerListesi=new ArrayList<>();
        int sonSatirIndexi=workbook
                                 .getSheet("Sayfa1")
                                .getLastRowNum();

        for (int i = 0; i < sonSatirIndexi ; i++) {

            ulkelerListesi.add(workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString());

        }
        ulkelerListesi.remove(0);
        //System.out.println(ulkelerListesi);

        // ulkeler excel'inde turkce ulke isimleri Senegal iceriyor mu test edin

        Assert.assertTrue(ulkelerListesi.contains("Senegal"));
        // toplam 190 ulke oldugunu test edin
        Assert.assertEquals(190,ulkelerListesi.size());
        // en uzun ulke isminin Mikronezya Federal Devletleri oldugunu test edin

        String enuzunIsim="Macaristan";

        for (String each:ulkelerListesi
             ) {
            if (each.length()>enuzunIsim.length()){
                enuzunIsim=each;
            }
        }
        System.out.println("En uzun isimli ulke :" +enuzunIsim);
        Assert.assertEquals("Mikronezya Federal Devletleri", enuzunIsim);
    }
}
