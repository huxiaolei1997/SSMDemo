<#--这一句是为了让Freemarker识别struts2的标签 -->
<#--<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设备列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
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
                    <th>功能</th>
                </tr>
                </thead>
                <tbody>
                    <#if equipmentList ??>
                         <#list equipmentList as equipment>
                             <tr>
                                 <td><input type="checkbox"></td>
                                 <td>${equipment.id}</td>
                                 <td>${equipment.code}</td>
                                 <td>${equipment.desc}</td>
                                 <td><a class="btn btn-primary" href="javascript:location.href='updateEquipment?equipment_id=${equipment.id}';">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-danger" href="javascript:;">删除</a></td>
                             </tr>
                         </#list>
                    </#if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
