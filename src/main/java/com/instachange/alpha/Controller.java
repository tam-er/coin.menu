package com.instachange.alpha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Controller {
    private static final String tickerUrl = "https://api.bitfinex.com/v1/pubticker/";
    static Pair pair;
    public enum HTTPMethods{
        GET,
        POST,
        DELETE
    }

    public static void setPair(Pair newpair) {
        pair = newpair;
    }

    public static Pair getPair() {
        return pair;
    }

    static public Pair refreshBTC_USDPair(String pair) {
        try {
            URL ticker = new URL(tickerUrl + pair);
            HttpURLConnection con = (HttpURLConnection) ticker.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int repsonseCode = con.getResponseCode();
            System.out.println("Response Code: " + repsonseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            String responseString = response.toString();
            System.out.println(responseString);
            ObjectMapper om = new ObjectMapper();
            Pair pairObj = om.readValue(responseString, Pair.class);
            return pairObj;
        } catch (MalformedURLException e) {
            System.err.println("Verbindung zum Server: " + tickerUrl + " kann nicht aufgebaut werden.");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    static public ResponseEntity<String> makeHTTPCall(HTTPMethods httpMethods, String URL){
        try {
            URL requestURL = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) requestURL.openConnection();
            con.setRequestMethod(httpMethods.name());
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int repsonseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responseString = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                responseString.append(inputLine);
            }
            in.close();
            String toReturn = responseString.toString();
            return new ResponseEntity<>(toReturn, HttpStatus.valueOf(repsonseCode));
        } catch (MalformedURLException e) {
            System.err.println("Verbindung zum Server: " + URL + " kann nicht aufgebaut werden.");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }



}
