package com.voices.controlManager;

import com.voices.managers.DriverManager;
import com.voices.managers.PageManager;

public class TestContext {
    private DriverManager driverManager;
    private PageManager pageManager;

    public TestContext(){
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriverForLaunch());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }
}
