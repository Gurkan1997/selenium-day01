package day04_JUnitFramework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

public class tr02 extends TestBase {

    // 1. Launch browser
    @Test
    public void test01() throws InterruptedException {
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("automationexercise"));
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        // 5. Verify 'New User Signup!' is visible
        WebElement usersihnup = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(usersihnup.isDisplayed());
        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("gurkan" + Keys.ENTER);
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("gurkan1@gmail.com" + Keys.ENTER);
        // 7. Click 'Signup' button
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enter = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@id='id_gender2']"));
        Actions actions= new Actions(driver);
        Faker faker= new Faker();
        String fakeEmailAdress=faker.internet().emailAddress();
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        actions.click(isimKutusu)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("01.12.1889")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.ENTER).perform();

        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Thread.sleep(5000);
        WebElement accountCreated=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(accountCreated.isDisplayed());
        //15. Click 'Continue' button
        WebElement devamEtme= driver.findElement(By.xpath("//a[text()='Continue']"));
        devamEtme.click();
        //16. Verify that 'Logged in as username' is visible
        Thread.sleep(5000);
        WebElement logged = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        //17. Click 'Delete Account' button
        WebElement delete= driver.findElement(By.xpath("//a[text()=' Delete Account']"));
        delete.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDelete= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDelete.isDisplayed());
        WebElement clickButton= driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        clickButton.click();


    }
}
