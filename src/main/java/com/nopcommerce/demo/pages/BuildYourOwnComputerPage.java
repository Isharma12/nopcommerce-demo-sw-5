package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {
    @CacheLookup
    @FindBy (id = "product_attribute_1")
    WebElement processorDropDown;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ramDropDown;

    @CacheLookup
    @FindBy(id = "product_attribute_3_6")
    WebElement hdd320GB;

    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hdd400GB;

    @CacheLookup
    @FindBy(id = "product_attribute_4_8")
    WebElement vistaHome;

    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement vistaPremium;

    @CacheLookup
    @FindBy(xpath = "(//label[normalize-space()='Software'])[1]")
    WebElement softwareLabel;

    @CacheLookup
    @FindBy(xpath = "label[for='product_attribute_5_10']")
    WebElement microsoftOffice;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bar-notification success']/p")
    WebElement verifyProductAddedMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bar-notification success']")
    WebElement crossButton;

    public void selectProcessorFromDropDown(String processor){
        Reporter.log("Select processor from drop down list." + processor + "from drop down" + processorDropDown.toString());
        CustomListeners.test.log(Status.PASS, "Select processor from drop down list." + processor);
        selectByVisibleTextFromDropDown(processorDropDown, processor);
    }

    public void selectRamFromDropDown(String ram){
        Reporter.log("Select ram from drop down list." + ram + "from drop down" + ramDropDown.toString());
        CustomListeners.test.log(Status.PASS, "Select ram from drop down list." + ram);
        selectByVisibleTextFromDropDown(ramDropDown, ram);
    }
    public void selectHDDRadios(String hddRadio) {
        Reporter.log("Select HDD radio button." + hddRadio);
        CustomListeners.test.log(Status.PASS, "Select HDD radio button." + hddRadio);
        switch (hddRadio) {
            case "320 GB":
                clickOnElement(hdd320GB);
                break;
            case "400 GB [+$100.00]":
                clickOnElement(hdd400GB);
                break;
            default:
                break;
        }
    }

        public void selectOsRadioButton(String osRadio){
            Reporter.log("Select OS radio button." + osRadio);
            CustomListeners.test.log(Status.PASS, "Select OS radio button." + osRadio);
            switch (osRadio){
                case "Vista Home [+$50.00]":
                    clickOnElement(vistaHome);
                    break;
                case "Vista Premium [+$60.00]":
                    clickOnElement(vistaPremium);
                    break;
                default:
                    break;
            }
        }
        public void selectMicrosoftOffice(){
        Reporter.log("Select microsoft office." + microsoftOffice.toString());
        CustomListeners.test.log(Status.PASS, "select microsoft office.");
        clickOnElement(microsoftOffice);

        }
        public void addToCartButton(){
        Reporter.log("Click on add to cart button." + addToCartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
        clickOnElement(addToCartButton);

        }
        public String verifyProductHasBeenAddedText(){
        Reporter.log("Verify product has been added text." + verifyProductAddedMessage.toString());
        CustomListeners.test.log(Status.PASS, "Verify product has been added.");
        return  getTextFromElement(verifyProductAddedMessage);

        }
        public void closeTheBar(){
        Reporter.log("Close the bar." + crossButton.toString());
        CustomListeners.test.log(Status.PASS, "Close the bar.");
        clickOnElement(crossButton);

        }
        public void buildYourOwnComputer(String processor, String ram, String hdd, String os, String software){
        selectProcessorFromDropDown(processor);
        selectRamFromDropDown(ram);
        selectHDDRadios(hdd);
        selectOsRadioButton(os);
        selectMicrosoftOffice();
        //selectSoftwareType(software);
        }






}






