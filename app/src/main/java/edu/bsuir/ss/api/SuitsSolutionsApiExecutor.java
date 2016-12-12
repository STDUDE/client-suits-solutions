package edu.bsuir.ss.api;

import android.net.Uri;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Antony on 04.12.2016.
 */
public class SuitsSolutionsApiExecutor {

    private static final int readTimeout = 10000;
    private static final int connectTimeout = 15000;

    private String url;
    public JSONObject params;

    public SuitsSolutionsApiExecutor(String url) {

    }

    public void post() {
        new Thread() {
            @Override
            public void run() {
                try

                {
                    URL url = new URL("https://timebase-server.herokuapp.com/api/login");

                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setReadTimeout(readTimeout);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    Uri.Builder builder = new Uri.Builder();
                    builder.appendQueryParameter("user_name", "antony_stdude");
                    builder.appendQueryParameter("password", "antony_stdude");
                    String query = builder.build().getEncodedQuery();
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();

                    StringBuffer jsonString = new StringBuffer();
                    int response = conn.getResponseCode();
                    if (response == HttpURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line;
                        while((line = br.readLine()) != null){
                            jsonString.append(line);
                        }
                        br.close();
                        //bis is your json do whatever you want with it
                    }
                    String result = jsonString.toString();
                    conn.disconnect();
                }

                catch(Exception e) {

                }
            }
        }.start();
    }

    public void get() {

    }
}
