package com.lxt.ssm.service;

import com.lxt.ssm.domain.Product;


import java.util.List;

public interface IProductService {


    public List<Product> findAll() throws Exception;


    void save(Product product) ;

    void delete(String productId) throws Exception;
}
