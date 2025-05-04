package techproed.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.CarRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_NegativeLoginTest {
    //Name:
    //US100208_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
    //Acceptance Criteria
    //Customer email: fake@rentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@rentalcars.com not found


    @Test
    public void test01() {

        //https://www.speedyli.com/ sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("carRentalUrl"));

        //Login buttonuna tıklayalım
        CarRentalPage carRentalPage = new CarRentalPage();
        carRentalPage.loginRegisterButton.click();

        //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile login olamadığını test edelim
        carRentalPage.emailTextBox.sendKeys(ConfigReader.getProperty("fakeEmail"));
        carRentalPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fakePassword"));
        carRentalPage.loginButton.click();

        //sayfayı kapatınız
        ReusableMethods.visibleWait(carRentalPage.negativeLoginVerify,10);
        Assert.assertTrue(carRentalPage.negativeLoginVerify.isDisplayed());

        Driver.closeDriver();

    }
}
