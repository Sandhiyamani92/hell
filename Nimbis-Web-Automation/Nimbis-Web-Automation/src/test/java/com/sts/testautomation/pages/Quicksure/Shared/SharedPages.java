package com.sts.testautomation.pages.Quicksure.Shared;

import com.sts.testautomation.core.pages.BasePage;
import org.openqa.selenium.WebDriver;


public class SharedPages extends BasePage {

    public SharedPages(WebDriver driver, int rowIndex) {
        super(driver, rowIndex);
        super.description = this.getClass().getSimpleName();
    }

    /***********************************
     ************** Steps **************
     ***********************************/
    public SharedPages navigateToUrl(String url) {
        navigate(url);
        return this;
    }

    public SharedPages enterLoginCredentials(String username, String password) {

        return this;
    }
}
