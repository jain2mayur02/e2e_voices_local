package com.voices.baseClass;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class BaseClass {
    static WebDriver driver;

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, null);
    }

    Logger logger = LoggerFactory.getLogger(BaseClass.class);

    public static void createAlert(String alertMessage, WebDriver driverClass) {
        JavascriptExecutor jse = (JavascriptExecutor) driverClass;
        jse.executeScript("window.confirm('" + alertMessage + "')");
        Alert alert = driverClass.switchTo().alert();
        alert.accept();
    }

    public static void javaScriptClick(WebDriver driverClass, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driverClass;
        executor.executeScript("arguments[0].click();", element);
    }

    public static String convertDateStringFormat(String date1) throws ParseException {
        Date date = new SimpleDateFormat("M/d/yyyy").parse(date1);
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
        String convertedDate = formatter.format(date);
        return convertedDate;
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date date = new Date();
        String todayDate = dateFormat.format(date);
        return todayDate;
    }

    public static void implicitWait(WebDriver driverClass, int waitSecTime) {
        driverClass.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSecTime));

    }

    public static void waitForVisibility(WebElement element, int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean waitForElementClickable(WebElement element, int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }

    public static void waitForElementPresent(WebElement element, int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public static void selectDropDownByIndex(WebDriver driverClass, WebElement dropDownElement, int dropDownIndex) {
        Select dropDownObj = new Select(dropDownElement);
        dropDownObj.selectByIndex(dropDownIndex);

    }

    public static void selectDropDownByVisibleText(WebDriver driverClass, WebElement dropDownElement, String dropDownTxt) {
        Select dropDownObj = new Select(dropDownElement);
        dropDownObj.selectByVisibleText(dropDownTxt);

    }

    public static void moveToElement(WebDriver driverClass, WebElement moveElement) {
        Actions a = new Actions(driverClass);
        a.moveToElement(moveElement).build().perform();
    }

    public static void horizontalScrollMethod(WebDriver driverClass, WebElement moveElement, int xOffSet, int yOffSet) {
        Actions a = new Actions(driverClass);
        a.clickAndHold(moveElement).moveByOffset(xOffSet, yOffSet).build().perform();

    }

    public static void moveToElementClick(WebDriver driverClass, WebElement moveElement) {
        BaseClass.staticWaitForVisibility(2000);
        Actions a = new Actions(driverClass);
        a.moveToElement(moveElement).click().build().perform();
        BaseClass.staticWaitForVisibility(2000);
    }

    public static void selectDropDownByValue(WebDriver driverClass, WebElement dropDownElement, String dropDownValue) {
        Select dropDownObj = new Select(dropDownElement);
        dropDownObj.selectByValue(dropDownValue);
    }

    public static void switchToFrame(WebDriver driverClass, WebElement frameElement) {
        driverClass.switchTo().frame(frameElement);
    }

    public static void switchDefaultContent(WebDriver driverClass) {
        driverClass.switchTo().defaultContent();
    }

    public static void refreshPage(WebDriver driverClass) {
        driverClass.navigate().refresh();
    }

    public static void acceptAlert(WebDriver driverClass) {
        driverClass.switchTo().alert().accept();
    }


    public static String getFirstSelectedOption(WebDriver driverClass, WebElement dropDownElement) {
        Select dropDownObj = new Select(dropDownElement);
        String firstOption = dropDownObj.getFirstSelectedOption().getText();
        return firstOption;
    }

    public static boolean isCheckBoxSelected(WebDriver driverClass, WebElement checkBoxElement) {
        boolean checkBoxStatus = checkBoxElement.isSelected();
        return checkBoxStatus;
    }

    public static int getTotalTableRowCount(WebDriver driverClass, String tableRowLocatorXpath) {
        int rowCount = driverClass.findElements(By.xpath(tableRowLocatorXpath)).size();
        return rowCount;
    }

    public static Boolean waitForAlertPresent(int waitSecTime, WebDriver driverClass) throws Error {
        new WebDriverWait(driverClass, Duration.ofSeconds(waitSecTime)).until(ExpectedConditions.alertIsPresent());
        return true;
    }


    public static void uploadExcelFile(WebDriver driverClass, String filePath) throws AWTException {
        Robot rb = new Robot();
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public static boolean isAlertPresent(WebDriver driverClass) {
        try {
            driverClass.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }


    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getPhysicalRowCount(String xlFile, String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        int rowCount = ws.getPhysicalNumberOfRows();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }


    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        if (row != null) {
            cell = row.getCell(colNum);
        }
        String data = "";
        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }


    public static Set<String> getDataFromRentRollImportExcelWithVacant(String excelFile, String sheetName, String propertyName, int colNo) throws IOException {
        Map<String, Set<String>> map = new TreeMap<String, Set<String>>(String.CASE_INSENSITIVE_ORDER);
        int maxRows = BaseClass.getPhysicalRowCount(excelFile, sheetName);
        Set<String> set = new HashSet<String>();
        for (int i = 1; i < maxRows; i++) {
            String name = BaseClass.getCellData(excelFile, sheetName, i, 0);
            String role = BaseClass.getCellData(excelFile, sheetName, i, colNo);
            if (map.containsKey(name)) {
                set = map.get(name);
                set.add(role);
                map.put(name, set);
            } else {
                set = new HashSet<String>();
                set.add(role);
                map.put(name, set);
            }
        }
        if (map.containsKey(propertyName)) {
            set = map.get(propertyName);
        } else {
            System.out.println("Data not Present");
        }
        return set;
    }


    public static java.util.List<String> getDataFromRentRollImportExcelInList(String excelFile, String sheetName, String propertyName, int colNo) throws IOException {
        Map<String, java.util.List<String>> map = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        int maxRows = BaseClass.getPhysicalRowCount(excelFile, sheetName);
        java.util.List<String> list = new ArrayList<String>();
        for (int i = 1; i < maxRows; i++) {
            String name = BaseClass.getCellData(excelFile, sheetName, i, 0);
            String role = BaseClass.getCellData(excelFile, sheetName, i, colNo);
            if (map.containsKey(name)) {
                list = map.get(name);
                list.add(role);
                map.put(name, list);
            } else {
                list = new ArrayList<String>();
                list.add(role);
                map.put(name, list);
            }
        }
        if (map.containsKey(propertyName)) {
            list = map.get(propertyName);
        } else {
            System.out.println("Data not Present");
        }
        return list;
    }


    public static Set getExcelColumnDataInSet(String xlFile, String xlSheet, int colNum, int startRow) throws IOException {
        Set<String> columnData = new LinkedHashSet<String>();
        int rowCount = getPhysicalRowCount(xlFile, xlSheet);
        for (int i = startRow; i < rowCount; i++) {
            String cellData = getCellData(xlFile, xlSheet, i, colNum);
            if (cellData == "") {
            } else {
                columnData.add(cellData);
            }
        }
        return columnData;
    }

    public static java.util.List getColumnDataInList(WebDriver driverClass, String xpath) {
        java.util.List<String> columnData = new ArrayList<String>();
        java.util.List<WebElement> columnDataWebElement = driverClass.findElements(By.xpath(xpath));
        for (WebElement element : columnDataWebElement) {
            columnData.add(element.getText());
        }
        return columnData;
    }


    public static Set<String> getDataFromRentRollImportExcelByTenantNameInSet(String excelFile, String sheetName, String tenantName, int tenantCol, int colNo, int startRowNo) throws IOException {
        Map<String, Set<String>> map = new TreeMap<String, Set<String>>(String.CASE_INSENSITIVE_ORDER);
        int maxRows = BaseClass.getPhysicalRowCount(excelFile, sheetName);
        Set<String> set = new HashSet<String>();
        for (int i = startRowNo; i < maxRows; i++) {
            String name = BaseClass.getCellData(excelFile, sheetName, i, tenantCol);
            String role = BaseClass.getCellData(excelFile, sheetName, i, colNo);
            if (map.containsKey(name)) {
                set = map.get(name);
                set.add(role);
                map.put(name, set);
            } else {
                set = new HashSet<String>();
                set.add(role);
                map.put(name, set);
            }
        }
        if (map.containsKey(tenantName)) {
            set = map.get(tenantName);
        } else {
            System.out.println("Data not Present");
        }
        return set;
    }

    public static java.util.List<String> getDataFromRentRollImportExcelByTenantNameInList(String excelFile, String sheetName, String tenantName, int tenantCol, int colNo, int startRowNo) throws IOException {
        Map<String, java.util.List<String>> map = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        int maxRows = BaseClass.getPhysicalRowCount(excelFile, sheetName);
        java.util.List<String> list = new ArrayList<String>();
        for (int i = startRowNo; i < maxRows; i++) {
            String name = BaseClass.getCellData(excelFile, sheetName, i, tenantCol);
            String role = BaseClass.getCellData(excelFile, sheetName, i, colNo);
            if (map.containsKey(name)) {
                list = map.get(name);
                list.add(role);
                map.put(name, list);
            } else {
                list = new ArrayList<String>();
                list.add(role);
                map.put(name, list);
            }
        }
        if (map.containsKey(tenantName)) {
            list = map.get(tenantName);
        } else {
            System.out.println("Data not Present");
        }
        return list;
    }


    public static Set<String> getDataFromImportExcelByValue(String excelFile, String sheetName, String tenantName, int tenantCol, int colNo, int startRowNo) throws IOException {
        Map<String, Set<String>> map = new TreeMap<String, Set<String>>(String.CASE_INSENSITIVE_ORDER);
        int maxRows = BaseClass.getPhysicalRowCount(excelFile, sheetName);
        Set<String> set = new LinkedHashSet<String>();
        for (int i = startRowNo; i < maxRows; i++) {
            String name = BaseClass.getCellData(excelFile, sheetName, i, tenantCol);
            String role = BaseClass.getCellData(excelFile, sheetName, i, colNo);
            if (map.containsKey(name)) {
                set = map.get(name);
                set.add(role);
                map.put(name, set);
            } else {
                set = new LinkedHashSet<String>();
                set.add(role);
                map.put(name, set);
            }
        }
        if (map.containsKey(tenantName)) {
            set = map.get(tenantName);
        } else {
            System.out.println("Data not Present");
        }
        return set;
    }

    public static Map getExcelDataInHashMap(String xlFile, String xlSheet, int startRow, int keyColNo, int valueColNo) throws IOException {
        HashMap<String, String> map = new LinkedHashMap<String, String>();
        int totalRow = BaseClass.getRowCount(xlFile, xlSheet);
        for (int i = startRow; i < totalRow; i++) {
            String key = BaseClass.getCellData(xlFile, xlSheet, i, keyColNo);
            String value = BaseClass.getCellData(xlFile, xlSheet, i, valueColNo);
            map.put(key, value);
        }
        return map;
    }

    public static void staticWaitForVisibility(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Throwable e) {
        }
    }


    public static Set mergeTwoSetInOne(Set s1, Set s2) {
        Set<String> mergeSet = new HashSet();
        mergeSet.addAll(s1);
        mergeSet.addAll(s2);
        return mergeSet;
    }

    public static String convertDateStringFormat1(String date1) throws ParseException {
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String convertedDate = formatter.format(date);
        return convertedDate;
    }


    public static String verifyFileExist(String filename) {
        String file_with_location = System.getProperty("user.home") + "\\Downloads\\" + filename;
        System.out.println(file_with_location);
        File file = new File(file_with_location);
        if (file.exists()) {
            Assert.assertTrue("Verify File downloaded", file.exists());
            System.out.println(file_with_location + " is present");

        } else {
            Assert.fail("File Not downloaded successfully");
        }
        return file_with_location;
    }

    public static String deleteExistingFile(String filename) {
        String file_with_location = System.getProperty("user.home") + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        if (file.exists()) {
            System.out.println(file_with_location + " is present");
            file.delete();
            System.out.println("file deleted");

            Assert.assertFalse("Verify file deleted", file.exists());
        } else {
            System.out.println(file_with_location + " is not present");
        }
        return file_with_location;
    }

    public static int additionOfSetElement(Set<String> set) {
        int sum = 0;
        for (String number : set) {
            int num = Integer.parseInt(number.replaceAll(",", ""));
            sum = sum + num;
        }
        return sum;
    }

    public static int additionOfListElement(java.util.List<String> list) {
        int sum = 0;
        for (String number : list) {
            int num = Integer.parseInt(number.replaceAll(",", ""));
            sum = sum + num;
        }
        return sum;
    }

    public static double additionOfSetElementInDouble(Set<Double> set) {
        double sum = 0;
        for (Double number : set) {
            double num = Double.parseDouble(String.valueOf(number));
            sum = sum + num;
        }
        return sum;
    }

    public static java.util.List getExcelColumnDataInList(String xlFile, String xlSheet, int colNum, int startRow) throws IOException {
        List<String> columnData = new ArrayList<String>();
        int rowCount = getPhysicalRowCount(xlFile, xlSheet);
        for (int i = startRow; i < rowCount; i++) {
            String cellData = getCellData(xlFile, xlSheet, i, colNum);
            if (cellData == "") {
            } else {
                columnData.add(cellData);
            }
        }
        return columnData;
    }

    public static boolean dynamicNameFileExists(String filename) {
        boolean flag = false;
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\";
        File[] listFile = new File(file_with_location).listFiles();
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isFile()) {
                String fileNameFromDownload = (listFile[i].getName());
                if (fileNameFromDownload.startsWith(filename) && fileNameFromDownload.endsWith(".xlsx")) {
                    return flag = true;
                }
            }
        }
        return flag;
    }

    public static void deleteExcelFile(String filename) {
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\";
        File[] listFile = new File(file_with_location).listFiles();
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isFile()) {
                String fileNameFromDownload = (listFile[i].getName());
                if (fileNameFromDownload.startsWith(filename) && fileNameFromDownload.endsWith(".xlsx")) {
                    if (fileNameFromDownload.startsWith(filename)) {
                        File from_file = new File(System.getProperty("user.home") + "\\Downloads\\" + fileNameFromDownload);
                        if (from_file.exists()) {
                            from_file.delete();
                        }
                    }
                }
            }
        }
    }

    public static void mouseOverOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static String getFileName(String filename) {
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\";
        String fileName = null;
        File[] listFile = new File(file_with_location).listFiles();
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isFile()) {
                String fileNameFromDownload = (listFile[i].getName());
                if (fileNameFromDownload.startsWith(filename) && fileNameFromDownload.endsWith(".xlsx")) {
                    fileName = fileNameFromDownload;
                }
            }
        }
        return fileName;
    }

    public static String getFirstSelectedElementInDropDown(WebDriver driverClass, WebElement element) {
        Select select = new Select(element);
        String option = select.getFirstSelectedOption().getText();
        return option;
    }

    public static void validateURLresponse(String url) {
        try {
            URL linkUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
//                    System.out.println(url + " - Valid link");
//                    System.out.println(url + " - Valid link (Response Code: " + responseCode + ")");
                Assert.assertTrue(true);
            } else {
                System.out.println(url + " - Invalid link (Response Code: " + responseCode + ")");
                Assert.assertTrue(false);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(url + " - Exception occurred: " + e.getMessage());
        }
    }


    public static void scrollUpToBottomOfPage(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
