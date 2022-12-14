package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
       homePage.mouseHoverToDesktopAndClick();
       homePage.selectMenu("Show All Desktops");
       String expectedDesktopText = "Desktops";
       Assert.assertEquals(desktopPage.navigateToDesktopErrorMessage(), expectedDesktopText, "Desktops is not displayed");
    }

   @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(laptopsAndNotebooksPage.navigateToLaptopsNotebooksErrorMessage(), "Laptops & Notebooks", "Show All Laptops & Notebooks not displayed");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.mouseHoverToComponentsAndClick();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(componentsPage.navigateToComponentsErrorMessage(), "Components", "Text not displayed" );
    }
}
