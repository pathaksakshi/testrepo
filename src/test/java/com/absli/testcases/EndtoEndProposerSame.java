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

public class EndtoEndProposerSame extends TestBase {

    public EndtoEndProposerSame(){super();}

    //---------------------------------------------------------------------------------------------------------------------------------------//
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameGMSF(HashMap<String, String> testData)throws InterruptedException, IOException {
    	 new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
		 WaitUtils.WaitTime2();
		 new GoToProducts().selectproduct(getDriver(),testData);
    	 new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);
    }

    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameAIPC(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);
    }

    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesamePSKE(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);
    }
//---------------------------------------------------------------------------------------------------------------------------------------
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")

    public void CompletesameANPA(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")

    public void CompletesameNPPB(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }

    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameBFEE(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }

    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameAASC(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameAIPE(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }

    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameBFEC(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameAAPB(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }
    @Test(groups= {"web"},dataProvider = "EndtoEndProposerSame", dataProviderClass = DataProviders.class,
            description = "Proposer Same Scenario")
    public void CompletesameBCSB(HashMap<String, String> testData)throws InterruptedException, IOException {
        new GoToPSMpageJourney().gotoPSMpageSAME(getDriver(),testData);
        WaitUtils.WaitTime2();
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProSameJourney().gotoEndToEndSameJourney(getDriver(),testData);

    }

}
