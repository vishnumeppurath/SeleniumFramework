package com.qatest.pageobjects;

import com.qatest.reusablecomponents.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class VehicleDataPage {
    @FindBy(id = "make")
    private WebElement make;
    @FindBy(id = "engineperformance")
    private WebElement enginePerformance;
    @FindBy(xpath = "//input[@id='engineperformance']//following-sibling::span[@class='error']")
    private WebElement enginePerformanceError;
    @FindBy(id = "dateofmanufacture")
    private WebElement dateOfManufacture;
    @FindBy(id="numberofseats")
    private WebElement numberOfSeats;

    public VehicleDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMake(String value){
        CommonMethods.selectOptionByVisibleText(make,value);
    }
    public void enterEnginePerformance(String value) {
        enginePerformance.sendKeys(value);
    }

    public String getEnginePerformanceErrorText() {
        return enginePerformanceError.getText();
    }

    public void enterDateOfManufacture(String value){
        dateOfManufacture.sendKeys(value);
    }
    public void selectNumberOfSeats(String value){
        CommonMethods.selectOptionByVisibleText(numberOfSeats,value);
    }
    public void enterVehicleData(Map<String,String> testData){
        selectMake(testData.get("Make"));
        enterEnginePerformance(testData.get("Engine Performance [kW]"));
        enterDateOfManufacture(testData.get("Date of Manufacture"));
        selectNumberOfSeats(testData.get("Number of Seats"));
    }
}
