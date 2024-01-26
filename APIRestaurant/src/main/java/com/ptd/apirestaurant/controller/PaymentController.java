package com.ptd.apirestaurant.controller;

import com.lowagie.text.DocumentException;
import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.entity.Payment;
import com.ptd.apirestaurant.service.PDFService;
import com.ptd.apirestaurant.service.PaymentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    PDFService pdfService;

    @PostMapping("/api/payment/create")
    ResponseEntity<String> createPayment(@RequestBody Map<String,String> req){
        int orderId = Integer.parseInt(req.get("orderId"));
        String res = paymentService.makePayment(orderId);
        if(res == "succes")
            return new ResponseEntity<>(new SuccessResponse("200","Success").toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new FailureRepsone(res).toString(),HttpStatus.OK);
    }
    @GetMapping ("/api/payment/confirm/{paymentId}")
    ResponseEntity<String> confirmPayment(@PathVariable("paymentId") int paymentId){
        String res = paymentService.confirmPayment(paymentId);
        if(res == "succes")
            return new ResponseEntity<>(new SuccessResponse("200","Success").toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new FailureRepsone(res).toString(),HttpStatus.OK);
    }

    @GetMapping("/api/payment/get-payment-by-order/{orderId}")
    ResponseEntity<Payment> getPaymentbyOrderID(@PathVariable("orderID") int orderId){
        return new ResponseEntity<>(paymentService.getPaymentByOrderId(orderId),HttpStatus.OK);
    }


    @GetMapping("/api/payment/get-all-payement")
    ResponseEntity<List<Object[]>> getAllPayment(@RequestParam Map<String, String> param){
        return new ResponseEntity<>(paymentService.getListPayementInRange(param), HttpStatus.OK);
    }

    @GetMapping("/api/pdf/payment")
    public void generatePDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename*=UTF-8''" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        response.addHeader("Content-Type", "application/pdf; charset=UTF-8");
        pdfService.export(response);
    }
}
