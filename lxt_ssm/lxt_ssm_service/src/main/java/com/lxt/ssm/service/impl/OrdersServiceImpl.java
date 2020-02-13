package com.lxt.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lxt.ssm.dao.IOrdersDao;
import com.lxt.ssm.domain.Orders;
import com.lxt.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //pageNum代表页码值，pageSize代表每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }

    //删除操作
    @Override
    public void delete(String ordersId) throws Exception {
        ordersDao.delete(ordersId);
    }
}
