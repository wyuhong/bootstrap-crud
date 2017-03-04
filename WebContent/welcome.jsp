<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon"
	href="${pageContext.request.contextPath }/images/favicon.ico">
<title>欢迎</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap-theme.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap-table.css"
	rel="stylesheet">
</head>
<body>
	<div id="delModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认</h4>
				</div>
				<div class="modal-body">
					<p>确认删除选中记录吗？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="delok" type="button" class="btn btn-primary">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<div id="addModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">新增学生</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">
							<label>学生编号</label> <input type="text" class="form-control"
								id="stuId" placeholder="请输入学生编号">
						</div>
						<div class="form-group">
							<label>学生姓名</label> <input type="text" class="form-control"
								id="stuName" placeholder="请输入学生姓名">
						</div>
						<div class="form-group">
							<label>所在班级</label> <select id="classId" class="form-control">
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="addok" type="button" class="btn btn-primary">保存</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div id="updateModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">修改学生</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">
							<label>学生编号</label> <input type="text" class="form-control"
								id="stuIdu" placeholder="请输入学生编号" disabled>
						</div>
						<div class="form-group">
							<label>学生姓名</label> <input type="text" class="form-control"
								id="stuNameu" placeholder="请输入学生姓名">
						</div>
						<div class="form-group">
							<label>所在班级</label> <select id="classIdu" class="form-control">
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="updateok" type="button" class="btn btn-primary">修改</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	


	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Bootstrap Table
					Examples</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="https://github.com/wenzhixin/bootstrap-table"
						target="_blank">Bootstrap Table</a></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">Options <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="options/boolean-options.html">Boolean
									options</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">Methods <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="methods/getOptions.html">getOptions</a></li>
							<li><a href="methods/getSelections.html">getSelections</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">Extensions <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="extensions/editable.html">Editable</a></li>
							<li><a href="extensions/export.html">Export</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">Integrate <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="integrate/angular">Angular</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">Issues <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="issues/1167.html"> 1167. Check/Uncheck All
									in all page </a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="content"
		style="width: 900px; height: 300px; margin: 100px auto;">
		<div id="toolbar" style="margin-bottom: 5px;">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="table"></table>
	</div>



	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>

	<script
		src="${pageContext.request.contextPath }/js/ie-emulation-modes-warning.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/ie10-viewport-bug-workaround.js"></script>
	<script type="text/javascript">
		//表格参数：用在bootstrapTable({key:value})的key 如：search
		//列参数：用在bootstrapTable({columns:[{key:value},{key1:value1}]})的key 如：field,checkbox
		//方法：用在bootstrapTable("method")的method 如bootstrapTable("getSelections")里面的getSelections
		//事件:用在bootstrapTable({eventname:function(){}})里面的eventname
		$(function() {
			
			$('#table').bootstrapTable({
				url : "stuAction?flag=queryAllJson",
				search : true,
				pagination : true,
				pageNumber : 1,
				pageSize : 2,
				pageList : [ 2, 10, 25, 50, 100 ],
				toolbar : '#toolbar',
				columns : [ {
					checkbox : true
				}, {
					field : 'stuId',
					title : '学生编号',
					align : 'center',
					valign : 'middle'
				}, {
					field : 'stuName',
					title : '学生姓名',
					align : 'center',
					valign : 'middle'
				}, {
					field : 'className',
					title : '所在班级',
					align : 'center',
					valign : 'middle'
				} ]
			});

			//批量删除
			$("#btn_delete").click(function() {
				var $selects = $("#table").bootstrapTable("getSelections");
				if ($selects.length == 0) {
					alert("请选择记录！");
				} else {
					$("#delModal").modal("show");
					$("#delok").click(function() {
						$("#delModal").modal("hide");
						//1 把前台页面数据删除掉
						var ids = [];
						$.each($selects, function(i) {
							ids.push($selects[i].stuId);
						});
						$("#table").bootstrapTable("remove", {
							field : "stuId",
							values : ids
						});
						//2 ajax把数据传递给后台进行删除
						$.post("stuAction?flag=delStus", {
							"a[]" : ids
						}, function(data) {

						});
					});
				}
			});
			
			
			//弹出新增模态框
			$("#btn_add").click(function(){
				//1 通过Ajax请求查询所有班级信息
				$.post(
					"clsAction?flag=queryAllJson",
					function(data){
						//每次加载班级信息时，将原有内容清空
						$("#classId").empty();
						//遍历拼接动态option节点
						var str = "";
						/* for(var i=0;i<data.length;i++){
							str = str + "<option value='"+data[i].classId+"'>"+data[i].className+"</option>";
						} */
						$.each(data,function(i){
							str = str + "<option value='"+data[i].classId+"'>"+data[i].className+"</option>";
						});
						//追加到容器中
						$("#classId").append(str);
					},
					"json"
				);
				$("#addModal").modal("show");
			});
			
			//保存按钮功能
			$("#addok").click(function(){
				var $stuId = $("#stuId").val();
				var $stuName = $("#stuName").val();
				var $classId = $("#classId").val();
				
				$.post(
					"stuAction?flag=addStu",
					{"stuId":$stuId,"stuName":$stuName,"classId":$classId},
					function(data){
						if(data.state == "success"){
							//1 先关闭新增的模态框
							$("#addModal").modal("hide");
							//添加成功
							//1 通过跳转到servlet
							/* location.href = "stuAction?flag=queryAll"; */
							//2 跳转到指定JSP页面
							/* location.href = "welcome.jsp"; */
							//3 使用前端框架(bootstrap table)自带的方法
							$("#table").bootstrapTable("refresh")
						}else{
							//添加失败
							//1 先关闭新增的模态框
							$("#addModal").modal("hide");
							//2 弹出统一的报错模态框
							alert("新增失败！");
						}
					},
					"json"
				);
			});
			
			//当点击修改按钮时的事件
			$("#btn_edit").click(function(){
				var $selects = $("#table").bootstrapTable("getSelections");
				if ($selects.length == 0) {
					alert("请选择记录！");
				} else if($selects.length > 1){
					alert("请选择单条记录！");
				} else {
					//客户只选择了一条记录
					//1 将选中学生的编号ajax提交到后台（）
					$.post(
						"stuAction?flag=queryStuByStuIdJson",
						{"stuId":$selects[0].stuId},
						function(data){
							$("#classIdu").empty();
							$("#stuIdu").val(data.spo.stuId);
							$("#stuNameu").val(data.spo.stuName);
							
							var str = "";
							var $clsList = data.clsList;
							for(var i=0;i<$clsList.length;i++){
								if($clsList[i].classId == data.spo.classId){
									str = str + "<option value='"+$clsList[i].classId+"' selected='selected'>"+$clsList[i].className+"</option>";
								}else{
									str = str + "<option value='"+$clsList[i].classId+"'>"+$clsList[i].className+"</option>";
								}
							}
							$("#classIdu").append(str);
							
						},
						"json"
					);
					$("#updateModal").modal("show");
				}
			});
			
			
			//点击修改按钮
			$("#updateok").click(function(){
				var $stuId = $("#stuIdu").val();
				var $stuName = $("#stuNameu").val();
				var $classId = $("#classIdu").val();
				
				
				$.post(
						"stuAction?flag=updateStu",
						{"stuId":$stuId,"stuName":$stuName,"classId":$classId},
						function(data){
							if(data.state == "success"){
								//1 先关闭新增的模态框
								$("#updateModal").modal("hide");
								//修改成功
								//1 通过跳转到servlet
								/* location.href = "stuAction?flag=queryAll"; */
								//2 跳转到指定JSP页面
								/* location.href = "welcome.jsp"; */
								//3 使用前端框架(bootstrap table)自带的方法
								$("#table").bootstrapTable("refresh")
							}else{
								//添加失败
								//1 先关闭新增的模态框
								$("#updateModal").modal("hide");
								//2 弹出统一的报错模态框
								alert("修改失败！");
							}
						},
						"json"
					);
				
			});
			
		});
	</script>
</body>
</html>
