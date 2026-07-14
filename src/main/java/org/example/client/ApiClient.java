package org.example.client;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.example.config.ConfigReader;
import org.example.utils.HeaderManager;
import org.example.utils.JsonUtils;

public class ApiClient {

    private static final Playwright playwright = Playwright.create();

    private static final APIRequestContext requestContext =
            playwright.request().newContext(
                    new APIRequest.NewContextOptions()
                            .setIgnoreHTTPSErrors(true)
                            .setExtraHTTPHeaders(HeaderManager.getDefaultHeaders())
            );

    /**
     * GET Request
     */
    public static APIResponse get(String endpoint) {

        String url = ConfigReader.getProperty("base.url") + endpoint;

        System.out.println("GET : " + url);

        return requestContext.get(url);
    }

    /**
     * POST Request
     */
    public static APIResponse post(String endpoint, Object requestBody) {

        String url = ConfigReader.getProperty("base.url") + endpoint;

        String jsonBody = JsonUtils.toJson(requestBody);

        System.out.println("POST : " + url);
        System.out.println("Request Body : " + jsonBody);

        return requestContext.post(
                url,
                RequestOptions.create()
                        .setData(jsonBody)
        );
    }

    /**
     * Close Playwright
     */
    public static void close() {
        requestContext.dispose();
        playwright.close();
    }
}