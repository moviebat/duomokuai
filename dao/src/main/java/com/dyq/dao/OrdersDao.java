package com.dyq.dao;

import com.dyq.domain.Orders;
import org.apache.ibatis.annotations.*;

/**
 * 不采用Mapper.xml文件配置，而是直接在Java里面写Sql
 */
@Mapper
public interface OrdersDao {
    @Select("select id, userId, price, content from s_orders where id = #{id}")
    Orders findOrdersById(@Param("Id") Long Id);

    @Select("select id, userId, price, content from s_orders where userId = #{userId}")
    Orders findOrdersByUserId(@Param("userId") Long userId);

    @Insert("insert into s_orders(id,userId, price, content) values (#{Id},#{userId}, #{price}, #{content})")
    int insertOrders(@Param("Id") Long Id,@Param("userId") Long userId, @Param("price") Double price, @Param("content") String content);

    @Delete("delete from s_orders where id = #{orderId}")
    int deleteOrders(@Param("orderId") Long orderId);

    @Update("update s_orders set content = #{content} where id = #{Id}")
    int updateOrdersById(@Param("content") String content, @Param("Id") Long Id);

    @Update("update s_orders set content = #{content} where userId = #{userId}")
    int updateOrdersByUserId(@Param("content") String content, @Param("userId") Long userId);
}
