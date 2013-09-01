<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>账号管理</title>
<%@ include file="../include/head.jsp"%>
<body class="">
  <!--<![endif]-->
  <%@ include file="../include/navbar.jsp"%>
  <%@ include file="../include/sidebar.jsp"%>
  <div class="content">
    <div class="header">
      <h1 class="page-title">Users</h1>
    </div>
    <ul class="breadcrumb">
      <li><a href="home">Home</a> <span class="divider">/</span></li>
      <li class="active">Users</li>
    </ul>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="btn-toolbar">
          <button class="btn btn-primary">
            <i class="icon-plus"></i> New User
          </button>
          <button class="btn">Import</button>
          <button class="btn">Export</button>
          <div class="btn-group"></div>
        </div>
        <div class="well">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>DisplayName</th>
                <th>Username</th>
                <th style="width: 26px;"></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${users.content}" var="user">
                <tr>
                  <td>${user.id}</td>
                  <td>${user.displayName}</td>
                  <td>${user.username}</td>
                  <td><a href="user.html"><i class="icon-pencil"></i></a> <a href="#myModal" role="button"
                  data-toggle="modal"><i class="icon-remove"></i></a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="pagination">
          <ul>
            <c:if test="${users.hasPreviousPage()}">
              <li><a href="users?page.page=${users.number}&page.size=${users.size}">前一页</a></li>
            </c:if>
            <li><a href="users?page.page=${users.number + 1}&page.size=${users.size}"">${users.number + 1}</a></li>
            <c:if test="${(users.number + 1) < users.totalPages}">
              <li><a href="users?page.page=${users.number + 2}&page.size=${users.size}"">${users.number + 2}</a></li>
            </c:if>
            <c:if test="${(users.number + 2) < users.totalPages}">
              <li><a href="users?page.page=${users.number + 3}&page.size=${users.size}"">${users.number + 3}</a></li>
            </c:if>
            <c:if test="${(users.number + 3) < users.totalPages}">
              <li><a href="users?page.page=${users.number + 4}&page.size=${users.size}"">${users.number + 4}</a></li>
            </c:if>
            <c:if test="${users.hasNextPage()}">
              <li><a href="users?page.page=${users.number + 2}&page.size=${users.size}">下一页</a></li>
            </c:if>
          </ul>
        </div>
        <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
          aria-hidden="true">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Delete Confirmation</h3>
          </div>
          <div class="modal-body">
            <p class="error-text">
              <i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?
            </p>
          </div>
          <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
            <button class="btn btn-danger" data-dismiss="modal">Delete</button>
          </div>
        </div>
        <footer>
          <hr>
          <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
          <p class="pull-right">
            A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a
              href="http://www.portnine.com" target="_blank">Portnine</a>
          </p>
          <p>
            &copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a>
          </p>
        </footer>
      </div>
    </div>
  </div>
  <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>
