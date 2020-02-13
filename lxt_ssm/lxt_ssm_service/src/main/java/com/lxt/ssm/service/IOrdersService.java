package com.lxt.ssm.service;

import com.lxt.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;

    void delete(String ordersId) throws Exception;
}
