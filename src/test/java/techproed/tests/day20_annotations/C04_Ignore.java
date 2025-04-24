package techproed.tests.day20_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Ignore//genellikle gecici olarak bir testi devre dısı bırakmak istersek bunu kullanabiliriz
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    @Test(enabled = false)//bu methodu devre dısı bıraktık
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}