<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>天亮OA系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/xadmin.css">
<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/theme5.css"> -->
<script src="<%=request.getContextPath()%>/resources/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/xadmin.js"></script>
</head>
<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.html">天亮OA系统</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>
		<ul class="layui-nav left fast-add" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">+新增</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
							<i class="iconfont">&#xe6a2;</i>弹出最大化
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')"> <i
							class="iconfont">&#xe6a8;</i>弹出自动宽高
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
							<i class="iconfont">&#xe6a8;</i>弹出指定宽高
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.add_tab('在tab打开','member-list.html')"> <i
							class="iconfont">&#xe6b8;</i>在tab打开
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
							<i class="iconfont">&#xe6b8;</i>在tab打开刷新
						</a>
					</dd>
				</dl></li>
		</ul>
		<!--公告展示  -->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

<style>
.book_class {
	/* 	绝对定位 */
	position: absolute;
	left: 30%;
	/* 	文字水平居中 */
	text-align: center;
	/* 	字体白色 */
	width: 50%;
	color: #fff;
	/* 	行高45px,和高度一样,这样文字就能默认垂直居中  */
	line-height: 45px;
	height: 45px;
	/* 	超出隐藏 */
	overflow: hidden;
}
</style>
		<script>
			$(function() {
				/**
					Ajax加载公告数据
				 */
				$.post("announcement/ann", function(obj) {
					for (var i = 0; i < obj.length; i++) {
						console.log(obj[i]);
						 $("#express").append(
								"<li>【公告】" + obj[i].messtype.type + ":"
										+ obj[i].content + "</li>"); 
					}
				});
				/**
					滚动字,确保设置了绝对定位
				 */
				// 距上距离
				var top = 0;
				// 创建定时器
				var t = setInterval(start, 50);

				// 开始滚动
				function start() {
					//先设置margin-top为0
					$("#express li:first").css("margin-top", top);
					//ul的高度为25，故这里以25判断第一行是否走出ul。
					if (top < -45) {
						//如果第一行已经走出ul，将top归零，为下个li做准备
						top = 0;
						//这句话的意思是，先将首行的top设为0，拷贝该行，放置最后一行
						//注意，如果这里不将第一行的top归零，拷贝后他将保持top=-45的状态，效果就是叠加在最后一行上。
						$("#express li:first").css("margin-top", top).clone(
								true).appendTo('#express');
						//移除首行，这时第二行变为首行
						$("#express li:first").remove();
					} else {
						//如果第一行还未走出ul，top自减
						top -= 1;
					}
				}
				/**
					当鼠标放置后停止，松开继续走
				 */

				$("#express").delegate('li', 'mousemove', function() {
					// 鼠标移入 清除定时
					clearInterval(t);
				});
				$("#express").delegate('li', 'mouseout', function() {
					// 鼠标移出 设置定时器
					t = setInterval(start, 50);
				});
			});
		</script>

		<div class="book_class">
			<ul id="express">
			</ul>
		</div>





















		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${loginUser.name }</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="xadmin.open('个人信息','index')">个人信息</a>
					</dd>

					<dd>
						<a href="logout">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="index">前台首页</a></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<c:forEach items="${sidebarSups }" var="sidebarSup">
					<li><a href="javascript:;"> <i
							class="iconfont left-nav-li" lay-tips="${sidebarSup.name }">&#xe6b8;</i>
							<cite>${sidebarSup.name }</cite> <i class="iconfont nav_right">&#xe697;</i></a>

						<ul class="sub-menu">
							<c:forEach items="${sidebarSup.sidebarSubs }" var="sidebarSub">
								<li><a
									onclick="xadmin.add_tab('${sidebarSub.name}','${sidebarSub.uri }')">
										<i class="iconfont">&#xe6a7;</i> <cite>${sidebarSub.name }</cite>
								</a></li>
							</c:forEach>
						</ul></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='welcome' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<style id="theme_style"></style>

</body>

</html>
