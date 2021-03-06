/**
 * Created by Administrator on 2016/6/28.
 */
var rootPath = "/smp-cloud-web"
$(document).ready(function(){

        $("#saveInfo").on("click",function(){
            var schoolId = $("#inputSchoolId").val();
            var smpDomain = $("#inputSMPDomain").val();
            var apiDomain = $("#inputAPIDomain").val();
            var inputInstallVersion = $("#inputInstallVersion").val();
            var params = {
                schoolId:schoolId,
                smpDomain:smpDomain,
                apiDomain:apiDomain,
                version:inputInstallVersion
            }
            $.ajax({
                type:"post",
                url:rootPath + "/product/info/set",
                contentType: "application/json; charset=utf-8",
                dataType:"json",
                data: JSON.stringify(params),
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
        })
    }
)
