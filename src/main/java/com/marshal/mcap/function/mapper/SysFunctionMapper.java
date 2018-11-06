package com.marshal.mcap.function.mapper;

import com.marshal.mcap.function.entity.SysFunction;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysFunctionMapper extends Mapper<SysFunction> {

    List<SysFunction> selectTopFunctions();

    List<SysFunction> selectChildFunctions(Long functionId);
}