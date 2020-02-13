package com.lxt.ssm.service;

import com.lxt.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void delete(String permissionId) throws Exception;
}
