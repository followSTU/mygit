<%@page import="com.sx.libarary.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书管理系统用户登录</title>
<link href="css/logina.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});
</script>
  <script type="text/javascript">
      $(function(){
    	  
          var loginAddr='http://localhost:8080/libarary/dologin';
          //学生
          $("#form1").validate({
              rules:{
                  stuname:{required:true},
                  stupassword:{required:true}
              },
              messages:{
                  stuname:{required:'请输入用户名'},
                  stupassword:{required:'请输入密码'}
              }
          })
          $("#btn1").click(function () {
              if($("#form1").valid()){
                  var userStr={};
                  userStr.userType={
                      userTypeId:2
                  };
                  userStr.userXuehao=$("#stuname").val();
                  userStr.userPassword=$("#stupassword").val();
                  var kaptcha=$("#usercode").val();
                  var formData=new FormData();
                  formData.append("userStr",JSON.stringify(userStr));
                  formData.append("kaptcha",kaptcha);
                  $.ajax({
                      url:loginAddr,
                      type:'POST',
                      data:formData,
                      contentType:false,
                      processData:false,
                      cash:false,
                      success:function (result) {
                
                    	  if(result.data.success){
                    
                    		  window.location.href="http://localhost:8080/libarary/Index/index.html";
                           }else{
                          	 alert(result.data.error)
                           }
                      }
                  })
              }
          })
          //教师
          $("#form2").validate({
              rules:{
                  teaname:{required:true},
                  teapassword:{required:true}
              },
              messages:{
                  teaname:{required:'请输入用户名'},
                  teapassword:{required:'请输入密码'}
              }
          })
          $("#btn2").click(function () {
              if($("#form2").valid()){
                  var userStr={};
                  userStr.userType={
                      userTypeId:1
                  };
                  userStr.userXuehao=$("#teaname").val();
                  userStr.userPassword=$("#teapassword").val();
                  var kaptcha=$("#teacode").val();
                  var formData=new FormData();
                  formData.append("userStr",JSON.stringify(userStr));
                  formData.append("kaptcha",kaptcha);
                  $.ajax({
                      url:loginAddr,
                      type:'POST',
                      data:formData,
                      contentType:false,
                      processData:false,
                      cash:false,
                      success:function (result) {
                    	  if(result.data.success){
                    		  window.location.href="http://localhost:8080/libarary/Index/index.html";
                           }else{
                          	 alert(result.data.error)
                           }
                      }
                  })
              }
          })
          //管理员
          $("#form3").validate({
              rules:{
                  adminname:{required:true},
                  adminpassword:{required:true}
              },
              messages:{
                  adminname:{required:'请输入用户名'},
                  adminpassword:{required:'请输入密码'}
              }
          })
          $("#btn3").click(function () {
              if($("#form3").valid()){
                  var userStr={};
                  userStr.userType={
                      userTypeId:3
                  };
                  userStr.userName=$("#adminname").val();
                  userStr.userPassword=$("#adminpassword").val();
                  var kaptcha=$("#admincode").val();
                  var formData=new FormData();
                  formData.append("userStr",JSON.stringify(userStr));
                  formData.append("kaptcha",kaptcha);
                  $.ajax({
                      url:loginAddr,
                      type:'POST',
                      data:formData,
                      contentType:false,
                      processData:false,
                      cash:false,
                      success:function (result) {
                    	  if(result.data.success){
                    		  window.location.href="http://localhost:8080/libarary/back/index.html";
                           }else{
                          	 alert(result.data.error)
                           }
                      }
                  })
              }
          })
      });
  </script>
<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
  <style type="text/css">
    #form1 label{display: block;color: red}
    #form2 label{display: block;color: red}
    #form3 label{display: block;color: red}
  </style>
</head>

<body>

<div id="tab">
  <ul class="tab_menu">
    <li class="selected">学生登录</li>
    <li>教师登录</li>
    <li>管理员登录</li>
  </ul>
  <div class="tab_box">
    <!-- 学生登录开始 -->
    <div>
      <div class="stu_error_box"></div>
      <form action="" method="post" class="stu_login_error" id="form1">
        <div >
          <span>学&nbsp;&nbsp;&nbsp;号：</span>
          <input type="text" name="stuname" placeholder="请输入学号" id="stuname"/>
          <!--ajaxurl="demo/valid.jsp"-->
        </div>
        <div >
          <span>密&nbsp;&nbsp;&nbsp;码：</span>
          <input type="password" name="stupassword" placeholder="请输入密码" id="stupassword"/>
        </div>
        <div id="code">
          <span>验证码：</span>
          <input type="text" id="usercode" name="code" placeholder="验证码"/>
          <img alt="验证按" title="点击更换" style="cursor: pointer" id="captcha_img"  src="../Kaptcha" > </div>
        <div>
          <span>还没有账号，<a href="register.html">注册</a></span>
        </div>
        <div id="login">
          <button type="button" id="btn1" >登录</button>
        </div>
      </form>
    </div>
   <!-- 学生登录结束-->
   <!-- 导师登录开始-->
    <div class="hide">
     <div class="tea_error_box"></div>
      <form action="" class="tea_login_error" id="form2">
        <div >
          <span>教工号：</span>
          <input type="text" name="teaname" id="teaname" placeholder="请输入教工号"/>
          <!--ajaxurl="demo/valid.jsp"-->
        </div>
        <div >
          <span>密&nbsp;&nbsp;&nbsp;码：</span>
          <input type="password" name="teapassword" placeholder="请输入密码" id="teapassword"/>
        </div>
        <div id="code">
          <span>验证码：</span>
          <input type="text" id="teacode" name="code" placeholder="验证码"/>
          <img alt="验证按" title="点击更换" style="cursor: pointer"   src="../Kaptcha" > </div>
        <div>
          <sapn>还没有账号，<a href="register.html">注册</a></sapn>
        </div>
        <div id="login">
          <button type="button" id="btn2" >登录</button>
        </div>
      </form>
    </div>
     <!-- 导师登录结束-->
     <!-- 教务登录开始-->
    <div class="hide">
    <div class="sec_error_box"></div>
      <form action=""  class="sec_login_error" id="form3">
        <div >
          <span>管理员：</span>
          <input type="text" name="adminname" placeholder="请输入管理员账号" id="adminname"/>
          <!--ajaxurl="demo/valid.jsp"-->
        </div>
        <div >
          <span>密&nbsp;&nbsp;&nbsp;码：</span>
          <input type="password" name="adminpassword" placeholder="请输入密码" id="adminpassword"/>
        </div>
        <div id="code">
          <span>验证码：</span>
          <input type="text" id="admincode" name="code" placeholder="验证码"/>
          <img alt="验证按" title="点击更换" style="cursor: pointer"  src="../Kaptcha" ></div>
        <div>
          <span>还没有账号，<a href="register.html">注册</a></span>
        </div>
        <div id="login">
          <button type="button" id="btn3" >登录</button>
        </div>
      </form>
    </div>
     <!-- 教务登录结束-->
  </div>
</div>

<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="images/0.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/1.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/2.jpg"></a></li>
  </ul>
</div>
</body>
</html>