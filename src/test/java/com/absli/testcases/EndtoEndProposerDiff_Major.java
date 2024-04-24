package com.absli.testcases;

import java.io.IOException;
import java.util.HashMap;

import Utils.*;
import com.absli.Products.GoToProducts;
import org.testng.annotations.Test;

import com.absli.base.TestBase;
import com.absli.dataproviders.DataProviders;

public class EndtoEndProposerDiff_Major extends TestBase {

    public EndtoEndProposerDiff_Major() {super();} 

    //---------------------------------------------------------------------------------------------------------------------------------------//
    @Test(groups= {"web"},dataProvider = "EndtoEndMajorDataProvider", dataProviderClass = DataProviders.class,
            description = "Proposer Same GMS Scenario")

    public void CompletemajordiffGMSA(HashMap<String, String> testData)throws InterruptedException, IOException {

    	 new GoToPMSpage_MajorJourney().gotoPSM_Majorpage(getDriver(),testData);
		 new GoToProducts().selectproduct(getDriver(),testData);
    	 new EndToEndProMajorJourney().gotoEndToEndMajorJourney(getDriver(),testData);
    	 
    	  
    }
	@Test(groups= {"web"},dataProvider = "EndtoEndMajorDataProvider", dataProviderClass = DataProviders.class,
			description = "Proposer Same GMS Scenario")

	public void CompletemajordiffASPE(HashMap<String, String> testData)throws InterruptedException, IOException {

		new GoToPMSpage_MajorJourney().gotoPSM_Majorpage(getDriver(),testData);
		new GoToProducts().selectproduct(getDriver(),testData);
		new EndToEndProMajorJourney().gotoEndToEndMajorJourney(getDriver(),testData);


	}
	@Test(groups= {"web"},dataProvider = "EndtoEndMajorDataProvider", dataProviderClass = DataProviders.class,
			description = "Proposer Same GMS Scenario")

	public void CompletemajordiffAAPA(HashMap<String, String> testData)throws InterruptedException, IOException {

		new GoToPMSpage_MajorJourney().gotoPSM_Majorpage(getDriver(),testData);
		new GoToProducts().selectproduct(getDriver(),testData);
		new EndToEndProMajorJourney().gotoEndToEndMajorJourney(getDriver(),testData);


	}


}
