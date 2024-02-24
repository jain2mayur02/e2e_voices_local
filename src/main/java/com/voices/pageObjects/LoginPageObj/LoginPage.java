package com.voices.pageObjects.LoginPageObj;

import com.voices.baseClass.BaseClass;
import com.voices.managers.ReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@name='username']")
    private static WebElement userName;

    @FindBy(xpath = "//*[@name='password']")
    private static WebElement password;

    @FindBy(xpath = "//*[@type='submi']")
    private static WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userLaunchAndValidateHomePage(){
        LoginPage.driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
        BaseClass.staticWaitForVisibility(10000);
    }



}
