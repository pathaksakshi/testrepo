package com.absli.testcases;
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
import com.absli.Products.GoToProducts;
import com.absli.base.TestBase;
import com.absli.dataproviders.DataProviders;
import com.absli.utils.WaitUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
public class EndtoEndProposerCompany extends TestBase {

    public EndtoEndProposerCompany(){super();}
    //---------------------------------------------------------------------------------------------------------------------------------------//
    @Test(groups= {"web"},dataProvider = "EndtoEndCompanyDataProvider", dataProviderClass = DataProviders.class,
            description = "Proposer Company Scenario")

    public void CompletecompanyAIPA(HashMap<String, String> testData)throws InterruptedException, IOException {

        new GoToPSMpageJourneyCompany().gotoPSMpageCompany(getDriver(),testData);
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProCompanyJourney().gotoEndToEndCompany(getDriver(),testData);


    }



}