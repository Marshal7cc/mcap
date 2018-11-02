package com.marshal.mcap.account.mapper;

import com.marshal.mcap.account.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends Mapper<SysUser> {

    List<Map> getUserOptions();
}