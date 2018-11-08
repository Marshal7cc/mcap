//控制层
app.controller("sysFunctionController", function ($scope, $controller, sysFunctionService,sysResourceService) {
    //继承
    $controller("baseController", {$scope: $scope});

    //初始化
    $scope.initForAdd = function () {
        $scope.sysFunction = {};
    }
    $scope.initForUpdate = function (id) {
        sysFunctionService.queryById(id).success(function (data) {
            $scope.sysFunction = data;
        });
    }

    //crud
    //查询,初始化查询条件为空
    $scope.condition = {};
    $scope.query = function (pageNum, pageSize) {
        sysFunctionService.query(pageNum, pageSize, $scope.condition).success(function (data) {
            $scope.rows = data.rows;
            $scope.pageConf.totalItems = data.total;
        });
    }
    //保存
    $scope.save = function () {
        sysFunctionService.save($scope.sysFunction).success(function (responseData) {
            if (responseData.success) {
                $scope.reloadList();
                swal("", responseData.message, "success");
            } else {
                swal("", responseData.message, "info");
            }
        });
    }
    //批量删除
    $scope.delete = function () {
        if($scope.selectedIds.length==0){
            swal("", "未选择数据!", "info");
            return ;
        }
        swal({
                title: "",
                text: "确定删除？",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确认",
                cancelButtonText: "取消"
            },
            function (isConfirm) {
                if (isConfirm) {
                    sysFunctionService.delete($scope.selectedIds).success(function (responseData) {
                        if (responseData.success) {
                            $scope.reloadList();
                            debugger;
                            swal("", responseData.message, "success");
                        } else {
                            swal("", responseData.message, "info");
                        }
                    });
                }
            });
    }
    //获取下拉框数据
    //防止ajax异步导致为空，声明一个空的
    $scope.sysResourceOptions = {data: []};
    $scope.getResourceOptions = function () {
        sysResourceService.getResourceOptions().success(function (data) {
            $scope.sysResourceOptions = {data: data};
        });
    }

    $scope.sysFunctionOptions = {data: []};
    $scope.getFunctionOptions = function () {
        sysFunctionService.getFunctionOptions().success(function (data) {
            $scope.sysFunctionOptions = {data: data};
        });
    }
});