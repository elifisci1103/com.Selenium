package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverMethodlari {
    public static void main(String[] args) {


            //Yeni bir class olusturalim (Homework)
            //ChromeDriver kullanarak, facebook sayfasina gidin

            System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://facebook.com");

            // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
            // degilse dogru basligi yazdirin.
            String expectedTitle = "facebook";
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
            System.out.println("Title testi PASSED");}else{
                System.out.println("Title testi FAILED baslık :" + actualTitle);

            //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
            // icermiyorsa “actual” URL’i yazdirin.
                String expectedUrl="facebook";
                String actualUrl = driver.getCurrentUrl();
                 if(actualUrl.contains(expectedUrl)){
                     System.out.println("Url testi PASSED");}else{
                     System.out.println("Url :" + actualUrl);
                 }

            // https://www.walmart.com/ sayfasina gidin.
                driver.get("https://walmart.com/");

            // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
                String expectedTitle2 ="Walmart";
                String actualTitle2 = driver.getTitle();
                if(actualTitle2.contains(expectedTitle2)){
                    System.out.println("2. title testi PASSED");}else{
                    System.out.println("2. title testi FAILED");}

            // Tekrar “facebook” sayfasina donun
                driver.navigate().back();

            // Sayfayi yenileyin
                driver.navigate().refresh();

            //Browser’i  kapatin
                driver.close();

        }
    }}

