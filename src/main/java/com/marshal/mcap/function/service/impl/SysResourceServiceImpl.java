package com.marshal.mcap.function.service.impl;

import com.github.pagehelper.PageHelper;
import com.marshal.mcap.function.entity.SysResource;
import com.marshal.mcap.function.mapper.SysResourceMapper;
import com.marshal.mcap.function.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/5
 * Time: 22:01
 * Description:
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> select(SysResource condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sysResourceMapper.select(condition);
    }

    @Override
    public SysResource selectByPrimaryKey(Long id) {
        return sysResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(SysResource sysResource) {

    }

    @Override
    public void delete(Long[] idList) {

    }
}
