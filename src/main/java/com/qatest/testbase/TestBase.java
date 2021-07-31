package com.qatest.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.qatest.factory.BrowserFactory;
import com.qatest.factory.DriverFactory;
import com.qatest.pageobjects.HomePage;
import com.qatest.pageobjects.VehicleDataPage;
import com.qatest.reusablecomponents.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class TestBase {

    public static HomePage homePage;
    public static VehicleDataPage vehicleDataPage;
    public static ExtentReports extentReports;
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
        String browser = PropertiesLoader.getPropertyByKey("browser");
        BrowserFactory browserFactory = new BrowserFactory();
        DriverFactory.getInstance().setDriver(browserFactory.getBrowser(browser));
        driver = DriverFactory.getInstance().getDriver();
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertiesLoader.getPropertyByKey("url"));
        homePage = new HomePage(driver);
        vehicleDataPage = new VehicleDataPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeDriver();
    }
}
