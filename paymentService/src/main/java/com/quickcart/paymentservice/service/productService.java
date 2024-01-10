package com.quickcart.paymentservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.quickcart.paymentservice.model.productModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class productService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getProductFallbackMethod")
    public productModel getProduct(Long id) {
        productModel product = new productModel();

        product = restTemplate.getForObject("http://productService/product/" + id, productModel.class);


        return product;
    }

    public productModel getProductFallbackMethod(int id){
        productModel p = new productModel();
        return p;
    }

}