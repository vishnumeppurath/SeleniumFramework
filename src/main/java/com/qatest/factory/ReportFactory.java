package com.qatest.factory;

import com.aventstack.extentreports.ExtentTest;

public class ReportFactory {
    private static final ThreadLocal<ExtentTest> threadLocal=new ThreadLocal<>();
    private static final ReportFactory reportFactory=new ReportFactory();
    private ReportFactory(){
    }
    public static ReportFactory getInstance(){
        return reportFactory;
    }
    public  void setExtentTest(ExtentTest extentTest){
        threadLocal.set(extentTest);
    }
    public ExtentTest getExtentTest(){
        return threadLocal.get();
    }
    public void removeExtentTest(){
        threadLocal.remove();
    }
}
