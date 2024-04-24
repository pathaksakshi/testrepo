package Utils;

import com.absli.base.ExtentFactory;
import com.absli.pageObjects.*;
import com.absli.utils.PropertiesUtils;
import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import util.TestUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.absli.base.BasePage.getDriver;

public class EndToEndProSameJourney {
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


    public void gotoEndToEndSameJourney(WebDriver driver, HashMap<String, String> testData) throws InterruptedException, IOException {

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


        dashboard.checkLoaderWeb();
        String SumAssuredValue = getDriver().findElement(By.xpath("(//p[@id='Initial-premium-amount'])[3]")).getText();
        TestUtil.scrollTillEndOfPage(getDriver());
        customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        //dashboard.checkLoaderWeb();


        // Plan Info Page //
        // Assertion for policy tab , all riders and ABG //
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

        // Communication Details Page //
        dashboard.checkLoaderWeb();
        communicationdetails.SelectpreflangWeb(testData.get("PreferredLang"));
        communicationdetails.enteraltnumber(testData.get("AlternateNumber"));
        communicationdetails.enterresnumber(testData.get("ResidenceNumber"));
        communicationdetails.clicksubmitBtn();
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
            wait.WaitTime2();
        }
        // Bank Details Page //
        dashboard.checkLoaderWeb();
        bankdetails.Clickaccounttypeweb(testData.get("TypeAccount"));
        //customerprofile.cpnextbutton();
        bankdetails.clicksubmitBtn();
        bankdetails.ClickPaymentMethodweb(testData.get("paymentmethod"));

        dashboard.checkLoaderWeb();
        if (testData.get("paymentmethod").equalsIgnoreCase("Direct Bill")) {

            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
            if (testData.get("paymentmethod").equalsIgnoreCase("e-SI")) {
            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
            TestUtil.scrollTillEndOfPage(getDriver());
            WaitUtils.WaitTime2();
            dashboard.checkLoaderWeb();
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
            dashboard.checkLoaderWeb();
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
        if (testData.get("paymentmethod").equalsIgnoreCase("Single Premium")) {

            bankdetails.Clicksourcefundweb(testData.get("sourceFund"));
            customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        }
        dashboard.checkLoaderWeb();


        // Proposer-Insured Personal info tab // (Same Scenario)
        if(!(testData.get("LeadID")).equalsIgnoreCase("505056")) {
            insurerpersonalinfo.SelectMaritalStatusweb(testData.get("Insumarital"));
            insurerpersonalinfo.SelectMaritalStatusweb(testData.get("Insumarital"));
        }
        if (testData.get("Insumarital").equalsIgnoreCase("Married")) {
            if (testData.get("PropTitle").equalsIgnoreCase("Ms.")) {
                insurerpersonalinfo.EnterMaidenNameweb(prop.getProperties("maidenname"));
            } else if (testData.get("PropTitle").equalsIgnoreCase("Mrs.")) {
                insurerpersonalinfo.EnterMaidenNameweb(prop.getProperties("maidenname"));
            }
        }
        insurerpersonalinfo.EnterFatherSpaouseNameweb(testData.get("fatherSpouse"));
        insurerpersonalinfo.EnterMotherNameweb(testData.get("mothername"));
        WaitUtils.WaitTime2();
        insurerpersonalinfo.SelectBirthPlaceweb(testData.get("InsurerBirthPlace"));
        if (testData.get("IsHaveEIA").equalsIgnoreCase("Want to Apply")) {
            insurerpersonalinfo.EIAwanttoapply(testData.get("PreferredIR"));
        } else if (testData.get("IsHaveEIA").equalsIgnoreCase("Yes")) {
            insurerpersonalinfo.EIAwantyes();
        }
        if (testData.get("IsInsuPolitical").equalsIgnoreCase("Yes")) {
            insurerpersonalinfo.IsInsupolitical(testData.get("PoliticalDetails"));
        }

        // Insurer Professional Details tab //
        TestUtil.scrollTillEndOfPage(getDriver());
        insuprofdetails.SelectQualificationweb(testData.get("qualification"));
        insuprofdetails.SelectOccupationweb(testData.get("occupationOption"));
        if (testData.get("occupationOption").equalsIgnoreCase("Professional")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Business Owner")) {
            insuprofdetails.EnterOccupationNameofbusinessweb(testData.get("nameofbusiness"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Service")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Farmer/Agriculturist")) {

        }
        if (testData.get("occupationOption").equalsIgnoreCase("Driver")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Armed Forces")) {
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Army/Navy/Police")) {
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Skilled Worker")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Jeweller")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb2(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Builder")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb2(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Scrap Dealer")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb2(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Doctor")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Lawyer")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Architect")) {
            insuprofdetails.EnterOccupationNameofEmployeeweb(testData.get("NameOfEmployer"));
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Housewife/Homemaker")) {
            insuprofdetails.SpouseAnnualIncome(prop.getProperties("AnnualIncome"));
//            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
//            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
//            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Others")) {
            insuprofdetails.EnterOccupationNatureofbusinessweb(testData.get("natureofbusiness"));
            insuprofdetails.selectOccupationTypeofOrganisationweb(testData.get("TypeOfOrganisation"));
            insuprofdetails.EnterOccupationDesignationweb(testData.get("Designation"));
        }
        if (testData.get("occupationOption").equalsIgnoreCase("Retired")) {
            insuprofdetails.Enterspouseannualincome(prop.getProperties("AnnualIncome"));

        }
//        if (testData.get("IsAreYouRegisterPerson").equalsIgnoreCase("Yes")) {
//            insuprofdetails.ClickOnAreYouRegisterPersonaUnderGSTweb(testData.get("GSTnumber"));
//        }
        insuprofdetails.ClickonSaveContinueButtonweb();
        dashboard.checkLoaderWeb();

        // Existing Policy and Refused Policy Tab //
        if (testData.get("AddexistingPolicy").equalsIgnoreCase("Existing Policy")) {
            insurerpersonalinfo.IsAddexistingPolicy(testData.get("AddexistingPolicy"), testData.get("InsurerName"), testData.get("SumAssured"));
        }
        if (testData.get("AddrefusedPolicy").equalsIgnoreCase("Refused Policy")) {
            insurerpersonalinfo.IsAddrefusedPolicy(testData.get("AddrefusedPolicy"), testData.get("PolicyType"), testData.get("InsurerNameRef"), testData.get("SumAssuredref"), testData.get("ReasonRef"));
        }
        WaitUtils.WaitTime2();
        TestUtil.scrollTillEndOfPage(getDriver());
        WaitUtils.WaitTime2();
        Thread.sleep(2000);
        customerprofile.cdnextbutton(); // customer details NEXT button(QA)

        // Purpose Of Insurance //
        dashboard.checkLoaderWeb();
        TestUtil.scrollTillTOPOfPage(getDriver());
        insurerpersonalinfo.SelectpurposeofIns(testData.get("InsurancePurpose1"), testData.get("InsurancePurpose2"), testData.get("InsurancePurpose3"));
        TestUtil.scrollTillEndOfPage(getDriver());
        customerprofile.cpnextbutton(); // customer profile Next Button(QA)
        dashboard.checkLoaderWeb();

        // Address Details page //
        address.SelectcommaddtypeWeb(testData.get("CommAddressType"));
        //address.entercommadd3(CommAddress3);
        address.entercommlandmark(testData.get("CommLandmark"));
        TestUtil.scrollTillEndOfPage(getDriver());
        address.clickConfirmcapital();  // CONFIRM button QA //
        dashboard.checkLoaderWeb();

        // Nominee Details Page //
        WaitUtils.WaitTime2();
        nominee.enternomineefname(testData.get("nomineeFirstName"));
        nominee.enternomineelname(testData.get("nomineeLastName"));
        nominee.fillDOBdetailsNomineeWeb(testData.get("day"), testData.get("month"), testData.get("year"));
        nominee.Clicknomineegenderweb(testData.get("nomineegender"));
        nominee.SelectRelationshipwithProposerdropdownWeb(testData.get("relationship"));
        nominee.enternomineeshare(testData.get("nomineeshare"));
        TestUtil.scrollTillEndOfPage(getDriver());
        customerprofile.cdnextbutton(); // customer details NEXT button(QA)
        dashboard.checkLoaderWeb();

        //--------------------------------------------NEW CODE ----------------------------------------------------//

        // Insurer Personal Health Details Tab //
        WaitUtils.WaitTime2();
        insupersonalhealth.EnterHeightFeet(testData.get("HeightFeet"));
        insupersonalhealth.EnterHeightInch(testData.get("HeightInch"));
        insupersonalhealth.EnterWeight(testData.get("weight"));
        if (testData.get("Isweightgainlost").equalsIgnoreCase("Yes")) {
            insupersonalhealth.ClickOnIsThereAnyWeightChangesYESBtnWeb(testData.get("Weightgainlost"));
        }
        insupersonalhealth.ClickSaveContinuecapitalBtn(); // SAVE & CONTINUE button QA//

        // Insurer Lifestyle Details Tab //
        if (testData.get("IsLifeStyleDetails").equalsIgnoreCase("YES")) {
            if (testData.get("IsNarcoticsDetails").equalsIgnoreCase("YES")) {
                insurerlifestyle.selectNarcoticsYESButton();
                insurerlifestyle.EnterReasonForNarcotics(testData.get("ProvideDetails"));
            }
            TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Alcohol Consumption']")));

            if (testData.get("IsAlcoholConsumptionDetails").equalsIgnoreCase("YES")) {
                insurerlifestyle.selectAlcohalConsumptionYESButton();
                insurerlifestyle.EnterReasonForAlcohol("ProvideDetails");
                insurerlifestyle.TypeofAlcoholConsume(testData.get("TypeOfAlcohal"), testData.get("Quantity"), testData.get("Frequency"));

                if (testData.get("AlcoholAdviseQ1").equalsIgnoreCase("YES")) {
                    insurerlifestyle.selectAdvicealcoholYESButton(testData.get("Hospital"), testData.get("Reason"),
                            testData.get("VisitDate"), testData.get("VisitMonth"), testData.get("VisitYear"));
                }
                if (testData.get("AlcoholAddictsQ2").equalsIgnoreCase("YES")) {
                    insurerlifestyle.selectAlcohalAddictsYESButton();
                }
                if (testData.get("AlcoholAddinfoQ3").equalsIgnoreCase("YES")) {
                    insurerlifestyle.selectAlcohalAddinfoYESButton(testData.get("Addinfo"));
                }
            }

            TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Tobacco / Nicotine ']")));

            if (testData.get("IsTobaccoNicotine").equalsIgnoreCase("YES")) {
                try{
                    insurerlifestyle.selectTobacconicotinYESButton();
                }
                catch (Exception e){
                    System.out.println("Field is not editable");
                }
               // insurerlifestyle.selectTobacconicotinYESButton();
                if(!(testData.get("LeadID")).equalsIgnoreCase("BCR10")) {
                    insurerlifestyle.Clickdurationmonthweb(testData.get("MonthDuration"));
                }
                insurerlifestyle.TypeofTobacco(testData.get("Tobaccotype"), testData.get("quantity"),
                        testData.get("noofyear"));

                if (testData.get("Advicetostop").equalsIgnoreCase("Yes")) {
                    insurerlifestyle.selectAdvisetostopYESButton(testData.get("SpecifyReason"));
                }
            }

            TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("//div[text()='Hazardous Activities']")));
             if (testData.get("IsHazardousActivities").equalsIgnoreCase("YES")) {
                insurerlifestyle.selectHazardousActivityYESButton();
                insurerlifestyle.HazardousSelectOption1(testData.get("Hazardactivity"));
                insurerlifestyle.enteryerashazard(testData.get("MentionYears"));
                insurerlifestyle.HazardousSelectOption2(testData.get("HazardActivityBy"));
            }
            TestUtil.scrollTillEndOfPage(getDriver());
            if (testData.get("IsTravel").equalsIgnoreCase("YES")) {
                insurerlifestyle.selectTraveloutsideYESButton();
                insurerlifestyle.TravelDetailstwelvemonth(testData.get("Country"), testData.get("City"), testData.get("DateofDept"), testData.get("DateofArrvl"), testData.get("Visatype"));
            }
        }
        TestUtil.scrollTillEndOfPage(getDriver());
        insurerlifestyle.ClickSaveContinueBtn(); // Save & Continue Button QA//
        dashboard.checkLoaderWeb();
        // Insurer Medical History Tab //

        if (testData.get("IsFamilyMedical").equalsIgnoreCase("YES")) {
            if (testData.get("IsFamilyMedicalMHBS").equalsIgnoreCase("Mellitus/High blood sugar")) {
                insurerfamilymedical.ClickOnMellitusCheckboxWeb();

            }
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
            if (testData.get("IsFamilyMedicalKS").equalsIgnoreCase("Kidney disease")) {
                insurerfamilymedical.ClickOnKidneydiseaseCheckboxWeb();

            }
            if (testData.get("IsFamilyMedicalPyr").equalsIgnoreCase("Paralysis")) {
                insurerfamilymedical.ClickOnParalysisCheckboxWeb();

            }
            insurerfamilymedical.EnterProvideDetailsCommonWeb(testData.get("Providemeddetails"));

            TestUtil.scrollToElement(getDriver(), getDriver().findElement(By.xpath("//div[text()='Mother']")));
            wait.WaitTime2();
            insurerfamilymedical.ValidationsOfFatherOnFamilyMedicalWeb(testData.get("FMBSLivingDemise"), testData.get("FMBSAgeDeath"), testData.get("FMBSStateAndCause"));
            wait.WaitTime2();
            if (testData.get("FMBSStateAndCause").equalsIgnoreCase("Others") && testData.get("FMBSLivingDemise").equalsIgnoreCase("Deceased")) {
                insurerfamilymedical.EnterOtherFilesOnFamilyMedical(testData.get("Providemeddetails"));

            } else if (testData.get("FMBSStateAndCause").equalsIgnoreCase("Others") && testData.get("FMBSLivingDemise").equalsIgnoreCase("Living")) {
                insurerfamilymedical.EnterOtherFilesOnFamilyMedicalliving(testData.get("Providemeddetails"));
            }
            WebElement Bro = getDriver().findElement(By.xpath("//div[text()='Brother']"));
            TestUtil.scrollToElement(driver, Bro);
            wait.WaitTime2();
            insurerfamilymedical.ValidationsOfMotherOnFamilyMedicalWeb(testData.get("FMBSLivingDemise"), testData.get("FMBSAgeDeath"), testData.get("FMBSStateAndCause"));
            wait.WaitTime2();
            if (testData.get("FMBSStateAndCause").equalsIgnoreCase("Others") && testData.get("FMBSLivingDemise").equalsIgnoreCase("Deceased")) {
                insurerfamilymedical.EnterOtherFilesOnFamilyMedicalother(testData.get("Providemeddetails"));

            } else if (testData.get("FMBSStateAndCause").equalsIgnoreCase("Others") && testData.get("FMBSLivingDemise").equalsIgnoreCase("Living")) {
                insurerfamilymedical.EnterOtherFilesOnFamilyMedicallivingMother(testData.get("Providemeddetails"));
            }

            if (testData.get("IsBrother").equalsIgnoreCase("YES")) {
                TestUtil.scrollTillEndOfPage(driver);
                insurerfamilymedical.ClickonAddBrotherBTNWeb();
                wait.WaitTime2();
                insurerfamilymedical.ValidationsOfBrotherOnFamilyMedicalWeb(testData.get("BSLivingDeceased"), testData.get("BrotherSisAge"), testData.get("BrotherSisStateOfHealth"));
                if (testData.get("BrotherSisStateOfHealth").equalsIgnoreCase("Others") && testData.get("BSLivingDeceased").equalsIgnoreCase("Deceased")) {
                    insurerfamilymedical.EnterOtherFilesOnFamilyMedicalBro(testData.get("Providemeddetails"));

                } else if (testData.get("BrotherSisStateOfHealth").equalsIgnoreCase("Others") && testData.get("BSLivingDeceased").equalsIgnoreCase("Living")) {
                    insurerfamilymedical.EnterOtherFilesOnFamilyMedicallivingBro(testData.get("Providemeddetails"));
                }
                insurerfamilymedical.ClickonSaveBrotherAndSisterBTNWeb();
            }

            if (testData.get("IsSister").equalsIgnoreCase("YES")) {
                TestUtil.scrollTillEndOfPage(driver);
                insurerfamilymedical.ClickonAddSisterBTNWeb1(testData.get("IsBrother"));
                wait.WaitTime2();
                insurerfamilymedical.ValidationsOfSisterOnFamilyMedicalWeb(testData.get("BSLivingDeceased"), testData.get("BrotherSisAge"), testData.get("BrotherSisStateOfHealth"));
                if (testData.get("BrotherSisStateOfHealth").equalsIgnoreCase("Others") && testData.get("BSLivingDeceased").equalsIgnoreCase("Deceased")) {
                    insurerfamilymedical.EnterOtherFilesOnFamilyMedicalBro(testData.get("Providemeddetails"));

                } else if (testData.get("BrotherSisStateOfHealth").equalsIgnoreCase("Others") && testData.get("BSLivingDeceased").equalsIgnoreCase("Living")) {
                    insurerfamilymedical.EnterOtherFilesOnFamilyMedicallivingBro(testData.get("Providemeddetails"));
                }
                Thread.sleep(1000);
                wait.WaitTime2();
                insurerfamilymedical.ClickonSaveBrotherAndSisterBTNWeb();
            }
        }
        insupersonalhealth.ClickSaveContinuecapitalBtn();
//        //COVID 19 CODE
//        // covid 19 details//
//        try{
//        if (testData.get("IsCoviddetails").equalsIgnoreCase("Yes")) {
//            insurercoviddetails.ClickOnhaveyoutestedCOVID19Web();
//            insurercoviddetails.enterdignodateweb(testData.get("DiagnosisDate"));
//            insurercoviddetails.enterrecoverydateweb(testData.get("RecoveryDate"));
//
//            if (testData.get("IsTreatmentTaken").equalsIgnoreCase("Yes")) {
//                insurercoviddetails.ClickOntreatmenttakenWeb();
//
//                if (testData.get("IsCoviddetailsAsymptomatic").equalsIgnoreCase("Yes")) {
//                    insurercoviddetails.ClickOnAsymptyesWeb();
//                } else if (testData.get("IsCoviddetailsAsymptomatic").equalsIgnoreCase("No")) {
//                    insurercoviddetails.ClickOnAsymptnoWeb();
//                }
//                if (testData.get("IsCoviddetailsHomeQ").equalsIgnoreCase("Yes")) {
//                    insurercoviddetails.ClickOnHomequryesWeb();
//                } else if (testData.get("IsCoviddetailsHomeQ").equalsIgnoreCase("No")) {
//                    insurercoviddetails.ClickOnHomequrynoWeb();
//                }
//                if (testData.get("IsCoviddetailsHospitalized").equalsIgnoreCase("Yes")) {
//                    insurercoviddetails.ClickOnHospitalyesWeb();
//                } else if (testData.get("IsCoviddetailsHospitalized").equalsIgnoreCase("No")) {
//                    insurercoviddetails.ClickOnHospitalnoWeb();
//                }
//            } else {
//                insurercoviddetails.ClickOnTretmentTakenNOBTNWeb();
//            }
//        }
//        }catch (Exception e){
//            System.out.println("NO COVID 19 DETAILS TAB IS PRESENT");
//        }
//
//        insurerlifestyle.ClickSaveContinueBtn();

        // Insurer Medical History Tab //
        insurermedicalhistory.Clickononotoall(); // for No To All check box //

        if (testData.get("IsFamilyMedicaldetails").equalsIgnoreCase("YES")) {
            if (testData.get("IsAbsentFromWork").equalsIgnoreCase("YES")) {
                insurermedicalhistory.ClickonAbsentfromWork();

                insurermedicalhistory.EnterAbsentfromWorkCurrentSymptoms(testData.get("AFWcurrentsymptoms"));
                insurermedicalhistory.EnterAbsentfromWorkDoctorDetails(testData.get("AFWdoctordetails"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsult(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosis(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
                insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalization(testData.get("AFWdetails"));
            } else if (testData.get("IsAbsentFromWork").equalsIgnoreCase("NO")) {
                insurermedicalhistory.ClickonAbsentfromWorkNO();
            }
            if (testData.get("IsHospitalization").equalsIgnoreCase("YES")) {
                insurermedicalhistory.Clickonhospitalization();

                insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomhos(testData.get("AFWcurrentsymptoms"));
                insurermedicalhistory.EnterAbsentfromWorkDoctorDetailshos(testData.get("AFWdoctordetails"));
                insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationhos(testData.get("AFWdetails"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsulthos(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosishos(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
            } else if (testData.get("IsHospitalization").equalsIgnoreCase("No")) {
                insurermedicalhistory.ClickonhospitalizationNO();
            }
            if (testData.get("IsAilments").equalsIgnoreCase("No")) {
                insurermedicalhistory.ClickonAilmentsNO();
            }
            if (testData.get("IsDisorder").equalsIgnoreCase("YES")) {
                insurermedicalhistory.ClickonDisorder();

                insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomdsdr(testData.get("AFWcurrentsymptoms"));
                insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsdsdr(testData.get("AFWdoctordetails"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdsdr(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisdsdr(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
                insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationdsdr(testData.get("AFWdetails"));
            } else if (testData.get("IsDisorder").equalsIgnoreCase("No")) {
                insurermedicalhistory.ClickonDisorderNO();
            }
            if (testData.get("IsSpouseHealth").equalsIgnoreCase("YES")) {
                insurermedicalhistory.ClickonSpouseHealth();

                insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomspouse(testData.get("AFWcurrentsymptoms"));
                insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsspouse(testData.get("AFWdoctordetails"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdspouse(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisspouse(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
                insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationspouse(testData.get("AFWdetails"));
            } else if (testData.get("IsSpouseHealth").equalsIgnoreCase("No")) {
                insurermedicalhistory.ClickonSpouseHealthNO();
            }
            if (testData.get("IsOtherSymptoms").equalsIgnoreCase("YES")) {
                insurermedicalhistory.Clickonothersymp();

                insurermedicalhistory.EnterAbsentfromWorkCurrentSymptomother(testData.get("AFWcurrentsymptoms"));
                insurermedicalhistory.EnterAbsentfromWorkDoctorDetailsother(testData.get("AFWdoctordetails"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfLastConsultdother(testData.get("AFWLCday"), testData.get("AFWLCmonth"), testData.get("AFWLCyear"));
                insurermedicalhistory.EnterAbsentfromWorkDateOfDiagnosisother(testData.get("AFWDDday"), testData.get("AFWDDmonth"), testData.get("AFWDDyear"));
                insurermedicalhistory.EnterAbsentfromWorkDetailsofHospitalizationother(testData.get("AFWdetails"));
            } else if (testData.get("IsOtherSymptoms").equalsIgnoreCase("No")) {
                insurermedicalhistory.ClickonothersympNO();
            }

            insurerlifestyle.ClickSaveContinueBtn(); //Save & Continue Button QA//
            dashboard.checkLoaderWeb();
        }

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
                if (testData.get("LifeStyleDetailsTrv").equalsIgnoreCase("Travel")) {
                    System.out.println("TravelOverNext12Months is Filled in LifeStyleDetail");
                } else if (testData.get("travelledOverNext12Months").equalsIgnoreCase("Yes")) {
                    nriMandate.clickOnTravelledNext12MonthButton(testData.get("travelledOverNext12Months"));
                    nriMandate.enterCountryTravelledOverNext12Months(testData.get("countryTravelledNext12Months"));
                    nriMandate.enterNext12MonthCity(testData.get("Next12MonthCity"));
                    nriMandate.enterNext12MonthsDepartDate(testData.get("nextTravelled12MonthsDepartDate"));
                    nriMandate.enterNext12MonthsArrivalDate(testData.get("nextTravelled12MonthsArrivalDate"));
                    nriMandate.selectNext12MonthsVisaType(testData.get("nextTravelled12MonthsVisaType"));
                    nriMandate.clickSaveButton();
                }
                TestUtil.scrollTillEndOfPage(getDriver());

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

                nriMandate.clickOnNext();
                dashboard.checkLoaderWeb();

            }

            // Review and accept page //
            TestUtil.scrollTillEndOfPage(getDriver());
          //  customerprofile.IsTDSRNA(prop.getProperties("TDSRNA"));
            rna.ClickOnRandACheckboxWeb();
            rna.ClickOnAgreeButtonWeb();


//            // E customer consent declaration //
//            if (testData.get("IsECCD").equalsIgnoreCase("Yes")) {
//                eccd.ECCDCompleteNow();
//                eccd.ClickOnyestoallCheckboxWeb();
//                eccd.ClickOnrecurringdepositCheckboxWeb();
//                eccd.ClickOnABSLICheckboxWeb();
//                eccd.ClickOnillustrationCheckboxWeb();
//                eccd.SelectRelationshipweb(testData.get("SelectRelationECCD"));
//                eccd.Selectmodeofpaymentweb(testData.get("ModeofPaymentECCD"));
//                eccd.Acceptbutton();
//                dashboard.checkLoaderWeb();
//                eccd.enterInsurerOTPeccdweb(prop.getProperties("InsurerOTP"));
//                bankdetails.clicksubmitBtn();
//                dashboard.checkLoaderWeb();
//                eccd.ClickGoBackbutton();
//                eccd.Nextbutton();
//            } else {
//                eccd.ClickDoitLaterbutton();
//                dashboard.checkLoaderWeb();
//
//            }
//
//            // Payment Page //
//            if (testData.get("IsSelectChequeORDDPayment").equalsIgnoreCase("Yes")) {
//                if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Cheque")) {
//                    paymentpage.ClickOnChequeAndDDModeweb();
//                    paymentpage.UploadChequeAndDDImgweb();
//                    paymentpage.EnterChequeDDNoWeb(testData.get("ChequeDDNo"));
//                    paymentpage.EnterDDMMYYONCDDWeb(testData.get("CDDday"), testData.get("CDDMonth"), testData.get("CDDYear"));
//                    paymentpage.EnterIFSCCodeOnCDDWeb(testData.get("CDDIFSCcode"));
//                    paymentpage.ClickCDDPaymentSubmitBTNweb();
//                    customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                    dashboard.checkLoaderWeb();
//
//
//                } else if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Demand Draft")) {
//                    paymentpage.UploadChequeAndDDImgweb();
//                    paymentpage.EnterChequeDDNoWeb(testData.get("ChequeDDNo"));
//                    paymentpage.EnterDDMMYYONCDDWeb(testData.get("CDDday"), testData.get("CDDMonth"), testData.get("CDDYear"));
//                    paymentpage.EnterIFSCCodeOnCDDWeb(testData.get("CDDIFSCcode"));
//                    dashboard.checkLoaderWeb();
//                    TestUtil.scrollToElement(driver, getDriver().findElement(By.xpath("(//span[text()='Submit'])[1]")));
//                    paymentpage.UploadDECLARATIONFORMImgweb();
//                    dashboard.checkLoaderWeb();
//                    paymentpage.ClickCDDPaymentSubmitBTNweb();
//                    customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                    dashboard.checkLoaderWeb();
//
//                } else if (testData.get("selectChequeORDemandDraft").equalsIgnoreCase("Fund Transfer")) {
//                    TestUtil.scrollTillEndOfPage(getDriver());
//                    paymentpage.ClickOnFundTransferModeweb();
//                    paymentpage.UploadFundtransferImgweb();
//                    TestUtil.scrollTillEndOfPage(getDriver());
//                    paymentpage.EnterpolicyNumberFTWeb(testData.get("PolicyNumber"));
//                    WebElement Balamount = getDriver().findElement(By.xpath("(//div[contains(@class,'win-back-balance')])[2]"));
//                    String BalamountValue = Balamount.getText();
//                    paymentpage.EnterAmountFTWeb(BalamountValue);
//                    paymentpage.ClickOnFTsavebuttonweb();
//                    paymentpage.ClickOnFTredeembuttonweb();
//                    customerprofile.cdnextbutton(); // customer details NEXT button(QA)
//                    dashboard.checkLoaderWeb();
//
//                }
//            } else {
//                TestUtil.scrollTillEndOfPage(getDriver());
//                paymentpage.ClickpaymentDoitLaterbutton();
//                dashboard.checkLoaderWeb();
//
//            }
//
//            // Document Upload Page //
//            List<WebElement> DocumentCount = getDriver().findElements(By.xpath("(//div[@role='tablist'])[2]//button//span[1]"));
//            int docSize = DocumentCount.size();
//            for (int i = 0; i < docSize; i++) {
//                String str = DocumentCount.get(i).getText();
//                if (str.equalsIgnoreCase("Identity Proof")) { // Identity Proof
//                    documentpage.clickOnIdentityTileweb();
//                    documentpage.SelectTypeOfDocumentweb(testData.get("SelectProposerIDProof"));
//                    documentpage.UploadFileweb();
//                    TestUtil.scrollTillEndOfPage(driver);
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//                if (str.equalsIgnoreCase("Address Proof")) { // Address Proof
//
//                    documentpage.SelectTypeOfDocumentweb(testData.get("SelectProposerAddressProof"));
//                    documentpage.UploadFileweb();
//                    TestUtil.scrollTillEndOfPage(driver);
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//                if (str.equalsIgnoreCase("Non Medical Requirement")) { // Non medical requirement
//
//                    try {
//                        documentpage.UploadNonMedicalFinancialProposerNotInsuredweb(); //Financial justication endorsed by BH
//
//                    } catch (Exception e) {
//                        System.out.println("Financial justication option is not available");
//                    }
//
//                    try {
//                        documentpage.UploadNonMedicalNEFTCancelweb(); //CANCELLED CHEQUE FOR NEFT
//                    } catch (Exception e) {
//                        System.out.println("UploadNonMedicalNEFTCancel option is not available");
//                    }
//
//
//                    try {
//                        documentpage.UploadNonMedicalPHOTOGRAPHProposerNotInsuredweb(); //Photograph
//
//                    } catch (Exception e) {
//                        System.out.println("UploadNonMedicalPHOTOGRAPHProposerNotInsured is not available");
//                    }
//
//                    try {
//                        documentpage.UploadNonMedicalSignedCopyweb(); //Signed copy of Profiler
//
//                    } catch (Exception e) {
//                        System.out.println("NonMedicalSignedCopy option is not available");
//                    }
//
//                    try {
//                        documentpage.UploadNonMedicalStatementInsuredweb(); //Bank statement showing Vintage Relationship
//
//                    } catch (Exception e) {
//                        System.out.println("NonMedicalStatementInsured option is not available");
//                    }
//
//                    TestUtil.scrollTillEndOfPage(getDriver());
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//                if (str.equalsIgnoreCase("PAN Card Proof")) { // PAN card
//
//                    documentpage.SelectTypeOfDocumentPanCard(testData.get("SelectProposerPAN"));
//                    documentpage.UploadFileweb();
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//                if (str.equalsIgnoreCase("Medical Requirement")) { // Medical Requirement
//
//                    TestUtil.scrollTillEndOfPage(getDriver());
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//                try {
//                    if (str.equalsIgnoreCase("Income Proof")) { // Income Proof
//
//                        documentpage.SelectTypeOfDocumentIncomePrrofweb(testData.get("SelectTypeOfDocIncomeProof"));
//                        documentpage.UploadFileweb();
//                        TestUtil.scrollTillEndOfPage(getDriver());
//                        documentpage.clickOnNEXTButtonweb();
//
//                    }
//                } catch (Exception e) {
//                    System.out.println("Income Proof Option is not Available");
//                }
//                if (str.equalsIgnoreCase("Age Proof")) { // Age Proof
//
//                    TestUtil.scrollToTopOfthePage(driver);
//                    documentpage.SelectTypeOfDocumentAgePrrofweb(testData.get("SelectProposerAgeProof"));
//                    documentpage.UploadFileweb();
//                    TestUtil.scrollTillEndOfPage(driver);
//                    documentpage.clickOnNEXTButtonweb();
//
//                }
//            }
    }
}