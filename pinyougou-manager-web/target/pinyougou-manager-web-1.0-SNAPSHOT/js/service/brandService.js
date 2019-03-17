//一、品牌服务层
app.service('brandService',function ($http) {

    //1.读取列表数据绑定到表单中
    this.findAll=function () {
        return $http.get('../brand/findAll.do');
    }

    //2.分页
    this.findPage=function (page,rows) {
        return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    }

    //3.查询单个
    this.findOne=function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    }

    //4.添加
    this.add=function (entity) {
        return $http.post('../brand/add.do',entity);
    }

    //5.更新
    this.update=function (entity) {
        return $http.post('../brand/update.do',entity);
    }

    //6.批量删除
    this.dele=function (ids) {
        //获取选中的复选框
        return $http.get('../brand/delete.do?ids='+ids);
    }

    //7.查询
    this.search=function (page,rows,entity) {
        return $http.post('../brand/search.do?page='+page+"&rows="+rows,entity);
    }
})



