<#include "/constants.ftl"> 
<@i.tHtml>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">费用报销</h1>
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
                            <#list cityList as city>
							City: ${city.cityName}! <br>
							Q:Why I like? <br>
							A:${city.description}!
							
							</#list>
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