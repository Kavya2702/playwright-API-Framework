package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getSingleUser() {

        APIResponse response = ApiClient.get(ApiEndpoints.USERS + "/2");

        System.out.println("Status : " + response.status());
        System.out.println(response.text());

        Assert.assertEquals(response.status(), 200);
    }
}