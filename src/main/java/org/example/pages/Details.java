package org.example.pages;

import org.example.Base;
import org.example.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Details extends Base {
   @FindBy(id = "add-to-cart-button")
    WebElement addToCart;

    public Details(WebDriver driver) {
        super(driver);
        initElements(this);
    }


    public void addToCart() {
        performWaitForElement(addToCart);
        addToCart.click();
        driver.navigate().back();
    }

}