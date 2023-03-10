package day08_eclicitlyWait_cookies_webTables;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru02 extends TestBase {
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
        //6. Enter incorrect email address and password
        WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("gurkan@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        //7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect=driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(incorrect.isDisplayed());

    }
}
