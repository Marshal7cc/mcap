package com.marshal.mcap.function.controller;

import com.marshal.mcap.function.entity.SysFunction;
import com.marshal.mcap.function.service.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/5
 * Time: 22:06
 * Description:
 */
@RestController
@RequestMapping("/sys/function")
public class SysFunctionController {

    @Autowired
    SysFunctionService sysFunctionService;

    @RequestMapping("/getMenus")
    public List<SysFunction> getMenus(){
        List<SysFunction> topFunctionList = sysFunctionService.selectTopFunction();
        getChildFunctions(topFunctionList);
        return topFunctionList;
    }

    public List<SysFunction> getChildFunctions(List<SysFunction> topFunctionList){
        for(SysFunction item :topFunctionList){
            List<SysFunction> childList = sysFunctionService.selectChildFunction(item.getFunctionId());
            if(childList!=null&&childList.size()>0){
                item.setChildFunctions(childList);
                getChildFunctions(childList);
            }else{
                continue;
            }
        }
        return topFunctionList;
    }
}
