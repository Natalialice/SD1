package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class ProductsPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement title;

    private final String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "inventory.html");
    }

    public void addToCart(String productName) {
        By fullLocator = By.xpath(String.format(addToCartButton, productName));
        driver.findElement(fullLocator).click();
    }

    public void addToCart(String... productsName) {
        Arrays.asList(productsName).forEach(this::addToCart);
    }

    public WebElement getTitle() {
        return title;
    }
}
