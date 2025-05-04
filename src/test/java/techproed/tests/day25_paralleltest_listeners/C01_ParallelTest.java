package techproed.tests.day25_paralleltest_listeners;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_ParallelTest {

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));
        Driver.closeDriver();
    }


    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));
        Driver.closeDriver();
    }





}
