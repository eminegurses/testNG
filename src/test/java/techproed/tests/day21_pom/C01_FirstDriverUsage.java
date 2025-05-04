package techproed.tests.day21_pom;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_FirstDriverUsage {

    @Test(groups ="smoke")
    public void test01() {
        Driver.closeDriver();
        Driver.getDriver().get("https://techproeducation.com");
        System.out.println(Driver.getDriver().getTitle());
        System.out.println(Driver.getDriver().getCurrentUrl());
        Driver.closeDriver();

        /*
          Driver driver = new Driver();
        driver.getDriver().get("https://techproeducation.com");

         */

    }
}