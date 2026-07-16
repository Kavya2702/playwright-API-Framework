package org.example.tests;

import com.microsoft.playwright.APIResponse;
import org.example.client.ApiClient;
import org.example.constants.ApiEndpoints;
import org.example.models.UpdateUserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchUserTest {

    @Test
    public void patchUser() {

        UpdateUserRequest request =
                new UpdateUserRequest(
                        null,
                        "Lead QA Engineer"
                );

        APIResponse response =
                ApiClient.patch(
                        ApiEndpoints.USERS + "/2",
                        request
                );

        Assert.assertEquals(response.status(), 200);
    }
}
