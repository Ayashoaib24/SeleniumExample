package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {
    protected WebDriver driver;
    private final WebDriverWait wait;
    protected String URL;
    protected Base(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    protected void initElements(Object child){
        PageFactory.initElements(driver, child);
    }

    public void visit(){
        this.driver.get(URL);
    }
    protected void performWaitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    } protected void performWaitForClickElement(WebElement element){
       wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void performWaitForElements(List<WebElement> element){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
