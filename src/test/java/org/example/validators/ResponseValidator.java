package org.example.validators;

import com.microsoft.playwright.APIResponse;
import org.example.models.UserResponse;
import org.testng.Assert;

public class ResponseValidator {

    /**
     * Validate HTTP Status Code
     */
    public static void validateStatus(APIResponse response, int expectedStatus) {

        Assert.assertEquals(
                response.status(),
                expectedStatus,
                "Status Code Validation Failed!"
        );
    }

    /**
     * Validate User Response
     */
    public static void validateUser(UserResponse response,
                                    String expectedName,
                                    String expectedJob) {

        Assert.assertEquals(
                response.getName(),
                expectedName,
                "Name Validation Failed!"
        );

        Assert.assertEquals(
                response.getJob(),
                expectedJob,
                "Job Validation Failed!"
        );

        Assert.assertNotNull(
                response.getId(),
                "User ID should not be null!"
        );
    }
}