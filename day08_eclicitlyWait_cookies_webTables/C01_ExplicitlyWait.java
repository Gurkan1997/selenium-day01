package day08_eclicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));

        //WebElement itsGoneElementi=
                //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        WebElement itsGoneElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        driver.close();




    }
}
