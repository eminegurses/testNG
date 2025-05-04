package techproed.tests.day25_paralleltest_listeners;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderParallelTest {


    @DataProvider(parallel = true)
    public static Object[][] credentials() {
        return new Object[][]{
                {ConfigReader.getProperty("carRentalEmail1"),ConfigReader.getProperty("carRentalPassword1") },
                {ConfigReader.getProperty("carRentalEmail2"),ConfigReader.getProperty("carRentalPassword2") },
                {ConfigReader.getProperty("carRentalEmail3"),ConfigReader.getProperty("carRentalPassword3") },
                {"ayhancan@cars.com", "Aa1234567!"},
                {"beyhancan@cars.com", "Aa1234567!"},
                {"ceyhancan@cars.com", "Aa1234567!"}
        };
    }
    @Test(dataProvider = "credentials")
    public void test01(String email, String password) {

        // CarRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("carRentalUrl"));

        // Login butonuna tıklayalım
        CarRentalPage carRentalPage = new CarRentalPage();
        carRentalPage.loginRegisterButton.click();

        // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        carRentalPage.emailTextBox.sendKeys(email);
        carRentalPage.passwordTextBox.sendKeys(password);
        carRentalPage.loginButton.click();
        carRentalPage.loginVerify.click();
        ReusableMethods.visibleWait(carRentalPage.logout,15);
        Assert.assertTrue(carRentalPage.logout.isDisplayed());

        // Sayfayı kapatalım
        Driver.closeDriver();
    }


}
