package com.blockchain.demo.Controller;

import com.blockchain.demo.Entity.Order;
import com.blockchain.demo.Entity.User;
import com.blockchain.demo.Mapper.OrderMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author conanlee
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderMapper orderMapper;

    @GetMapping
    public List<Order> getOrderInfo(){
        return orderMapper.findAll();
    }

    @GetMapping("/{user_ID}")
    public List<Order> findOrderInfoByUserID(@PathVariable("user_ID") Integer user_ID){
        return orderMapper.findByUserID(user_ID);
    }

    @GetMapping("/{order_ID}")
    public List<Order> findOrderInfoByOrderID(@PathVariable("order_ID") String order_ID){
        return orderMapper.findByOrderID(order_ID);
    }

    @PostMapping
    public String addOrder(@RequestBody Order order){
        orderMapper.save(order);
        return "success";
    }

    @PutMapping("/updateByUID")
    public String updateOrderByUserID(@RequestBody Order order){
        orderMapper.updateByUserId(order);
        return "success";
    }

    @PutMapping("updateByOID")
    public String updateOrderByOrderID(@RequestBody Order order){
        orderMapper.updateByOrderId(order);
        return "success";
    }
}
