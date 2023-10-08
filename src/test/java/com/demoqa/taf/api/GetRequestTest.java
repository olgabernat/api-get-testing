package com.demoqa.taf.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetRequestTest {
    @DisplayName("Check code status")
    @Test
    public void testGetStatusCode() throws Exception {
        String url = "https://demoqa.com/BookStore/v1/Books";

        HttpGet get = new HttpGet(url);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(get);

        Assertions.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }

    @DisplayName("Response content check")
    @Test
    public void testGetResponse() throws Exception {
        String url = "https://demoqa.com/BookStore/v1/Books";

        HttpGet get = new HttpGet(url);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(get);

        String responseBody = EntityUtils.toString(httpResponse.getEntity());
        Assertions.assertTrue(responseBody.contains("Git"));
    }
}
