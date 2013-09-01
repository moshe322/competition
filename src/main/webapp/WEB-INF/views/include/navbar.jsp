<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="navbar">
    <div class="navbar-inner">
      <ul class="nav pull-right">
        <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
        <li id="fat-menu" class="dropdown"><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
            <i class="icon-user"></i>${sessionScope.account.username}<i class="icon-caret-down"></i>
        </a>
          <ul class="dropdown-menu">
            <li><a tabindex="-1" href="#">我的账号</a></li>
            <li class="divider"></li>
            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
            <li class="divider visible-phone"></li>
            <li><a tabindex="-1" href="${pageContext.request.contextPath}/home/logout">退出</a></li>
          </ul></li>
      </ul>
      <a class="brand" href="index.html"><span class="first">Competition</span> <span class="second">后台管理系统</span></a>
    </div>
  </div>