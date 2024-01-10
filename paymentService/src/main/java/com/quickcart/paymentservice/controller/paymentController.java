package com.quickcart.paymentservice.controller;


import com.quickcart.paymentservice.model.Message;
import com.quickcart.paymentservice.model.paymentRequestModel;
import com.quickcart.paymentservice.model.paymentResponseModel;
import com.quickcart.paymentservice.model.productModel;
import com.quickcart.paymentservice.service.payService;
import com.quickcart.paymentservice.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class paymentController {
    @Autowired
    productService productService1;
    @Autowired
    payService pay1;

    @PostMapping
    public Message pay(@RequestBody paymentResponseModel requestBody) {
        try {
            Long productId = requestBody.getId();
            String email = requestBody.getEmail();
            Long code = requestBody.getSecurityCode();
            productModel product = productService1.getProduct(productId);
            double price = product.getPrice();
            paymentRequestModel paymentRequest = new paymentRequestModel(email, code, (long) price);

            String result = pay1.getProduct(paymentRequest);

            // Check if the result is null and provide a default message
            String message = (result != null) ? result : "Empty response message";

            return new Message(message);
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            return new Message("Error processing payment: " + e.getMessage());
        }
    }
}
