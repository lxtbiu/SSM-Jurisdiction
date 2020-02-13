package com.lxt.ssm.service.impl;

import com.lxt.ssm.dao.IPermissionDao;
import com.lxt.ssm.domain.Permission;
import com.lxt.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    //查询所有的权限
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void delete(String permissionId) throws Exception {
        permissionDao.delete(permissionId);
    }
}
