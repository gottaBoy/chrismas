<#include "/constants.ftl"> 
<@i.tHtml>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">新增信息</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row --> 
	    <form role="form" action="${request.contextPath}/hhg/saveHhgInfo" method="post">
	    <input type="hidden" name="id" />
        <div class="row">
          <div class="col-lg-6"> 
	        <div class="form-group">
	            <label >始发地：</label>
	            <input id="send" name="send" class="form-control"/>
	        </div>
	        <div class="form-group">
	            <label >到达地：</label>
	            <input id="arrive" name="arrive" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label >货物名称：</label>
	            <input id="goodsName" name="goodsName" class="form-control"/>
	        </div>
	        
	        <div class="form-group">
	            <label >运输单价（元/吨）：</label>
	            <input id="price" name="price" class="form-control"/>
	        </div>
	        <div class="form-group">
	            <label >发布日期：</label>
	            <input id="publishTime" type="text" name="publishTime" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	        </div> 
		</div>
        <!-- /.col-lg-6 -->
        <div class="col-lg-6"> 
             <div class="form-group">
	            <label >联系单位：</label>
	            <input type="text" id="departInfo" name="departInfo" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >联系人：</label>
	            <input type="text" id="departInfoName" name="departInfoName" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >联系手机：</label>
	            <input type="text" id="departInfoTel" name="departInfoTel" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >更多联系信息：</label>
	            <input type="text" id="departInfoMore" name="departInfoMore" class="form-control" />
	        </div>
	        <div class="form-group">
	            <label >备注：</label>
	            <input id="remark" name="remark" class="form-control"/>
	        </div>
	        <#--
	        <div class="form-group">
	            <label id="endDate">结束日期：</label>
	            <input name="endDate" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
	        </div>  -->
	        
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