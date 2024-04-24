package Utils;
import static com.absli.base.BasePage.getDriver;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.absli.pageObjects.AddressDetalis;
import com.absli.pageObjects.BankDetails;
import com.absli.pageObjects.CommunicationDetails;
import com.absli.pageObjects.CompanyProfessionalDetails;
import com.absli.pageObjects.CustomerProfile;
import com.absli.pageObjects.Dashboard;
import com.absli.pageObjects.DocumentsPage;
import com.absli.pageObjects.ECCDPage;
import com.absli.pageObjects.HealthAndPureTermsPage;
import com.absli.pageObjects.InsuProfessionalDetails;
import com.absli.pageObjects.InsurabilityDeclaration;
import com.absli.pageObjects.InsurerCovidDetails;
import com.absli.pageObjects.InsurerFamilyMedical;
import com.absli.pageObjects.InsurerLifestyle;
import com.absli.pageObjects.InsurerMedicalHistory;
import com.absli.pageObjects.InsurerNRIMandate;
import com.absli.pageObjects.InsurerPersonalHealth;
import com.absli.pageObjects.InsurerPersonalInfo;
import com.absli.pageObjects.JointlifePage;
import com.absli.pageObjects.LoginPage;
import com.absli.pageObjects.MinorCovidDetails;
import com.absli.pageObjects.MinorPersonalHealth;
import com.absli.pageObjects.MinorPersonalInfo;
import com.absli.pageObjects.Nominee;
import com.absli.pageObjects.PaymentPage;
import com.absli.pageObjects.ProposerNRIMandate;
import com.absli.pageObjects.ProposerPersonalInfo;
import com.absli.pageObjects.ProposerProfessionalDetails;
import com.absli.pageObjects.RandAPage;
import com.absli.pageObjects.SalesDetails;
import com.absli.pageObjects.SpouseCovidDetails;
import com.absli.pageObjects.SpouseLifestyle;
import com.absli.pageObjects.SpouseMedicalHistory;
import com.absli.pageObjects.ViewQuote;
import com.absli.utils.PropertiesUtils;
import com.absli.utils.WaitUtils;
import util.TestUtil;

public class ViewQuoteFactoryPlatinum {
    Dashboard dashboard;
    WaitUtils wait;
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

    public void ViewPagePlatinum_gain(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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

        if (testData.get("IsPremiumAmountplatinum").equalsIgnoreCase("YES")) {
            viewquote.EnterPremiumAmountWeb(testData.get("premiumamountplatinum"));
        }
        if (testData.get("IsPPTOptionplatinum").equalsIgnoreCase("YES")) {
            viewquote.SelectPPTWeb(testData.get("pptplatinum"));
        }
        if (testData.get("IsPolicytermplatinum").equalsIgnoreCase("YES")) {
            viewquote.EnterPolicytermWeb(testData.get("poltermplatinum"));
        }
        if (testData.get("IsSAMultiplierplatinum").equalsIgnoreCase("YES")) {
            viewquote.SelectisummultiplierWeb(testData.get("SAmultiplatinum"));
        }
        if (testData.get("Isinvestmentoptplatinum").equalsIgnoreCase("YES")) {
            viewquote.selectInvestMentOptionaspireWeb(testData.get("Invoptionplatinum"));
        }
        if (testData.get("Invoptionplatinum").equalsIgnoreCase("Self-Managed Option") || testData.get("Invoptionplatinum").equalsIgnoreCase("Systematic Transfer Option") || testData.get("Invoptionplatinum").equalsIgnoreCase("Return Optimiser Option")) {
            viewquote.selectUnderWritingClassWeb(testData.get("uclassplatinum"));
        }
        if (testData.get("Invoptionplatinum").equalsIgnoreCase("Life Cycle Option") || testData.get("Invoptionplatinum").equalsIgnoreCase("Smart Option")) {
            viewquote.SelectRiskProfileWeb(testData.get("ProfilePlatinum"));
            viewquote.selectUnderWritingClassWeb(testData.get("uclassplatinum"));
        }
        if (testData.get("IsPaymodeplatinum").equalsIgnoreCase("YES")) {
            viewquote.SelectPaymodeWeb(testData.get("paymodeplatinum"));
        }

        if (testData.get("Isinvestmentoptplatinum").equalsIgnoreCase("YES")) {
            if (testData.get("Invoptionplatinum").equalsIgnoreCase("Self-Managed Option")) {
                viewquote.MagnifierFund(testData.get("magnifierplatinum"));
                viewquote.MaximiserFund(testData.get("maximiserplatinum"));
                viewquote.SuperFund(testData.get("superTwentyplatinum"));
                viewquote.CappedNintyFund(testData.get("CappedNintyplatinum"));
                viewquote.AssetAllocationFund(testData.get("assetplatinum"));
                viewquote.LiquidPlusFund(testData.get("liquidPlusplatinum"));
                viewquote.IncomeAdvFund(testData.get("incomeAdvplatinum"));
                viewquote.AsssureFund(testData.get("assureFundplatinum"));
                viewquote.Enhancer(testData.get("enhanceplatinum"));
                viewquote.MultiplierFund(testData.get("multiplierplatinum"));
                viewquote.valueFund(testData.get("valueFundplatinum"));
                viewquote.BuilderFund(testData.get("builderplatinum"));
                viewquote.ProtectorFund(testData.get("protectorplatinum"));
                viewquote.PureEquityFund(testData.get("pureEquityplatinum"));
                viewquote.CreatorFund(testData.get("creatorFundplatinum"));
                viewquote.MncFund(testData.get("mnuplatinum"));
            }
            if (testData.get("Invoptionplatinum").equalsIgnoreCase("Systematic Transfer Option")) {
                viewquote.Enhancer(testData.get("enhanceplatinum"));
                viewquote.MaximiserFund(testData.get("maximiserplatinum"));
                viewquote.SuperFund(testData.get("superTwentyplatinum"));
                viewquote.CappedNintyFund(testData.get("CappedNintyplatinum"));
                viewquote.valueFund(testData.get("valueFundplatinum"));
                viewquote.MncFund(testData.get("mnuplatinum"));
                viewquote.IncomeAdvFund(testData.get("incomeAdvplatinum"));
                viewquote.CreatorFund(testData.get("creatorFundplatinum"));
                viewquote.MultiplierFund(testData.get("multiplierplatinum"));
            }
        }

        // Add riders //
        if (testData.get("IsAddRiderplatinum").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();

            if (testData.get("Iswavierofpremiumplatinum").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }

                if (testData.get("IsADDRiderplatinum").equalsIgnoreCase("Accidental Death Benefit Plus")) {
                    viewquote.addADB(testData.get("ADDMamountplatinum"));
                }

            viewquote.addbutton();

        }

    }
}