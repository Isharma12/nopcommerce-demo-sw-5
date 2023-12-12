package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "div[class='page-title'] h1")
    WebElement computersText;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
    WebElement desktopsLink;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Notebooks'][normalize-space()='Notebooks']")
    WebElement notebooksLink;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Software'][normalize-space()='Software']")
    WebElement softwareLink;

    public String verifyComputerText(){
        Reporter.log("Verify computer text." + computersText);
        CustomListeners.test.log(Status.PASS, "Verify computer text.");
        return getTextFromElement(computersText);

    }
    public void selectFromSublist(String subList){
        Reporter.log("Select option from sublist." + subList + "from options");
        CustomListeners.test.log(Status.PASS, "Select option from sublist." +subList);
        switch(subList){
            case "Desktops":
                clickOnElement(desktopsLink);
                break;
            case "Notebooks":
                clickOnElement(notebooksLink);
                break;
            case "Software":
                clickOnElement(softwareLink);
                break;
            default:
                break;
        }
    }






















}
