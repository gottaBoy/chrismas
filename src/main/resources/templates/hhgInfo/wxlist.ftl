<!DOCTYPE html>
<html style="background-color: white;">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>黄骅港</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">

	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${request.contextPath}/css/mui.min.css">
	<script src="${request.contextPath}/js/mui.min.js"></script>
	<script src="http://static.cargocn.com/libs/startbootstrap-sb-admin-2/1.0.8/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		.footer {
			position: fixed;
			bottom: 0;
			left: 0;
		}
		table{
		    padding-bottom:60px;
		    margin-bottom:60px;
		}
		table thead th{
		    text-align: center;
		}
		.pspan{
		   width:25%;
		}
		.bg{
		   background-position:50% 50%;
		   background-size:cover;
		   background-image:url(./bannar.png)
		}
		.bg-phone{
		   background-position:50% 50%;
		   background-size:cover;
		   background-image:url(./phone.png)
		}
		.page-header{
		   margin: 20px 0 10px;
		}
		h3{
			line-height: 36px;
			height: 36px;
			padding-left: 20px;
			background: #f2f2f2;
			margin:20px 0;
		}
		p{margin:0;padding:0}
		.f-icon {
			display: block;
			width: 20px;
			height: 20px;
			background: #31BBEE;
			flex:none;
		}
		.flex-cont{
			display: -webkit-box; 
			display: -webkit-flex;
			display: flex;
		}
		.flex-item{
			-webkit-box-flex: 1;
			-webkit-flex: 1;
			flex: 1;
			width: 0%;
		}
		.flex-info{
			-webkit-box-align: start;
			-webkit-align-items: flex-start;
			align-items: flex-start;
			margin: 20px 0;
			border-bottom: 1px solid #ddd;
			padding:10px;
		}
		.flex-info .f-icon{
			margin:0 10px 0 20px;
		}
		.flex-info-center{
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
		}
	</style>
</head>
<!-- <body style="background-color: #0099cc;text-align: center;"> -->
<body style="background-color: white;text-align: center;">
    <div style="display:none;">${code?default('')}</div>
    <image src="${request.contextPath}/image/banner.png" style="width:100%;height:100%;"/>
    <div class="getNowFormatDate" style="background: lightgray;width: 100%;height: 20px;"> 
    </div>
    <div style="padding:10px 5px;">
    <#if showTel == true>
        <#if hhgInfoList?? && (hhgInfoList?size > 0) >
		  <#list hhgInfoList as item>
			 <div class="flex-cont flex-info flex-info-center">
	            <!--<i class="f-icon"></i>-->
				<image src="${request.contextPath}/image/hxs.jpg" style="width:60px;height:60px;"/>
	            <div class="flex-item s-word" style="text-align:left;margin-left: 10px;">
	                <p style="font-size:18px;">${item.send?default('')}--${item.arrive?default('')}  运费${item.price?default('')}</p> 
			        <p style="font-size:12px;">${item.remark?default('')}</p>
			        <p style="font-size:16px;">联系电话 ${item.departInfoTel?default('')}</p>
	            </div>
				<image class="alertBtn" title="${item.departInfoTel?default('')}" src="${request.contextPath}/image/phone.png" style="width:30px;height:30px;" onclick="messageModal();"/>
	         </div>
		  </#list>
		<#else>
		   <div class="text-center">暂无数据,请稍后查看</div>
		</#if>
    <#else>
        <#if hhgInfoList?? && (hhgInfoList?size > 0) >
		  <#list hhgInfoList as item>
	         <#--<div class="page-header" style="position:relative">
		      <div style="width: 60px;height: 60px;position: absolute;left:0px;top:20px;">
		         <image src="${request.contextPath}/image/hxs.jpg" style="width:100%;height:100%;"/>
		      </div>
		      <div style="width: 100%;height: 100%;position: relative;margin: 0 auto;">
		        <p style="font-size:20px;">${item.send?default('')}--${item.arrive?default('')}  运费${item.price?default('')}</p> 
		        <p style="font-size:12px;">${item.remark?default('')}</p>
		        <p style="font-size:16px;">联系电话 ${item.departInfoTel?substring(0,3)}*****${item.departInfoTel?substring(8,11)}</p>
		      </div>
		      <div style="width: 30px;height: 30px;position: absolute;right:0px;top:35px;">
		         <image src="${request.contextPath}/image/phone.png" style="width:100%;height:100%;"/>
			  </div>
			 </div>-->
             <div class="flex-cont flex-info flex-info-center">
	            <!--<i class="f-icon"></i>-->
				<image src="${request.contextPath}/image/hxs.jpg" style="width:60px;height:60px;"/>
	            <div class="flex-item s-word" style="text-align:left;margin-left: 10px;">
	                <p style="font-size:18px;">${item.send?default('')}--${item.arrive?default('')}  运费${item.price?default('')}</p> 
			        <p style="font-size:12px;">${item.remark?default('')}</p>
			        <p style="font-size:16px;">联系电话 ${item.departInfoTel?substring(0,3)}*****${item.departInfoTel?substring(8,11)}</p>
	            </div>
				<image class="alertBtn" title="${item.departInfoTel?substring(0,3)}*****${item.departInfoTel?substring(8,11)}" src="${request.contextPath}/image/phone.png" style="width:30px;height:30px;" />
	         </div>
		  </#list>
		<#else>
		   <div class="text-center">暂无数据,请稍后查看</div>
		</#if>
    </#if>
    </div>
    <div class="ibox" style="background: white;width: 100%;height: 60px;padding-right: 0px;">
    </div>
    
    <div class="footer" style="background: white;width: 100%;height: 60px;padding-right: 0px;">
		<div class="col-xs-12" style="padding-left: 0px;padding-right: 0px;">
		    货源信息真实有效， 首页左下角限时领取红包！<br/>
			联系电话：<a href="tel:4008565886">400-856-5886</a>
		<#--<a href="tel:4008565886#mp.weixin.qq.com">400-856-5886</a><a href="wtai://wp//mc;110">110</a>  
		<a href="wtai://wp/ap;;">存储</a>-->
		</div>
	</div>
</body>
<script type="text/javascript" charset="utf-8">
// H5 plus事件处理  
function plusReady(){  
}  
if(window.plus){  
  plusReady();  
}else{  
  document.addEventListener("plusready",plusReady,false);  
}  
//mui初始化
mui.init({
 	swipeBack: true //启用右滑关闭功能
});
var btnArray = ['取消', '拨打'];
Array.prototype.forEach.call(document.getElementsByClassName('alertBtn'),function(item,index,arr){
  var phone=item.title;
  item.addEventListener('tap', function() {
   if(phone.indexOf("*")>0){
	    mui.alert(item.title+'<image src="${request.contextPath}/image/miniapp.jpg" style="width:100%;height:100%;"/>', '长按二维码认证后即可拨打', function() {
			
		});
   }else{
	    mui.confirm('是否拨打'+phone+'?','提示',btnArray,function(e){
	        if(e.index == 1){
	            plus.device.dial(phone,false);
	        }
	    })
   }
  })
});

function getNowFormatTime() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = ".";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
var rightdate = getNowFormatDate();
$(document).ready(function(){
   $(".getNowFormatDate").html(rightdate);
   
})
</script>
</html>