package com.voices.stepDefinition.HomePage;

import com.voices.controlManager.TestContext;
import com.voices.managers.ReaderManager;
import com.voices.pageObjects.HomePageObj.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class HomePageSteps {

    TestContext testContext;
    private List<Map<String, String>> data;

    HomePage homePage;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.getPageManager().getHomePage();
    }

    @Given("User Open Home Page")
    public void user_open_home_page() {
        homePage.userLaunchAndValidateHomePage();
    }

    @Given("User Click on Find Talent Talent Profile and Validate all hyperlinks")
    public void user_click_on_find_talent_talent_profile_and_validate_all_hyperlinks() {
        homePage.verifyTalentProfileAllHyperLink();
    }

    @Given("User Click on Find Talent Talent Package and Validate all hyperlinks")
    public void user_click_on_find_talent_talent_package_and_validate_all_hyperlinks() {

    }

    @And("User click on How it works link and validate url")
    public void user_click_on_how_it_works_link_and_validate_url() {
        homePage.clickOnHowItWorkAndValidateUrl();
    }

    @And("User click on log in link and validate url")
    public void user_click_on_log_in_link_and_validate_url() {
        homePage.clickOnLogInAndValidateUrl();
    }

    @And("User click on sign up link and validate url")
    public void user_click_on_sign_up_link_and_validate_url() {
        homePage.clickOnSignUpAndValidateUrl();
    }

    @And("User validate all company links under footer for Non Sign user")
    public void user_validate_all_company_links_under_footer_for_non_sign_user() {
        homePage.validateAllCompanyLinkUnderFooterForNonSignUser();
    }

    @And("User validate all for client links under footer for Non Sign user")
    public void user_validate_all_for_client_links_under_footer_for_non_sign_user() {
        homePage.validateAllForClientLinkUnderFooterForNonSignUser();
    }

    @And("User validate all for talent links under footer for Non Sign user")
    public void user_validate_all_for_talent_links_under_footer_for_non_sign_user() {
        homePage.validateAllForTalentLinkUnderFooterForNonSignUser();
    }

    @And("User validate all social media links under footer for Non Sign user")
    public void user_validate_all_social_media_links_under_footer_for_non_sign_user() {
        homePage.validateSocialMediaLinkUnderFooter();
    }

    @And("User validate all footer links under footer for Non Sign user")
    public void user_validate_all_footer_links_under_footer_for_non_sign_user() {
        homePage.validateAllFooterLinkUnderFooter();
    }

    @And("User login with client credentials")
    public void user_login_with_client_credentials() {
        homePage.userLogin(ReaderManager.getInstance().getConfigReader().getClientUserName(), ReaderManager.getInstance().getConfigReader().getClientPassword(), "clientLoginUrl");
    }

    @And("User Click on post job and Validate url open successfully")
    public void user_click_on_post_job_and_validate_search_text_and_url() {
        homePage.userClickOnPostAJobAndValidateUrl();
    }

    @And("User Click on jobs and Validate all hyperlinks")
    public void user_click_on_jobs_and_validate_all_hyperlinks() {
        homePage.clickOnJobAndValidateAllLink();
    }

    @And("User Click on user icon and Validate all hyperlinks")
    public void user_click_on_user_icon_and_validate_all_hyperlinks() {
        homePage.clickOnUserIconAndValidateAllLinks();
    }

    @And("User Click on Messages and Notifications hyperlinks")
    public void user_click_on_messages_and_notifications_hyperlinks() {
        homePage.clickOnMessagesAndNotificationLinks();
    }

    @Then("Validate all sub module hyperlink")
    public void validate_all_sub_module_hyperlink() {
        homePage.validateSubModuleLink();
    }

    @Then("User validate all company link under footer of page")
    public void user_validate_all_company_link_under_footer_of_page() {
        homePage.validateAllCompanyLinkUnderFooter();
    }

    @Then("User validate all resources link under footer of page")
    public void user_validate_all_resources_link_under_footer_of_page() {
        homePage.validateAllResourcesLinkUnderFooter();
    }

    @Then("User validate all social media link under footer of page")
    public void user_validate_all_social_media_link_under_footer_of_page() {
        homePage.validateSocialMediaLinkUnderFooter();
    }

    @Then("User validate all footer link under footer of page")
    public void user_validate_all_footer_link_under_footer_of_page() {
        homePage.validateAllFooterLinkUnderFooter();
    }

    @And("User login with Talent Guest credentials")
    public void user_login_with_Talent_Guest_credentials() {
        homePage.userLogin(ReaderManager.getInstance().getConfigReader().getTalentGuestUserName(), ReaderManager.getInstance().getConfigReader().getTalentGuestPassword(), "TalentLoginUrl");
    }

    @And("User over on jobs and Validate all hyperlinks")
    public void user_over_on_jobs_and_Validate_all_hyperlinks() {
        homePage.overOnJobAndValidateAllLinkForTalentUser();
    }

    @And("User Click on payments and Validate all hyperlinks")
    public void user_Click_on_payments_and_Validate_all_hyperlinks() {
        homePage.overOnPaymentAndValidateAllLinkForTalentUser();
    }

    @And("User Click on Messages and validate hyperlinks")
    public void user_Click_on_Messages_and_validate_hyperlinks() {
        homePage.validateMessageLinkForTalentUser();
    }

    @And("User Click on helps and Validate all hyperlinks")
    public void user_Click_on_helps_and_Validate_all_hyperlinks() {
        homePage.validateHelpMenuLinksForTalentUser();
    }

    @And("User click on user icon and validate all hyperlink")
    public void user_click_on_user_icon_and_validate_all_hyperlink() {
        homePage.clickOnUserIconAndValidateAllLinksForTalentUser();
    }

    @And("User validate all resources link under footer of page for talent user")
    public void user_validate_all_resources_link_under_footer_of_page_for_talent_user() {
        homePage.validateAllResourcesLinkUnderFooterForTalentUser();
    }

    @Given("User validate all by language links for non login user")
    public void user_validate_all_by_language_links_for_non_login_user() {
        homePage.validateSubFooterLinkForByLanguage();
    }

    @Given("User validate all by category links for non login user")
    public void user_validate_all_by_category_links_for_non_login_user() {
        homePage.validateSubFooterLinkForByCategory();
    }

    @Given("User validate all by style links for non login user")
    public void user_validate_all_by_style_links_for_non_login_user() {
        homePage.validateSubFooterLinkForByStyle();
    }

    @Given("User validate all by location links for non login user")
    public void user_validate_all_by_location_links_for_non_login_user() {
        homePage.validateSubFooterLinkForByLocation();
    }

}