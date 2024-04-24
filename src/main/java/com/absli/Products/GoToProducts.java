package com.absli.Products;

import Utils.EndToEndProMajorJourney;
import Utils.EndToEndProSameJourney;
import Utils.GoToPSMpageJourney;
import Utils.GoToPMSpage_MajorJourney;


import Utils.ViewQuoteFactoryAIP;
import Utils.ViewQuoteFactoryAkshaya;
import Utils.ViewQuoteFactoryFMP;
import Utils.ViewQuoteFactoryGMS;
import Utils.ViewQuoteFactoryN_Ayush;
import Utils.*;
import com.absli.base.TestBase;
import com.absli.dataproviders.DataProviders;
import com.absli.pageObjects.*;
import com.absli.utils.PropertiesUtils;
import com.absli.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.TestUtil;

import java.io.IOException;
import java.util.HashMap;

import static com.absli.base.BasePage.getDriver;

public class GoToProducts {
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
    //------------------------------------------------------Same GMS------------------------------------------------------------------//

    public void selectproduct(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

        TestUtil.scrollTillTOPOfPage(getDriver());

        if (testData.get("IsselectGMSPlan").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryGMS().ViewPageGMS(getDriver(),testData);
        }
        if (testData.get("IsselectFMPPlan").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryFMP().ViewPageFMP(getDriver(),testData);
        }
        if (testData.get("IsselectAIPPlan").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryAIP().ViewPageAIP(getDriver(),testData);
        }
        if (testData.get("IsselectN_AyushPlan").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryN_Ayush().ViewPageNischitAyush(getDriver(),testData);
        }
        if (testData.get("IsselectAkshaya").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryAkshaya().ViewPageAkshaya(getDriver(),testData);
        }
        if (testData.get("IsselectN_Laabh").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryN_Laabh().ViewPageNischitLaabh(getDriver(),testData);
        }
        if (testData.get("IsselectASP").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryASP().ViewPageASP(getDriver(),testData);
        }
        if (testData.get("IsselectVision_Endo").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryVision_Endo().ViewPageVision_Endo(getDriver(),testData);
        }
        if (testData.get("IsselectFortune").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryFortune().ViewPageFortune(getDriver(),testData);
        }
        if (testData.get("IsselectN_Pension").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryN_Pension().ViewPageNischitPension(getDriver(),testData);
        }
        if (testData.get("IsselectPSK").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryPSK().ViewPagePSK(getDriver(),testData);
        }
        if (testData.get("IsselectWealth_secure").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryWealth_secure().ViewPageWealth_secure(getDriver(),testData);
        }
        if (testData.get("IsselectWealth_aspire").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryWealth_aspire().ViewPageWealth_aspire(getDriver(),testData);
        }
        if (testData.get("IsselectASK").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryASK().ViewPageASK(getDriver(),testData);
        }
        if (testData.get("IsselectChild_future").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryChild_future().ViewPageChild_future(getDriver(),testData);
        }
        if (testData.get("IsselectDigi").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryDigi().ViewPageDigi(getDriver(),testData);
        }
        if (testData.get("IsselectCancer").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryCancershield().ViewPageCancershield(getDriver(),testData);
        }
        if (testData.get("IsselectSalaried").equalsIgnoreCase("YES")) {
            new ViewQuoteFactorySalaried().ViewPageSalaried(getDriver(),testData);
        }
        if (testData.get("IsselectVisionlife").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryVision_lifeincome().ViewPageVision_lifeincome(getDriver(),testData);
        }
        if (testData.get("IsselectVisionlifeplus").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryVision_lifeincomeplus().ViewPageVision_lifeincomeplus(getDriver(),testData);
        }
        if (testData.get("IsselectVisionstar").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryVision_star().ViewPageVision_star(getDriver(),testData);
        }
        if (testData.get("IsselectCriti_Shield").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryCriti().ViewPageCritishield(getDriver(),testData);
        }
        if (testData.get("IsselectAssured_flexi").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryAssured_flexi().ViewPageAssured_flexi(getDriver(),testData);
        }
        if (testData.get("IsselectPlatinum").equalsIgnoreCase("YES")) {
            new ViewQuoteFactoryPlatinum().ViewPagePlatinum_gain(getDriver(),testData);
        }
        if(testData.get("IsselectGAP").equalsIgnoreCase("YES")){
            new ViewQuoteFactoryGAP().ViewPageGAP(getDriver(),testData);
        }

    }
}
