package techproed.tests.day23_excel_dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_CarRentalExcelDDT {


    @Test
    public void test02() {
        String dosyaYolu = "src/test/java/techproed/resources/smoketestdata.xlsx";
        String sayfaIsmi = "Sayfa1";
        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);

        for (int i = 0; i <= excelReader.rowCount(); i++) {
            String email = excelReader.getCellData(i, 0);
            String password = excelReader.getCellData(i, 1);
            System.out.println(email + " " + password);
        }


    }


    @Test
    public void test01() {

        //RentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("carRentalUrl"));

        //Excel dosyamızdaki tüm email ve passwordler ile login olalım ve login olduğumuzu doğrulayalım
        String dosyaYolu = "src/test/java/techproed/resources/smoketestdata.xlsx";
        String sayfaIsmi = "Sayfa1";
        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        CarRentalPage carRentalPage = new CarRentalPage();

        for (int i = 1; i <= excelReader.rowCount(); i++) {

            String email = excelReader.getCellData(i, 0);
            String password = excelReader.getCellData(i, 1);

            carRentalPage.loginRegisterButton.click();
            carRentalPage.emailTextBox.sendKeys(email);
            carRentalPage.passwordTextBox.sendKeys(password);
            carRentalPage.loginButton.click();
            ReusableMethods.waitForSecond(1);
            carRentalPage.loginVerify.click();

            ReusableMethods.visibleWait(carRentalPage.logout,10);

            Assert.assertTrue(carRentalPage.logout.isDisplayed());
            carRentalPage.logout.click();
            ReusableMethods.waitForSecond(1);

            carRentalPage.yesButton.click();
            ReusableMethods.waitForSecond(1);

        }
        Driver.closeDriver();


    }
}