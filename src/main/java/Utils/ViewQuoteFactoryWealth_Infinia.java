package Utils;
import static com.absli.base.BasePage.getDriver;

import java.io.IOException;
import java.util.HashMap;

import com.absli.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import com.absli.pageObjects.ViewQuote;
import com.absli.utils.PropertiesUtils;
import com.absli.utils.WaitUtils;
import util.TestUtil;
public class ViewQuoteFactoryWealth_Infinia {

    Dashboard dashboard;
    Wait wait;
    LoginPage loginPage;
    SalesDetails salesdetails;
    CustomerProfile customerprofile;
    ViewQuote viewquote;
    CommunicationDetails communicationdetails;
    BankDetails bankdetails;
    Nominee nominee;
    AddressDetalis address;
    CompanyProfessionalDetails companyprofdetails;
    InsurerPersonalInfo insurerpersonalinfo;
    InsuProfessionalDetails insuprofdetails;
    InsurerPersonalHealth insupersonalhealth;
    InsurerLifestyle insurerlifestyle;
    InsurerFamilyMedical insurerfamilymedical;
    InsurerCovidDetails insurercoviddetails;
    InsurerMedicalHistory insurermedicalhistory;
    ProposerPersonalInfo proposerpersonalinfo;
    ProposerProfessionalDetails proposerprofdetails;
    MinorPersonalInfo minorpersonalinfo;
    MinorPersonalHealth minorpersonalhealth;
    MinorCovidDetails minorcoviddetails;
    InsurabilityDeclaration insudecleration;
    ECCDPage eccd;
    ProposerNRIMandate nriMandate;
    InsurerNRIMandate insurerNriMandate;
    RandAPage rna;
    PaymentPage paymentpage;
    DocumentsPage documentpage;
    JointlifePage jointlife;
    SpouseLifestyle spouselifestyle;
    SpouseCovidDetails spousecovid;
    SpouseMedicalHistory spousemedicalhistory;
    public static PropertiesUtils prop;
    SoftAssert softassert;
    HealthAndPureTermsPage healthandpuretermspage;

    public void ViewPageWealth_infinia(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

        dashboard = new Dashboard(getDriver());
        loginPage = new LoginPage(getDriver());
        salesdetails = new SalesDetails(getDriver());
        customerprofile = new CustomerProfile(getDriver());
        viewquote = new ViewQuote(getDriver());
        communicationdetails = new CommunicationDetails(getDriver());
        bankdetails = new BankDetails(getDriver());
        nominee = new Nominee(getDriver());
        address = new AddressDetalis(getDriver());
        proposerpersonalinfo = new ProposerPersonalInfo(getDriver());
        proposerprofdetails = new ProposerProfessionalDetails(getDriver());
        insurerpersonalinfo = new InsurerPersonalInfo(getDriver());
        insuprofdetails = new InsuProfessionalDetails(getDriver());
        insupersonalhealth = new InsurerPersonalHealth((getDriver()));
        insurerlifestyle = new InsurerLifestyle(getDriver());
        insurerfamilymedical = new InsurerFamilyMedical((getDriver()));
        insurercoviddetails = new InsurerCovidDetails(getDriver());
        insurermedicalhistory = new InsurerMedicalHistory(getDriver());
        nriMandate = new ProposerNRIMandate(getDriver());
        insurerNriMandate = new InsurerNRIMandate(getDriver());
        insurerNriMandate = new InsurerNRIMandate(getDriver());
        rna = new RandAPage(getDriver());
        eccd = new ECCDPage(getDriver());
        paymentpage = new PaymentPage(getDriver());
        documentpage = new DocumentsPage(getDriver());
        prop = new PropertiesUtils();
        softassert = new SoftAssert();
        healthandpuretermspage = new HealthAndPureTermsPage(getDriver());

        // View Quote page //
        if (testData.get("IsPremiumAmountWealth_infinia").equalsIgnoreCase("YES")) {
            viewquote.EnterPremiumAmountWeb(testData.get("premiumamountWealth_infinia"));
        }
        if(testData.get("IsPlanoptioninfiniaWealth_infinia").equalsIgnoreCase("YES")) {
            viewquote.SelectPlanOption(testData.get("PlanoptioninfiniaWealth_infinia"));
            if (testData.get("PlanoptioninfiniaWealth_infinia").equalsIgnoreCase("Milestone Variant")) {
                if (testData.get("IspolicytermWealth_infinia").equalsIgnoreCase("YES")) {
                    viewquote.SelectPolicytermADG(testData.get("policytermWealth_infinia"));
                }
            }
        }
        if (testData.get("IsPPTOptionWealth_infinia").equalsIgnoreCase("YES")) {
            viewquote.SelectPPTWeb(testData.get("pptWealth_infinia"));

        }

        if(testData.get("IsInvestMentOptionWealth_infinia").equalsIgnoreCase("YES")){
            viewquote.selectInvestMentOptionaspireWeb(testData.get("investMentOptionWealth_infinia"));
        }

        if(testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Self Managed Option")){
            if(testData.get("IsUnderWritingClassWealth_infinia").equalsIgnoreCase("YES")){
                viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_infinia"));

            }
        }else if(testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Systematic Transfer Option")) {
            //viewquote.transferfrequencyWeb(testData.get("transferFrequ"));
            if (testData.get("IsUnderWritingClassWealth_infinia").equalsIgnoreCase("YES")) {
                viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_infinia"));
            }
        } else if (testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Life Cycle Option")) {
            viewquote.SelectRiskProfileWeb(testData.get("RiskProfileWealth_infinia"));
            if (testData.get("IsUnderWritingClassWealth_infinia").equalsIgnoreCase("YES")) {
                viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_infinia"));
            }

        } else if (testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Smart Option")) {
            viewquote.SelectRiskProfileWeb(testData.get("RiskProfileWealth_infinia"));
            if (testData.get("IsUnderWritingClassWealth_infinia").equalsIgnoreCase("YES")) {
                viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_infinia"));
            }

        } else if (testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Return Optimiser Option")) {
            if (testData.get("IsUnderWritingClassWealth_infinia").equalsIgnoreCase("YES")) {
                viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_infinia"));
            }
        }
//        else (testData.get("Sumassuredmultiplierinfinia").equalsIgnoreCase("YES")){
//            viewquote.SelectisummultiplierWeb(testData.get("Sumassmultipliervalue"));
//        }
        if(!(testData.get("pptWealth_infinia").equalsIgnoreCase("Single Pay"))) {
            if (testData.get("Sumassuredmultiplierinfinia").equalsIgnoreCase("YES")) {
                viewquote.SelectisummultiplierWeb(testData.get("SumassmultipliervalueWealth_infinia"));
            }
        }

        if (testData.get("IsPaymodeWealth_infinia").equalsIgnoreCase("YES")) {
            if(testData.get("pptWealth_infinia").equalsIgnoreCase("Single Pay")){
                viewquote.SelectPaymodeWeb("Annual");
            }
            viewquote.SelectPaymodeWeb(testData.get("paymodeWealth_infinia"));

        }
        if(testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Self Managed Option")){
            viewquote.MultiplierFund(testData.get("multiplier"));
            viewquote.MagnifierFund(testData.get("magnifier"));
            viewquote.MaximiserFund(testData.get("maximiser"));
            viewquote.SuperFund(testData.get("superTwenty"));
            viewquote.LiquidPlusFund(testData.get("liquidPlus"));
            viewquote.IncomeAdvFund(testData.get("incomeAdv"));
            viewquote.AsssureFund(testData.get("assureFund"));
            viewquote.Enhancer(testData.get("enhance"));
            viewquote.CappedNintyFund(testData.get("CappedNinty"));
            viewquote.CreatorFund(testData.get("creatorFund"));
            viewquote.valueFund(testData.get("valueFund"));
            viewquote.ProtectorFund(testData.get("protector"));
            viewquote.BuilderFund(testData.get("builder"));
            viewquote.PureEquityFund(testData.get("pureEquity"));
            viewquote.AssetAllocationFund(testData.get("asset"));
            viewquote.MncFund(testData.get("mnu"));
        }
        if(testData.get("investMentOptionWealth_infinia").equalsIgnoreCase("Systematic Transfer Option")){
            viewquote.Enhancer(testData.get("enhance"));
            viewquote.MaximiserFund(testData.get("maximiser"));
            viewquote.SuperFund(testData.get("superTwenty"));
            viewquote.MncFund(testData.get("mnu"));
            viewquote.IncomeAdvFund(testData.get("incomeAdv"));
            viewquote.CreatorFund(testData.get("creatorFund"));
            viewquote.valueFund(testData.get("valueFund"));
            viewquote.MultiplierFund(testData.get("multiplier"));
        }
        // Add riders //
        if (testData.get("IsAddRiderWealth_infinia").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();
            if (testData.get("IswavierofpremiumWealth_infinia").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }
            if (testData.get("IsADBRiderWealth_infinia").equalsIgnoreCase("Accidental Death Benefit Plus")) {
                viewquote.addADB(testData.get("ADMamountWealth_infinia"));
            }
            viewquote.addbutton();
            TestUtil.scrollTillEndOfPage(getDriver());
        }


        //viewquote.SelectABGEmployeeDiscountWeb(IsABGEmployee, ABGEmployeeDscountID);

//	String InitialPremiumAmountValue1 = getDriver().findElement(By.xpath("//div[contains(@class,'amount-in-numbers')]")).getText();
        loginPage.Applicationnumber(); // printing of application number in report //

        WebElement PayMode = getDriver().findElement(By.xpath("//div[contains(@class,'payment-cycle-text')]"));
        String PayModeValue = PayMode.getText();
        String[] PayModeValueupdate = PayModeValue.split(": ");
        softassert.assertEquals(PayModeValueupdate[1], testData.get("paymode"));

        WebElement PlanOption = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[1]"));
        String PlanOptionValue = PlanOption.getText();
        softassert.assertEquals(PlanOptionValue, testData.get("benefitotion"));

        WebElement PT = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[2]"));
        String PTValue = PT.getText();
        String[] PTValueupdate = PTValue.split(" ");
        softassert.assertEquals(PTValueupdate[0], testData.get("policyterm"));

        WebElement PPT = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[4]"));
        String PPTValue = PPT.getText();
        softassert.assertEquals(PPTValue, testData.get("ppt"));

        TestUtil.scrollTillEndOfPage(getDriver());
        viewquote.clickConfirmPlanBtn(); // Confirm Plan button QA
        dashboard.checkLoaderWeb();
    }
}
