package com.dyq.web.controller;

import com.dyq.domain.Orders;
import com.dyq.service.impl.impl.OrdersServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mybatis-test
 * @ClassName: OrdersController
 * @description:
 * @author: Dengyq
 * @create: 2019-02-25 16:19
 **/
@RestController
@RequestMapping(value = "/order")
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersService;

    /**
     *查询用户下的订单
     * @param Id 传一个userName--@Param-课直接接收前端传递过来的值，取代传统的request.getParameter();
     * @return
     */
    @GetMapping(value = "/findOrdersByUserId")
    public Orders findOrdersByUserId(@Param("Id") Long Id){

        Orders order = ordersService.findOrdersByUserId(Id);

        return order;
    }

    /**
     * 给用户插入一条订单
     * @param userId
     * @param price
     * @param content
     * @return
     */
    @GetMapping(value = "/insertOrders")
    @ResponseBody
    public Object insertOrders(@Param("userId") Long userId,
                               @Param("Id") Long Id,
                               @Param("price") Double price,
                               @Param("content") String content){
        Map<String,Object> data = new HashMap<>();

        ordersService.insertOrders(Id,userId, price, content);
        data.put("message", "添加成功");
        data.put("code", "0");

        return data;
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @GetMapping(value = "/deleteOrders")
    @ResponseBody
    public Object deleteOrders(@Param("orderId") Long orderId){
        System.out.println("orderId is "+orderId);
        Map<String,Object> data = new HashMap<>();
        int count = ordersService.deleteOrders(orderId);
        data.put("count",count);
        return data;
    }

    /**
     * 更新订单数据
     * @param Id
     * @param content
     * @return
     */
    @GetMapping(value = "/updateOrdersById")
    @ResponseBody
    public Object updateOrdersById(@Param("Id")Long Id, @Param("content") String content){
        Map<String,Object> data = new HashMap<>();

        int count = ordersService.updateOrdersById(content, Id);
        if (count > 0) {
            data.put("message", "修改成功");
            data.put("code", "0");
        }else {
            data.put("message", "修改失败");
            data.put("code", "1");
        }

        return data;
    }

    /**
     * 更新订单数据
     * @param userId
     * @param content
     * @return
     */
    @GetMapping(value = "/updateOrdersByUserId")
    @ResponseBody
    public Object updateOrdersByUserId(@Param("userId")Long userId, @Param("content") String content){
        Map<String,Object> data = new HashMap<>();

        int count = ordersService.updateOrdersByUserId(content, userId);
        if (count > 0) {
            data.put("message", "修改成功");
            data.put("code", "0");
        }else {
            data.put("message", "使用UserId修改订单content失败");
            data.put("code", "1");
        }
        return data;
    }

}
