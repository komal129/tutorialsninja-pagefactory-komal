package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SuccessPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement yourAccountText;
//    @CacheLookup
//    @FindBy(xpath = "//a[contains(text(),'Continue')]")
//    WebElement sucessContinue;
    By sucessContinue = By.xpath("//div[@class='pull-right']/a[text()='Continue']");

    public SuccessPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyYourAccountMessage() {
        //Reporter.log("Verify your Account Message" + yourAccountText.toString());
        return getTextFromElement(yourAccountText);
    }

    public void clickOnSucessContinueButton() {
        Reporter.log("Click on success continue button " + sucessContinue.toString());
        clickOnElement(sucessContinue);
    }

}
