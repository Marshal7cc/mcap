package com.marshal.mcap.account.service;

import com.marshal.mcap.account.entity.SysUser;
import com.marshal.mcap.system.entity.ResponseData;
import com.marshal.mcap.system.service.BaseService;
import com.marshal.mcap.system.service.impl.BaseServiceImpl;

import java.util.List;
import java.util.Map;

public interface SysUserService{

    List<SysUser> select(SysUser condition, int pageNum, int pageSize);

    public SysUser selectByPrimaryKey(Long id);

    public void save(SysUser SysUser);

    public void delete(Long[] idList);

    List<Map> getUserOptions();
}
