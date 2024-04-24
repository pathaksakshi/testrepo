package com.absli.testcases;


import java.io.IOException;
import java.util.HashMap;

import Utils.*;
import com.absli.Products.GoToProducts;
import com.absli.utils.WaitUtils;
import org.apache.maven.wagon.Wagon;
import org.testng.annotations.Test;

import com.absli.base.TestBase;
import com.absli.dataproviders.DataProviders;

import static com.absli.base.BasePage.getDriver;
import static com.absli.base.TestBase.wait;

public class EndtoEndProposerJointlife extends TestBase {
    public EndtoEndProposerJointlife() {super();}

    //---------------------------------------------------------------------------------------------------------------------------------------//
    @Test(groups= {"web"},dataProvider = "EndtoEndJointlifeDataProvider", dataProviderClass = DataProviders.class,
            description = "Jointlife Scenario")

    public void CompletejointGMSA(HashMap<String, String> testData)throws InterruptedException, IOException {

        new GoToPMSpageJointlife().gotoPSM_Jointlifepage(getDriver(),testData);
        new GoToProducts().selectproduct(getDriver(),testData);
        new EndToEndProJointlife().gotoEndToEndJointlifeJourney(getDriver(),testData);

    }
}
