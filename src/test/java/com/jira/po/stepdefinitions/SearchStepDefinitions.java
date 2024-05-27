package com.jira.po.stepdefinitions;

import com.jira.po.navigation.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class SearchStepDefinitions {

    public SearchPage searchPage;

    @Given("user navigates to {string}")
    public void goToSite(String site) {
        searchPage.openPage(site);
    }

    @When("enter search term {string} on site")
    public void searchFor(String term) {
        searchPage.searchFor(term);
    }

    @Then("verify that the 1st result contains {string}")
    public void verifyResult(String resultText){
        assertTrue(resultText+" - NOT FOUND in 1st result of the search", searchPage.verifyResults(resultText));
    }

    @Then("close the browser")
    public void closeBrowser(){
        //close all active sessions
        searchPage.getDevTools().close();
        //quit and close all browser windows
        searchPage.getDriver().quit();
    }
}
