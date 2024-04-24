package com.absli.pageObjects;
import com.absli.Listner.AllureListener;
import com.absli.base.*;

import com.absli.utils.WaitUtils;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;




public class RandAPage extends TestBase  {
    public WebDriver driver;
    public WaitUtils wait;


    public RandAPage(WebDriver driver)
    {
        PageFactory.initElements(getDriver(), this);
    }

    //RNA page(SAKSHI) //5-7-2023
    @FindBy(xpath = "//input[@name='userAgreementStatus']")
    private WebElement RandAcheckbox;

    @FindBy(xpath = "//button[@name='ACCEPT']")
    private WebElement AgreeBtn ;

    @FindBy(xpath = " //button[@name='OK']")
    private WebElement AlertOKBtn ;


    public void ClickOnRandACheckboxWeb() {
        wait.waitForElementToBeVisibleweb(getDriver(), RandAcheckbox, 10, "Element is Not Display");
        if (RandAcheckbox.isEnabled()) {
            RandAcheckbox.click();
            Allure.step("Clicked on R&A check box");
        } else {
            System.out.println("R&A check box is not visible");
        }
    }

    public void ClickOnAgreeButtonWeb() {
        wait.waitForElementToBeVisibleweb(getDriver(), AgreeBtn, 10, "Element is Not Display");
        if (AgreeBtn.isEnabled()) {
            AgreeBtn.click();
            Allure.step("Clicked on Agree Btn");
        } else {
            System.out.println("Agree Btn is not visible");
        }
    }

    public void ClickOnAlertokButtonWeb() {
        wait.waitForElementToBeVisibleweb(getDriver(), AlertOKBtn, 10, "Element is Not Display");
        if (AlertOKBtn.isEnabled()) {
            AlertOKBtn.click();
            Allure.step("Clicked on OK Btn");
        } else {
            System.out.println("OK Btn is not visible");
        }
    }

}