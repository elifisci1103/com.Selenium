package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.Chromedriver.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon anasayfaya gidin.
        driver.get("https://amazon.com");
        //Arama kutusuna java yazıp aratın.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java");
        aramaKutusu.submit();
        //Arama sonuçlarından çıkan resimlerdeki yazıları yazdırın.
        List<WebElement> aramaSonuclari = driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclari.size());
        int sayı =1;
        for (WebElement eachElement:aramaSonuclari) {
            System.out.println(sayı +"---" +eachElement.getText());
            sayı++;
        }
        Thread.sleep(3000);
        driver.close();
    }
}
