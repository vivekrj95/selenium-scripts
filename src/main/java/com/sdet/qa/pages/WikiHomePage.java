package com.sdet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.qa.base.TestBase;

public class WikiHomePage extends TestBase{
	
	@FindBy(xpath="//h1[@id='firstHeading']")
	WebElement header;
	
	@FindBy(id="searchInput") 
	WebElement searchBox;
	
	@FindBy(xpath="//a[@title='Pushpa: The Rise']")
	WebElement selectDrpDown;
	
	@FindBy(xpath="//td[contains(text(),'India')]")
	WebElement country;
	
	//@FindBy(xpath="//tr[@xpath='1']//li[contains(text(),'17')]")
	@FindBy(xpath="//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[12]")
	WebElement date;
	
	public WikiHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String searchWikiMovie(String mName) {
		
		searchBox.click();
		searchBox.sendKeys(mName);
		selectDrpDown.click();
		return header.getText();
	}
	
	public String validateWikiCountry() {
		
		return country.getText();
	}
	
	public String validateWikiDate() {
		System.out.println(date.getText());
		return date.getText();
	}

}
