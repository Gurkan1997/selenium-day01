package bodySelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class soru08 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expected="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expected,actualUrl);
        //4. Click on 'Products' button
        WebElement product= driver.findElement(By.xpath("//i[@style='font-size: 16px;']"));
        product.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProduct=driver.findElement(By.xpath("//h2[.='All Products']"));
        Assert.assertTrue(allProduct.isDisplayed());
        //6. The products list is visible
        WebElement list=driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(list.isDisplayed());

        Thread.sleep(5000);
        //7. Click on 'View Product' of first product
        Actions actions=new Actions(driver);
        actions.click(list).sendKeys(Keys.ARROW_DOWN)
                        .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).perform();

        driver.findElement(By.xpath("(((//a[.='View Product'])[1]")).click();
        //8. User is landed to product detail page
        String expectedUrl="https://www.automationexercise.com/product_details/1";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actual);
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement detail=driver.findElement(By.xpath("//div[@class='product-information']"));
        System.out.println(detail.getText());
        Assert.assertTrue(detail.isDisplayed());

    }
}
