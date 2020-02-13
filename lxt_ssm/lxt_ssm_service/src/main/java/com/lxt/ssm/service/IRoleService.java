package com.lxt.ssm.service;

import com.lxt.ssm.domain.Permission;
import com.lxt.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    void delete(String roleId) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

}
