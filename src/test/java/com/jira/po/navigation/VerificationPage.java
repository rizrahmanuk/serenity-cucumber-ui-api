package com.jira.po.navigation;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class VerificationPage extends PageObject {
    private final String xpath = "//div[@data-csa-c-pos='1']//descendant::span[contains(.,'%s') and @class='a-size-medium a-color-base a-text-normal']";

    public void openPage(String url) {
        openUrl(url);
    }

    public boolean verifyResults(String resultText){
        String completedXPath = String.format(xpath, resultText);
        WebElementFacade resultFoundElement = find(By.xpath(completedXPath));
        return resultFoundElement.isCurrentlyVisible();
    }

}

