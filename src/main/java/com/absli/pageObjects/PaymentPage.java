package com.absli.pageObjects;

import com.absli.Listner.AllureListener;
import com.absli.base.*;

import com.absli.utils.WaitUtils;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import java.io.IOException;


public class PaymentPage extends TestBase {
    public WebDriver driver;
    public WaitUtils wait;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    //SASKHI
    @FindBy(xpath = "(//input[@type='file'])[1]")
    private WebElement uploadcheque;
    @FindBy(xpath = "(//input[@type='file'])[2]")
    private WebElement uploadFTimg;
    @FindBy(xpath = "//input[@id='chequeDDNo']")
    private WebElement cheqddno;
    @FindBy(xpath = "//input[@id='dd']")
    private WebElement cheqddday;
    @FindBy(xpath = "//input[@name='month']")
    private WebElement cheddmonth;
    @FindBy(xpath = "//input[@name='year']")
    private WebElement cheqddyear;
    @FindBy(xpath = "//input[@id='ifscCode']")
    private WebElement cheqddifsc;
    @FindBy(xpath = "(//span[text()='Submit'])[1]")
    private WebElement cheqddsubmit;
    @FindBy(xpath = "//span[contains(text(), 'Next')]")
    private WebElement nextbutton;
    @FindBy(xpath = "//div[contains(text(),'CHEQUE / DEMAND DRAFT')]")
    private WebElement cheqddtab;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement declarationdd;
    @FindBy(xpath = "//button[@name='DO IT LATER']")
    private WebElement paydoitlater;
    @FindBy(xpath = "(//div[contains(text(),'FUND TRANSFER')])[1]")
    private WebElement fundft;
    @FindBy(xpath = "//input[@name='policyDetails[0].policyNo']")
    private WebElement ftpolicy;
    @FindBy(xpath = "//input[@name='policyDetails[0].policyAmount']")
    private WebElement ftamount;
    @FindBy(xpath = "//button//span[contains(text(), 'SAVE')]")
    private WebElement fundsave;
    @FindBy(xpath = "//button//span[contains(text(), 'REDEEM')]")
    private WebElement fundredeem;
    
    
    //NetBanking Vijay========
    
    @FindBy(xpath = "//div[contains(text(),'Net Banking')]")
    private WebElement NetBanking;
    
    @FindBy(xpath = "//div[contains(text(),'Credit Card')]")
    private WebElement CreditCard;
    
    @FindBy(xpath = "//div[contains(text(),'Debit Card')]")
    private WebElement DebitCard;
    
    @FindBy(xpath = "//span[contains(text(),'Pay Now')]")
    private WebElement PayNowBTN;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void UploadChequeAndDDImgweb() throws InterruptedException{
        String destination = System.getProperty("user.dir") + "//Document//download.jpg";
        wait.WaitTime(2);
        uploadcheque.sendKeys(destination);
        Allure.step( "Failed to upload file...Upload Button is not Display");
    }

    public void EnterChequeDDNoWeb(String ChequeDDNo) {
        wait.waitForElementToBeVisibleweb(getDriver(), cheqddno, 20, "Element is Not Display");
        if(cheqddno.isDisplayed()) {
            cheqddno.sendKeys(ChequeDDNo);
            Allure.step("Enter Cheque No OR DD No As=====>"+ChequeDDNo);
        }else {
            Allure.step( " Cheque Or Demand Draft No is not display ");
        }
    }

    public void EnterDDMMYYONCDDWeb(String CDDday,String CDDMonth,String CDDYear ) {
        wait.waitforElementToBeClickable(getDriver(), cheqddday, 100);
        cheqddday.click();
        cheqddday.sendKeys(CDDday);
        Allure.step( "Enter Cheque Date On(day) As=====> "+CDDday);

        wait.waitforElementToBeClickable(getDriver(),cheddmonth,100);
        cheddmonth.click();
        cheddmonth.sendKeys(CDDMonth);
        Allure.step( "Enter Cheque Date On (month) As=====> "+CDDMonth);

        cheqddyear.click();
        cheqddyear.sendKeys(CDDYear);
        Allure.step("Enter Cheque Date On (year) As=====> "+CDDYear);

    }

    public void EnterIFSCCodeOnCDDWeb(String CDDIFSCcode) {
        wait.waitForElementToBeVisibleweb(getDriver(), cheqddifsc, 20, "Element is Not Display");
        if(cheqddifsc.isDisplayed()) {
            cheqddifsc.click();
            cheqddifsc.sendKeys(CDDIFSCcode);
           Allure.step( "Enter  IFSC Code As >>>"+CDDIFSCcode);
        }else {
            Allure.step(" IFSC Filed Is Not Display");
        }
    }
    public void ClickCDDPaymentSubmitBTNweb() throws InterruptedException {
        TestUtil.scrollToElement(getDriver(),getDriver().findElement(By.xpath("(//span[text()='Submit'])[1]")));
        TestUtil.verifybgColor(cheqddsubmit, driver);
        if(cheqddsubmit.isDisplayed()) {
            cheqddsubmit.click();
           Allure.step("Click on Submit On CDD Payment ");
        }else {
           Allure.step( "Submit  Button On CDD Payment is not display ");
        }
    }
    public void Nextbutton() {
        wait.waitForElementToBeVisibleweb(getDriver(), nextbutton, 10, "Element is Not Display");
        if (nextbutton.isEnabled()) {
            nextbutton.click();
            Allure.step("Clicked on next button on payment");
        } else {
            System.out.println("next button not visible");
        }
    }

    public void UploadDECLARATIONFORMImgweb() throws InterruptedException{
        String destination= System.getProperty("user.dir")+"\\Document\\download.jpg";
        declarationdd.sendKeys(destination);
        Allure.step( "Failed to upload file...Upload Button is not Display");
    }

    public void ClickOnChequeAndDDModeweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), cheqddtab, 20, "Element is Not Display");
        if(cheqddtab.isDisplayed()) {
            cheqddtab.click();
            Allure.step("Click Or Select CHEQUE / DEMAND DRAFT  Payment Mode ");
        }else {
           Allure.step( "Payment Mode button is not display ");
        }
    }

    public void ClickpaymentDoitLaterbutton() {
        wait.waitForElementToBeVisibleweb(getDriver(), paydoitlater, 10, "Element is Not Display");
        if (paydoitlater.isDisplayed()) {
            paydoitlater.click();
            Allure.step("Clicked on do it later button on Payment");
        } else {
            System.out.println("do it later button not visible");
        }
    }

    ///////////////////////////// Fund Transfer /////////////////////////////////////////////////////////

    public void ClickOnFundTransferModeweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), fundft, 20, "Element is Not Display");
        if(fundft.isDisplayed()) {
            fundft.click();
            Allure.step("Click On Fund Transfer Payment Mode ");
        }else {
            Allure.step( "Payment Mode button is not display ");
        }
    }

    public void UploadFundtransferImgweb() throws InterruptedException{
        String destination = System.getProperty("user.dir") + "//Document//download.jpg";
        wait.WaitTime(2);
        uploadFTimg.sendKeys(destination);
        Allure.step( "Failed to upload file...Upload Button is not Display");
    }

    public void EnterpolicyNumberFTWeb(String PolicyNumber) {
        wait.waitForElementToBeVisibleweb(getDriver(), ftpolicy, 20, "Element is Not Display");
        if(ftpolicy.isDisplayed()) {
            ftpolicy.click();
            ftpolicy.sendKeys(PolicyNumber);
            Allure.step( "Enter PolicyNumber As >>>"+PolicyNumber);
        }else {
            Allure.step(" Policy Number Filed Is Not Display");
        }
    }
    public void EnterAmountFTWeb(String BalamountValue) {
        wait.waitForElementToBeVisibleweb(getDriver(), ftamount, 20, "Element is Not Display");
        if(ftamount.isDisplayed()) {
            ftamount.click();
            ftamount.sendKeys(BalamountValue);
            Allure.step( "Enter Amount FT As >>>"+BalamountValue);
        }else {
            Allure.step(" Amount FT Filed Is Not Display");
        }
    }
    public void ClickOnFTsavebuttonweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), fundsave, 20, "Element is Not Display");
        if(fundsave.isDisplayed()) {
            fundsave.click();
            Allure.step("Click On Fund Transfer Save Button");
        }else {
            Allure.step( "Fund Transfer Save button is not display ");
        }
    }
    public void ClickOnFTredeembuttonweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), fundredeem, 20, "Element is Not Display");
        if(fundredeem.isDisplayed()) {
            fundredeem.click();
            Allure.step("Click On Fund Transfer REDEEM Button");
        }else {
            Allure.step( "Fund Transfer REDEEM button is not display ");
        }
    }
//======================================NetBanking Vijay=================
    public void ClickOnNetBankingModeweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), NetBanking, 5, "Element is Not Display");
        if(NetBanking.isDisplayed()) {
        	NetBanking.click();
            Allure.step("Click Or Select Net Banking  Payment Mode ");
        }else {
           Allure.step( "Payment Mode button is not display ");
        }
    }

    public void ClickOnCreditCardModeweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), CreditCard, 5, "Element is Not Display");
        if(CreditCard.isDisplayed()) {
        	CreditCard.click();
            Allure.step("Click Or Select Credit card Payment Mode ");
        }else {
           Allure.step( "Payment Mode button is not display ");
        }
    }
    public void ClickOnDebitCardModeweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), DebitCard, 5, "Element is Not Display");
        if(DebitCard.isDisplayed()) {
        	DebitCard.click();
            Allure.step("Click Or SelectDebit card Payment Mode ");
        }else {
           Allure.step( "Payment Mode button is not display ");
        }
    }
    public void ClickOnPaymentPayNowBTNweb() {
        wait.waitForElementToBeVisibleweb(getDriver(), PayNowBTN, 5, "Element is Not Display");
        if(PayNowBTN.isDisplayed()) {
        	PayNowBTN.click();
            Allure.step("Click Or SelectDebit card Payment Mode ");
        }else {
           Allure.step( "Payment Mode button is not display ");
        }
    }

    // net banking payment method //
    @FindBy(xpath = "//input[@name='ctl00$m$g_4b5b5f7b_0a8c_4c23_9eda_248459aab3a2$ctl00$btnSuccess']")
    private WebElement sucessbtn;
    @FindBy(xpath = "//input[@name='ctl00$m$g_4b5b5f7b_0a8c_4c23_9eda_248459aab3a2$ctl00$btnFail']")
    private WebElement failbtn;

    public void selectpaymentmethodNB(String PaymentType) {
        WebElement nbmethodselect=getDriver().findElement(By.xpath("//div[@role='group']/button[@value='"+PaymentType+"']"));
        wait.waitforElementToBeClickable(getDriver(), nbmethodselect, 30);
        if (nbmethodselect.isEnabled()) {
            nbmethodselect.click();
        }
    }
    public void selectsuccessbtnNB() {
        wait.waitforElementToBeClickable(getDriver(), sucessbtn, 30);
        if (sucessbtn.isEnabled()) {
            sucessbtn.click();
        }
    }
    public void selectfailbtnNB() {
        wait.waitforElementToBeClickable(getDriver(), failbtn, 30);
        if (failbtn.isEnabled()) {
            failbtn.click();
        }
    }

}