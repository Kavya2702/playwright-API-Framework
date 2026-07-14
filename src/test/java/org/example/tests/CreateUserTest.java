package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void createUser() {

        UserRequest request =
                new UserRequest("Kaviya", "QA Engineer");

        APIResponse response =
                ApiClient.post(ApiEndpoints.USERS, request);

        System.out.println("Status Code : " + response.status());
        System.out.println("Response : ");
        System.out.println(response.text());

        Assert.assertEquals(response.status(), 201);
    }
}