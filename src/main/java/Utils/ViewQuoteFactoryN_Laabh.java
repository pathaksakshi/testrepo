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
public class ViewQuoteFactoryN_Laabh {
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

    public void ViewPageNischitLaabh(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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
        if (testData.get("IsPremiumAmountN_Laabh").equalsIgnoreCase("YES")) {
            TestUtil.scrollTillTOPOfPage(getDriver());
            wait.WaitTime(5);
            viewquote.EnterPremiumAmountWeb(testData.get("premiumamountN_Laabh"));
        }
        if (testData.get("IsPlanOptionN_Laabh").equalsIgnoreCase("YES")) {
            viewquote.SelectPlanoptWeb(testData.get("PlanOptionN_Laabh"));
        }
        if (testData.get("IsPPTOptionN_Laabh").equalsIgnoreCase("YES")) {
            viewquote.SelectPPTWeb(testData.get("pptN_Laabh"));
        }
        if (testData.get("IspolicytermN_Laabh").equalsIgnoreCase("YES")) {
            viewquote.SelectPoltermWeb(testData.get("policytermN_Laabh"));
        }
        if (testData.get("IsPaymodeN_Laabh").equalsIgnoreCase("YES")) {
            viewquote.SelectPaymodeWeb(testData.get("paymodeN_Laabh"));
        }
        if (testData.get("PlanOptionN_Laabh").equalsIgnoreCase("Option 2 - Income with Lumpsum Option ")) {
            viewquote.SelectbenefreqWeb(testData.get("benefitfreqN_Laabh"));
        }


        // Add riders //
        if (testData.get("IsAddRiderN_Laabh").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();

            if (testData.get("IswavierofpremiumN_Laabh").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }

                if (testData.get("IsADBRiderN_Laabh").equalsIgnoreCase("Accidental Death Benefit Plus")) {
                    viewquote.addADB(testData.get("ADMamountN_Laabh"));
                }
                if (testData.get("IsCIRiderN_Laabh").equalsIgnoreCase("Critical Illness")) {
                    viewquote.addCI(testData.get("CIamountN_Laabh"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }
                if (testData.get("IsSCRiderN_Laabh").equalsIgnoreCase("Surgical Care")) {
                    viewquote.addSC(testData.get("SCamountN_Laabh"));
                }
                if (testData.get("IsHSRiderN_Laabh").equalsIgnoreCase("Hospital Care")) {
                    viewquote.addHC(testData.get("HCamountN_Laabh"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }

            viewquote.addbutton();

            TestUtil.scrollTillEndOfPage(getDriver());
        }

    }
}
