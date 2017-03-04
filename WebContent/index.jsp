<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${pageContext.request.contextPath }/images/favicon.ico">
    <title>登录</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/bootstrap-theme.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" role="form" method="post">
        <h4 class="form-signin-heading">登录</h4>
        <input type="email" id="userName" class="form-control" placeholder="账号" required autofocus>
        <input type="password" id="userPwd" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-primary btn-block" id="btnLogin">登录</button>
        <!-- <input type="button" class="btn btn-lg btn-primary btn-block" value="登录" id="btnLogin"/> -->
        <!-- <button id="btnLogin">uuu</button> -->
      </form>
    </div> 
	<!-- 在导入bootstrap的JS之前一定要导入jquery.js(bootstrap是以jquery为基础的) -->
	<!-- bootstrap3.3.0必须使用jquery1.9.1或者更高版本 -->
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath }/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript">
    	$(function(){
    		//delegate可以替代以前的live方法（能够解决动态创建的节点的单击事件问题）
    		$("form").delegate("#btnLogin","click",function(e){
    			var $userName = $("#userName").val();
    			var $userPwd = $("#userPwd").val();
    			if($.trim($userName) == ""){
    				if($.trim($userPwd) == ""){
    					
    				}
    			}else if($.trim($userPwd) == ""){
    				
    			}else{
    				e.preventDefault();
        			$.post(
        				"userAction?flag=login",
        				{"userName":$userName,"userPwd":$userPwd},
        				function(data){
        					if(data.state == "success"){
        						location.href = "welcome.jsp";
        					}else{
        						alert("用户名或者密码错误！");
        					}
        				},
        				"json"
        			);
    			}
    		});
    		/* $("#btnLogin").on("click",function(e){
    			var $userName = $("#userName").val();
    			var $userPwd = $("#userPwd").val();
    			
    			if($.trim($userName) == ""){
    				if($.trim($userPwd) == ""){
    					
    				}
    			}else if($.trim($userPwd) == ""){
    				
    			}else{
    				e.preventDefault();
    				$.post(
    	    				"userAction?flag=login",
    	    				{"userName":$userName,"userPwd":$userPwd},
    	    				function(data){
    	    					if(data.state == "success"){
    	    						location.href = "userAction?flag=queryAll";
    	    					}else{
    	    						alert("账号或密码错误！");
    	    					}
    	    				},
    	    				"json"
    	    			);
    			}
    		}); */
    	});
    </script>
  </body>
</html>
