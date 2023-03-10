package day09_excel_screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReadExcel2 {
    @Test
public void test01() throws IOException {
        String dosyaYolu="src/test/java/day09_excel_screenshot_jsExecutor/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

    //  - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

        //      - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
       String istenenData= workbook.getSheet("sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenData);

    //  - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualData=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedData="Kabil";
        Assert.assertEquals(expectedData,actualData);


    //  - Satir sayisini bulalim
        System.out.println((workbook.getSheet("Sayfa1").getLastRowNum())-1);
        // getLastRowNum() son satirin index'ini verir

    // - Sayfa2'deki satir sayisi ve Fiziki olarak kullanilan satir sayisini bulun
      int satirSayisi= (workbook.getSheet("Sayfa1").getLastRowNum())-1;
        System.out.println(satirSayisi);
        int fizikiSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(fizikiSatirSayisi);



    // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap = new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 1; i <=sonSatirIndexi ; i++) { // basligi almamak icin 1'den baslattim.
            String ulke= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkelerMap.put(ulke,baskent);
        }
        System.out.println(ulkelerMap);

        }

}

