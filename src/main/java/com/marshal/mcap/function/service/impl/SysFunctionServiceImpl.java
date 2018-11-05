package com.marshal.mcap.function.service.impl;

import com.github.pagehelper.PageHelper;
import com.marshal.mcap.function.entity.SysFunction;
import com.marshal.mcap.function.mapper.SysFunctionMapper;
import com.marshal.mcap.function.service.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/5
 * Time: 22:03
 * Description:
 */
@Service
public class SysFunctionServiceImpl implements SysFunctionService {

    @Autowired
    SysFunctionMapper sysFunctionMapper;

    @Override
    public List<SysFunction> select(SysFunction condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sysFunctionMapper.select(condition);
    }

    @Override
    public SysFunction selectByPrimaryKey(Long id) {
        return sysFunctionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(SysFunction sysFunction) {

    }

    @Override
    public void delete(Long[] idList) {

    }

    @Override
    public List<SysFunction> selectTopFunction() {
        return sysFunctionMapper.selectTopFunction();
    }

    @Override
    public List<SysFunction> selectChildFunction(Long functionId) {
        return sysFunctionMapper.selectChildFunction(functionId);
    }

    @Override
    public Integer selectChildFunctionCount(Long functionId) {
        return sysFunctionMapper.selectChildFunctionCount(functionId);
    }
}
