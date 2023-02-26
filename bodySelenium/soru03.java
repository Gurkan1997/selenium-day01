package bodySelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru03 extends TestBase {

    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath(" //a[.=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton= driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpLoginButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());
        //6. Enter incorrect email address and password
        WebElement email= driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        email.sendKeys("hgjztu@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("qwert");

        //7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect=driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(incorrect.isDisplayed());



    }
}
