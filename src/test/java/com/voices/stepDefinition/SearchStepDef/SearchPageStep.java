package com.voices.stepDefinition.SearchStepDef;

import com.voices.controlManager.TestContext;
import com.voices.pageObjects.HomePageObj.HomePage;
import com.voices.pageObjects.SearchPageObj.SearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class SearchPageStep {
    TestContext testContext;

    SearchPage searchPage;

    public SearchPageStep(TestContext testContext) {
        this.testContext = testContext;
        searchPage = testContext.getPageManager().getSearchPage();
    }

    @And("User validate category packages search function for Non Sign User")
    public void user_validate_category_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @And("User validate language packages search function for Non Sign User")
    public void user_validate_language_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @And("User validate accent packages search function for Non Sign User")
    public void user_validate_accent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @And("User validate voice gender packages search function for Non Sign User")
    public void user_validate_voice_gender_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @And("User validate voice age packages search function for Non Sign User")
    public void user_validate_voice_age_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @And("User validate price packages search function for Non Sign User")
    public void user_validate_price_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesAgeSearchForNonSignUser(minimumPrice, maximumPrice);
    }

    @And("User validate delivery time packages search function for Non Sign User")
    public void user_validate_delivery_time_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        String deliveryTime03 = deliveryTimeList.get(0).get("Delivery Time 03");
        searchPage.validateVoicesDeliveryTimeSearchForNonSignUser(deliveryTime01, deliveryTime02, deliveryTime03);
    }

    @And("User validate talent tier packages search function for Non Sign User")
    public void user_validate_talent_tier_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(talentTier01, talentTier02);
    }

    @And("User validate online status packages search function for Non Sign User")
    public void user_validate_online_status_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(onlineStatus01);
    }

    @And("User validate location packages search function for Non Sign User")
    public void user_validate_location_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(country, state, city);
    }


    @And("User validate category talent search function for Non Sign User")
    public void user_validate_category_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @And("User validate language talent search function for Non Sign User")
    public void user_validate_language_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @And("User validate accent talent search function for Non Sign User")
    public void user_validate_accent_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @And("User validate voice gender talent search function for Non Sign User")
    public void user_validate_voice_gender_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @And("User validate voice age talent search function for Non Sign User")
    public void user_validate_voice_age_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @And("User validate voice role talent search function for Non Sign User")
    public void user_validate_voice_role_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

    @And("User validate style talent search function for Non Sign User")
    public void user_validate_style_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

    @And("User validate talent tier talent search function for Non Sign User")
    public void user_validate_talent_tier_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

    @And("User validate online status talent search function for Non Sign User")
    public void user_validate_online_status_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

    @And("User validate location talent search function for Non Sign User")
    public void user_validate_location_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

    @And("User validate live directed session talent search function for Non Sign User")
    public void user_validate_live_directed_session_talent_search_function_for_non_sign_user(DataTable dataTable) {

    }

}
