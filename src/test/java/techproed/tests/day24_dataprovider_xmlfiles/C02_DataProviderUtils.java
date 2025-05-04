package techproed.tests.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C02_DataProviderUtils {

    //https://mehmetualatas.github.io/dataprovider/ adresine gidelim
    //BlackBoxTesting techniques ile Data Driven test yapalim

    @Test(dataProvider = "positiveTestData",dataProviderClass = DataProviderUtils.class)
    public void test01(String age) {

        Driver.getDriver().get("https://mehmetualatas.github.io/dataprovider/");

        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searchBox.sendKeys(age, Keys.TAB,Keys.ENTER);

        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());
        Driver.closeDriver();
    }
}