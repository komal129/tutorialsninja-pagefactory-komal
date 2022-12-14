package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    SuccessPage successPage;
    MyAccountPage myAccountPage;
    LogoutPage logoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        successPage = new SuccessPage();
        myAccountPage = new MyAccountPage();
        logoutPage = new LogoutPage();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyRegisterAccount(), "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyReturningCustomer(), "Returning Customer", "Login page not displayed");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Joe");
        registerPage.enterLastName("Jhones");
        registerPage.enterEmail("joejhones@example.com");
        registerPage.enterTelephone("9876543215");
        registerPage.enterPassword("joe123456");
        registerPage.enterConformPassword("joe123456");
        registerPage.clickOnSubcribe();
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();
        //Assert.assertEquals(successPage.verifyYourAccountMessage(), "Your Account Has Been Created!", "Text not displayed");
        successPage.clickOnSucessContinueButton();
        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Not logged out");
        logoutPage.clickOnContinue();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Not logged out");
        logoutPage.clickOnContinue();
    }

}
