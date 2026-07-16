package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void deleteUser() {

        APIResponse response =
                ApiClient.delete(ApiEndpoints.USERS + "/2");

        System.out.println("Status Code : " + response.status());

        System.out.println("Response : ");

        System.out.println(response.text());

        Assert.assertEquals(response.status(), 204);
    }
}