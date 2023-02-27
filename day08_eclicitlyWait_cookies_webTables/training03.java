package day08_eclicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.TestBaseClass.driver;

public class training03 {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textboxın etkin olmadigini dogrulayin
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());


        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton= driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
        enableButton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        // explicit wait ile bekleyeceksek
        // A- wait objesi olustur
        // B- mumkunse kullanilacak webelementi locate et (texbox == locate edildi)
        // C- wait objesi kullanarak bekleyin


        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled= driver.findElement(By.id("message"));
        Assert.assertTrue(itsEnabled.isDisplayed());


        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());
        driver.close();

    }





}
