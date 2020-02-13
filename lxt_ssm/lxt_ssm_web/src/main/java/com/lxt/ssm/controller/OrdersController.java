package com.lxt.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.lxt.ssm.domain.Orders;
import com.lxt.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;


    //分页查询订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> list = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //查询订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    //删除订单操作
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true)String ordersId) throws Exception{
        ordersService.delete(ordersId);
        return "redirect:findAll.do";
    }
}
