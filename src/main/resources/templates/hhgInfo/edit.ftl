<#include "/constants.ftl"> 
<@i.tHtml>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">编辑信息</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row --> 
	    <form role="form" action="${request.contextPath}/hhg/saveHhgInfo" method="post">
	    <input type="hidden" name="id" value="${hhgInfo.id}"/>
        <div class="row">
          <div class="col-lg-6"> 
	        <div class="form-group">
	            <label >始发地：</label>
	            <input id="send" name="send" value="${hhgInfo.send}" class="form-control"/>
	        </div>
	        <div class="form-group">
	            <label >到达地：</label>
	            <input id="arrive" name="arrive" value="${hhgInfo.arrive}" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label >货物名称：</label>
	            <input id="goodsName" name="goodsName" value="${hhgInfo.goodsName}" class="form-control"/>
	        </div>
	        
	        <div class="form-group">
	            <label >运输单价（元/吨）：</label>
	            <input id="price" name="price" value="${hhgInfo.price}" class="form-control"/>
	        </div>
	        <div class="form-group">
	            <label >发布日期：</label>
	            <input id="publishTime" name="publishTime" class="form-control" value="${(hhgInfo.publishTime?string("yyyy-MM-dd HH:mm:ss"))}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	        </div> 
		</div>
        <!-- /.col-lg-6 -->
        <div class="col-lg-6"> 
             <div class="form-group">
	            <label >联系单位：</label>
	            <input type="text" id="departInfo" name="departInfo" value="${hhgInfo.departInfo?default('')}" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >联系手机：</label>
	            <input type="text" id="departInfoTel" name="departInfoTel" value="${hhgInfo.departInfoTel?default('')}" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >联系人：</label>
	            <input type="text" id="departInfoName" name="departInfoName" value="${hhgInfo.departInfoName?default('')}" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >更多联系信息：</label>
	            <input type="text" id="departInfoMore" name="departInfoMore" value="${hhgInfo.departInfoMore?default('')}" class="form-control" />
	        </div>
	        
	        <#--
	        <div class="form-group">
	            <label id="endDate">结束日期：</label>
	            <input name="endDate" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
	        </div>  -->
	        <div class="form-group">
	            <label >备注：</label>
	            <input id="remark" name="remark" value="${hhgInfo.remark?default('')}" class="form-control"/>
	        </div>
        </div>
        <!-- /.col-lg-6 --> 
    </div>
    <!-- /.row -->
    <div class="row"> 
    	<div class="col-lg-12">  
		  <button class="btn btn-default" onclick="onSubmint">保存</button>
		</div>
        <!-- /.col-lg-12 --> 
    </div>
    <!-- /.row -->
  <form>
</div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->      
<#--
<style>
    ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
</style>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="tree" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
-->
<script>
function onSubmint(){
   //触发form元素的submit事件
   $("form").submit();
}
$(document).ready(function() {
    $("form").submit( function(event){
	    var send = $('input[name="send"]').val();
		var arrive = $('input[name="arrive"]').val();
		var goodsName = $('input[name="goodsName"]').val();
		var price = $('input[name="price"]').val();
		var departInfoTel = $('input[name="departInfoTel"]').val();
	    if( !send){
	        alert("始发地为空！");
	        return false; // 返回值为false，将阻止表单提交
	    }else if( !arrive ){
	         alert("到达地为空！");
	        return false; // 返回值为false，将阻止表单提交
	    }else if( !goodsName ){
	        alert("货物名称为空！");
	        return false; // 返回值为false，将阻止表单提交
	    }else if( !price ){
	         alert("运费单价为空！");
	        return false; // 返回值为false，将阻止表单提交
	    }else if( !departInfoTel ){
	         alert("联系人手机为空！");
	        return false; // 返回值为false，将阻止表单提交
	    }
	});
})
</script>
</@i.tHtml>  
<#--<script>
        $(function () {
            var setting = {
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: onClick
                }
            };

            var zNodes =[
                <#list organizationList as o>
                    <#if !o.rootNode>
                        { id:${o.id}, pId:${o.parentId}, name:"${o.name}"},
                    </#if>
                </#list>
            ];

            function onClick(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getSelectedNodes(),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#organizationId").val(id);
                $("#organizationName").val(name);
                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#organizationName");
                var cityOffset = $("#organizationName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
    </script>
 -->