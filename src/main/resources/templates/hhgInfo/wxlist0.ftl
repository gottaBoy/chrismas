<#--<#assign form=JspTaglibs[ "/WEB-INF/tld/spring-form.tld"]/>-->
<!DOCTYPE html>
<html style="background-color: #0099cc;">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>货运中国网</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-touch-fullscreen" content="yes">
		<meta name="apple-mobile-web-app-capable" content="yes">

		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
		</style>
		<script type="text/javascript">
		</script>
	</head>

	<body style="background-color: #0099cc;text-align: center;">

		<div class="panel panel-default" style="margin-top: 20px;margin-left: 10px;margin-right: 10px;">
			<table class="table table-condensed">
				<caption>今日货源信息</caption><#--(${item.publishTime?string("yyyy-MM-dd")?default('')})-->
				<thead>
					<#--<tr>
						<th>始发地</th>
						<th>到达地</th>
						<th>货物名称</th>
						<th>运费单价(元/吨)</th>
						<th>联系单位</th>
						<th>联系人</th>
						<th>联系手机</th>
					</tr>-->
					<tr>
						<th>始发--到达</th>
						<th>货物(运价)</th>
						<th>联系人(手机号)</th>
					</tr>
				</thead>
				<tbody>	
				  <#if hhgInfoList?? && (hhgInfoList?size > 0) >
				    <#list hhgInfoList as item>
                         <tr>
							<#--<td><span class="pspan">${item.send?default('')}==>${item.arrive?default('')}</span><span class="pspan">${item.goodsName?default('')}</span>
							<span class="pspan">${item.price?default('')}</span><span class="pspan">${item.departInfo_Tel?default('')}</span>
							<br/><span>${item.remark?default('')}</span>
							</td>-->
							<td>${item.send?default('')}--${item.arrive?default('')}</td>
							<td>${item.goodsName?default('')}(${item.price?default('')})</td>
							<td>${item.departInfoName?default('')}(${item.departInfoTel?default('')})</td>
						</tr>
					</#list>
                  <#else>
                   <tr><td colspan="3" class="text-center">暂无数据,请稍后查看</td></tr>
                  </#if>
					<#--<#list wlist as item>
						<tr>
							<td>${item.send?default('')}</td>
							<td>${item.arrive?default('')}</td>
							<td>${item.goodsName?default('')}</td>
							<td>${item.price?default('')}</td>
							<td>${item.departInfo?default('')}</td>
							<td>${item.departInfo_Tel?default('')}</td>
							<td>${item.planStartTime?string("yyyy-MM-dd")?default('')}</td>
						</tr>
					</#list>-->
				</tbody>
			</table>
		</div>
        <div class="ibox" style="background: #0099cc;width: 100%;height: 60px;padding-right: 0px;">
        </div>
		<#--<#include "hhgFooter.ftl">-->
        <div class="footer" style="background: white;width: 100%;height: 60px;padding-right: 0px;">
			<div class="col-xs-12" style="padding-left: 0px;padding-right: 0px;">
			    
				更多信息请拨打联系电话<br/>
				400-856-5886
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" role="dialog" aria-labelledby="messageModalLabel" id="messageModal" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          			<span aria-hidden="true">×</span>
					</button>
						<h3 class="modal-title" id="messageModalLabel">客户税点</h3>
					</div>
					<div class="modal-body clearfix">
						<div class="row col-sm-12">
							<div class="col-sm-8 form-group">
								<label>客户名称</label>
								<input type="text" id="codename" class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>税点      例如:(0.09)</label>
								<input type="text" id="codevalue" class="form-control">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="addCompanyInvoice()">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>