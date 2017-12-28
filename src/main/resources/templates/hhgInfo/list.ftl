<#include "/constants.ftl"> 
<@i.tHtml>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">今日信息列表</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row --> 
        <div class="row">    
        	<div class="col-lg-12">

				<#if msg?exists>
				    <div class="message">${msg}</div>
				</#if>
				
            </div> 
                <!-- /.col-lg-12 --> 
        </div>
        <!-- /.row --> 
        <div class="row">    
        	<div class="col-lg-12"> 
				<div class="panel panel-default">
                    <div class="panel-body">
                       <p>
                		<a href="${request.contextPath}/hhg/create" class="btn btn-default" >新增发布信息</a>
                		<#--<a href="${request.contextPath}/expensescreate/upload" class="btn btn-default" >费用报销表上传</a>-->
                       </p>
	                   <div class="dataTable_wrapper">
	                	  <form name="frm-dt_1" id="frm-dt_1">	                        		
	                    	<table id="dt_1" width="100%" class="table table-striped table-bordered table-hover">
							    <thead>
							        <tr>
							        	<th><input name="select_all" value="1" type="checkbox"></th>
							        	<th>操作</th> 
							            <th>发布日期</th>
							            <th>始发地</th>
							            <th>到达地</th>
							            <th>货物名称</th> 
							            <th>运费单价(元/吨)</th>
							            <th>联系单位</th> 
							            <th>联系人</th> 
							            <th>联系方式</th> 
							            <th>备注</th> 
							        </tr>
							    </thead> 
							</table>
							<p class="form-group">
							  <#-- <button type="button" class="btn btn-primary" onclick="javascript:batchSubmit();">批量提交</button>
							   <button type="button" class="btn btn-primary" onclick="javascript:print1();">打印费用报销表</button>
							   <button type="button" class="btn btn-primary" onclick="javascript:print2();">打印出差费用报销表</button>
							   -->
							</p>   
					    </form>
            	    </div>
                    <!-- /.table-responsive -->	
                </div>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->  
</@i.tHtml>
<script type="text/javascript">
	function batchSubmit() {
		$('#frm-dt_1').attr('action','${request.contextPath}/expensescreate/batchPending');
		$('#frm-dt_1').attr('target','_self');
		$('#frm-dt_1').submit();
	}
	function print1() {
		$('#frm-dt_1').attr('action','${request.contextPath}/expensescreate/print1');
		$('#frm-dt_1').attr('target','_blank');
		$('#frm-dt_1').submit();
	}
	function print2() {
		$('#frm-dt_1').attr('action','${request.contextPath}/expensescreate/print2');
		$('#frm-dt_1').attr('target','_blank');
		$('#frm-dt_1').submit();
	}

	function retrieveData( sSource, aoData, fnCallback ) {     
        //查询条件称加入参数数组     
        //var rentRuleId =document.getElementById('rentRuleId').value;  
        //alert(rentRuleId);
        $.ajax( {     
            type: "POST",
            url: sSource,   
            dataType:"json",  
            data: "dtParaJson="+JSON.stringify(aoData),  
            success: function(data) {   
               //$("#url_sortdata").val(data.aaData);  
                fnCallback(data); //服务器端返回的对象的returnObject部分是要求的格式     
            }     
        });    
    }  
    
//
// Updates "Select all" control in a data table
//
function updateDataTableSelectAllCtrl(table){
   var $table             = table.table().node();
   var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
   var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
   var chkbox_select_all  = $('thead input[name="select_all"]', $table).get(0);

   // If none of the checkboxes are checked
   if($chkbox_checked.length === 0){
      chkbox_select_all.checked = false;
      if('indeterminate' in chkbox_select_all){
         chkbox_select_all.indeterminate = false;
      }

   // If all of the checkboxes are checked
   } else if ($chkbox_checked.length === $chkbox_all.length){
      chkbox_select_all.checked = true;
      if('indeterminate' in chkbox_select_all){
         chkbox_select_all.indeterminate = false;
      }

   // If some of the checkboxes are checked
   } else {
      chkbox_select_all.checked = true;
      if('indeterminate' in chkbox_select_all){
         chkbox_select_all.indeterminate = true;
      }
   }
}

function convertToString(timestamp){
  var d = new Date(timestamp);    //根据时间戳生成的时间对象
  var date = (d.getFullYear()) + "-" + 
           (d.getMonth() + 1) + "-" +
           (d.getDate()) + " " + 
           (d.getHours()) + ":" + 
           (d.getMinutes()) + ":" + 
           (d.getSeconds())
  return date;
}

$(document).ready(function (){
   // Array holding selected row IDs
   var rows_selected = [];
   var dataTable_config = {//jquery_datatable插件的默认参数皮质
		//"bStateSave": true, //是否把获得数据存入cookie
	
		//"bLengthChange":false, //关闭每页显示多少条数据
		"bProcessing": true,
		//"bAutoWidth":true,//自动宽度
		"bServerSide": true,
		"responsive": true,
		"sAjaxSource": "${request.contextPath}/hhg/getPageList",
		"fnServerData":retrieveData,
		"bPaginate": true,  //是否分页。
		"bFilter": false,
		"sPaginationType": "full_numbers",      //分页样式
		"pageLength": 20,
		"columns" : [ {
				"data" : "id",
				"searchable": false,
				"orderable": false,
				"width": "1%",
				"className": "dt-body-center",
				"render": function (data, type, full, meta){
		        	return '<input type="checkbox">';
				}
			}, {
				"data" : "id",
            	"orderable": false,
				"render": function ( data, type, full, meta ) {
            		var rh = '';
            		rh += ' <a href="${request.contextPath}/hhg/'+data+'/edit">修改</a>';
            		rh += ' <a href="${request.contextPath}/hhg/'+data+'/delete">删除</a>';
            		return rh;
            	}
			}, {
	            "data" : "publishTime",
	            "render": function ( data, type, full, meta ) {
	               
	               return convertToString(data);
	            }
	            //"type" : "date",
	            //"render": $.fn.dataTable.render.moment( 'YYYY-MM-DD HH:mm:ss', 'YY-MM-DD' )
	        }, {
	            "data" : "send"
	        }, {
	            "data" : "arrive"
	        }, {
	            "data" : "goodsName"
	        }, {
	            "data" : "price"
	        }, {
	            "data" : "departInfo"
	        },{
	            "data" : "departInfoName"
	        }, {
	            "data" : "departInfoTel" 
	        }, {
	            "data" : "remark"
	        }, 
		],
        "lengthMenu": [
            [20, 30, 50],
            [20, 30, 50] // 更改每页显示记录数
        ],	
        "language": {
            "lengthMenu": "  _MENU_ 条数据",
            "emptyTable": "表格中没有数据~",
            "info": "显示 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
            "infoEmpty": "没有数据~",
            "infoFiltered": "(在 _MAX_ 条数据中查询)",
            "lengthMenu": "显示 _MENU_ 条数据",
            "search": "查询:",
            "zeroRecords": "没有找到对应的数据",
            "paginate": {
                "previous":"上一页",
                "next": "下一页",
                "last": "末页",
                "first": "首页"
            }
        },
        "columnDefs": [
        	{
         		sDefaultContent: '',
         		aTargets: [ '_all' ]
          	} 
		],
		"order": [
			[2, "desc"]
		],
		'rowCallback': function(row, data, dataIndex){
	        // Get row ID
	        var rowId = data[0];
	
	        // If row ID is in the list of selected row IDs
	        if($.inArray(rowId, rows_selected) !== -1){
	            $(row).find('input[type="checkbox"]').prop('checked', true);
	            $(row).addClass('selected');
	        }
		}
    };
   
   var table = $('#dt_1').DataTable(dataTable_config);

   // Handle click on checkbox
   $('#dt_1 tbody').on('click', 'input[type="checkbox"]', function(e){
      var $row = $(this).closest('tr');

      // Get row data
      var data = table.row($row).data();

      // Get row ID
      var rowId = data['expensesId'];

      // Determine whether row ID is in the list of selected row IDs 
      var index = $.inArray(rowId, rows_selected);

      // If checkbox is checked and row ID is not in list of selected row IDs
      if(this.checked && index === -1){
         rows_selected.push(rowId);

      // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
      } else if (!this.checked && index !== -1){
         rows_selected.splice(index, 1);
      }

      if(this.checked){
         $row.addClass('selected');
      } else {
         $row.removeClass('selected');
      }

      // Update state of "Select all" control
      updateDataTableSelectAllCtrl(table);

      // Prevent click event from propagating to parent
      e.stopPropagation();
   });

   // Handle click on table cells with checkboxes
   $('#dt_1').on('click', 'tbody td, thead th:first-child', function(e){
      //$(this).parent().find('input[type="checkbox"]').trigger('click');
   });

   // Handle click on "Select all" control
   $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
      if(this.checked){
         $('#dt_1 tbody input[type="checkbox"]:not(:checked)').trigger('click');
      } else {
         $('#dt_1 tbody input[type="checkbox"]:checked').trigger('click');
      }

      // Prevent click event from propagating to parent
      e.stopPropagation();
   });

   // Handle table draw event
   table.on('draw', function(){
      // Update state of "Select all" control
      updateDataTableSelectAllCtrl(table);
   });

   // Handle form submission event 
   $('#frm-dt_1').on('submit', function(e){
      var form = this; 
      if ($("input[name='selectedId[]']"))
      	$("input[name='selectedId[]']").remove();      
      // Iterate over all selected checkboxes
      $.each(rows_selected, function(index, rowId){
         // Create a hidden element  
         $(form).append(
             $('<input>')
                .attr('type', 'hidden')
                .attr('name', 'selectedId[]')
                .val(rowId)
         );
      });
   });

});
    
</script> 