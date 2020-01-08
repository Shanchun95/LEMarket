package com.phonemarket.controller;

import com.phonemarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("findTotalOrder")
    @ResponseBody
    public Integer findTotalOrder(){
        Integer order = orderService.findTotalOrder();
        return order;
    }
    @RequestMapping("findReadPayOrder")
    @ResponseBody
    public Integer findReadPayOrder(){
        Integer order = orderService.findTotalOrder();
        return order;
    }

    @RequestMapping("findReadyToDeliverOrd")
    @ResponseBody
    public Integer findReadyToDeliverOrd(){
        Integer order = orderService.findTotalOrder();
        return order;
    }

    @RequestMapping("takeOrder")
    @ResponseBody
    public Integer takeOrder(Integer addr, Integer goodslist){
//        Integer order = orderService.takeOrder();
        return null;
    }
}
