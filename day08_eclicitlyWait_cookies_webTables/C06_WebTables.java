package day08_eclicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        WebElement headers= driver.findElement(By.xpath("(//div[@role='row'])[1]"));
        System.out.println(headers.getText());

        System.out.println("____________________");

        //  3. 3.sutunun basligini yazdirin
        WebElement sutunBaslik=driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[2]"));
        System.out.println(sutunBaslik.getText());

        System.out.println("_______________");


        //  4. Tablodaki tum datalari yazdirin
        WebElement tabloData=driver.findElement(By.xpath("//div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]"));
        System.out.println(tabloData.getText());


        System.out.println("_______________");

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement>satirlar=driver.findElements(By.xpath("//div[@class='rt-td']"));
        List<String>tumSatirlar=new ArrayList<>();
        String [][] satirArr=new String[7][7];

        for (WebElement satirs:satirlar
        ) {
            System.out.print(satirs.getText()+" ");
            tumSatirlar.add(satirs.getText());

        }
        System.out.println();
        System.out.println("************************arr*****************************");
        for (int i = 0; i < 7; i++) {
            satirArr[i][i]=tumSatirlar.get(i);

        }
        System.out.println(Arrays.toString(satirArr));
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------");

        // 3. 3.sutunun basligini yazdirin
        System.out.println();

        WebElement sutun3=driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println(sutun3.getText());
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int sayac=0;
        for (WebElement dolu:satirlar
        ) {
            if(!(dolu.getText().isBlank())){
                sayac++;
            }

        }
        System.out.println(sayac);

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement>satisSayisi=driver.findElements(By.id("close-fixedban"));
        System.out.println("satisSayisi"+satisSayisi.size());
        //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisi=driver.findElements(By.xpath("//div[@class='rt-resizer']"));
        System.out.println("sutun sayisi : "+sutunSayisi.size());

        //  8. Tablodaki 3.kolonu yazdirin
        for (int i = 0; i <=3 ; i++) {
            WebElement kolon3=driver.findElement(By.xpath("//div/div/div[2]/div[2]/div[3]/div[1]"));
            System.out.println("3.kolon : "+ kolon3.getText());
        }


        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
        //     bana datayi yazdirsin
    }
}
