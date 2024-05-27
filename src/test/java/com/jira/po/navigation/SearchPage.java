package com.jira.po.navigation;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends VerificationPage {

    @FindBy( id = "twotabsearchtextbox")
    private WebElementFacade searchInputElement;

    @FindBy(xpath="//input[@id='nav-search-submit-button' and @type='submit']")
    private WebElementFacade searchButtonElement;

    public void searchFor(String term) {
       searchInputElement.waitUntilPresent().type(term);
       searchButtonElement.click();
    }


}
