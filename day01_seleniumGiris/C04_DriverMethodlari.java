package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https:/wisequarter.com");

        System.out.println(driver.getWindowHandle());

        System.out.println(driver.getPageSource());

        String expectedIcerik="2 hours ";
        String actualSayfaKodlari= driver.getPageSource();



        driver.quit();
    }
}
