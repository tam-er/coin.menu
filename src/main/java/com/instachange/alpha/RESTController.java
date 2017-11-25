package com.instachange.alpha;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RESTController {

    @RequestMapping("/ticker")
    public Pair index(@RequestParam(value="pair", defaultValue="btcusd") String pair){
        return Controller.getPair();
    }

    @RequestMapping("/wallet")
    public String generateWallet(){
        /*return Controller.makeHTTPCall(Controller.HTTPMethods.GET, "");*/
        return"";
    }
}
