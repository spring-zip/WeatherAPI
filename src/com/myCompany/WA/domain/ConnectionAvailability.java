package com.myCompany.WA.domain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class ConnectionAvailability {

    public static boolean isWebsiteReachable(String website) {
        try {
            URL url = new URL(website);

            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {
            return false;

        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
