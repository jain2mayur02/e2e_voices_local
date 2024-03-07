package com.voices.stepDefinition.SearchStepDef;

import com.voices.controlManager.TestContext;
import com.voices.pageObjects.SearchPageObj.SearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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


}
