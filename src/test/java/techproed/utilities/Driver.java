package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    private Driver() {
        /*
        Driver i page object model de singleton pattern ile kullaniriz, bunu yapabilmek icin
        Driver clasimizdan object olusturulmasini engelledik, böylece project genelinde
        sadece getDriver() methodu uzerinden driver kullanilabilecktir
         */
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }


}