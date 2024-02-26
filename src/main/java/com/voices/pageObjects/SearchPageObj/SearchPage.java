package com.voices.pageObjects.SearchPageObj;

import com.voices.baseClass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
                talentTab.click();
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(categoryDropdown, 30, SearchPage.driver);
            categoryDropdown.click();
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
            String[] countPage1 = elementCount.getText().split(" ");
            int totalCountPage1 = Integer.parseInt(countPage1[3]);
            int totalFirstPageCount = 0;
            if (totalCountPage1 < 24) {
                totalFirstPageCount = totalCountPage1;
                Assert.assertEquals("Validate category gadget count for first page", totalFirstPageCount, categoryTextEleList.size());
                continue;
            } else {
                Assert.assertEquals("Validate category gadget count for first page", 24, categoryTextEleList.size());
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
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                talentTab.click();
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(languageDropdown, 30, SearchPage.driver);
            languageDropdown.click();
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
                BaseClass.waitForVisibility(talentTab, 30, SearchPage.driver);
                talentTab.click();
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(accentDropdown, 30, SearchPage.driver);
            accentDropdown.click();
            BaseClass.waitForVisibility(accentSearchField, 30, SearchPage.driver);
            accentSearchField.sendKeys(accent);
            BaseClass.staticWaitForVisibility(2000);
            WebElement accentElement = SearchPage.driver.findElement(By.xpath("(//div[text()='" + accent + "'])[1]"));
            accentElement.click();
            BaseClass.staticWaitForVisibility(3000);
//            List<WebElement> accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

            List<WebElement> accentTextEleList = null;
            if (tabName.equalsIgnoreCase("Packages")) {
                accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
            } else if (tabName.equalsIgnoreCase("Talent")) {
                accentTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-demoTags']"));
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
                talentTab.click();
                BaseClass.staticWaitForVisibility(3000);
            }
            BaseClass.waitForVisibility(genderDropdown, 30, SearchPage.driver);
            genderDropdown.click();
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
                talentTab.click();
                BaseClass.staticWaitForVisibility(5000);
            }
            BaseClass.waitForVisibility(ageDropdown, 30, SearchPage.driver);
            ageDropdown.click();
            WebElement ageElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + age + "']"));
            ageElement.click();
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
        priceDropdown.click();
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
            deliveryTimeDropdown.click();
            WebElement deliveryTimeElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + deliveryTime + "']"));
            deliveryTimeElement.click();
            BaseClass.waitForVisibility(deliveryTimeApplyFilterButton, 30, SearchPage.driver);
            deliveryTimeApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> deliveryTimeTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

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


    public void validateVoicesTalentTierTimeSearchForNonSignUser(String... talentTierList) {
        for (String talentTier : talentTierList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            BaseClass.waitForVisibility(talentTierDropdown, 30, SearchPage.driver);
            talentTierDropdown.click();
            WebElement talentTierElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + talentTier + "']"));
            talentTierElement.click();
            BaseClass.waitForVisibility(talentTierApplyFilterButton, 30, SearchPage.driver);
            talentTierApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> talentTierTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

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
            List<WebElement> talentTierTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
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

    @FindBy(xpath = "//button[@id='recently_online-FiltersTrigger']")
    private WebElement onlineStatusDropdown;
    @FindBy(xpath = "//button[@id='recently_online-Apply']")
    private WebElement onlineStatusApplyFilterButton;

    public void validateVoicesOnlineStatusSearchForNonSignUser(String... onlineStatusList) {
        for (String onlineStatus : onlineStatusList) {
            SearchPage.driver.get("https://www.voices.systems/");
            BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
            searchIcon.click();
            BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
            showMoreLink.click();
            BaseClass.waitForVisibility(onlineStatusDropdown, 30, SearchPage.driver);
            onlineStatusDropdown.click();
            WebElement onlineStatusElement = SearchPage.driver.findElement(By.xpath("//label[normalize-space()='" + onlineStatus + "']"));
            onlineStatusElement.click();
            BaseClass.waitForVisibility(onlineStatusApplyFilterButton, 30, SearchPage.driver);
            onlineStatusApplyFilterButton.click();
            BaseClass.staticWaitForVisibility(3000);
            List<WebElement> onlineStatusTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

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
            List<WebElement> onlineStatusTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
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

    public void validateVoicesLocationSearchForNonSignUser(String country, String state, String city) {
        SearchPage.driver.get("https://www.voices.systems/");
        BaseClass.waitForVisibility(searchIcon, 30, SearchPage.driver);
        searchIcon.click();
        BaseClass.waitForVisibility(showMoreLink, 30, SearchPage.driver);
        showMoreLink.click();
        BaseClass.waitForVisibility(locationDropdown, 30, SearchPage.driver);
        locationDropdown.click();
        BaseClass.waitForVisibility(countryDropdown, 30, SearchPage.driver);
        countryDropdown.click();
        BaseClass.waitForVisibility(countrySearchField, 30, SearchPage.driver);
        countrySearchField.sendKeys(country);
        BaseClass.staticWaitForVisibility(2000);
        SearchPage.driver.findElement(By.xpath("//div[text()='" + country + "']")).click();
        BaseClass.staticWaitForVisibility(3000);
        BaseClass.waitForVisibility(stateDropdown, 30, SearchPage.driver);
        stateDropdown.click();
        WebElement stateElement = SearchPage.driver.findElement(By.xpath("//div[text()='" + state + "']"));
        BaseClass.waitForVisibility(stateElement, 30, SearchPage.driver);
        BaseClass.javaScriptClick(SearchPage.driver, stateElement);
        BaseClass.staticWaitForVisibility(3000);
        cityTextField.sendKeys(city);

        BaseClass.waitForVisibility(locationApplyFilterButton, 30, SearchPage.driver);
        locationApplyFilterButton.click();
        BaseClass.staticWaitForVisibility(3000);
        List<WebElement> locationTextEleList = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));

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
        List<WebElement> locationTextEleList2 = SearchPage.driver.findElements(By.xpath("//div[@class='ResultCard-category']"));
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


}