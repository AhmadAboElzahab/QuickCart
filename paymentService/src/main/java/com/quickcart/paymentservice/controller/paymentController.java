package com.quickcart.paymentservice.controller;


import com.quickcart.paymentservice.model.*;
import com.quickcart.paymentservice.service.mailService;
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
    @Autowired
    private mailService mail;

    @PostMapping
    public Message pay(@RequestBody paymentResponseModel requestBody) {
        try {
            Long productId = requestBody.getId();
            String email = requestBody.getEmail();
            Long code = requestBody.getSecurityCode();
            productModel product = productService1.getProduct(productId);
            double price = product.getPrice();
            paymentRequestModel paymentRequest = new paymentRequestModel(email, code, (long) price);

            mailModel m = new mailModel(email, price);
            String result = pay1.getProduct(paymentRequest);



          if(result != null) {
if(result=="Success"){
    String sendEmail = mail.sendEmail(m);
}
              return new Message(result);

          }

          else {

              return new Message(result);
          }


        } catch (Exception e) {

            return new Message("Error processing payment: " + e.getMessage());
        }
    }
}
