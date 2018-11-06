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

    /**
     * 获取菜单
     * @return
     */
    @RequestMapping("/getMenus")
    public List<SysFunction> getMenuList(){
        List<SysFunction> topFunctionList = sysFunctionService.selectTopFunctions();
        getChildFunctions(topFunctionList);
        return topFunctionList;
    }
    /**
     * 递归填充最外层菜单的子菜单
     * @param functionList
     * @return
     */
    public List<SysFunction> getChildFunctions(List<SysFunction> functionList){
        for(SysFunction item :functionList){
            List<SysFunction> childList = sysFunctionService.selectChildFunctions(item.getFunctionId());
            if(childList!=null&&childList.size()>0){
                item.setChildFunctions(childList);
                getChildFunctions(childList);
            }else{
                continue;
            }
        }
        return functionList;
    }
}
