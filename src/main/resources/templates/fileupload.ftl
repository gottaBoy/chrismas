<!DOCTYPE html>
<html lang="en">
<head>  
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>货运中国网</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.0/jquery.js"></script>
  <script src="./vendor/jquery.iframe-transport.js"></script>
  <script src="./vendor/jquery.ui.widget.js"></script>
  <script src="./vendor/jquery.fileupload.js"></script>
</head>
<body>
   <!--点击超链接上传附件-->
   <input type="file" name="file" id="fileupload"  style="display:none" onclick="upload()" multiple/>
   <a href='' onclick="document.getElementById('fileupload').click();return false;">添加附件</a>
   <!--用隐藏框保存附件组id-->
   <input type="hidden" name="attaSetId" id="attaSetId" value=""/>
   
<script type="text/javascript">
	$(document).ready(function(){
	})
	
	//附件上传，选择文件后自动上传
	function upload() {
	    $('#fileupload').fileupload({
	    	url:"${ctx}/common/attachment.do?method=uploadFile&attaSetId="+$('#attaSetId').val(),
	        dataType: 'json',
	        done: function (e, data) {
	            var str="";
	        	$('#attaSetId').val(data.result.attaSetId);//将附件组Id赋值给隐藏框
	        	str+='<li id='+
	   	              data.result.attaId+
		              '>'+
	        	     '<a  href="#" onclick="deleteAtta(\''+data.result.attaId+'\')" class="pull-right" >删除</a><i class="icon-annex"></i>'+
	        		 data.result.fileNameOriginal+
	        		 '</li>';
	        $(".unstyled").append(str);
	        }
	    });
    }
	//附件删除
	function deleteAtta(id){
		$.ajax({
			url:'${ctx}/common/attachment.do?method=deleteFile&attaId='+id,
			type:'POST',
			data:{attaId:id}
		}).done(function(){
			$("#"+id).remove();//将页面上的记录显示删除掉
		});
	}
</script>
	
</body>
</html>