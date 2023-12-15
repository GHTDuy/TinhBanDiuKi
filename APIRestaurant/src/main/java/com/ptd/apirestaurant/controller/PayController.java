package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.enums.RequestType;
import com.ptd.apirestaurant.momoclasses.Environment;
import com.ptd.apirestaurant.momoclasses.PaymentResponse;
import com.ptd.apirestaurant.momoclasses.momoprocessor.CreateOrderMoMo;
import com.ptd.apirestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PayController {

    @Autowired
    OrderService orderService;

    @PostMapping("/api/pay/momo/{orderID}")
    public ResponseEntity<Map<String,String>> payWithMOMO(@PathVariable("orderID") int orderID) throws Exception {
        String orderInfo = "Pay for order "+ orderID;
        String returnURL = "https://google.com.vn";
        String notifyURL = "https://google.com.vn";
        String requestId = String.valueOf(System.currentTimeMillis());
        Environment environment = Environment.selectEnv("dev");
        Double amount = orderService.getTotalPriceOfOrder(orderID);
        String orderId = String.valueOf(System.currentTimeMillis());
        PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Integer.toString(amount.intValue()), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
        String url = captureWalletMoMoResponse.getPayUrl();
        Map<String ,String> res = new HashMap<>();
        res.put("payUrl",url);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
