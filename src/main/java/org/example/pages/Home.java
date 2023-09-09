package org.example.pages;

import org.example.Base;
import org.example.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Home extends Base {

    @FindBy(id = "nav-hamburger-menu")
    WebElement sideMenu;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[14]")
    WebElement viewAll;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/ul/li[11]")
    WebElement videoGames;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[32]/li[3]/a")
    WebElement showAllVideoGames;

    @FindBy(xpath = "//*[@id=\"s-refinements\"]/div[2]/ul/li")
    WebElement freeShippingFilter;
    @FindBy(xpath = "//*[@id=\"p_n_condition-type/28071525031\"]/span/a")
    WebElement newProductsFilter;
    @FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]")
    WebElement sortButton;

    @FindBy(xpath = "//*[@id=\"s-result-sort-select_2\"]")
    WebElement highToLowSelection;
    @FindBy(className = "s-asin")
    WebElement products;
    @FindBy(className = "s-pagination-next")
    WebElement next;

    List<String> all = new ArrayList<>();


    public Home(WebDriver driver) {
        super(driver);
        URL = "https://www.amazon.eg/";
        initElements(this);
        driver.manage().window().maximize();
        visit();
    }

    private void performSideMenuClick() {
        performWaitForElement(sideMenu);
        sideMenu.click();
    }

    private void setViewAll() {
        performWaitForElement(viewAll);
        viewAll.click();
    }

    private void selectVideoGame() {
        performWaitForElement(videoGames);
        videoGames.click();
    }

    private void setShowAllVideoGames() {
        performWaitForElement(showAllVideoGames);
        showAllVideoGames.click();
    }

    private void setFreeShippingFilter() {
        performWaitForElement(freeShippingFilter);
        freeShippingFilter.click();
    }

    private void setNewProductsFilter() {
        performWaitForElement(newProductsFilter);
        newProductsFilter.click();
    }

    private void setSortButton() {
        performWaitForElement(sortButton);
        sortButton.click();
    }

    private void selectHighToLowSelection() {
        performWaitForElement(highToLowSelection);
        highToLowSelection.click();
    }

    private void sortProducts() {
        setSortButton();
        selectHighToLowSelection();
    }


    private void setProducts() {
        performWaitForElement(products);
        List<WebElement> elements = driver.findElements(By.className("a-price-whole"));
        List<WebElement> filteredElements = WebElementUtils.filterElementsByValueBelow(elements);

         for (int i = 0; i <= filteredElements.size()-1; i++) {
             addToCart(filteredElements.get(i));
             elements = driver.findElements(By.className("a-price-whole"));
             filteredElements = WebElementUtils.filterElementsByValueBelow(elements);

        }
        all.addAll(filteredElements.stream().map(WebElement::getText).collect(Collectors.toUnmodifiableList()));

         performWaitForClickElement(next);
         if (next.isEnabled() && next.isDisplayed()) {
             next.click();
             setProducts();
         } else {
             goToCart();
         }
    }

    private void goToCart() {

    }

    private void addToCart(WebElement element) {
        System.out.println(element.getText());
        element.click();
        new Details(driver).addToCart();
        driver.navigate().back();
    }


    public void startTestCycle() {
        performSideMenuClick();
        setViewAll();
        selectVideoGame();
        setShowAllVideoGames();
        setFreeShippingFilter();
        setNewProductsFilter();
        sortProducts();
        setProducts();

    }
}
