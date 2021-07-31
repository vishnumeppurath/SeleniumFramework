package com.qatest.testbase;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qatest.factory.DriverFactory;
import com.qatest.factory.ReportFactory;
import com.qatest.reusablecomponents.ReportGenerator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listener extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest=ReportFactory.getInstance().getExtentTest();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        File takesScreenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") +
                "/target/test-report/screenshot/" + result.getMethod().getMethodName() +
                simpleDateFormat.format(date) + ".jpg";
        try {
            FileUtils.copyFile(takesScreenshot, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.log(Status.FAIL, "Test Case :" + result.getMethod().getMethodName() + "is Failed");
        extentTest.log(Status.FAIL, result.getThrowable());
        extentTest.addScreenCaptureFromPath("/target/test-report/screenshot/"+result.getMethod().getMethodName() +
                simpleDateFormat.format(date) + ".jpg", "Failure Screenshot");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest=ReportFactory.getInstance().getExtentTest();
        extentTest.log(Status.PASS, "Test Case :" + result.getMethod().getMethodName() + "is Passed");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportFactory.getInstance().setExtentTest( extentReports.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext context) {
        if(extentReports==null){
            extentReports = ReportGenerator.generateExtentReport();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
