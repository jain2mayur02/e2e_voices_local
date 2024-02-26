package com.voices.managers;

import com.voices.baseClass.BaseClass;
import com.voices.pageObjects.HomePageObj.HomePage;
import com.voices.pageObjects.LoginPageObj.LoginPage;
import com.voices.pageObjects.SearchPageObj.SearchPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;
    private BaseClass baseclass;
    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public BaseClass getBaseClass() {
        return (baseclass == null) ? baseclass = new BaseClass(driver) : baseclass;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public SearchPage getSearchPage() {
        return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
    }

}

