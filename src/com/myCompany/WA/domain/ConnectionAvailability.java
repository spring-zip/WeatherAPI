package com.myCompany.WA.domain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionAvailability {
    public boolean isNetworkReachable() {
        try {
            URL url = new URL("https://google.com/");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            Object objData = urlConnect.getContent();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
