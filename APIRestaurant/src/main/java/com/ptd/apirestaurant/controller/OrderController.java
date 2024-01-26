package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.OrderDTO;
import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.entity.OrderDetail;
import com.ptd.apirestaurant.service.OrderDetailService;
import com.ptd.apirestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/api/order/create-order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO order){
        try {
            Order orderCreate = orderService.addOrder(order);
            if(orderCreate != null)
                return  new ResponseEntity<>(new SuccessResponse("200", "Success").toString(), HttpStatus.OK);
            else
                return new ResponseEntity<>(new FailureRepsone("Fail to create").toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex) {
            return new ResponseEntity<>(new FailureRepsone(ex.getMessage()).toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/api/order/make-order/{orderId}")
    public ResponseEntity<String> makeOrder(@RequestBody Map<Integer,Integer> listFood, @PathVariable("orderId") Integer orderID){
        String res = orderDetailService.makeOrder(listFood,orderID);
        if(res == "Success")
            return  new ResponseEntity<>(new SuccessResponse("200","Success").toString(), HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone(res).toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/api/order/change-table/{orderId}")
    public ResponseEntity<String> requestToChangeTable(@PathVariable("orderId") Integer orderID,@RequestBody Map<String, String> req){
        String res = orderService.requestToChangeTable(orderID, Integer.parseInt(req.get("tableID")));
        if(res == "Success")
            return  new ResponseEntity<>(new SuccessResponse("200","Success").toString(), HttpStatus.OK);
        if (res == "This table is not available")
            return  new ResponseEntity<>(new SuccessResponse("200",res).toString(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(new FailureRepsone(res).toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/api/order/finish-order/{orderId}")
    public  ResponseEntity<String> finishOrder(@PathVariable("orderId") int orderId){
        if(orderService.finshOrder(orderId)== true)
            return  new ResponseEntity<>(new SuccessResponse("200","Success").toString(), HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Failure").toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/api/order/delete/{orderId}")
    public  ResponseEntity<String> deleteOrder(@PathVariable("orderId") int orderId){
        return new ResponseEntity<>(new SuccessResponse("204",orderService.deleteOrder(orderId)).toString(),HttpStatus.OK);
    }

    @PatchMapping("/api/order/accept-or-denny/{id}")
    public  ResponseEntity<String> acceptOrDennyOrder(@PathVariable("id") int orderId, @RequestParam("type") int type){
        String res = orderService.acceptOrDennyOrder(orderId,type);
        if(res == "success")
            return new ResponseEntity<>(new SuccessResponse("200",res).toString(),HttpStatus.OK);
        else
            return new ResponseEntity<>(new FailureRepsone(res).toString(),HttpStatus.OK);
    }



    @GetMapping("/api/order/get-order-detail/{orderId}")
    ResponseEntity<List<OrderDetail>> getOrderDetailByOrder(@PathVariable("orderId") int orderId){
        return new ResponseEntity<>(orderDetailService.getOrderDetailByOrderId(orderId),HttpStatus.OK);
    }

}
