package com.absli.pageObjects;

import com.absli.base.ExtentFactory;
import com.absli.base.TestBase;
import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;



public class AddressDetalis extends TestBase {


    public WebDriver driver;
    public WaitUtils wait;

    public AddressDetalis(WebDriver driver) {PageFactory.initElements(getDriver(), this);}

    // Address Details page // 8/6/2023=mayur

    @FindBy(xpath = "//div[@id='addTypeID']")
    private WebElement commaddtyp;
    @FindBy(xpath = "//input[@id='add3Id']")
    private WebElement coma;
    @FindBy(xpath = "//input[@id='landmark']")
    private WebElement comlnd;
    @FindBy(xpath = "//button[@name='CONFIRM']")
    private WebElement addconf;
    @FindBy(xpath = "//input[@id='isSameAsComAdd']")
    private WebElement permanentaddchkbox;

    @FindBy(xpath = "//div[@id='perAddTypeID']")
    private  WebElement permanentaddtype;

    @FindBy(xpath = "//input[@id='perAddPinId']")
    private  WebElement permanentpincode;

    @FindBy(xpath = "//input[@id='perAdd1Id']")
    private WebElement permanentadd1;

    @FindBy(xpath = "//input[@id='perAdd2Id']")
    private WebElement permanentadd2;

    @FindBy(xpath = "//input[@id='perAdd3Id']")
    private WebElement permanentadd3;

    @FindBy(xpath = "//input[@id='perLandmark']")
    private WebElement permanentlandmark;

    @FindBy(xpath = "//input[@id='perCity']")
    private WebElement permanentcity;

//======================
    @FindBy(xpath = "//input[contains(@name,'isSameAsComAdd')]")
    private WebElement permanentAddCheckBox;
    
    @FindBy(xpath = "(//input[@name='perAddPinId'])[1]")
    private WebElement pinCodeInputWeb;
    
    @FindBy(xpath = "(//input[@id='perAdd1Id'])[1]")
    private WebElement validAddressOne;
    
    @FindBy(xpath = "(//*[@id='perAddTypeID'])")
    private WebElement perAddDroupDown;
    

    @FindBy(xpath = "(//*[@id='perCity'])")
    private WebElement CityName;
    
    
    public void SelectcommaddtypeWeb(String CommAddressType) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), commaddtyp, 50,"time out to find element on page");
        if(commaddtyp.isDisplayed()) {
            commaddtyp.click();
        }
        wait.WaitTime(1);
        WebElement Selectaddresstype =getDriver().findElement(By.xpath("//ul/li//span[text()='"+CommAddressType+"']"));
        wait.waitForElementToBeVisibleweb(getDriver(), Selectaddresstype, 50,"time out to find element on page");
        if(Selectaddresstype.isDisplayed()){
            Selectaddresstype.click();
            Allure.step("Select Communication Address type  >"  + CommAddressType);
        }else {
            System.out.println("Communication Type of Address DropDown is not visible");
        }
    }

    public void entercommadd3(String CommAddress3) {
        wait.waitForElementToBeVisibleweb(getDriver(), coma, 50,"time out to find element on page");
        if (coma.isDisplayed()) {
            coma.sendKeys(CommAddress3);
            Allure.step("Enter Communication Address 3  >"  + CommAddress3);
        } else {
            System.out.println("Communication Address Line 3 input box is not visible");

        }
    }
    public void entercommlandmark(String CommLandmark) {
        wait.waitForElementToBeVisibleweb(getDriver(), comlnd, 50,"time out to find element on page");
        if (comlnd.isDisplayed()) {
            comlnd.sendKeys(CommLandmark);
            Allure.step("Enter the Landmark In communication Address  >"  + CommLandmark);
        } else {
            System.out.println("Communication Address Landmark input box is not visible");
        }
    }

    public void clickConfirmcapital(){
        wait.waitForElementToBeVisibleweb(getDriver(), addconf, 30,"time out to find element on page");
        if (addconf.isDisplayed()) {
            addconf.click();
            Allure.step("Clicked On Confirm Button");
        } else {
            System.out.println("CONFIRM button is not visible");

        }
    }

    public void PermanentAddresschkbox() {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentaddchkbox, 10, "Element is Not Display");
        if (permanentaddchkbox.isEnabled()) {
            permanentaddchkbox.click();
            Allure.step("Clicked on permanent address checkbox");
        } else {
            System.out.println("permanent address checkbox not visible");
        }
    }

    public void SelectpermanentaddtypeWeb(String PermanentAddress) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentaddtype, 50,"time out to find element on page");
        if(permanentaddtype.isDisplayed()) {
            permanentaddtype.click();
        }
        wait.WaitTime(1);
        WebElement Selectaddresstype =getDriver().findElement(By.xpath("//ul/li[@data-value='"+PermanentAddress+"']"));
        wait.waitforElementToBeClickable(getDriver(), Selectaddresstype, 100);
        if(Selectaddresstype.isDisplayed()){
            Selectaddresstype.click();
            Allure.step("Select Communication Address type  >"  + PermanentAddress);
        }else {
            System.out.println("Permanent Type of Address DropDown is not visible");
        }
    }

    public void enterpermanentpincode(String PermanentPincode) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentpincode, 50,"time out to find element on page");
        if (permanentpincode.isDisplayed()) {
            permanentpincode.sendKeys(PermanentPincode);
            Allure.step("Enter the Pincode in permanent Address  >"  + PermanentPincode);
        } else {
            System.out.println("Pincode in permanent Address is not visible");
        }
    }

    public void enterpermanentadd1(String PermanentAddress1) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentadd1, 50,"time out to find element on page");
        if (permanentadd1.isDisplayed()) {
            permanentadd1.sendKeys(PermanentAddress1);
            Allure.step("Enter the PermanentAddress1 in permanent Address  >"  + PermanentAddress1);
        } else {
            System.out.println("PermanentAddress1 in permanent Address is not visible");
        }
    }

    public void enterpermanentadd2(String PermanentAddress2) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentadd2, 50,"time out to find element on page");
        if (permanentadd2.isDisplayed()) {
            permanentadd2.sendKeys(PermanentAddress2);
            Allure.step("Enter the PermanentAddress2 in permanent Address  >"  + PermanentAddress2);
        } else {
            System.out.println("PermanentAddress2 in permanent Address is not visible");
        }
    }
    public void enterpermanentadd3(String PermanentAddress3) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentadd3, 50,"time out to find element on page");
        if (permanentadd3.isDisplayed()) {
            permanentadd3.sendKeys(PermanentAddress3);
            Allure.step("Enter the PermanentAddress3 in permanent Address  >"  + PermanentAddress3);
        } else {
            System.out.println("PermanentAddress3 in permanent Address is not visible");
        }
    }
    public void enterpermanentlandmark(String PermanentLandmark) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentlandmark, 50,"time out to find element on page");
        if (permanentlandmark.isDisplayed()) {
            permanentlandmark.sendKeys(PermanentLandmark);
            Allure.step("Enter the Landmark in permanent Address  >"  + PermanentLandmark);
        } else {
            System.out.println("Landmark in permanent Address is not visible");
        }
    }

    public void enterpermanentcity(String PermanentCity) {
        wait.waitForElementToBeVisibleweb(getDriver(), permanentcity, 50,"time out to find element on page");
        if (permanentcity.isDisplayed()) {
            permanentcity.sendKeys(PermanentCity);
            Allure.step("Enter the city in permanent Address  >"  + PermanentCity);
        } else {
            System.out.println("city in permanent Address is not visible");
        }
    }

//NET BANKING DONE BY VIJAY===
    public void ClickOnPermanentAddress() {
   	
       if(permanentAddCheckBox.isEnabled()) {
    	   permanentAddCheckBox.click();
    	   Allure.step ("UnSelect Permanent Address ChechBox ");
       }else {
    	   Allure.step("Permanent Address ChechBox  Is Not Enabled");
       }
   }

    public void EnterPinCodeWeb(String pinCode){
        
        if(pinCodeInputWeb.isDisplayed()){
        	pinCodeInputWeb.sendKeys(pinCode);
        	  Allure.step ("Enter Permanent Address Pincode  Value As =====>"+pinCode);
           }
        else {
        	  Allure.step ("Permanent Address pincide is not displayed");
        }
    }
    public void EnterPermanentAddressOneWeb(String addressOne){
       
        if(validAddressOne.isDisplayed()){
        	validAddressOne.sendKeys(addressOne);
        	  Allure.step ("Enter Permanent Addeass1  Value As =====>"+addressOne);
           }
        else {
        	  Allure.step("Permanent Address1 is not displayed");
        }
    }
    public void EnterPermanentCityAddressOneWeb(String addressOne){
        
        if(CityName.isDisplayed()){
        	CityName.sendKeys(addressOne);
        	  Allure.step ("Enter Permanent Addeass1  Value As =====>"+addressOne);
           }
        else {
        	  Allure.step("Permanent Address1 is not displayed");
        }
    }
    public void ClickOnAddressLocationDropDownButton() {
		
		if(perAddDroupDown.isDisplayed()) {
			perAddDroupDown.click();
			
			 Allure.step ("Click on prement address dropdown Button");
		}
		else {
			// Allure.step( val+" Button is Not Display");
		}
    }


    public void ClickOnAddressLocation2Button(String val) {
		WebElement next = getDriver().findElement(By.xpath("(//span[contains(text(),'"+val+"')])"));
		if(next.isEnabled()) {
			next.click();
			
			 Allure.step ("Click on "+val+" Button");
		}
		else {
			next.click();
			Allure.step ("Click on "+val+" Button");
		}
    }

    public void ClickOnAddressLocationButton(String val) {
		WebElement next = getDriver().findElement(By.xpath("(//div[contains(text(),'"+val+"')])[2]"));
		if(next.isDisplayed()) {
			next.click();
			
			ExtentFactory.getInstance().getExtent().log(Status.INFO, "Click on "+val+" Button");
		}
		else {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, val+" Button is Not Display");
		}
    }

    public void uploadCustomerPhoto() throws InterruptedException, IOException {

            WebElement SelectVal = getDriver().findElement(By.xpath("//input[@type='file']"));
            wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
            String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
            Thread.sleep(1000);
            SelectVal.sendKeys(destination);
            Allure.step( "Successfully Uploaded PHOTOGRAPH File");
    }


    public void clickCustomerPhotoNext() {
        WebElement ConfirmBtn = getDriver().findElement(By.xpath("//span[text()='NEXT']"));
        wait.waitforElementToBeClickable(getDriver(), ConfirmBtn, 100);
        if (ConfirmBtn.isDisplayed()) {
            ConfirmBtn.click();
            Allure.step( "Click on Confirm Button" );
        }
        else {
            Allure.step(  "Confirm Button Is Not Display" );
        }
    }

    public void clickDoItLaterCustomerPhoto() {
        WebElement ConfirmBtn = getDriver().findElement(By.xpath("//span[text()='DO IT LATER']"));
        wait.waitforElementToBeClickable(getDriver(), ConfirmBtn, 100);
        if (ConfirmBtn.isDisplayed()) {
            ConfirmBtn.click();
            Allure.step(  "Click on Confirm Button" );
        }
        else {
            Allure.step(  "Confirm Button Is Not Display" );
        }
    }








}
