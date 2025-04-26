package techproed.tests.day22_pom_excel;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PropertiesUsageTest {

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        //bazi testler yaptik
        Driver.closeDriver();
    }

    @Test
    public void test05() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        //bazi testler yaptik
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        //bazi testler yaptik
        Driver.closeDriver();
    }

    @Test
    public void test03() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        //bazi testler yaptik
        Driver.closeDriver();
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        //bazi testler yaptik
        Driver.closeDriver();
    }


}