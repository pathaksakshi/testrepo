package com.absli.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absli.base.TestBase;
import com.absli.utils.WaitUtils;

import io.qameta.allure.Allure;

public class HealthAndPureTermsPage extends TestBase{
	 public WebDriver driver;
	    public WaitUtils wait;

	    public HealthAndPureTermsPage(WebDriver driver) {PageFactory.initElements(getDriver(), this);}
	    
	    
	    @FindBy(name = "annualIncome") // for same ='prop' diff='insu'
	    private WebElement premiumvalueRecommendPlan;
	    
	    @FindBy(xpath = "//div[@id='mui-component-select-occupation']") // for same ='prop' diff='insu'
	    private WebElement Occupationdropdown;

	    @FindBy(xpath = "//input[contains(@name,'ULIP')]") // for same ='prop' diff='insu'
	    private WebElement Ele1;
	    @FindBy(xpath = "//input[contains(@name,'Traditional')]") // for same ='prop' diff='insu'
	    private WebElement Ele2;
	    
	    @FindBy(xpath = "//input[contains(@name,'Protection')]") // for same ='prop' diff='insu'
	    private WebElement Ele3;
	    
	    @FindBy(xpath = "//input[contains(@name,'Health')]") // for same ='prop' diff='insu'
	    private WebElement Ele4;
	    
	    
	   
	    
	    public void enterPremiumValueRecommendPlanWeb(String args) {
	    	
	        
	        if(premiumvalueRecommendPlan.isDisplayed()){
	        	premiumvalueRecommendPlan.click();

	            premiumvalueRecommendPlan.sendKeys(args);
	            Allure.step ("Enter Premium Value As=====> "+args);
	        }
	        }
	    public void OccupationdropdownSelectionONRecommendPlanWeb(String args ) throws InterruptedException {
	       
	        Occupationdropdown.click();
	        Thread.sleep(2000);
	        Allure.step ("Click on Occupation DropDown");
	        WebElement OccupationdropdownChoose = getDriver().findElement(By.xpath("//ul//li//span[text()='"+args+"']"));
	        Thread.sleep(2000);
	        if(OccupationdropdownChoose.isDisplayed()){
	        	  Thread.sleep(2000);
	        	OccupationdropdownChoose.click();
	        	
	        	 Allure.step ("Select Occupation Values  As=====> "+args);
	        }else {
	        	 Allure.step ("Failed To Display Occupation Values As=====>"+args);
	        }
	    }	
	    
	    public void lifeStageSelectionONRecommendPlanWeb(String args){

	        WebElement lifeStageBtnWeb= getDriver().findElement(By.xpath("//span[text()='"+args+"']"));
	        

	        if(lifeStageBtnWeb.isDisplayed()){
	        	lifeStageBtnWeb.click();
	        	 Allure.step ("Select Life Stage As=====> "+args);
	        }else {
	        	 Allure.step ("Life Stage Element is not Display");
	        }

	    }
	    
	    public void investmentGoalSelectionONRecommendPlanWeb(String args){

	    	WebElement investmentGoalBtnWeb= getDriver().findElement(By.xpath("//button[contains(@value,'"+args+"')]"));
	        

	        if(investmentGoalBtnWeb.isDisplayed()){
	        	investmentGoalBtnWeb.click();
	        	 Allure.step( "Select  Invesment Goal As=====> "+args);
	        }else {
	        	 Allure.step ("Investment Goal Element is not Display");
	        }

	    }

	   
	    
	    public void RiskprofileSelectionONRecommendPlanWeb(String args){

	        WebElement  RiskprofileBtnWeb= getDriver().findElement(By.xpath("//div[text()=\""+args+"\"]"));
	       
	        if(RiskprofileBtnWeb.isDisplayed()){
	        	RiskprofileBtnWeb.click();
	        	 Allure.step ("Select Risk Profile As=====> "+args);
	        }else {
	        	 Allure.step ("Risk Profile Element is not Display");
	        }

	    }
	    

	    public void ClickonAddExistingPoliciesWeb(){

	          WebElement  Ele1= getDriver().findElement(By.xpath("//img[contains(@alt,'add icon')]"));
	         
	          if(Ele1.isDisplayed()){
	          	Ele1.click();
	          	 Allure.step ("Click On Add Existing Policies Button");
	          }else {
	        	  Allure.step( "Add Existing Policies Button Element is not Display");
	          }

	      }


	    public void EnterAllSumAssuredAmountweb(String val){
	    	
	        if(Ele1.isDisplayed()){
	        	Ele1.sendKeys(val);
	        	 Allure.step ("Enter ULIP Values As=====>"+val);
	        }else {
	        	 Allure.step ("ULIP TextBox is not Display");
	        }
	        if(Ele2.isDisplayed()){
	        	Ele2.sendKeys(val);
	        	 Allure.step( "Enter Traditional Values As=====>"+val);
	        }else {
	        	 Allure.step ("traditional TextBox is not Display");
	        }
	        if(Ele3.isDisplayed()){
	        	Ele3.sendKeys(val);
	        	 Allure.step( "Enter Protection Values As=====>"+val);
	        }else {
	        	 Allure.step("Protection TextBox is not Display");
	        }
	        if(Ele4.isDisplayed()){
	        	Ele4.sendKeys(val);
	        	 Allure.step( "Enter Health Values As=====>"+val);
	        }else {
	        	 Allure.step ("Health TextBox is not Display");
	        }

	    }

	    
	    public void clickonViewPlansBtnWeb() {
	        WebElement selectplanWeb =  getDriver().findElement(By.xpath("//button[contains(@name,'View Plans')]"));
	       // wait.waitforElementToBeClickable( WebDriverFactoryStaticThreadLocal.getDriver(), selectplanWeb, 100);
	        if (selectplanWeb.isDisplayed()) {
	            selectplanWeb.click();
	            Allure.step( "Click on View Plans Button");
	        } else {
	        	 Allure.step ("View Plans Button is not display");

	        }
	    }
	    public void SelectRecommendedPlanList(String val) {
	        WebElement selectplanWeb =  getDriver().findElement(By.xpath("//div[contains(text(),'"+val+"')]"));
	        
	        if (selectplanWeb.isDisplayed()) {
	            selectplanWeb.click();
	            Allure.step ("Select  Values As======>"+val);
	        } else {
	        	 Allure.step (val+"is Not Display");

	        }
	    }
	    
	    
	    
}
