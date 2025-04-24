package techproed.tests.day20_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class C03_Priority {

    WebDriver driver;

    @BeforeMethod
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 0)//Default olarak 0 oldugu icin ikinci olarak calisti
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    @Test(priority = 2)//prioritysi en yüksek oldugu icin en son calisti
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test(priority = -1)//prioritysi en düsük oldugu icin ilk olarak bu method calisti
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}