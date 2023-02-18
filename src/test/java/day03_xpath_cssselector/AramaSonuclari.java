package day03_xpath_cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AramaSonuclari {
    public static void main(String[] args) {
        System.setProperty("Webriver.Chromedriver.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Google a gidin.
        driver.get("https://google.com");

        // arama cubuguna Java yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("Java");
        aramaCubugu.submit();

        // bulunan sonuc sayisinin 100binden cok oldugunu test edin

        WebElement sonucSayiElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        // About 1.350.000.000 results (0,43 seconds)
        String sonucYazisi= sonucSayiElementi.getText();
        String[] sonucYaziArr=sonucYazisi.split(" ");
        String sonucSayisiStr= sonucYaziArr[1]; // 1.350.000.000
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi= Integer.parseInt(sonucSayisiStr);
        System.out.println(actualSonucSayisi);
        int expectedSonucSayisi=100000;
        if (actualSonucSayisi>expectedSonucSayisi){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Arama sonuc sayisi testi FAILED");
        }
        driver.close();




    }
    }

