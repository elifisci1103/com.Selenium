package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButton {
   // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
   // a. Verilen web sayfasına gidin.
   // "https://facebook.com"
   // b. Cookies’i kabul edin
   // c. Create an account buton’una basin
   // d. Radio button elementlerini locate edin ve size uygun olani secin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://facebook.com");
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customElementi= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        femaleElementi.click();
        //Sectiğiniz radio buttonun seçili olduğunu diğer butonların seçili olmadığını test edin.
        Assert.assertTrue(femaleElementi.isSelected());
        Assert.assertFalse(maleElementi.isSelected());
        Assert.assertFalse(customElementi.isSelected());
    }
}