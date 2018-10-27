package com.marshal.mcap.account.service;

import com.marshal.mcap.account.entity.SysUser;
import com.marshal.mcap.system.entity.ResponseData;

public interface SysUserService {

    ResponseData query(SysUser condition, int pageNum, int pageSize);

    public SysUser queryById(Long id);

    public void save(SysUser SysUser);

    public void delete(Long[] idList);
}
