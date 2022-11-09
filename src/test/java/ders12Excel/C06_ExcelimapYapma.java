package ders12Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ExcelimapYapma {
    @Test
    public void ecelMapTesti() throws IOException {
        // Bazen excel'deki

        String dosyayolu=System.getProperty("user.home") + "/Desktop/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);

        Workbook workbook= WorkbookFactory.create(fis);

        // Excel'de birden fazla sutun oldugu icin list gibi bir yapiya
        // bu bilgileri depolamak mumkun olmaz
        // reel database'e en yakin java yapisi olan map kullanabilirz

        //ingilizce ulke ismi key
        // diger 3 bilgiyi birlestirdigimiz String ise value olsun

        Map<String,String> ulkelerMapi=new HashMap<>();

        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndexi ; i++) {

            String keyUlke=workbook
                    .getSheet("Sayfa1")
                    .getRow(i)
                    .getCell(0)
                    .toString();
            String valueUlke=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                            +", "
                            + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                            + ",  "
                           + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
                        ulkelerMapi.put(valueUlke,valueUlke);

        }

    }
}
