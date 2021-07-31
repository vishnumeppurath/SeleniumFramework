package com.qatest.reusablecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods {
    public static List<String> getDropDownOptions(WebElement webElement){
        Select select=new Select(webElement);
        return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public static void selectOptionByVisibleText(WebElement webElement,String value){
        Select select=new Select(webElement);
        select.selectByVisibleText(value);
    }
}
