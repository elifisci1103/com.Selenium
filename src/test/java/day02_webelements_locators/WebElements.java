package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.Chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon anasayfaya gidin.
        driver.get("https://amazon.com");
        //Arama kutusunu locate edip bir webelement olarak kaydedin.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //Arama kutusuna nutella yazıp aratın.
        aramaKutusu.sendKeys("nutella");
        aramaKutusu.submit();
        Thread.sleep(3000);
        driver.close();

    }
}
