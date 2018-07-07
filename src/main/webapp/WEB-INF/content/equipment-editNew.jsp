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
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <form role="form" method="post" action="../equipment">
                <div class="form-group">
                    <label>设备ID</label>
                    <input type="text" class="form-control" name="model.code"
                           value="">
                </div>
                <div class="form-group">
                    <label>设备描述</label>
                    <textarea class="form-control" id="desc" name="model.desc"></textarea>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
