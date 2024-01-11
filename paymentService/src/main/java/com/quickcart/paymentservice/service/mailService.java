package com.quickcart.paymentservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.quickcart.paymentservice.model.Message;
import com.quickcart.paymentservice.model.paymentRequestModel;
import com.quickcart.paymentservice.model.productModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class mailService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProductFallbackMethod")
    public String getProduct(paymentRequestModel paymentRequest) {
    
    }

    public String getProductFallbackMethod(paymentRequestModel paymentRequest) {
        // Log the fallback or handle it according to your application's needs
        return "Fallback Message";
    }
}