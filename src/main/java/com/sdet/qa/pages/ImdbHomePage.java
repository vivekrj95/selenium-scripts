package com.sdet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.qa.base.TestBase;
import com.sdet.qa.util.TestUtil;

public class ImdbHomePage extends TestBase {
	//page Factory or Object Repo
	
	@FindBy(xpath="//h1[text()='Pushpa: The Rise - Part 1']")
	WebElement header;
	
	@FindBy(id="suggestion-search") 
	WebElement search;
	
	@FindBy(xpath="//a[@data-testid='search-result--const']")
	WebElement srchDropdwn;
	
	@FindBy(xpath=("//a[contains(text(),'December 17, 2021 (United States)')]"))
	WebElement releaseDate;
	
	@FindBy(xpath=("//a[text()='India']"))
	WebElement country;
	
	//Initializing the page objects
	public ImdbHomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String searchMovie(String mName) {
		search.click();
		search.sendKeys(mName);
		srchDropdwn.click();
		
		return header.getText();
	}
	
	public String validateReleaseDate() {
		
		return releaseDate.getText();
	}
	
	public String validateCountry() {
		
		return country.getText();
	}

}
