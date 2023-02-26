package bodySelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class soruX extends TestBase {

    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expected="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expected,actualUrl);
        //4. Click on 'Contact Us' button
        WebElement contactUs= driver.findElement(By.xpath("//a[.=' Contact us']"));
        contactUs.click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= driver.findElement(By.xpath("//h2[.='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());
        //6. Enter name, email, subject and message
        WebElement name= driver.findElement(By.xpath("//input[@data-qa='name']"));
        Actions actions=new Actions(driver);
        actions.click(name)
                .sendKeys("ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("ahmet@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("subject")
                .sendKeys(Keys.TAB)
                .sendKeys("Your message here").perform();

        //7. Upload file
        /*String dosyaYolu=System.getProperty("user.home")+"C:\\Users\\grkng\\logo.jpg";
        WebElement chooiseFile= driver.findElement(By.xpath("//input[@type='file']"));
        chooiseFile.sendKeys(dosyaYolu);*/
        //8. Click 'Submit' button
        WebElement submit= driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        //9. Click OK button

        driver.switchTo().alert().accept();
        bekle(3);

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success= driver.findElement(By.xpath("(//div[@style='display: block;'])[1]"));
        Assert.assertTrue(success.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton= driver.findElement(By.xpath("//span[.=' Home']"));
        homeButton.click();

        Assert.assertEquals(expected,actualUrl);




    }
}
