package com.voices.stepDefinition.SearchStepDef;

import com.voices.controlManager.TestContext;
import com.voices.pageObjects.SearchPageObj.SearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @And("User validate online status packages search function for Non Sign User")
    public void user_validate_online_status_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @And("User validate location packages search function for Non Sign User")
    public void user_validate_location_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
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
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        String role02 = roleList.get(0).get("Role 02");
        String role03 = roleList.get(0).get("Role 03");
        String role04 = roleList.get(0).get("Role 04");
        searchPage.validateRoleSearchForNonSignUser(tabName, role01, role02, role03, role04);
    }

    @And("User validate style talent search function for Non Sign User")
    public void user_validate_style_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        String style02 = styleList.get(0).get("Style 02");
        String style03 = styleList.get(0).get("Style 03");
        String style04 = styleList.get(0).get("Style 04");
        searchPage.validateStyleSearchForNonSignUser(tabName, style01, style02, style03, style04);

    }

    @And("User validate talent tier talent search function for Non Sign User")
    public void user_validate_talent_tier_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @And("User validate online status talent search function for Non Sign User")
    public void user_validate_online_status_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @And("User validate location talent search function for Non Sign User")
    public void user_validate_location_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
    }

    @And("User validate live directed session talent search function for Non Sign User")
    public void user_validate_live_directed_session_talent_search_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        String liveDirSession02 = liveDirected.get(0).get("Live Dir Session 02");
        String liveDirSession03 = liveDirected.get(0).get("Live Dir Session 03");
        String liveDirSession04 = liveDirected.get(0).get("Live Dir Session 04");
        searchPage.validateLiveDirectedSessionSearchForNonSignUser(tabName, liveDirSession01, liveDirSession02, liveDirSession03, liveDirSession04);

    }

    @Given("User validate category packages play demo function for Non Sign User")
    public void user_validate_category_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages play demo function for Non Sign User")
    public void user_validate_language_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages play demo function for Non Sign User")
    public void user_validate_accent_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages play demo function for Non Sign User")
    public void user_validate_voice_gender_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages play demo function for Non Sign User")
    public void user_validate_voice_age_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages play demo function for Non Sign User")
    public void user_validate_price_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPricePlayDemoForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages play demo function for Non Sign User")
    public void user_validate_delivery_time_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimePlayDemoForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages play demo function for Non Sign User")
    public void user_validate_talent_tier_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages play demo function for Non Sign User")
    public void user_validate_online_status_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages play demo function for Non Sign User")
    public void user_validate_location_packages_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent play demo function for Non Sign User")
    public void user_validate_category_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent play demo function for Non Sign User")
    public void user_validate_language_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent play demo function for Non Sign User")
    public void user_validate_accent_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent play demo function for Non Sign User")
    public void user_validate_voice_gender_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent play demo function for Non Sign User")
    public void user_validate_voice_age_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent play demo function for Non Sign User")
    public void user_validate_voice_role_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRolePlayDemoForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent play demo function for Non Sign User")
    public void user_validate_style_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStylePlayDemoForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent play demo function for Non Sign User")
    public void user_validate_talent_tier_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent play demo function for Non Sign User")
    public void user_validate_online_status_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent play demo function for Non Sign User")
    public void user_validate_location_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent play demo function for Non Sign User")
    public void user_validate_live_directed_session_talent_play_demo_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionPlayDemoForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate category packages search function for Client User")
    public void user_validate_category_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @Given("User validate language packages search function for Client User")
    public void user_validate_language_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @Given("User validate accent packages search function for Client User")
    public void user_validate_accent_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @Given("User validate voice gender packages search function for Client User")
    public void user_validate_voice_gender_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages search function for Client User")
    public void user_validate_voice_age_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @Given("User validate price packages search function for Client User")
    public void user_validate_price_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesAgeSearchForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages search function for Client User")
    public void user_validate_delivery_time_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        String deliveryTime03 = deliveryTimeList.get(0).get("Delivery Time 03");
        searchPage.validateVoicesDeliveryTimeSearchForNonSignUser(deliveryTime01, deliveryTime02, deliveryTime03);
    }

    @Given("User validate talent tier packages search function for Client User")
    public void user_validate_talent_tier_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages search function for Client User")
    public void user_validate_online_status_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages search function for Client User")
    public void user_validate_location_packages_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent search function for Client User")
    public void user_validate_category_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @Given("User validate language talent search function for Client User")
    public void user_validate_language_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @Given("User validate accent talent search function for Client User")
    public void user_validate_accent_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @Given("User validate voice gender talent search function for Client User")
    public void user_validate_voice_gender_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent search function for Client User")
    public void user_validate_voice_age_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @Given("User validate voice role talent search function for Client User")
    public void user_validate_voice_role_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        String role02 = roleList.get(0).get("Role 02");
        String role03 = roleList.get(0).get("Role 03");
        String role04 = roleList.get(0).get("Role 04");
        searchPage.validateRoleSearchForNonSignUser(tabName, role01, role02, role03, role04);
    }

    @Given("User validate style talent search function for Client User")
    public void user_validate_style_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        String style02 = styleList.get(0).get("Style 02");
        String style03 = styleList.get(0).get("Style 03");
        String style04 = styleList.get(0).get("Style 04");
        searchPage.validateStyleSearchForNonSignUser(tabName, style01, style02, style03, style04);
    }

    @Given("User validate talent tier talent search function for Client User")
    public void user_validate_talent_tier_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status talent search function for Client User")
    public void user_validate_online_status_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent search function for Client User")
    public void user_validate_location_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent search function for Client User")
    public void user_validate_live_directed_session_talent_search_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        String liveDirSession02 = liveDirected.get(0).get("Live Dir Session 02");
        String liveDirSession03 = liveDirected.get(0).get("Live Dir Session 03");
        String liveDirSession04 = liveDirected.get(0).get("Live Dir Session 04");
        searchPage.validateLiveDirectedSessionSearchForNonSignUser(tabName, liveDirSession01, liveDirSession02, liveDirSession03, liveDirSession04);
    }

    @Given("User validate category packages play demo function for Client User")
    public void user_validate_category_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages play demo function for Client User")
    public void user_validate_language_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages play demo function for Client User")
    public void user_validate_accent_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages play demo function for Client User")
    public void user_validate_voice_gender_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages play demo function for Client User")
    public void user_validate_voice_age_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages play demo function for Client User")
    public void user_validate_price_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPricePlayDemoForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages play demo function for Client User")
    public void user_validate_delivery_time_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimePlayDemoForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages play demo function for Client User")
    public void user_validate_talent_tier_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages play demo function for Client User")
    public void user_validate_online_status_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages play demo function for Client User")
    public void user_validate_location_packages_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent play demo function for Client User")
    public void user_validate_category_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent play demo function for Client User")
    public void user_validate_language_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent play demo function for Client User")
    public void user_validate_accent_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent play demo function for Client User")
    public void user_validate_voice_gender_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent play demo function for Client User")
    public void user_validate_voice_age_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent play demo function for Client User")
    public void user_validate_voice_role_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRolePlayDemoForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent play demo function for Client User")
    public void user_validate_style_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStylePlayDemoForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent play demo function for Client User")
    public void user_validate_talent_tier_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent play demo function for Client User")
    public void user_validate_online_status_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent play demo function for Client User")
    public void user_validate_location_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent play demo function for Client User")
    public void user_validate_live_directed_session_talent_play_demo_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionPlayDemoForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate category packages search function for Guest User")
    public void user_validate_category_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @Given("User validate language packages search function for Guest User")
    public void user_validate_language_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @Given("User validate accent packages search function for Guest User")
    public void user_validate_accent_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @Given("User validate voice gender packages search function for Guest User")
    public void user_validate_voice_gender_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages search function for Guest User")
    public void user_validate_voice_age_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @Given("User validate price packages search function for Guest User")
    public void user_validate_price_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesAgeSearchForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages search function for Guest User")
    public void user_validate_delivery_time_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        String deliveryTime03 = deliveryTimeList.get(0).get("Delivery Time 03");
        searchPage.validateVoicesDeliveryTimeSearchForNonSignUser(deliveryTime01, deliveryTime02, deliveryTime03);
    }

    @Given("User validate talent tier packages search function for Guest User")
    public void user_validate_talent_tier_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages search function for Guest User")
    public void user_validate_online_status_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages search function for Guest User")
    public void user_validate_location_packages_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent search function for Guest User")
    public void user_validate_category_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        String category03 = catagoryList.get(0).get("Category 03");
        String category04 = catagoryList.get(0).get("Category 04");
        searchPage.validateCategorySearchForNonSignUser(tabName, category01, category02, category03, category04);
    }

    @Given("User validate language talent search function for Guest User")
    public void user_validate_language_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        String language03 = languageList.get(0).get("Language 03");
        String language04 = languageList.get(0).get("Language 04");
        searchPage.validateLanguageSearchForNonSignUser(tabName, language01, language02, language03, language04);
    }

    @Given("User validate accent talent search function for Guest User")
    public void user_validate_accent_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        String accent03 = languageList.get(0).get("Accent 03");
        searchPage.validateAccentSearchForNonSignUser(tabName, accent01, accent02, accent03);
    }

    @Given("User validate voice gender talent search function for Guest User")
    public void user_validate_voice_gender_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderSearchForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent search function for Guest User")
    public void user_validate_voice_age_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        String age03 = ageList.get(0).get("Age 03");
        String age04 = ageList.get(0).get("Age 04");
        searchPage.validateVoicesAgeSearchForNonSignUser(tabName, age01, age02, age03, age04);
    }

    @Given("User validate voice role talent search function for Guest User")
    public void user_validate_voice_role_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        String role02 = roleList.get(0).get("Role 02");
        String role03 = roleList.get(0).get("Role 03");
        String role04 = roleList.get(0).get("Role 04");
        searchPage.validateRoleSearchForNonSignUser(tabName, role01, role02, role03, role04);
    }

    @Given("User validate style talent search function for Guest User")
    public void user_validate_style_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        String style02 = styleList.get(0).get("Style 02");
        String style03 = styleList.get(0).get("Style 03");
        String style04 = styleList.get(0).get("Style 04");
        searchPage.validateStyleSearchForNonSignUser(tabName, style01, style02, style03, style04);
    }

    @Given("User validate talent tier talent search function for Guest User")
    public void user_validate_talent_tier_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeSearchForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status talent search function for Guest User")
    public void user_validate_online_status_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusSearchForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent search function for Guest User")
    public void user_validate_location_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationSearchForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent search function for Guest User")
    public void user_validate_live_directed_session_talent_search_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        String liveDirSession02 = liveDirected.get(0).get("Live Dir Session 02");
        String liveDirSession03 = liveDirected.get(0).get("Live Dir Session 03");
        String liveDirSession04 = liveDirected.get(0).get("Live Dir Session 04");
        searchPage.validateLiveDirectedSessionSearchForNonSignUser(tabName, liveDirSession01, liveDirSession02, liveDirSession03, liveDirSession04);

    }

    @Given("User validate category packages play demo function for Guest User")
    public void user_validate_category_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages play demo function for Guest User")
    public void user_validate_language_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages play demo function for Guest User")
    public void user_validate_accent_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages play demo function for Guest User")
    public void user_validate_voice_gender_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages play demo function for Guest User")
    public void user_validate_voice_age_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages play demo function for Guest User")
    public void user_validate_price_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPricePlayDemoForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages play demo function for Guest User")
    public void user_validate_delivery_time_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimePlayDemoForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages play demo function for Guest User")
    public void user_validate_talent_tier_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages play demo function for Guest User")
    public void user_validate_online_status_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages play demo function for Guest User")
    public void user_validate_location_packages_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent play demo function for Guest User")
    public void user_validate_category_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryPlayDemoForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent play demo function for Guest User")
    public void user_validate_language_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguagePlayDemoForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent play demo function for Guest User")
    public void user_validate_accent_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentPlayDemoForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent play demo function for Guest User")
    public void user_validate_voice_gender_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderPlayDemoForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent play demo function for Guest User")
    public void user_validate_voice_age_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgePlayDemoForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent play demo function for Guest User")
    public void user_validate_voice_role_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRolePlayDemoForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent play demo function for Guest User")
    public void user_validate_style_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStylePlayDemoForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent play demo function for Guest User")
    public void user_validate_talent_tier_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimePlayDemoForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent play demo function for Guest User")
    public void user_validate_online_status_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusPlayDemoForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent play demo function for Guest User")
    public void user_validate_location_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationPlayDemoForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent play demo function for Guest User")
    public void user_validate_live_directed_session_talent_play_demo_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionPlayDemoForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate category packages Clear function for Non Sign User")
    public void user_validate_category_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages Clear function for Non Sign User")
    public void user_validate_language_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages Clear function for Non Sign User")
    public void user_validate_accent_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages Clear function for Non Sign User")
    public void user_validate_voice_gender_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages Clear function for Non Sign User")
    public void user_validate_voice_age_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages Clear function for Non Sign User")
    public void user_validate_price_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPriceClearForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages Clear function for Non Sign User")
    public void user_validate_delivery_time_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimeClearForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages Clear function for Non Sign User")
    public void user_validate_talent_tier_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages Clear function for Non Sign User")
    public void user_validate_online_status_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages Clear function for Non Sign User")
    public void user_validate_location_packages_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent Clear function for Non Sign User")
    public void user_validate_category_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent Clear function for Non Sign User")
    public void user_validate_language_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent Clear function for Non Sign User")
    public void user_validate_accent_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent Clear function for Non Sign User")
    public void user_validate_voice_gender_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent Clear function for Non Sign User")
    public void user_validate_voice_age_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent Clear function for Non Sign User")
    public void user_validate_voice_role_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRoleClearForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent Clear function for Non Sign User")
    public void user_validate_style_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStyleClearForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent Clear function for Non Sign User")
    public void user_validate_talent_tier_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent Clear function for Non Sign User")
    public void user_validate_online_status_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent Clear function for Non Sign User")
    public void user_validate_location_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent Clear function for Non Sign User")
    public void user_validate_live_directed_session_talent_clear_function_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionClearForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate category packages Clear function for Client User")
    public void user_validate_category_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages Clear function for Client User")
    public void user_validate_language_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages Clear function for Client User")
    public void user_validate_accent_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages Clear function for Client User")
    public void user_validate_voice_gender_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages Clear function for Client User")
    public void user_validate_voice_age_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages Clear function for Client User")
    public void user_validate_price_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPriceClearForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages Clear function for Client User")
    public void user_validate_delivery_time_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimeClearForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages Clear function for Client User")
    public void user_validate_talent_tier_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages Clear function for Client User")
    public void user_validate_online_status_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages Clear function for Client User")
    public void user_validate_location_packages_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent Clear function for Client User")
    public void user_validate_category_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent Clear function for Client User")
    public void user_validate_language_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent Clear function for Client User")
    public void user_validate_accent_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent Clear function for Client User")
    public void user_validate_voice_gender_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent Clear function for Client User")
    public void user_validate_voice_age_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent Clear function for Client User")
    public void user_validate_voice_role_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRoleClearForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent Clear function for Client User")
    public void user_validate_style_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStyleClearForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent Clear function for Client User")
    public void user_validate_talent_tier_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent Clear function for Client User")
    public void user_validate_online_status_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent Clear function for ClientUser")
    public void user_validate_location_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent Clear function for Client User")
    public void user_validate_live_directed_session_talent_clear_function_for_client_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionClearForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate category packages Clear function for Guest User")
    public void user_validate_category_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language packages Clear function for Guest User")
    public void user_validate_language_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent packages Clear function for Guest User")
    public void user_validate_accent_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender packages Clear function for Guest User")
    public void user_validate_voice_gender_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age packages Clear function for Guest User")
    public void user_validate_voice_age_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate price packages Clear function for Guest User")
    public void user_validate_price_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> priceList = dataTable.asMaps(String.class, String.class);
        String minimumPrice = priceList.get(0).get("Minimum Price");
        String maximumPrice = priceList.get(0).get("Maximum Price");
        searchPage.validateVoicesPriceClearForNonSignUser(minimumPrice, maximumPrice);
    }

    @Given("User validate delivery time packages Clear function for Guest User")
    public void user_validate_delivery_time_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> deliveryTimeList = dataTable.asMaps(String.class, String.class);
        String deliveryTime01 = deliveryTimeList.get(0).get("Delivery Time 01");
        String deliveryTime02 = deliveryTimeList.get(0).get("Delivery Time 02");
        searchPage.validateVoicesDeliveryTimeClearForNonSignUser(deliveryTime01, deliveryTime02);
    }

    @Given("User validate talent tier packages Clear function for Guest User")
    public void user_validate_talent_tier_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        String talentTier02 = talentTierList.get(0).get("Talent Tier 02");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01, talentTier02);
    }

    @Given("User validate online status packages Clear function for Guest User")
    public void user_validate_online_status_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location packages Clear function for Guest User")
    public void user_validate_location_packages_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate category talent Clear function for Guest User")
    public void user_validate_category_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> catagoryList = dataTable.asMaps(String.class, String.class);
        String tabName = catagoryList.get(0).get("Tab Name");
        String category01 = catagoryList.get(0).get("Category 01");
        String category02 = catagoryList.get(0).get("Category 02");
        searchPage.validateCategoryClearForNonSignUser(tabName, category01, category02);
    }

    @Given("User validate language talent Clear function for Guest User")
    public void user_validate_language_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String language01 = languageList.get(0).get("Language 01");
        String language02 = languageList.get(0).get("Language 02");
        searchPage.validateLanguageClearForNonSignUser(tabName, language01, language02);
    }

    @Given("User validate accent talent Clear function for Guest User")
    public void user_validate_accent_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> languageList = dataTable.asMaps(String.class, String.class);
        String tabName = languageList.get(0).get("Tab Name");
        String accent01 = languageList.get(0).get("Accent 01");
        String accent02 = languageList.get(0).get("Accent 02");
        searchPage.validateAccentClearForNonSignUser(tabName, accent01, accent02);
    }

    @Given("User validate voice gender talent Clear function for Guest User")
    public void user_validate_voice_gender_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> genderList = dataTable.asMaps(String.class, String.class);
        String tabName = genderList.get(0).get("Tab Name");
        String gender01 = genderList.get(0).get("Gender 01");
        String gender02 = genderList.get(0).get("Gender 02");
        searchPage.validateVoicesGenderClearForNonSignUser(tabName, gender01, gender02);
    }

    @Given("User validate voice age talent Clear function for Guest User")
    public void user_validate_voice_age_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> ageList = dataTable.asMaps(String.class, String.class);
        String tabName = ageList.get(0).get("Tab Name");
        String age01 = ageList.get(0).get("Age 01");
        String age02 = ageList.get(0).get("Age 02");
        searchPage.validateVoicesAgeClearForNonSignUser(tabName, age01, age02);
    }

    @Given("User validate voice role talent Clear function for Guest User")
    public void user_validate_voice_role_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> roleList = dataTable.asMaps(String.class, String.class);
        String tabName = roleList.get(0).get("Tab Name");
        String role01 = roleList.get(0).get("Role 01");
        searchPage.validateRoleClearForNonSignUser(tabName, role01);
    }

    @Given("User validate style talent Clear function for Guest User")
    public void user_validate_style_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> styleList = dataTable.asMaps(String.class, String.class);
        String tabName = styleList.get(0).get("Tab Name");
        String style01 = styleList.get(0).get("Style 01");
        searchPage.validateStyleClearForNonSignUser(tabName, style01);
    }

    @Given("User validate talent tier talent Clear function for Guest User")
    public void user_validate_talent_tier_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> talentTierList = dataTable.asMaps(String.class, String.class);
        String tabName = talentTierList.get(0).get("Tab Name");
        String talentTier01 = talentTierList.get(0).get("Talent Tier 01");
        searchPage.validateVoicesTalentTierTimeClearForNonSignUser(tabName, talentTier01);
    }

    @Given("User validate online status talent Clear function for Guest User")
    public void user_validate_online_status_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> onlineStatusList = dataTable.asMaps(String.class, String.class);
        String tabName = onlineStatusList.get(0).get("Tab Name");
        String onlineStatus01 = onlineStatusList.get(0).get("Online Status 01");
        searchPage.validateVoicesOnlineStatusClearForNonSignUser(tabName, onlineStatus01);
    }

    @Given("User validate location talent Clear function for Guest User")
    public void user_validate_location_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> location = dataTable.asMaps(String.class, String.class);
        String tabName = location.get(0).get("Tab Name");
        String country = location.get(0).get("Country");
        String state = location.get(0).get("State");
        String city = location.get(0).get("City");
        searchPage.validateVoicesLocationClearForNonSignUser(tabName, country, state, city);
    }

    @Given("User validate live directed session talent Clear function for Guest User")
    public void user_validate_live_directed_session_talent_clear_function_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> liveDirected = dataTable.asMaps(String.class, String.class);
        String tabName = liveDirected.get(0).get("Tab Name");
        String liveDirSession01 = liveDirected.get(0).get("Live Dir Session 01");
        searchPage.validateLiveDirectedSessionClearForNonSignUser(tabName, liveDirSession01);
    }

    @Given("User validate Profile Name for packages for Non Sign User")
    public void user_validate_profile_name_for_packages_for_non_sign_user() {
        searchPage.validateProfileNameForPackageTab();
    }

    @Given("User validate Profile Name for Talent for Non Sign User")
    public void user_validate_profile_name_for_talent_for_non_sign_user() {
        searchPage.validateProfileNameForTalentTab();
    }

    @Given("User validate Profile Name for packages for Client User")
    public void user_validate_profile_name_for_packages_for_client_user() {
        searchPage.validateProfileNameForPackageTab();
    }

    @Given("User validate Profile Name for Talent for Client User")
    public void user_validate_gadget_name_for_talent_for_client_user() {
        searchPage.validateProfileNameForTalentTab();
    }

    @Given("User validate Profile Name for packages for Guest User")
    public void user_validate_profile_name_for_packages_for_guest_user() {
        searchPage.validateProfileNameForPackageTab();
    }

    @Given("User validate Profile Name for Talent for Guest User")
    public void user_validate_profile_name_for_talent_for_guest_user() {
        searchPage.validateProfileNameForTalentTab();
    }

    @Given("User validate star rating for packages for Non Sign User")
    public void user_validate_star_rating_for_packages_for_non_sign_user() {
        searchPage.validateStarRatingForPackageTab();
    }

    @Given("User validate star rating for Talent for Non Sign User")
    public void user_validate_star_rating_for_talent_for_non_sign_user() {
        searchPage.validateStarRatingForTalentTab();
    }

    @Given("User validate star rating for packages for Client User")
    public void user_validate_star_rating_for_packages_for_client_user() {
        searchPage.validateStarRatingForPackageTab();
    }

    @Given("User validate star rating for Talent for Client User")
    public void user_validate_star_rating_for_talent_for_client_user() {
        searchPage.validateStarRatingForTalentTab();
    }

    @Given("User validate star rating for packages for Guest User")
    public void user_validate_star_rating_for_packages_for_guest_user() {
        searchPage.validateStarRatingForPackageTab();
    }

    @Given("User validate star rating for Talent for Guest User")
    public void user_validate_star_rating_for_talent_for_guest_user() {
        searchPage.validateStarRatingForTalentTab();
    }


    @Given("User validate sort by rating for packages for Non Sign User")
    public void user_validate_sort_by_rating_for_packages_for_non_sign_user() {
        searchPage.validateSortByRatingForPackageTab();
    }

    @Given("User validate sort by review for packages for Non Sign User")
    public void user_validate_sort_by_review_for_packages_for_non_sign_user() {
        searchPage.validateSortByReviewForPackageTab();
    }

    @Given("User validate sort by price for packages for Non Sign User")
    public void user_validate_sort_by_price_for_packages_for_non_sign_user() {
        searchPage.validateSortByPriceForPackageTab();
    }

    @Given("User validate sort by rating for Talent for Non Sign User")
    public void user_validate_sort_by_rating_for_talent_for_non_sign_user() {
        searchPage.validateSortByRatingForTalentTab();
    }

    @Given("User validate sort by review for Talent for Non Sign User")
    public void user_validate_sort_by_review_for_talent_for_non_sign_user() {
        searchPage.validateSortByReviewForTalentTab();
    }

    @Given("User validate sort by rating for packages for Client User")
    public void user_validate_sort_by_rating_for_packages_for_client_user() {
        searchPage.validateSortByRatingForPackageTab();
    }

    @Given("User validate sort by review for packages for Client User")
    public void user_validate_sort_by_review_for_packages_for_client_user() {
        searchPage.validateSortByReviewForPackageTab();
    }

    @Given("User validate sort by price for packages for Client User")
    public void user_validate_sort_by_price_for_packages_for_client_user() {
        searchPage.validateSortByPriceForPackageTab();
    }


    @Given("User validate sort by rating for Talent for Client User")
    public void user_validate_sort_by_rating_for_talent_for_client_user() {
        searchPage.validateSortByRatingForTalentTab();
    }

    @Given("User validate sort by review for Talent for Client User")
    public void user_validate_sort_by_review_for_talent_for_client_user() {
        searchPage.validateSortByReviewForTalentTab();
    }

    @Given("User validate sort by rating for packages for Guest User")
    public void user_validate_sort_by_rating_for_packages_for_guest_user() {
        searchPage.validateSortByRatingForPackageTab();
    }

    @Given("User validate sort by review for packages for Guest User")
    public void user_validate_sort_by_review_for_packages_for_guest_user() {
        searchPage.validateSortByReviewForPackageTab();
    }

    @Given("User validate sort by price for packages for Guest User")
    public void user_validate_sort_by_price_for_packages_for_guest_user() {
        searchPage.validateSortByPriceForPackageTab();
    }

    @Given("User validate sort by rating for Talent for Guest User")
    public void user_validate_sort_by_rating_for_talent_for_guest_user() {
        searchPage.validateSortByRatingForTalentTab();
    }

    @Given("User validate sort by review for Talent for Guest User")
    public void user_validate_sort_by_review_for_talent_for_guest_user() {
        searchPage.validateSortByReviewForTalentTab();
    }

    @Given("User add favorites into the list for client user for packages tab")
    public void user_add_favorites_into_the_list(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String listName = list.get(0).get("List Name");
        searchPage.addFavoritesForClientUserUserPackagesTab(listName);
    }

    @Then("Validate added favorite for packages tab display in favorite tab for client user")
    public void validate_added_favorite_display_in_favorite_tab(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String listName = list.get(0).get("List Name");
        searchPage.validateAddedFavoriteCountForPackageTab(listName);
    }

    @Given("User add favorites into the list for client user for talent tab")
    public void user_add_favorites_into_the_list_for_talent_tab(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String listName = list.get(0).get("List Name");
        searchPage.addFavoritesForClientUserTalentTab(listName);
    }

    @Then("Validate added favorite for talent tab display in favorite tab for client user")
    public void validate_added_favorite_display_in_favorite_tab_for_talent_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String listName = list.get(0).get("List Name");
        searchPage.validateAddedFavoriteCountForTalentTab(listName);
    }

    @When("User select multiple dropdown options for packages tab for Non Sign User")
    public void user_select_multiple_dropdown_options_for_packages_tab_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Packages tab for Non Sign User")
    public void validate_multiple_dropdown_option_for_packages_tab_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @When("User select multiple dropdown options for Talent tab for Non Sign User")
    public void user_select_multiple_dropdown_options_for_talent_tab_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Talent tab for Non Sign User")
    public void validate_multiple_dropdown_option_for_talent_tab_for_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @When("User select multiple dropdown options for packages tab for Client User")
    public void user_select_multiple_dropdown_options_for_packages_tab_for_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Packages tab for Client User")
    public void validate_multiple_dropdown_option_for_packages_tab_for_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @When("User select multiple dropdown options for Talent tab for Client User")
    public void user_select_multiple_dropdown_options_for_talent_tab_for_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Talent tab for Client User")
    public void validate_multiple_dropdown_option_for_talent_tab_for_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @When("User select multiple dropdown options for packages tab for Guest User")
    public void user_select_multiple_dropdown_options_for_packages_tab_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Packages tab for Guest User")
    public void validate_multiple_dropdown_option_for_packages_tab_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @When("User select multiple dropdown options for Talent tab for Guest User")
    public void user_select_multiple_dropdown_options_for_talent_tab_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.selectMultipleDropdownValue(tabName, category, language, accent);

    }

    @Then("Validate multiple dropdown option for Talent tab for Guest User")
    public void validate_multiple_dropdown_option_for_talent_tab_for_guest_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String tabName = list.get(0).get("Tab Name");
        String category = list.get(0).get("Category 01");
        String language = list.get(0).get("Language 01");
        String accent = list.get(0).get("Accent 01");
        searchPage.validateMultiDropdownSelection(tabName, category, language, accent);
    }

    @Given("User enter options for advance search for packages non sign user")
    public void user_enter_options_for_advance_search_for_packages_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String minPrice = list.get(0).get("Min Price");
        String maxPrice = list.get(0).get("Max Price");
        String deliveryTime = list.get(0).get("Delivery Time");
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForPackagesTabForNonSignUser(minPrice, maxPrice, deliveryTime, category, language, accent, gender, age, keyword);
    }

    @Then("Validate result for advance search for packages non sign user")
    public void validate_result_for_advance_search_for_packages_non_sign_user() {
        searchPage.validateAdvanceSearchResultsForPackagesTab();
    }

    @Given("User enter options for advance search for packages Client user")
    public void user_enter_options_for_advance_search_for_packages_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String minPrice = list.get(0).get("Min Price");
        String maxPrice = list.get(0).get("Max Price");
        String deliveryTime = list.get(0).get("Delivery Time");
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForPackagesTabForSignUser(minPrice, maxPrice, deliveryTime, category, language, accent, gender, age, keyword);
    }

    @Then("Validate result for advance search for packages Client user")
    public void validate_result_for_advance_search_for_packages_client_user() {
        searchPage.validateAdvanceSearchResultsForPackagesTab();
    }

    @Given("User enter options for advance search for packages talent guest user")
    public void user_enter_options_for_advance_search_for_packages_talent_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String minPrice = list.get(0).get("Min Price");
        String maxPrice = list.get(0).get("Max Price");
        String deliveryTime = list.get(0).get("Delivery Time");
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForPackagesTabForSignUser(minPrice, maxPrice, deliveryTime, category, language, accent, gender, age, keyword);
    }

    @Then("Validate result for advance search for packages talent guest user")
    public void validate_result_for_advance_search_for_packages_talent_user() {
        searchPage.validateAdvanceSearchResultsForPackagesTab();
    }

    @Given("User enter options for advance search for talent non sign user")
    public void user_enter_options_for_advance_search_for_talent_non_sign_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForTalentTabForNonSignUser(category, language, accent, gender, age, keyword);
    }
    @Then("Validate result for advance search for talent non sign user")
    public void validate_result_for_advance_search_for_talent_non_sign_user() {
        searchPage.validateAdvanceSearchResultsForTalentTab();
    }

    @Given("User enter options for advance search for talent client user")
    public void user_enter_options_for_advance_search_for_talent_client_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForTalentTabForSignUser(category, language, accent, gender, age, keyword);
    }
    @Then("Validate result for advance search for talent client user")
    public void validate_result_for_advance_search_for_talent_client_user() {
        searchPage.validateAdvanceSearchResultsForTalentTab();
    }

    @Given("User enter options for advance search for talent guest user")
    public void user_enter_options_for_advance_search_for_talent_guest_user(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String category = list.get(0).get("Category");
        String language = list.get(0).get("Language");
        String accent = list.get(0).get("Accent");
        String gender = list.get(0).get("Gender");
        String age = list.get(0).get("Age");
        String keyword = list.get(0).get("Keyword");
        searchPage.userSelectAdvanceSearchOptionsForTalentTabForSignUser(category, language, accent, gender, age, keyword);
    }
    @Then("Validate result for advance search for talent guest user")
    public void validate_result_for_advance_search_for_talent_guest_user() {
        searchPage.validateAdvanceSearchResultsForTalentTab();
    }


}
