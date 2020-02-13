package com.lxt.ssm.dao;

import com.lxt.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductDao {

    //根据id查询结果
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Delete("delete from product where id = #{productId}")
    void delete(String productId);
}
