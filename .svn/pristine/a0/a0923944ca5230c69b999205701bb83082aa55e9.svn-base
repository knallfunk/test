/**
 * Created by Administrator on 2016/6/22.
 */
var rootPath = "/smp-cloud-web"
$(document).ready(function(){
    var selfParams = {
        condition:""
    }
    bootstrapTableInit();

    $("#searchContent").on("click",function(){
        var searchContent = $("#content").val();
        selfParams.condition = searchContent;
        bootstrapTableInit();
        selfParams.condition = "";
    })

    function bootstrapTableInit(){
        $("#school-shows").bootstrapTable("destroy").bootstrapTable({
            url:rootPath + "/restful/web/school/get",
            method:"post",
            cache: false,
            showFooter:true,
            showRefresh:true,
            height: 700,
            data:"rows",
            toolbar:"#toolbar",
            pagination: true,
            paginationPreText: "<-",
            paginationNextText:"->",
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            queryParams:queryParams,
            sidePagination: "server",
            pageNumber:1,
            pageSize: 15,
            pageList: [15,30 ,45],
            smartDisplay:true,
            showToggle:true,
            showPaginationSwitch:true,
            columns: [{
                field: 'schoolId',
                title: '编号'
            },{
                field: 'schoolName',
                title: '学校名称',
            },{
                field: "shortName",
                title: '学校简称'
            },{
                field: "license",
                title: '产品license'
            },{
                field: "version",
                title: 'version',
                visible:false
            },{
                field: "versionName",
                title: '产品类型'
            },{
                field:"operate",
                title:"操作",
                events:"operateEvent",
                formatter:operateFormatter
            }]
        })
    }

    function operateFormatter(value,row,index){
        return [
            '<button class="generateLicense table-bnt">'+
            '生成license</button>'+
            '<button class="getLicense table-bnt">'+
            '查看license</button>'
        ].join();
    }

    function queryParams(params){
        var data = {
            pageSize:params.pageSize,
            pageNo:params.pageNumber,
            condition:selfParams.condition
        }
        return JSON.stringify(data);
    }

    $("#submitBnt").on("click",function(){
        var flag = $("#schoolSelect").val();
        var schoolId = sessionStorage.getItem("schoolId");
        if(flag == -1){
            alert("请选择产品类型");
            return;
        }
        var param = {
            schoolId:schoolId,
            productType:flag
        }
        $.ajax({
            type:"post",
            url:rootPath + "/restful/web/license/generate",
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            data: JSON.stringify(param),
            success:function(json){
                var status = json.status;
                var  msg = json.msg;
                if(status == 200){
                    alert("添加成功")
                }else{
                    alert(msg);
                }
            },
            error:function(){
                alert("请求失败");
            },
            cache:false
        });
        $("#school-shows").bootstrapTable("refresh");
        sessionStorage.setItem("schoolId","");
        $("#schoolSelect").val(-1);
    });

    $("#cancelBnt").on("click",function(){
        $("#schoolSelect").val(-1);
        $("#productType").modal({
            show:false
        });
    });

})

window.operateEvent = {
    'click .generateLicense':function(e,value,row,index){
        var schoolId = row.schoolId;
        var version = row.version;
        if(version == null){
            $("#schoolSelect").val(-1);
        }else if(version == 1){
            $("#schoolSelect").val(1);
        }else{
            $("#schoolSelect").val(2);
        }
        sessionStorage.setItem("schoolId",schoolId);
        $("#productType").modal({
            show:true
        })
    },
    'click .getLicense':function(e,value,row,index){
        var schoolId = row.schoolId;
        var param = {
            schoolId:schoolId
        }
        $.ajax({
            type:"post",
            url:rootPath + "/restful/web/get/license",
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            data: JSON.stringify(param),
            success:function(json){
                var status = json.status;
                var  msg = json.msg;
                if(status == 200){
                    var license = json.license;
                    $("#schoolLicense").val(license);
                    $("#licenseView").modal({
                        show:true
                    })
                }else{
                    alert(msg);
                    return;
                }
            },
            error:function(){
                alert("请求失败");
            },
            cache:false
        });
    }
}
