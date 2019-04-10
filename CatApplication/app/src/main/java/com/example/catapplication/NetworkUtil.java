package com.example.catapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtil {
    public static String API_KEY = "9037af91-05b7-488f-8bef-2677d56558bf";

    public static String downloadJSON(URL url) {
        try {
            HttpURLConnection httpurlcon = (HttpURLConnection) url.openConnection();
            httpurlcon.setRequestMethod("GET");
            httpurlcon.setRequestProperty("Content-Type",  "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(httpurlcon.getInputStream()));
            String line;
            StringBuffer out = new StringBuffer();
            do {
                line = reader.readLine();
                if (line != null) {
                    out.append(line).append("\n");
                }
            } while (line != null);
            return out.toString();

        } catch (Exception e) {
            Log.e("api", e.getMessage(), e);
        }
        return null;

    }

    public static Bitmap downloadImage(URL url) {
        Bitmap result = null;
        try {
            HttpURLConnection httpurlcon = (HttpURLConnection) url.openConnection();
            httpurlcon.setRequestMethod("GET");
            result = BitmapFactory.decodeStream(httpurlcon.getInputStream());

        } catch (Exception e) {
            Log.e("api", e.getMessage(), e);
        }
        return result;
    }
}
