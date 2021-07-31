package com.qatest.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private final ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
    private static final DriverFactory driverFactory=new DriverFactory();
    private DriverFactory(){
    }
    public static DriverFactory getInstance(){
        return driverFactory;
    }
    public void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }
    public WebDriver getDriver(){
       return threadLocal.get();
    }
    public void closeDriver(){
        threadLocal.get().quit();
        threadLocal.remove();
    }
}
