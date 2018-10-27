package com.marshal.mcap.account.mapper;

import com.marshal.mcap.account.entity.SysUser;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> selectByCondition(SysUser condition);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}