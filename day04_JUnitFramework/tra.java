package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tra {

    @Test
    public void test01() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage=driver.findElement(By.id("slider"));
        Assert.assertTrue(homepage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginPage= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginPage.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ahmet@nehaber.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345"+ Keys.ENTER);

        //7. Click 'login' button

        //8. Verify that 'Logged in as username' is visible
        WebElement logged= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

        //10. Verify that user is navigated to login page
        String expectedLink="https://automationexercise.com/login";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(expectedLink,actualLink);

        Thread.sleep(3000);
        driver.close();

    }
}
