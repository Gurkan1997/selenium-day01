package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class C07_JsAlerts extends TestBaseClass {
    @Test
    public void test01(){
        // Gerekli ayarlamalari yapip
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3 test method'u olusturup her method'da bir JsAlert'e basin
        // Ilgili method'lari kullanin
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
        bekle(2);

    }



    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 2.alert'e tiklayalim
    // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3.alert'e tiklayalim
    // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
    // Cikan sonuc yazisinin Abdullah icerdigini test edelim

}
