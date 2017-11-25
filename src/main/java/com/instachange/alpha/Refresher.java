package com.instachange.alpha;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

public class Refresher extends TimerTask {
    @Override
    public void run() {
        Controller.setPair(Controller.refreshBTC_USDPair("btcusd"));
    }
}
