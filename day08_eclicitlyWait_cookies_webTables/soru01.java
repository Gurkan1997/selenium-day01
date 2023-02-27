package day08_eclicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class soru01 extends TestBase {

    @Test
    public void test01(){
        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //4. Click on 'Signup / Login' button

        WebElement signupLogin= driver.findElement(By.xpath("//a[@href='/login']"));
        signupLogin.click();
        //5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        //6. Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("zafersahingoz@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456");
        //7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInas= driver.findElement(By.xpath(" //a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedInas.isDisplayed());
        //9. Click 'Delete Account' button

        //10. Verify that 'ACCOUNT DELETED!' is visible



    }




}
