package com.lxt.ssm.controller;

import com.lxt.ssm.domain.Permission;
import com.lxt.ssm.domain.Role;
import com.lxt.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    //查询所有的角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    //新建角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //角色删除
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true)String roleId) throws Exception{
        roleService.delete(roleId);
        return "redirect:findAll.do";
    }

    //根据roleId查询role，并查询可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        //根据角色id查询角色，roleId查询role
        Role role =roleService.findById(roleId);
        //根据角色id查询可以添加的权限，roleId查询permission
        List<Permission> list = roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",list);
        mv.setViewName("role-permission-add");
        return mv;
    }

    // 给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds ) throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

}
