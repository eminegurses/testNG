package techproed.tests.day24_dataprovider_xmlfiles;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_DataProviderDataDrivenTest {

    @DataProvider
    public static Object[][] credentials() {
        return new Object[][]{
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
        Assert.assertTrue(carRentalPage.logout.isDisplayed());
        // Sayfayı kapatalım
        Driver.closeDriver();


    }
}