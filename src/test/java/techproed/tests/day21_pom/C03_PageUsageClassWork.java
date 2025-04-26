package techproed.tests.day21_pom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.Driver;

public class C03_PageUsageClassWork {

    //Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //Log in by locating the UserName, UserPassword, submitButton elements
    //user=Admin
    //userPassword=admin123
    //Test that the Login Test is successful
    //close the page


    @Test
    public void testtest01() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullanici=Admin
        //kullaniciSifre=admin123
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys("Admin");
        openSourcePage.password.sendKeys("admin123");
        openSourcePage.loginButton.click();


        //Login Testinin basarili oldugunu test edelim



        //sayfayı kapatalim

    }
}