package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
    /**
     * 根据状态和下单时间查询订单
     * @param status
     * @param orderTime
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrdertimeLT(Integer status, LocalDateTime orderTime);

    @Update("UPDATE orders SET " +
            "cancel_reason = #{cancelReason}, " +
            "cancel_time = #{cancelTime}, " +
            "pay_status = #{payStatus}, " +
            "pay_method = #{payMethod}, " +
            "status = #{status} " +
            "WHERE id = #{id}")
    void update(Orders order);


}