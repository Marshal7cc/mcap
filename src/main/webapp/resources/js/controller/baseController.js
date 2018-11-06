/**
 * author:Marshal
 * description:angularJs基础controller
 */
app.controller("baseController",function ($scope) {
    //分页
    $scope.pageConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 5,
        perPageOptions: [5,10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };
    $scope.reloadList=function(){
        $scope.selectedIds=[];
        $scope.query($scope.pageConf.currentPage,$scope.pageConf.itemsPerPage);
    };

    //选中id动态更新
    $scope.selectedIds=[];
    $scope.updateSelected=function($event,id){
        if($event.target.checked){
            $scope.selectedIds.push(id);
        }else {
            var index=$scope.selectedIds.indexOf(id);
            $scope.selectedIds.splice(index,1);
        }
    }


    /**
     * 常用renderer函数
     * @param jsonStr
     * @returns {string}
     */
    //把json字符串转换成正常展示
    $scope.jsonRenderer=function (jsonStr) {
        var json=JSON.parse(jsonStr);
        var renderStr="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                renderStr+=",";
            }
            renderStr+=json[i].text;
        }
        return renderStr;
    }

    $scope.sysUserStatusRender=function (status) {
        if(status=="ACTV")
            return "正常";
        else
            return "冻结";
    }
});