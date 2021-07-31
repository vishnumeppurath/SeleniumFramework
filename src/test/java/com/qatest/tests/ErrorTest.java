package com.qatest.tests;

import com.qatest.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorTest extends TestBase {
    @Test(enabled = false)
    public void checkEnginePerformanceError(){
        homePage.clickAutomobile();
        vehicleDataPage.enterEnginePerformance("5000");
        Assert.assertEquals(vehicleDataPage.getEnginePerformanceErrorText(),"Must be a number between 1 and 2000");
    }
    @Test(enabled = true)
    public void checkEnginePerformanceErrorFail(){
        homePage.clickAutomobile();
        vehicleDataPage.enterEnginePerformance("5000");
        Assert.assertEquals(vehicleDataPage.getEnginePerformanceErrorText(),"Must be a number between 2 and 2000");
    }
}
