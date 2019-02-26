package com.dyq.service.impl.impl;

import com.dyq.dao.OrdersDao;
import com.dyq.domain.Orders;
import com.dyq.service.impl.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mybatis-test
 * @ClassName: OrdersServiceImpl
 * @description:
 * @author: Dengyq
 * @create: 2019-02-25 16:17
 **/
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public Orders findOrdersById(Long Id) {
        return ordersDao.findOrdersById(Id);
    }

    @Override
    public Orders findOrdersByUserId(Long userId) {
        return ordersDao.findOrdersByUserId(userId);
    }

    @Override
    public void insertOrders(Long Id,Long userId, Double price, String content) {
        ordersDao.insertOrders(Id,userId, price, content);
// int max = 2/0; //正常情况下，代码执行到这报错，但是已经走了inserOrders方法。加上事物管理，他会把inserOrders方法回滚，你把注释放开看看
    }

    @Override
    public int deleteOrders(Long id) {
        return ordersDao.deleteOrders(id);
    }

    @Override
    public int updateOrdersById(String content, Long Id) {
        return ordersDao.updateOrdersById(content, Id);
    }


    @Override
    public int updateOrdersByUserId(String content, Long userId) {

        return ordersDao.updateOrdersByUserId(content, userId);
    }
}
