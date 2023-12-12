package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //click on Register link
        homePage.clickOnRegisterLink();
        //verify "Register" link
        Assert.assertEquals(registerPage.verifyRegisterText(), "Register", "");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //click on Register link
        homePage.clickOnRegisterLink();
        //click on "Register" button
        registerPage.clickOnRegisterButton();
        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.verifyFirstNameError(), "First name is required.", "First name is required.");
        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.verifyLastNameError(), "Last name is required.", "Unable to verify error.");
        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.verifyEmailError(), "Email is required.", "Unable to verify error.");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyPasswordError(), "Password is required.", "Unable to verify error.");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyConfirmPasswordError(), "Password is required.", "Unable to verify error.");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {

        //Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectGender("Female");
        // Enter firstname
        registerPage.enterFirstName("Prime");
        // Enter lastname
        registerPage.enterLastName("Testing");
        // Select day
        registerPage.dateOfBirthDay("12");
        // Select month
        registerPage.dateOfBirthMonth("February");
        // Select year
        registerPage.dateOfBirthYear("1992");
        // Enter email
        registerPage.enterEmail("Abc123@gmail.com");
        // Enter password
        registerPage.enterPassword("Xyz456");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("Xyz456");
        //  Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify message "Your registration completed"
        Assert.assertEquals(registerPage.verifyRegistrationCompleteMessage(), "Your registration completed","Unable to verify message.");

    }
}