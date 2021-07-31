package com.qatest.tests;

import com.qatest.reusablecomponents.ExcelReader;
import com.qatest.testbase.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class EndToEndTest extends TestBase {
    public  static  final Logger LOGGER=LoggerFactory.getLogger(EndToEndTest.class);

    @Test(dataProvider = "autoMobileInsuranceData")
    public void AutomobileInsuranceTest(Object object) {
        LOGGER.debug("AutomobileInsuranceTest started in "+Thread.currentThread().getName());
        Map<String, String> testData = (Map<String, String>) object;
        homePage.clickAutomobile();
        vehicleDataPage.enterVehicleData(testData);
    }

    @DataProvider(name = "autoMobileInsuranceData")
    public Object[][] getTestData() throws IOException {
        int rowCount = ExcelReader.getRowCountOfSheet("VechicleData");
        Object[][] objects = new Object[rowCount][1];
        for (int i = 1; i <= rowCount; i++) {
            objects[i - 1][0] = ExcelReader.getTestData("VechicleData", i);
        }
        return objects;
    }

}
