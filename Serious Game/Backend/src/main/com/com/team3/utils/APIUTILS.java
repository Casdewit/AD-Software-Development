package com.team3.utils;

import spark.utils.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class APIUTILS {

    public static TestResponse request(String method, String path, String requestBody) {

        try {
            // create URL and fetch data from HTTP connection
            URL url = new URL("http://localhost:4567/" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }
    }
}
