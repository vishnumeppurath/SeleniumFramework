package com.qatest.tests;

import com.qatest.factory.DriverFactory;
import com.qatest.testbase.TestBase;
import org.testng.annotations.Test;

public class AutomobileTest extends TestBase {
    @Test(priority = 0)
    public void calculateInsuranceForVolvo() {
        System.out.println(DriverFactory.getInstance().getDriver().getTitle());
    }
    @Test(priority = 1)
    public void calculateInsuranceForFord() {
        System.out.println(DriverFactory.getInstance().getDriver().getCurrentUrl());
    }

}
