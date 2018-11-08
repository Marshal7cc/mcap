//控制层
app.controller("sysResourceController", function ($scope, $controller, sysResourceService) {
    //继承
    $controller("baseController", {$scope: $scope});

    //初始化
    $scope.initForAdd = function () {
        $scope.sysResource = {};
    }
    $scope.initForUpdate = function (id) {
        sysResourceService.queryById(id).success(function (data) {
            $scope.sysResource = data;
        });
    }

    //crud
    //查询,初始化查询条件为空
    $scope.condition = {};
    $scope.query = function (pageNum, pageSize) {
        sysResourceService.query(pageNum, pageSize, $scope.condition).success(function (data) {
            $scope.rows = data.rows;
            $scope.pageConf.totalItems = data.total;
        });
    }
    //保存
    $scope.save = function () {
        sysResourceService.save($scope.sysResource).success(function (responseData) {
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
        if ($scope.selectedIds.length == 0) {
            swal("", "未选择数据!", "info");
            return;
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
                    sysResourceService.delete($scope.selectedIds).success(function (responseData) {
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
});