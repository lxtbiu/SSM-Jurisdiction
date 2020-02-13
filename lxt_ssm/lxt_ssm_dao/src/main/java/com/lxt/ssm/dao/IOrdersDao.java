package com.lxt.ssm.dao;

import com.lxt.ssm.domain.Member;
import com.lxt.ssm.domain.Orders;
import com.lxt.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select =
                    "com.lxt.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select =
                    "com.lxt.ssm.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select =
                    "com.lxt.ssm.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select =
                    "com.lxt.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId) throws Exception;

    @Delete("delete from orders where id = #{ordersId}")
    void delete(String ordersId) throws Exception;
}
