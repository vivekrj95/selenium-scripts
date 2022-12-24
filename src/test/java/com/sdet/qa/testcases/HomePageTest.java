package com.sdet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sdet.qa.base.TestBase;
import com.sdet.qa.pages.ImdbHomePage;
import com.sdet.qa.pages.WikiHomePage;
import com.sdet.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	ImdbHomePage imdbHomePage;
	WikiHomePage wikiHomePage;
	TestUtil testUtil;
	String country,date;
	String imdbHeader,wikiHeader;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		imdbHomePage= new ImdbHomePage();
		wikiHomePage= new WikiHomePage();
		
		
	}
	
	
	@Test(priority=1)
	public void validateHeaderTest() {
		
		driver.get(prop.getProperty("url"));
		imdbHeader=imdbHomePage.searchMovie(TestUtil.MOVIE_NAME);
		Assert.assertEquals(imdbHeader, "Pushpa: The Rise","Header doesn't match");
	}
	@Test(priority=2)
	public void fetchDate() {
		driver.get(prop.getProperty("url"));
		imdbHomePage.searchMovie(TestUtil.MOVIE_NAME);
		date = imdbHomePage.validateReleaseDate();
		
	}
	@Test(priority=3)
	public void fetchCountry() {
		driver.get(prop.getProperty("url"));
		imdbHomePage.searchMovie(TestUtil.MOVIE_NAME);
		country = imdbHomePage.validateCountry();
		
	}
	
	@Test(priority=4)
	public void validateWikiHeader() {
		driver.get(prop.getProperty("url1"));
		wikiHeader = wikiHomePage.searchWikiMovie(TestUtil.MOVIE_NAME);
		Assert.assertEquals(wikiHeader, imdbHeader,"Header are not matching");
	}
	
	@Test(priority=5)
	public void fetchWikiCountry() {
		driver.get(prop.getProperty("url1"));
		wikiHomePage.searchWikiMovie(TestUtil.MOVIE_NAME);
		String wikiCountry = wikiHomePage.validateWikiCountry();
		Assert.assertEquals(wikiCountry, country);
	}
	
	@Test(priority=6)
	public void fetchWikiDate() {
		driver.get(prop.getProperty("url1"));
		wikiHomePage.searchWikiMovie(TestUtil.MOVIE_NAME);
		String wikiDate = wikiHomePage.validateWikiDate();
		Assert.assertEquals(wikiDate, date);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
