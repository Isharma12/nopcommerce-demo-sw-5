package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();

    }
    @Test(groups = {"sanity", "regression"})
    public void UserShouldNavigateToLoginPageSuccessFully() {

        //click on login link
        homePage.clickOnLoginLink();

        //verify that "Welcome, Please Sign In! message display
        Assert.assertEquals(loginPage.verifyWelcomeText(), "Welcome, Please Sign In!", "Unable to verify text.");
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials(){
        //click on login link
        homePage.clickOnLoginLink();
        //enter EmailId
        loginPage.enterEmail("Abc123@gmail.com");
        //Enter password
        loginPage.enterPassword("Xyz456");
        //Click on login button
        loginPage.clickOnLoginButton();
        //Verify that the error message
        Assert.assertEquals(loginPage.verifyErrorMessage(),"Login was unsuccessful. Please correct the errors and try again. +" +
                "                \"No customer account found, Unable to verify message");

    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginSuccessfullyWithValidCredential(){

        //click on login link
        homePage.clickOnLoginLink();
        //Enter email id
        loginPage.enterEmail("Abc123@gmail.com");
        //Enter Password
        loginPage.enterPassword("Xyz456");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify the LogOut link is display
        Assert.assertEquals(loginPage.verifyErrorMessage(), "Log out", "Unable to verify link.");
    }
    @Test(groups = "regression")
            public void verifyThatUserShouldLogOutSuccessfully(){
        //click on login link
        homePage.clickOnLoginLink();
        //Enter email id
        loginPage.enterEmail("Abc123@gmail.com");
        //Enter Password
        loginPage.enterPassword("Xyz456");
        //Click on Login Button
        loginPage.clickOnLogoutLink();
        //Verify that Login link Display
        Assert.assertEquals(homePage.verifyLoginLinkIsDisplayed(), "Log in", "Unable to verify link.");

    }

}
