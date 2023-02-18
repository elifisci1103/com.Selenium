package day03_xpath_cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath {
    public static void main(String[] args) {
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        System.setProperty("Webdriver.Chrome.driver","drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/" );
        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick = 'addElement()']")).click();
        // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@onclick = 'deleteElement()']"));
        if (deleteButonu.isDisplayed()) {
            System.out.println("Delete buton testi PASSED");
        }else {
            System.out.println("Delete buton testi FAILED");}
        // 4- Delete tusuna basin
        deleteButonu.click();
        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveButonu = driver.findElement(By.xpath("//h3"));
        if (addRemoveButonu.isDisplayed()) {
            System.out.println("Add/Remove buton testi PASSED");
        }else {
            System.out.println("Add/Remove buton testi FAILED");}
    }
}
