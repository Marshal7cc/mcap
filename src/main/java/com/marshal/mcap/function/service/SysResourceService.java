package com.marshal.mcap.function.service;

import com.marshal.mcap.function.entity.SysResource;

import java.util.List;

public interface SysResourceService {
    List<SysResource> select(SysResource condition, int pageNum, int pageSize);

    SysResource selectByPrimaryKey(Long id);

    void save(SysResource sysResource);

    void delete(Long[] idList);
}
