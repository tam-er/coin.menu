package com.instachange.alpha;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pair {
    @JsonProperty("mid")
    double mid;
    @JsonProperty("bid")
    double bid;
    @JsonProperty("ask")
    double ask;
    @JsonProperty("last_price")
    double last_price;
    @JsonProperty("low")
    double low;
    @JsonProperty("high")
    double high;
    @JsonProperty("volume")
    double volume;
    @JsonProperty("timestamp")
    double timestamp;

    @JsonCreator
    public Pair(@JsonProperty("mid") double mid,@JsonProperty("bid") double bid, @JsonProperty("ask") double ask,
                @JsonProperty("last_price") double last_price, @JsonProperty("low") double low,
                @JsonProperty("high") double high,@JsonProperty("volume") double volume, @JsonProperty("timestamp")double timestamp) {
        this.mid = mid;
        this.bid = bid;
        this.ask = ask;
        this.last_price = last_price;
        this.low = low;
        this.high = high;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
