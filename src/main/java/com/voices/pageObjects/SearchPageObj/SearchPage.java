package com.voices.pageObjects.SearchPageObj;

import com.voices.baseClass.BaseClass;
import com.voices.managers.ReaderManager;
import com.voices.pageObjects.HyperLinkPageObj.HyperLinkPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class SearchPage {

    private static WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='siteSearch-form-submitButton nav-main-form-btn-search']")
    private WebElement searchIcon;
    @FindBy(xpath = "//button[@id='category_ids-FiltersTrigger']")
    private WebElement categoryDropdown;
    @FindBy(xpath = "//div[@data-category='language_ids']//div[@role='combobox']")
    private WebElement languageDropdown;
    @FindBy(xpath = "//button[@id='category_ids-Apply']")
    private WebElement applyFilterButton;
    @FindBy(xpath = "//button[@id='voice_gender-Apply']")
    private WebElement genderApplyFilterButton;
    @FindBy(xpath = "//ul[@class='pagination']/li[2]/a")
    private WebElement pgination2;
    @FindBy(xpath = "//h2[@class='search-results-pagination-text']")
    private WebElement elementCount;
    @FindBy(xpath = "(//input[@placeholder='Search...'])[1]")
    private WebElement languageSearchField;
    @FindBy(xpath = "//div[@data-category='accent_id']")
    private WebElement accentDropdown;
    @FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
    private WebElement accentSearchField;
    @FindBy(xpath = "//button[@id='voice_gender-FiltersTrigger']")
    private WebElement genderDropdown;
    @FindBy(xpath = "//button[@id='voice_age_ids-FiltersTrigger']")
    private WebElement ageDropdown;
    @FindBy(xpath = "//button[@id='voice_age_ids-Apply']")
    private WebElement ageApplyFilterButton;
    @FindBy(xpath = "//button[@id='BudgetFiltersTrigger']")
    private WebElement priceDropdown;
    @FindBy(xpath = "//input[@id='budget_min']")
    private WebElement minimumPriceXp;
    @FindBy(xpath = "//input[@id='budget_max']")
    private WebElement maximumPriceXp;
    @FindBy(xpath = "//button[@id='BudgetApply']")
    private WebElement priceApplyFilterButton;
    @FindBy(xpath = "//label[@for='search-type-talent']")
    private WebElement talentTab;

    public void validateCategorySearchForNonSignUser(String tabName, String... categoryList) {
        for (String category : categoryList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, categoryDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(categoryDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, categoryDropdown);
            WebElement categoryElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + category + "']"));
            categoryElement.click();
            BaseClass.waitForVisibility(applyFilterButton, 30, SearchPage.driver);
            applyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> categoryTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (categoryTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", categoryTextEleList.size() == 0);
                continue;

            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate category count for first page", totalFirstPageCount, categoryTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate category count for first page", 24, categoryTextEleList.size());
            }

            for (WebElement categoryTextElement : categoryTextEleList) {
                Assert.assertTrue("Validate Category Text", categoryTextElement.getText().contains(category));
            }
            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> categoryTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                categoryTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                categoryTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate category gadget count for second page", totalSecondPageCount, categoryTextEleList2.size());
            } else {
                Assert.assertEquals("Validate category gadget count for second page", 24, categoryTextEleList2.size());
            }

            for (WebElement categoryTextElement : categoryTextEleList2) {
                Assert.assertTrue("Validate Category Text for second page", categoryTextElement.getText().contains(category));
            }

        }

    }

    public void validateLanguageSearchForNonSignUser(String tabName, String... languageList) {
        for (String language : languageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.staticWaitForVisibility(5000);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, languageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(languageDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, languageDropdown);
            BaseClass.waitForVisibility(languageSearchField, 30, SearchPage.driver);
            languageSearchField.sendKeys(language);
            BaseClass.staticWaitForVisibility(2000);
            WebElement languageElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + language + "'])[1]"));
            languageElement.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> languageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            List<WebElement> languageTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                languageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                languageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (languageTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", languageTextEleList.size() == 0);
                continue;

            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate language gadget count", totalFirstPageCount, languageTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate language gadget count", 24, languageTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> languageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> languageTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                languageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                languageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate language gadget count", totalSecondPageCount, languageTextEleList2.size());
            } else {
                Assert.assertEquals("Validate language gadget count", 24, languageTextEleList2.size());
            }

        }

    }

    public void validateAccentSearchForNonSignUser(String tabName, String... accentList) {
        for (String accent : accentList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.staticWaitForVisibility(5000);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, accentDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            accentDropdown.click();
            BaseClass.waitForVisibility(accentSearchField, 30, SearchPage.driver);
            accentSearchField.sendKeys(accent);
            BaseClass.staticWaitForVisibility(2000);
            WebElement accentElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + accent + "'])[1]"));
            accentElement.click();
            BaseClass.staticWaitForVisibility(3000);

            List<WebElement> accentTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (accentTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", accentTextEleList.size() == 0);
                continue;

            }

            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate accent first page gadget count", totalFirstPageCount, accentTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate accent first page gadget count", 24, accentTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> accentTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> accentTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                accentTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                accentTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate accent second page gadget count", totalSecondPageCount, accentTextEleList2.size());
            } else {
                Assert.assertEquals("Validate accent second page gadget count", 24, accentTextEleList2.size());
            }

        }

    }


    public void validateVoicesGenderSearchForNonSignUser(String tabName, String... genderList) {
        for (String gender : genderList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, genderDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(genderDropdown, 30, SearchPage.driver);
//            genderDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, genderDropdown);
            WebElement genderElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + gender + "']"));
            genderElement.click();
            BaseClass.waitForVisibility(genderApplyFilterButton, 30, SearchPage.driver);
            genderApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> genderTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> genderTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                genderTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                genderTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            if (genderTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", genderTextEleList.size() == 0);
                continue;

            }

            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate gender gadget count for first page", totalFirstPageCount, genderTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate gender gadget count for first page", 24, genderTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> genderTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> genderTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                genderTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                genderTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate gender gadget count for second page", totalSecondPageCount, genderTextEleList2.size());
            } else {
                Assert.assertEquals("Validate gender gadget count for second page", 24, genderTextEleList2.size());
            }

        }

    }


    public void validateVoicesAgeSearchForNonSignUser(String tabName, String... ageList) {
        for (String age : ageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, ageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(ageDropdown, 30, SearchPage.driver);
//            ageDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, ageDropdown);
            WebElement ageElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + age + "']"));
//            ageElement.click();
            BaseClass.javaScriptClick(SearchPage.driver, ageElement);
            BaseClass.waitForVisibility(ageApplyFilterButton, 30, SearchPage.driver);
            ageApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> ageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> ageTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                ageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                ageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (ageTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", ageTextEleList.size() == 0);
                continue;
            }

            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate age gadget count for first page", totalFirstPageCount, ageTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate age gadget count for first page", 24, ageTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> ageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> ageTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                ageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                ageTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate age gadget count for second page", totalSecondPageCount, ageTextEleList2.size());
            } else {
                Assert.assertEquals("Validate age gadget count for second page", 24, ageTextEleList2.size());
            }

        }

    }


    public void validateVoicesAgeSearchForNonSignUser(String minimumPrice, String maximumPrice) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.waitForVisibility(priceDropdown, 30, SearchPage.driver);
//        priceDropdown.click();
        BaseClass.javaScriptClick(SearchPage.driver, priceDropdown);
        BaseClass.waitForVisibility(minimumPriceXp, 30, SearchPage.driver);
        minimumPriceXp.sendKeys(minimumPrice);
        BaseClass.waitForVisibility(maximumPriceXp, 30, SearchPage.driver);
        maximumPriceXp.sendKeys(maximumPrice);
        BaseClass.waitForVisibility(priceApplyFilterButton, 30, SearchPage.driver);
        priceApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> priceTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userPrice']/span"));
        int minimum = Integer.parseInt(minimumPrice);
        int maximum = Integer.parseInt(maximumPrice);
        String[] countPage1 = elementCount.getText().split(" ");
        int totalCountPage1 = Integer.parseInt(countPage1[3]);
        int totalFirstPageCount = 0;
        if (totalCountPage1 < 24) {
            totalFirstPageCount = totalCountPage1;
            Assert.assertEquals("Validate price gadget count for first page", totalFirstPageCount, priceTextEleList.size());
        } else {
            Assert.assertEquals("Validate price gadget count for first page", 24, priceTextEleList.size());
        }

        for (WebElement priceTextElement : priceTextEleList) {
            int price = Integer.parseInt(priceTextElement.getText().substring(1));
            Assert.assertTrue("Validate Gadget price", (minimum <= price) && (price <= maximum));
        }

        BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
        BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, pgination2);
        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> priceTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userPrice']/span"));
        String[] countPage2 = elementCount.getText().split(" ");
        int totalCountPage2 = Integer.parseInt(countPage2[3]);
        int totalSecondPageCount = 0;
        if (totalCountPage2 < 48) {
            totalSecondPageCount = totalCountPage2 - 24;
            Assert.assertEquals("Validate price gadget count for second page", totalSecondPageCount, priceTextEleList2.size());
        } else {
            Assert.assertEquals("Validate price gadget count for second page", 24, priceTextEleList2.size());
        }
        for (WebElement priceTextElement : priceTextEleList2) {
            int price = Integer.parseInt(priceTextElement.getText().substring(1));
            Assert.assertTrue("Validate Gadget price", (minimum <= price) && (price <= maximum));
        }

    }

    @FindBy(xpath = "//button[@id='delivery_time-FiltersTrigger']")
    private WebElement deliveryTimeDropdown;
    @FindBy(xpath = "//button[@id='delivery_time-Apply']")
    private WebElement deliveryTimeApplyFilterButton;
    @FindBy(xpath = "//button[normalize-space()='Show More']")
    private WebElement showMoreLink;

    public void validateVoicesDeliveryTimeSearchForNonSignUser(String... deliveryTimeList) {
        for (String deliveryTime : deliveryTimeList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            BaseClass.waitForVisibility(deliveryTimeDropdown, 30, SearchPage.driver);
//            deliveryTimeDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, deliveryTimeDropdown);
            WebElement deliveryTimeElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + deliveryTime + "']"));
            deliveryTimeElement.click();
            BaseClass.waitForVisibility(deliveryTimeApplyFilterButton, 30, SearchPage.driver);
            deliveryTimeApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> deliveryTimeTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            if (deliveryTimeTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", deliveryTimeTextEleList.size() == 0);
                continue;
            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate delivery time gadget count for first page", totalFirstPageCount, deliveryTimeTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate delivery time gadget count for first page", 24, deliveryTimeTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> deliveryTimeTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate delivery time gadget count for second page", totalSecondPageCount, deliveryTimeTextEleList2.size());
            } else {
                Assert.assertEquals("Validate delivery time gadget count for second page", 24, deliveryTimeTextEleList2.size());
            }

        }

    }

    @FindBy(xpath = "//button[@id='achievement_ids-FiltersTrigger']")
    private WebElement talentTierDropdown;
    @FindBy(xpath = "//button[@id='achievement_ids-Apply']")
    private WebElement talentTierApplyFilterButton;


    @FindBy(xpath = "//button[@id='recently_online-FiltersTrigger']")
    private WebElement onlineStatusDropdown;
    @FindBy(xpath = "//button[@id='recently_online-Apply']")
    private WebElement onlineStatusApplyFilterButton;


    @FindBy(xpath = "//input[@aria-label='Select a country']")
    private WebElement countrySearchField;
    @FindBy(xpath = "//button[@id='location-FiltersTrigger']")
    private WebElement locationDropdown;
    @FindBy(xpath = "//div[@id='location-Filters']//div[@role='combobox']//div[@class='choices__inner']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//div[@role='listbox']//div[@class='choices__inner']")
    private WebElement stateDropdown;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityTextField;
    @FindBy(xpath = "//button[@id='location-Apply']")
    private WebElement locationApplyFilterButton;


    @FindBy(xpath = "//div[@data-category='role_ids']//div[@role='combobox']")
    private WebElement roleDropdown;
    @FindBy(xpath = "//div[@data-category='role_ids']//input[@placeholder='Search...']")
    private WebElement roleSearchField;
    @FindBy(xpath = "//label[@for='search-type-projects']")
    private WebElement packageTab;

    public void validateRoleSearchForNonSignUser(String tabName, String... roleList) {
        for (String role : roleList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(7000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, roleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(7000);
            }


            BaseClass.waitForVisibility(roleDropdown, 30, SearchPage.driver);
//            roleDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, roleDropdown);
            BaseClass.waitForVisibility(roleSearchField, 30, SearchPage.driver);
            roleSearchField.sendKeys(role);
            BaseClass.staticWaitForVisibility(2000);
            WebElement roleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + role + "'])[1]"));
            roleElement.click();
            BaseClass.staticWaitForVisibility(3000);

            List<WebElement> roleTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                roleTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                roleTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (roleTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", roleTextEleList.size() == 0);
                continue;
            }

            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate role first page gadget count", totalFirstPageCount, roleTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate role first page gadget count", 24, roleTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> accentTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> roleTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                roleTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                roleTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate role second page gadget count", totalSecondPageCount, roleTextEleList2.size());
            } else {
                Assert.assertEquals("Validate role second page gadget count", 24, roleTextEleList2.size());
            }

        }
    }

    @FindBy(xpath = "//div[@data-category='style_ids']//div[@role='combobox']")
    private WebElement styleDropdown;
    @FindBy(xpath = "(//input[@placeholder='Search...'])[4]")
    private WebElement styleSearchField;


    public void validateStyleSearchForNonSignUser(String tabName, String... styleList) {
        for (String style : styleList) {
            System.out.println(style);
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
            if (!BaseClass.isElementPresent(SearchPage.driver, styleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
//                BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
//                BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
            }

            BaseClass.waitForVisibility(styleDropdown, 30, SearchPage.driver);
//            styleDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, styleDropdown);
            BaseClass.waitForVisibility(styleSearchField, 30, SearchPage.driver);
            styleSearchField.sendKeys(style);
            BaseClass.staticWaitForVisibility(2000);
            WebElement styleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + style + "'])[1]"));
            styleElement.click();
            BaseClass.staticWaitForVisibility(3000);

            List<WebElement> styleTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                styleTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                styleTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (styleTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", styleTextEleList.size() == 0);
                continue;
            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate style first page gadget count", totalFirstPageCount, styleTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate style first page gadget count", 24, styleTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> accentTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> styleTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                styleTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                styleTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate style second page gadget count", totalSecondPageCount, styleTextEleList2.size());
            } else {
                Assert.assertEquals("Validate style second page gadget count", 24, styleTextEleList2.size());
            }

        }
    }

    public void validateVoicesTalentTierTimeSearchForNonSignUser(String tabName, String... talentTierList) {
        for (String talentTier : talentTierList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.staticWaitForVisibility(5000);
                talentTab.click();
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
            if (!BaseClass.isElementPresent(SearchPage.driver, talentTierDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.staticWaitForVisibility(3000);
            BaseClass.javaScriptClick(SearchPage.driver, talentTierDropdown);
            WebElement talentTierElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + talentTier + "']"));
//            talentTierElement.click();
            BaseClass.javaScriptClick(SearchPage.driver, talentTierElement);
            BaseClass.waitForVisibility(talentTierApplyFilterButton, 30, SearchPage.driver);
            talentTierApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> talentTierTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> talentTierTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                talentTierTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                talentTierTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (talentTierTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", talentTierTextEleList.size() == 0);
                continue;
            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate talent tier gadget count for first page", totalFirstPageCount, talentTierTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate talent tier gadget count for first page", 24, talentTierTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> talentTierTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            List<WebElement> talentTierTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                talentTierTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                talentTierTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate talent tier gadget count for second page", totalSecondPageCount, talentTierTextEleList2.size());
            } else {
                Assert.assertEquals("Validate talent tier gadget count for second page", 24, talentTierTextEleList2.size());
            }

        }

    }

    public void validateVoicesOnlineStatusSearchForNonSignUser(String tabName, String... onlineStatusList) {
        for (String onlineStatus : onlineStatusList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
//            showMoreLink.click();
            BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
            if (!BaseClass.isElementPresent(SearchPage.driver, talentTierDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.staticWaitForVisibility(3000);
//            onlineStatusDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, onlineStatusDropdown);
            WebElement onlineStatusElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + onlineStatus + "']"));
//            onlineStatusElement.click();
            BaseClass.javaScriptClick(SearchPage.driver, onlineStatusElement);
            BaseClass.waitForVisibility(onlineStatusApplyFilterButton, 30, SearchPage.driver);
            onlineStatusApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> onlineStatusTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> onlineStatusTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                onlineStatusTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                onlineStatusTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (onlineStatusTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", onlineStatusTextEleList.size() == 0);
                continue;
            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate online status gadget count for first page", totalFirstPageCount, onlineStatusTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate online status gadget count for first page", 24, onlineStatusTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> onlineStatusTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> onlineStatusTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                onlineStatusTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                onlineStatusTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }

            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate online status gadget count for second page", totalSecondPageCount, onlineStatusTextEleList2.size());
            } else {
                Assert.assertEquals("Validate online status gadget count for second page", 24, onlineStatusTextEleList2.size());
            }

        }

    }

    public void validateVoicesLocationSearchForNonSignUser(String tabName, String country, String state, String city) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (tabName.equalsIgnoreCase("Talent")) {
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(5000);
        }
        BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
//        showMoreLink.click();
        BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
        if (!BaseClass.isElementPresent(SearchPage.driver, locationDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(locationDropdown, 30, SearchPage.driver);
//        locationDropdown.click();
        BaseClass.javaScriptClick(SearchPage.driver, locationDropdown);
        BaseClass.waitForVisibility(countryDropdown, 30, SearchPage.driver);
        countryDropdown.click();
        BaseClass.waitForVisibility(countrySearchField, 30, SearchPage.driver);
        countrySearchField.sendKeys(country);
        BaseClass.staticWaitForVisibility(2000);
        SearchPage.driver.findElement(By.xpath("//div[text()='" + country + "']")).click();
//        BaseClass.staticWaitForVisibility(3000);
//        BaseClass.waitForVisibility(stateDropdown, 30, SearchPage.driver);
//        stateDropdown.click();
//        WebElement stateElement = SearchPage.driver.findElement(By.xpath("//div[text()='" + state + "']"));
//        BaseClass.waitForVisibility(stateElement, 30, SearchPage.driver);
//        BaseClass.javaScriptClick(SearchPage.driver, stateElement);
//        BaseClass.staticWaitForVisibility(3000);
//        cityTextField.sendKeys(city);

        BaseClass.waitForVisibility(locationApplyFilterButton, 30, SearchPage.driver);
        locationApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
//        List<WebElement> locationTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

        List<WebElement> locationTextEleList = null;
        if (tabName.equalsIgnoreCase("Packages")) {
            locationTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
        } else if (tabName.equalsIgnoreCase("Talent")) {
            locationTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
        }
        String[] countPage1 = elementCount.getText().split(" ");
        int totalCountPage1 = Integer.parseInt(countPage1[3]);
        int totalFirstPageCount = 0;
        if (totalCountPage1 < 24) {
            totalFirstPageCount = totalCountPage1;
            Assert.assertEquals("Validate location gadget count for first page", totalFirstPageCount, locationTextEleList.size());
        } else {
            Assert.assertEquals("Validate location gadget count for first page", 24, locationTextEleList.size());
        }

        BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
        BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, pgination2);
        BaseClass.staticWaitForVisibility(3000);
//        List<WebElement> locationTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

        List<WebElement> locationTextEleList2 = null;
        if (tabName.equalsIgnoreCase("Packages")) {
            locationTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
        } else if (tabName.equalsIgnoreCase("Talent")) {
            locationTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
        }
        String[] countPage2 = elementCount.getText().split(" ");
        int totalCountPage2 = Integer.parseInt(countPage2[3]);
        int totalSecondPageCount = 0;
        if (totalCountPage2 < 48) {
            totalSecondPageCount = totalCountPage2 - 24;
            Assert.assertEquals("Validate location gadget count for second page", totalSecondPageCount, locationTextEleList2.size());
        } else {
            Assert.assertEquals("Validate location gadget count for second page", 24, locationTextEleList2.size());
        }

    }

    @FindBy(xpath = "//button[@id='directed_session_ids-FiltersTrigger']")
    private WebElement LiveDirDropdown;
    @FindBy(xpath = "//button[@id='directed_session_ids-Apply']")
    private WebElement liveApplyFilterButton;

    public void validateLiveDirectedSessionSearchForNonSignUser(String tabName, String... liveDirList) {
        for (String liveDir : liveDirList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, roleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(LiveDirDropdown, 30, SearchPage.driver);
            LiveDirDropdown.click();
            WebElement liveDirElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + liveDir + "']"));
            liveDirElement.click();
            BaseClass.waitForVisibility(liveApplyFilterButton, 30, SearchPage.driver);
            liveApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> liveDirTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                liveDirTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                liveDirTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            if (liveDirTextEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", liveDirTextEleList.size() == 0);
                continue;
            }
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate Live Directed Session gadget count for first page", totalFirstPageCount, liveDirTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate Live Directed Session gadget count for first page", 24, liveDirTextEleList.size());
            }

            BaseClass.scrollUpToBottomOfPage(SearchPage.driver);
            BaseClass.waitForVisibility(pgination2, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, pgination2);
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> liveDirTextEleList2 = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                liveDirTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                liveDirTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
            }
            String[] countPage2 = elementCount.getText().split(" ");
            int totalCountPage2 = Integer.parseInt(countPage2[3]);
            int totalSecondPageCount = 0;
            if (totalCountPage2 < 48) {
                totalSecondPageCount = totalCountPage2 - 24;
                Assert.assertEquals("Validate Live Directed Session gadget count for second page", totalSecondPageCount, liveDirTextEleList2.size());
            } else {
                Assert.assertEquals("Validate Live Directed Session gadget count for second page", 24, liveDirTextEleList2.size());
            }


        }

    }

    public void validateCategoryPlayDemoForNonSignUser(String tabName, String... categoryList) {
        for (String category : categoryList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
//                talentTab.click();
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, categoryDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(categoryDropdown, 30, SearchPage.driver);
            categoryDropdown.click();
            WebElement categoryElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + category + "']"));
            categoryElement.click();
            BaseClass.waitForVisibility(applyFilterButton, 30, SearchPage.driver);
            applyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> categoryPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (categoryPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", categoryPlayDemoEleList.size() == 0);
                continue;
            }

            for (WebElement categoryPlayDemoElement : categoryPlayDemoEleList) {
                Assert.assertTrue("Validate Category Text", categoryPlayDemoElement.isEnabled());
            }

        }

    }

    public void validateLanguagePlayDemoForNonSignUser(String tabName, String... languageList) {
        for (String language : languageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, languageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(languageDropdown, 30, SearchPage.driver);
//            languageDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, languageDropdown);
            BaseClass.waitForVisibility(languageSearchField, 30, SearchPage.driver);
            languageSearchField.sendKeys(language);
            BaseClass.staticWaitForVisibility(2000);
            WebElement languageElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + language + "'])[1]"));
            languageElement.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> languageTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            List<WebElement> languagePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (languagePlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", languagePlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement languagePlayDemoElement : languagePlayDemoEleList) {
                Assert.assertTrue("Validate Play demo button for language dropdown", languagePlayDemoElement.isEnabled());
            }
        }
    }

    public void validateAccentPlayDemoForNonSignUser(String tabName, String... accentList) {
        for (String accent : accentList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, accentDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.staticWaitForVisibility(5000);
            accentDropdown.click();
//            BaseClass.javaScriptClick(SearchPage.driver, accentDropdown);
            BaseClass.waitForVisibility(accentSearchField, 30, SearchPage.driver);
            accentSearchField.sendKeys(accent);
            BaseClass.staticWaitForVisibility(2000);
            WebElement accentElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + accent + "'])[1]"));
            accentElement.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> accentPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (accentPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", accentPlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement accentPlayDemoElement : accentPlayDemoEleList) {
                Assert.assertTrue("Validate accent play demo button", accentPlayDemoElement.isEnabled());
            }

        }

    }

    public void validateVoicesGenderPlayDemoForNonSignUser(String tabName, String... genderList) {
        for (String gender : genderList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, genderDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(genderDropdown, 30, SearchPage.driver);
//            genderDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, genderDropdown);
            WebElement genderElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + gender + "']"));
            genderElement.click();
            BaseClass.waitForVisibility(genderApplyFilterButton, 30, SearchPage.driver);
            genderApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> genderPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));

            if (genderPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", genderPlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement genderPlayDemoElement : genderPlayDemoEleList) {
                Assert.assertTrue("Validate Play Demo button for gender dropdown", genderPlayDemoElement.isEnabled());
            }
        }
    }

    public void validateVoicesAgePlayDemoForNonSignUser(String tabName, String... ageList) {
        for (String age : ageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
//                talentTab.click();
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, ageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(ageDropdown, 30, SearchPage.driver);
//            ageDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, ageDropdown);
            WebElement ageElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + age + "']"));
            ageElement.click();
            BaseClass.waitForVisibility(ageApplyFilterButton, 30, SearchPage.driver);
            ageApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> agePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (agePlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", agePlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement agePlayDemoElement : agePlayDemoEleList) {
                Assert.assertTrue("Validate Age Play Demo button", agePlayDemoElement.isEnabled());
            }

        }
    }

    public void validateVoicesPricePlayDemoForNonSignUser(String minimumPrice, String maximumPrice) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (!BaseClass.isElementPresent(SearchPage.driver, priceDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(priceDropdown, 30, SearchPage.driver);
//        priceDropdown.click();
        BaseClass.javaScriptClick(SearchPage.driver, priceDropdown);
        BaseClass.waitForVisibility(minimumPriceXp, 30, SearchPage.driver);
        minimumPriceXp.sendKeys(minimumPrice);
        BaseClass.waitForVisibility(maximumPriceXp, 30, SearchPage.driver);
        maximumPriceXp.sendKeys(maximumPrice);
        BaseClass.waitForVisibility(priceApplyFilterButton, 30, SearchPage.driver);
        priceApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> pricePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
        for (WebElement pricePlayDemoElement : pricePlayDemoEleList) {
            Assert.assertTrue("Validate paly demo button for price dropdown", pricePlayDemoElement.isEnabled());
        }

    }

    public void validateVoicesDeliveryTimePlayDemoForNonSignUser(String... deliveryTimeList) {
        for (String deliveryTime : deliveryTimeList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, deliveryTimeDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(deliveryTimeDropdown, 30, SearchPage.driver);
//            deliveryTimeDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, deliveryTimeDropdown);
            WebElement deliveryTimeElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + deliveryTime + "']"));
//            deliveryTimeElement.click();
            BaseClass.javaScriptClick(SearchPage.driver, deliveryTimeElement);
            BaseClass.waitForVisibility(deliveryTimeApplyFilterButton, 30, SearchPage.driver);
            deliveryTimeApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> deliveryTimePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (deliveryTimePlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", deliveryTimePlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement deliveryTimePlayDemoElement : deliveryTimePlayDemoEleList) {
                Assert.assertTrue("Validate Play demo button for delivery time dropdown", deliveryTimePlayDemoElement.isEnabled());
            }
        }
    }

    public void validateVoicesTalentTierTimePlayDemoForNonSignUser(String tabName, String... talentTierList) {
        for (String talentTier : talentTierList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.staticWaitForVisibility(3000);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, talentTierDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(talentTierDropdown, 30, SearchPage.driver);
//            talentTierDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, talentTierDropdown);
            WebElement talentTierElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + talentTier + "']"));
            talentTierElement.click();
            BaseClass.waitForVisibility(talentTierApplyFilterButton, 30, SearchPage.driver);
            talentTierApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> talentTierPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (talentTierPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", talentTierPlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement talentTierPlayDemoElement : talentTierPlayDemoEleList) {
                Assert.assertTrue("Validate Play demo button for Talent tier dropdown", talentTierPlayDemoElement.isEnabled());
            }
        }
    }

    public void validateVoicesOnlineStatusPlayDemoForNonSignUser(String tabName, String... onlineStatusList) {
        for (String onlineStatus : onlineStatusList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, onlineStatusDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(onlineStatusDropdown, 30, SearchPage.driver);
//            onlineStatusDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, onlineStatusDropdown);
            WebElement onlineStatusElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + onlineStatus + "']"));
            onlineStatusElement.click();
            BaseClass.waitForVisibility(onlineStatusApplyFilterButton, 30, SearchPage.driver);
            onlineStatusApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> onlineStatusPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (onlineStatusPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", onlineStatusPlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement onlineStatusPlayDemoElement : onlineStatusPlayDemoEleList) {
                Assert.assertTrue("Validate Play Button for Online Status Dropdown", onlineStatusPlayDemoElement.isEnabled());
            }
        }
    }

    public void validateVoicesLocationPlayDemoForNonSignUser(String tabName, String country, String state, String city) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (tabName.equalsIgnoreCase("Talent")) {
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(5000);
        }
        BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
        showMoreLink.click();
        if (!BaseClass.isElementPresent(SearchPage.driver, locationDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(locationDropdown, 30, SearchPage.driver);
//        locationDropdown.click();
        BaseClass.javaScriptClick(SearchPage.driver, locationDropdown);
        BaseClass.waitForVisibility(countryDropdown, 30, SearchPage.driver);
        countryDropdown.click();
        BaseClass.waitForVisibility(countrySearchField, 30, SearchPage.driver);
        countrySearchField.sendKeys(country);
        BaseClass.staticWaitForVisibility(2000);
        SearchPage.driver.findElement(By.xpath("//div[text()='" + country + "']")).click();
//        BaseClass.staticWaitForVisibility(3000);
//        BaseClass.waitForVisibility(stateDropdown, 30, SearchPage.driver);
//        stateDropdown.click();
//        WebElement stateElement = SearchPage.driver.findElement(By.xpath("//div[text()='" + state + "']"));
//        BaseClass.waitForVisibility(stateElement, 30, SearchPage.driver);
//        BaseClass.javaScriptClick(SearchPage.driver, stateElement);
//        BaseClass.staticWaitForVisibility(3000);
//        cityTextField.sendKeys(city);

        BaseClass.waitForVisibility(locationApplyFilterButton, 30, SearchPage.driver);
        locationApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> locationPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
        for (WebElement locationPlayDemoElement : locationPlayDemoEleList) {
            Assert.assertTrue("Validate play demo button for location dropdown", locationPlayDemoElement.isEnabled());
        }

    }

    public void validateRolePlayDemoForNonSignUser(String tabName, String... roleList) {
        for (String role : roleList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, roleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(roleDropdown, 30, SearchPage.driver);
//            roleDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, roleDropdown);
            BaseClass.waitForVisibility(roleSearchField, 30, SearchPage.driver);
            roleSearchField.sendKeys(role);
            BaseClass.staticWaitForVisibility(2000);
            WebElement roleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + role + "'])[1]"));
            roleElement.click();
            BaseClass.staticWaitForVisibility(3000);

            List<WebElement> rolePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (rolePlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", rolePlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement rolePlayDemoElement : rolePlayDemoEleList) {
                Assert.assertTrue("Validate play demo button for role dropdown", rolePlayDemoElement.isEnabled());
            }
        }
    }

    public void validateStylePlayDemoForNonSignUser(String tabName, String... styleList) {
        for (String style : styleList) {
            System.out.println(style);
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, styleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(styleDropdown, 30, SearchPage.driver);
//            styleDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, styleDropdown);
            BaseClass.waitForVisibility(styleSearchField, 30, SearchPage.driver);
            styleSearchField.sendKeys(style);
            BaseClass.staticWaitForVisibility(2000);
            WebElement styleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + style + "'])[1]"));
            styleElement.click();
            BaseClass.staticWaitForVisibility(3000);

            List<WebElement> stylePlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (stylePlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", stylePlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement stylePlayDemoElement : stylePlayDemoEleList) {
                Assert.assertTrue("Validate play demo button for style dropdown", stylePlayDemoElement.isEnabled());
            }

        }
    }

    public void validateLiveDirectedSessionPlayDemoForNonSignUser(String tabName, String... liveDirList) {
        for (String liveDir : liveDirList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, LiveDirDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(LiveDirDropdown, 30, SearchPage.driver);
//            LiveDirDropdown.click();
            BaseClass.javaScriptClick(SearchPage.driver, LiveDirDropdown);
            WebElement liveDirElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + liveDir + "']"));
            liveDirElement.click();
            BaseClass.waitForVisibility(liveApplyFilterButton, 30, SearchPage.driver);
            liveApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> liveDirPlayDemoEleList = SearchPage.driver.findElements(By.xpath("//div[@class='play-pause-btn']"));
            if (liveDirPlayDemoEleList.isEmpty()) {
                Assert.assertTrue("Zero record found", liveDirPlayDemoEleList.size() == 0);
                continue;
            }
            for (WebElement liveDriPlayDemoElement : liveDirPlayDemoEleList) {
                Assert.assertTrue("Validate play demo button for live directed session dropdown", liveDriPlayDemoElement.isEnabled());
            }
        }
    }

    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[1]/span[1]")
    private WebElement firstFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[2]/span[1]")
    private WebElement secondFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[3]/span[1]")
    private WebElement thirdFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[4]/span[1]")
    private WebElement fourthFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[5]/span[1]")
    private WebElement fifthFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[6]/span[1]")
    private WebElement sixthFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[7]/span[1]")
    private WebElement seventhFilterText;
    @FindBy(xpath = "//ul[@id='SearchFilter-chips']/li[8]/span[1]")
    private WebElement eighthFilterText;
    @FindBy(xpath = "//button[normalize-space()='Clear filters']")
    private WebElement clearFilterButton;

    public void validateCategoryClearForNonSignUser(String tabName, String... categoryList) {
        for (String category : categoryList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, categoryDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(categoryDropdown, 30, SearchPage.driver);
            categoryDropdown.click();
            WebElement categoryElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + category + "']"));
            categoryElement.click();
            BaseClass.waitForVisibility(applyFilterButton, 30, SearchPage.driver);
            applyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", category, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

        }

    }

    public void validateLanguageClearForNonSignUser(String tabName, String... languageList) {
        for (String language : languageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, languageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(languageDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, languageDropdown);
            BaseClass.waitForVisibility(languageSearchField, 30, SearchPage.driver);
            languageSearchField.sendKeys(language);
            BaseClass.staticWaitForVisibility(2000);
            WebElement languageElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + language + "'])[1]"));
            BaseClass.waitForVisibility(languageElement, 30, SearchPage.driver);
            languageElement.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", language, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

        }
    }

    public void validateAccentClearForNonSignUser(String tabName, String... accentList) {
        for (String accent : accentList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, accentDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.staticWaitForVisibility(5000);
            accentDropdown.click();
            BaseClass.waitForVisibility(accentSearchField, 30, SearchPage.driver);
            accentSearchField.sendKeys(accent);
            BaseClass.staticWaitForVisibility(2000);
            WebElement accentElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + accent + "'])[1]"));
            accentElement.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", accent, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

        }

    }

    public void validateVoicesGenderClearForNonSignUser(String tabName, String... genderList) {
        for (String gender : genderList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, genderDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(genderDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, genderDropdown);
            WebElement genderElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + gender + "']"));
            genderElement.click();
            BaseClass.waitForVisibility(genderApplyFilterButton, 30, SearchPage.driver);
            genderApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", gender, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        }
    }

    public void validateVoicesAgeClearForNonSignUser(String tabName, String... ageList) {
        for (String age : ageList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, ageDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(ageDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, ageDropdown);
            WebElement ageElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + age + "']"));
            BaseClass.waitForVisibility(ageElement, 30, SearchPage.driver);
            ageElement.click();
            BaseClass.waitForVisibility(ageApplyFilterButton, 30, SearchPage.driver);
            ageApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", age, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        }
    }

    public void validateVoicesPriceClearForNonSignUser(String minimumPrice, String maximumPrice) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (!BaseClass.isElementPresent(SearchPage.driver, priceDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(priceDropdown, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, priceDropdown);
        BaseClass.waitForVisibility(minimumPriceXp, 30, SearchPage.driver);
        minimumPriceXp.sendKeys(minimumPrice);
        BaseClass.waitForVisibility(maximumPriceXp, 30, SearchPage.driver);
        maximumPriceXp.sendKeys(maximumPrice);
        BaseClass.waitForVisibility(priceApplyFilterButton, 30, SearchPage.driver);
        priceApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertTrue("Validate Filter text", firstFilterText.getText().trim().contains(minimumPrice));
        Assert.assertTrue("Validate Filter text", secondFilterText.getText().trim().contains(maximumPrice));
        clearFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));

    }

    public void validateVoicesDeliveryTimeClearForNonSignUser(String... deliveryTimeList) {
        for (String deliveryTime : deliveryTimeList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, deliveryTimeDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(deliveryTimeDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, deliveryTimeDropdown);
            WebElement deliveryTimeElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + deliveryTime + "']"));
            BaseClass.javaScriptClick(SearchPage.driver, deliveryTimeElement);
            BaseClass.waitForVisibility(deliveryTimeApplyFilterButton, 30, SearchPage.driver);
            deliveryTimeApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", deliveryTime, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        }
    }

    public void validateVoicesTalentTierTimeClearForNonSignUser(String tabName, String... talentTierList) {
        for (String talentTier : talentTierList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.staticWaitForVisibility(3000);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, talentTierDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(talentTierDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTierDropdown);
            WebElement talentTierElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + talentTier + "']"));
            talentTierElement.click();
            BaseClass.waitForVisibility(talentTierApplyFilterButton, 30, SearchPage.driver);
            talentTierApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", talentTier, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        }
    }

    public void validateVoicesOnlineStatusClearForNonSignUser(String tabName, String... onlineStatusList) {
        for (String onlineStatus : onlineStatusList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, onlineStatusDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(onlineStatusDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, onlineStatusDropdown);
            WebElement onlineStatusElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + onlineStatus + "']"));
            onlineStatusElement.click();
            BaseClass.waitForVisibility(onlineStatusApplyFilterButton, 30, SearchPage.driver);
            onlineStatusApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", onlineStatus, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        }
    }

    public void validateVoicesLocationClearForNonSignUser(String tabName, String country, String state, String city) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (tabName.equalsIgnoreCase("Talent")) {
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(5000);
        }
        BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
//        showMoreLink.click();
        BaseClass.javaScriptClick(SearchPage.driver, showMoreLink);
        if (!BaseClass.isElementPresent(SearchPage.driver, locationDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(locationDropdown, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, locationDropdown);
        BaseClass.waitForVisibility(countryDropdown, 30, SearchPage.driver);
        countryDropdown.click();
        BaseClass.waitForVisibility(countrySearchField, 30, SearchPage.driver);
        countrySearchField.sendKeys(country);
        BaseClass.staticWaitForVisibility(2000);
        SearchPage.driver.findElement(By.xpath("//div[text()='" + country + "']")).click();
//        BaseClass.staticWaitForVisibility(3000);
//        BaseClass.waitForVisibility(stateDropdown, 30, SearchPage.driver);
//        stateDropdown.click();
//        WebElement stateElement = SearchPage.driver.findElement(By.xpath("//div[text()='" + state + "']"));
//        BaseClass.waitForVisibility(stateElement, 30, SearchPage.driver);
//        BaseClass.javaScriptClick(SearchPage.driver, stateElement);
//        BaseClass.staticWaitForVisibility(3000);
//        cityTextField.sendKeys(city);

        BaseClass.waitForVisibility(locationApplyFilterButton, 30, SearchPage.driver);
        locationApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertEquals("Validate Filter text", country, firstFilterText.getText().trim());
        clearFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

    }

    public void validateRoleClearForNonSignUser(String tabName, String... roleList) {
        for (String role : roleList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            if (!BaseClass.isElementPresent(SearchPage.driver, roleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(roleDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, roleDropdown);
            BaseClass.waitForVisibility(roleSearchField, 30, SearchPage.driver);
            roleSearchField.sendKeys(role);
            BaseClass.staticWaitForVisibility(2000);
            WebElement roleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + role + "'])[1]"));
            roleElement.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", role, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

        }
    }

    public void validateStyleClearForNonSignUser(String tabName, String... styleList) {
        for (String style : styleList) {
            System.out.println(style);
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, styleDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(styleDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, styleDropdown);
            BaseClass.waitForVisibility(styleSearchField, 30, SearchPage.driver);
            styleSearchField.sendKeys(style);
            BaseClass.staticWaitForVisibility(2000);
            WebElement styleElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + style + "'])[1]"));
            styleElement.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", style, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));


        }
    }

    public void validateLiveDirectedSessionClearForNonSignUser(String tabName, String... liveDirList) {
        for (String liveDir : liveDirList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            if (tabName.equalsIgnoreCase("Talent")) {
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            if (!BaseClass.isElementPresent(SearchPage.driver, LiveDirDropdown)) {
                packageTab.click();
                BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
                BaseClass.javaScriptClick(SearchPage.driver, talentTab);
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(LiveDirDropdown, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, LiveDirDropdown);
            WebElement liveDirElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + liveDir + "']"));
            liveDirElement.click();
            BaseClass.waitForVisibility(liveApplyFilterButton, 30, SearchPage.driver);
            liveApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertEquals("Validate Filter text", liveDir, firstFilterText.getText().trim());
            clearFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));

        }
    }

    @FindBy(xpath = "//span[@class='d-flex align-items-center']/h1")
    private WebElement profileName;

    public void validateProfileNameForPackageTab() {
        for (int i = 0; i <= 3; i++) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            BaseClass.staticWaitForVisibility(5000);
            String parentWindow = SearchPage.driver.getWindowHandle();
            List<WebElement> elementList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userInfoName-project']/a"));
            String frontPageName = elementList.get(i).getText().trim();
            elementList.get(i).click();
            Set<String> allWindow = SearchPage.driver.getWindowHandles();
            for (String childWindow : allWindow) {
                if (!childWindow.equalsIgnoreCase(parentWindow)) {
                    SearchPage.driver.switchTo().window(childWindow);
                    String subPageName = profileName.getText().trim();
                    Assert.assertEquals("Validate Gadget Name", frontPageName, subPageName);
                    SearchPage.driver.close();
                }
            }
            SearchPage.driver.switchTo().window(parentWindow);
        }

    }

    public void validateProfileNameForTalentTab() {
        for (int i = 0; i <= 3; i++) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();

            BaseClass.staticWaitForVisibility(5000);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(5000);

            String parentWindow = SearchPage.driver.getWindowHandle();
            List<WebElement> elementList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userInfo portfolio-list-item-talent-name']/a"));
            String frontPageName = elementList.get(i).getText().trim();
            elementList.get(i).click();
            Set<String> allWindow = SearchPage.driver.getWindowHandles();
            for (String childWindow : allWindow) {
                if (!childWindow.equalsIgnoreCase(parentWindow)) {
                    SearchPage.driver.switchTo().window(childWindow);
                    String subPageName = profileName.getText().trim();
                    Assert.assertEquals("Validate Profile Name", frontPageName, subPageName);
                    SearchPage.driver.close();
                }
            }
            SearchPage.driver.switchTo().window(parentWindow);

        }

    }

    @FindBy(xpath = "//div[@class='aggregated-star-rating']")
    private WebElement rating;

    public void validateStarRatingForPackageTab() {
        for (int i = 0; i <= 3; i++) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            BaseClass.staticWaitForVisibility(5000);
            String parentWindow = SearchPage.driver.getWindowHandle();
            List<WebElement> elementNameList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userInfoName-project']/a"));
            List<WebElement> elementRatingList = SearchPage.driver.findElements(By.xpath("//div[@class='stars-text']/span[1]"));
            String frontPageRating = elementRatingList.get(i).getText().trim();
            elementNameList.get(i).click();
            Set<String> allWindow = SearchPage.driver.getWindowHandles();
            for (String childWindow : allWindow) {
                if (!childWindow.equalsIgnoreCase(parentWindow)) {
                    SearchPage.driver.switchTo().window(childWindow);
                    BaseClass.scrollToElement(SearchPage.driver, rating);
                    BaseClass.staticWaitForVisibility(3000);
                    String subPageRating = rating.getText().trim();
                    Assert.assertEquals("Validate Gadget Star Rating", frontPageRating, subPageRating);
                    SearchPage.driver.close();
                }
            }
            SearchPage.driver.switchTo().window(parentWindow);
        }

    }

    public void validateStarRatingForTalentTab() {
        for (int i = 0; i <= 3; i++) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();

            BaseClass.staticWaitForVisibility(5000);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(5000);

            String parentWindow = SearchPage.driver.getWindowHandle();
            List<WebElement> elementNameList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-userInfo portfolio-list-item-talent-name']/a"));
            List<WebElement> elementRatingList = SearchPage.driver.findElements(By.xpath("//div[@class='stars-text']/span[1]"));
            String frontPageRating = elementRatingList.get(i).getText().trim();
            elementNameList.get(i).click();
            Set<String> allWindow = SearchPage.driver.getWindowHandles();
            for (String childWindow : allWindow) {
                if (!childWindow.equalsIgnoreCase(parentWindow)) {
                    SearchPage.driver.switchTo().window(childWindow);
                    BaseClass.scrollToElement(SearchPage.driver, rating);
                    BaseClass.staticWaitForVisibility(3000);
                    String subPageRating = rating.getText().trim();
                    Assert.assertEquals("Validate Rating", frontPageRating, subPageRating);
                    SearchPage.driver.close();
                }
            }
            SearchPage.driver.switchTo().window(parentWindow);
        }
    }


    @FindBy(xpath = "(//strong[contains(text(), 'Sort:')])[2]/../../../button")
    private WebElement sortButton;
    @FindBy(xpath = "//div[@class='action-list-dropdown show']//button[@title='Sort: Rating'][normalize-space()='Rating']")
    private WebElement sortRating;
    @FindBy(xpath = "//div[@class='action-list-dropdown show']//button[@title='Sort: Reviews'][normalize-space()='Reviews']")
    private WebElement sortReview;

    public void validateSortByRatingForPackageTab() {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.waitForVisibility(sortButton, 30, SearchPage.driver);
        sortButton.click();
        BaseClass.waitForVisibility(sortRating, 30, SearchPage.driver);
        sortRating.click();
        BaseClass.staticWaitForVisibility(5000);
        List<String> ratingList = BaseClass.getColumnDataInList(SearchPage.driver, "//div[@class='stars-text']/span[1]");
        List<Double> ratingsList = BaseClass.convertStringToDoubleList(ratingList);
        Assert.assertTrue("Validate Sort Rating", BaseClass.isSortedAscending(ratingsList));
    }

    public void validateSortByReviewForPackageTab() {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.waitForVisibility(sortButton, 30, SearchPage.driver);
        sortButton.click();
        BaseClass.waitForVisibility(sortReview, 30, SearchPage.driver);
        sortReview.click();
        BaseClass.staticWaitForVisibility(5000);
        List<String> reviewList = BaseClass.getColumnDataInList(SearchPage.driver, "//div[@class='stars-text']/a");
        System.out.println("reviewList " + reviewList);
        List<String> reviewStringList = BaseClass.removeAnyWord(reviewList, "Reviews");
        System.out.println("reviewStringList " + reviewStringList);
        List<Double> reviewsList = BaseClass.convertStringToDoubleList(reviewStringList);
        System.out.println("reviewsList " + reviewsList);
        Assert.assertTrue("Validate Sort Review", BaseClass.isSortedDescending(reviewsList));
    }

    @FindBy(xpath = "//div[@class='action-list-dropdown show']//button[@title='Sort: Price'][normalize-space()='Price']")
    private WebElement sortPrice;

    public void validateSortByPriceForPackageTab() {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.waitForVisibility(sortButton, 30, SearchPage.driver);
        sortButton.click();
        BaseClass.waitForVisibility(sortPrice, 30, SearchPage.driver);
        sortPrice.click();
        BaseClass.staticWaitForVisibility(5000);
        List<String> priceList = BaseClass.getColumnDataInList(SearchPage.driver, "//div[@class='ResultCard-userPrice']/span");
        System.out.println("priceList " + priceList);
        List<String> priceStringList = BaseClass.removeAnyWord(priceList, "$");
        System.out.println("priceStringList " + priceStringList);
        List<Double> pricesList = BaseClass.convertStringToDoubleList(priceStringList);
        System.out.println("pricesList " + pricesList);
        Assert.assertTrue("Validate Sort Price", BaseClass.isSortedAscending(pricesList));
    }

    public void validateSortByRatingForTalentTab() {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.javaScriptClick(SearchPage.driver, talentTab);
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.waitForVisibility(sortButton, 30, SearchPage.driver);
        sortButton.click();
        BaseClass.waitForVisibility(sortRating, 30, SearchPage.driver);
        sortRating.click();
        BaseClass.staticWaitForVisibility(5000);
        List<String> ratingList = BaseClass.getColumnDataInList(SearchPage.driver, "//div[@class='stars-text']/span[1]");
        List<Double> ratingsList = BaseClass.convertStringToDoubleList(ratingList);
        Assert.assertTrue("Validate Sort Rating", BaseClass.isSortedAscending(ratingsList));
    }

    public void validateSortByReviewForTalentTab() {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.javaScriptClick(SearchPage.driver, talentTab);
        BaseClass.staticWaitForVisibility(5000);
        BaseClass.waitForVisibility(sortButton, 30, SearchPage.driver);
        sortButton.click();
        BaseClass.waitForVisibility(sortReview, 30, SearchPage.driver);
        sortReview.click();
        BaseClass.staticWaitForVisibility(5000);
        List<String> reviewList = BaseClass.getColumnDataInList(SearchPage.driver, "//div[@class='stars-text']/a");
        System.out.println("reviewList " + reviewList);
        List<String> reviewStringList = BaseClass.removeAnyWord(reviewList, "Reviews");
        System.out.println("reviewStringList " + reviewStringList);
        List<Double> reviewsList = BaseClass.convertStringToDoubleList(reviewStringList);
        System.out.println("reviewsList " + reviewsList);
        Assert.assertTrue("Validate Sort Review", BaseClass.isSortedDescending(reviewsList));
    }

    @FindBy(xpath = "//div[@class='circle-avatar-container circle-avatar-container-xs']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[normalize-space()='Favorites']")
    private WebElement favoriteTab;
    @FindBy(xpath = "//nav[@id='main-tab-nav']//a[normalize-space()='Packages']")
    private WebElement favoritePackageTab;
    @FindBy(xpath = "//button[normalize-space()='Edit List']")
    private WebElement editListButton;
    @FindBy(xpath = "//a[normalize-space()='Delete List']")
    private WebElement deleteListButton;
    @FindBy(xpath = "//button[@id='delete-favorite-list-submit-btn']")
    private WebElement deleteConfirmation;
    @FindBy(xpath = "(//i[@title='Save to Favorites'])[1]")
    private WebElement addListIcon;
    @FindBy(xpath = "(//span[text()='Create New List'])[1]")
    private WebElement createListLink;
    @FindBy(xpath = "//textarea[@id='favorite_list_name-0']")
    private WebElement createListTextBox;
    @FindBy(xpath = "(//button[text()='Create'])[1]")
    private WebElement createButton;

    public void addFavoritesForClientUserUserPackagesTab(String listName) {
        BaseClass.waitForVisibility(userIcon, 30, SearchPage.driver);
        BaseClass.mouseOverOnElement(SearchPage.driver, userIcon);
        BaseClass.waitForVisibility(favoriteTab, 30, SearchPage.driver);
        favoriteTab.click();
        BaseClass.waitForVisibility(favoritePackageTab, 30, SearchPage.driver);
        favoritePackageTab.click();
        WebElement listElement = null;
        try {
            listElement = SearchPage.driver.findElement(By.xpath("//a[@title='View: " + listName + "']"));
        } catch (Exception e) {

        }
        if (BaseClass.isElementPresent(SearchPage.driver, listElement)) {
            BaseClass.waitForVisibility(listElement, 30, SearchPage.driver);
            listElement.click();
            BaseClass.waitForVisibility(editListButton, 30, SearchPage.driver);
            editListButton.click();
            BaseClass.waitForVisibility(deleteListButton, 30, SearchPage.driver);
            deleteListButton.click();
            BaseClass.waitForVisibility(deleteConfirmation, 30, SearchPage.driver);
            deleteConfirmation.click();
            BaseClass.staticWaitForVisibility(5000);
        }
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        addListIcon.click();
        BaseClass.waitForVisibility(createListLink, 30, SearchPage.driver);
        createListLink.click();
        BaseClass.waitForVisibility(createListTextBox, 30, SearchPage.driver);
        createListTextBox.sendKeys(listName);
        BaseClass.waitForVisibility(createButton, 30, SearchPage.driver);
        createButton.click();
        BaseClass.staticWaitForVisibility(2000);
        addListIcon.click();
        BaseClass.staticWaitForVisibility(2000);
        addListIcon.click();
    }

    @FindBy(xpath = "//span[@id='favorite-items-subheading']")
    private WebElement favoriteCount;

    public void validateAddedFavoriteCountForPackageTab(String listName) {
        BaseClass.waitForVisibility(userIcon, 30, SearchPage.driver);
        BaseClass.mouseOverOnElement(SearchPage.driver, userIcon);
        BaseClass.waitForVisibility(favoriteTab, 30, SearchPage.driver);
        favoriteTab.click();
        BaseClass.waitForVisibility(favoritePackageTab, 30, SearchPage.driver);
        favoritePackageTab.click();
        WebElement listElement = SearchPage.driver.findElement(By.xpath("//a[@title='View: " + listName + "']"));
        BaseClass.waitForVisibility(listElement, 30, SearchPage.driver);
        listElement.click();
        BaseClass.staticWaitForVisibility(5000);
        Assert.assertEquals("Validate Favorite Count", "3 Package Favorites", favoriteCount.getText().trim());
    }

    public void validateAddedFavoriteCountForTalentTab(String listName) {
        BaseClass.waitForVisibility(userIcon, 30, SearchPage.driver);
        BaseClass.mouseOverOnElement(SearchPage.driver, userIcon);
        BaseClass.waitForVisibility(favoriteTab, 30, SearchPage.driver);
        favoriteTab.click();
        WebElement listElement = SearchPage.driver.findElement(By.xpath("//a[@title='View: " + listName + "']"));
        BaseClass.waitForVisibility(listElement, 30, SearchPage.driver);
        listElement.click();
        BaseClass.staticWaitForVisibility(5000);
        Assert.assertEquals("Validate Favorite Count", "3 Talent Favorites", favoriteCount.getText().trim());
    }

    public void addFavoritesForClientUserTalentTab(String listName) {
        BaseClass.waitForVisibility(userIcon, 30, SearchPage.driver);
        BaseClass.mouseOverOnElement(SearchPage.driver, userIcon);
        BaseClass.waitForVisibility(favoriteTab, 30, SearchPage.driver);
        favoriteTab.click();
        WebElement listElement = null;
        try {
            listElement = SearchPage.driver.findElement(By.xpath("//a[@title='View: " + listName + "']"));
        } catch (Exception e) {

        }
        if (BaseClass.isElementPresent(SearchPage.driver, listElement)) {
            BaseClass.waitForVisibility(listElement, 30, SearchPage.driver);
            listElement.click();
            BaseClass.waitForVisibility(editListButton, 30, SearchPage.driver);
            editListButton.click();
            BaseClass.waitForVisibility(deleteListButton, 30, SearchPage.driver);
            deleteListButton.click();
            BaseClass.waitForVisibility(deleteConfirmation, 30, SearchPage.driver);
            deleteConfirmation.click();
            BaseClass.staticWaitForVisibility(5000);
        }
        searchIcon.click();
        BaseClass.staticWaitForVisibility(5000);
        talentTab.click();
        BaseClass.staticWaitForVisibility(5000);
        addListIcon.click();
        BaseClass.waitForVisibility(createListLink, 30, SearchPage.driver);
        createListLink.click();
        BaseClass.waitForVisibility(createListTextBox, 30, SearchPage.driver);
        createListTextBox.sendKeys(listName);
        BaseClass.waitForVisibility(createButton, 30, SearchPage.driver);
        createButton.click();
        BaseClass.staticWaitForVisibility(2000);
        addListIcon.click();
        BaseClass.staticWaitForVisibility(2000);
        addListIcon.click();
    }


    public void selectMultipleDropdownValue(String tabName, String category, String language, String accent) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        if (tabName.equalsIgnoreCase("Talent")) {
            BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        if (!BaseClass.isElementPresent(SearchPage.driver, categoryDropdown)) {
            packageTab.click();
            BaseClass.waitForVisibility(talentTab, 60, SearchPage.driver);
            BaseClass.javaScriptClick(SearchPage.driver, talentTab);
            BaseClass.staticWaitForVisibility(3000);
        }
        BaseClass.waitForVisibility(categoryDropdown, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, categoryDropdown);
        WebElement categoryElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + category + "']"));
        categoryElement.click();
        BaseClass.waitForVisibility(applyFilterButton, 30, SearchPage.driver);
        applyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);

        BaseClass.waitForVisibility(languageDropdown, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, languageDropdown);
        BaseClass.waitForVisibility(languageSearchField, 30, SearchPage.driver);
        languageSearchField.sendKeys(language);
        BaseClass.staticWaitForVisibility(2000);
        WebElement languageElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + language + "'])[1]"));
        languageElement.click();
        BaseClass.staticWaitForVisibility(3000);

        accentDropdown.click();
        BaseClass.waitForVisibility(accentSearchField, 30, SearchPage.driver);
        accentSearchField.sendKeys(accent);
        BaseClass.staticWaitForVisibility(2000);
        WebElement accentElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + accent + "'])[1]"));
        accentElement.click();
        BaseClass.staticWaitForVisibility(3000);

    }

    public void validateMultiDropdownSelection(String tabName, String category, String language, String accent) {
        Assert.assertEquals("Validate category Filter text", category, firstFilterText.getText().trim());
        Assert.assertEquals("Validate language Filter text", language, secondFilterText.getText().trim());
        Assert.assertEquals("Validate accent Filter text", accent, thirdFilterText.getText().trim());

        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> categoryTextEleList = null;
        if (tabName.equalsIgnoreCase("Packages")) {
            categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
        } else if (tabName.equalsIgnoreCase("Talent")) {
            categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
        }
        if (categoryTextEleList.isEmpty()) {
            Assert.assertTrue("Zero record found", categoryTextEleList.size() == 0);

        } else {
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate category count for first page", totalFirstPageCount, categoryTextEleList.size());
            } else {
                Assert.assertEquals("Validate category count for first page", 24, categoryTextEleList.size());
            }
        }

        clearFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, thirdFilterText));
    }

    @FindBy(xpath = "//input[@id='filter_talent']/..")
    private WebElement talentFilter;
    @FindBy(xpath = "//input[@id='filters_price_min']")
    private WebElement minPriceTextBox;
    @FindBy(xpath = "//input[@id='filters_price_max']")
    private WebElement maxPriceTextBox;
    @FindBy(xpath = "//select[@name='filter_delivery_time']")
    private WebElement deliveryTimeDropdownXp;
    @FindBy(xpath = "//select[@name='filter_categories']")
    private WebElement categoryDropdownXp;
    @FindBy(xpath = "//select[@name='filter_languages']")
    private WebElement languageDropdownXp;
    @FindBy(xpath = "//select[@name='filter_accents']")
    private WebElement accentDropdownXp;
    @FindBy(xpath = "//select[@name='filter_voice_gender']")
    private WebElement genderDropdownXp;
    @FindBy(xpath = "//select[@name='filter_voice_ages']")
    private WebElement ageDropdownXp;
    @FindBy(xpath = "//input[@id='filters_keywords']")
    private WebElement keywordTextBox;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//form[@class='nav-main-form siteSearch-form siteSearch-form-desktop']//button[@type='button']")
    private WebElement advanceSearchButton;
    @FindBy(xpath = "//a[@class='nav-main-submenu-link nav-main-submenu-link-line d-flex justify-content-between']")
    private WebElement howItWorkLink;
    @FindBy(xpath = "//h1[normalize-space()='How It Works']")
    private WebElement howItWorksText;

    public void clickOnHowItWorkAndValidateUrl() {
        BaseClass.waitForVisibility(howItWorkLink, 60, SearchPage.driver);
        howItWorkLink.click();
        BaseClass.waitForVisibility(howItWorksText, 60, SearchPage.driver);
        Assert.assertEquals("Validate How It Work Text", "How It Works", howItWorksText.getText().trim());
        Assert.assertEquals("Validate Url", ReaderManager.getInstance().getConfigReader().getUrlEndPoint("HowItWorks"), SearchPage.driver.getCurrentUrl());
        BaseClass.validateURLresponse(SearchPage.driver.getCurrentUrl());
        SearchPage.driver.navigate().refresh();

    }

    public void userSelectAdvanceSearchOptionsForPackagesTabForNonSignUser(String minPrice, String maxPrice, String deliveryTime, String category, String language, String accent, String gender, String age, String keyword) {
        clickOnHowItWorkAndValidateUrl();
        BaseClass.waitForVisibility(advanceSearchButton, 30, SearchPage.driver);
        advanceSearchButton.click();
        BaseClass.waitForVisibility(minPriceTextBox, 30, SearchPage.driver);
        minPriceTextBox.sendKeys(minPrice);
        maxPriceTextBox.sendKeys(maxPrice);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, deliveryTimeDropdownXp, deliveryTime);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, categoryDropdownXp, category);
        BaseClass.scrollToElement(SearchPage.driver, languageDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, languageDropdownXp, language);
        BaseClass.scrollToElement(SearchPage.driver, accentDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, accentDropdownXp, accent);
        BaseClass.scrollToElement(SearchPage.driver, genderDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, genderDropdownXp, gender);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, ageDropdownXp, age);
        BaseClass.scrollToElement(SearchPage.driver, keywordTextBox);
        keywordTextBox.sendKeys(keyword);
        BaseClass.scrollToElement(SearchPage.driver, searchButton);
        searchButton.click();
        BaseClass.staticWaitForVisibility(5000);

    }

    public void userSelectAdvanceSearchOptionsForPackagesTabForSignUser(String minPrice, String maxPrice, String deliveryTime, String category, String language, String accent, String gender, String age, String keyword) {
        BaseClass.waitForVisibility(advanceSearchButton, 30, SearchPage.driver);
        advanceSearchButton.click();
        BaseClass.waitForVisibility(minPriceTextBox, 30, SearchPage.driver);
        minPriceTextBox.sendKeys(minPrice);
        maxPriceTextBox.sendKeys(maxPrice);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, deliveryTimeDropdownXp, deliveryTime);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, categoryDropdownXp, category);
        BaseClass.scrollToElement(SearchPage.driver, languageDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, languageDropdownXp, language);
        BaseClass.scrollToElement(SearchPage.driver, accentDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, accentDropdownXp, accent);
        BaseClass.scrollToElement(SearchPage.driver, genderDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, genderDropdownXp, gender);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, ageDropdownXp, age);
        BaseClass.scrollToElement(SearchPage.driver, keywordTextBox);
        keywordTextBox.sendKeys(keyword);
        BaseClass.scrollToElement(SearchPage.driver, searchButton);
        searchButton.click();
        BaseClass.staticWaitForVisibility(5000);

    }

    public void validateAdvanceSearchResultsForPackagesTab() {
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, thirdFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fourthFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fifthFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, sixthFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, seventhFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, eighthFilterText));

        BaseClass.staticWaitForVisibility(3000);

        List<WebElement> categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

        if (categoryTextEleList.isEmpty()) {
            Assert.assertTrue("Zero record found", categoryTextEleList.size() == 0);

        } else {
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate category count for first page", totalFirstPageCount, categoryTextEleList.size());
            } else {
                Assert.assertEquals("Validate category count for first page", 24, categoryTextEleList.size());
            }
        }

        clearFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, thirdFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fourthFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fifthFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, sixthFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, seventhFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, eighthFilterText));
    }

    public void userSelectAdvanceSearchOptionsForTalentTabForNonSignUser(String category, String language, String accent, String gender, String age, String keyword) {
        clickOnHowItWorkAndValidateUrl();
        BaseClass.waitForVisibility(advanceSearchButton, 30, SearchPage.driver);
        advanceSearchButton.click();
        BaseClass.waitForVisibility(talentFilter, 30, SearchPage.driver);
        talentFilter.click();
        BaseClass.waitForVisibility(categoryDropdownXp, 30, SearchPage.driver);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, categoryDropdownXp, category);
        BaseClass.scrollToElement(SearchPage.driver, languageDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, languageDropdownXp, language);
        BaseClass.scrollToElement(SearchPage.driver, accentDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, accentDropdownXp, accent);
        BaseClass.scrollToElement(SearchPage.driver, genderDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, genderDropdownXp, gender);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, ageDropdownXp, age);
        BaseClass.scrollToElement(SearchPage.driver, keywordTextBox);
        keywordTextBox.sendKeys(keyword);
        BaseClass.scrollToElement(SearchPage.driver, searchButton);
        searchButton.click();
        BaseClass.staticWaitForVisibility(5000);

    }

    public void userSelectAdvanceSearchOptionsForTalentTabForSignUser(String category, String language, String accent, String gender, String age, String keyword) {
        BaseClass.waitForVisibility(advanceSearchButton, 30, SearchPage.driver);
        advanceSearchButton.click();
        BaseClass.waitForVisibility(talentFilter, 30, SearchPage.driver);
        talentFilter.click();
        BaseClass.waitForVisibility(categoryDropdownXp, 30, SearchPage.driver);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, categoryDropdownXp, category);
        BaseClass.scrollToElement(SearchPage.driver, languageDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, languageDropdownXp, language);
        BaseClass.scrollToElement(SearchPage.driver, accentDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, accentDropdownXp, accent);
        BaseClass.scrollToElement(SearchPage.driver, genderDropdownXp);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, genderDropdownXp, gender);
        BaseClass.selectDropDownByVisibleText(SearchPage.driver, ageDropdownXp, age);
        BaseClass.scrollToElement(SearchPage.driver, keywordTextBox);
        keywordTextBox.sendKeys(keyword);
        BaseClass.scrollToElement(SearchPage.driver, searchButton);
        searchButton.click();
        BaseClass.staticWaitForVisibility(5000);

    }
    public void validateAdvanceSearchResultsForTalentTab() {
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, thirdFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fourthFilterText));
        Assert.assertTrue("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fifthFilterText));

        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> categoryTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));

        if (categoryTextEleList.isEmpty()) {
            Assert.assertTrue("Zero record found", categoryTextEleList.size() == 0);

        } else {
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate category count for first page", totalFirstPageCount, categoryTextEleList.size());
            } else {
                Assert.assertEquals("Validate category count for first page", 24, categoryTextEleList.size());
            }
        }

        clearFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, firstFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, secondFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, thirdFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fourthFilterText));
        Assert.assertFalse("Validate filter option not present", BaseClass.isElementPresent(SearchPage.driver, fifthFilterText));

    }
}





