package com.lzitec.coronavirustrackerapp.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CoronaVirusDataService {

    private static final String DATA_URL = "URLConnection";
    private static final String GET = "GET";

    @PostConstruct
    public void fetchCoronaVirusData() throws IOException {
        URL url = new URL(DATA_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        int status =  connection.getResponseCode();
        System.out.println("Response code = "+ status);
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

    }

}
