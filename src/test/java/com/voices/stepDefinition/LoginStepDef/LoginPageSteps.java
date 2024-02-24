package com.voices.stepDefinition.LoginStepDef;

import com.voices.controlManager.TestContext;
import com.voices.pageObjects.LoginPageObj.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class LoginPageSteps {
    TestContext testContext;
    private List<Map<String,String>> data;

    LoginPage loginPage;

    public LoginPageSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageManager().getLoginPage();
    }




}
