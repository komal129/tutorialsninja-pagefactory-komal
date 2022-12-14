package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.HpProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;


public class DesktopTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    HpProductPage hpProductPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        desktopPage = new DesktopPage();
        hpProductPage = new HpProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Desktops");
        Map<String, ArrayList> mapArrays = desktopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.clickOnCurrency();
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All DeskTops");
        desktopPage.sortByName();
        desktopPage.clickOnHpProduct();
        Assert.assertEquals(hpProductPage.HpTextErrorMessage(), "HP LP3065", "HP LP3065 Product not display");
        hpProductPage.selectDate("2022","November","30");
        hpProductPage.changeProductQuantity();
        hpProductPage.clickOnAddToCartButton();
        Assert.assertEquals(hpProductPage.addToCartErrorMessage(), "HP LP3065");
        hpProductPage.clickOnShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.shoppingCartTextErrorMessage(),"Shopping Cart  (1.00kg)", "Shopping cart is not displayed" );
        Assert.assertEquals(shoppingCartPage.productNameErrorMessage(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2022-11-30"), "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.modelErrorMessage(),"Product 21","Model not matched" );
        Assert.assertEquals(shoppingCartPage.priceTotalErrorMessage(),"£74.73", "Total not matched" );
    }

}
