package day05_assertions_dropdownMenu;

import day02_webelements_locators.WebElements;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IlkTestBase extends TestBase {
    @Test
    public void test01(){
        //amazona gidelim.
        driver.get("https://amazon.com");
        //nutella aratalım.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        //sonucların nutella içerip içermediğini test edin.
        WebElement actualSonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik ="Nutella";
        String actualIcerik=actualSonucYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }

}
