package com.qatest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "nav_automobile")
    private WebElement automobile;
    @FindBy(id = "nav_motorcycle")
    private WebElement motorcycle;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAutomobile(){
        automobile.click();
    }
    public void clickMotorCycle(){
        motorcycle.click();
    }
}
