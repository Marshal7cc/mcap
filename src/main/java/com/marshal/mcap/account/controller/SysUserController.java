package com.marshal.mcap.account.controller;

import com.marshal.mcap.account.entity.SysUser;
import com.marshal.mcap.account.service.SysUserService;
import com.marshal.mcap.system.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/10/26
 * Time: 20:35
 * Description:
 */
@RestController
@RequestMapping("/account/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/query")
    public ResponseData query(@RequestBody SysUser condition,int pageNum,int pageSize){
        return sysUserService.query(condition,pageNum,pageSize);
    }

    @RequestMapping("/save")
    public ResponseData save(@RequestBody SysUser sysUser){
        try{
            sysUserService.save(sysUser);
            return new ResponseData(true,"保存成功");
        }catch (Exception e){
            return new ResponseData(false,e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public ResponseData delete(@RequestParam("selectedIds")Long[] selectedIds){
        try{
            sysUserService.delete(selectedIds);
            return new ResponseData(true,"删除成功");
        }catch (Exception e){
            return new ResponseData(false,e.getMessage());
        }
    }

    @RequestMapping("/queryById")
    public SysUser queryById(@RequestParam("id")Long id){
        return sysUserService.queryById(id);
    }
}
