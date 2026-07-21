package org.example.dataprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "userData")
    public Object[][] userData() {

        return new Object[][]{

                {"Kaviya", "QA Engineer"}

        };
    }
}