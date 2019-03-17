//二、品牌控制层
app.controller('brandController',function ($scope,$controller,brandService) {

    //**继承baseControlller.js
    $controller('baseController',{$scope:$scope});




    //读取列表数据绑定到表单中
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        )
    }

    //下面代码可以通过继承获得
    /*//重新加载列表数据
    $scope.reloadList=function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }
    //分页控件配置
    $scope.paginationConf = {

        currentPage: 1,                        //当前页码
        totalItems: 10,                        //总条数
        itemsPerPage: 10,
        perPageOptions: [10,20,30,40,50],      //页码选项
        onChange: function () {                //更改页面时触发事件
            $scope.reloadList();  //重新加载
        }
    }*/
    //分页
    $scope.findPage=function (page,rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数

            }
        )
    }


    //查询实体
    $scope.findOne=function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity =response;
            }
        )
    }

    //保存(可以覆盖前面的保存方法)
    $scope.save=function () {

        var object=null;             	                       //方法名称
        if($scope.entity.id!=null){                            //如果有ID
            object=brandService.update($scope.entity);         //则执行修改方法
        }else{
            object=brandService.add($scope.entity);            //否则执行add方法
        }
        object.success(
            function (response) {
                if(response.success){
                    //表示添加或修改成功
                    $scope.reloadList();  //重新加载
                }else{
                    alert(response.message);
                }
            }
        )
    }


    //以下代码可以通过继承获得
    /*$scope.selectIds=[];   //选中的ID集合
    //更新复选
    $scope.updateSelection = function ($event, id) {

        if($event.target.checked){  //如果是被选中，则增加到数组

            $scope.selectIds.push(id);

        }else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx,1);  //删除
        }
    }*/
    //批量删除
    $scope.dele=function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if(response.success){
                    $scope.reloadList();  //刷新列表
                }
            }
        )
    }


    //查询
    $scope.searchEntity={};    //定义搜索对象

    $scope.search=function (page,rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total;   //记录总数
                $scope.list=response.rows;      //给列变量赋值
            }
        )
    }


});