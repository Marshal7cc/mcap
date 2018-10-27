//控制层
app.controller("sysUserController",function ($scope,$controller,sysUserService) {
    //继承
    $controller("baseController",{$scope:$scope});

    //初始化
    $scope.initForAdd=function(){
        $scope.sysUser={};
    }
    $scope.initForUpdate=function(id){
        sysUserService.queryById(id).success(function(data){
            $scope.sysUser=data;
        });
    }

    //crud
    //查询,初始化查询条件为空
    $scope.condition={};
    $scope.query=function (pageNum,pageSize) {
        sysUserService.query(pageNum,pageSize,$scope.condition).success(function (data) {
            $scope.rows=data.rows;
            $scope.pageConf.totalItems=data.total;
        });
    }
    //保存
    $scope.save=function () {
        sysUserService.save($scope.sysUser).success(function (data) {
            if(data.success){
                $scope.reloadList();
            }else{
                alert(data.message);
            }
        });
    }
    //批量删除
    $scope.delete=function(){
        sysUserService.delete($scope.selectedIds).success(function (data) {
            if(data.success){
                $scope.reloadList();
            }else{
                alert(data.message);
            }
        });
    }
    //获取下拉框数据
    //防止ajax异步导致为空，声明一个空的
    $scope.sysUserOptions={data:[]};
    $scope.getOptions=function () {
        sysUserService.getOptions().success(function(data){
            $scope.sysUserOptions={data:data};
        });
    }
});