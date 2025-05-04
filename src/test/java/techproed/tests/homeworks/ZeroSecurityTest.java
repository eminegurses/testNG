package techproed.tests.Homeworks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroSecurityPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static techproed.utilities.Driver.getDriver;

public class ZeroSecurityTest {

    //=======Homework 1=======

    @Test
    public void test01() {
        getDriver().get(ConfigReader.getProperty("zeroSecurityUrl"));

        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        ZeroSecurityPage zeroSecurityPage = new ZeroSecurityPage();
        SoftAssert softAssert = new SoftAssert();

        Assert.assertTrue(Objects.requireNonNull(getDriver().getTitle()).contains("Personal"),
                "Sayfa 'Personal' içermiyor");

        //2. Sign in butonuna basin
        zeroSecurityPage.zeroBankLoginButton.click();

        //3. Login kutusuna "username" yazin
        zeroSecurityPage.loginBox.sendKeys("username");

        //4. Password kutusuna "password" yazin
        zeroSecurityPage.passwordTextBox.sendKeys("password");

        //5. Sign in tusuna basin
        zeroSecurityPage.submitButton.click();

        getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        zeroSecurityPage.onlineBankingMenu.click();
        ReusableMethods.waitForSecond(2);
        zeroSecurityPage.payBills.click();
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains("Zero"));
        ReusableMethods.waitForSecond(2);


        //7. "Purchase Foreign Currency" tusuna basin
        zeroSecurityPage.purchaseForeignCurrencyButton.click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        ReusableMethods.waitForSecond(10);
        Select currencySelect = new Select(zeroSecurityPage.currencyDropdown);
        currencySelect.selectByVisibleText("Eurozone (euro)");


        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String selectedOption = currencySelect.getFirstSelectedOption().getText();
        softAssert.assertEquals(selectedOption, "Eurozone (euro)");


        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")

        List<WebElement> dropdownList = currencySelect.getOptions();
        List<String> actualList = new ArrayList<>();
        for (WebElement w : dropdownList) {
            actualList.add(w.getText());
        }

        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)",
                "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));


        softAssert.assertEquals(actualList, expectedList);
        softAssert.assertAll();
        Driver.closeDriver();

    }
}