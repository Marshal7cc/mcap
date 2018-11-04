//控制层
app.controller("quartzController", function ($scope, $controller, quartzService) {
    //继承
    $controller("baseController", {$scope: $scope});
    /**
     * scheduler方法
     */
    $scope.startUp = function () {
        quartzService.startUp().success(function (responseData) {
            if (responseData.success) {
                swal("", responseData.message, "success");
            } else {
                swal("", responseData.message, "info");
            }
        })
    }
    $scope.standBy = function () {
        quartzService.standBy().success(function (responseData) {
            if (responseData.success) {
                swal("", responseData.message, "success");
            } else {
                swal("", responseData.message, "info");
            }
        })
    }
    /**
     * job方法
     */
    $scope.condition = {};
    $scope.query = function (pageNum, pageSize) {
        quartzService.query(pageNum, pageSize, $scope.condition).success(function (data) {
            $scope.rows = data.rows;
            $scope.pageConf.totalItems = data.total;
        });
    }
    $scope.pauseJob = function (jobName, jobGroup) {
        quartzService.pauseJob(jobName, jobGroup).success(function (responseData) {
            if (responseData.success) {
                swal("", responseData.message, "success");
                $scope.reloadList();
            } else {
                swal("", responseData.message, "info");
            }
        });
    }
    $scope.resumeJob = function (jobName, jobGroup) {
        quartzService.resumeJob(jobName, jobGroup).success(function (responseData) {
            if (responseData.success) {
                swal("", responseData.message, "success");
                $scope.reloadList();
            } else {
                swal("", responseData.message, "info");
            }
        });
    }
    $scope.deleteJob = function (jobName, jobGroup) {
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
                    quartzService.deleteJob(jobName, jobGroup).success(function (responseData) {
                        if (responseData.success) {
                            swal("", responseData.message, "success");
                            $scope.reloadList();
                        } else {
                            swal("", responseData.message, "info");
                        }
                    });
                }
            });
    }
    //保存
    $scope.createJob = function () {
        quartzService.createJob($scope.jobCreateInfo).success(function (responseData) {
            if (responseData.success) {
                swal("提示", responseData.message, "success");
                $scope.reloadList();
            } else {
                swal("提示", responseData.message, "info");
            }
        });
    }

    $scope.initForAdd = function () {
        $scope.jobCreateInfo = {jobData: []};
    }
    //新增行表
    $scope.addLine = function () {
        $scope.jobCreateInfo.jobData.push({});
    }
    //删除行表
    $scope.deleteLine = function (index) {
        $scope.jobCreateInfo.jobData.splice(index, 1);
    }
});