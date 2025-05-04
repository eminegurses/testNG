package techproed.tests.day23_excel_dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C02_CarRentalExcelTest {

    @Test
    public void test01() {

        //RentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("carRentalUrl"));

        //Login buttonuna tıklayalım
        CarRentalPage carRentalPage = new CarRentalPage();
        carRentalPage.loginRegisterButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String dosyaYolu = "src/test/java/techproed/resources/smoketestdata.xlsx";
        String sayfaIsmi = "Sayfa1";
        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);

        String email = excelReader.getCellData(1, 0);
        String password = excelReader.getCellData(1, 1);

        carRentalPage.emailTextBox.sendKeys(email);
        carRentalPage.passwordTextBox.sendKeys(password);
        carRentalPage.loginButton.click();

        //Girilen email ile giriş yapıldığını doğrulayın
        ReusableMethods.waitForSecond(1);
        carRentalPage.loginVerify.click();

        ReusableMethods.waitForSecond(1);
        carRentalPage.profile.click();

        String actualEmail = carRentalPage.profileEmail.getText();
        Assert.assertEquals(actualEmail,email);

        //sayfayı kapatalım
        Driver.closeDriver();


    }
}