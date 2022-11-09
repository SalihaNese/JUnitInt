package ders12Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        // ulkeler excel'ine gidin
        // 32.satırdaki ülke isminin ingilizce Canada oldugunu test edelim

        String dosyayolu=System.getProperty("user.home")+ "/Desktop/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyayolu);

        Workbook workbook= WorkbookFactory.create(fis);

        String actuelIsim=workbook
                .getSheet("sayfa1")
                .getRow(31)
                .getCell(0)
                .toString();
        String expectedIsim="Canada";
        Assert.assertEquals(expectedIsim,actuelIsim);
    }

}
