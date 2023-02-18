package day03_xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MavenIlkClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- "" sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
       aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucSayisi.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim

        driver.navigate().back();
        List<WebElement> baslikElementleriListesi=
                driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        int baslikNo=1;
        for (WebElement eachElement: baslikElementleriListesi
        ) {
            System.out.println(baslikNo +" --- " + eachElement.getText());
            baslikNo++;
        //   soldaki aramayi daraltabilecegimiz basliklar
        }
        Thread.sleep(3000);
        driver.close();

    }}

