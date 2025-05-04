package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class ZeroSecurityPage {

    public WebElement signInButton;

    public ZeroSecurityPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//button[@id='signing_button']")
    public WebElement zeroBankLoginButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "(//span[@class='headers'])[4]")
    public WebElement payBills;

    @FindBy(xpath = "//a[@href='#ui-tabs-3']")
    public WebElement purchaseForeignCurrencyButton;

    @FindBy(css = "#pc_currency") // CSS Selector kullanımı
    public WebElement currencyDropdown;

    public void selectCurrency(String currency) {
        purchaseForeignCurrencyButton.click();
        ReusableMethods.waitForSecond(2);
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText(currency);
    }

    public List<String> getCurrencyOptions() {
        Select select = new Select(currencyDropdown);
        List<String> options = new ArrayList<>();
        select.getOptions().forEach(option -> options.add(option.getText()));
        return options;
    }




}