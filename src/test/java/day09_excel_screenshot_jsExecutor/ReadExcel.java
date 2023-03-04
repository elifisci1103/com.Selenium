package day09_excel_screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void test01() throws IOException {
        /*
            Biz kodlarimizla bilgisayardaki bir dosyaya direk erisim saglayip
            anlik o dosyadan bilgi almayiz
            Bunun yerine class'in basinda, bilgisayarimizdaki excel dosyanin
            1- bir kopyasini olusturur
            2- excel'deki tum bilgileri kopya workbook'a yukler
            3- workbook uzerinde yapacagimiz tum islemleri yapariz
            4- eger olusturdugumuz workbook'da update yaparsak
               son halini excel'e islemek icin
               class'in sonunda kopya workbook'daki bilgileri excel'e kaydederiz.
         */
        // 1- bilgisayardaki excel'e ulasabilmek icin dosyaYolu gerekir
              String dosyaYolu="src/test/java/day09_excel_screenshot_jsExecutor/ulkeler.xlsx";
        // 2- Dosya yolunu olusturdugumuz excel'den bilgileri almak icin
        //    FileInputStream objesi olusturmaliyiz
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Bilgilerini aldigimiz excel'de calisma yapabilmek icin
        //    kod ortamimizda kopya bir workbook olusturmaliyiz
        Workbook workbook= WorkbookFactory.create(fis);
        // Bilgisayarimizdaki excel'in icinde bulunan tum bilgiler
        // artik workbook objesinde kayitli
        // excel'in yapisi geregi, sirayla
        // - istenen sayfa
        // - istenen satir
        // - istenen hucre
        // olusturulmalidir / okunmalidir
        // 12.satirin, 3.hucresinin "Azerbaycan" oldugunu test edin
      String actualData =workbook.getSheet("sayfa1").getRow(11).getCell(2).toString();
      String expectedData="Azerbaycan";
      Assert.assertEquals(expectedData,actualData);
        // excel index kullanir yani 0'dan baslar

    }
}
