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

public class ViewQuoteFactorySalaried {
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

    public void ViewPageSalaried(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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

        if (testData.get("Issmokerstatus").equalsIgnoreCase("YES")) {
            viewquote.SelectSmokingStatus(testData.get("Issmoker"));
        }

        if (testData.get("IsPlanOptionSalaried").equalsIgnoreCase("YES")) {
            viewquote.SelectPlanOptionweb(testData.get("PlanOptionSalaried"));
            wait.WaitTime2();
        }

        if (testData.get("IsPPTOptionSalaried").equalsIgnoreCase("YES")) {
            viewquote.SelectPPTWeb(testData.get("pptOptionSalaried"));
            wait.WaitTime2();
        }
        if (testData.get("IsPolicyTermSalaried").equalsIgnoreCase("YES")) {
            viewquote.EnterPolicytermWeb(testData.get("PolicytermSalaried"));
            wait.WaitTime2();
        }

        if (testData.get("IsPlanOptionSalaried").equalsIgnoreCase("YES")) {
            if (testData.get("PlanOptionSalaried").equalsIgnoreCase("Option 3 - Fixed Income Cover")) {
                wait.WaitTime2();
                viewquote.SelectIncomeBenefitPeriodWeb(testData.get("IncomeBenefitPeriodSalaried"));
            }
            if (testData.get("PlanOptionSalaried").equalsIgnoreCase("Option 4 - Increasing Income Cover")) {
                wait.WaitTime2();
                viewquote.SelectIncomeBenefitPeriodWeb(testData.get("IncomeBenefitPeriodSalaried"));
                wait.WaitTime2();
                viewquote.SelectIncomeEscalationRateWeb(testData.get("IncomeEscalationRateSalaried"));
            }
        }
        if (testData.get("IsCompanySalaried").equalsIgnoreCase("YES")) {
            viewquote.EnterOccupationNameofEmployeeSalariedTerm(testData.get("companysalaried"));
        }
        if (testData.get("IsPaymodeSalaried").equalsIgnoreCase("YES")) {
            viewquote.SelectPaymodeWeb(testData.get("paymodeSalaried"));
        }
        if(testData.get("IsACIAST").equalsIgnoreCase("YES")){
            viewquote.AddACIRiderWeb();
            viewquote.enterSumAssuredACIWeb(testData.get("SumAssuredACIAST"));
        }
        TestUtil.scrollTillEndOfPage(driver);

        // Add riders //
        if (testData.get("IsAddRiderAST").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();

            if (testData.get("IswavierofpremiumAST").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }

                if (testData.get("IsADDRiderAST").equalsIgnoreCase("Accidental Death and Disability")) {
                    viewquote.addADD(testData.get("ADDMamountAST"));
                }
                if (testData.get("IsCIRiderAST").equalsIgnoreCase("Critical Illness")) {
                    viewquote.addCI(testData.get("CIamountAST"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }
                if (testData.get("IsSCRiderAST").equalsIgnoreCase("Surgical Care")) {
                    viewquote.addSC(testData.get("SCamountAST"));
                }
                if (testData.get("IsHSRiderAST").equalsIgnoreCase("Hospital Care")) {
                    viewquote.addHC(testData.get("HCamountAST"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }
                if ((testData.get("IsADBRiderAST")).equalsIgnoreCase("Accidental Death Benefit Plus")) {
                    viewquote.addADB(testData.get("ADBamountAST"));
                }

            viewquote.addbutton();
        }
    }
}