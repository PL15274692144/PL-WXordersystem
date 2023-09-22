package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 分页条件查询并按下单时间排序
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);

    /**
     * 根据状态统计订单数量
     * @param status
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer status);

    /**
     * 获取超时订单
     * @param status
     * @param localDateTime
     * @return
     */
    @Select("select * from orders where status = #{status} and order_time < #{localDateTime}")
    List<Orders> getBtStatusAdnOrderTimeLT(Integer status, LocalDateTime localDateTime);

    /**
     * 根据id查询用户的所有订单
     * @param userId
     * @return
     */
    @Select("select * from orders where user_id = #{userId}")
    List<Orders> list(Long userId);

    /**
     * 每天完成的订单的金额总和
     * @param map
     * @return
     */
    Double sumByMap(Map map);

    /**
     * 根据指定的时间和状态查询订单
     * @param map
     * @return
     */
    Integer getOrderCount(Map map);

    /**
     * 根据指定的时间查询销量前10的菜品
     * @param beginTime
     * @param endTime
     * @return
     */
    List<GoodsSalesDTO> getSalesTop10(@Param("begin") LocalDateTime begin, @Param("end") LocalDateTime end);

}
