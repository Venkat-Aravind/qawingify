package TestScripts;
import Base.BaseClass;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class VerifyMainTest extends BaseClass {
    @Test(description = "Login using valid credentials ", priority = 1)
    public void TC_001() {
        LoginPage page = new LoginPage();
        page.textIsDisplayed();
        Assert.assertEquals(page.textIsDisplayed(), "Login Form", "Login Form text is not displayed at the login-page of the site.");
        page.setLoginPage("ishakeshri330@gmail.com", "qazxsw@123");
    }
    @Test(description="Verify logo is present on login-page of the site")
    public void TC_002()
    {
        LoginPage page= new LoginPage();
        Assert.assertTrue(page.IsLogoDisplayed(), "Logo is not displayed at the login-page");
    }
    @Test(description="Verify twitter, linkedln, and facebook link is displayed at login-page")
    public void TC_003()
    {
        LoginPage page= new LoginPage();
        Assert.assertTrue(page.IsLinkedlnLinksDisplayed(), "Linked-ln link is not displayed at the login-page of the site.");
        Assert.assertTrue(page.IsTwitterLinksDisplayed(), "Twitter link is not displayed at the login-page of the site");
        Assert.assertTrue(page.IsFbLinksDisplayed(), "Fb link is not displayed at the login-page of the site");
    }
    @Test(description="Verify username, password, login button, remember me and the check-box is enabled ")
    public void TC_004()
    {
        LoginPage page= new LoginPage();
        Assert.assertTrue(page.IsVerifyUserNameDisplayed(), "Username text is not displayed ");
        Assert.assertTrue(page.IsVerifyPasswordDisplayed(), "Password text is not displayed");
        Assert.assertTrue(page.IsVerifyRemMeTextDisplayed(), "Remember me text is not displayed");
        Assert.assertTrue(page.IsVerifyLoginBtnDisplayed(), "Login Button is not displayed");
        Assert.assertTrue(page.IsVerifyCheckBoxDisplayed(), "Checkbox of remember me box is not displayed");


    }
    @Test(description= "Login passing email and blank password", priority=2)
    public void TC_005()
        {
            LoginPage loginPage= new LoginPage();
            loginPage.setLoginPage("ishakeshri330@gmail.com", "");
            Assert.assertEquals(loginPage.getWarningMessageText1(), "Password must be present","Warning message is not displayed at the login-page");
        }
        @Test(description= "Login passing blank email and valid password", priority=3)
         public void TC_006()
        {
        LoginPage loginPage= new LoginPage();
        loginPage.setLoginPage("", "abxc@123");
        Assert.assertEquals(loginPage.getWarningMessageText2(),"Username must be present", "Warning message is not displayed at the login-page");
    }
    @Test(description= "Blank email and blank password", priority=4)
    public void TC_007()
    {
        LoginPage loginPage= new LoginPage();
        loginPage.setLoginPage("", "");
        Assert.assertEquals(loginPage.getWarningMessageText3(), "Both Username and Password must be present", "Warning message is not displayed at the login-page");
    }
    @Test(description = "Enter email, password, click RememberMe, and click on LoginBtn", priority = 5)
    public void TC_008() {
        LoginPage page = new LoginPage();
        page.textIsDisplayed();
        Assert.assertEquals(page.textIsDisplayed(), "Login Form", "Login Form text is not displayed at the login-page of the site.");
        page.clickRememberMe();
        page.setLoginPage("ishakeshri330@gmail.com", "qazxsw@123");
    }
    @Test(description= "Enter email and password, click on login Button , Click on Amount header, and check sorting of the list", priority=6)
    public void TC_009()
    {
        LoginPage page = new LoginPage();
        page.textIsDisplayed();
        Assert.assertEquals(page.textIsDisplayed(), "Login Form", "Login Form text is not displayed at the login-page of the site.");
        page.setLoginPage("ishakeshri330@gmail.com", "qazxsw@123");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.AmountClick();
        System.out.println(dashboardPage.getAmountList());
        System.out.println(dashboardPage.getSortingAmountList());
        Assert.assertEquals(dashboardPage.getAmountList(), dashboardPage.getSortingAmountList(), "Expected amount match with the actual amounts");

    }
    @Test(description="Verify passing login credentials , click and check remember me checkbox functionality")
    public void TC_010()
    {
        LoginPage page= new LoginPage();
        page.clickRememberMe();
        page.setLoginPage("ishakeshri330@gmail.com", "qazxsw@123");
        page.setNavigateBack();
        page.getAttributeMethod();
        System.out.println(page.getAttributeMethod());
        Assert.assertEquals(page.getAttributeMethod(), "ishakeshri330@gmail.com", "Email-id is not saved or remember me functionality is not working");
    }
    @Test(description="Verify logo of username and password is present on the login-page of the site")
    public void TC_011()
    {
        LoginPage page= new LoginPage();
        Assert.assertTrue(page.IconOfUserNameIsDisplayed(), "Icon of username is not displayed at login-page");
        Assert.assertTrue(page.IconOfPasswordIsDisplayed(), "Icon of password is not displayed at login-page");
    }
    @Test(description="Verify placeholders is present on login-page fields")
    public void TC_012()
    {
        LoginPage page= new LoginPage();
        Assert.assertEquals(page.verifyPasswordPlaceHolder(), "Enter your password", "Placeholder of username field is not displayed on the login-page");
        Assert.assertEquals(page.verifyUserNamePlaceHolder(), "Enter your username",  "Placeholder of password field is not displayed on the login-page");
    }


}








































