package techproed.tests.day20_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethods {


    WebDriver driver;

    @BeforeClass
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void amazonTitleTest01() throws InterruptedException {
        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //captcha yi asiyoruz
        driver.navigate().refresh();
        driver.navigate().refresh();
        Thread.sleep(1000);

        //amazon sayfa basliginda Amazon icerdigini doğrulayin
        Assert.assertTrue(driver.getTitle().contains("RAmazon"));

        //arama kutusunda testng aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("testng", Keys.ENTER);
    }

    @Test(dependsOnMethods = "amazonTitleTest01")
    public void amazonTitleTest02() throws InterruptedException {
        Thread.sleep(2000);
        //basligin testng icerdigini test edelim
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("testng"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}