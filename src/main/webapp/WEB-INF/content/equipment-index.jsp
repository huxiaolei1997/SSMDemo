<%--
  Created by IntelliJ IDEA.
  User: Mystery
  Date: 2018/7/7
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@taglib prefix="s" uri="/struts-tags" %>--%>
<%--<#--这一句是为了让Freemarker识别struts2的标签 -->--%>
<%--<#--<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />-->--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设备列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="/SSMDemo/static/css/pagination.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <table class="table" style="border: 1px solid #ddd;">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>设备ID</th>
                    <th>描述</th>
                    <th>功能<a class="btn btn-danger batch-delete-equipment" href="javascript:;">删除</a>
                        <a class="btn btn-success" href="equipment/new">添加设备</a></th>
                </tr>
                </thead>
                <tbody>
                <%--<s:iterator value="model">--%>
                    <%--<tr>--%>
                        <%--<td><input type="checkbox" class="checkbox-equipment-id" style="width: 15px;" value="${model.id}"></td>--%>
                        <%--<td>${model.id}</td>--%>
                        <%--<td>${model.code}</td>--%>
                        <%--<td>${model.desc}</td>--%>
                        <%--<td><a class="btn btn-primary" href="javascript:location.href='equipment/${model.id}/edit';">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-danger" href="javascript:location.href='deleteEquipmentById?equipment_id=${model.id}';">删除</a></td>--%>
                    <%--</tr>--%>
                <%--</s:iterator>--%>
                    <c:forEach items="${equipmentPager.dataList}" var="model">
                        <tr>
                            <td><input type="checkbox" class="checkbox-equipment-id" style="width: 15px;" value="${model.id}"></td>
                            <td>${model.id}</td>
                            <td>${model.code}</td>
                            <td>${model.desc}</td>
                            <td><a class="btn btn-primary" href="javascript:location.href='equipment/${model.id}/edit';">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-danger" href="javascript:location.href='equipment/${model.id}/deleteConfirm';">删除</a></td>
                        </tr>
                    </c:forEach>
                <%--<c:set var="name" value="test"/>--%>
                <%--${name}--%>
            </tbody>
            </table>
        </div>
        <div class="col-lg-6 col-lg-offset-3">
            <div class="m-style M-box"></div>
            <div>
                <form id="pager" method="GET" action="equipment">
                    <input type="hidden" id="current_page" name="current_page" value="1"/>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="/SSMDemo/static/js/jquery.pagination.js"></script>
<script type="text/javascript">
    $(function() {
        $('.M-box').pagination({
            pageCount: ${equipmentPager.total_page},
            current: ${equipmentPager.current_page},
            callback: function (api) {
                // 当前页号
                var current_page = api.getCurrent();
                $("#pager").attr("action", "equipment");
                $("#current_page").val(current_page);
                console.log(current_page);
                $("#pager").submit();
            }
        });
    });
</script>
</body>
</html>