package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class DropdownMenu2 extends TestBaseClass {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

       WebElement ddm= driver.findElement(By.id("dropdown"));
       Select select = new Select(ddm);
       select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);

        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        bekle(2);
       select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //  4.Tüm dropdown değerleri(value) yazdırın
         List<WebElement> liste=select.getOptions();
         int no=1;
        for (WebElement eachElement:liste) {
            System.out.println(no+ " " +eachElement.getText());
        }

        //  5.Dropdown’un boyutununun 4 oldugunu test edin
        int expectedSize=4;
        int actualSize= liste.size();
        Assert.assertEquals(expectedSize,actualSize);
        bekle(3);

    }}


