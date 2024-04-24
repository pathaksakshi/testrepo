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

public class ViewQuoteFactoryVision_lifeincomeplus {

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

    public void ViewPageVision_lifeincomeplus (WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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

        try {
            viewquote.CloseAlertPopUp();
        } catch (Exception e) {
        }

        wait.WaitTime2();
        if (testData.get("IsPremiumvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.EnterPremiumAmountWeb(testData.get("PremiumAmountvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("IsBenifitOptionvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.selectBenifitOptionWeb(testData.get("BenifitOptionvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("IsPPTOptionvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.SelectPPTWeb(testData.get("pptOptionvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("IsBenifitPayoutPeriodvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.selectBenifitPayoutPeriodWeb(testData.get("BenifitPayoutPeriodvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("IsBenifitPayoutvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.selectBenifitPayoutWeb(testData.get("BenifitPayoutvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("IsBonusUtilizationOptionvisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.selectBonusUtilizationOptionWeb(testData.get("bonusUtilizationOptionvisionlifeplus"));
            wait.WaitTime2();
        }
        if (testData.get("BenifitOptionvisionlifeplus").equalsIgnoreCase("Whole Life Income")) {
            viewquote.SelectmaturityageWeb(testData.get("maturityAge"));
            wait.WaitTime2();
        }
        if (testData.get("IsPaymodevisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.SelectPaymodeWeb(testData.get("paymodevisionlifeplus"));
            wait.WaitTime2();
        }

        // Add riders //
        if (testData.get("IsAddRidervisionlifeplus").equalsIgnoreCase("YES")) {
            viewquote.addriderbutton();

            if (testData.get("Iswavierofpremiumvisionlifeplus").equalsIgnoreCase("Waiver Of Premium")) {
                viewquote.addWOP();
            }

                if (testData.get("IsCIRidervisionlifeplus").equalsIgnoreCase("Critical Illness")) {
                    viewquote.addCI(testData.get("CIamountvisionlifeplus"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }
                if (testData.get("IsSCRidervisionlifeplus").equalsIgnoreCase("Surgical Care")) {
                    viewquote.addSC(testData.get("SCamountvisionlifeplus"));
                }
                if (testData.get("IsHSRidervisionlifeplus").equalsIgnoreCase("Hospital Care")) {
                    viewquote.addHC(testData.get("HCamountvisionlifeplus"));
                    TestUtil.scrollTillEndOfPage(getDriver());
                }
                if ((testData.get("IsADBRidervisionlifeplus")).equalsIgnoreCase("Accidental Death Benefit Plus")) {
                    viewquote.addADB(testData.get("ADBamountvisionlifeplus"));
                }

            viewquote.addbutton();

            TestUtil.scrollTillEndOfPage(getDriver());
        }

    }
}
