package com.qatest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LandingPageTest {
    ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Star time"+java.time.LocalDateTime.now());
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("End time"+java.time.LocalDateTime.now());
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        threadLocal.set(driver);
        //driver.manage().window().maximize();
        threadLocal.get().get("http://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing " + threadLocal.get().hashCode());
        threadLocal.get().quit();
    }

    @Test
    public void CheckPageTitle() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Demo Web Shop");
    }

    @Test
    public void CheckCategoryItem() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        List<WebElement> categoryElements = driver.findElements(By.xpath("//div[@class=\"block block-category-navigation\"]//div[2]//li//a"));
        List<String> categories = categoryElements.stream().map(WebElement::getText).collect(Collectors.toList());
        categories.forEach(System.out::println);
        Assert.assertTrue(categories.contains("Computers"));
    }

    @Test
    public void CheckPageTitle1() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Demo Web Shop");
    }

    @Test
    public void CheckCategoryItem1() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        List<WebElement> categoryElements = driver.findElements(By.xpath("//div[@class=\"block block-category-navigation\"]//div[2]//li//a"));
        List<String> categories = categoryElements.stream().map(WebElement::getText).collect(Collectors.toList());
        categories.forEach(System.out::println);
        Assert.assertTrue(categories.contains("Computers"));
    }

    @Test
    public void CheckPageTitle2() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Demo Web Shop");
    }

    @Test
    public void CheckCategoryItem2() {
        WebDriver driver = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + "-" + driver.hashCode());
        List<WebElement> categoryElements = driver.findElements(By.xpath("//div[@class=\"block block-category-navigation\"]//div[2]//li//a"));
        List<String> categories = categoryElements.stream().map(WebElement::getText).collect(Collectors.toList());
        categories.forEach(System.out::println);
        Assert.assertTrue(categories.contains("Computers"));
    }
}
