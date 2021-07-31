package com.qatest.reusablecomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportGenerator {

    public static ExtentReports generateExtentReport(){
        ExtentReports extent = new ExtentReports();
        Date date=new Date();
        SimpleDateFormat dateTimeFormatter=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+
                "/target/test-report/Report-"+dateTimeFormatter.format(date)+".html");
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setReportName("SampleReport");
        sparkReporter.config().setTheme(Theme.DARK);
        return extent;
    }
}
