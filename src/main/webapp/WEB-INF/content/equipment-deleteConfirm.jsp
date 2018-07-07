<%--
  Created by IntelliJ IDEA.
  User: Mystery
  Date: 2018/7/7
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <div class="page-header">
                <h1>Delete Equipment ${id}</h1>
            </div>

            <form action="../${id}?_method=DELETE" method="post">
                <p>
                    Are you sure you want to delete equipment ${id}?
                </p>
                <div class="btn-group">
                    <input type="submit" value="Delete" class="btn btn-danger" />
                    <input type="button" value="Cancel" class="btn btn-success" onclick="window.location.href = '/SSMDemo/equipment'" />
                </div>
            </form>
            <br />
            <a href="/SSMDemo/equipment" class="btn btn-info">
                <span class="glyphicon glyphicon-arrow-left"></span> Back to Equipment list.
            </a>
        </div><!--/col-md-12--->
    </div><!--/row-->
</div><!--/container-->
</body>
</html>
