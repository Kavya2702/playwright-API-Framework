package org.example.tests.Validators;

import org.example.models.UserResponse;
import org.testng.Assert;

public class ResponseValidator {

    public static void validateStatus(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void validateUser(UserResponse response,
                                    String expectedName,
                                    String expectedJob) {

        Assert.assertEquals(response.getName(), expectedName);
        Assert.assertEquals(response.getJob(), expectedJob);

        Assert.assertNotNull(response.getId());
    }
}