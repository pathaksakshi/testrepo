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
public class ViewQuoteFactoryWealth_secure {
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

    public void ViewPageWealth_secure(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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

        if (testData.get("IsPremiumAmountWealth_secure").equalsIgnoreCase("YES")) {
            viewquote.EnterPremiumAmountWeb(testData.get("premiumamountWealth_secure"));
        }
        if (testData.get("IsPPTWealth_secure").equalsIgnoreCase("YES")) {
            viewquote.EnterPolpayingtermmaspireWeb(testData.get("PayingTermWealth_secure"));
        }
        if (testData.get("IsInvestmentOptionWealth_secure").equalsIgnoreCase("YES")) {
            viewquote.selectInvestMentOptionaspireWeb(testData.get("InvestOptionWealth_secure"));

            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Self-Managed")) {
                if (testData.get("IsUnderWritingClassWealth_secure").equalsIgnoreCase("YES")) {
                    viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_secure"));
                }
            }
            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Systematic Transfer")) {
                if (testData.get("IsUnderWritingClassWealth_secure").equalsIgnoreCase("YES")) {
                    viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_secure"));
                }
            }
            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Life Cycle")) {
                viewquote.SelectRiskProfileWeb(testData.get("RiskProfile_Wealth_secure"));
                if (testData.get("IsUnderWritingClassWealth_secure").equalsIgnoreCase("YES")) {
                    viewquote.selectUnderWritingClassWeb(testData.get("underWritingClassWealth_secure"));
                }
            }

        }

        if (testData.get("IsPaymodeWealth_secure").equalsIgnoreCase("YES")) {
            viewquote.SelectPaymodeWeb(testData.get("paymodeWealth_secure"));
        }

        if (testData.get("IsInvestmentOptionWealth_secure").equalsIgnoreCase("YES")) {
            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Self-ManagedWealth_secure")) {
                viewquote.MagnifierFund(testData.get("magnifierWealth_secure"));
                viewquote.MaximiserFund(testData.get("maximiserWealth_secure"));
                viewquote.SuperFund(testData.get("superTwentyWealth_secure"));
                viewquote.CappedNintyFund(testData.get("CappedNintyWealth_secure"));
                viewquote.AssetAllocationFund(testData.get("assetWealth_secure"));
                viewquote.LiquidPlusFund(testData.get("liquidPlusWealth_secure"));
                viewquote.IncomeAdvFund(testData.get("incomeAdvWealth_secure"));
                viewquote.AsssureFund(testData.get("assureFundWealth_secure"));
                viewquote.Enhancer(testData.get("enhanceWealth_secure"));
                viewquote.MultiplierFund(testData.get("multiplierWealth_secure"));
                viewquote.valueFund(testData.get("valueFundWealth_secure"));
                viewquote.BuilderFund(testData.get("builderWealth_secure"));
                viewquote.ProtectorFund(testData.get("protectorWealth_secure"));
                viewquote.PureEquityFund(testData.get("pureEquityWealth_secure"));
                viewquote.CreatorFund(testData.get("creatorFundWealth_secure"));
                viewquote.MncFund(testData.get("mnuWealth_secure"));
            }
            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Systematic Transfer")) {
                viewquote.Enhancer(testData.get("enhanceWealth_secure"));
                viewquote.MaximiserFund(testData.get("maximiserWealth_secure"));
                viewquote.SuperFund(testData.get("superTwentyWealth_secure"));
                viewquote.CappedNintyFund(testData.get("CappedNintyWealth_secure"));
                viewquote.valueFund(testData.get("valueFundWealth_secure"));
                viewquote.MncFund(testData.get("mnuWealth_secure"));
                viewquote.IncomeAdvFund(testData.get("incomeAdvWealth_secure"));
                viewquote.CreatorFund(testData.get("creatorFundWealth_secure"));
                viewquote.MultiplierFund(testData.get("multiplierWealth_secure"));
            }
            if (testData.get("InvestOptionWealth_secure").equalsIgnoreCase("Life Cycle")) {
                System.out.println("By deafult it is 100%");
            }

        }

        // Add riders //
        if (testData.get("IsAddRiderWealth_secure").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();
            if (testData.get("IswavierofpremiumWealth_secure").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }

                if (testData.get("IsADDRiderWealth_secure").equalsIgnoreCase("Accidental Death Benefit Plus")) {
                    viewquote.addADB(testData.get("ADDMamountWealth_secure"));
                }

            viewquote.addbutton();

        }

    }
}
