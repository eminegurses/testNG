package techproed.tests.day22_pom_excel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PropertiesUsageTest {

    //Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //Log in by locating the UserName, UserPassword, submitButton elements
    //user=Admin
    //userPassword=admin123
    //Test that the Login Test is successful
    //close the page




    @Test
    public void test01() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourceUserPassword"));
        openSourcePage.loginButton.click();

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        //sayfayi kapatalim
        Driver.closeDriver();


    }
}