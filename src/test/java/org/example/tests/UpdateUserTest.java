package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UpdateUserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest {

    @Test
    public void updateUser() {

        UpdateUserRequest request =
                new UpdateUserRequest(
                        "Kaviya",
                        "Senior QA Engineer"
                );

        APIResponse response =
                ApiClient.put(
                        ApiEndpoints.USERS + "/2",
                        request
                );

        System.out.println("Status Code : " + response.status());
        System.out.println("Response : ");
        System.out.println(response.text());

        Assert.assertEquals(response.status(), 200);
    }
}