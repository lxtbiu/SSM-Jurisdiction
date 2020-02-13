package com.lxt.ssm.controller;


import com.lxt.ssm.domain.Product;
import com.lxt.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception{

        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

    //产品删除
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true)String productId) throws Exception{
        productService.delete(productId);
        return "redirect:findAll.do";
    }
}
