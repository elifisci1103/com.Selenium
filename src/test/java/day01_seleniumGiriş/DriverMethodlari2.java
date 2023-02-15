package day01_seleniumGiriş;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethodlari2 {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
         WebDriver driver =new ChromeDriver();
       //  driver.manage().window().maximize(); //Ekranı tam ekran yapar.
      //   driver.close();                      //Açılan web sayfasını kapatır.


        //Amazon anasayfaya gidin.
        driver.get("https://www.amazon.com");

        //Gittiğiniz sayfadaki url ve title ı yazdırın.
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Amazon anasayfaya gittiğinizi test edin.
        String expectedIcerik ="amazon";
        String actualUrl=driver.getCurrentUrl();
        if(actualUrl.contains(expectedIcerik)){
            System.out.println("TEST PASSED");}
            else{
            System.out.println("TEST FAILED");}
        }
    }

