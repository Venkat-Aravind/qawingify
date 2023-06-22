package PageObjects;

import Actions.PreDefinedActions;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }
	@FindBy(css="#username")
	private WebElement UserName;
    @FindBy(css="#password")
	private WebElement Password;
    @FindBy(css="#log-in")
	private WebElement LoginBtn;
	@FindBy(xpath="//div[@class='logo-w']")
	private WebElement Logo;




	@FindBy(css=".auth-header")
	private WebElement VerifyText;
	@FindBy(xpath="//div[text()='Password must be present']")
    private WebElement WarningMessage1;

    @FindBy(xpath="//div[text()='Username must be present']")
	private WebElement WarningMessage2;

	@FindBy(xpath="//div[text()='Both Username and Password must be present ']")
	private WebElement WarningMessage3;

	@FindBy(xpath="//input[@class='form-check-input']")
	private WebElement RememberMeCheckBox;

	@FindBy(css="a:nth-child(2)")
	private WebElement FacebookLink;

	@FindBy(css="img[src='img/twitter.png']")
	private WebElement TwitterLink;

	@FindBy(css="img[src='img/linkedin.png']")
	private WebElement LinkedlnLink;

	@FindBy(xpath="//div[@class='pre-icon os-icon os-icon-user-male-circle']")
	private WebElement IconUserName ;

	@FindBy(xpath="//div[@class='pre-icon os-icon os-icon-fingerprint']")
	private WebElement IconPassword;

	@FindBy(xpath="//label[text()='Username']")
	private WebElement UserNameText;

	@FindBy(xpath="//label[text()='Password']")
	private WebElement PasswordText;

	@FindBy(xpath="//button[text()='Log In']")
	private WebElement LogInBtnText;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement CheckBox;

	@FindBy(xpath="//label[@class='form-check-label']")
	private WebElement RememberMeText;





    public void setLoginPage(String email, String pass)
    {
        PreDefinedActions.sendKeysMethod(UserName, email);
        PreDefinedActions.sendKeysMethod(Password, pass);
        PreDefinedActions.clickMethod(LoginBtn, true);
    }
    public boolean IsLogoDisplayed()
    {
       return Logo.isDisplayed();

    }
    public boolean IsFbLinksDisplayed()
    {
        return FacebookLink.isEnabled();

    }
    public boolean IsTwitterLinksDisplayed()
    {
        return TwitterLink.isEnabled();
    }
    public boolean IsLinkedlnLinksDisplayed()
    {
        return LinkedlnLink.isEnabled();
    }
    public void setNavigateBack()
    {
        PreDefinedActions.navigateBack();
    }
    public String getAttributeMethod()
    {
       return  UserName.getAttribute("value");

    }
    public boolean IconOfUserNameIsDisplayed()
    {
        return IconUserName.isDisplayed();
    }
    public boolean IconOfPasswordIsDisplayed()
    {
        return IconPassword.isDisplayed();
    }

    public String textIsDisplayed()
    {
        return PreDefinedActions.getText(VerifyText);
    }
    public String getWarningMessageText1()
    {
       return  PreDefinedActions.getText(WarningMessage1);
    }
    public String getWarningMessageText2()
    {
        return  PreDefinedActions.getText(WarningMessage2);
    }
    public String getWarningMessageText3()
    {
        return  PreDefinedActions.getText(WarningMessage3);
    }
    public void clickRememberMe()
    {
        PreDefinedActions.clickMethod(RememberMeCheckBox, true);
    }
    public String verifyUserNamePlaceHolder()
    {
        return UserName.getAttribute("placeholder");
    }
    public String verifyPasswordPlaceHolder()
    {
       return Password.getAttribute("placeholder");
    }
    public boolean IsVerifyUserNameDisplayed() {
       return  UserNameText.isDisplayed();
    }
    public boolean  IsVerifyPasswordDisplayed()
    {
        return PasswordText.isDisplayed();
    }
    public boolean IsVerifyLoginBtnDisplayed()
    {
        return LogInBtnText.isDisplayed();
    }
    public boolean IsVerifyCheckBoxDisplayed()
    {
        return CheckBox.isDisplayed();
    }
    public boolean IsVerifyRemMeTextDisplayed()
    {
       return  RememberMeText.isDisplayed();
    }



}
