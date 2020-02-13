package com.lxt.ssm.service.impl;

import com.lxt.ssm.dao.IProductDao;
import com.lxt.ssm.domain.Product;
import com.lxt.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(String productId) throws Exception {
        productDao.delete(productId);
    }

}
