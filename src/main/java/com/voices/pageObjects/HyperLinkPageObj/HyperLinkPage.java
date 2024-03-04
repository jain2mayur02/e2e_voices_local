package com.voices.pageObjects.HyperLinkPageObj;

import com.voices.baseClass.BaseClass;
import com.voices.managers.ReaderManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class HyperLinkPage {
    private static WebDriver driver;

    public HyperLinkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='find-talent']")
    private WebElement findTalentLink;
    // @FindBy(xpath = "//div[@class='megaMenu-talent-items megaMenu-talent-items-active']//div[@class='megaMenu-talent-items-text']")
    @FindBy(xpath = "//span[normalize-space()='Find Talent for Your Job']")
    private WebElement talentProfile;
    //@FindBy(xpath = "//a[@class='nav-main-submenu-link nav-main-submenu-link-line']")

    @FindBy(xpath = "//a[@class='nav-main-submenu-link nav-main-submenu-link-line']")
    private WebElement logInLink;


/*    @FindBy(linkText = "Log In")
    private WebElement logInLink;*/
    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement loginEmailTextBox;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[normalize-space()='Log In']")
    private WebElement logInButton;
    @FindBy(xpath = "//button[@title='Submit Search']")
    private WebElement searchIcon;
    @FindBy(xpath = "//h1[@id='keyword-heading']")
    private WebElement searchHeading;
    @FindBy(xpath = "//a[@class='header-btn header-btn-primary header-btn-postjob btn']")
    private WebElement postAJobButton;
    @FindBy(xpath = "//div[@id='header-title']")
    private WebElement postAJobText;

    @FindBy(xpath = "//a[@id='Jobs']")
    private WebElement jobsIcon;

    @FindBy(xpath = "//a[@id='Messages']")
    private WebElement messagesIcon;
    @FindBy(xpath = "//h1[normalize-space()='Messages']")
    private WebElement messagesIconText;


    @FindBy(xpath = "//a[@id='Notifications']")
    private WebElement notificationIcon;

    @FindBy(xpath = "//h1[normalize-space()='Notification Center']")
    private WebElement notificationIconText;

    @FindBy(xpath = "//li[@class='nav-main-submenu-list-item nav-main-submenu-list-item-desktop has-dropdown']//a[contains(@class,'nav-main-submenu-link-icon')]")
    private WebElement userIcon;
    @FindBy(xpath = "//a[normalize-space()='My Home']")
    private WebElement myHomeLink;
    @FindBy(xpath = "//h1[normalize-space()='Get Started']")
    private WebElement getStartedText;
    @FindBy(xpath = "//a[normalize-space()='Favorites']")
    private WebElement favoritesLink;
    @FindBy(xpath = "//h1[normalize-space()='Favorite Talent']")
    private WebElement favoriteTalentText;
    @FindBy(xpath = "//a[normalize-space()='Previously Hired Talent']")
    private WebElement previouslyHiredTalentLink;
    @FindBy(xpath = "//div[@class='page-header']/h1")
    private WebElement previouslyHiredTalentText;
    @FindBy(xpath = "//a[normalize-space()='Reviews']")
    private WebElement reviewsLink;
    @FindBy(xpath = "//h1[normalize-space()='Reviews']")
    private WebElement reviewsText;
    @FindBy(xpath = "//a[normalize-space()='Manage Licenses']")
    private WebElement manageLicensesLink;
    @FindBy(xpath = "//h1[normalize-space()='License Management']")
    private WebElement manageLicensesText;
    @FindBy(xpath = "//a[normalize-space()='Manage Team']")
    private WebElement manageTeamLink;
    @FindBy(xpath = "//h1[normalize-space()='Team Members']")
    private WebElement manageTeamText;
    @FindBy(xpath = "//a[normalize-space()='Billing History']")
    private WebElement billingHistoryLink;
    @FindBy(xpath = "//h1[normalize-space()='Billing History']")
    private WebElement billingHistoryText;
    @FindBy(xpath = "//a[normalize-space()='Account Settings']")
    private WebElement accountSettingsLink;
    @FindBy(xpath = "//h1[normalize-space()='Business Profile']")
    private WebElement accountSettingsText;
    @FindBy(xpath = "//a[normalize-space()='Help Center']")
    private WebElement helpCenterLink;
    @FindBy(xpath = "//h1[normalize-space()='How can we help?']")
    private WebElement helpCenterText;
    @FindBy(xpath = "//a[normalize-space()='Contact Support']")
    private WebElement contactSupportLink;
    @FindBy(xpath = "//h1[normalize-space()='How can we help?']")
    private WebElement contactSupportText;
    @FindBy(xpath = "//li[@class='nav-main-dropdown-list-item']//a[@class='nav-main-dropdown-link'][normalize-space()='Log Out']")
    private WebElement logOutLink;
    @FindBy(xpath = "//h2[@id='login-form-title']")
    private WebElement logoutText;
    @FindBy(xpath = "//i[@class='right']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]")
    private WebElement rightScrollClick;
    @FindBy(xpath = "//a[@id='Payments']")
    private WebElement paymentIcon;
    @FindBy(xpath = "//a[@id='Messages']")
    private WebElement messageIcon;
    @FindBy(xpath = "//h1[normalize-space()='Messages']")
    private WebElement messageText;
    @FindBy(xpath = "//div[contains(text(),'Help')]/../../a")
    private WebElement helpIcon;
    @FindBy(xpath = "//div[@class='flexbox']/../div/a[1]")
    private WebElement userProfile;
    @FindBy(xpath = "//div[@class='flexbox']/../div/a[2]")
    private WebElement premiumLink;
    @FindBy(xpath = "//a[@class='nav-main-submenu-link nav-main-submenu-link-line d-flex justify-content-between']")
    private WebElement howItWorkLink;
    @FindBy(xpath = "//h1[normalize-space()='How It Works']")
    private WebElement howItWorksText;
    @FindBy(xpath = "//h2[normalize-space()='Log In to Voices']")
    private WebElement logInToVoicesText;
    @FindBy(xpath = "//a[@class='nav-main-submenu-btn header-btn header-btn-primary']")
    private WebElement signUpLink;
    @FindBy(xpath = "//h2[@id='signup-title']")
    private WebElement signUpWithVoicesText;


    public void userLaunchAndValidateHomePage() {
        HyperLinkPage.driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
        BaseClass.staticWaitForVisibility(2000);
    }

    public void userLogin(String userName, String password, String urlKey) {
        BaseClass.waitForVisibility(logInLink, 60, HyperLinkPage.driver);
        BaseClass.staticWaitForVisibility(5000);
        logInLink.click();
        //BaseClass.javaScriptClick(HomePage.driver, logInLink);
        BaseClass.waitForVisibility(loginEmailTextBox, 60, HyperLinkPage.driver);
        loginEmailTextBox.sendKeys(userName);
        BaseClass.waitForVisibility(passwordTextBox, 60, HyperLinkPage.driver);
        passwordTextBox.sendKeys(password);
        BaseClass.waitForElementClickable(logInButton, 60, HyperLinkPage.driver);
        logInButton.click();
        BaseClass.waitForVisibility(searchIcon, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Login Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(urlKey), HyperLinkPage.driver.getCurrentUrl());
        searchIcon.click();
        BaseClass.waitForVisibility(searchHeading, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Search text", "Search", searchHeading.getText().trim());


    }

    public void userClickOnPostAJobAndValidateUrl() {
        BaseClass.waitForVisibility(postAJobButton, 60, HyperLinkPage.driver);
        postAJobButton.click();
        BaseClass.waitForVisibility(postAJobText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Post A Job Test", "Post a Job", postAJobText.getText().trim());
        Assert.assertEquals("Validate Post A Job Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("postAJob"), HyperLinkPage.driver.getCurrentUrl());
    }


    public void clickOnJobAndValidateAllLink() {
        HyperLinkPage.driver.get("https://www.voices.systems/client/jobs/index");
        BaseClass.waitForVisibility(jobsIcon, 60, HyperLinkPage.driver);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, jobsIcon);
        List<WebElement> jobsList = HyperLinkPage.driver.findElements(By.xpath("//li[contains(@class,'nav-main-submenu-list-item has-dropdown')]//div[@class='nav-main-dropdown']/ul/li/a"));
        for (WebElement jobLink : jobsList) {
            BaseClass.waitForVisibility(jobsIcon, 60, HyperLinkPage.driver);
            BaseClass.mouseOverOnElement(HyperLinkPage.driver, jobsIcon);
            String jobLinkText = jobLink.getText();
            String keyLinkText = jobLinkText.replaceAll(" ", "");
            HyperLinkPage.driver.findElement(By.xpath("//a[text()='" + jobLinkText + "']")).click();
            System.out.println(jobLinkText);
            BaseClass.staticWaitForVisibility(2000);
            Assert.assertEquals("Validate Page URL", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(keyLinkText), HyperLinkPage.driver.getCurrentUrl());
            WebElement jobsStatusElement = HyperLinkPage.driver.findElement(By.xpath("//a[text()='" + jobLinkText + "']/.."));
            Assert.assertEquals("Validate Jobs Status", "active", jobsStatusElement.getAttribute("class").trim());
        }
    }

    public void validateUserIconLink(WebElement elementLink, String propertyLinkKey, WebElement actualPageTextElement, String expectedPageText) {
        BaseClass.waitForVisibility(userIcon, 60, HyperLinkPage.driver);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, userIcon);
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.javaScriptClick(HyperLinkPage.driver, elementLink);
        BaseClass.waitForVisibility(actualPageTextElement, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Page URL", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(propertyLinkKey), HyperLinkPage.driver.getCurrentUrl());
        System.out.println(actualPageTextElement.getText());
        Assert.assertTrue("Validate Page text", actualPageTextElement.getText().trim().contains(expectedPageText));
    }

    public void clickOnUserIconAndValidateAllLinks() {
        HyperLinkPage.driver.get("https://www.voices.systems/client/jobs/index");
        validateUserIconLink(myHomeLink, "MyHome", getStartedText, "Get Started");
        validateUserIconLink(favoritesLink, "Favorites", favoriteTalentText, "Favorite Talent");
        validateUserIconLink(previouslyHiredTalentLink, "PreviouslyHiredTalent", previouslyHiredTalentText, "Previously Hired Talent");
        validateUserIconLink(reviewsLink, "Reviews", reviewsText, "Reviews");
        validateUserIconLink(manageLicensesLink, "ManageLicenses", manageLicensesText, "License Management");
        validateUserIconLink(manageTeamLink, "ManageTeam", manageTeamText, "Team Members");
        validateUserIconLink(billingHistoryLink, "BillingHistory", billingHistoryText, "Billing History");
        validateUserIconLink(accountSettingsLink, "AccountSettings", accountSettingsText, "Business Profile");
        validateUserIconLink(helpCenterLink, "HelpCenter", helpCenterText, "How can we help?");
        validateUserIconLink(contactSupportLink, "ContactSupport", contactSupportText, "How can we help?");
        validateUserIconLink(logOutLink, "loginPage", logoutText, "Log In to Voices");

    }

    public void clickOnMessagesAndNotificationLinks() {
        messagesIcon.click();
        BaseClass.waitForVisibility(messagesIconText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Post A Message Test", "Messages", messagesIconText.getText().trim());
        Assert.assertEquals("Validate Post A Message", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("MessageIcon"), HyperLinkPage.driver.getCurrentUrl());

        notificationIcon.click();
        BaseClass.waitForVisibility(notificationIconText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Post A Notification Test", "Notification Center", notificationIconText.getText().trim());
        Assert.assertEquals("Validate Post A Notification Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("NotificationIcon"), HyperLinkPage.driver.getCurrentUrl());

    }

    public void verifyTalentProfileAllHyperLink() {
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, findTalentLink);
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, talentProfile);
        talentProfile.click();
        BaseClass.staticWaitForVisibility(2000);
        List<WebElement> allLinks = HyperLinkPage.driver.findElements(By.xpath("(//div[@id='talent-marketplace'])[1]/div/a"));
        for (WebElement link : allLinks) {
            String linkText = link.getText();
            System.out.println(linkText);
        }
    }

    public void validateSubModuleLink() {
        List<WebElement> allLinks = HyperLinkPage.driver.findElements(By.xpath("//div[@class='side-scroll-container']/section/a"));
        for (int link = 0; link < allLinks.size(); link++) {
            allLinks = HyperLinkPage.driver.findElements(By.xpath("//div[@class='side-scroll-container']/section/a"));
            for (int i = 0; i <= 10; i++) {
                if (!allLinks.get(link).isEnabled()) {
                    rightScrollClick.click();
                } else {
                    String linkText = allLinks.get(link).getText().replaceAll(" ", "");
                    System.out.println(linkText);
                    allLinks.get(link).click();
                    BaseClass.staticWaitForVisibility(2000);
                    Assert.assertEquals("Validate Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(linkText), HyperLinkPage.driver.getCurrentUrl());
                    BaseClass.validateURLresponse(ReaderManager.getInstance().getConfigReader().getUrlEndPoint(linkText));
                    break;
                }
            }
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateAllCompanyLinkUnderFooter() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allCompanyLinks = HyperLinkPage.driver.findElements(By.xpath("//a[@aria-label='Expand mobile menu'][normalize-space()='Company']/../ul/li/a"));
        for (int link = 0; link < allCompanyLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allCompanyLinks = HyperLinkPage.driver.findElements(By.xpath("//a[@aria-label='Expand mobile menu'][normalize-space()='Company']/../ul/li/a"));
            String companyLinkText = allCompanyLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(companyLinkText);
            allCompanyLinks.get(link).click();
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Company Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(companyLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateAllResourcesLinkUnderFooter() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allResourceLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='Resources']/../ul/li/a"));
        for (int link = 0; link < allResourceLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allResourceLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='Resources']/../ul/li/a"));
            String resourceLinkText = allResourceLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(resourceLinkText);
            allResourceLinks.get(link).click();
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Resource Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(resourceLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateAllFooterLinkUnderFooter() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allFooterLinks = HyperLinkPage.driver.findElements(By.xpath("//ul[@class='footer-menu footer-menu-lower']/li/a"));
        for (int link = 0; link < allFooterLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allFooterLinks = HyperLinkPage.driver.findElements(By.xpath("//ul[@class='footer-menu footer-menu-lower']/li/a"));
            String footerLinkText = allFooterLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(footerLinkText);
            allFooterLinks.get(link).click();
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Footer Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(footerLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateSocialMediaLinkUnderFooter() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allMediaLinks = HyperLinkPage.driver.findElements(By.xpath("//ul[@class='footer-social']/li/a"));
        for (int link = 0; link < allMediaLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allMediaLinks = HyperLinkPage.driver.findElements(By.xpath("//ul[@class='footer-social']/li/a"));
            String mediaLinkText = allMediaLinks.get(link).getAttribute("title").replaceAll(" ", "");
            System.out.println(mediaLinkText);
            String parentWindow = HyperLinkPage.driver.getWindowHandle();
            allMediaLinks.get(link).click();
            BaseClass.staticWaitForVisibility(1000);
            Set<String> allWindows = HyperLinkPage.driver.getWindowHandles();
            for (String childWindow : allWindows) {
                if (!childWindow.equalsIgnoreCase(parentWindow)) {
                    HyperLinkPage.driver.switchTo().window(childWindow);
                    BaseClass.staticWaitForVisibility(1000);
                    System.out.println(HyperLinkPage.driver.getCurrentUrl());
                    Assert.assertTrue("Validate All Media Link",  HyperLinkPage.driver.getCurrentUrl().contains(ReaderManager.getInstance().getConfigReader().getUrlEndPoint(mediaLinkText)));
//                    Assert.assertEquals("Validate All Media Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(mediaLinkText), HyperLinkPage.driver.getCurrentUrl());
//                    BaseClass.validateURLresponse(HomePage.driver.getCurrentUrl());
                    HyperLinkPage.driver.close();
                }
            }
            HyperLinkPage.driver.switchTo().window(parentWindow);
        }

    }

    public void overOnJobAndValidateAllLinkForTalentUser() {
        BaseClass.waitForVisibility(jobsIcon, 60, HyperLinkPage.driver);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, jobsIcon);
        List<WebElement> jobsList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Jobs']/../div/ul/li/a"));
        for (int link = 0; link < jobsList.size(); link++) {
            BaseClass.waitForVisibility(jobsIcon, 60, HyperLinkPage.driver);
            BaseClass.mouseOverOnElement(HyperLinkPage.driver, jobsIcon);
            jobsList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Jobs']/../div/ul/li/a"));
            String jobLinkText = jobsList.get(link).getText();
            String keyLinkText = "Talent" + jobLinkText.replaceAll(" ", "");
            HyperLinkPage.driver.findElement(By.xpath("(//a[contains(text(),'" + jobLinkText + "')])[1]")).click();
            BaseClass.staticWaitForVisibility(2000);
            Assert.assertEquals("Validate Page URL", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(keyLinkText), HyperLinkPage.driver.getCurrentUrl());
            WebElement jobsStatusElement = HyperLinkPage.driver.findElement(By.xpath("//a[text()='" + jobLinkText + "']/.."));
            Assert.assertEquals("Validate Jobs Status", "active", jobsStatusElement.getAttribute("class").trim());
        }
    }


    public void overOnPaymentAndValidateAllLinkForTalentUser() {
        BaseClass.waitForVisibility(paymentIcon, 60, HyperLinkPage.driver);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, paymentIcon);
        List<WebElement> paymentList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Payments']/./../div/ul/li"));
        for (int link = 0; link < paymentList.size(); link++) {
            BaseClass.waitForVisibility(paymentIcon, 60, HyperLinkPage.driver);
            BaseClass.mouseOverOnElement(HyperLinkPage.driver, paymentIcon);
            paymentList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Payments']/./../div/ul/li"));
            String paymentLinkText = paymentList.get(link).getText();
            String keyLinkText = "Talent" + paymentLinkText.replaceAll(" ", "");
            HyperLinkPage.driver.findElement(By.xpath("(//a[contains(text(),'" + paymentLinkText + "')])[1]")).click();
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate Page URL", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(keyLinkText), HyperLinkPage.driver.getCurrentUrl());
            WebElement jobsStatusElement = HyperLinkPage.driver.findElement(By.xpath("//a[text()='" + paymentLinkText + "']/.."));
            Assert.assertEquals("Validate Payment Status", "active", jobsStatusElement.getAttribute("class").trim());
        }
    }


    public void validateMessageLinkForTalentUser() {
        BaseClass.waitForVisibility(messageIcon, 60, HyperLinkPage.driver);
        messageIcon.click();
        BaseClass.waitForVisibility(messageText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Message Text", "Messages", messageText.getText().trim());
        BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        Assert.assertEquals("Validate Message Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("TalentMessage"), HyperLinkPage.driver.getCurrentUrl());
    }


    public void validateHelpMenuLinksForTalentUser() {
        HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
        BaseClass.waitForVisibility(helpIcon, 60, HyperLinkPage.driver);
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, helpIcon);
        List<WebElement> helpLinktList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Help']/../div/ul/li/a"));
        for (int link = 0; link < helpLinktList.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
            BaseClass.waitForVisibility(helpIcon, 60, HyperLinkPage.driver);
            BaseClass.mouseOverOnElement(HyperLinkPage.driver, helpIcon);
            helpLinktList = HyperLinkPage.driver.findElements(By.xpath("//a[@id='Help']/../div/ul/li/a"));
            String keyLinkText = "Talent" + helpLinktList.get(link).getText().replaceAll(" ", "");
            helpLinktList.get(link).click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Menu Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(keyLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());

        }
    }


    public void validateUserProfileAndPremiumUrl(WebElement linkXpath, String urlKey) {
        HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, userIcon);
        BaseClass.javaScriptClick(HyperLinkPage.driver, linkXpath);
        BaseClass.staticWaitForVisibility(2000);
        Assert.assertEquals("Validate User Profile Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(urlKey), HyperLinkPage.driver.getCurrentUrl());
        BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
    }

    public void clickOnUserIconAndValidateAllLinksForTalentUser() {
        validateUserProfileAndPremiumUrl(userProfile, "TalentUserProfile");
        validateUserProfileAndPremiumUrl(premiumLink, "TalentPremium");
        HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
        BaseClass.mouseOverOnElement(HyperLinkPage.driver, userIcon);
        List<WebElement> userLinkList = HyperLinkPage.driver.findElements(By.xpath("//div[@class='flexbox']/../ul/li/a"));
        for (int link = 0; link < userLinkList.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
            BaseClass.waitForVisibility(userIcon, 60, HyperLinkPage.driver);
            BaseClass.mouseOverOnElement(HyperLinkPage.driver, userIcon);
            userLinkList = HyperLinkPage.driver.findElements(By.xpath("//div[@class='flexbox']/../ul/li/a"));
            String keyLinkText = "Talent" + userLinkList.get(link).getText().replaceAll(" ", "");
            BaseClass.javaScriptClick(HyperLinkPage.driver, userLinkList.get(link));
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate user link Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(keyLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }

    }

    public void validateAllResourcesLinkUnderFooterForTalentUser() {
        HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allResourceLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='Resources']/../ul/li/a"));
        for (int link = 0; link < allResourceLinks.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/projects/search?keywords=");
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allResourceLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='Resources']/../ul/li/a"));
            String resourceLinkText = "Talent" + allResourceLinks.get(link).getText().replaceAll(" ", "");
            allResourceLinks.get(link).click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate All Resource Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(resourceLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }


    public void clickOnHowItWorkAndValidateUrl() {
        BaseClass.waitForVisibility(howItWorkLink, 60, HyperLinkPage.driver);
        howItWorkLink.click();
        BaseClass.waitForVisibility(howItWorksText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate How It Work Text", "How It Works", howItWorksText.getText().trim());
        Assert.assertEquals("Validate Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("HowItWorks"), HyperLinkPage.driver.getCurrentUrl());
        BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        HyperLinkPage.driver.navigate().refresh();

    }

    public void clickOnLogInAndValidateUrl() {
        BaseClass.waitForVisibility(logInLink, 60, HyperLinkPage.driver);
        logInLink.click();
        BaseClass.waitForVisibility(logInToVoicesText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Log In Text", "Log In to Voices", logInToVoicesText.getText().trim());
        Assert.assertEquals("Validate Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("HowItWorks"), HyperLinkPage.driver.getCurrentUrl());
        BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        HyperLinkPage.driver.navigate().refresh();
    }

    public void clickOnSignUpAndValidateUrl() {
        BaseClass.waitForVisibility(signUpLink, 60, HyperLinkPage.driver);
        signUpLink.click();
        BaseClass.waitForVisibility(signUpWithVoicesText, 60, HyperLinkPage.driver);
        Assert.assertEquals("Validate Sign Up Text", "Sign Up with Voices", signUpWithVoicesText.getText().trim());
        Assert.assertEquals("Validate Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("HowItWorks"), HyperLinkPage.driver.getCurrentUrl());
        BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        HyperLinkPage.driver.navigate().refresh();
    }

    public void validateAllCompanyLinkUnderFooterForNonSignUser() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allCompanyLinks = HyperLinkPage.driver.findElements(By.xpath("//a[@aria-label='Expand mobile menu'][normalize-space()='Company']/../ul/li/a"));
        for (int link = 0; link < allCompanyLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allCompanyLinks = HyperLinkPage.driver.findElements(By.xpath("//a[@aria-label='Expand mobile menu'][normalize-space()='Company']/../ul/li/a"));
            String companyLinkText = allCompanyLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(companyLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allCompanyLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Company Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(companyLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateAllForClientLinkUnderFooterForNonSignUser() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allForClientLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='For Client']/../ul/li/a"));
        for (int link = 0; link < allForClientLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allForClientLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='For Client']/../ul/li/a"));
            String forClientLinkText = "NonSignUserClient" + allForClientLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(forClientLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allForClientLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All For Client Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(forClientLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateAllForTalentLinkUnderFooterForNonSignUser() {
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allForTalentLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='For Talent']/../ul/li/a"));
        for (int link = 0; link < allForTalentLinks.size(); link++) {
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allForTalentLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='For Talent']/../ul/li/a"));
            String forTalentLinkText = "NonSignUserTalent" + allForTalentLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(forTalentLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allForTalentLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
//            Assert.assertEquals("Validate All For Talent Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(forTalentLinkText), HyperLinkPage.driver.getCurrentUrl());
            Assert.assertTrue("Validate All For Talent Link", HyperLinkPage.driver.getCurrentUrl().contains(ReaderManager.getInstance().getConfigReader().getUrlEndPoint(forTalentLinkText)));
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }
    }

    public void validateSubFooterLinkForByLanguage() {
        HyperLinkPage.driver.get("https://www.voices.systems/");
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allByLanguageLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Language']/../ul/li/a"));
        for (int link = 0; link < allByLanguageLinks.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/");
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allByLanguageLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Language']/../ul/li/a"));
            String byLanguageLinkText = "NonSignUser" + allByLanguageLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(byLanguageLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allByLanguageLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
//            Assert.assertEquals("Validate All Language Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(byLanguageLinkText), HyperLinkPage.driver.getCurrentUrl());
            Assert.assertTrue("Validate All Language Link",  HyperLinkPage.driver.getCurrentUrl().contains(ReaderManager.getInstance().getConfigReader().getUrlEndPoint(byLanguageLinkText)));
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }

    }

    public void validateSubFooterLinkForByCategory() {
        HyperLinkPage.driver.get("https://www.voices.systems/");
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allByCategoryLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Category']/../ul/li/a"));
        for (int link = 0; link < allByCategoryLinks.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/");
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allByCategoryLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Category']/../ul/li/a"));
            String byCategoryLinkText = "NonSignUser" + allByCategoryLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(byCategoryLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allByCategoryLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Category Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(byCategoryLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }

    }
    public void validateSubFooterLinkForByStyle() {
        HyperLinkPage.driver.get("https://www.voices.systems/");
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allByStyleLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Style']/../ul/li/a"));
        for (int link = 0; link < allByStyleLinks.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/");
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allByStyleLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Style']/../ul/li/a"));
            String byStyleLinkText = "NonSignUser" + allByStyleLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(byStyleLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allByStyleLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Style Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(byStyleLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }

    }

    public void validateSubFooterLinkForByLocation() {
        HyperLinkPage.driver.get("https://www.voices.systems/");
        BaseClass.staticWaitForVisibility(2000);
        BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
        List<WebElement> allByLocationLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Location']/../ul/li/a"));
        for (int link = 0; link < allByLocationLinks.size(); link++) {
            HyperLinkPage.driver.get("https://www.voices.systems/");
            BaseClass.staticWaitForVisibility(2000);
            BaseClass.scrollUpToBottomOfPage(HyperLinkPage.driver);
            allByLocationLinks = HyperLinkPage.driver.findElements(By.xpath("//a[normalize-space()='By Location']/../ul/li/a"));
            String byLocationLinkText = "NonSignUser" + allByLocationLinks.get(link).getText().replaceAll(" ", "");
            System.out.println(byLocationLinkText);
            BaseClass.javaScriptClick(HyperLinkPage.driver, allByLocationLinks.get(link));
            BaseClass.staticWaitForVisibility(3000);
            System.out.println(HyperLinkPage.driver.getCurrentUrl());
            Assert.assertEquals("Validate All Location Link", ReaderManager.getInstance().getConfigReader().getUrlEndPoint(byLocationLinkText), HyperLinkPage.driver.getCurrentUrl());
            BaseClass.validateURLresponse(HyperLinkPage.driver.getCurrentUrl());
        }

    }


}
