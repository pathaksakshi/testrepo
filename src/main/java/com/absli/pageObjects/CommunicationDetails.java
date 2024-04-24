package com.absli.pageObjects;

import com.absli.base.ExtentFactory;
import com.absli.base.TestBase;
import com.absli.base.TestBase;
import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CommunicationDetails extends TestBase {

    public WebDriver driver;
    public WaitUtils wait;

    public CommunicationDetails(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }


    // Communication Details page // 7/6/2023=mayur
    @FindBy(xpath = "//div[@id='preferredLanguage']")
    private WebElement lang;
    @FindBy(xpath = "//input[@id='alternateMobileNumber']")
    private WebElement altnm;
    @FindBy(xpath = "//input[@id='residenceTelephoneNumber']")
    private WebElement resnm;
    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement submit;

    // Communication Details page // 13/6/2023=SAKSHI
    @FindBy(xpath = "//input[@id='mobileNumber']")
    private WebElement insumobno;
        @FindBy(xpath = "//input[@id='emailId']")
    private WebElement insuemail;



    public void SelectpreflangWeb(String PreferredLang) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), lang, 30,"time out to find element on page");
        if(lang.isDisplayed()) {
            lang.click();
        }
        Thread.sleep(1000);
        WebElement LangWebSelection=getDriver().findElement(By.xpath("//li/div/span[text()='"+PreferredLang+"']"));
        if(LangWebSelection.isDisplayed()) {
            wait.waitForElementToBeVisibleweb(getDriver(), LangWebSelection, 30,"time out to find element on page");
            LangWebSelection.click();
            Allure.step("Select the Preferred Language  >"  + PreferredLang);
        }
        else {
            System.out.println("Preferred Language Is not Visible");
        }
    }

    public void enteraltnumber(String AlternateNumber) {
        wait.waitForElementToBeVisibleweb(getDriver(), altnm, 50,"time out to find element on page");
        if (altnm.isDisplayed()) {
            altnm.sendKeys(AlternateNumber);
            Allure.step("Enter the Alternate Number  >"  + AlternateNumber);
        } else {
            System.out.println("Alternate Mobile Number input box is not visible");
        }
    }
    public void enterresnumber(String ResidenceNumber) {
        wait.waitForElementToBeVisibleweb(getDriver(), resnm, 50,"time out to find element on page");
        if (resnm.isDisplayed()) {
            resnm.sendKeys(ResidenceNumber);
            Allure.step("Enter the Residence Number  >"  + ResidenceNumber);
        } else {
            System.out.println("Residence Telephone Number input box is not visible");
        }
    }
    public void clicksubmitBtn(){
        wait.waitforElementToBeClickable(getDriver(), submit, 30);
        if (submit.isDisplayed()) {
            submit.click();
            Allure.step("CLicked On Submit Button ");
        } else {
            System.out.println("Submit button is not visible");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void EnterInsuredMobileNoweb(String InsuredMobno) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), insumobno, 30,"time out to find element on page");
        if (insumobno.isDisplayed()) {
            insumobno.click();
            insumobno.sendKeys(InsuredMobno);
            Allure.step("Enter Insurer Mobile Number  >" + InsuredMobno);
        } else {
            System.out.println("Insurer Mobile number input box is not visible");
        }
    }
    public void EnterInsuredEmailIdweb(String Insuemail) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), insuemail, 30,"time out to find element on page");
        if (insuemail.isDisplayed()) {
            insuemail.click();
            insuemail.sendKeys(Insuemail);
            Allure.step("Enter Insurer Email ID  >" + Insuemail);
        } else {
            System.out.println("Insurer Email ID input box is not visible");
        }
    }
    public void EnterSpouseMobileNoweb(String SpouseMobno) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), insumobno, 30,"time out to find element on page");
        if (insumobno.isDisplayed()) {
            insumobno.click();
            insumobno.sendKeys(SpouseMobno);
            Allure.step("Enter Spouse Mobile Number  >" + SpouseMobno);
        } else {
            System.out.println("Spouse Mobile number input box is not visible");
        }
    }

    public void EnterSpouseEmailIdweb(String SpouseEmail) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), insuemail, 30,"time out to find element on page");
        if (insuemail.isDisplayed()) {
            insuemail.click();
            insuemail.sendKeys(SpouseEmail);
            Allure.step("Enter Spouse Email ID  >" + SpouseEmail);
        } else {
            System.out.println("Spouse Email ID input box is not visible");
        }
    }


}
