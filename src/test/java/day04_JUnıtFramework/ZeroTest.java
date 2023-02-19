package day04_JUnıtFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroTest {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanine  “username” yazdirin
      WebElement logIn = driver.findElement(By.id("user_login"));
      logIn.sendKeys("username"+ Keys.ENTER);

        //4. Password alanina “password” yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password"+ Keys.ENTER);
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //Back tusuna basin
        driver.navigate().back();
        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
         driver.findElement(By.id("sp_amount")).sendKeys("1000");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement text =driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(text.isDisplayed()){
            System.out.println("Test PASSED");}else{
            System.out.println("Test FAILED");}
        }
    }

