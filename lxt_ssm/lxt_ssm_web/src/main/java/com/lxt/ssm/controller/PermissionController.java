package com.lxt.ssm.controller;

import com.lxt.ssm.domain.Permission;
import com.lxt.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //查询所有的权限
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> list = permissionService.findAll();
        mv.addObject("permissionList", list);
        mv.setViewName("permission-list");
        return mv;
    }

    //新增权限
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    //删除权限操作
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true)String permissionId) throws Exception{
        permissionService.delete(permissionId);
        return "redirect:findAll.do";
    }
}
