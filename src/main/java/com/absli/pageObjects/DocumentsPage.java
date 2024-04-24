package com.absli.pageObjects;
import com.absli.base.BasePage;
import com.absli.base.ExtentFactory;
import com.absli.base.TestBase;
import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DocumentsPage extends TestBase {

    public WebDriver driver;
    public WaitUtils wait;

    public DocumentsPage(WebDriver driver) {PageFactory.initElements(getDriver(), this);}

    @FindBy(xpath = "//span[contains(text(),'Identity Proof')]")
    private WebElement identityBTN;
    @FindBy(xpath = "//div[@aria-haspopup='listbox']")
    private WebElement SelectType;
    @FindBy(xpath = "//span[contains(text(),'NEXT')]")
    private WebElement NEXTBTN;
    @FindBy(xpath = "//button[@name='Save & Continue']")
    private WebElement SaveContinueBTN;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement SelectValUploadFileweb;

    public void clickOnIdentityTileweb() {

        wait.waitForElementToBeVisibleweb(getDriver(), identityBTN, 20, "Element is Not Display");
        if (identityBTN.isDisplayed()) {
            identityBTN.click();
            Allure.step("Click On Identity Proof Tile ");
        } else {
            System.out.println("Identity Proof Tile is not display ");
        }
    }

    public void SelectTypeOfDocumentweb(String val) throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), SelectType, 20, "Element is Not Display");
        try {
            SelectType.click();
            WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
            wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 20, "Element is Not Display");
            SelectVal.click();
            Allure.step("Select Values As=====>" + val);
        }
        catch (Exception e){
            WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
            wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 20, "Element is Not Display");
            JavascriptExecutor js = (JavascriptExecutor) BasePage.getDriver();

            js.executeScript("arguments[0].click();", SelectVal);
            System.out.println("Address card waived off");
        }

    }
    public void UploadFileweb() throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), SelectValUploadFileweb, 30, "Element is Not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        //  wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 30, "Element is Not Display");
        try {
            //  if (SelectVal.isEnabled()) {
            SelectValUploadFileweb.sendKeys(destination);
            Allure.step("Successfully Uploaded File");
        }
        catch
        (Exception e) {
            System.out.println("Address card waived off");
        }
    }



    public void clickOnNEXTButtonweb() throws InterruptedException {
        wait.waitForElementToBeVisibleweb(getDriver(), NEXTBTN, 20, "Element is Not Display");
        if (NEXTBTN.isDisplayed()) {
            NEXTBTN.click();
            Allure.step("Click On Next Button ");
        } else {
            System.out.println("Next Button  is not display ");
        }
    }
    public void UploadNonMedicalNEFTCancelweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'CANCELLED CHEQUE FOR NEFT')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded NEFT Cancelled Cheque File");
    }
    public void UploadNonMedicalSignedCopyweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'Signed copy of Profiler')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded Signed Copy");
    }

    public void UploadNonMedicalPHOTOGRAPHProposerNotInsuredweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'Photograph')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        wait.WaitTime(2);
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded PHOTOGRAPH File");
    }
    public void UploadNonMedicalFinancialProposerNotInsuredweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'Financial justication endorsed by BH')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        wait.WaitTime(2);
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded PHOTOGRAPH File");
    }

    public void UploadNonMedicalPremiumProposerNotInsuredweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'HDFC premium exception approval')]//parent::p//parent::div//parent::div/following-sibling::div//input)[2]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        wait.WaitTime(2);
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded PHOTOGRAPH File");
    }

    public void UploadNonMedicalPHOTOGRAPHPInsuredweb() throws InterruptedException { //    (//div[contains(text(),'Photograph')]//parent::p//parent::div//parent::div/following-sibling::div//input)[2]
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'Photograph')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        wait.WaitTime(2);
        SelectVal.sendKeys(destination);
        Allure.step("Successfully Uploaded PHOTOGRAPH File");

    }
    public void UploadNonMedicalStatementInsuredweb() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//div[contains(text(),'Bank statement showing Vintage Relationship')]//parent::p//parent::div//parent::div/following-sibling::div//input)[1]"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 0, "Element is not Display");
        String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
        wait.WaitTime(2);
        SelectVal.sendKeys(destination);
        Allure.step( "Successfully Uploaded PHOTOGRAPH File");

    }
    public void SelectTypeOfDocumentPanCard(String val) throws InterruptedException {
        WebElement SelectType = getDriver().findElement(By.xpath("//div[@aria-haspopup='listbox']"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectType, 20, "Element is Not Display");
        try {
            SelectType.click();
            Allure.step("Click On Select Type of document DropDown");
            wait.WaitTime(2);
            try {
                WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
                WaitUtils.waitForElementToBeVisibleweb(getDriver(),SelectVal,30,"unable to locate element");
                SelectVal.click();
                Allure.step("Select Values As=====>" + val);
            }catch (Exception e){
                WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
                WaitUtils.waitForElementToBeVisibleweb(getDriver(),SelectVal,30,"unable to locate element");
                //SelectVal.click();
                JavascriptExecutor js = (JavascriptExecutor) BasePage.getDriver();

                js.executeScript("arguments[0].click();", SelectVal);
                Allure.step("Select Values As=====>" + val);
            }

        }
        catch (Exception e){
            System.out.println("PAN card is waived off ");
        }
    }
    public void SelectTypeOfDocumentIncomePrrofweb(String val) throws InterruptedException {
        WebElement SelectType = getDriver().findElement(By.xpath("//div[@aria-haspopup='listbox']"));
        wait.waitforElementToBeClickable(getDriver(), SelectType, 20);
        SelectType.click();
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "Click On Select Type of document DropDown");
        wait.WaitTime(2);
        try{
            WebElement SelectVal=getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
            WaitUtils.waitForElementToBeVisibleweb(getDriver(),SelectVal,30,"unable to locate element");
            SelectVal.click();
            Allure.step("Select Values As=====>" + val);
        }catch (Exception e){
            WebElement SelectVal=getDriver().findElement(By.xpath("//ul/li/div/span[text()='"+val+"']"));
            WaitUtils.waitForElementToBeVisibleweb(getDriver(),SelectVal,30,"unable to locate element");
            //SelectVal.click();
            JavascriptExecutor js = (JavascriptExecutor) BasePage.getDriver();

            js.executeScript("arguments[0].click();", SelectVal);
            Allure.step("Select Values As=====>" + val);
        }

    }

    public void SelectTypeOfDocumentAgePrrofweb(String val) throws InterruptedException {
        WebElement SelectTypeprop = getDriver().findElement(By.xpath("(//div[@aria-haspopup='listbox'])[1]"));
        wait.waitforElementToBeClickable(getDriver(), SelectTypeprop, 20);
        try {
            SelectTypeprop.click();
            Allure.step("Click On Select Type of document DropDown");
            wait.WaitTime(2);

            WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
            SelectVal.click();
            Allure.step("Select Values As=====>" + val);
        }
        catch (Exception E)
        {
            System.out.println("Address proof is waived off ");
        }
    }

    public void SelectTypeOfDocumentinsuAgePrrofweb(String val) throws InterruptedException {
        WebElement SelectTypeinsu = getDriver().findElement(By.xpath("//div[@aria-haspopup='listbox']"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectTypeinsu, 20, "Element is Not Display");
        try {
            SelectTypeinsu.click();
            Allure.step("Click On Select Type of document DropDown");
            wait.WaitTime(2);
            WebElement SelectVal = getDriver().findElement(By.xpath("//ul/li/div/span[starts-with(text(),'"+val+"')]"));
            SelectVal.click();
            Allure.step("Select Values As=====>" + val);
        }
        catch (Exception e)
        {
            System.out.println("Address proof is waived off ");
        }
    }

    public void UploadFilewebinsuage() throws InterruptedException {
        WebElement SelectVal = getDriver().findElement(By.xpath("(//input[@type='file'])"));
        wait.waitForElementToBeVisibleweb(getDriver(), SelectVal, 20, "Element is Not Display");
        try {
            String destination = System.getProperty("user.dir") + "/FileUpload/SRIDEVI_PARVATIKAR_DigiShield.pdf";
            if (SelectVal.isDisplayed()) {
                SelectVal.sendKeys(destination);
                Allure.step("Successfully Uploaded File");
            } else {
                SelectVal.sendKeys(destination);
                System.out.println("Successfully Uploaded File");
            }
        } catch (Exception e) {
            System.out.println("Address proof is waived off ");
        }
    }
    public void clickOnSaveContinueButton() throws InterruptedException {

        wait.waitForElementToBeVisibleweb(getDriver(), SaveContinueBTN, 20, "Element is Not Display");
        if (SaveContinueBTN.isDisplayed()) {
            SaveContinueBTN.click();
            Allure.step("Click On Save and continue button");
        } else {
            System.out.println( "Save and continue button is not display ");
        }

    }
}