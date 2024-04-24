package com.absli.testcases;

import java.io.IOException;
import java.util.HashMap;

import Utils.*;
import com.absli.Products.GoToProducts;
import org.testng.annotations.Test;

import com.absli.base.TestBase;
import com.absli.dataproviders.DataProviders;

public class EndtoEndProposerDiff_Minor extends TestBase {
	 public EndtoEndProposerDiff_Minor() {super();}

	    @Test(groups= {"web"},dataProvider = "EndtoEndMinorDataProvider", dataProviderClass = DataProviders.class,
	            description = "Proposer Same GMS Scenario")

	    public void CompleteminorGMSA(HashMap<String, String> testData)throws InterruptedException, IOException {

	    	 new GoToPMSpage_MinorJourney().gotoPSM_Minorpage(getDriver(),testData);
			 new GoToProducts().selectproduct(getDriver(),testData);
	    	 new EndToEndProMinorJourney().gotoEndToEndMinorJourney(getDriver(),testData);
	 }

	@Test(groups= {"web"},dataProvider = "EndtoEndMinorDataProvider", dataProviderClass = DataProviders.class,
			description = "Proposer Same GMS Scenario")

	public void CompleteminorAAPB(HashMap<String, String> testData)throws InterruptedException, IOException {

		new GoToPMSpage_MinorJourney().gotoPSM_Minorpage(getDriver(),testData);
		new GoToProducts().selectproduct(getDriver(),testData);
		new EndToEndProMinorJourney().gotoEndToEndMinorJourney(getDriver(),testData);
	}
	@Test(groups= {"web"},dataProvider = "EndtoEndMinorDataProvider", dataProviderClass = DataProviders.class,
			description = "Proposer Same GMS Scenario")

	public void CompleteminorAIPB(HashMap<String, String> testData)throws InterruptedException, IOException {

		new GoToPMSpage_MinorJourney().gotoPSM_Minorpage(getDriver(),testData);
		new GoToProducts().selectproduct(getDriver(),testData);
		new EndToEndProMinorJourney().gotoEndToEndMinorJourney(getDriver(),testData);
	}

}
