package day03_xpath_cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssSelector {
    public static void main(String[] args) {
        // 1- bir class olusturun
        System.setProperty("Webdriver.Chromedriver.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/" );
        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle = "Spend less";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title testi PASSED");} else {
            System.out.println("Title testi FAILED");}
        // 6- Gift Cards sekmesine basin
         driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']")).click();
        // 7- Birthday butonuna basin
         driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();
        // 8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span [@class='a-truncate-cut'])[1]")).click();
        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//button[@value ='25']")).click();
        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement ücret=driver.findElement(By.xpath("//div[@id='gc-live-preview-amount-container']"));
        String expectedUcret ="25$";
        String actualUcret=ücret.getText();
        if(expectedUcret.equals(actualUcret)){
            System.out.println("Test PASSED");}else{
            System.out.println("Test FAILED" +  "Ücret :" + actualUcret);}
        // 11-Sayfayi kapatin
        driver.close();

    }
}
