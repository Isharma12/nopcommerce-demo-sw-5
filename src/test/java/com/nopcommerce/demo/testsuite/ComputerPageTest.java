package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //click on computer tab
        homePage.selectTopMenu("Computer");
        //Verify "Computer" text
        Assert.assertEquals(computerPage.verifyComputerText(), "Computer",  "Unable to verify link.");

        }

        @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
            //click on computer tab
            homePage.selectTopMenu("Computer");
            //Click on Desktops link
            computerPage.selectFromSublist("Desktops");
            //Verify "Desktops" text
            Assert.assertEquals(desktopsPage.verifyDesktopsText(), "Desktops", "Unable to verify text.");
        }

    @Test(dataProvider = "Build Own Computer", dataProviderClass = TestNG.class, groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String hdd, String os, String software){
        //click on computer tab
        homePage.selectTopMenu("Computer");
        //Click on Desktops link
        computerPage.selectFromSublist("Desktops");
        // Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
        //Select processor
        buildYourOwnComputerPage.selectProcessorFromDropDown(processor);
        //Select "Ram" ram
        buildYourOwnComputerPage.selectRamFromDropDown("ram");
        //select "HDD" hdd
        buildYourOwnComputerPage.selectHDDRadios(hdd);
        //select OS os
        buildYourOwnComputerPage.selectOsRadioButton(os);
        //Select "Software" software
        buildYourOwnComputerPage.selectMicrosoftOffice();
        //Click on "Add to cart" button
        buildYourOwnComputerPage.addToCartButton();
        //Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(buildYourOwnComputerPage.verifyProductHasBeenAddedText(), "The product has been added to your shopping cart", "Unable to verify message.");
    }

}
