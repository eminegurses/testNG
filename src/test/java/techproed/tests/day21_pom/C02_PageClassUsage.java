package techproed.tests.day21_pom;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C02_PageClassUsage {

    @Test
    public void test01() throws InterruptedException {
        //amazon sayfasina gidelim
        Driver.getDriver().get("https://amazon.com");

        //captcha yi asalim
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        //arama kutusunda selenium aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("selenium", Keys.ENTER);

        //sayfayi kapatalim
        Driver.closeDriver();
    }


}