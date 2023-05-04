package com.blockchain.demo.Mapper;

import com.blockchain.demo.Entity.Order;
import com.blockchain.demo.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author conanlee
 */
public interface OrderMapper {

    @Select("Select * from order_info")
    List<Order> findAll();
    @Select("select * from order_info where user_ID = #{user_ID}")
    List<Order> findByUserID(Integer userID);

    @Select("select * from order_info where orderID = #{order_ID}")
    List<Order> findByOrderID(String orderID);

    @Update("INSERT INTO order_info(order_ID, user_ID, order_time, order_type, order_origin, order_destination, order_amount, order_fee, order_status) " +
            "VALUES (#{order_ID}, #{user_ID}, #{order_time}, #{order_type}, #{order_origin}, #{order_destination}, #{order_amount}, #{order_fee}, #{order_status})")
    @Transactional(rollbackFor = Exception.class)
    void save(Order order);


    @Update("UPDATE order_info SET order_ID = #{order_ID, order_time = #{order_time], order_type = #{order_type}, order_origin = #{order_origin}, order_destination = #{order_destination}, " +
            "order_amount = #{order_amount}, order_fee = #{order_fee}, order_status = #{order_status} WHERE user_ID = #{user_ID}}")
    @Transactional(rollbackFor = Exception.class)
    void updateByUserId(Order order);

    @Update("UPDATE order_info SET user_ID = #{user_ID}, order_time = #{order_time], order_type = #{order_type}, order_origin = #{order_origin}, " +
            "order_destination = #{order_destination}, order_amount = #{order_amount}, order_fee = #{order_fee}, order_status = #{order_status} WHERE order_ID = #{order_ID}")
    @Transactional(rollbackFor = Exception.class)
    void updateByOrderId(Order order);
}
