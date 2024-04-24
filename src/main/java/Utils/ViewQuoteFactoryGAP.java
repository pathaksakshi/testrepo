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
public class ViewQuoteFactoryGAP {
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

    public void ViewPageGAP(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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

      //  WaitUtils.WaitTime2();
        if(testData.get("Newproposal").equalsIgnoreCase("No")){
            viewquote.Selectpropsalnobtngap(testData.get("Newproposal"));
        }
        viewquote.Selectpremiumannuitygap(testData.get("annuitypremium"));
        if(testData.get("annuitypremium").equalsIgnoreCase("Premium")){
            viewquote.clickclosealert();
        }
        viewquote.Selectannuitymodegap(testData.get("annuitymode"));
        if(testData.get("Isannuitypremiumfield").equalsIgnoreCase("Yes")) {
            if(testData.get("annuitypremiumfield").equalsIgnoreCase("Annuity")){
            viewquote.Enterannuitygap(testData.get("amt"));
            }
            if(testData.get("annuitypremiumfield").equalsIgnoreCase("Premium")){
                viewquote.Enterpremiumgap(testData.get("amt"));
            }
        }
        viewquote.selectannuityoptionsgap(testData.get("annuityopts"));
        if(testData.get("annuityopts").equalsIgnoreCase("Option 1 - Life Annuity")){
            viewquote.selectlevelincreaseanngap(testData.get("levelincreasingannuity"));
            if(testData.get("levelincreasingannuity").equalsIgnoreCase("Increasing")){
                viewquote.SelectIncomeEscalationRateWeb(testData.get("IncomeEscalationRateSalariedGAP"));
            }
            viewquote.selectSinglejointlifegap(testData.get("singlejointlife"));
            if(testData.get("singlejointlife").equalsIgnoreCase("Joint Life")){
                viewquote.selectjointliferelngap(testData.get("jointliferel"));
                TestUtil.scrollTillEndOfPage(getDriver());
                viewquote.clickOnnrijointlifeweb(testData.get("jointlifenri"));
                viewquote.enterPANcardjointlife(testData.get("JointlifePAN"));
                viewquote.fillDOBdetailsJointlifeWeb(testData.get("Jointlifeday"),testData.get("Jointlifemonth"),testData.get("Jointlifeyear"));
                viewquote.clickOnsavebuttonjointlifeweb();
            }
        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 2 - Annuity Certain for a specified period and thereafter for life")){
            viewquote.selectannuitycurtainopt2gap(testData.get("annuitycurtain"));
        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 3 - Life Annuity with return of Balance of Purchase Price")){
            if(testData.get("levelincreasingannuity").equalsIgnoreCase("Increasing")){
                viewquote.SelectIncomeEscalationRateWeb(testData.get("IncomeEscalationRateSalariedGAP"));
            }
        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 4 - Life Annuity with 50% Annuity payable to Secondary Annuitant on death of Primary Annuitant")){
            viewquote.selectjointliferelngap(testData.get("jointliferel"));
            TestUtil.scrollTillEndOfPage(getDriver());
            viewquote.clickOnnrijointlifeweb(testData.get("jointlifenri"));
            viewquote.enterPANcardjointlife(testData.get("JointlifePAN"));
            viewquote.fillDOBdetailsJointlifeWeb(testData.get("Jointlifeday"),testData.get("Jointlifemonth"),testData.get("Jointlifeyear"));
            viewquote.clickOnsavebuttonjointlifeweb();
        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 5 - Life Annuity with Return of Purchase Price")){
            viewquote.selectSinglejointlifegap(testData.get("singlejointlife"));
            viewquote.selectropopt5gap(testData.get("rop"));
            if(testData.get("singlejointlife").equalsIgnoreCase("Joint Life")){
                viewquote.selectjointliferelngap(testData.get("jointliferel"));
                TestUtil.scrollTillEndOfPage(getDriver());
                viewquote.clickOnnrijointlifeweb(testData.get("jointlifenri"));
                viewquote.enterPANcardjointlife(testData.get("JointlifePAN"));
                viewquote.fillDOBdetailsJointlifeWeb(testData.get("Jointlifeday"),testData.get("Jointlifemonth"),testData.get("Jointlifeyear"));
                viewquote.clickOnsavebuttonjointlifeweb();
            }
        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 8 - Life Annuity with Partial Return of Purchase Price to survivor and balance to nominee")){
            viewquote.selectjointliferelngap(testData.get("jointliferel"));
            TestUtil.scrollTillEndOfPage(getDriver());
            viewquote.clickOnnrijointlifeweb(testData.get("jointlifenri"));
            viewquote.enterPANcardjointlife(testData.get("JointlifePAN"));
            viewquote.fillDOBdetailsJointlifeWeb(testData.get("Jointlifeday"),testData.get("Jointlifemonth"),testData.get("Jointlifeyear"));
            viewquote.clickOnsavebuttonjointlifeweb();

        }
        if(testData.get("annuityopts").equalsIgnoreCase("Option 9 - Deferred Life Annuity with Return of Premium")){
            viewquote.selectSinglejointlifegap(testData.get("singlejointlife"));
            viewquote.SelectidefermentperiodWeb(testData.get("DefermentPeriod"));
            viewquote.SelectPPTWeb(testData.get("pptGAP"));
            if(!testData.get("pptGAP").equalsIgnoreCase("Single pay")){
                viewquote.SelectPaymodeWeb(testData.get("paymodeGAP"));
            }
        }

    }
}
