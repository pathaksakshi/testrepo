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

public class EndToEndProMinorJourney {
	
	
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


    public void gotoEndToEndMinorJourney(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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
        minorpersonalhealth=new MinorPersonalHealth(getDriver());
        insurerlifestyle = new InsurerLifestyle(getDriver());
        insudecleration=new InsurabilityDeclaration(getDriver());
        minorpersonalinfo=new MinorPersonalInfo(getDriver());
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

        String SumAssuredValue = getDriver().findElement(By.xpath("(//p[@id='Initial-premium-amount'])[3]")).getText();

        Thread.sleep(2000);
        customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        dashboard.checkLoaderWeb();

        // Plan Info Page //
        // Assertion for policy tab and wop rider //
        loginPage.Applicationnumber(); // printing of application number in report //

        WebElement PayMode = getDriver().findElement(By.xpath("//div[contains(@class,'payment-cycle-text')]"));
        String PayModeValue = PayMode.getText();
        TestUtil.verifybgColor(PayMode, driver);
        String[] PayModeValueupdate = PayModeValue.split(": ");
        softassert.assertEquals(PayModeValueupdate[1], testData.get("IsAddRider"));

        WebElement PlanOption = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[1]"));
        String PlanOptionValue = PlanOption.getText();
        TestUtil.verifybgColor(PlanOption, driver);
        softassert.assertEquals(PlanOptionValue, testData.get("benefitotion"));

        WebElement PT = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[2]"));
        String PTValue = PT.getText();
        TestUtil.verifybgColor(PT, driver);
        String[] PTValueupdate = PTValue.split(" ");
        softassert.assertEquals(PTValueupdate[0], testData.get("policyterm"));

        WebElement PPT = getDriver().findElement(By.xpath("(//div[contains(@class,'quote-plan-option')])[4]"));
        String PPTValue = PPT.getText();
        TestUtil.verifybgColor(PPT, driver);
        softassert.assertEquals(PPTValue, testData.get("ppt"));

//        if (testData.get("IsAddRider").equalsIgnoreCase("YES")) {
//            TestUtil.scrollTillEndOfPage(getDriver());
//            WebElement WOPEle = getDriver().findElement(By.xpath("(//label[contains(@class,'quote-plan-option')])[1]"));
//            String WOPEleValue = WOPEle.getText();
//            TestUtil.verifybgColor(WOPEle, getDriver());
//            softassert.assertEquals(WOPEleValue, testData.get("Iswavierofpremium"));
//        }
        TestUtil.scrollTillEndOfPage(getDriver());
        viewquote.clickConfirmPlanBtn(); // Confirm Plan button QA
        dashboard.checkLoaderWeb();


        // Proposer and Minor Communication Details Page //
        communicationdetails.SelectpreflangWeb(testData.get("PreferredLang"));
        communicationdetails.enteraltnumber(testData.get("AlternateNumber"));
        communicationdetails.enterresnumber(testData.get("ResidenceNumber"));
        customerprofile.cpnextbutton(); // customer profile Next Button(QA)
        Thread.sleep(5000);
        communicationdetails.EnterInsuredMobileNoweb(testData.get("InsuredMobno"));
        customerprofile.cpnextbutton(); // customer profile Next Button(QA)
        dashboard.checkLoaderWeb();

        //new milestone customer photo (LA-12416)
        if(prop.getProperties("customerPhotoSelection").equalsIgnoreCase("Upload") ){
            address.uploadCustomerPhoto();
            dashboard.checkLoaderWeb();
            wait.WaitTime2();
            address.clickCustomerPhotoNext();
            wait.WaitTime2();
        } else if (prop.getProperties("customerPhotoSelection").equalsIgnoreCase("Do It later")) {
            address.clickDoItLaterCustomerPhoto();
            address.clickDoItLaterCustomerPhoto();
            wait.WaitTime2();
        }

        // Bank Details Page //
        dashboard.checkLoaderWeb();
        bankdetails.Clickaccounttypeweb(testData.get("TypeAccount"));
        //customerprofile.cpnextbutton();
        bankdetails.clicksubmitBtn();
        bankdetails.ClickPaymentMethodweb(testData.get("paymentmethod"));


        bankdetails.ClickPaymentMethodweb(testData.get("paymentmethod"));

        if (testData.get("paymentmethod").equalsIgnoreCase("Single Premium")) {
            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
        if (testData.get("paymentmethod").equalsIgnoreCase("Direct Bill")) {

            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
        if (testData.get("paymentmethod").equalsIgnoreCase("e-SI")) {
            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
            TestUtil.scrollTillEndOfPage(getDriver());
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
            bankdetails.EnterIFSCforesiWeb(testData.get("IFSCcode"));
            bankdetails.EnterACCnoforesiWeb(testData.get("AccountNumber"));
            bankdetails.ClickAccTypeesiweb(testData.get("AccountType"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
        if (testData.get("paymentmethod").equalsIgnoreCase("NACH/Direct Debit")) {
            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            TestUtil.scrollTillEndOfPage(getDriver());
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
        dashboard.checkLoaderWeb();


        // Proposer-Insured Personal info tab // (Minor Scenario)
        proposerpersonalinfo.SelectMaritalStatusweb(testData.get("Propmarital"));
        if (testData.get("Propmarital").equalsIgnoreCase("Married")) {
            if (testData.get("PropTitle").equalsIgnoreCase("Ms.")) {
                proposerpersonalinfo.EnterMaidenNameweb(testData.get("propMaidenName"));
            } else if (testData.get("PropTitle").equalsIgnoreCase("Mrs.")) {
                proposerpersonalinfo.EnterMaidenNameweb(testData.get("propMaidenName"));
            }
        }
        proposerpersonalinfo.EnterFatherSpaouseNameweb(testData.get("PropfatherSpouse"));
        proposerpersonalinfo.EnterMotherNameweb(testData.get("Propmothername"));
        proposerpersonalinfo.SelectBirthPlaceweb(testData.get("ProposerBirthPlace"));
        if (testData.get("IsHaveEIA").equalsIgnoreCase("Want to Apply")) {
            proposerpersonalinfo.EIAwanttoapply(testData.get("PreferredIR"));
        } else if (testData.get("IsHaveEIA").equalsIgnoreCase("Yes")) {
            proposerpersonalinfo.EIAwantyes();
        }
        if (testData.get("IsPropPolitical").equalsIgnoreCase("Yes")) {
            proposerpersonalinfo.IsaProppolitical(testData.get("PoliticalDetails"));
        }

        // Proposer Professional Details tab //
        proposerprofdetails.SelectQualificationweb(testData.get("Propqualification"));
        proposerprofdetails.SelectOccupationweb(testData.get("PropoccupationOption"));
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Professional")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Business Owner")) {
            proposerprofdetails.EnterOccupationNameofbusinessweb(testData.get("Propnameofbusiness"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Service")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Farmer/Agriculturist")) {

        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Driver")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Armed Forces")) {
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Army/Navy/Police")) {
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Skilled Worker")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Jeweller")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Builder")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Scrap Dealer")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Doctor")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Lawyer")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Architect")) {
            proposerprofdetails.EnterOccupationNameofEmployeeweb(testData.get("Propnameofemployee"));
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("PropoccupationOption").equalsIgnoreCase("Others")) {
            proposerprofdetails.EnterOccupationNatureofbusinessweb(testData.get("Propnatureofbusiness"));
            proposerprofdetails.selectOccupationTypeofOrganisationweb(testData.get("Proptypeoforganisation"));
            proposerprofdetails.EnterOccupationDesignationweb(testData.get("PropDesignation"));
        }
        if (testData.get("IsAreYouRegisterPerson").equalsIgnoreCase("Yes")) {
            proposerprofdetails.ClickOnAreYouRegisterPersonaUnderGSTweb(testData.get("GSTnumber"));
        }
        proposerprofdetails.ClickonProposerAddInsuredButtonweb();


        // Minor personal info tab //
        dashboard.checkLoaderWeb();
        Thread.sleep(2000);
        minorpersonalinfo.EnterMinorFatherNameweb(testData.get("MinorFatherName"));
        minorpersonalinfo.EnterMinorMotherNameweb(testData.get("MinorMotherName"));
        minorpersonalinfo.selectminorliving(testData.get("MinorLivingWith"));
        minorpersonalinfo.SelectBirthPlaceweb(testData.get("MinorBirthPlace"));
        TestUtil.scrollTillEndOfPage(getDriver());

        if (testData.get("IsInsuPolitical").equalsIgnoreCase("Yes")) {
            insurerpersonalinfo.IsMinorpolitical(testData.get("IsInsuPolitical"));
        }
        minorpersonalinfo.selectEducationStage(testData.get("Stage"), testData.get("Studying"), testData.get("CollegeStudy"));
        insurerlifestyle.ClickSaveContinueBtn(); //Save & Continue Button QA//
        dashboard.checkLoaderWeb();

        // Existing Policy and Refused Policy Tab //
        if (testData.get("AddexistingPolicy").equalsIgnoreCase("Existing Policy")) {
            insurerpersonalinfo.IsAddexistingPolicy(testData.get("AddexistingPolicy"), testData.get("InsurerName"), testData.get("SumAssured"));
        }
        if (testData.get("AddrefusedPolicy").equalsIgnoreCase("Refused Policy")) {
            insurerpersonalinfo.IsAddrefusedPolicy(testData.get("AddrefusedPolicy"), testData.get("PolicyType"), testData.get("InsurerNameRef"), testData.get("SumAssuredref"), testData.get("ReasonRef"));
        }
        customerprofile.cdnextbutton(); // customer details NEXT button(QA)

        // Purpose Of Insurance //
        TestUtil.scrollTillTOPOfPage(getDriver());
        insurerpersonalinfo.SelectpurposeofIns(testData.get("InsurancePurpose1"), testData.get("InsurancePurpose2"), testData.get("InsurancePurpose3"));
        TestUtil.scrollTillEndOfPage(getDriver());
        customerprofile.cpnextbutton(); // customer profile Next Button(QA)


        // Address Details page //
        address.SelectcommaddtypeWeb(testData.get("CommAddressType"));
        //address.entercommadd3(testData.get(CommAddress3));
        //address.entercommlandmark(testData.get("CommLandmark"));
        TestUtil.scrollTillEndOfPage(getDriver());
        address.clickConfirmcapital();  // CONFIRM button QA //
        dashboard.checkLoaderWeb();

//        // family Insurance History //
//        if (testData.get("IsFamilyInsuHistory").equalsIgnoreCase("Yes")) {
//            minorpersonalinfo.familyinsuhistory();
//            minorpersonalinfo.enterbrothernumber(testData.get("BrotherSibling"));
//            minorpersonalinfo.entersisternumber(testData.get("SisterSibling"));
//            minorpersonalinfo.selectchildreninsured(testData.get("AreChildrenInsured"), testData.get("childrenDetails"));
//            minorpersonalinfo.selectexistingpolicyfather(testData.get("EXistingFather"), testData.get("FinurerName"), testData.get("Fsumassured"), testData.get("Fpolnumber"), testData.get("Fdate"), testData.get("Fmonth"), testData.get("Fyear"), testData.get("Fissueyear"));
//
//            minorpersonalinfo.selectexistingpolicymother(testData.get("EXistingMother"), testData.get("MinurerName"), testData.get("Msumassured"), testData.get("Mpolnumber"), testData.get("Mdate"), testData.get("Mmonth"), testData.get("Myear"), testData.get("Missueyear"));
//
//            minorpersonalinfo.selectexistingpolicybrother(testData.get("EXistingBrother"), testData.get("BinurerName"), testData.get("Bsumassured"), testData.get("Bpolnumber"), testData.get("Bdate"), testData.get("Bmonth"), testData.get("Byear"), testData.get("Bissueyear"));
//
//            minorpersonalinfo.selectexistingpolicysister(testData.get("EXistingSister"), testData.get("SinurerName"), testData.get("Ssumassured"), testData.get("Spolnumber"), testData.get("Sdate"), testData.get("Smonth"), testData.get("Syear"), testData.get("Sissueyear"));
//
//        }

        // Insurer Personal Health Details Tab //

//        insupersonalhealth.EnterHeightFeet(testData.get("HeightFeet"));
//            insupersonalhealth.EnterHeightInch(testData.get("HeightInch"));
//            insupersonalhealth.EnterWeight(testData.get("weight"));
//            if (testData.get("Isweightgainlost").equalsIgnoreCase("Yes")) {
//                insupersonalhealth.ClickOnIsThereAnyWeightChangesYESBtnWeb(testData.get("Weightgainlost"));
//            }
//            insupersonalhealth.ClickSaveContinuecapitalBtn(); //SAVE & CONTINUE button QA//
//            dashboard.checkLoaderWeb();
//
//
//            // Proposer Lifestyle Details Tab //
//            if (testData.get("IsLifeStyleDetails").equalsIgnoreCase("Yes")) {
//                if (testData.get("LifeStyleDetailsN").equalsIgnoreCase("Narcotics")) {
//                    insurerlifestyle.selectNarcoticsYESButton();
//
//                    insurerlifestyle.EnterReasonForNarcotics(testData.get("ProvideDetails"));
//                }
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Alcohol Consumption']")));
//                if (testData.get("LifeStyleDetailsA").equalsIgnoreCase("Alcohol Consumption")) {
//                    insurerlifestyle.selectAlcohalConsumptionYESButton();
//
//                    insurerlifestyle.TypeofAlcoholConsume(testData.get("TypeOfAlcohal"), testData.get("Quantity"), testData.get("Frequency"));
//                }
//                if (testData.get("AlcoholAdvise").equalsIgnoreCase("Yes")) {
//                    insurerlifestyle.selectAdvicealcoholYESButton(testData.get("Hospital"), testData.get("Reason"), testData.get("VisitDate"), testData.get("VisitMonth"), testData.get("VisitYear"));
//                }
//                if (testData.get("AlcoholAddicts").equalsIgnoreCase("Yes")) {
//                    insurerlifestyle.selectAlcohalAddictsYESButton();
//                }
//                if (testData.get("AlcoholAddinfo").equalsIgnoreCase("Yes")) {
//                    insurerlifestyle.selectAlcohalAddinfoYESButton(testData.get("Addinfo"));
//                }
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Tobacco / Nicotine ']")));
//                if (testData.get("LifeStyleDetailsTN").equalsIgnoreCase("Tobacco/Nicotine")) {
//                    insurerlifestyle.selectTobacconicotinYESButton();
//                    insurerlifestyle.Clickdurationmonthweb(testData.get("MonthDuration"));
//                    insurerlifestyle.TypeofTobacco(testData.get("Tobaccotype"), testData.get("quantity"), testData.get("noofyear"));
//                }
//                if (testData.get("Advicetostop").equalsIgnoreCase("Yes")) {
//                    insurerlifestyle.selectAdvisetostopYESButton(testData.get("SpecifyReason"));
//                }
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Hazardous Activities']")));
//                if (testData.get("LifeStyleDetailsHZ").equalsIgnoreCase("Hazardous Activities")) {
//                    insurerlifestyle.selectHazardousActivityYESButton();
//                    insurerlifestyle.HazardousSelectOption1(testData.get("Hazardactivity"));
//                    insurerlifestyle.enteryerashazard(testData.get("MentionYears"));
//                    insurerlifestyle.HazardousSelectOption2(testData.get("HazardActivityBy"));
//                }
//                TestUtil.scrollTillEndOfPage(getDriver());
//                if (testData.get("LifeStyleDetailsTrv").equalsIgnoreCase("Travel")) {
//                    insurerlifestyle.selectTraveloutsideYESButton();
//                    insurerlifestyle.TravelDetailstwelvemonth(testData.get("Country"), testData.get("City"), testData.get("DateofDept"), testData.get("DateofArrvl"), testData.get("Visatype"));
//                }
//                insurerlifestyle.ClickSaveContinueBtn(); //Save & Continue Button QA//
//                dashboard.checkLoaderWeb();
//
//            }
//            // Proposer Medical History Tab //
//            if (testData.get("IsFamilyMedical").equalsIgnoreCase("Yes")) {
//                if (testData.get("IsFamilyMedicalMHBS").equalsIgnoreCase("Mellitus/High blood sugar")) {
//                    insurerfamilymedical.ClickOnMellitusCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalHD").equalsIgnoreCase("Hereditary disorder")) {
//                    insurerfamilymedical.ClickOnHereditarydisorderCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalCD").equalsIgnoreCase("Chronic disorder")) {
//                    insurerfamilymedical.ClickOnChronicdisorderCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalHA").equalsIgnoreCase("Heart ailment")) {
//                    insurerfamilymedical.ClickOnHeartailmentCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalStroke").equalsIgnoreCase("Stroke")) {
//                    insurerfamilymedical.ClickOnStrokeCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalHBP").equalsIgnoreCase("High blood pressure")) {
//                    insurerfamilymedical.ClickOnHighbloodpressureCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalCncr").equalsIgnoreCase("Cancer")) {
//                    insurerfamilymedical.ClickOnCancerCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalDiab").equalsIgnoreCase("Diabetes")) {
//                    insurerfamilymedical.ClickOnDiabetesCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalKS").equalsIgnoreCase("Kidney disease")) {
//                    insurerfamilymedical.ClickOnKidneydiseaseCheckboxWeb();
//
//                }
//                if (testData.get("IsFamilyMedicalPyr").equalsIgnoreCase("Paralysis")) {
//                    insurerfamilymedical.ClickOnParalysisCheckboxWeb();
//
//                }
//                insurerfamilymedical.EnterProvideDetailsCommonWeb(testData.get("Providemeddetails"));
//
//                // Proposer family medical tab // father+mother+brother+sister
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Father']")));
//                if (testData.get("IsFMBSstatus").equalsIgnoreCase("Yes")) {
//                    insurerfamilymedical.FatherOnFamilyMedicalWeb(testData.get("FatherStatus"), testData.get("FAge"), testData.get("FHealthState"), testData.get("FDeathage"), testData.get("FDeathcause"));
//                    TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Mother']")));
//                    insurerfamilymedical.MotherOnFamilyMedicalWeb(testData.get("MotherStatus"), testData.get("MAge"), testData.get("MHealthState"), testData.get("MDeathage"), testData.get("MDeathcause"));
//                }
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Brother']")));
//                if (testData.get("IsAddBrother").equalsIgnoreCase("Yes")) {
//                    insurerfamilymedical.BrotheraddFamilyMedicalWeb();
//                    insurerfamilymedical.BrotherOnFamilyMedicalWeb(testData.get("BrotherStatus"), testData.get("BAge"), testData.get("BHealthState"), testData.get("BDeathage"), testData.get("BDeathcause"));
//                    insurerfamilymedical.BrothersaveFamilyMedicalWeb();
//                }
//                TestUtil.scrollTillEndOfPage(getDriver());
//                if (testData.get("IsAddSister").equalsIgnoreCase("Yes")) {
//                    insurerfamilymedical.SisteraddFamilyMedicalWeb();
//                    insurerfamilymedical.SisterOnFamilyMedicalWeb(testData.get("SisterStatus"), testData.get("SAge"), testData.get("SHealthState"), testData.get("SDeathage"), testData.get("SDeathcause"));
//                    insurerfamilymedical.SisterrsaveFamilyMedicalWeb();
//                }
//                TestUtil.scrollTillEndOfPage(getDriver());
//                insupersonalhealth.ClickSaveContinuecapitalBtn(); //SAVE & CONTINUE button QA//
//                dashboard.checkLoaderWeb();
//
//
//
////            //COVID 19 CODE
////            // covid 19 details//
////            if (testData.get("IsCoviddetails").equalsIgnoreCase("Yes")) {
////                insurercoviddetails.ClickOnhaveyoutestedCOVID19Web();
////                insurercoviddetails.enterdignodateweb(testData.get("DiagnosisDate"));
////                insurercoviddetails.enterrecoverydateweb(testData.get("RecoveryDate"));
////
////                if (testData.get("IsTreatmentTaken").equalsIgnoreCase("Yes")) {
////                    insurercoviddetails.ClickOntreatmenttakenWeb();
////
////                    if (testData.get("IsCoviddetailsAsymptomatic").equalsIgnoreCase("Yes")) {
////                        insurercoviddetails.ClickOnAsymptyesWeb();
////                    } else if (testData.get("IsCoviddetailsAsymptomatic").equalsIgnoreCase("No")) {
////                        insurercoviddetails.ClickOnAsymptnoWeb();
////                    }
////                    if (testData.get("IsCoviddetailsHomeQ").equalsIgnoreCase("Yes")) {
////                        insurercoviddetails.ClickOnHomequryesWeb();
////                    } else if (testData.get("IsCoviddetailsHomeQ").equalsIgnoreCase("No")) {
////                        insurercoviddetails.ClickOnHomequrynoWeb();
////                    }
////                    if (testData.get("IsCoviddetailsHospitalized").equalsIgnoreCase("Yes")) {
////                        insurercoviddetails.ClickOnHospitalyesWeb();
////                    } else if (testData.get("IsCoviddetailsHospitalized").equalsIgnoreCase("No")) {
////                        insurercoviddetails.ClickOnHospitalnoWeb();
////                    }
////                } else {
////                    insurercoviddetails.ClickOnTretmentTakenNOBTNWeb();
////                }
////            }
////            insurerlifestyle.ClickSaveContinueBtn();
//            // Proposer Medical History Tab //
//            if (testData.get("IsFamilyMedicaldetails").equalsIgnoreCase("Yes")) {
//                if (testData.get("IsAbsentFromWork").equalsIgnoreCase("Absent From Work")) {
//                    insurermedicalhistory.ClickonAbsentfromWork();
//
//                    insurermedicalhistory.EnterAbsentfromWorkCurrentSymptoms(testData.get("AFWcurrentsymptoms"));
//                    insurermedicalhistory.EnterAbsentfromWorkDoctorDetails(testData.get("AFWdoctordetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsult(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosis(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalization(testData.get("AFWdetails"));
//                } else if (testData.get("IsAbsentFromWork").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonAbsentfromWorkNO();
//                }
//                if (testData.get("IsHospitalization").equalsIgnoreCase("Hospitalization")) {
//                    insurermedicalhistory.Clickonhospitalization();
//
//                    insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomhos(testData.get("AFWcurrentsymptoms"));
//                    insurermedicalhistory.EnterAbsentfromWorkDoctorDetailshos(testData.get("AFWdoctordetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationhos(testData.get("AFWdetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsulthos(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosishos(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                } else if (testData.get("IsHospitalization").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonhospitalizationNO();
//                }
//                if (testData.get("IsAilments").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonAilmentsNO();
//                }
//                if (testData.get("IsDisorder").equalsIgnoreCase("Disorder")) {
//                    insurermedicalhistory.ClickonDisorder();
//
//                    insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomdsdr(testData.get("AFWcurrentsymptoms"));
//                    insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsdsdr(testData.get("AFWdoctordetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdsdr(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisdsdr(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationdsdr(testData.get("AFWdetails"));
//                } else if (testData.get("IsDisorder").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonDisorderNO();
//                }
//                if (testData.get("IsSpouseHealth").equalsIgnoreCase("Spouse Health")) {
//                    insurermedicalhistory.ClickonSpouseHealth();
//
//                    insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomspouse(testData.get("AFWcurrentsymptoms"));
//                    insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsspouse(testData.get("AFWdoctordetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdspouse(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisspouse(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationspouse(testData.get("AFWdetails"));
//                } else if (testData.get("IsSpouseHealth").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonSpouseHealthNO();
//                }
//                if (testData.get("IsOtherSymptoms").equalsIgnoreCase("Other symptoms")) {
//                    insurermedicalhistory.Clickonothersymp();
//
//                    insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomother(testData.get("AFWcurrentsymptoms"));
//                    insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsother(testData.get("AFWdoctordetails"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdother(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisother(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                    insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationother(testData.get("AFWdetails"));
//                } else if (testData.get("IsOtherSymptoms").equalsIgnoreCase("No")) {
//                    insurermedicalhistory.ClickonothersympNO();
//                }
//                if (testData.get("PropTitle").equalsIgnoreCase("Mrs.") || (testData.get("PropTitle").equalsIgnoreCase("Ms."))) {
//                    if (testData.get("IsPregnant").equalsIgnoreCase("Are You Pregnant")) {
//                        insurermedicalhistory.ClickonAreyoupregnant();
//
//                        insurermedicalhistory.EnterAreyoupregnantnumberofweeks(testData.get("NoofWeeeks"));
//                        insurermedicalhistory.EnterAreyoupregnantCurrentSymptoms(testData.get("AFWcurrentsymptoms"));
//                        insurermedicalhistory.EnterAreyoupregnantDoctorDetails(testData.get("AFWdoctordetails"));
//                        insurermedicalhistory.EnterAreyoupregnantDateOfLastConsult(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                        insurermedicalhistory.EnterAreyoupregnantDateOfDiagnosis(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                        insurermedicalhistory.EnterAreyoupregnantDetailsofHospitalization(testData.get("AFWdetails"));
//                    } else if (testData.get("IsPregnant").equalsIgnoreCase("No")) {
//                        insurermedicalhistory.ClickonAreyoupregnantNo();
//                    }
//                    if (testData.get("IsGynaecological").equalsIgnoreCase("Gynaecological Problem")) {
//                        insurermedicalhistory.Clickongynaecological();
//
//                        insurermedicalhistory.EntergynaecologicalCurrentSymptoms(testData.get("AFWcurrentsymptoms"));
//                        insurermedicalhistory.EntergynaecologicalDoctorDetails(testData.get("AFWdoctordetails"));
//                        insurermedicalhistory.EntergynaecologicalDateOfLastConsult(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
//                        insurermedicalhistory.EntergynaecologicalDateOfDiagnosis(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
//                        insurermedicalhistory.EntergynaecologicalDetailsofHospitalization(testData.get("AFWdetails"));
//                    } else if (testData.get("IsGynaecological").equalsIgnoreCase("No")) {
//                        insurermedicalhistory.ClickongynaecologicalNo();
//                    }
//                }
//            }
//            insurerlifestyle.ClickSaveContinueBtn(); //Save & Continue Button QA//
//            dashboard.checkLoaderWeb();
//
//        } // Applicable for WOP only

//        // Minor Personal Health Details Tab //
        minorpersonalhealth.EnterMinorHeightFeet(testData.get("MinorHeightFeet"));
        minorpersonalhealth.EnterMinorHeightInch(testData.get("MinorHeightInch"));
        minorpersonalhealth.EnterMinorWeight(testData.get("Minorweight"));
        if (testData.get("IsMinorweightgainlost").equalsIgnoreCase("Yes")) {
            minorpersonalhealth.ClickOnIsThereAnyWeightChangesMinorYESBtnWeb(testData.get("MinorWeightgainlost"));
        }
        TestUtil.scrollTillEndOfPage(getDriver());
        insupersonalhealth.ClickSaveContinuecapitalminorBtn(); //SAVE & CONTINUE button QA//minor
        dashboard.checkLoaderWeb();


        // minor family medical tab //
        if (testData.get("IsFamilyMedical").equalsIgnoreCase("Yes")) {
            if (testData.get("IsFamilyMedicalHD").equalsIgnoreCase("Hereditary disorder")) {
                insurerfamilymedical.ClickOnHereditarydisorderCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalCD").equalsIgnoreCase("Chronic disorder")) {
                insurerfamilymedical.ClickOnChronicdisorderCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalHA").equalsIgnoreCase("Heart ailment")) {
                insurerfamilymedical.ClickOnHeartailmentCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalStroke").equalsIgnoreCase("Stroke")) {
                insurerfamilymedical.ClickOnStrokeCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalHBP").equalsIgnoreCase("High blood pressure")) {
                insurerfamilymedical.ClickOnHighbloodpressureCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalCncr").equalsIgnoreCase("Cancer")) {
                insurerfamilymedical.ClickOnCancerCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalDiab").equalsIgnoreCase("Diabetes")) {
                insurerfamilymedical.ClickOnDiabetesCheckboxWeb();

            }
            insurerfamilymedical.EnterProvideDetailsCommonWeb(testData.get("Providemeddetails"));
            TestUtil.scrollTillEndOfPage(getDriver());
            insupersonalhealth.ClickSaveContinuecapitalBtn(); //SAVE & CONTINUE button QA//
            dashboard.checkLoaderWeb();

        }

        // Minor Insurability Declaration Tab //
        if (testData.get("IsInsurabiltityDecleration").equalsIgnoreCase("Yes")) {
            if (testData.get("IsHospital").equalsIgnoreCase("Hospitalization")) {
                insudecleration.Clickonhospitalization();
                insudecleration.EnterHospCurrentSymptoms(testData.get("currentsymptoms"));
                insudecleration.EnterHospDoctorDetails(testData.get("doctordetails"));
                insudecleration.EnterHospDateOfLastConsult(testData.get("LCday"), testData.get("LCmonth"), testData.get("LCyear"));
                insudecleration.EnterHospDateOfDiagnosis(testData.get("DDday"), testData.get("DDmonth"), testData.get("DDyear"));
                insudecleration.EnterHospDetailsofHospitalization(testData.get("details"));
            }
            if (testData.get("IsDiagnosis1").equalsIgnoreCase("Diagnosis 1")) {
                insudecleration.ClickonDiagnosis1();

                insudecleration.Enterdianosis1CurrentSymptoms(testData.get("currentsymptoms"));
                insudecleration.Enterdiagnosis1DoctorDetails(testData.get("doctordetails"));
                insudecleration.Enterdiagnosis1DateOfLastConsult(testData.get("LCday"), testData.get("LCmonth"), testData.get("LCyear"));
                insudecleration.Enterdiagnosis1DateOfDiagnosis(testData.get("DDday"), testData.get("DDmonth"), testData.get("DDyear"));
                insudecleration.Enterdiagnosis1DetailsofHospitalization(testData.get("details"));
            }
            if (testData.get("IsDiagnosis2").equalsIgnoreCase("Diagnosis 2")) {
                insudecleration.ClickonDiagnosis2();

                insudecleration.Enterdianosis2CurrentSymptoms(testData.get("currentsymptoms"));
                insudecleration.Enterdiagnosis2DoctorDetails(testData.get("doctordetails"));
                insudecleration.Enterdiagnosis2DateOfLastConsult(testData.get("LCday"), testData.get("LCmonth"), testData.get("LCyear"));
                insudecleration.Enterdiagnosis2DateOfDiagnosis(testData.get("DDday"), testData.get("DDmonth"), testData.get("DDyear"));
                insudecleration.Enterdiagnosis2DetailsofHospitalization(testData.get("details"));
            }
            if (testData.get("IsOtherSympt").equalsIgnoreCase("Other symptoms")) {
                insudecleration.ClickonOthersymptoms();

                insudecleration.EnterothersCurrentSymptoms(testData.get("currentsymptoms"));
                insudecleration.EnterothersDoctorDetails(testData.get("doctordetails"));
                insudecleration.EnterothersDateOfLastConsult(testData.get("LCday"), testData.get("LCmonth"), testData.get("LCyear"));
                insudecleration.EnterothersDateOfDiagnosis(testData.get("DDday"), testData.get("DDmonth"), testData.get("DDyear"));
                insudecleration.EnterothersDetailsofHospitalization(testData.get("details"));
            }
        }
        insurerlifestyle.ClickSaveContinueBtn(); //Save & Continue Button QA//
        dashboard.checkLoaderWeb();


        // Proposer NRI Mandate //
        if (testData.get("propNRI").equalsIgnoreCase("YES")) {
            nriMandate.clickOnAreYouIndianOrigin(testData.get("isIndianOrigin"));
            nriMandate.enterCountryOfPermanentResidence(testData.get("pResidence"));
            nriMandate.enterDateFromWhichBecamePR(testData.get("datePR"));
            nriMandate.enterDateLastVisitedIndia(testData.get("lastVisitedIndiaDate"));
            nriMandate.enterPassportNumber(testData.get("passportNumber"));
            nriMandate.clickOnPlaceForSigningApplication(testData.get("placeOfSigningApplication")); //Place For Signing Application

            // FNIO - PIO //
            if (testData.get("FNIOPIOButton").equalsIgnoreCase("Yes")) {
                nriMandate.clickOnFNIOPIO(testData.get("FNIOPIOButton"));
                nriMandate.durationOfStayIndiaFNIO(testData.get("durationInYrs"), testData.get("durationInMonths"));
                nriMandate.selectNatureOfVisa(testData.get("natureOfVisaHeld"));
                nriMandate.selectPurposeOfStayIndiaFNIO(testData.get("purposeOfStayFNIO_PIO"));
                if (testData.get("purposeOfStayFNIO_PIO").equalsIgnoreCase("Student")) {
                    nriMandate.enterNatureOfStayIndiaFNIO(testData.get("natureOfStayFNIO_PIO"));
                } else if (testData.get("purposeOfStayFNIO_PIO").equalsIgnoreCase("Others")) {
                    nriMandate.enterSpecificReasonFNIO_PIO(testData.get("specificReasonFNIO_PIO"));
                }
                nriMandate.selectPIO_OCICard(testData.get("selectPIO_OCICard"));
            }

            //Purpose of your stay abroad//
            nriMandate.clickOnPurposeOfStayAbroad(testData.get("purposeOfStayAbroad"));
            if (testData.get("purposeOfStayAbroad").equalsIgnoreCase("Student")) {
                nriMandate.enterStudentNatureOfStay(testData.get("studentNatureOfStayAbroad"));
            } else if (testData.get("purposeOfStayAbroad").equalsIgnoreCase("Others")) {
                nriMandate.enterSpecificNatureOfStayAbroad(testData.get("stayAbroadSpecificReason"));
            }
            nriMandate.enterIntendedDurationOfStayAbroad(testData.get("intendedDurationYear"), testData.get("intendedDurationMonth"));

            //Residence Address while in Abroad//
            nriMandate.addTypeNri(testData.get("nriAddressType"));
            nriMandate.enterNriAddress1(testData.get("address1Nri"));
            nriMandate.enterNriAddress2(testData.get("address2Nri"));
            nriMandate.enterNriAddress3(testData.get("address3Nri"));
            nriMandate.enterNriArea(testData.get("areaNri"));
            nriMandate.enterNriCity(testData.get("cityNri"));
            nriMandate.enterNriState(testData.get("stateNri"));
            nriMandate.enterNriPinCode(testData.get("pinCodeNri"));
            nriMandate.enterNriTeleNumberResidence(testData.get("teleNumberResidenceNri"));
            nriMandate.enterNriTeleNumberOffice(testData.get("teleNumberOfficeNri"));

            //Have you traveled over the last 12 months?//
            nriMandate.clickOnTravelledLast12MonthButton(testData.get("travelledOverLast12Months"));
            if (testData.get("travelledOverLast12Months").equalsIgnoreCase("Yes")) {
                nriMandate.enterCountryTravelledOverLast12Months(testData.get("countryTravelledLast12Months"));
                nriMandate.enterLast12MonthCity(testData.get("last12MonthCity"));
                nriMandate.enterLast12MonthsDepartDate(testData.get("lastTravelled12MonthsDepartDate"));
                nriMandate.enterLast12MonthsArrivalDate(testData.get("lastTravelled12MonthsArrivalDate"));
                nriMandate.selectVisaType(testData.get("lastTravelled12MonthsVisaType"));

                nriMandate.clickSaveButton();
            }

            //Are you planning to travel in next 12 months?//
            if (testData.get("travelledOverNext12Months").equalsIgnoreCase("Yes")) {
                nriMandate.clickOnTravelledNext12MonthButton(testData.get("travelledOverNext12Months"));
                nriMandate.enterCountryTravelledOverNext12Months(testData.get("countryTravelledNext12Months"));
                nriMandate.enterNext12MonthCity(testData.get("Next12MonthCity"));
                nriMandate.enterNext12MonthsDepartDate(testData.get("nextTravelled12MonthsDepartDate"));
                nriMandate.enterNext12MonthsArrivalDate(testData.get("nextTravelled12MonthsArrivalDate"));
                nriMandate.selectNext12MonthsVisaType(testData.get("nextTravelled12MonthsVisaType"));

                nriMandate.clickSaveButton();
            }

            //Bank Details//
            nriMandate.doYouHaveNriAccount(testData.get("haveNriAccount"));
            if (testData.get("haveNriAccount").equalsIgnoreCase("Yes")) {
                nriMandate.typeOfNriAccount(testData.get("nriAccountType"));
                nriMandate.enterNRIMicrCode(testData.get("nriMicrCode"));
            }

            //Exchange Facility availed?//
            nriMandate.clickOnExchangeFacilityButton(testData.get("exchangeFacility"));
            if (testData.get("exchangeFacility").equalsIgnoreCase("Yes")) {
                nriMandate.enterRBIPermitNumber(testData.get("rbiPermitNumber"));
                nriMandate.enterRBIPermitDetails(testData.get("rbiPermitDetail"));
                nriMandate.enterRBIOfficeName(testData.get("rbiOfficeName"));
            }

            //Payment Details//
            nriMandate.clickOnPaymentDetails(testData.get("nriPaymentDetails"));
            if (testData.get("nriPaymentDetails").equalsIgnoreCase("Others")) {
                nriMandate.enterProvideDetails(testData.get("providePaymentDetail"));
            }
            TestUtil.scrollTillEndOfPage(getDriver());

            if (testData.get("InsuNRI").equalsIgnoreCase("YES")) {
                nriMandate.clickOnAddInsuredDetails();
            } else if ((testData.get("propNRI").equalsIgnoreCase("YES"))) {
                nriMandate.clickOnContinue();
            }
            dashboard.checkLoaderWeb();

        }

        // insurer NRI Mandate //
        if (testData.get("InsuNRI").equalsIgnoreCase("YES")) {
            nriMandate.clickOnAreYouIndianOrigin(testData.get("isIndianOriginInsur"));
            nriMandate.enterCountryOfPermanentResidence(testData.get("pResidenceInsur"));
            nriMandate.enterDateFromWhichBecamePR(testData.get("datePRInsur"));
            nriMandate.enterDateLastVisitedIndia(testData.get("lastVisitedIndiaDateInsur"));
            nriMandate.enterPassportNumber(testData.get("passportNumberInsur"));
            nriMandate.clickOnPlaceForSigningApplication(testData.get("placeOfSigningApplicationInsur"));

            //FNIO/PIO//
            if (testData.get("FNIOPIOButtonInsur").equalsIgnoreCase("Yes")) {
                nriMandate.clickOnFNIOPIO(testData.get("FNIOPIOButtonInsur"));
                nriMandate.durationOfStayIndiaFNIO(testData.get("durationInYrsInsur"), testData.get("durationInMonthsInsur"));
                nriMandate.selectNatureOfVisa(testData.get("natureOfVisaHeldInsur"));
                nriMandate.selectPurposeOfStayIndiaFNIO(testData.get("purposeOfStayFNIO_PIOInsur"));
                if (testData.get("purposeOfStayFNIO_PIOInsur").equalsIgnoreCase("Student")) {
                    nriMandate.enterNatureOfStayIndiaFNIO(testData.get("natureOfStayFNIO_PIOInsur"));
                } else if (testData.get("purposeOfStayFNIO_PIOInsur").equalsIgnoreCase("Others")) {
                    nriMandate.enterSpecificReasonFNIO_PIO(testData.get("specificReasonFNIO_PIOInsur"));
                }
                nriMandate.selectPIO_OCICard(testData.get("selectPIO_OCICardInsur"));
            }

            //Residence Address while in India//
            if (testData.get("isAddSameAsPrimary").equalsIgnoreCase("YES")) {
                insurerNriMandate.addressSameASPropPrimary();
            } else if (testData.get("isAddSameAsPrimary").equalsIgnoreCase("NO")) {
                insurerNriMandate.enterIndianAddress1(testData.get("indianAddress1"));
                insurerNriMandate.enterIndianAddress2(testData.get("indianAddress2"));
                insurerNriMandate.enterIndianAddress3(testData.get("indianAddress3"));
                insurerNriMandate.enterIndianArea(testData.get("IndianAr"));
                insurerNriMandate.enterIndianCity(testData.get("indianCity"));
                insurerNriMandate.enterIndianState(testData.get("indianState"));
                insurerNriMandate.enterIndianPinCode(testData.get("indianPincode"));
            }

            //Purpose of your stay abroad//
            nriMandate.clickOnPurposeOfStayAbroad(testData.get("purposeOfStayAbroadInsur"));
            if (testData.get("purposeOfStayAbroadInsur").equalsIgnoreCase("Student")) {
                nriMandate.enterStudentNatureOfStay(testData.get("studentNatureOfStayAbroadInsur"));
            } else if (testData.get("purposeOfStayAbroadInsur").equalsIgnoreCase("Others")) {
                nriMandate.enterSpecificNatureOfStayAbroad(testData.get("stayAbroadSpecificReasonInsur"));
            }
            nriMandate.enterIntendedDurationOfStayAbroad(testData.get("intendedDurationYearInsur"), testData.get("intendedDurationMonthInsur"));

            //Residence Address while in Abroad//
            nriMandate.addTypeNri(testData.get("nriAddressTypeInsur"));
            nriMandate.enterNriAddress1(testData.get("address1NriInsur"));
            nriMandate.enterNriAddress2(testData.get("address2NriInsur"));
            nriMandate.enterNriAddress3(testData.get("address3NriInsur"));
            nriMandate.enterNriArea(testData.get("areaNriInsur"));
            nriMandate.enterNriCity(testData.get("cityNriInsur"));
            nriMandate.enterNriState(testData.get("stateNriInsur"));
            nriMandate.enterNriPinCode(testData.get("pinCodeNriInsur"));
            nriMandate.enterNrimobilenumber(testData.get("mobilenumberNri"));
            nriMandate.enterNriTeleNumberResidence(testData.get("teleNumberResidenceNriInsur"));
            nriMandate.enterNriTeleNumberOffice(testData.get("teleNumberOfficeNriInsur"));

            //Have you traveled over the last 12 months? *//
            insurerNriMandate.clickOnTravelledLast12MonthButton(testData.get("travelledOverLast12MonthsInsur"));
            if (testData.get("travelledOverLast12MonthsInsur").equalsIgnoreCase("Yes")) {
                nriMandate.enterCountryTravelledOverLast12Months(testData.get("countryTravelledLast12MonthsInsur"));
                nriMandate.enterLast12MonthCity(testData.get("last12MonthCityInsur"));
                nriMandate.enterLast12MonthsDepartDate(testData.get("lastTravelled12MonthsDepartDateInsur"));
                nriMandate.enterLast12MonthsArrivalDate(testData.get("lastTravelled12MonthsArrivalDateInsur"));
                nriMandate.selectVisaType(testData.get("lastTravelled12MonthsVisaTypeInsur"));

                nriMandate.clickSaveButton();
            }

            //Are you planning to travel in next 12 months? *//
            insurerNriMandate.clickOnTravelledNext12MonthButton(testData.get("travelledOverNext12MonthsInsur"));
            if (testData.get("travelledOverNext12MonthsInsur").equalsIgnoreCase("Yes")) {
                nriMandate.enterCountryTravelledOverNext12Months(testData.get("countryTravelledNext12MonthsInsur"));
                nriMandate.enterNext12MonthCity(testData.get("Next12MonthCityInsur"));
                nriMandate.enterNext12MonthsDepartDate(testData.get("nextTravelled12MonthsDepartDateInsur"));
                nriMandate.enterNext12MonthsArrivalDate(testData.get("nextTravelled12MonthsArrivalDateInsur"));
                nriMandate.selectNext12MonthsVisaType(testData.get("nextTravelled12MonthsVisaTypeInsur"));

                nriMandate.clickSaveButton();
            }
            insurerNriMandate.clickOnInsuredContinueButton();
            rna.ClickOnAgreeButtonWeb();

        }
        // Review and accept page //
        TestUtil.scrollTillEndOfPage(getDriver());
        rna.ClickOnRandACheckboxWeb();
        rna.ClickOnAgreeButtonWeb();

//
//        // E customer consent declaration //
//        if (testData.get("IsECCD").equalsIgnoreCase("Yes")) {
//            eccd.ECCDCompleteNow();
//            eccd.ClickOnyestoallCheckboxWeb();
//            eccd.ClickOnrecurringdepositCheckboxWeb();
//            eccd.ClickOnABSLICheckboxWeb();
//            eccd.ClickOnillustrationCheckboxWeb();
//            eccd.SelectRelationshipweb(testData.get("SelectRelationECCD"));
//            eccd.Selectmodeofpaymentweb(testData.get("ModeofPaymentECCD"));
//            eccd.Acceptbutton();
//            dashboard.checkLoaderWeb();
//            eccd.enterProposerOTPeccdweb(prop.getProperties("ProposerOTP"));
//            bankdetails.clicksubmitBtn();
//            dashboard.checkLoaderWeb();
//            eccd.ClickGoBackbutton();
//            eccd.Nextbutton();
//        } else {
//            eccd.ClickDoitLaterbutton();
//            dashboard.checkLoaderWeb();
//
//        }
//
//        // Payment Page //
//        if (testData.get("IsSelectChequeORDDPayment").equalsIgnoreCase("Yes")) {
//            if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Cheque")) {
//                paymentpage.ClickOnChequeAndDDModeweb();
//                paymentpage.UploadChequeAndDDImgweb();
//                paymentpage.EnterChequeDDNoWeb(testData.get("ChequeDDNo"));
//                paymentpage.EnterDDMMYYONCDDWeb(testData.get("CDDday"), testData.get("CDDMonth"), testData.get("CDDYear"));
//                paymentpage.EnterIFSCCodeOnCDDWeb(testData.get("CDDIFSCcode"));
//                paymentpage.ClickCDDPaymentSubmitBTNweb();
//                customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                dashboard.checkLoaderWeb();
//
//
//            } else if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Demand Draft")) {
//                paymentpage.UploadChequeAndDDImgweb();
//                paymentpage.EnterChequeDDNoWeb(testData.get("ChequeDDNo"));
//                paymentpage.EnterDDMMYYONCDDWeb(testData.get("CDDday"), testData.get("CDDMonth"), testData.get("CDDYear"));
//                paymentpage.EnterIFSCCodeOnCDDWeb(testData.get("CDDIFSCcode"));
//                dashboard.checkLoaderWeb();
//                TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("(//span[text()='Submit'])[1]")));
//                paymentpage.UploadDECLARATIONFORMImgweb();
//                dashboard.checkLoaderWeb();
//                paymentpage.ClickCDDPaymentSubmitBTNweb();
//                customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                dashboard.checkLoaderWeb();
//
//            } else if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Fund Transfer")) {
//                TestUtil.scrollTillEndOfPage(getDriver());
//                paymentpage.ClickOnFundTransferModeweb();
//                paymentpage.UploadFundtransferImgweb();
//                TestUtil.scrollTillEndOfPage(getDriver());
//                paymentpage.EnterpolicyNumberFTWeb(testData.get("PolicyNumber"));
//
//                WebElement Balamount = getDriver().findElement(By.xpath("(//div[contains(@class,'win-back-balance')])[2]"));
//                String BalamountValue = Balamount.getText();
//                paymentpage.EnterAmountFTWeb(BalamountValue);
//                paymentpage.ClickOnFTsavebuttonweb();
//                paymentpage.ClickOnFTredeembuttonweb();
//                customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                dashboard.checkLoaderWeb();
//
//            }
//        } else {
//            TestUtil.scrollTillEndOfPage(getDriver());
//            paymentpage.ClickpaymentDoitLaterbutton();
//            dashboard.checkLoaderWeb();
//
//        }
//

    }
}
