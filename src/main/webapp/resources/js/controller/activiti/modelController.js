//控制层
app.controller("modelController",function ($scope,$controller,modelService) {
    //继承
    $controller("baseController",{$scope:$scope});

    //初始化
    $scope.initForAdd=function(){
        $scope.model={};
    }
    $scope.initForUpdate=function(id){
        modelService.queryById(id).success(function(data){
            $scope.model=data;
        });
    }

    //crud
    //查询,初始化查询条件为空
    $scope.condition={};
    $scope.query=function (pageNum,pageSize) {
        modelService.query(pageNum,pageSize,$scope.condition).success(function (data) {
            $scope.rows=data.rows;
            $scope.pageConf.totalItems=data.total;
        });
    }
    //保存
    $scope.save=function () {
        $scope.modelRequest.version=1;
        $scope.modelRequest.metaInfo=JSON.stringify({
            name:$scope.modelRequest.name,
            version:$scope.modelRequest.version,
        });
        modelService.save($scope.modelRequest).success(function (modelRequest) {
            $scope.reloadList();
        });
    }
    //批量删除
    $scope.delete=function(){
        modelService.delete($scope.selectedIds).success(function (data) {
            if(data.success){
                $scope.reloadList();
            }else{
                alert(data.message);
            }
        });
    }
    //编辑模型
    $scope.edit=function (modelId) {
        var url = "../modeler.html?modelId="+modelId;
        window.open(url);
    }
});