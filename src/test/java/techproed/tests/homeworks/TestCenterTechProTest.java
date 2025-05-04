package techproed.tests.Homeworks;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TestCenterTechProTest {

    @Test
    public void test01() {

        //=======Homework 2=======
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        //Page object Model kullanarak sayfaya giriş yapildigini test edin

        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        TestCenterPage testCenterPage= new TestCenterPage();

        testCenterPage.userName.sendKeys(ConfigReader.getProperty("testCenterUsername"));

        testCenterPage.password.sendKeys(ConfigReader.getProperty("testCenterPassword"));
        testCenterPage.loginButton.click();


       // Assert.assertTrue(testCenterPage.testCenterLoginVerify.isDisplayed());
//        //Sayfadan cikis yap ve cikis yapildigini test et
//
     //  testCenterPage.testCenterLogoutVerify.click();
//
//        Assert.assertEquals(Driver.getDriver().getTitle(), "Login");
//
//         Sayfayı kapatınız
           Driver.closeDriver();
//
//
//
//
//
//
//
  }
}
